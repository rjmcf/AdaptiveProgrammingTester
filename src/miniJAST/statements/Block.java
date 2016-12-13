package miniJAST.statements;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;

import java.util.ArrayList;

public class Block implements StmntNoTrailSubstmnt {
    private ArrayList<BlockStatement> stmnts;

    public Block() { stmnts = new ArrayList<>(); }
    public void addBlockStmnt(BlockStatement b) { stmnts.add(b); }

    @Override
    public FlowControl execute(Context c) throws MiniJASTException{
        for (BlockStatement b : stmnts) {
            FlowControl fc = b.execute(c);
            switch (fc) {
                case NONE:
                    break;
                default:
                    return fc;
            }
        }

        return FlowControl.NONE;
    }
}
