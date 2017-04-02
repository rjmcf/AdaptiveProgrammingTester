package miniJAST.statements;

import miniJAST.Context;
import miniJAST.MiniJASTNode;
import miniJAST.exceptions.MiniJASTException;

public interface BlockStatement extends MiniJASTNode{
    FlowControl execute(Context c, int depth) throws MiniJASTException;
    FlowControl executeStart(Context c) throws MiniJASTException;
    String stringRepr(int blocksDeep);
}
