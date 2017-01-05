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

public abstract class CondLoopBase extends StatementBase implements BlockStatement{
    protected Expression cond;
    protected BlockStatement stmnt;

    protected void baseSetUpCondLoop(Expression c, BlockStatement s) { cond = c; stmnt = s; subNodes.add(c); subNodes.add(s); }

    protected FlowControl condAndLoop(Context c, int d) throws MiniJASTException {
        checkType(cond, Expression.class);
        checkType(stmnt, BlockStatement.class);

        ReturnValues rC = cond.evaluate(c);
        if (rC.getType().uType != UnannType.BOOLEAN)
            throw new TypeException("Condition must be boolean type");
        if (rC.getIsArray())
            throw new TypeException("Can not operate on arrays!");

        loop:
        while (((ReturnValuesBool)rC).value) {
            FlowControl fC = stmnt.execute(c, d+1);
            removeDecsAtDepth(c, d+1);
            switch (fC) {
                case BREAK:
                    break loop;
                case CONTINUE:
                    continue loop;
                case RETURN:
                    return fC;
            }
            rC = cond.evaluate(c);
        }

        return FlowControl.NONE;
    }

    @Override
    public FlowControl executeStart(Context c) throws MiniJASTException {
        return execute(c, 0);
    }
}
