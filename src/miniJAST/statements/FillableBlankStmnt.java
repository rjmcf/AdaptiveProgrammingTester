package miniJAST.statements;

import miniJAST.Context;
import miniJAST.FillableBlank;
import miniJAST.MiniJASTNode;
import miniJAST.NodeCount;
import miniJAST.exceptions.BlankEmptyException;
import miniJAST.exceptions.MiniJASTException;

import java.util.ArrayList;

public class FillableBlankStmnt extends FillableBlank implements BlockStatement {
    BlockStatement studentStmnt;

    public void setStudentStmnt(BlockStatement sS) { studentStmnt = sS; }
    public boolean isFilled() { return studentStmnt != null; }
    @Override
    public boolean getIsLeaf() { return false; }
    @Override
    public boolean getIsMarked() { return false; }
    @Override
    public void setMarked(boolean b) { }
    @Override
    public void setIsLeaf(boolean b) { }
    @Override
    public ArrayList<? extends MiniJASTNode> getSubNodes() { return null; }

    public FillableBlankStmnt(int nReplaced) { super(nReplaced); }
    public BlockStatement getStudentStmnt() { return studentStmnt; }

    @Override
    public FlowControl execute(Context c, int depth) throws MiniJASTException {
        if (studentStmnt == null)
            throw new BlankEmptyException();
        else
            return studentStmnt.execute(c, depth);
    }

    @Override
    public FlowControl executeStart(Context c) throws MiniJASTException {
        if (studentStmnt == null)
            throw new BlankEmptyException();
        else
            return studentStmnt.executeStart(c);
    }

    @Override
    public NodeCount getTreeSize() {
        if (studentStmnt == null)
            return new NodeCount(0, nodesReplaced);
        else
            return studentStmnt.getTreeSize();
    }

    @Override
    public String stringRepr(int blocksDeep) {
        if (studentStmnt == null)
            return pad(blocksDeep) + "..(" + getId() + ")..";
        else
            return studentStmnt.stringRepr(blocksDeep);
    }

    private String pad(int count) {
        return new String(new char[count]).replace("\0", "    ");
    }
}
