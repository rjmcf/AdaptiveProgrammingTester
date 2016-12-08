package miniJAST.expressions.arithExpr;

import miniJAST.Context;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesChar;
import miniJAST.expressions.returnValues.ReturnValuesDouble;
import miniJAST.expressions.returnValues.ReturnValuesInt;
import miniJAST.types.UnannType;

public class MultExpr extends AddExpr {
    private boolean isTimes;
    private MultExpr leftSide; // Left associative
    private UnaryExpr rightSide;

    @Override
    public ReturnValues evaluate(Context c) throws Exception {
        ReturnValues left = leftSide.evaluate(c);
        ReturnValues right = rightSide.evaluate(c);

        if (left.getType().uType == UnannType.BOOLEAN || right.getType().uType == UnannType.BOOLEAN)
            throw new Exception("Cannot use * or / on operands of type Boolean");


        switch (left.getType().uType) {
            case CHAR:
                switch (right.getType().uType) {
                    case CHAR:
                        return new ReturnValuesInt(isTimes ? ((ReturnValuesChar)left).value * ((ReturnValuesChar)right).value
                                : ((ReturnValuesChar)left).value / ((ReturnValuesChar)right).value);
                    case INT:
                        return new ReturnValuesInt(isTimes ? ((ReturnValuesChar)left).value * ((ReturnValuesInt)right).value
                                : ((ReturnValuesChar)left).value / ((ReturnValuesInt)right).value);
                    default: // DOUBLE
                        return new ReturnValuesDouble(isTimes ? ((ReturnValuesChar)left).value * ((ReturnValuesDouble)right).value
                                : ((ReturnValuesChar)left).value / ((ReturnValuesDouble)right).value);
                }
            case INT:
                switch (right.getType().uType) {
                    case CHAR:
                        return new ReturnValuesInt(isTimes ? ((ReturnValuesInt)left).value * ((ReturnValuesChar)right).value
                                : ((ReturnValuesInt)left).value / ((ReturnValuesChar)right).value);
                    case INT:
                        return new ReturnValuesInt(isTimes ? ((ReturnValuesInt)left).value * ((ReturnValuesInt)right).value
                                : ((ReturnValuesInt)left).value / ((ReturnValuesInt)right).value);
                    default: // DOUBLE
                        return new ReturnValuesDouble(isTimes ? ((ReturnValuesInt)left).value * ((ReturnValuesDouble)right).value
                                : ((ReturnValuesInt)left).value / ((ReturnValuesDouble)right).value);
                }
            default: // DOUBLE
                switch (right.getType().uType) {
                    case CHAR:
                        return new ReturnValuesDouble(isTimes ? ((ReturnValuesDouble)left).value * ((ReturnValuesChar)right).value
                                : ((ReturnValuesDouble)left).value / ((ReturnValuesChar)right).value);
                    case INT:
                        return new ReturnValuesDouble(isTimes ? ((ReturnValuesDouble)left).value * ((ReturnValuesInt)right).value
                                : ((ReturnValuesDouble)left).value / ((ReturnValuesInt)right).value);
                    default: // DOUBLE
                        return new ReturnValuesDouble(isTimes ? ((ReturnValuesDouble)left).value * ((ReturnValuesDouble)right).value
                                : ((ReturnValuesDouble)left).value / ((ReturnValuesDouble)right).value);
                }
        }
    }
}