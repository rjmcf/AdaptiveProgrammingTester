package miniJAST.statements;

import miniJAST.Context;

public enum SingleWordStmnt implements StmntNoTrailSubstmnt{
    BREAK {
        @Override
        public FlowControl execute(Context c) {
            return FlowControl.BREAK;
        }
    },
    CONTINUE {
        @Override
        public FlowControl execute(Context c) {
            return FlowControl.CONTINUE;
        }
    },
    RETURN {
        @Override
        public FlowControl execute(Context c) {
            return FlowControl.RETURN;
        }
    }
}
