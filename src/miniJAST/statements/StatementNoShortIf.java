package miniJAST.statements;

import miniJAST.Context;

public interface StatementNoShortIf {
    FlowControl execute(Context c) throws Exception;
}
