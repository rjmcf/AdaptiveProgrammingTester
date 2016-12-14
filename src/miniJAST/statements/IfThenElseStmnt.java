package miniJAST.statements;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.types.UnannType;

public class IfThenElseStmnt implements Statement{
    private Expression cond;
    private StatementNoShortIf trueStmnt;
    private Statement falseStmnt;

    public void setUpITE(Expression c, StatementNoShortIf t, Statement f) { cond = c; trueStmnt = t; falseStmnt = f; }

    @Override
    public FlowControl execute(Context c) throws MiniJASTException {
        ReturnValues r = cond.evaluate(c);
        if (r.getType().uType != UnannType.BOOLEAN)
            throw new TypeException("Condition must be Boolean type");
        if (r.getIsArray())
            throw new TypeException("Can not operate on arrays!");

        if (((ReturnValuesBool)r).value)
            return trueStmnt.execute(c);
        else
            return falseStmnt.execute(c);
    }
}
