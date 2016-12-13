package miniJAST.expressions.boolExpr;

import miniJAST.Context;
import miniJAST.exceptions.IncorrectEvaluationException;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.returnValues.*;

import java.util.IllegalFormatCodePointException;

public class EqExpr extends AndExpr {
    private boolean isEqualityTest;
    private EqExpr leftSide; // Left associative (allows arith eq test on left side)
    private RelationExpr rightSide;

    public void setUp(boolean e, EqExpr l, RelationExpr r) { isEqualityTest = e; leftSide = l; rightSide = r; }


    @Override
    public ReturnValues evaluate(Context c) throws MiniJASTException {
        ReturnValuesBool result;

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
