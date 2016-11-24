package miniJAST;

public class ExprSequence extends MiniJASTNode {
    private MiniJASTNode part1;
    private MiniJASTNode part2;

    public ExprSequence(MiniJASTNode p1, MiniJASTNode p2, boolean b) { super(b); part1 = p1; part2 = p2; }

    public MiniJASTNode getPart1() { return part1; }
    public MiniJASTNode getPart2() { return part2; }
}
