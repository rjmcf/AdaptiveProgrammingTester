package miniJAST.statements;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.StatementExpr;

public class ExpressionStmnt extends StatementBase implements StmntNoTrailSubstmnt {
    private int expr;

    public ExpressionStmnt(Expression sE) { subNodes.clear(); expr = 0; subNodes.add(sE); }

    @Override
    public FlowControl execute(Context c, int depth) throws MiniJASTException {
        checkType((Expression)subNodes.get(expr), StatementExpr.class);
        ((Expression)subNodes.get(expr)).evaluate(c);
        return FlowControl.NONE;
    }

    @Override
    public FlowControl executeStart(Context c) throws MiniJASTException {
        return execute(c, 0);
    }

    @Override
    public String stringRepr(int blocksDeep) {
        return pad(blocksDeep) +  ((Expression)subNodes.get(expr)).stringRepr() + ";";
    }
}
