package miniJAST.statements;

import miniJAST.Context;
import miniJAST.FillableBlank;
import miniJAST.MiniJASTNode;
import miniJAST.NodeCount;
import miniJAST.exceptions.BlankEmptyException;
import miniJAST.exceptions.MiniJASTException;

import java.util.ArrayList;

public class FillableBlankStmnt extends FillableBlank implements Statement {
    Statement studentStmnt;

    public void setStudentStmnt(Statement sS) { studentStmnt = sS; }
    public boolean isFilled() { return studentStmnt != null; }
    @Override
    public boolean getIsLeaf() { return false; }
    @Override
    public ArrayList<? extends MiniJASTNode> getSubNodes() { return null; }

    public FillableBlankStmnt(int nReplaced) { super(nReplaced); }
    public Statement getStudentStmnt() { return studentStmnt; }

    @Override
    public FlowControl execute(Context c) throws MiniJASTException {
        if (studentStmnt == null)
            throw new BlankEmptyException();
        else
            return studentStmnt.execute(c);
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
            return pad(blocksDeep) + (SHOWIDS ? "..(" + getId() + ").." : ".....");
        else
            return studentStmnt.stringRepr(blocksDeep);
    }

    @Override
    public void empty() {
        studentStmnt = null;
    }

    private String pad(int count) {
        return new String(new char[count]).replace("\0", "    ");
    }
}
