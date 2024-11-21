package Grammar;

import Grammar.SkyLoadLexer;
import Grammar.SkyLoadParser;
import Runtime.SkyLoadEvaluator; // Import the evaluator
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class SkyLoadMain {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: SkyLoadMain <file>");
            return;
        }

        String sourceFile = args[0];
        try {
            // Step 1: Create a lexer from the input file
            SkyLoadLexer lexer = new SkyLoadLexer(CharStreams.fromFileName(sourceFile));
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            // Step 2: Create a parser from the token stream
            SkyLoadParser parser = new SkyLoadParser(tokens);

            // Step 3: Generate a parse tree starting from the 'program' rule
            ParseTree tree = parser.program();

            // Step 4: Pass the parse tree to the evaluator
            SkyLoadEvaluator evaluator = new SkyLoadEvaluator();
            evaluator.visit(tree); // This evaluates and executes the parsed program

            System.out.println("Execution completed successfully.");
        } catch (IOException e) {
            System.err.println("Error reading source file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error during execution: " + e.getMessage());
        }
    }
}
