package miniJAST.expressions.boolExpr;

import miniJAST.Context;
import miniJAST.NodeCount;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.ExpressionBase;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.types.UnannType;

public class CondExpr extends ExpressionBase {
    private OrExpr cond;
    private Expression trueExpr;
    private CondExpr falseExpr; // Right associative

    public void setUpCondExpr(OrExpr c, Expression t, CondExpr f) { cond = c; trueExpr = t; falseExpr = f;
        subNodes.add(cond); subNodes.add(trueExpr); subNodes.add(falseExpr); }

    @Override
    public NodeCount getTreeSize() {
        NodeCount result = new NodeCount(cond.getTreeSize().filled + trueExpr.getTreeSize().filled + falseExpr.getTreeSize().filled,
                cond.getTreeSize().empty + trueExpr.getTreeSize().empty + falseExpr.getTreeSize().empty);
        result.filled++;
        return result;
    }

    @Override
    public String stringRepr() {
        return cond.stringRepr() + " ? " + trueExpr.stringRepr() + " : " + falseExpr.stringRepr();
    }

    @Override
    public ReturnValues evaluate(Context c) throws MiniJASTException {
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
