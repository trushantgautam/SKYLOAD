package Runtime;
import Grammar.SkyLoadBaseVisitor;
import Grammar.SkyLoadParser;

public class SkyLoadEvaluator extends SkyLoadBaseVisitor<Object> {
    private final SkyLoadRuntime runtime;
    private boolean breakFlag = false;      // To handle 'cut' (break)
    private boolean continueFlag = false;

    public SkyLoadEvaluator() {
        this.runtime = new SkyLoadRuntime();
    }

    @Override
    public Object visitProgram(SkyLoadParser.ProgramContext ctx) {
        for (SkyLoadParser.InstructionContext instruction : ctx.instruction()) {
            visit(instruction);
            if (breakFlag || continueFlag) break; // Stop execution if 'cut' or 'skip' is triggered
        }
        return null;
    }

    @Override
    public Object visitDeclareVar(SkyLoadParser.DeclareVarContext ctx) {
        String varName = ctx.ID().getText();
        Object value = null;
        if (ctx.expression() != null) {
            value = visit(ctx.expression());
        } else if (ctx.ternary() != null) {
            value = visit(ctx.ternary());
        } else if (ctx.condition() != null) {
            value = visit(ctx.condition());
        }
        runtime.defineVariable(varName, value);
        return null;
    }

    @Override
    public Object visitAssignment(SkyLoadParser.AssignmentContext ctx) {
        String varName = ctx.ID().getText();
        Object value = visit(ctx.expression());
        runtime.assignVariable(varName, value);
        return null;
    }

    @Override
    public Object visitDecision(SkyLoadParser.DecisionContext ctx) {
        // Evaluate the condition
        boolean condition = (boolean) visit(ctx.condition());

        // If condition is true, execute instructions before 'otherwise'
        if (condition) {
            // Execute only instructions before 'otherwise'
            int alternativeIndex = ctx.ALTERNATIVE() != null ? ctx.ALTERNATIVE().getSymbol().getTokenIndex() : -1;
            for (SkyLoadParser.InstructionContext instruction : ctx.instruction()) {
                // Stop if we encounter 'otherwise'
                if (instruction.getStart().getTokenIndex() >= alternativeIndex && alternativeIndex != -1) {
                    break;
                }
                visit(instruction);
            }
        }
        // If condition is false and 'otherwise' exists, execute 'otherwise' block
        else if (ctx.ALTERNATIVE() != null) {
            boolean foundAlternative = false;
            for (SkyLoadParser.InstructionContext instruction : ctx.instruction()) {
                // Skip instructions until we find 'otherwise'
                if (!foundAlternative && instruction.getStart().getTokenIndex() >= ctx.ALTERNATIVE().getSymbol().getTokenIndex()) {
                    foundAlternative = true;
                }
                if (foundAlternative) {
                    visit(instruction);
                }
            }
        }

        return null;
    }

    @Override
    public Object visitTernary(SkyLoadParser.TernaryContext ctx) {
        // Evaluate the condition
        Object conditionResult = visit(ctx.condition());
        if (!(conditionResult instanceof Boolean)) {
            throw new RuntimeException("The condition in the ternary operator must evaluate to a boolean.");
        }
        boolean condition = (Boolean) conditionResult;

        // Evaluate the true and false expressions
        Object trueExpressionResult = visit(ctx.expression(0));
        Object falseExpressionResult = visit(ctx.expression(1));

        // Return the result based on the condition
        return condition ? trueExpressionResult : falseExpressionResult;
    }

    @Override
    public Object visitForLoop(SkyLoadParser.ForLoopContext ctx) {
        visit(ctx.assignment(0));  // Initialize loop variable
        while ((boolean) visit(ctx.condition())) {  // Condition check
            for (SkyLoadParser.InstructionContext instruction : ctx.instruction()) {
                visit(instruction);
                if (breakFlag) {   // Break out of the loop
                    breakFlag = false;
                    return null;
                }
                if (continueFlag) {  // Skip to next iteration of the loop
                    continueFlag = false;
                    break;
                }
            }
            visit(ctx.assignment(1));  // Update loop variable after each iteration
        }
        return null;
    }

    @Override
    public Object visitWhileLoop(SkyLoadParser.WhileLoopContext ctx) {

        while ((boolean) visit(ctx.condition())) {  // Condition check
            for (SkyLoadParser.InstructionContext instruction : ctx.instruction()) {
                visit(instruction);

                if (breakFlag) {   // Break out of the loop
                    breakFlag = false;
                    return null;
                }

                if (continueFlag) {  // Skip to next iteration of the loop
                    continueFlag = false;
                    break;
                }
            }
        }
        return null;
    }

    @Override
    public Object visitShowStatement(SkyLoadParser.ShowStatementContext ctx) {

        boolean newline = ctx.SHOW_NEWLINE() != null;  // Check if it's a `show_nl` command
        StringBuilder output = new StringBuilder();
        // Collect all expressions to be printed.
        for (SkyLoadParser.ExpressionContext exprCtx: ctx.expression()) {
            Object value = visit(exprCtx);
            if (value instanceof Boolean) {
                value = (Boolean) value ? "yes" : "no";
            }
            output.append(value.toString());  // Separate values with space.
        }
        // Trim the final output to remove extra space.
        String result = output.toString();
        // Print based on whether it's a `show_nl` or default `show`.
        if (newline) {
            runtime.show_nl(result);  // Print with an explicit newline.
        } else {
            runtime.show(result);  // Default print with newline.
        }
        return null;
    }

    @Override
    public Object visitLoopControlStatement(SkyLoadParser.LoopControlStatementContext ctx) {
        if(ctx.BREAK() != null){
            breakFlag = true;  // Set the flag to indicate a 'cut' statement was encountered.
        } else if(ctx.CONTINUE() != null){
            continueFlag = true;  // Set the flag to indicate a 'skip' statement was encountered.
        }
        return null;
    }
    @Override
    public Object visitCondition(SkyLoadParser.ConditionContext ctx) {
        // Handle NOT condition
        if (ctx.NOT() != null) {
            boolean value = (boolean) visit(ctx.condition(0));
            return runtime.negate(value);
        }
        // Handle condition AND condition
        if (ctx.AND() != null) {
            boolean left = (boolean) visit(ctx.condition(0));
            boolean right = (boolean) visit(ctx.condition(1));
            return runtime.evaluateBoolean(left, "and", right);
        }
        // Handle condition OR condition
        if (ctx.OR() != null) {
            boolean left = (boolean) visit(ctx.condition(0));
            boolean right = (boolean) visit(ctx.condition(1));
            return runtime.evaluateBoolean(left, "or", right);
        }
        // Handle parenthesized condition
        if (ctx.LPAREN() != null) {
            return visit(ctx.condition(0));
        }
        // Handle comparison between two expressions
        if (ctx.expression().size() == 2) {
            Object left = visit(ctx.expression(0));
            Object right = visit(ctx.expression(1));

            String operator = null;
            if (ctx.LESS_THAN() != null) {
                operator = "<";
            } else if (ctx.LESS_EQUAL() != null) {
                operator = "<=";
            } else if (ctx.GREATER_THAN() != null) {
                operator = ">";
            } else if (ctx.GREATER_EQUAL() != null) {
                operator = ">=";
            } else if (ctx.EQUALS() != null) {
                operator = "is";
            } else if (ctx.NOT_EQUALS() != null) {
                operator = "!=";
            } else {
                throw new RuntimeException("Unknown comparison operator in condition.");
            }

            return runtime.evaluateRelational(left, operator, right);
        }
        // Handle YES and NO literals
        if (ctx.YES() != null) {
            return true;
        }
        if (ctx.NO() != null) {
            return false;
        }
        throw new RuntimeException("Unsupported condition: " + ctx.getText());
    }
    @Override
    public Object visitExpression(SkyLoadParser.ExpressionContext ctx) {
        return visit(ctx.additionExpression());
    }

    @Override
    public Object visitAdditionExpression(SkyLoadParser.AdditionExpressionContext ctx) {
        if (ctx.additionExpression() != null) {
            Object left = visit(ctx.additionExpression());
            Object right = visit(ctx.multiplicationExpression());
            String operator = ctx.getChild(1).getText();
            return runtime.evaluateArithmetic(left, operator, right);
        }
        return visit(ctx.multiplicationExpression());
    }

    @Override
    public Object visitMultiplicationExpression(SkyLoadParser.MultiplicationExpressionContext ctx) {
        if (ctx.multiplicationExpression() != null) {
            Object left = visit(ctx.multiplicationExpression());
            Object right = visit(ctx.primaryExpression());
            String operator = ctx.getChild(1).getText();
            return runtime.evaluateArithmetic(left, operator, right);
        }
        return visit(ctx.primaryExpression());
    }
    @Override
    public Object visitPrimaryExpression(SkyLoadParser.PrimaryExpressionContext ctx) {

        if (ctx.YES() != null) {
            return true; // Map 'yes' to true
        }
        if (ctx.NO() != null) {
            return false; // Map 'no' to false
        }
        if (ctx.YES() != null) {
            return true; // 'yes' maps to true
        }
        if (ctx.NO() != null) {
            return false; // 'no' maps to false
        }
        if (ctx.INT() != null) {
            return Integer.parseInt(ctx.INT().getText());
        }
        if (ctx.STRING() != null) {
            return ctx.STRING().getText().replace("\"", ""); // Strip quotes
        }
        if (ctx.ID() != null) {
            return runtime.getVariable(ctx.ID().getText()); // Fetch variable value
        }
        if (ctx.LPAREN() != null && ctx.RPAREN() != null) {
            return visit(ctx.expression()); // Evaluate parenthesized expression
        }
        throw new RuntimeException("Unsupported primary expression: " + ctx.getText());
    }
}
