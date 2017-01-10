package miniJAST.statements;

import miniJAST.Context;
import miniJAST.MiniJASTNode;
import miniJAST.NodeCount;
import miniJAST.exceptions.MiniJASTException;

import java.util.ArrayList;

public class Block extends StatementBase implements StmntNoTrailSubstmnt {
    boolean isOuterMost;

    public Block(boolean isOuter) { isOuterMost = isOuter; }
    public void addBlockStmnt(BlockStatement b) { subNodes.add(b); }

    @Override
    public String stringRepr(int blocksDeep) {
        String result = pad(blocksDeep-1) + "{\n";
        for (MiniJASTNode s : subNodes)
            result += ((BlockStatement)s).stringRepr(blocksDeep) + "\n";
        result += pad(blocksDeep-1) + "}";
        return result;
    }

    @Override
    public FlowControl execute(Context c, int d) throws MiniJASTException{
        for (MiniJASTNode b : subNodes) {
            checkType((BlockStatement)b, BlockStatement.class);

            FlowControl fc = ((BlockStatement)b).execute(c, isOuterMost ? d : d+1);
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
