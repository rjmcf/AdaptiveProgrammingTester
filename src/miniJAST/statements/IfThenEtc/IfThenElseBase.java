package miniJAST.statements.IfThenEtc;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.statements.*;
import miniJAST.types.UnannType;

public abstract class IfThenElseBase extends StatementBase implements BlockStatement {
    protected int cond;
    protected int trueStmnt;
    protected int falseStmnt;

    protected void baseSetUpITE(Expression c, StatementNoShortIf t, BlockStatement f) {
        subNodes.clear();
        subNodes.add(c); subNodes.add(t); subNodes.add(f);
        cond = 0; trueStmnt = 1; falseStmnt = 2;
    }

    @Override
    public String stringRepr(int blocksDeep) {
        return pad(blocksDeep) + "if (" + ((Expression)subNodes.get(cond)).stringRepr() + ") \n" +
                ((BlockStatement)subNodes.get(trueStmnt)).stringRepr(blocksDeep+1) + "\n" + pad(blocksDeep) +
                "else \n" + ((BlockStatement)subNodes.get(falseStmnt)).stringRepr(blocksDeep+1);
    }

    @Override
    public FlowControl execute(Context c, int d) throws MiniJASTException {
        checkType((Expression)subNodes.get(cond), Expression.class);
        checkType((BlockStatement)subNodes.get(trueStmnt), StatementNoShortIf.class);
        checkType((BlockStatement)subNodes.get(falseStmnt), BlockStatement.class);

        ReturnValues r = ((Expression)subNodes.get(cond)).evaluate(c);
        if (r.getType().uType != UnannType.BOOLEAN)
            throw new TypeException("Condition must be Boolean type");
        if (r.getIsArray())
            throw new TypeException("Can not operate on arrays!");

        if (((ReturnValuesBool)r).value) {
            FlowControl result = ((BlockStatement)subNodes.get(trueStmnt)).execute(c, d+1);
            removeDecsAtDepth(c, d+1);
            return result;
        }
        else {
            FlowControl result = ((BlockStatement)subNodes.get(falseStmnt)).execute(c, d+1);
            removeDecsAtDepth(c, d+1);
            return result;
        }
    }

    @Override
    public FlowControl executeStart(Context c) throws MiniJASTException {
        return execute(c, 0);
    }
}
