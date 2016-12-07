package miniJAST.expressions.arithExpr;

import miniJAST.Context;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.types.GeneralType;

public class MultExpr extends AddExpr {
    private boolean isTimes;
    private MultExpr leftSide; // Left associative
    private UnaryExpr rightSide;

    @Override
    public ReturnValues evaluate(Context c) throws Exception {
        return null;
    }
}
