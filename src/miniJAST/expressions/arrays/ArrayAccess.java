package miniJAST.expressions.arrays;

import miniJAST.Context;
import miniJAST.NodeCount;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.OutOfBoundsException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.ExpressionBase;
import miniJAST.expressions.Id;
import miniJAST.expressions.PrimaryExpr;
import miniJAST.expressions.assignment.AssignLHS;
import miniJAST.expressions.returnValues.*;
import miniJAST.types.UnannType;

public class ArrayAccess extends PrimaryExpr implements AssignLHS {
    private Id id;
    private Expression index;

    public void setUpArrayAccess(Id i, Expression e) { id = i; index = e;
        subNodes.add(id); subNodes.add(index); }

    @Override
    public NodeCount getTreeSize() {
        NodeCount result = new NodeCount(id.getTreeSize().filled + index.getTreeSize().filled,
                id.getTreeSize().empty + index.getTreeSize().empty);
        result.filled++;
        return result;
    }

    @Override
    public String stringRepr() {
        return id.getName() + "[" + index.stringRepr() + "]";
    }

    public ReturnValues evaluate(Context c) throws MiniJASTException {
        ReturnValues r = id.evaluate(c);

        if (!(r.getIsArray()))
            throw new TypeException("Cannot use array access on variable that isn't array");

        ReturnValuesArray ar = (ReturnValuesArray)r;

        ReturnValues i = index.evaluate(c);
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
