package miniJAST.statements.ForLoops;

import miniJAST.Context;
import miniJAST.MiniJASTNode;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.StatementExpr;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.statements.BlockStatement;
import miniJAST.statements.FlowControl;
import miniJAST.statements.LVD.LocalVarDec;
import miniJAST.statements.Statement;
import miniJAST.statements.StatementBase;
import miniJAST.types.UnannType;

import java.util.ArrayList;

public abstract class ForStmntBase extends StatementBase implements BlockStatement {
    protected int init;
    protected int condI;
    protected ArrayList<Integer> updates = new ArrayList<>();
    protected int stmnt;

    public void setUpForStmnt( BlockStatement i, Expression c) {
        subNodes.clear();
        subNodes.add(i); init = 0;
        subNodes.add(c); condI = 1;
    }
    public void addUpdate(Expression se) { subNodes.add(se); updates.add(subNodes.size()-1); }
    protected void baseSetBody(BlockStatement s) { subNodes.add(s); stmnt = subNodes.size() - 1; }

    @Override
    public String stringRepr(int blocksDeep) {
        String result = pad(blocksDeep) + "for (" + (subNodes.get(init) == null ? "" :
                ((BlockStatement)subNodes.get(init)).stringRepr(0)) + "; " +
                (subNodes.get(condI) == null ? "" : ((Expression)subNodes.get(condI)).stringRepr()) + "; ";
        for (int u : updates)
            result += ((Expression)subNodes.get(u)).stringRepr() + ", ";
        String result1 = result.substring(0, result.length() - 2);
        result1 += ") \n" + ((BlockStatement)subNodes.get(stmnt)).stringRepr(blocksDeep + 1);
        return result1;
    }

    @Override
    public FlowControl execute(Context c, int d) throws MiniJASTException {
        checkType((BlockStatement)subNodes.get(init), ForInit.class);
        checkType((Expression)subNodes.get(condI), Expression.class);
        checkType((BlockStatement)subNodes.get(stmnt), BlockStatement.class);

        if (subNodes.get(init) != null)
            ((ForInit)subNodes.get(init)).execute(c, d+1);

        Expression cond = (Expression)subNodes.get(condI);
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
            FlowControl fC = ((BlockStatement)subNodes.get(stmnt)).execute(c, d+2);
            removeDecsAtDepth(c, d+2);
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

        removeDecsAtDepth(c, d+1);

        return FlowControl.NONE;
    }

    @Override
    public FlowControl executeStart(Context c) throws MiniJASTException {
        return execute(c, 0);
    }
}
