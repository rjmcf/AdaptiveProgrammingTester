package miniJAST.expressions.boolExpr;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.ExpressionBase;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.types.UnannType;

public class CondExpr extends ExpressionBase {
    private Expression cond;
    private Expression trueExpr;
    private Expression falseExpr; // Right associative

    public void setUpCondExpr(Expression c, Expression t, Expression f) { cond = c; trueExpr = t; falseExpr = f;
        subNodes.add(cond); subNodes.add(trueExpr); subNodes.add(falseExpr); }

    @Override
    public String stringRepr() {
        return cond.stringRepr() + " ? " + trueExpr.stringRepr() + " : " + falseExpr.stringRepr();
    }

    @Override
    public ReturnValues evaluate(Context c) throws MiniJASTException {
        checkType(cond, OrExpr.class);
        checkType(trueExpr, Expression.class);
        checkType(falseExpr, CondExpr.class);

        ReturnValues condV = cond.evaluate(c);
        if (condV.getType().uType != UnannType.BOOLEAN)
            throw new TypeException("Conditional expression must have type Boolean");

        if (condV.getIsArray())
            throw new TypeException("Cannot operate on whole arrays");

        if (((ReturnValuesBool)condV).value)
            return trueExpr.evaluate(c);
        else
            return falseExpr.evaluate(c);
    }
}
