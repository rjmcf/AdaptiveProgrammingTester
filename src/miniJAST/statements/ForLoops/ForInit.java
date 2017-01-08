package miniJAST.statements.ForLoops;

import miniJAST.Context;
import miniJAST.MiniJASTNode;
import miniJAST.exceptions.IncorrectEvaluationException;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.Expression;
import miniJAST.statements.BlockStatement;
import miniJAST.statements.FlowControl;
import miniJAST.statements.LVD.LocalVarDec;
import miniJAST.expressions.StatementExpr;
import miniJAST.statements.StatementBase;

import java.util.ArrayList;

public class ForInit extends StatementBase implements BlockStatement{
    private boolean hasLVD = false;

    public void setLocalVarDec(BlockStatement lv) { subNodes.clear(); hasLVD = true; subNodes.add(lv); }
    public void addStmntExpr(Expression se) { hasLVD = false; subNodes.add(se); }

    public String stringRepr() {
        if (!hasLVD) {
            String result = "";
            for (MiniJASTNode se : subNodes)
                result += ((Expression)se).stringRepr() + ", ";
            return result.substring(0, result.length() - 2);
        } else
            return  subNodes.get(0) instanceof LocalVarDec ?
                    ((LocalVarDec)subNodes.get(0)).stringRepr(0).substring(0, ((LocalVarDec)subNodes.get(0)).stringRepr(0).length() - 1) :
                    ((BlockStatement)subNodes.get(0)).stringRepr(0);
    }

    public FlowControl execute(Context c, int d) throws MiniJASTException {
        if (!hasLVD) {
            for (MiniJASTNode se : subNodes) {
                checkType((Expression)se, StatementExpr.class);
                ((Expression)se).evaluate(c);
            }
        } else {
            checkType((BlockStatement)subNodes.get(0), LocalVarDec.class);
            ((BlockStatement)subNodes.get(0)).execute(c, d);
        }

        return null;
    }

    @Override
    public FlowControl executeStart(Context c) throws MiniJASTException {
        throw new IncorrectEvaluationException("Should not be starting execution on ForInit");
    }

    @Override
    public String stringRepr(int blocksDeep) {
        return null;
    }
}
