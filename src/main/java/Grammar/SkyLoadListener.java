// Generated from C:/Users/Acer/IdeaProjects/SKYLOAD/src/main/java/Grammar/SkyLoad.g4 by ANTLR 4.13.2
package Grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SkyLoadParser}.
 */
public interface SkyLoadListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SkyLoadParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(SkyLoadParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link SkyLoadParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(SkyLoadParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link SkyLoadParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(SkyLoadParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SkyLoadParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(SkyLoadParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SkyLoadParser#declareVar}.
	 * @param ctx the parse tree
	 */
	void enterDeclareVar(SkyLoadParser.DeclareVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link SkyLoadParser#declareVar}.
	 * @param ctx the parse tree
	 */
	void exitDeclareVar(SkyLoadParser.DeclareVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link SkyLoadParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(SkyLoadParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SkyLoadParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(SkyLoadParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SkyLoadParser#decision}.
	 * @param ctx the parse tree
	 */
	void enterDecision(SkyLoadParser.DecisionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SkyLoadParser#decision}.
	 * @param ctx the parse tree
	 */
	void exitDecision(SkyLoadParser.DecisionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SkyLoadParser#ternary}.
	 * @param ctx the parse tree
	 */
	void enterTernary(SkyLoadParser.TernaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SkyLoadParser#ternary}.
	 * @param ctx the parse tree
	 */
	void exitTernary(SkyLoadParser.TernaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SkyLoadParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(SkyLoadParser.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link SkyLoadParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(SkyLoadParser.ForLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link SkyLoadParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(SkyLoadParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link SkyLoadParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(SkyLoadParser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link SkyLoadParser#showStatement}.
	 * @param ctx the parse tree
	 */
	void enterShowStatement(SkyLoadParser.ShowStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SkyLoadParser#showStatement}.
	 * @param ctx the parse tree
	 */
	void exitShowStatement(SkyLoadParser.ShowStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SkyLoadParser#loopControlStatement}.
	 * @param ctx the parse tree
	 */
	void enterLoopControlStatement(SkyLoadParser.LoopControlStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SkyLoadParser#loopControlStatement}.
	 * @param ctx the parse tree
	 */
	void exitLoopControlStatement(SkyLoadParser.LoopControlStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SkyLoadParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(SkyLoadParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SkyLoadParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(SkyLoadParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SkyLoadParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SkyLoadParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SkyLoadParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SkyLoadParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SkyLoadParser#additionExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditionExpression(SkyLoadParser.AdditionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SkyLoadParser#additionExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditionExpression(SkyLoadParser.AdditionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SkyLoadParser#multiplicationExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicationExpression(SkyLoadParser.MultiplicationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SkyLoadParser#multiplicationExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicationExpression(SkyLoadParser.MultiplicationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SkyLoadParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpression(SkyLoadParser.PrimaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SkyLoadParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpression(SkyLoadParser.PrimaryExpressionContext ctx);
}