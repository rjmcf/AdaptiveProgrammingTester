package miniJAST.statements;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.types.Type;
import miniJAST.types.UnannType;

public class IfThenElseStmntNoShortIf extends StatementBase implements StatementNoShortIf {
    private Expression cond;
    private StatementNoShortIf trueStmnt;
    private StatementNoShortIf falseStmnt;

    public void setUpITENSI(Expression c, StatementNoShortIf t, StatementNoShortIf f) { cond = c; trueStmnt = t; falseStmnt = f; }

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
