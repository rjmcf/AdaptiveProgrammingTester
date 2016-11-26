package miniJAST.expressions.arithExpr;

import miniJAST.expressions.StatementExpr;

public class UnaryPostfixExpr extends UnaryExpr implements StatementExpr {
    private boolean isIncrement;
    private UnaryPostfixExpr expr;
}
