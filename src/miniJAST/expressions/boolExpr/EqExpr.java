package miniJAST.expressions.boolExpr;

import miniJAST.Context;
import miniJAST.exceptions.IncorrectEvaluationException;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.returnValues.*;

public class EqExpr extends AndExpr {
    private boolean isEqualityTest;
    private int leftSide; // Left associative (allows arith eq test on left side)
    private int rightSide;

    public void setUpEqExpr(boolean e, Expression l, Expression r) {
        subNodes.clear();
        isEqualityTest = e; leftSide = 0; rightSide = 1;
        subNodes.add(l); subNodes.add(r);
    }

    @Override
    public String stringRepr() {
        return subNodes.get(leftSide).stringRepr() + (isEqualityTest ? " == " : " != ") + subNodes.get(rightSide).stringRepr();
    }

    @Override
    public ReturnValues evaluate(Context c) throws MiniJASTException {
        checkType(subNodes.get(leftSide), EqExpr.class);
        checkType(subNodes.get(rightSide), RelationExpr.class);

        ReturnValues l = subNodes.get(leftSide).evaluate(c);
        ReturnValues r = subNodes.get(rightSide).evaluate(c);

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
