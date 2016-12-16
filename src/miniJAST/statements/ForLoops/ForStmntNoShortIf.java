package miniJAST.statements.ForLoops;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.StatementExpr;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.statements.FlowControl;
import miniJAST.statements.StatementNoShortIf;
import miniJAST.types.UnannType;

import java.util.ArrayList;

public class ForStmntNoShortIf implements StatementNoShortIf {
    private ForInit init;
    private Expression cond;
    private ArrayList<StatementExpr> updates;
    private StatementNoShortIf stmnt;

    public ForStmntNoShortIf() { updates = new ArrayList<>(); }
    public void setUpForStmntNSI(ForInit i, Expression c) { init = i; cond = c; }
    public void addUpdate(StatementExpr se) { updates.add(se); }
    public void setBody(StatementNoShortIf s) { stmnt = s; }

    @Override
    public FlowControl execute(Context c) throws MiniJASTException {
        if (init != null)
            init.execute(c);

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
            FlowControl fC = stmnt.execute(c);
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

        return FlowControl.NONE;
    }
}
