package miniJAST.expressions;

import miniJAST.Context;
import miniJAST.expressions.returnValues.ReturnValues;

public class BracketedExpr extends PrimaryExpr {
    private Expression expr;

    @Override
    public ReturnValues evaluate(Context c) throws Exception {
        return expr.evaluate(c);
    }
}
