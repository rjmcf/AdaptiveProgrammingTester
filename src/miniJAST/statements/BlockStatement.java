package miniJAST.statements;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;

public interface BlockStatement {
    FlowControl execute(Context c, int depth) throws MiniJASTException;
}
