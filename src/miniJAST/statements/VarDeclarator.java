package miniJAST.statements;

import miniJAST.expressions.Expression;

public class VarDeclarator {
    protected String name;
    private Expression expr;
    protected boolean isArray = false;

    public void setUpVarDec(String n, Expression e) { name = n; expr = e; }

    public int getSubNodes() {
        return expr.getSubNodes() + 1;
    }

    public String getName() { return name; }
    public Expression getExpr() { return expr; }
}
