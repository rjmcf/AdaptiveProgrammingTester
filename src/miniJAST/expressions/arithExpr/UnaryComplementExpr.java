package miniJAST.expressions.arithExpr;

import miniJAST.Context;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBoolean;
import miniJAST.types.UnannType;

public class UnaryComplementExpr extends UnaryExpr {
    // Only logical complement here
    private UnaryExpr expr;

    @Override
    public ReturnValues evaluate(Context c) throws Exception {
        ReturnValues e = expr.evaluate(c);

        if (e.getType().uType != UnannType.BOOLEAN)
            throw new Exception("Cannot apply ! to non-boolean type.");

        return new ReturnValuesBoolean(!((ReturnValuesBoolean)e).value);
    }
}
