package miniJAST.expressions.arithExpr;

import com.sun.org.apache.bcel.internal.generic.Type;
import com.sun.org.apache.xpath.internal.operations.Mult;
import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesChar;
import miniJAST.expressions.returnValues.ReturnValuesDouble;
import miniJAST.expressions.returnValues.ReturnValuesInt;
import miniJAST.types.UnannType;

public class MultExpr extends AddExpr {
    private boolean isTimes;
    private MultExpr leftSide; // Left associative
    private UnaryExpr rightSide;

    public void setUp(boolean t, MultExpr l, UnaryExpr r) { isTimes = t; leftSide = l; rightSide = r; }

    @Override
    public ReturnValues evaluate(Context c) throws MiniJASTException {
        ReturnValues left = leftSide.evaluate(c);
        ReturnValues right = rightSide.evaluate(c);

        if (left.getType().uType == UnannType.BOOLEAN || right.getType().uType == UnannType.BOOLEAN)
            throw new TypeException("Cannot use * or / on operands of type Boolean");

        if (left.getIsArray() || right.getIsArray())
            throw new TypeException("Cannot operate on whole arrays");


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
