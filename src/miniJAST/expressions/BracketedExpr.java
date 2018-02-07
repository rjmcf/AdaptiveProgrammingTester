package miniJAST.expressions;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.arithExpr.UnaryExpr;
import miniJAST.expressions.returnValues.ReturnValues;

public class BracketedExpr extends UnaryExpr {
    private int expr;

    public void setUpBracketExpr(Expression e) { expr = 0; subNodes.add(e); }

    @Override
    public String stringRepr() {
        return "(" + subNodes.get(expr).stringRepr() + ")";
    }

    @Override
    public ReturnValues evaluate(Context c) throws MiniJASTException {
        checkType(subNodes.get(expr), Expression.class);

        return subNodes.get(expr).evaluate(c);
    }
}
