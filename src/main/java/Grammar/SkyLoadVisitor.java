// Generated from C:/Users/Acer/IdeaProjects/SKYLOAD/src/main/java/Grammar/SkyLoad.g4 by ANTLR 4.13.2
package Grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SkyLoadParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SkyLoadVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SkyLoadParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(SkyLoadParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link SkyLoadParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction(SkyLoadParser.InstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SkyLoadParser#declareVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareVar(SkyLoadParser.DeclareVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link SkyLoadParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(SkyLoadParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SkyLoadParser#decision}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecision(SkyLoadParser.DecisionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SkyLoadParser#ternary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernary(SkyLoadParser.TernaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SkyLoadParser#forLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoop(SkyLoadParser.ForLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link SkyLoadParser#whileLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(SkyLoadParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link SkyLoadParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowStatement(SkyLoadParser.ShowStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SkyLoadParser#loopControlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopControlStatement(SkyLoadParser.LoopControlStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SkyLoadParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(SkyLoadParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SkyLoadParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(SkyLoadParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SkyLoadParser#additionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionExpression(SkyLoadParser.AdditionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SkyLoadParser#multiplicationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationExpression(SkyLoadParser.MultiplicationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SkyLoadParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpression(SkyLoadParser.PrimaryExpressionContext ctx);
}