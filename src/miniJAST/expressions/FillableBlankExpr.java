package miniJAST.expressions;

import miniJAST.Context;
import miniJAST.NodeCount;
import miniJAST.exceptions.BlankEmptyException;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.returnValues.ReturnValues;

public class FillableBlankExpr extends Id {
    int nodesReplaced;
    Expression studentExpr;

    @Override
    public NodeCount getTreeSize() {
        if (studentExpr == null)
            return new NodeCount(0, nodesReplaced);
        else
            return studentExpr.getTreeSize();
    }

    @Override
    public String stringRepr() {
        return "...";
    }

    @Override
    public ReturnValues evaluate(Context c) throws MiniJASTException {
        if (studentExpr == null)
            throw new BlankEmptyException();
        else
            return studentExpr.evaluate(c);
    }
}
