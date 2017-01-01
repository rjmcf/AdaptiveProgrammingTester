package miniJAST.statements.DoAndWhileLoops;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.statements.BlockStatement;
import miniJAST.statements.FlowControl;
import miniJAST.statements.StatementBase;
import miniJAST.types.UnannType;

public abstract class WhileStmntBase extends CondLoopBase implements BlockStatement {
    @Override
    public String stringRepr(int blocksDeep) {
        return pad(blocksDeep) + "while (" + cond.stringRepr() + ") \n" + stmnt.stringRepr(blocksDeep + 1);
    }

    @Override
    public FlowControl execute(Context c, int d) throws MiniJASTException {
        return condAndLoop(c, d);
    }
}
