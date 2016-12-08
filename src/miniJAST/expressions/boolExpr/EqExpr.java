package miniJAST.expressions.boolExpr;

import miniJAST.Context;
import miniJAST.expressions.returnValues.*;

public class EqExpr extends AndExpr {
    private boolean equalityTest;
    private EqExpr leftSide; // Left associative (allows arith eq test on left side)
    private RelationExpr rightSide;

    @Override
    public ReturnValues evaluate(Context c) throws Exception {
        ReturnValuesBool result;

        ReturnValues l = leftSide.evaluate(c);
        ReturnValues r = rightSide.evaluate(c);

        if (l.getType().uType != r.getType().uType)
            throw new Exception("Type mismatch between arguments of ==");

        if (l.getIsArray() || r.getIsArray())
            throw new Exception("Cannot operate on whole arrays");

        switch (l.getType().uType) {
            case BOOLEAN:
                return equalityTest ? new ReturnValuesBool(((ReturnValuesBool)l).value == ((ReturnValuesBool)r).value)
                        : new ReturnValuesBool(((ReturnValuesBool)l).value != ((ReturnValuesBool)r).value);
            case CHAR:
                return equalityTest ? new ReturnValuesBool(((ReturnValuesChar)l).value == ((ReturnValuesChar)r).value)
                        : new ReturnValuesBool(((ReturnValuesChar)l).value != ((ReturnValuesChar)r).value);
            case INT:
                return equalityTest ? new ReturnValuesBool(((ReturnValuesInt)l).value == ((ReturnValuesInt)r).value)
                        : new ReturnValuesBool(((ReturnValuesInt)l).value != ((ReturnValuesInt)r).value);
            case DOUBLE:
                return equalityTest ? new ReturnValuesBool(((ReturnValuesDouble)l).value == ((ReturnValuesDouble)r).value)
                        : new ReturnValuesBool(((ReturnValuesDouble)l).value != ((ReturnValuesDouble)r).value);
            default:
                throw new Exception("Type of left operand is not one of possible UnannTypes.");
        }
    }
}
