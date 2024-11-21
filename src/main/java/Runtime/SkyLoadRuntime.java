package Runtime;

import java.util.HashMap;
import java.util.Map;

public class SkyLoadRuntime {
    private final Map<String, Object> variables;

    public SkyLoadRuntime() {
        this.variables = new HashMap<>();
    }

    // Define a variable
    public void defineVariable(String name, Object value) {
        if (variables.containsKey(name)) {
            throw new RuntimeException("Variable '" + name + "' is already defined.");
        }
        variables.put(name, value);
    }

    // Assign value to an existing variable
    public void assignVariable(String name, Object value) {
        if (!variables.containsKey(name)) {
            throw new RuntimeException("Variable '" + name + "' is not defined.");
        }
        variables.put(name, value);
    }

    // Retrieve the value of a variable
    public Object getVariable(String name) {
        if (!variables.containsKey(name)) {
            throw new RuntimeException("Variable '" + name + "' is not defined.");
        }
        return variables.get(name);
    }

    // Print a value
    public void show(Object value) {
        System.out.print(value);
    }
    public void show_nl(Object value)
    {
        System.out.print(value);  // Print without moving to the next line...
        System.out.println();     // ...then move to the next line explicitly.
    }

    // Evaluate arithmetic expressions
    public Object evaluateArithmetic(Object left, String operator, Object right) {
        if (left instanceof Integer && right instanceof Integer) {
            int l = (Integer) left;
            int r = (Integer) right;

            return switch (operator) {
                case "+" -> l + r;
                case "-" -> l - r;
                case "*" -> l * r;
                case "/" -> {
                    if (r == 0) throw new RuntimeException("Division by zero.");
                    yield l / r;
                }
                case "%" -> l % r;
                default -> throw new RuntimeException("Unknown operator: " + operator);
            };
        }
        else if (left instanceof String && right instanceof String) {
            String l = (String) left;
            String r = (String) right;

            return switch (operator) {
                case "+" -> l + r; // Concatenate two strings
                default -> throw new RuntimeException("Operator '" + operator + "' is not supported for strings.");
            };
        }
        // Type mismatch
        else {
            throw new RuntimeException("Relational operations are only supported for matching types (both integers or both strings).");
        }
    }

    // Evaluate relational expressions
    public boolean evaluateRelational(Object left, String operator, Object right) {
        if (left instanceof Boolean && right instanceof Boolean) {
            boolean l = (Boolean) left;
            boolean r = (Boolean) right;

            return switch (operator) {
                case "is" -> l == r;
                case "!=" -> l != r;
                default -> throw new RuntimeException("Unknown operator for booleans: " + operator);
            };
        }
        // Handle integer comparison
        else if (left instanceof Integer && right instanceof Integer) {
            int l = (Integer) left;
            int r = (Integer) right;

            return switch (operator) {
                case "<" -> l < r;
                case "<=" -> l <= r;
                case ">" -> l > r;
                case ">=" -> l >= r;
                case "is" -> l == r;
                case "!=" -> l != r;
                default -> throw new RuntimeException("Unknown operator: " + operator);
            };
        }
        // Handle string comparisons
        else if (left instanceof String && right instanceof String) {
            String l = (String) left;
            String r = (String) right;

            return switch (operator) {
                case "is" -> l.equals(r); // Check if strings are equal
                case "!=" -> !l.equals(r); // Check if strings are not equal
                default -> throw new RuntimeException("Operator '" + operator + "' is not supported for strings.");
            };
        }
        // Type mismatch
        else {
            throw new RuntimeException("Relational operations are only supported for matching types (both integers or both strings).");
        }
    }

    // Evaluate boolean logic
    public boolean evaluateBoolean(boolean left, String operator, boolean right) {
        return switch (operator) {
            case "and" -> left && right;
            case "or" -> left || right;
            default -> throw new RuntimeException("Unknown boolean operator: " + operator);
        };
    }

    public boolean negate(boolean value) {
        return !value;
    }
}
