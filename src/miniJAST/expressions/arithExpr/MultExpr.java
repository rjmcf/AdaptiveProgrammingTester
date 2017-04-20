package miniJAST.expressions.arithExpr;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesChar;
import miniJAST.expressions.returnValues.ReturnValuesDouble;
import miniJAST.expressions.returnValues.ReturnValuesInt;
import miniJAST.types.PrimType;

public class MultExpr extends AddExpr {
    private boolean isTimes;
    private int leftSide; // Left associative
    private int rightSide;

    public void setUpMultExpr(boolean t, Expression l, Expression r) {
        subNodes.clear();
        isTimes = t; subNodes.add(l); subNodes.add(r);
        leftSide = 0; rightSide = 1;
    }

    @Override
    public String stringRepr() {
        return subNodes.get(leftSide).stringRepr() + (isTimes ? " * " : " / ") + subNodes.get(rightSide).stringRepr();
    }

    @Override
    public ReturnValues evaluate(Context c) throws MiniJASTException {
        checkType(subNodes.get(leftSide), MultExpr.class);
        checkType(subNodes.get(rightSide), UnaryExpr.class);

        ReturnValues left = subNodes.get(leftSide).evaluate(c);
        ReturnValues right = subNodes.get(rightSide).evaluate(c);

        if (left.getPType() == PrimType.BOOLEAN || right.getPType() == PrimType.BOOLEAN)
            throw new TypeException("Cannot use * or / on operands of type Boolean");

        if (left.getIsArray() || right.getIsArray())
            throw new TypeException("Cannot operate on whole arrays");


        switch (left.getPType()) {
            case CHAR:
                switch (right.getPType()) {
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
                switch (right.getPType()) {
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
                switch (right.getPType()) {
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
