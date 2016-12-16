package miniJAST.statements;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;

import java.util.ArrayList;

public class Block extends StatementBase implements StmntNoTrailSubstmnt {
    private ArrayList<BlockStatement> stmnts;

    public Block() { stmnts = new ArrayList<>(); }
    public void addBlockStmnt(BlockStatement b) { stmnts.add(b); }

    @Override
    public FlowControl execute(Context c, int d) throws MiniJASTException{
        for (BlockStatement b : stmnts) {
            FlowControl fc = b.execute(c, d+1);
            switch (fc) {
                case NONE:
                    break;
                default:
                    return fc;
            }
        }

        removeDecsAtDepth(c, d+1);
        return FlowControl.NONE;
    }
}
