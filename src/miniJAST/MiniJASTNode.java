package miniJAST;

public interface MiniJASTNode {
    NodeCount getTreeSize();
    boolean fillBlank(int blankId, MiniJASTNode replacement);
}
