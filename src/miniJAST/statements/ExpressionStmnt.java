package miniJAST.statements;

import miniJAST.Context;
import miniJAST.NodeCount;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.StatementExpr;
import miniJAST.expressions.returnValues.ReturnValues;

public class ExpressionStmnt implements StmntNoTrailSubstmnt {
    private StatementExpr expr;

    public ExpressionStmnt(StatementExpr sE) { expr = sE; }

    @Override
    public FlowControl execute(Context c, int depth) throws MiniJASTException {
        expr.evaluate(c);
        return FlowControl.NONE;
    }

    @Override
    public FlowControl executeStart(Context c) throws MiniJASTException {
        expr.evaluate(c);
        return FlowControl.NONE;
    }

    @Override
    public NodeCount getTreeSize() {
        NodeCount count = expr.getTreeSize();
        count.filled++;
        return count;
    }

    @Override
    public String stringRepr() {
        return expr.stringRepr() + ";";
    }
}
