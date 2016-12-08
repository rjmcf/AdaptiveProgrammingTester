package miniJAST.expressions.boolExpr;

import miniJAST.Context;
import miniJAST.expressions.Expression;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.types.UnannType;

public class CondExpr extends Expression {
    private OrExpr cond;
    private Expression trueExpr;
    private CondExpr falseExpr; // Right associative

    @Override
    public ReturnValues evaluate(Context c) throws Exception {
        ReturnValues condV = cond.evaluate(c);
        if (condV.getType().uType != UnannType.BOOLEAN)
            throw new Exception("Conditional expression must have type Boolean");

        if (condV.getIsArray())
            throw new Exception("Cannot operate on whole arrays");

        if (((ReturnValuesBool)condV).value)
            return trueExpr.evaluate(c);
        else
            return falseExpr.evaluate(c);
    }
}
