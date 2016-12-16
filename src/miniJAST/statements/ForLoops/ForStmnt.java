package miniJAST.statements.ForLoops;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.Literal;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.statements.FlowControl;
import miniJAST.statements.Statement;
import miniJAST.expressions.StatementExpr;
import miniJAST.statements.StatementBase;
import miniJAST.types.UnannType;

import java.util.ArrayList;

public class ForStmnt extends StatementBase implements Statement {
    private ForInit init;
    private Expression cond;
    private ArrayList<StatementExpr> updates;
    private Statement stmnt;

    public ForStmnt() { updates = new ArrayList<>(); }
    public void setUpForStmnt( ForInit i, Expression c) { init = i; cond = c; }
    public void addUpdate(StatementExpr se) { updates.add(se); }
    public void setBody(Statement s) { stmnt = s; }

    @Override
    public FlowControl execute(Context c, int d) throws MiniJASTException{
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
}
