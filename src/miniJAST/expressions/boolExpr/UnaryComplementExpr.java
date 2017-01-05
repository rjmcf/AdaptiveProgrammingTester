package miniJAST.expressions.boolExpr;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.arithExpr.UnaryExpr;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.types.UnannType;

public class UnaryComplementExpr extends UnaryExpr {
    // Only logical complement here
    private Expression expr;

    public void setUpCompExpr(Expression e) { expr = e; subNodes.add(expr); }

    @Override
    public String stringRepr() {
        return " !" + expr.stringRepr();
    }

    @Override
    public ReturnValues evaluate(Context c) throws MiniJASTException {
        checkType(expr, UnaryExpr.class);

        ReturnValues e = expr.evaluate(c);

        if (e.getType().uType != UnannType.BOOLEAN)
            throw new TypeException("Cannot apply ! to non-boolean type.");

        if (e.getIsArray())
            throw new TypeException("Cannot operate on whole arrays");

        return new ReturnValuesBool(!((ReturnValuesBool)e).value);
    }
}
