package miniJAST.expressions;

import miniJAST.Context;
import miniJAST.FillableBlank;
import miniJAST.MiniJASTNode;
import miniJAST.NodeCount;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.returnValues.ReturnValues;

import java.util.ArrayList;
import java.util.ListIterator;

public abstract class ExpressionBase implements Expression {
    protected ArrayList<Expression> subNodes = new ArrayList<>();
    public boolean getIsLeaf() { return subNodes.size() == 0; }
    @Override
    public abstract ReturnValues evaluate(Context c) throws MiniJASTException;
    @Override
    public NodeCount getTreeSize() {
        NodeCount result = new NodeCount();
        for (Expression e : subNodes) {
            result.filled += e.getTreeSize().filled;
            result.empty += e.getTreeSize().empty;
        }
        result.filled++;
        return result;
    }
    @Override
    public abstract String stringRepr();

    protected void checkType(Expression e, Class<? extends Expression> c) throws MiniJASTException {
        if (e instanceof FillableBlankExpr)
            e.evaluate(new Context());

        if (!(c.isInstance(e)))
            throw new TypeException("expected " + c.getName() + " but found " + e.getClass().getName());
    }

    @Override
    public boolean fillBlank(int blankId, MiniJASTNode replacement) {
        if (!(replacement instanceof Expression))
            return false;
        ListIterator<Expression> it = subNodes.listIterator();
        while (it.hasNext()){
            MiniJASTNode sNode = it.next();
            if (sNode instanceof FillableBlank) {
                if (((FillableBlank)sNode).getId() == blankId) {
                    it.set((Expression)replacement);
                    return true;
                }
            } else {
                if (sNode.fillBlank(blankId, replacement))
                    return true;
            }
        }
        return false;
    }
}
