package miniJAST.statements.IfThenEtc;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.statements.*;
import miniJAST.types.PrimType;

public class IfThenElseStmnt extends StatementBase {
    protected int cond;
    protected int trueStmnt;
    protected int falseStmnt;

    protected void baseSetUpITE(Expression c, Statement t, Statement f) {
        subNodes.clear();
        subNodes.add(c); subNodes.add(t); subNodes.add(f);
        cond = 0; trueStmnt = 1; falseStmnt = 2;
    }

    @Override
    public String stringRepr(int blocksDeep) {
        return pad(blocksDeep) + "if (" + ((Expression)subNodes.get(cond)).stringRepr() + ") \n" +
                ((Statement)subNodes.get(trueStmnt)).stringRepr(blocksDeep+1) + "\n" + pad(blocksDeep) +
                "else \n" + ((Statement)subNodes.get(falseStmnt)).stringRepr(blocksDeep+1);
    }

    public void setUpITE(Expression c, Statement t, Statement f) { baseSetUpITE(c, t, f); }

    @Override
    public FlowControl execute(Context c) throws MiniJASTException {
        checkType((Expression)subNodes.get(cond), Expression.class);
        checkType((Statement)subNodes.get(trueStmnt), Statement.class);
        checkType((Statement)subNodes.get(falseStmnt), Statement.class);

        ReturnValues r = ((Expression)subNodes.get(cond)).evaluate(c);
        if (r.getPType() != PrimType.BOOLEAN)
            throw new TypeException("Condition must be Boolean type");
        if (r.getIsArray())
            throw new TypeException("Can not operate on arrays!");

        if (((ReturnValuesBool)r).value) {
            stepIn(c);
            FlowControl result = ((Statement)subNodes.get(trueStmnt)).execute(c);
            stepOut(c);
            return result;
        }
        else {
            stepIn(c);
            FlowControl result = ((Statement)subNodes.get(falseStmnt)).execute(c);
            stepOut(c);
            return result;
        }
    }
}
