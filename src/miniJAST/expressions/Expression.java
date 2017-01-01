package miniJAST.expressions;

import miniJAST.Context;
import miniJAST.NodeCount;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.returnValues.ReturnValues;

public interface Expression {
    ReturnValues evaluate(Context c) throws MiniJASTException;
    NodeCount getTreeSize();
    String stringRepr();
}
