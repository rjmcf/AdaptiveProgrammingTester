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
        NodeCount result = new NodeCount();
        for (MiniJASTNode e : subNodes) {
            result.filled += e.getTreeSize().filled;
            result.empty += e.getTreeSize().empty;
        }
        result.filled++;
        return result;
    }

    protected void checkType(Expression e, Class<? extends Expression> c) throws MiniJASTException {
        if (e == null)
            return;

        if (e instanceof FillableBlankExpr)
            e.evaluate(new Context());

        if (!(c.isInstance(e)))
            throw new TypeException("expected " + c.getName() + " but found " + e.getClass().getName());
    }

    protected void checkType(BlockStatement e, Class<? extends BlockStatement> c) throws MiniJASTException {
        if (e == null)
            return;

        if (e instanceof FillableBlankStmnt)
            e.executeStart(new Context());

        if (!(c.isInstance(e)))
            throw new TypeException("expected " + c.getName() + " but found " + e.getClass().getName());
    }

    @Override
    public boolean fillBlank(int blankId, MiniJASTNode replacement) {
        ListIterator<MiniJASTNode> it = subNodes.listIterator();
        while (it.hasNext()){
            MiniJASTNode sNode = it.next();
            if (sNode instanceof FillableBlank) {
                if (((FillableBlank)sNode).getId() == blankId) {
                    it.set(replacement);
                    return true;
                }
            } else {
                if (sNode.fillBlank(blankId, replacement))
                    return true;
            }
        }
        return false;
    }

    protected String pad(int count) {
        return new String(new char[count]).replace("\0", "    ");
    }
}
