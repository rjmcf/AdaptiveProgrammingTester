package miniJAST;

public class GenExpr extends MiniJASTNode {
    private String expr;

    private String getExpr() { return expr; }

    public GenExpr(String e, boolean b) { super(b); expr = e; }
}
