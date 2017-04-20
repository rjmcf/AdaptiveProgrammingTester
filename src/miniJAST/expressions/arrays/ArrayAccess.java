package miniJAST.expressions.arrays;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.OutOfBoundsException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.FillableBlankExpr;
import miniJAST.expressions.Id;
import miniJAST.expressions.arithExpr.UnaryExpr;
import miniJAST.expressions.assignment.AssignLHS;
import miniJAST.expressions.returnValues.*;
import miniJAST.types.PrimType;
import miniJAST.types.Type;

public class ArrayAccess extends UnaryExpr implements AssignLHS {
    private int idE;
    private int index;
    private Id idOnceChecked;

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

    public boolean checkDefined(Context c) throws MiniJASTException {
        checkType(subNodes.get(idE), Id.class);
        try {
            if (subNodes.get(idE) instanceof FillableBlankExpr)
                idOnceChecked = (Id) ((FillableBlankExpr) subNodes.get(idE)).getStudentExpr();
            else
                idOnceChecked = (Id) subNodes.get(idE);
        } catch (ClassCastException e) {
            throw new TypeException("ID must have type Id!");
        }

        boolean result = idOnceChecked.checkDefined(c);
        if (!idOnceChecked.getIsArray())
            throw new TypeException("Cannot use array access on variable that isn't array");
        return result;
    }

    public ReturnValuesInt evaluateIndex(Context c) throws MiniJASTException {
        try {
            return (ReturnValuesInt) subNodes.get(index).evaluate(c);
        } catch (ClassCastException cE) {
            throw new TypeException("Index must have integer type, and must not be array.");
        }
    }

    public Type getArType() {
        return idOnceChecked.getType();
    }

    public String getName(){
        return idOnceChecked.getName();
    }

    public ReturnValues evaluate(Context c) throws MiniJASTException {
        checkType(subNodes.get(idE), Id.class);

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
        if (i.getPType() != PrimType.INT)
            throw new TypeException("Can only index with int value");

        if (i.getIsArray())
            throw new TypeException("Cannot index with array");

        int index = ((ReturnValuesInt)i).value;

        int size = ar.getSize();
        if (index < 0 || index >= size)
            throw new OutOfBoundsException(index, size);

        switch (r.getPType()) {
            case BOOLEAN:
                return new ReturnValuesBool((boolean)ar.get(index));
            case CHAR:
                return new ReturnValuesChar((char)ar.get(index));
            case INT:
                return new ReturnValuesInt((int)ar.get(index));
            default: // DOUBLE
                return new ReturnValuesDouble((double)ar.get(index));
        }
    }
}
