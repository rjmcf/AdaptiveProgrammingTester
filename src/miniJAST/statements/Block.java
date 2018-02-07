package miniJAST.statements;

import miniJAST.Context;
import miniJAST.MiniJASTNode;
import miniJAST.exceptions.MiniJASTException;

public class Block extends StatementBase {
    boolean isOuterMost;

    public Block(boolean isOuter) { isOuterMost = isOuter; }
    public void addBlockStmnt(Statement b) { subNodes.add(b); }

    @Override
    public String stringRepr(int blocksDeep) {
        String result = pad(blocksDeep-1) + "{\n";
        for (MiniJASTNode s : subNodes)
            result += ((Statement)s).stringRepr(blocksDeep) + "\n";
        result += pad(blocksDeep-1) + "}";
        return result;
    }

    @Override
    public FlowControl execute(Context c) throws MiniJASTException{
        if (!isOuterMost)
            stepIn(c);
        for (MiniJASTNode b : subNodes) {
            checkType((Statement)b, Statement.class);

            FlowControl fc = ((Statement)b).execute(c);
            switch (fc) {
                case NONE:
                    break;
                default:
                    return fc;
            }
        }

        if (!isOuterMost)
            stepOut(c);
        return FlowControl.NONE;
    }
}
