package miniJAST.statements.LVD;

import miniJAST.Context;
import miniJAST.exceptions.IncorrectEvaluationException;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.Expression;
import miniJAST.statements.BlockStatement;
import miniJAST.statements.FlowControl;
import miniJAST.statements.StatementBase;
import miniJAST.types.UnannType;

public class VarDeclarator extends StatementBase implements BlockStatement{
    protected String name;
    private int expr;
    protected boolean isArray = false;

    public void setUpVarDec(String n, Expression e) { subNodes.clear(); name = n; expr = 0; subNodes.add(e); }

    public String getName() { return name; }
    public Expression getExpr() { return (Expression)subNodes.get(expr); }

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
        return name + (subNodes.get(expr) ==
                null ? "" : (" = " + ((Expression)subNodes.get(expr)).stringRepr()));
    }
}
