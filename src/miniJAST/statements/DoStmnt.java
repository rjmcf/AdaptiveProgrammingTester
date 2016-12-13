package miniJAST.statements;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.types.UnannType;

public class DoStmnt implements StmntNoTrailSubstmnt{
    private Statement stmnt;
    private Expression cond;

    public void setUp(Statement s, Expression c) { stmnt = s; cond = c; }

    @Override
    public FlowControl execute(Context c) throws MiniJASTException {
        stmnt.execute(c);
        ReturnValues rCond = cond.evaluate(c);
        if (rCond.getType().uType != UnannType.BOOLEAN)
            throw new TypeException("Condition does not have boolean type");
        if (rCond.getIsArray())
            throw new TypeException("Can not operate on arrays!");

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
