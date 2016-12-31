package miniJAST.statements;

import miniJAST.Context;
import miniJAST.NodeCount;
import miniJAST.exceptions.MiniJASTException;

public interface BlockStatement {
    FlowControl execute(Context c, int depth) throws MiniJASTException;
    FlowControl executeStart(Context c) throws MiniJASTException;
    NodeCount getTreeSize();
    String stringRepr();
}
