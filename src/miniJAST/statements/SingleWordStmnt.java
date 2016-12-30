package miniJAST.statements;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;

public enum SingleWordStmnt implements StmntNoTrailSubstmnt{
    EMPTY {
        @Override
        public int getSubNodes() { return 0; }

        @Override
        public FlowControl execute(Context c, int d) {
            return FlowControl.NONE;
        }

        @Override
        public FlowControl executeStart(Context c) throws MiniJASTException { return FlowControl.NONE; }
    },
    BREAK {
        @Override
        public int getSubNodes() { return 0; }

        @Override
        public FlowControl execute(Context c, int d) {
            return FlowControl.BREAK;
        }

        @Override
        public FlowControl executeStart(Context c) throws MiniJASTException { return FlowControl.BREAK; }
    },
    CONTINUE {
        @Override
        public int getSubNodes() { return 0; }

        @Override
        public FlowControl execute(Context c, int d) {
            return FlowControl.CONTINUE;
        }

        @Override
        public FlowControl executeStart(Context c) throws MiniJASTException { return FlowControl.CONTINUE; }
    },
    RETURN {
        @Override
        public int getSubNodes() { return 0; }

        @Override
        public FlowControl execute(Context c, int d) {
            return FlowControl.RETURN;
        }

        @Override
        public FlowControl executeStart(Context c) throws MiniJASTException { return FlowControl.RETURN; }
    }
}
