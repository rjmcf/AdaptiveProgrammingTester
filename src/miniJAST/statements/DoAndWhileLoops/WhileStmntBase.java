package miniJAST.statements.DoAndWhileLoops;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.Expression;
import miniJAST.statements.BlockStatement;
import miniJAST.statements.FlowControl;

public abstract class WhileStmntBase extends CondLoopBase {
    @Override
    public String stringRepr(int blocksDeep) {
        return pad(blocksDeep) + "while (" + ((Expression)subNodes.get(cond)).stringRepr() + ") \n" +
                ((BlockStatement)subNodes.get(stmnt)).stringRepr(blocksDeep + 1);
    }

    @Override
    public FlowControl execute(Context c, int d) throws MiniJASTException {
        return condAndLoop(c, d);
    }
}
