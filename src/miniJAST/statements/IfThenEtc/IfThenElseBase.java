package miniJAST.statements.IfThenEtc;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.statements.BlockStatement;
import miniJAST.statements.FlowControl;
import miniJAST.statements.StatementBase;
import miniJAST.statements.StatementNoShortIf;
import miniJAST.types.UnannType;

public abstract class IfThenElseBase extends StatementBase implements BlockStatement {
    protected Expression cond;
    protected StatementNoShortIf trueStmnt;
    protected BlockStatement falseStmnt;

    protected void baseSetUpITE(Expression c, StatementNoShortIf t, BlockStatement f) { cond = c; trueStmnt = t; falseStmnt = f;
        subNodes.add(c); subNodes.add(t); subNodes.add(f);
    }

    @Override
    public String stringRepr(int blocksDeep) {
        return pad(blocksDeep) + "if (" + cond.stringRepr() + ") \n" + trueStmnt.stringRepr(blocksDeep+1) + "\n" + pad(blocksDeep) + "else\n" + falseStmnt.stringRepr(blocksDeep+1);
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
