package miniJAST.expressions.boolExpr;

import miniJAST.expressions.Expression;

public class CondExpr extends Expression {
    private CondOrExpr cond;
    private Expression trueExpr;
    private CondExpr falseExpr; // Right associative
}
