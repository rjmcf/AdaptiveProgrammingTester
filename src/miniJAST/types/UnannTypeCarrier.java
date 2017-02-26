package miniJAST.types;

import miniJAST.MiniJASTNode;
import miniJAST.NodeCount;

import java.util.ArrayList;

public class UnannTypeCarrier implements MiniJASTNode {

    public UnannType type;

    public UnannTypeCarrier(UnannType t) { type = t; }

    @Override
    public NodeCount getTreeSize() {
        return null;
    }

    @Override
    public boolean getIsLeaf() {
        return false;
    }

    @Override
    public boolean getIsMarked() {
        return false;
    }

    @Override
    public void setIsLeaf(boolean b) {

    }

    @Override
    public void setMarked(boolean b) {

    }

    @Override
    public ArrayList<? extends MiniJASTNode> getSubNodes() {
        return null;
    }
}
