package miniJAST.statements.LVD;

import miniJAST.Context;
import miniJAST.exceptions.IncorrectEvaluationException;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.Expression;
import miniJAST.statements.BlockStatement;
import miniJAST.statements.FlowControl;
import miniJAST.statements.StatementBase;

public class VarDeclarator extends StatementBase {
    protected String name;
    private int expr;
    protected boolean isArray = false;
    private boolean hasExpr;

    public void setUpVarDec(String n, Expression e) {
        subNodes.clear();
        name = n;
        expr = 0;
        if (e == null) {
            hasExpr = false;
        } else {
            hasExpr = true;
            subNodes.add(e);
        }
    }

    public String getName() { return name; }
    public Expression getExpr() { return hasExpr ? (Expression)subNodes.get(expr) : null; }

    @Override
    public FlowControl execute(Context c, int depth) throws MiniJASTException {
        throw new IncorrectEvaluationException("Should not be executing a VarDeclarator");
    }

    @Override
    public FlowControl executeStart(Context c) throws MiniJASTException {
        throw new IncorrectEvaluationException("Should not be executing a VarDeclarator");
    }

    @Override
    public String stringRepr(int blocksDeep) {
        return name + (hasExpr ? (" = " + ((Expression)subNodes.get(expr)).stringRepr()) : "");
    }
}
