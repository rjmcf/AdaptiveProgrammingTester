package miniJAST.expressions.boolExpr;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.types.UnannType;

public class CondExpr extends Expression {
    private OrExpr cond;
    private Expression trueExpr;
    private CondExpr falseExpr; // Right associative

    public void setUpCondExpr(OrExpr c, Expression t, CondExpr f) { cond = c; trueExpr = t; falseExpr = f; }

    @Override
    public ReturnValues evaluate(Context c) throws MiniJASTException {
        ReturnValues condV = cond.evaluate(c);
        if (condV.getType().uType != UnannType.BOOLEAN)
            throw new TypeException("Conditional expression must have type Boolean");

        if (condV.getIsArray())
            throw new TypeException("Cannot operate on whole arrays");

        ReturnValues t = trueExpr.evaluate(c);
        ReturnValues f = falseExpr.evaluate(c);

        if (t.getType().uType != f.getType().uType)
            throw new TypeException("Types of two expressions must match");

        if (((ReturnValuesBool)condV).value)
            return t;
        else
            return f;
    }
}
