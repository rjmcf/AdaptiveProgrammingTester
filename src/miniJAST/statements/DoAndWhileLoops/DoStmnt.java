package miniJAST.statements.DoAndWhileLoops;

import miniJAST.Context;
import miniJAST.NodeCount;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.statements.FlowControl;
import miniJAST.statements.Statement;
import miniJAST.statements.StatementBase;
import miniJAST.statements.StmntNoTrailSubstmnt;
import miniJAST.types.UnannType;

public class DoStmnt extends CondLoopBase implements StmntNoTrailSubstmnt {
    public void setUpDo(Statement s, Expression c) { baseSetUpCondLoop(c, s); }

    @Override
    public String stringRepr(int blocksDeep) {
        return pad(blocksDeep) + "do \n" + stmnt.stringRepr(blocksDeep+1) + " while (" + cond.stringRepr() + ")";
    }

    @Override
    public FlowControl execute(Context c, int d) throws MiniJASTException {
        stmnt.execute(c, d+1);
        removeDecsAtDepth(c, d+1);
        return condAndLoop(c, d);
    }
}
