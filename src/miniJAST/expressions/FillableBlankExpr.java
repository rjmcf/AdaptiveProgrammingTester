package miniJAST.expressions;

import miniJAST.Context;
import miniJAST.exceptions.BlankEmptyException;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.returnValues.ReturnValues;

public class FillableBlankExpr extends PrimaryExpr {
    int subNodes;
    Expression studentexpr;

    @Override
    public int getSubNodes() {
        return subNodes;
    }

    @Override
    public ReturnValues evaluate(Context c) throws MiniJASTException {
        if (studentexpr == null)
            throw new BlankEmptyException();
        else
            return studentexpr.evaluate(c);
    }
}
