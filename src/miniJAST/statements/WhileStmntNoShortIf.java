package miniJAST.statements;

import miniJAST.Context;
import miniJAST.expressions.Expression;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.types.UnannType;

public class WhileStmntNoShortIf implements StatementNoShortIf {
    private Expression cond;
    private StatementNoShortIf stmnt;

    @Override
    public FlowControl execute(Context c) throws Exception {
        ReturnValues rC = cond.evaluate(c);
        if (rC.getType().uType != UnannType.BOOLEAN)
            throw new Exception("Condition must be boolean type");

        loop:
        while (((ReturnValuesBool)rC).value) {
            FlowControl fC = stmnt.execute(c);
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
}
