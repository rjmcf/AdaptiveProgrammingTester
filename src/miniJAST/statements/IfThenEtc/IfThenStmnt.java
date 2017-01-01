package miniJAST.statements.IfThenEtc;

import miniJAST.Context;
import miniJAST.NodeCount;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.statements.FlowControl;
import miniJAST.statements.Statement;
import miniJAST.statements.StatementBase;
import miniJAST.types.UnannType;

public class IfThenStmnt extends StatementBase implements Statement {
    private Expression cond;
    private Statement stmnt;

    public void setUpIfThen(Expression c, Statement t) { cond = c; stmnt = t; subNodes.add(c); subNodes.add(t); }

    @Override
    public String stringRepr(int blocksDeep) {
        return pad(blocksDeep) + "if (" + cond.stringRepr() + ") \n" + stmnt.stringRepr(blocksDeep+1);
    }

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

    @Override
    public FlowControl executeStart(Context c) throws MiniJASTException {
        return execute(c, 0);
    }
}
