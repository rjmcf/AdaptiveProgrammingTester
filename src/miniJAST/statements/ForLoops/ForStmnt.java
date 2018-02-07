package miniJAST.statements.ForLoops;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.StatementExpr;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.statements.*;
import miniJAST.types.PrimType;

import java.util.ArrayList;

public class ForStmnt extends StatementBase {
    protected int init;
    protected int condI;
    protected ArrayList<Integer> updates = new ArrayList<>();
    protected int stmnt;

    public void setUpForStmnt(Statement i, Expression c) {
        subNodes.clear();
        subNodes.add(i); init = 0;
        subNodes.add(c); condI = 1;
    }
    public void addUpdate(Expression se) { subNodes.add(se); updates.add(subNodes.size()-1); }
    protected void baseSetBody(Statement s) { subNodes.add(s); stmnt = subNodes.size() - 1; }

    @Override
    public String stringRepr(int blocksDeep) {
        String result = pad(blocksDeep) + "for (" + (subNodes.get(init) == null ? "" :
                ((Statement)subNodes.get(init)).stringRepr(0)) + "; " +
                (subNodes.get(condI) == null ? "" : ((Expression)subNodes.get(condI)).stringRepr()) + "; ";
        boolean once = true;
        for (int u : updates) {
            if (once) {
                once = false;
            } else {
                result += ", ";
            }
            result += ((Expression)subNodes.get(u)).stringRepr();
        }
        result += ") \n" + ((Statement)subNodes.get(stmnt)).stringRepr(blocksDeep + 1);
        return result;
    }

    public void setBody(Statement s) { baseSetBody(s); }

    @Override
    public FlowControl execute(Context c) throws MiniJASTException {
        checkType((Statement)subNodes.get(init), ForInit.class);
        checkType((Expression)subNodes.get(condI), Expression.class);
        checkType((Statement)subNodes.get(stmnt), Statement.class);

        stepIn(c);

        if (subNodes.get(init) != null) {
            try {
                if (subNodes.get(init) instanceof FillableBlankStmnt) {
                    ((FillableBlankStmnt)subNodes.get(init)).getStudentStmnt().execute(c);
                } else {
                    ((ForInit)subNodes.get(init)).execute(c);
                }
            } catch (ClassCastException e) {
                throw new TypeException("Init for For must have type ForInit!");
            }
        }


        Expression cond = (Expression)subNodes.get(condI);
        ReturnValues condR;
        if (cond != null)
            condR = cond.evaluate(c);
        else
            condR = new ReturnValuesBool(true);

        if (condR.getPType() != PrimType.BOOLEAN)
            throw new TypeException("Condition must have boolean type");
        if (condR.getIsArray())
            throw new TypeException("Can not operate on arrays!");

        loop:
        while(((ReturnValuesBool)condR).value) {
            stepIn(c);
            FlowControl fC = ((Statement)subNodes.get(stmnt)).execute(c);
            stepOut(c);
            switch(fC) {
                case BREAK:
                    break loop;
                case CONTINUE:
                    for (int se : updates) {
                        checkType((Expression)subNodes.get(se), StatementExpr.class);
                        ((Expression)subNodes.get(se)).evaluate(c);
                    }

                    if (cond != null)
                        condR = cond.evaluate(c);
                    continue loop;
                case RETURN:
                    return fC;
            }

            for (int se : updates) {
                checkType((Expression)subNodes.get(se), StatementExpr.class);
                ((Expression)subNodes.get(se)).evaluate(c);
            }

            if (cond != null)
                condR = cond.evaluate(c);
        }

        stepOut(c);

        return FlowControl.NONE;
    }
}
