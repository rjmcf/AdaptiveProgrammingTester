package miniJAST;

import java.util.ArrayList;

public interface MiniJASTNode {
    NodeCount getTreeSize();
    boolean fillBlank(int blankId, MiniJASTNode replacement);
    boolean getIsLeaf();
    boolean getIsMarked();
    void setIsLeaf(boolean b);
    void setMarked(boolean b);
    ArrayList<? extends MiniJASTNode> getSubNodes();
    // TODO fix the stringRep situation. :-/ Make sure FillableBlanks still print correctly
}
