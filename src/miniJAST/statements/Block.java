package miniJAST.statements;

import miniJAST.Context;

import java.util.ArrayList;

public class Block implements StmntNoTrailSubstmnt {
    private ArrayList<BlockStatement> stmnts;

    @Override
    public FlowControl execute(Context c) throws Exception{
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
