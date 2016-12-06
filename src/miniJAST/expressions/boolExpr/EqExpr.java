package miniJAST.expressions.boolExpr;

import miniJAST.Context;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.types.GeneralType;
import miniJAST.types.UnannType;

public class EqExpr extends AndExpr {
    private boolean equalityTest;
    private EqExpr leftSide; // Left associative (allows arith eq test on left side)
    private RelationExpr rightSide;

    @Override
    public ReturnValues evaluate(Context c) throws Exception {
        ReturnValues l = leftSide.evaluate(c);
        ReturnValues r = rightSide.evaluate(c);

        if (leftSide.getType() != rightSide.getType())
            throw new Exception("Type mismatch between arguments of ==");

        type = UnannType.BOOLEAN;

        ReturnValues result = new ReturnValues();
        result.type = UnannType.BOOLEAN;
        result.gType = GeneralType.BOOL;

        switch (leftSide.getType()) {
            case BOOLEAN:
                result.boolVal = l.boolVal == r.boolVal;
                return result;
            case BYTE:
            case CHAR:
            case SHORT:
            case INT:
            case LONG:
                result.boolVal = l.intVal == r.intVal;
                return result;
            case FLOAT:
            case DOUBLE:
                result.boolVal = l.fpVal == r.fpVal;
                return result;
            default:
                throw new Exception("Type of left operand is not one of possible UnannTypes.");
        }
    }
}
