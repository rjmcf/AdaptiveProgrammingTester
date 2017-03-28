package miniJAST.expressions.boolExpr;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.arithExpr.UnaryExpr;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.types.PrimType;

public class UnaryComplementExpr extends UnaryExpr {
    // Only logical complement here
    private int expr;

    public void setUpCompExpr(Expression e) { subNodes.clear(); expr = 0; subNodes.add(e); }

    @Override
    public String stringRepr() {
        return "!" + subNodes.get(expr).stringRepr();
    }

    @Override
    public ReturnValues evaluate(Context c) throws MiniJASTException {
        checkType(subNodes.get(expr), UnaryExpr.class);

        ReturnValues e = subNodes.get(expr).evaluate(c);

        if (e.getType().uType != PrimType.BOOLEAN)
            throw new TypeException("Cannot apply ! to non-boolean type.");

        if (e.getIsArray())
            throw new TypeException("Cannot operate on whole arrays");

        return new ReturnValuesBool(!((ReturnValuesBool)e).value);
    }
}
