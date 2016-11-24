package miniJAST;

public class ForLoopNode extends MiniJASTNode {
    private MiniJASTNode init;
    private BoolExpr cond;
    private MiniJASTNode between;
    private MiniJASTNode body;

    public ForLoopNode(MiniJASTNode i, BoolExpr c, MiniJASTNode be, MiniJASTNode bo, boolean b) {
        super(b);
        init = i;
        cond = c;
        between = be;
        body = bo;
    }

    public MiniJASTNode getInit() { return init; }
    public BoolExpr getCond() { return cond; }
    public MiniJASTNode getBetween() { return between; }
    public MiniJASTNode getBody() { return body; }
}
