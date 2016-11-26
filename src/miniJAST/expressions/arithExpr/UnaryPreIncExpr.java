package miniJAST.expressions.arithExpr;

import miniJAST.expressions.StatementExpr;

public class UnaryPreIncExpr extends UnaryExpr implements StatementExpr {
    private boolean isPlus;
    private UnaryExpr expr;
}
