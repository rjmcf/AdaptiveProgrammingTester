package miniJAST.expressions;

import miniJAST.Context;
import miniJAST.NodeCount;
import miniJAST.exceptions.BlankEmptyException;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.assignment.AssignExpr;
import miniJAST.expressions.assignment.AssignLHS;
import miniJAST.expressions.returnValues.ReturnValues;

public class FillableBlankExpr extends Id {
    int nodesReplaced;
    Expression studentexpr;

    @Override
    public NodeCount getTreeSize() {

        if (studentexpr == null)
            return new NodeCount(0, nodesReplaced);
        else
            return studentexpr.getTreeSize();
    }

    @Override
    public String stringRepr() {
        return " ... ";
    }

    @Override
    public ReturnValues evaluate(Context c) throws MiniJASTException {
        if (studentexpr == null)
            throw new BlankEmptyException();
        else
            return studentexpr.evaluate(c);
    }
}
