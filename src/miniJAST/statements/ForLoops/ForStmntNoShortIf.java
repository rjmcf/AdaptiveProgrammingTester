package miniJAST.statements.ForLoops;

import miniJAST.Context;
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

    @Override
    public FlowControl execute(Context c) throws Exception {
        init.execute(c);
        ReturnValues condR = cond.evaluate(c);
        if (condR.getType().uType != UnannType.BOOLEAN)
            throw new Exception("Condition must have boolean type");
        if (condR.getIsArray())
            throw new Exception("Can not operate on arrays!");

        loop:
        while(((ReturnValuesBool)condR).value) {
            FlowControl fC = stmnt.execute(c);
            switch(fC) {
                case BREAK:
                    break loop;
                case CONTINUE:
                    continue loop;
                case RETURN:
                    return fC;
            }

            for (StatementExpr se : updates)
                se.evaluate(c);

            condR = cond.evaluate(c);
        }

        return FlowControl.NONE;
    }
}
