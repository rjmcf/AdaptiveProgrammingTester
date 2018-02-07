package miniJAST.statements.DoAndWhileLoops;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.Expression;
import miniJAST.statements.*;

public class DoStmnt extends CondLoopBase {
    public void setUpDo(Statement s, Expression c) { baseSetUpCondLoop(c, s); }

    @Override
    public String stringRepr(int blocksDeep) {
        return pad(blocksDeep) + "do \n" + ((Statement)subNodes.get(stmnt)).stringRepr(blocksDeep+1) +
                " while (" + ((Expression)subNodes.get(cond)).stringRepr() + ")";
    }

    @Override
    public FlowControl execute(Context c) throws MiniJASTException {
        stepIn(c);
        ((Statement)subNodes.get(stmnt)).execute(c);
        stepOut(c);
        return condAndLoop(c);
    }
}
