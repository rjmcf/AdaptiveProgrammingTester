package miniJAST.expressions.boolExpr;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.types.PrimType;

public class AndExpr extends OrExpr {
    private int leftSide; // Left associative
    private int rightSide;

    public void setUpAndExpr(Expression l, Expression r) {
        subNodes.clear();
        leftSide = 0; rightSide = 1;
        subNodes.add(l); subNodes.add(r);
    }

    @Override
    public String stringRepr() {
        return subNodes.get(leftSide).stringRepr() + " && " + subNodes.get(rightSide).stringRepr();
    }

    @Override
    public ReturnValues evaluate(Context c) throws MiniJASTException {
        checkType(subNodes.get(leftSide), AndExpr.class);
        checkType(subNodes.get(rightSide), EqExpr.class);

        ReturnValues l = subNodes.get(leftSide).evaluate(c);

        if (l.getType().uType != PrimType.BOOLEAN)
            throw new TypeException("&& operator not applicable to operands that aren't of type boolean");

        if (l.getIsArray())
            throw new TypeException("Cannot operate on whole arrays");

        if (!((ReturnValuesBool)l).value) {
            return new ReturnValuesBool(false);
        }

        ReturnValues r = subNodes.get(rightSide).evaluate(c);

        if (r.getType().uType != PrimType.BOOLEAN)
        throw new TypeException("&& operator not applicable to operands that aren't of type boolean");

        if (r.getIsArray())
            throw new TypeException("Cannot operate on whole arrays");

        return new ReturnValuesBool(((ReturnValuesBool)r).value);
    }
}
