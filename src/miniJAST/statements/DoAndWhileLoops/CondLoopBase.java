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
import miniJAST.types.PrimType;

public abstract class CondLoopBase extends StatementBase {
    protected int cond;
    protected int stmnt;

    protected void baseSetUpCondLoop(Expression c, BlockStatement s) {
        subNodes.clear();
        subNodes.add(c); cond = 0;
        subNodes.add(s); stmnt = 1;
    }

    protected FlowControl condAndLoop(Context c) throws MiniJASTException {
        checkType((Expression)subNodes.get(cond), Expression.class);
        checkType((BlockStatement)subNodes.get(stmnt), BlockStatement.class);

        Expression condE = ((Expression)subNodes.get(cond));

        ReturnValues rC = condE.evaluate(c);
        if (rC.getType().uType != PrimType.BOOLEAN)
            throw new TypeException("Condition must be boolean type");
        if (rC.getIsArray())
            throw new TypeException("Can not operate on arrays!");

        loop:
        while (((ReturnValuesBool)rC).value) {
            stepIn(c);
            FlowControl fC = ((BlockStatement)subNodes.get(stmnt)).execute(c);
            stepOut(c);
            switch (fC) {
                case BREAK:
                    break loop;
                case CONTINUE:
                    continue loop;
                case RETURN:
                    return fC;
            }
            rC = condE.evaluate(c);
        }

        return FlowControl.NONE;
    }
}
