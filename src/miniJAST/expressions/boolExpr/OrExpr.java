package miniJAST.expressions.boolExpr;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.types.Type;
import miniJAST.types.UnannType;

public class OrExpr extends CondExpr {
    private OrExpr leftSide; // Left associative
    private AndExpr rightSide;

    public void setUpOrExpr(OrExpr l, AndExpr r) { leftSide = l; rightSide = r; }

    @Override
    public int getSubNodes() {
        int l = leftSide.getSubNodes();
        int r = rightSide.getSubNodes();
        return l + r + 2;
    }

    @Override
    public ReturnValues evaluate(Context c) throws MiniJASTException {
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
