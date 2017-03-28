package miniJAST.expressions.boolExpr;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.ExpressionBase;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.types.PrimType;

public class CondExpr extends ExpressionBase {
    private int cond;
    private int trueExpr;
    private int falseExpr; // Right associative

    public void setUpCondExpr(Expression c, Expression t, Expression f) {
        subNodes.clear();
        cond = 0; trueExpr = 1; falseExpr = 2;
        subNodes.add(c); subNodes.add(t); subNodes.add(f);
    }

    @Override
    public String stringRepr() {
        return subNodes.get(cond).stringRepr() + " ? " + subNodes.get(trueExpr).stringRepr() + " : " + subNodes.get(falseExpr).stringRepr();
    }

    @Override
    public ReturnValues evaluate(Context c) throws MiniJASTException {
        checkType(subNodes.get(cond), OrExpr.class);
        checkType(subNodes.get(trueExpr), Expression.class);
        checkType(subNodes.get(falseExpr), CondExpr.class);

        ReturnValues condV = subNodes.get(cond).evaluate(c);
        if (condV.getType().uType != PrimType.BOOLEAN)
            throw new TypeException("Conditional expression must have type Boolean");

        if (condV.getIsArray())
            throw new TypeException("Cannot operate on whole arrays");

        if (((ReturnValuesBool)condV).value)
            return subNodes.get(trueExpr).evaluate(c);
        else
            return subNodes.get(falseExpr).evaluate(c);
    }
}
