package miniJAST.expressions.boolExpr;

import miniJAST.Context;
import miniJAST.expressions.ReturnValues;
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

        switch (leftSide.getType()) {
            case BOOLEAN:
                result.boolVal = l.boolVal == r.boolVal;
                return result;
            case BYTE:
                result.boolVal = l.byteVal == r.byteVal;
                return result;
            case CHAR:
                result.boolVal = l.cVal == r.cVal;
                return result;
            case SHORT:
                result.boolVal = l.sVal == r.sVal;
                return result;
            case INT:
                result.boolVal = l.iVal == r.iVal;
                return result;
            case LONG:
                result.boolVal = l.lVal == r.lVal;
                return result;
            case FLOAT:
                result.boolVal = l.fVal == r.fVal;
                return result;
            case DOUBLE:
                result.boolVal = l.dVal == r.dVal;
                return result;
            default:
                throw new Exception("Type of left operand is not one of possible UnannTypes.");
        }
    }
}
