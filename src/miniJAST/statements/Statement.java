package miniJAST.statements;

import miniJAST.Context;
import miniJAST.MiniJASTNode;
import miniJAST.exceptions.MiniJASTException;

public interface Statement extends MiniJASTNode{
    FlowControl execute(Context c) throws MiniJASTException;
    String stringRepr(int blocksDeep);
}
