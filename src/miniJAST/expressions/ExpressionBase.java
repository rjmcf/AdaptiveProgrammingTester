package miniJAST.expressions;

import miniJAST.Context;
import miniJAST.NodeCount;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.returnValues.ReturnValues;

import java.util.ArrayList;

public abstract class ExpressionBase implements Expression {
    protected ArrayList<Expression> subNodes = new ArrayList<>();
    @Override
    public ArrayList<Expression> getSubNodes() { return subNodes; }
    private boolean isLeaf;
    @Override
    public boolean getIsLeaf() {
        if (!isLeaf)
            isLeaf = subNodes.size() == 0;
        return isLeaf;
    }
    @Override
    public void setIsLeaf(boolean b) { isLeaf = b; }
    private boolean isMarked = false;
    @Override
    public boolean getIsMarked() { return isMarked; }
    @Override
    public void setMarked(boolean b) { isMarked = b; }
    @Override
    public abstract ReturnValues evaluate(Context c) throws MiniJASTException;
    @Override
    public NodeCount getTreeSize() {
        NodeCount current, result = new NodeCount();
        for (Expression e : subNodes) {
            current = e.getTreeSize();
            result.filled += current.filled;
            result.empty += current.empty;
        }
        result.filled++;
        return result;
    }

    protected void checkType(Expression e, Class<? extends Expression> c) throws MiniJASTException {
        if (e instanceof FillableBlankExpr) {
            if (!((FillableBlankExpr) e).isFilled())
                e.evaluate(new Context());
            else
                return;
        }

        if (!(c.isInstance(e)))
            throw new TypeException("expected " + c.getName() + " but found " + e.getClass().getName());
    }
}
