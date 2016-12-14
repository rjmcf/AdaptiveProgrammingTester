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
    public ReturnValues evaluate(Context c) throws MiniJASTException {
        ReturnValuesBool result;

        ReturnValues l = leftSide.evaluate(c);
        ReturnValues r = rightSide.evaluate(c);

        if (l.getType().uType != UnannType.BOOLEAN || r.getType().uType != UnannType.BOOLEAN)
            throw new TypeException("|| operator not applicable to operands that aren't of type boolean");

        if (l.getIsArray() || r.getIsArray())
            throw new TypeException("Cannot operate on whole arrays");

        if (((ReturnValuesBool)l).value) {
            result = new ReturnValuesBool(true);
            return result;
        }

        result = new ReturnValuesBool(((ReturnValuesBool)r).value);
        return result;
    }
}
