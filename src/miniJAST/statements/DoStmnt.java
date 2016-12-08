package miniJAST.statements;

import miniJAST.Context;
import miniJAST.expressions.Expression;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.types.UnannType;

public class DoStmnt implements StmntNoTrailSubstmnt{
    private Statement stmnt;
    private Expression cond;

    @Override
    public FlowControl execute(Context c) throws Exception {
        stmnt.execute(c);
        ReturnValues rCond = cond.evaluate(c);
        if (rCond.getType().uType != UnannType.BOOLEAN)
            throw new Exception("Condition does not have boolean type");

        loop:
        while(((ReturnValuesBool)rCond).value) {
            FlowControl fc = stmnt.execute(c);
            switch (fc) {
                case BREAK:
                    break loop;
                case CONTINUE:
                    continue loop;
                case RETURN:
                    return fc;
            }
            rCond = cond.evaluate(c);
        }

        return FlowControl.NONE;
    }
}
