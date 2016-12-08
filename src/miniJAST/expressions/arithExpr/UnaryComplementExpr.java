package miniJAST.expressions.arithExpr;

import miniJAST.Context;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.types.UnannType;

public class UnaryComplementExpr extends UnaryExpr {
    // Only logical complement here
    private UnaryExpr expr;

    @Override
    public ReturnValues evaluate(Context c) throws Exception {
        ReturnValues e = expr.evaluate(c);

        if (e.getType().uType != UnannType.BOOLEAN)
            throw new Exception("Cannot apply ! to non-boolean type.");

        if (e.getIsArray())
            throw new Exception("Cannot operate on whole arrays");

        return new ReturnValuesBool(!((ReturnValuesBool)e).value);
    }
}
