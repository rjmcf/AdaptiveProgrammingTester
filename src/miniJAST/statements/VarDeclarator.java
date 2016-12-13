package miniJAST.statements;

import miniJAST.expressions.Expression;

public class VarDeclarator {
    private String name;
    private Expression expr;
    protected boolean isArray = false;

    public void setUp(String n, Expression e) { name = n; expr = e; }

    public String getName() { return name; }
    public Expression getExpr() { return expr; }
}
