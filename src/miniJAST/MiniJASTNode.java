package miniJAST;

public interface MiniJASTNode {
    NodeCount getTreeSize();
    boolean fillBlank(int blankId, MiniJASTNode replacement);
    boolean getIsLeaf();
    boolean getIsMarked();
    void setMarked(boolean b);
}
