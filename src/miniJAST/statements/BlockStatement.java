package miniJAST.statements;

import miniJAST.Context;

public interface BlockStatement {
    FlowControl execute(Context c) throws Exception;
}
