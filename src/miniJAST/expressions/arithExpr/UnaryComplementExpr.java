package miniJAST.expressions.arithExpr;

import miniJAST.Context;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.types.GeneralType;

public class UnaryComplementExpr extends UnaryExpr {
    // Only logical complement here
    private UnaryExpr expr;

    @Override
    public ReturnValues evaluate(Context c) throws Exception {

        return null;
    }
}
