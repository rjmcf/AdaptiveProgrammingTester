package miniJAST;

public class AssignExpr extends MiniJASTNode {
    private String var;
    private MiniJASTNode expr;

    public String getVar() { return var; }
    public MiniJASTNode getExpr() { return expr; }

    public AssignExpr(String v, MiniJASTNode e, boolean b) { super(b); var = v; expr = e; }

}
