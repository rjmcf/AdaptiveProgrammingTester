package miniJAST.expressions.boolExpr;

import miniJAST.Context;
import miniJAST.expressions.returnValues.*;

public class EqExpr extends AndExpr {
    private boolean equalityTest;
    private EqExpr leftSide; // Left associative (allows arith eq test on left side)
    private RelationExpr rightSide;

    @Override
    public ReturnValues evaluate(Context c) throws Exception {
        ReturnValuesBoolean result;

        ReturnValues l = leftSide.evaluate(c);
        ReturnValues r = rightSide.evaluate(c);

        if (l.getType().uType != r.getType().uType)
            throw new Exception("Type mismatch between arguments of ==");

        switch (l.getType().uType) {
            case BOOLEAN:
                return equalityTest ? new ReturnValuesBoolean(((ReturnValuesBoolean)l).value == ((ReturnValuesBoolean)r).value)
                        : new ReturnValuesBoolean(((ReturnValuesBoolean)l).value != ((ReturnValuesBoolean)r).value);
            case CHAR:
                return equalityTest ? new ReturnValuesBoolean(((ReturnValuesChar)l).value == ((ReturnValuesChar)r).value)
                        : new ReturnValuesBoolean(((ReturnValuesChar)l).value != ((ReturnValuesChar)r).value);
            case INT:
                return equalityTest ? new ReturnValuesBoolean(((ReturnValuesInt)l).value == ((ReturnValuesInt)r).value)
                        : new ReturnValuesBoolean(((ReturnValuesInt)l).value != ((ReturnValuesInt)r).value);
            case DOUBLE:
                return equalityTest ? new ReturnValuesBoolean(((ReturnValuesDouble)l).value == ((ReturnValuesDouble)r).value)
                        : new ReturnValuesBoolean(((ReturnValuesDouble)l).value != ((ReturnValuesDouble)r).value);
            default:
                throw new Exception("Type of left operand is not one of possible UnannTypes.");
        }
    }
}
