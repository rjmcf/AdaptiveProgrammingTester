package miniJAST.statements;

import miniJAST.Context;
import miniJAST.FillableBlank;
import miniJAST.MiniJASTNode;
import miniJAST.NodeCount;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.FillableBlankExpr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public abstract class StatementBase implements MiniJASTNode {
    protected ArrayList<MiniJASTNode> subNodes = new ArrayList<>();
    @Override
    public ArrayList<MiniJASTNode> getSubNodes() { return subNodes; }
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
    protected void removeDecsAtDepth(Context c, int d) {
        if (d == 0)
            return;
        Iterator<String> nTDs = c.namesToDepths.keySet().iterator();
        Iterator<String> nTVs = c.namesToValues.keySet().iterator();
        Iterator<String> nTTs = c.namesToTypes.keySet().iterator();
        while (nTDs.hasNext()) {
            nTVs.next();
            nTTs.next();
            if (c.namesToDepths.get(nTDs.next()) >= d) {
                nTVs.remove();
                nTTs.remove();
                nTDs.remove();
            }
        }
    }

    @Override
    public NodeCount getTreeSize() {
        NodeCount current, result = new NodeCount();

        for (MiniJASTNode e : subNodes) {
            current = e.getTreeSize();
            result.filled += current.filled;
            result.empty += current.empty;
        }
        result.filled++;
        return result;
    }

    protected void checkType(Expression e, Class<? extends Expression> c) throws MiniJASTException {
        if (e == null)
            return;

        if (e instanceof FillableBlankExpr) {
            if (!((FillableBlankExpr) e).isFilled())
                e.evaluate(new Context());
            else
                return;
        }

        if (!(c.isInstance(e)))
            throw new TypeException("expected " + c.getName() + " but found " + e.getClass().getName());
    }

    protected void checkType(BlockStatement e, Class<? extends BlockStatement> c) throws MiniJASTException {
        if (e == null)
            return;

        if (e instanceof FillableBlankStmnt) {
            if (!((FillableBlankStmnt) e).isFilled())
                e.executeStart(new Context());
            else
                return;
        }

        if (!(c.isInstance(e)))
            throw new TypeException("expected " + c.getName() + " but found " + e.getClass().getName());
    }

    protected String pad(int count) {
        return new String(new char[count]).replace("\0", "    ");
    }
}
