package miniJAST.expressions;

import miniJAST.Context;
import miniJAST.FillableBlank;
import miniJAST.MiniJASTNode;
import miniJAST.NodeCount;
import miniJAST.exceptions.BlankEmptyException;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.returnValues.ReturnValues;

import java.util.ArrayList;

public class FillableBlankExpr extends FillableBlank implements Expression{
    private Expression studentExpr;

    public void setStudentExpr(Expression sE) { studentExpr = sE; }
    public boolean isFilled() { return studentExpr != null; }
    @Override
    public boolean getIsLeaf() { return false; }
    @Override
    public ArrayList<? extends MiniJASTNode> getSubNodes() { return null; }

    public FillableBlankExpr(int nReplaced) { super(nReplaced); }
    public Expression getStudentExpr() { return studentExpr; }

    @Override
    public NodeCount getTreeSize() {
        if (studentExpr == null)
            return new NodeCount(0, nodesReplaced);
        else
            return studentExpr.getTreeSize();
    }

    @Override
    public ReturnValues evaluate(Context c) throws MiniJASTException {
        if (studentExpr == null)
            throw new BlankEmptyException();
        else
            return studentExpr.evaluate(c);
    }

    @Override
    public String stringRepr() {
        if (studentExpr == null)
            return SHOWIDS ? "..(" + getId() + ").." : "...";
        else
            return studentExpr.stringRepr();
    }

    @Override
    public void empty() {
        studentExpr = null;
    }
}
