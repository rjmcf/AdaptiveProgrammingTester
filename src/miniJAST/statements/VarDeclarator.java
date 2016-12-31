package miniJAST.statements;

import miniJAST.NodeCount;
import miniJAST.expressions.Expression;

public class VarDeclarator {
    protected String name;
    private Expression expr;
    protected boolean isArray = false;

    public void setUpVarDec(String n, Expression e) { name = n; expr = e; }

    public NodeCount getTreeSize() {
        NodeCount result = expr.getTreeSize();
        result.filled++;
        return result;
    }

    public String getName() { return name; }
    public Expression getExpr() { return expr; }
}
