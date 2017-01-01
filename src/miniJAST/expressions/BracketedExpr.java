package miniJAST.expressions;

import miniJAST.Context;
import miniJAST.NodeCount;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.returnValues.ReturnValues;

public class BracketedExpr extends PrimaryExpr {
    private Expression expr;

    public void setUpBracketExpr(Expression e) { expr = e; subNodes.add(expr); }

    @Override
    public String stringRepr() {
        return " (" + expr.stringRepr() + ") ";
    }

    @Override
    public ReturnValues evaluate(Context c) throws MiniJASTException {
        return expr.evaluate(c);
    }
}
