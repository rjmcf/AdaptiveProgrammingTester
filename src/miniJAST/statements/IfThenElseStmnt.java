package miniJAST.statements;

import miniJAST.Context;
import miniJAST.expressions.Expression;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.types.UnannType;

public class IfThenElseStmnt implements Statement{
    private Expression cond;
    private StatementNoShortIf trueStmnt;
    private Statement falseStmnt;

    @Override
    public FlowControl execute(Context c) throws Exception {
        ReturnValues r = cond.evaluate(c);
        if (r.getType().uType != UnannType.BOOLEAN)
            throw new Exception("Condition must be Boolean type");

        if (((ReturnValuesBool)r).value)
            return trueStmnt.execute(c);
        else
            return falseStmnt.execute(c);
    }
}
