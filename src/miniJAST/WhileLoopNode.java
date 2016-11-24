package miniJAST;

public class WhileLoopNode extends MiniJASTNode {
    private BoolExpr cond;
    private MiniJASTNode body;

    public WhileLoopNode(BoolExpr c, MiniJASTNode bo, boolean b) { super(b); cond = c; body = bo; }

    public BoolExpr getCond() { return cond; }
    public MiniJASTNode getBody() { return body; }
}
