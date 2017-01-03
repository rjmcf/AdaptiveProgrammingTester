package miniJAST.statements;

import miniJAST.Context;
import miniJAST.NodeCount;
import miniJAST.exceptions.BlankEmptyException;
import miniJAST.exceptions.MiniJASTException;

public class FillableBlankStmnt extends StatementBase implements StmntNoTrailSubstmnt {
    int nodesReplaced;
    BlockStatement studentStmnt;

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
        return "...";
    }
}
