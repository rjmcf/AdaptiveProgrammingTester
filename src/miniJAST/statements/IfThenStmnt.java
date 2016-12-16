package miniJAST.statements;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.types.UnannType;

public class IfThenStmnt extends StatementBase implements Statement {
    private Expression cond;
    private Statement stmnt;

    public void setUpIfThen(Expression c, Statement t) { cond = c; stmnt = t; }

    @Override
    public FlowControl execute(Context c, int d) throws MiniJASTException {
        ReturnValues r = cond.evaluate(c);
        if (r.getType().uType != UnannType.BOOLEAN)
            throw new TypeException("Condition must be Boolean type");
        if (r.getIsArray())
            throw new TypeException("Can not operate on arrays!");

        if (((ReturnValuesBool)r).value) {
            FlowControl result = stmnt.execute(c, d+1);
            removeDecsAtDepth(c, d+1);
            return result;
        }


        return FlowControl.NONE;
    }
}
