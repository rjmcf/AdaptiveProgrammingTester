package miniJAST.expressions.arithExpr;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.boolExpr.RelationExpr;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesChar;
import miniJAST.expressions.returnValues.ReturnValuesDouble;
import miniJAST.expressions.returnValues.ReturnValuesInt;
import miniJAST.types.UnannType;

public class AddExpr extends RelationExpr {
    private boolean isPlus;
    private AddExpr leftSide; // Left associative
    private MultExpr rightSide;

    public void setUpAddExpr(boolean p, AddExpr l, MultExpr r) { isPlus = p; leftSide = l; rightSide = r; }

    @Override
    public ReturnValues evaluate(Context c) throws MiniJASTException {
        ReturnValues left = leftSide.evaluate(c);
        ReturnValues right = rightSide.evaluate(c);

        if (left.getType().uType == UnannType.BOOLEAN || right.getType().uType == UnannType.BOOLEAN)
            throw new TypeException("Cannot use + or - on operands of type Boolean");

        if (left.getIsArray() || right.getIsArray())
            throw new TypeException("Cannot operate on whole arrays");

        switch (left.getType().uType) {
            case CHAR:
                switch (right.getType().uType) {
                    case CHAR:
                        return new ReturnValuesInt(isPlus ? ((ReturnValuesChar)left).value + ((ReturnValuesChar)right).value
                                : ((ReturnValuesChar)left).value - ((ReturnValuesChar)right).value);
                    case INT:
                        return new ReturnValuesInt(isPlus ? ((ReturnValuesChar)left).value + ((ReturnValuesInt)right).value
                                : ((ReturnValuesChar)left).value - ((ReturnValuesInt)right).value);
                    default: // DOUBLE
                        return new ReturnValuesDouble(isPlus ? ((ReturnValuesChar)left).value + ((ReturnValuesDouble)right).value
                                : ((ReturnValuesChar)left).value - ((ReturnValuesDouble)right).value);
                }
            case INT:
                switch (right.getType().uType) {
                    case CHAR:
                        return new ReturnValuesInt(isPlus ? ((ReturnValuesInt)left).value + ((ReturnValuesChar)right).value
                                : ((ReturnValuesInt)left).value - ((ReturnValuesChar)right).value);
                    case INT:
                        return new ReturnValuesInt(isPlus ? ((ReturnValuesInt)left).value + ((ReturnValuesInt)right).value
                                : ((ReturnValuesInt)left).value - ((ReturnValuesInt)right).value);
                    default: // DOUBLE
                        return new ReturnValuesDouble(isPlus ? ((ReturnValuesInt)left).value + ((ReturnValuesDouble)right).value
                                : ((ReturnValuesInt)left).value - ((ReturnValuesDouble)right).value);
                }
            default: // DOUBLE
                switch (right.getType().uType) {
                    case CHAR:
                        return new ReturnValuesDouble(isPlus ? ((ReturnValuesDouble)left).value + ((ReturnValuesChar)right).value
                                : ((ReturnValuesDouble)left).value - ((ReturnValuesChar)right).value);
                    case INT:
                        return new ReturnValuesDouble(isPlus ? ((ReturnValuesDouble)left).value + ((ReturnValuesInt)right).value
                                : ((ReturnValuesDouble)left).value - ((ReturnValuesInt)right).value);
                    default: // DOUBLE
                        return new ReturnValuesDouble(isPlus ? ((ReturnValuesDouble)left).value + ((ReturnValuesDouble)right).value
                                : ((ReturnValuesDouble)left).value - ((ReturnValuesDouble)right).value);
                }
        }
    }
}
