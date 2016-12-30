package miniJAST.statements;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;

public interface BlockStatement {
    FlowControl execute(Context c, int depth) throws MiniJASTException;
    FlowControl executeStart(Context c) throws MiniJASTException;
    int getSubNodes();
}
