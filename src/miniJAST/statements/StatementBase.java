package miniJAST.statements;

import miniJAST.Context;
import miniJAST.FillableBlank;
import miniJAST.MiniJASTNode;
import miniJAST.NodeCount;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.FillableBlankExpr;
import miniJAST.types.Type;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class StatementBase implements Statement {
    protected ArrayList<MiniJASTNode> subNodes = new ArrayList<>();
    @Override
    public ArrayList<MiniJASTNode> getSubNodes() { return subNodes; }
    @Override
    public boolean getIsLeaf() {
        if (subNodes.size() == 0)
            return true;
        for (MiniJASTNode n : subNodes)
            if (!(n instanceof FillableBlank))
                return false;
        return true;
    }
    protected void stepIn(Context c) {
        HashMap<String, Type> newMap1 = new HashMap<>();
        HashMap<String, Object> newMap2 = new HashMap<>();
        for (String s : c.namesToTypes.peek().keySet())
            newMap1.put(s, c.namesToTypes.peek().get(s));
        c.namesToTypes.push(newMap1);
        for (String s : c.namesToValues.peek().keySet())
            newMap2.put(s, c.namesToValues.peek().get(s));
        c.namesToValues.push(newMap2);
    }
    protected void stepOut(Context c) {
        if (c.namesToTypes.size() == 1)
            return;

        c.namesToTypes.pop();
        HashMap<String, Object> oldMap = c.namesToValues.pop();
        for (String s : oldMap.keySet())
            if (c.namesToTypes.peek().containsKey(s))
                c.namesToValues.peek().put(s, oldMap.get(s));
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

    protected void checkType(Statement e, Class<? extends Statement> c) throws MiniJASTException {
        if (e == null)
            return;

        if (e instanceof FillableBlankStmnt) {
            if (!((FillableBlankStmnt) e).isFilled())
                e.execute(new Context());
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
