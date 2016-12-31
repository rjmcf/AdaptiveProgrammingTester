package miniJAST.expressions;

import miniJAST.Context;
import miniJAST.NodeCount;
import miniJAST.exceptions.BlankEmptyException;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.returnValues.ReturnValues;

public class FillableBlankExpr extends PrimaryExpr {
    int nodesReplaced;
    Expression studentexpr;

    @Override
    public NodeCount getTreeSize() {
        return new NodeCount(0, nodesReplaced);
    }

    @Override
    public ReturnValues evaluate(Context c) throws MiniJASTException {
        if (studentexpr == null)
            throw new BlankEmptyException();
        else
            return studentexpr.evaluate(c);
    }
}
