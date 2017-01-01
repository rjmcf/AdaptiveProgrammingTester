package miniJAST.statements.LVD;

import miniJAST.MiniJASTNode;
import miniJAST.NodeCount;
import miniJAST.expressions.Expression;
import miniJAST.statements.StatementBase;
import miniJAST.types.UnannType;

public class VarDeclarator extends StatementBase implements MiniJASTNode{
    protected String name;
    private Expression expr;
    protected boolean isArray = false;

    public void setUpVarDec(String n, Expression e) { name = n; expr = e; subNodes.add(e); }

    public String getName() { return name; }
    public Expression getExpr() { return expr; }
    public String stringRepr(UnannType t) { return name + (expr == null ? "" : (" = " + expr.stringRepr())); }
}
