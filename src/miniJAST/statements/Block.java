package miniJAST.statements;

import miniJAST.Context;
import miniJAST.NodeCount;
import miniJAST.exceptions.MiniJASTException;

import java.util.ArrayList;

public class Block extends StatementBase implements StmntNoTrailSubstmnt {
    private ArrayList<BlockStatement> stmnts;
    boolean isOuterMost;

    public Block(boolean isOuter) { stmnts = new ArrayList<>(); isOuterMost = isOuter; }
    public void addBlockStmnt(BlockStatement b) { stmnts.add(b); subNodes.add(b); }

    @Override
    public NodeCount getTreeSize() {
        NodeCount result = new NodeCount();
        for (BlockStatement s : stmnts)
            result.add(s.getTreeSize());
        result.filled++;
        return result;
    }

    @Override
    public String stringRepr(int blocksDeep) {
        String result = pad(blocksDeep-1) + "{ \n";
        for (BlockStatement s : stmnts)
            result += s.stringRepr(blocksDeep) + "\n";
        result += pad(blocksDeep-1) + "}";
        return result;
    }

    @Override
    public FlowControl execute(Context c, int d) throws MiniJASTException{
        for (BlockStatement b : stmnts) {
            FlowControl fc = b.execute(c, isOuterMost ? d : d+1);
            switch (fc) {
                case NONE:
                    break;
                default:
                    return fc;
            }
        }

        if (!isOuterMost)
            removeDecsAtDepth(c, d+1);
        return FlowControl.NONE;
    }

    @Override
    public FlowControl executeStart(Context c) throws MiniJASTException {
        return execute(c, 0);
    }
}
