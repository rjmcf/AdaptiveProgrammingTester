package miniJAST.expressions.arrays;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.OutOfBoundsException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.FillableBlankExpr;
import miniJAST.expressions.Id;
import miniJAST.expressions.assignment.AssignLHS;
import miniJAST.expressions.assignment.UnaryPostfixExpr;
import miniJAST.expressions.returnValues.*;
import miniJAST.types.UnannType;

public class ArrayAccess extends UnaryPostfixExpr implements AssignLHS {
    private int idE;
    private int index;

    public void setUpArrayAccess(Expression i, Expression e) {
        subNodes.clear();
        subNodes.add(i); subNodes.add(e);
        idE = 0; index = 1;

    }

    @Override
    public String stringRepr() {
        if (subNodes.get(idE) instanceof Id)
            return ((Id)subNodes.get(idE)).getName() + "[" + subNodes.get(index).stringRepr() + "]";
        else
            return (subNodes.get(idE)).stringRepr() + "[" + subNodes.get(index).stringRepr() + "]";
    }

    public ReturnValues evaluate(Context c) throws MiniJASTException {
        checkType(subNodes.get(idE), Id.class);
        checkType(subNodes.get(index), Expression.class);

        Id id;
        try {
            if (subNodes.get(idE) instanceof FillableBlankExpr)
                id = (Id) ((FillableBlankExpr) subNodes.get(idE)).getStudentExpr();
            else
                id = (Id) subNodes.get(idE);
        } catch (ClassCastException e) {
            throw new TypeException("ID must have type Id!");
        }

        ReturnValues r = id.evaluate(c);

        if (!(r.getIsArray()))
            throw new TypeException("Cannot use array access on variable that isn't array");

        ReturnValuesArray ar = (ReturnValuesArray)r;

        ReturnValues i = subNodes.get(index).evaluate(c);
        if (i.getType().uType != UnannType.INT)
            throw new TypeException("Can only index with int value");

        if (i.getIsArray())
            throw new TypeException("Cannot index with array");

        int index = ((ReturnValuesInt)i).value;

        if (index < 0 || index >= id.getType().size)
            throw new OutOfBoundsException(index, id.getType().size);

        switch (r.getType().uType) {
            case BOOLEAN:
                return new ReturnValuesBoolAA(id.getName(), index, (boolean)ar.get(index));
            case CHAR:
                return new ReturnValuesCharAA(id.getName(), index, (char)ar.get(index));
            case INT:
                return new ReturnValuesIntAA(id.getName(), index, (int)ar.get(index));
            default: // DOUBLE
                return new ReturnValuesDoubleAA(id.getName(), index, (double)ar.get(index));
        }
    }
}
