package miniJAST.statements.LVD;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.Expression;
import miniJAST.statements.BlockStatement;
import miniJAST.statements.FlowControl;
import miniJAST.statements.StatementBase;
import miniJAST.types.UnannType;

public class VarDeclarator extends StatementBase implements BlockStatement{
    protected String name;
    private Expression expr;
    protected boolean isArray = false;

    public void setUpVarDec(String n, Expression e) { name = n; expr = e; subNodes.add(e); }

    public String getName() { return name; }
    public Expression getExpr() { return expr; }
    public String stringRepr(UnannType t) { return name + (expr == null ? "" : (" = " + expr.stringRepr())); }

    @Override
    public FlowControl execute(Context c, int depth) throws MiniJASTException {
        return null;
    }

    @Override
    public FlowControl executeStart(Context c) throws MiniJASTException {
        return null;
    }

    @Override
    public String stringRepr(int blocksDeep) {
        return null;
    }
}
