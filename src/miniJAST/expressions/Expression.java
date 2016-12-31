package miniJAST.expressions;

import miniJAST.Context;
import miniJAST.NodeCount;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.returnValues.ReturnValues;

public abstract class Expression {
    public abstract ReturnValues evaluate(Context c) throws MiniJASTException;
    public NodeCount getTreeSize() { return new NodeCount(1,0); };
    public abstract String stringRepr();
}
