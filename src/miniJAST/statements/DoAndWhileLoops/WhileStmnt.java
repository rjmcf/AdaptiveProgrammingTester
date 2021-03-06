package miniJAST.statements.DoAndWhileLoops;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.Expression;
import miniJAST.statements.Statement;
import miniJAST.statements.FlowControl;

public class WhileStmnt extends CondLoopBase {
    @Override
    public String stringRepr(int blocksDeep) {
        return pad(blocksDeep) + "while (" + ((Expression)subNodes.get(cond)).stringRepr() + ") \n" +
                ((Statement)subNodes.get(stmnt)).stringRepr(blocksDeep + 1);
    }

    @Override
    public FlowControl execute(Context c) throws MiniJASTException {
        return condAndLoop(c);
    }

    public void setUpWhile(Expression c, Statement s) { baseSetUpCondLoop(c, s); }
}
