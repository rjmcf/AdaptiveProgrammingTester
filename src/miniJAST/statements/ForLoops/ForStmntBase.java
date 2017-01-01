package miniJAST.statements.ForLoops;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.StatementExpr;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.statements.BlockStatement;
import miniJAST.statements.FlowControl;
import miniJAST.statements.Statement;
import miniJAST.statements.StatementBase;
import miniJAST.types.UnannType;

import java.util.ArrayList;

public abstract class ForStmntBase extends StatementBase implements BlockStatement {
    protected ForInit init;
    protected Expression cond;
    protected ArrayList<StatementExpr> updates = new ArrayList<>();
    protected BlockStatement stmnt;

    public void setUpForStmnt( ForInit i, Expression c) { init = i; cond = c; subNodes.add(i); subNodes.add(c); }
    public void addUpdate(StatementExpr se) { updates.add(se); subNodes.add(se); }
    protected void baseSetBody(BlockStatement s) { stmnt = s; subNodes.add(s); }

    @Override
    public String stringRepr(int blocksDeep) {
        String result = pad(blocksDeep) + "for (" + (init == null ? "" : init.stringRepr()) + "; " +
                (cond == null ? "" : cond.stringRepr()) + "; ";
        for (StatementExpr u : updates)
            result += u.stringRepr() + ", ";
        String result1 = result.substring(0, result.length() - 2);
        result1 += ") \n" + stmnt.stringRepr(blocksDeep + 1);
        return result1;
    }

    @Override
    public FlowControl execute(Context c, int d) throws MiniJASTException {
        if (init != null)
            init.execute(c, d+1);

        ReturnValues condR;
        if (cond != null)
            condR = cond.evaluate(c);
        else
            condR = new ReturnValuesBool(true);

        if (condR.getType().uType != UnannType.BOOLEAN)
            throw new TypeException("Condition must have boolean type");
        if (condR.getIsArray())
            throw new TypeException("Can not operate on arrays!");

        loop:
        while(((ReturnValuesBool)condR).value) {
            FlowControl fC = stmnt.execute(c, d+2);
            removeDecsAtDepth(c, d+2);
            switch(fC) {
                case BREAK:
                    break loop;
                case CONTINUE:
                    for (StatementExpr se : updates)
                        se.evaluate(c);

                    if (cond != null)
                        condR = cond.evaluate(c);
                    continue loop;
                case RETURN:
                    return fC;
            }

            for (StatementExpr se : updates)
                se.evaluate(c);

            if (cond != null)
                condR = cond.evaluate(c);
        }

        removeDecsAtDepth(c, d+1);

        return FlowControl.NONE;
    }

    @Override
    public FlowControl executeStart(Context c) throws MiniJASTException {
        return execute(c, 0);
    }
}
