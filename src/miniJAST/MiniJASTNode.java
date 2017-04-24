package miniJAST;

import java.util.ArrayList;

public interface MiniJASTNode {
    NodeCount getTreeSize();
    boolean getIsLeaf();
    ArrayList<? extends MiniJASTNode> getSubNodes();
    // TODO fix the stringRep situation. :-/ Make sure FillableBlanks still print correctly
}
