package miniJAST.statements;

import miniJAST.Context;
import miniJAST.MiniJASTNode;
import miniJAST.NodeCount;
import miniJAST.exceptions.MiniJASTException;

import java.util.ArrayList;

public enum SingleWordStmnt implements StmntNoTrailSubstmnt{
    EMPTY {
        @Override
        public NodeCount getTreeSize() { return new NodeCount(1,0); }

        @Override
        public boolean getIsLeaf() { return true; }

        @Override
        public boolean getIsMarked() { return false; }

        @Override
        public void setIsLeaf(boolean b) { }

        @Override
        public void setMarked(boolean b) { }

        @Override
        public ArrayList<? extends MiniJASTNode> getSubNodes() { return null; }

        @Override
        public String stringRepr(int blocksDeep) { return pad(blocksDeep) + ";"; }

        protected String pad(int count) {
            return new String(new char[count]).replace("\0", "    ");
        }

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
        public boolean getIsLeaf() { return true; }

        @Override
        public boolean getIsMarked() { return false; }

        @Override
        public void setIsLeaf(boolean b) { }

        @Override
        public void setMarked(boolean b) { }

        @Override
        public ArrayList<? extends MiniJASTNode> getSubNodes() { return null; }

        @Override
        public String stringRepr(int blocksDeep) { return pad(blocksDeep) + "break;"; }

        protected String pad(int count) {
            return new String(new char[count]).replace("\0", "    ");
        }

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
        public boolean getIsLeaf() { return true; }

        @Override
        public boolean getIsMarked() { return false; }

        @Override
        public void setIsLeaf(boolean b) { }

        @Override
        public void setMarked(boolean b) { }

        @Override
        public ArrayList<? extends MiniJASTNode> getSubNodes() { return null; }

        @Override
        public String stringRepr(int blocksDeep) { return pad(blocksDeep) + "continue;"; }

        protected String pad(int count) {
            return new String(new char[count]).replace("\0", "    ");
        }

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
        public boolean getIsLeaf() { return true; }

        @Override
        public boolean getIsMarked() { return false; }

        @Override
        public void setIsLeaf(boolean b) { }

        @Override
        public void setMarked(boolean b) { }

        @Override
        public ArrayList<? extends MiniJASTNode> getSubNodes() { return null; }

        @Override
        public String stringRepr(int blocksDeep) { return pad(blocksDeep) + "return;"; }

        protected String pad(int count) {
            return new String(new char[count]).replace("\0", "    ");
        }

        @Override
        public FlowControl execute(Context c, int d) {
            return FlowControl.RETURN;
        }

        @Override
        public FlowControl executeStart(Context c) throws MiniJASTException { return FlowControl.RETURN; }
    }
}
