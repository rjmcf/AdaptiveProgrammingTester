package miniJAST;

public class IfASTNode extends MiniJASTNode {
    private BoolExpr expr;
    private MiniJASTNode statement;

    public BoolExpr getBExpr() { return expr; }
    public MiniJASTNode getStatement() { return statement; }

    public IfASTNode(BoolExpr e, MiniJASTNode s, boolean b) { super(b); expr = e; statement = s; }
}
