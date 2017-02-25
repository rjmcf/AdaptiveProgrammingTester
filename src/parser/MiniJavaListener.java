// Generated from MiniJava.g4 by ANTLR 4.5.3
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniJavaParser}.
 */
public interface MiniJavaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MiniJavaParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MiniJavaParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(MiniJavaParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(MiniJavaParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclaration(MiniJavaParser.LocalVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclaration(MiniJavaParser.LocalVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MiniJavaParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MiniJavaParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#forControl}.
	 * @param ctx the parse tree
	 */
	void enterForControl(MiniJavaParser.ForControlContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#forControl}.
	 * @param ctx the parse tree
	 */
	void exitForControl(MiniJavaParser.ForControlContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(MiniJavaParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(MiniJavaParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void enterForUpdate(MiniJavaParser.ForUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void exitForUpdate(MiniJavaParser.ForUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#parExpression}.
	 * @param ctx the parse tree
	 */
	void enterParExpression(MiniJavaParser.ParExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#parExpression}.
	 * @param ctx the parse tree
	 */
	void exitParExpression(MiniJavaParser.ParExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(MiniJavaParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(MiniJavaParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpression(MiniJavaParser.StatementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpression(MiniJavaParser.StatementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MiniJavaParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MiniJavaParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#variableDeclarators}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarators(MiniJavaParser.VariableDeclaratorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#variableDeclarators}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarators(MiniJavaParser.VariableDeclaratorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarator(MiniJavaParser.VariableDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarator(MiniJavaParser.VariableDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitializer(MiniJavaParser.VariableInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitializer(MiniJavaParser.VariableInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#arrayInitializerValues}.
	 * @param ctx the parse tree
	 */
	void enterArrayInitializerValues(MiniJavaParser.ArrayInitializerValuesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#arrayInitializerValues}.
	 * @param ctx the parse tree
	 */
	void exitArrayInitializerValues(MiniJavaParser.ArrayInitializerValuesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#arrayInitializerSize}.
	 * @param ctx the parse tree
	 */
	void enterArrayInitializerSize(MiniJavaParser.ArrayInitializerSizeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#arrayInitializerSize}.
	 * @param ctx the parse tree
	 */
	void exitArrayInitializerSize(MiniJavaParser.ArrayInitializerSizeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#typeType}.
	 * @param ctx the parse tree
	 */
	void enterTypeType(MiniJavaParser.TypeTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#typeType}.
	 * @param ctx the parse tree
	 */
	void exitTypeType(MiniJavaParser.TypeTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(MiniJavaParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(MiniJavaParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(MiniJavaParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(MiniJavaParser.LiteralContext ctx);
}