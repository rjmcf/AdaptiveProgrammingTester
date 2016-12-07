package miniJAST.expressions.boolExpr;

import miniJAST.Context;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.types.UnannType;

public class XOrExpr extends AndExpr {
    private XOrExpr leftSide; // Left associative
    private EqExpr rightSide;

    @Override
    public ReturnValues evaluate(Context c) throws Exception {
        ReturnValues l = leftSide.evaluate(c);
        ReturnValues r = rightSide.evaluate(c);

        if (leftSide.getType() != UnannType.BOOLEAN || rightSide.getType() != UnannType.BOOLEAN)
            throw new Exception("& operator not applicable to operands that aren't of type boolean");

        type = UnannType.BOOLEAN;

        l.boolVal ^= r.boolVal;
        return l;
    }
}
