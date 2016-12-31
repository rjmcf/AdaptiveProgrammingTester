package miniJAST.statements;

import miniJAST.Context;
import miniJAST.NodeCount;
import miniJAST.exceptions.MiniJASTException;

public enum SingleWordStmnt implements StmntNoTrailSubstmnt{
    EMPTY {
        @Override
        public NodeCount getTreeSize() { return new NodeCount(1,0); }

        @Override
        public String stringRepr() { return ";"; }

        @Override
        public FlowControl execute(Context c, int d) {
            return FlowControl.NONE;
        }

        @Override
        public FlowControl executeStart(Context c) throws MiniJASTException { return FlowControl.NONE; }
    },
    BREAK {
        @Override
        public NodeCount getTreeSize() { return new NodeCount(1,0); }

        @Override
        public String stringRepr() { return "break;"; }

        @Override
        public FlowControl execute(Context c, int d) {
            return FlowControl.BREAK;
        }

        @Override
        public FlowControl executeStart(Context c) throws MiniJASTException { return FlowControl.BREAK; }
    },
    CONTINUE {
        @Override
        public NodeCount getTreeSize() { return new NodeCount(1,0); }

        @Override
        public String stringRepr() { return "continue;"; }

        @Override
        public FlowControl execute(Context c, int d) {
            return FlowControl.CONTINUE;
        }

        @Override
        public FlowControl executeStart(Context c) throws MiniJASTException { return FlowControl.CONTINUE; }
    },
    RETURN {
        @Override
        public NodeCount getTreeSize() { return new NodeCount(1,0); }

        @Override
        public String stringRepr() { return "return;"; }

        @Override
        public FlowControl execute(Context c, int d) {
            return FlowControl.RETURN;
        }

        @Override
        public FlowControl executeStart(Context c) throws MiniJASTException { return FlowControl.RETURN; }
    }
}
