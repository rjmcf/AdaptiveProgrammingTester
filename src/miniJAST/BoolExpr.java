package miniJAST;

public class BoolExpr extends MiniJASTNode {
    private String expr;

    public String getExpr() { return expr; }

    public BoolExpr(String e, boolean b) { super(b); expr = e; }
}
