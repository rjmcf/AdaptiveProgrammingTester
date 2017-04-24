package miniJAST.statements;

import miniJAST.Context;
import miniJAST.MiniJASTNode;
import miniJAST.NodeCount;
import miniJAST.exceptions.MiniJASTException;

import java.util.ArrayList;

public enum SingleWordStmnt implements BlockStatement{
    EMPTY {
        @Override
        public NodeCount getTreeSize() { return new NodeCount(1,0); }

        @Override
        public boolean getIsLeaf() { return true; }

        @Override
        public ArrayList<? extends MiniJASTNode> getSubNodes() { return null; }

        @Override
        public String stringRepr(int blocksDeep) { return pad(blocksDeep) + ";"; }

        protected String pad(int count) {
            return new String(new char[count]).replace("\0", "    ");
        }

        @Override
        public FlowControl execute(Context c) {
            return FlowControl.NONE;
        }
    },
    BREAK {
        @Override
        public NodeCount getTreeSize() { return new NodeCount(1,0); }

        @Override
        public boolean getIsLeaf() { return true; }

        @Override
        public ArrayList<? extends MiniJASTNode> getSubNodes() { return null; }

        @Override
        public String stringRepr(int blocksDeep) { return pad(blocksDeep) + "break;"; }

        protected String pad(int count) {
            return new String(new char[count]).replace("\0", "    ");
        }

        @Override
        public FlowControl execute(Context c) {
            return FlowControl.BREAK;
        }
    },
    CONTINUE {
        @Override
        public NodeCount getTreeSize() { return new NodeCount(1,0); }

        @Override
        public boolean getIsLeaf() { return true; }

        @Override
        public ArrayList<? extends MiniJASTNode> getSubNodes() { return null; }

        @Override
        public String stringRepr(int blocksDeep) { return pad(blocksDeep) + "continue;"; }

        protected String pad(int count) {
            return new String(new char[count]).replace("\0", "    ");
        }

        @Override
        public FlowControl execute(Context c) {
            return FlowControl.CONTINUE;
        }
    },
    RETURN {
        @Override
        public NodeCount getTreeSize() { return new NodeCount(1,0); }

        @Override
        public boolean getIsLeaf() { return true; }

        @Override
        public ArrayList<? extends MiniJASTNode> getSubNodes() { return null; }

        @Override
        public String stringRepr(int blocksDeep) { return pad(blocksDeep) + "return;"; }

        protected String pad(int count) {
            return new String(new char[count]).replace("\0", "    ");
        }

        @Override
        public FlowControl execute(Context c) {
            return FlowControl.RETURN;
        }
    }
}
