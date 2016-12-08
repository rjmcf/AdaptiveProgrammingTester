package miniJAST.expressions.arrays;

import miniJAST.Context;
import miniJAST.expressions.Expression;
import miniJAST.expressions.Id;
import miniJAST.expressions.PrimaryExpr;
import miniJAST.expressions.assignment.AssignLHS;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesArray;
import miniJAST.expressions.returnValues.ReturnValuesArrayAccess;
import miniJAST.expressions.returnValues.ReturnValuesInt;
import miniJAST.types.UnannType;

public class ArrayAccess extends PrimaryExpr implements AssignLHS {
    private Id id;
    private Expression index;

    public ReturnValues evaluate(Context c) throws Exception {
        ReturnValues r = id.evaluate(c);

        if (!(r instanceof ReturnValuesArray))
            throw new Exception("Cannot use array access on variable that isn't array");

        ReturnValuesArray ar = (ReturnValuesArray)r;

        ReturnValues i = index.evaluate(c);
        if (i.getType().uType != UnannType.INT)
            throw new Exception("Can only index with int value");

        int index = ((ReturnValuesInt)i).value;

        switch (r.getType().uType) {
            case BOOLEAN:
                return new ReturnValuesArrayAccess<Boolean>(UnannType.BOOLEAN, id.getName(), index,
                        (boolean)ar.get(index));
            case CHAR:
                return new ReturnValuesArrayAccess<Character>(UnannType.CHAR, id.getName(), index,
                        (char)ar.get(index));
            case INT:
                return new ReturnValuesArrayAccess<Integer>(UnannType.CHAR, id.getName(), index,
                        (int)ar.get(index));
            default: // DOUBLE
                return new ReturnValuesArrayAccess<Double>(UnannType.CHAR, id.getName(), index,
                        (double)ar.get(index));
        }
    }
}
