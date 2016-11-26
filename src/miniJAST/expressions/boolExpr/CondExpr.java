package miniJAST.expressions.boolExpr;

import miniJAST.expressions.Expression;

public class CondExpr extends BoolExpr {
    private CondOrExpr cond;
    private Expression trueExpr;
    private CondExpr falseExpr; // Right associative
}
