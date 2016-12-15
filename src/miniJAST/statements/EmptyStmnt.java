package miniJAST.statements;

import miniJAST.Context;
import miniJAST.statements.ForLoops.ForInit;

public class EmptyStmnt extends ForInit implements StmntNoTrailSubstmnt {
    @Override
    public FlowControl execute(Context c) {
        return FlowControl.NONE;
    }
}
