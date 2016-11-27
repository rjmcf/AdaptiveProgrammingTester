package miniJAST.expressions;

import miniJAST.Context;

public class BracketedExpr extends PrimaryExpr {
    private Expression expr;

    @Override
    public ReturnValues evaluate(Context c) throws Exception {
        ReturnValues result = expr.evaluate(c);
        type = expr.type;
        return result;
    }
}
