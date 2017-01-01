package miniJAST.expressions;

import miniJAST.Context;
import miniJAST.NodeCount;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.returnValues.ReturnValues;

import java.util.ArrayList;

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
}
