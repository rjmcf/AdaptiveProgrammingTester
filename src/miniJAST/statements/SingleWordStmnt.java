package miniJAST.statements;

import miniJAST.Context;

public enum SingleWordStmnt implements StmntNoTrailSubstmnt{
    EMPTY{
        @Override
        public FlowControl execute(Context c) throws Exception {
            return FlowControl.NONE;
        }
    },
    BREAK {
        @Override
        public FlowControl execute(Context c) throws Exception {
            return FlowControl.BREAK;
        }
    },
    CONTINUE {
        @Override
        public FlowControl execute(Context c) throws Exception {
            return FlowControl.CONTINUE;
        }
    },
    RETURN {
        @Override
        public FlowControl execute(Context c) throws Exception {
            return FlowControl.RETURN;
        }
    }
}
