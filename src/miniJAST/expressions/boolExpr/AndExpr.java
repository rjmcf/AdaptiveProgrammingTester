package miniJAST.expressions.boolExpr;

import miniJAST.Context;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.types.UnannType;

public class AndExpr extends OrExpr {
    private AndExpr leftSide; // Left associative
    private EqExpr rightSide;

    @Override
    public ReturnValues evaluate(Context c) throws Exception {
        ReturnValuesBool result;

        ReturnValues l = leftSide.evaluate(c);

        if (l.getType().uType != UnannType.BOOLEAN)
            throw new Exception("&& operator not applicable to operands that aren't of type boolean");

        if (!((ReturnValuesBool)l).value) {
            result = new ReturnValuesBool(false);
            return result;
        }

        ReturnValues r = rightSide.evaluate(c);

        if (r.getType().uType != UnannType.BOOLEAN)
            throw new Exception("&& operator not applicable to operands that aren't of type boolean");

        result = new ReturnValuesBool(((ReturnValuesBool)r).value);
        return result;
    }
}
