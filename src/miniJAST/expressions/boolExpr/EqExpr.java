package miniJAST.expressions.boolExpr;

import miniJAST.Context;
import miniJAST.exceptions.IncorrectEvaluationException;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.returnValues.*;

public class EqExpr extends AndExpr {
    private boolean isEqualityTest;
    private Expression leftSide; // Left associative (allows arith eq test on left side)
    private Expression rightSide;

    public void setUpEqExpr(boolean e, Expression l, Expression r) { isEqualityTest = e; leftSide = l; rightSide = r;
        subNodes.add(leftSide); subNodes.add(rightSide);}

    @Override
    public String stringRepr() {
        return leftSide.stringRepr() + (isEqualityTest ? " == " : " != ") + rightSide.stringRepr();
    }

    @Override
    public ReturnValues evaluate(Context c) throws MiniJASTException {
        checkType(leftSide, EqExpr.class);
        checkType(rightSide, RelationExpr.class);

        ReturnValues l = leftSide.evaluate(c);
        ReturnValues r = rightSide.evaluate(c);

        if (l.getType().uType != r.getType().uType)
            throw new TypeException("Type mismatch between arguments of ==");

        if (l.getIsArray() || r.getIsArray())
            throw new TypeException("Cannot operate on whole arrays");

        switch (l.getType().uType) {
            case BOOLEAN:
                return isEqualityTest ? new ReturnValuesBool(((ReturnValuesBool)l).value == ((ReturnValuesBool)r).value)
                        : new ReturnValuesBool(((ReturnValuesBool)l).value != ((ReturnValuesBool)r).value);
            case CHAR:
                return isEqualityTest ? new ReturnValuesBool(((ReturnValuesChar)l).value == ((ReturnValuesChar)r).value)
                        : new ReturnValuesBool(((ReturnValuesChar)l).value != ((ReturnValuesChar)r).value);
            case INT:
                return isEqualityTest ? new ReturnValuesBool(((ReturnValuesInt)l).value == ((ReturnValuesInt)r).value)
                        : new ReturnValuesBool(((ReturnValuesInt)l).value != ((ReturnValuesInt)r).value);
            case DOUBLE:
                return isEqualityTest ? new ReturnValuesBool(((ReturnValuesDouble)l).value == ((ReturnValuesDouble)r).value)
                        : new ReturnValuesBool(((ReturnValuesDouble)l).value != ((ReturnValuesDouble)r).value);
            default:
                throw new IncorrectEvaluationException("Type of left operand is not one of possible UnannTypes.");
        }
    }
}
