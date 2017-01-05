package miniJAST.expressions.boolExpr;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.types.UnannType;

public class OrExpr extends CondExpr {
    private Expression leftSide; // Left associative
    private Expression rightSide;

    public void setUpOrExpr(Expression l, Expression r) { leftSide = l; rightSide = r;
        subNodes.add(leftSide); subNodes.add(rightSide);}

    @Override
    public String stringRepr() {
        return leftSide.stringRepr() + " || " + rightSide.stringRepr();
    }

    @Override
    public ReturnValues evaluate(Context c) throws MiniJASTException {
        checkType(leftSide, OrExpr.class);
        checkType(rightSide, AndExpr.class);

        ReturnValues l = leftSide.evaluate(c);

        if (l.getType().uType != UnannType.BOOLEAN)
            throw new TypeException("|| operator not applicable to operands that aren't of type boolean");

        if (l.getIsArray())
            throw new TypeException("Cannot operate on whole arrays");

        if (((ReturnValuesBool)l).value) {
            return new ReturnValuesBool(true);
        }

        ReturnValues r = rightSide.evaluate(c);

        if (r.getType().uType != UnannType.BOOLEAN)
            throw new TypeException("|| operator not applicable to operands that aren't of type boolean");

        if (r.getIsArray())
            throw new TypeException("Cannot operate on whole arrays");

        return new ReturnValuesBool(((ReturnValuesBool)r).value);
    }
}
