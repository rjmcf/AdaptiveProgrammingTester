package miniJAST.statements;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.types.UnannType;

public class IfThenElseStmnt extends StatementBase implements Statement{
    private Expression cond;
    private StatementNoShortIf trueStmnt;
    private Statement falseStmnt;

    public void setUpITE(Expression c, StatementNoShortIf t, Statement f) { cond = c; trueStmnt = t; falseStmnt = f; }

    @Override
    public int getSubNodes() {
        return cond.getSubNodes() + trueStmnt.getSubNodes() + falseStmnt.getSubNodes() + 3;
    }

    @Override
    public FlowControl execute(Context c, int d) throws MiniJASTException {
        ReturnValues r = cond.evaluate(c);
        if (r.getType().uType != UnannType.BOOLEAN)
            throw new TypeException("Condition must be Boolean type");
        if (r.getIsArray())
            throw new TypeException("Can not operate on arrays!");

        if (((ReturnValuesBool)r).value) {
            FlowControl result = trueStmnt.execute(c, d+1);
            removeDecsAtDepth(c, d+1);
            return result;
        }
        else {
            FlowControl result = falseStmnt.execute(c, d+1);
            removeDecsAtDepth(c, d+1);
            return result;
        }
    }

    @Override
    public FlowControl executeStart(Context c) throws MiniJASTException {
        return execute(c, 0);
    }
}
