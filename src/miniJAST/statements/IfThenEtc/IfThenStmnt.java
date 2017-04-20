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
import miniJAST.types.PrimType;

public class IfThenStmnt extends StatementBase {
    private int cond;
    private int stmnt;

    public void setUpIfThen(Expression c, BlockStatement t) {
        subNodes.clear();
        cond = 0;
        stmnt = 1;
        subNodes.add(c);
        subNodes.add(t);
    }

    @Override
    public String stringRepr(int blocksDeep) {
        return pad(blocksDeep) + "if (" + ((Expression) subNodes.get(cond)).stringRepr() + ") \n" +
                ((BlockStatement) subNodes.get(stmnt)).stringRepr(blocksDeep + 1);
    }

    @Override
    public FlowControl execute(Context c) throws MiniJASTException {
        checkType((Expression) subNodes.get(cond), Expression.class);
        checkType((BlockStatement) subNodes.get(stmnt), BlockStatement.class);

        ReturnValues r = ((Expression) subNodes.get(cond)).evaluate(c);
        if (r.getPType() != PrimType.BOOLEAN)
            throw new TypeException("Condition must be Boolean type");
        if (r.getIsArray())
            throw new TypeException("Can not operate on arrays!");

        if (((ReturnValuesBool) r).value) {
            stepIn(c);
            FlowControl result = ((BlockStatement) subNodes.get(stmnt)).execute(c);
            stepOut(c);
            return result;
        }


        return FlowControl.NONE;
    }
}
