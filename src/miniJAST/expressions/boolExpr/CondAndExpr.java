package miniJAST.expressions.boolExpr;

import miniJAST.Context;
import miniJAST.expressions.ReturnValues;
import miniJAST.types.UnannType;

public class CondAndExpr extends CondOrExpr {
    private CondAndExpr leftSide; // Left associative
    private IncOrExpr rightSide;

    @Override
    public ReturnValues evaluate(Context c) throws Exception {
        ReturnValues l = leftSide.evaluate(c);
        ReturnValues r = rightSide.evaluate(c);

        if (leftSide.getType() != UnannType.BOOLEAN || rightSide.getType() != UnannType.BOOLEAN)
            throw new Exception("& operator not applicable to operands that aren't of type boolean");

        type = UnannType.BOOLEAN;

        l.boolVal = l.boolVal && r.boolVal;
        return l;
    }
}
