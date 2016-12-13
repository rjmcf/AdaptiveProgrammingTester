package miniJAST.statements;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;

public interface StatementNoShortIf {
    FlowControl execute(Context c) throws MiniJASTException;
}
