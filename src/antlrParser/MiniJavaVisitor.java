// Generated from MiniJava.g4 by ANTLR 4.5.3
package antlrParser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MiniJavaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MiniJavaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code blockEntry}
	 * labeled alternative in {@link MiniJavaParser#entry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockEntry(MiniJavaParser.BlockEntryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockStatementsEntry}
	 * labeled alternative in {@link MiniJavaParser#entry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatementsEntry(MiniJavaParser.BlockStatementsEntryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementEntry}
	 * labeled alternative in {@link MiniJavaParser#entry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementEntry(MiniJavaParser.StatementEntryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionEntry}
	 * labeled alternative in {@link MiniJavaParser#entry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionEntry(MiniJavaParser.ExpressionEntryContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MiniJavaParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code localVariableDeclaration}
	 * labeled alternative in {@link MiniJavaParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclaration(MiniJavaParser.LocalVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code makeStmnt}
	 * labeled alternative in {@link MiniJavaParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMakeStmnt(MiniJavaParser.MakeStmntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code makeVarDec}
	 * labeled alternative in {@link MiniJavaParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMakeVarDec(MiniJavaParser.MakeVarDecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmnt}
	 * labeled alternative in {@link MiniJavaParser#statementTop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmnt(MiniJavaParser.StmntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmntNSI}
	 * labeled alternative in {@link MiniJavaParser#statementTop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmntNSI(MiniJavaParser.StmntNSIContext ctx);
	/**
	 * Visit a parse tree produced by the {@code makeBlock}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMakeBlock(MiniJavaParser.MakeBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code makeIf}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMakeIf(MiniJavaParser.MakeIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code makeITE}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMakeITE(MiniJavaParser.MakeITEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code makeFor}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMakeFor(MiniJavaParser.MakeForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code makeWhile}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMakeWhile(MiniJavaParser.MakeWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code makeStatementNTS}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMakeStatementNTS(MiniJavaParser.MakeStatementNTSContext ctx);
	/**
	 * Visit a parse tree produced by the {@code makeBlockNSI}
	 * labeled alternative in {@link MiniJavaParser#statementNSI}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMakeBlockNSI(MiniJavaParser.MakeBlockNSIContext ctx);
	/**
	 * Visit a parse tree produced by the {@code makeITENSI}
	 * labeled alternative in {@link MiniJavaParser#statementNSI}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMakeITENSI(MiniJavaParser.MakeITENSIContext ctx);
	/**
	 * Visit a parse tree produced by the {@code makeForNSI}
	 * labeled alternative in {@link MiniJavaParser#statementNSI}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMakeForNSI(MiniJavaParser.MakeForNSIContext ctx);
	/**
	 * Visit a parse tree produced by the {@code makeWhileNSI}
	 * labeled alternative in {@link MiniJavaParser#statementNSI}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMakeWhileNSI(MiniJavaParser.MakeWhileNSIContext ctx);
	/**
	 * Visit a parse tree produced by the {@code makeStatementNTSNSI}
	 * labeled alternative in {@link MiniJavaParser#statementNSI}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMakeStatementNTSNSI(MiniJavaParser.MakeStatementNTSNSIContext ctx);
	/**
	 * Visit a parse tree produced by the {@code makeDo}
	 * labeled alternative in {@link MiniJavaParser#statementNTS}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMakeDo(MiniJavaParser.MakeDoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code return}
	 * labeled alternative in {@link MiniJavaParser#statementNTS}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(MiniJavaParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code break}
	 * labeled alternative in {@link MiniJavaParser#statementNTS}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreak(MiniJavaParser.BreakContext ctx);
	/**
	 * Visit a parse tree produced by the {@code continue}
	 * labeled alternative in {@link MiniJavaParser#statementNTS}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinue(MiniJavaParser.ContinueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code empty}
	 * labeled alternative in {@link MiniJavaParser#statementNTS}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmpty(MiniJavaParser.EmptyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code makeStmntExpr}
	 * labeled alternative in {@link MiniJavaParser#statementNTS}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMakeStmntExpr(MiniJavaParser.MakeStmntExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code makePrint}
	 * labeled alternative in {@link MiniJavaParser#statementNTS}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMakePrint(MiniJavaParser.MakePrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forInitLVD}
	 * labeled alternative in {@link MiniJavaParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInitLVD(MiniJavaParser.ForInitLVDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forInitExprs}
	 * labeled alternative in {@link MiniJavaParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInitExprs(MiniJavaParser.ForInitExprsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#parExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpression(MiniJavaParser.ParExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(MiniJavaParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(MiniJavaParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code makeID}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMakeID(MiniJavaParser.MakeIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code preIncEtc}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreIncEtc(MiniJavaParser.PreIncEtcContext ctx);
	/**
	 * Visit a parse tree produced by the {@code makeNot}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMakeNot(MiniJavaParser.MakeNotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condExpr}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondExpr(MiniJavaParser.CondExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(MiniJavaParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relationalExpr}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpr(MiniJavaParser.RelationalExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code makeBracketed}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMakeBracketed(MiniJavaParser.MakeBracketedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultExpr(MiniJavaParser.MultExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code postInc}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostInc(MiniJavaParser.PostIncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqExpr}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExpr(MiniJavaParser.EqExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(MiniJavaParser.AddExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayAccess}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess(MiniJavaParser.ArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code makeLiteral}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMakeLiteral(MiniJavaParser.MakeLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpr(MiniJavaParser.AssignExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(MiniJavaParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#variableDeclarators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarators(MiniJavaParser.VariableDeclaratorsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayVarDec}
	 * labeled alternative in {@link MiniJavaParser#variableDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayVarDec(MiniJavaParser.ArrayVarDecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleVarDec}
	 * labeled alternative in {@link MiniJavaParser#variableDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleVarDec(MiniJavaParser.SingleVarDecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayInitVals}
	 * labeled alternative in {@link MiniJavaParser#variableInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInitVals(MiniJavaParser.ArrayInitValsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayInitSize}
	 * labeled alternative in {@link MiniJavaParser#variableInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInitSize(MiniJavaParser.ArrayInitSizeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code initExpr}
	 * labeled alternative in {@link MiniJavaParser#variableInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitExpr(MiniJavaParser.InitExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#arrayInitializerValues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInitializerValues(MiniJavaParser.ArrayInitializerValuesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#arrayInitializerSize}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInitializerSize(MiniJavaParser.ArrayInitializerSizeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(MiniJavaParser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(MiniJavaParser.LiteralContext ctx);
}