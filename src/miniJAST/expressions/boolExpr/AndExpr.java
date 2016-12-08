package miniJAST.expressions.boolExpr;

import miniJAST.Context;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBoolean;
import miniJAST.types.UnannType;

public class AndExpr extends OrExpr {
    private AndExpr leftSide; // Left associative
    private EqExpr rightSide;

    @Override
    public ReturnValues evaluate(Context c) throws Exception {
        ReturnValuesBoolean result;

        ReturnValues l = leftSide.evaluate(c);

        if (l.getType().uType != UnannType.BOOLEAN)
            throw new Exception("&& operator not applicable to operands that aren't of type boolean");

        if (!((ReturnValuesBoolean)l).value) {
            result = new ReturnValuesBoolean(false);
            return result;
        }

        ReturnValues r = rightSide.evaluate(c);

        if (r.getType().uType != UnannType.BOOLEAN)
            throw new Exception("&& operator not applicable to operands that aren't of type boolean");

        result = new ReturnValuesBoolean(((ReturnValuesBoolean)r).value);
        return result;
    }
}
