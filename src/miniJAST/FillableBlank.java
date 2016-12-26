package miniJAST;

import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.statements.FlowControl;
import miniJAST.statements.StmntNoTrailSubstmnt;

public class FillableBlank extends Expression implements StmntNoTrailSubstmnt  {
    private int nodesReplaced;

    public FillableBlank(int n) { nodesReplaced = n; }

    @Override
    public FlowControl execute(Context c, int depth) throws MiniJASTException {
        return null;
    }

    @Override
    public FlowControl executeStart(Context c) throws MiniJASTException {
        return null;
    }

    @Override
    public ReturnValues evaluate(Context c) throws MiniJASTException {
        return null;
    }

    @Override
    public int getSubNodes() {
        return nodesReplaced - 1;
    }
}
