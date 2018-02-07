package miniJAST.statements.ForLoops;

import miniJAST.Context;
import miniJAST.MiniJASTNode;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.Expression;
import miniJAST.statements.Statement;
import miniJAST.statements.FlowControl;
import miniJAST.statements.LVD.LocalVarDec;
import miniJAST.expressions.StatementExpr;
import miniJAST.statements.StatementBase;

public class ForInit extends StatementBase {
    private boolean hasLVD = false;

    public void setLocalVarDec(Statement lv) { subNodes.clear(); hasLVD = true; subNodes.add(lv); }
    public void addStmntExpr(Expression se) { hasLVD = false; subNodes.add(se); }

    @Override
    public FlowControl execute(Context c) throws MiniJASTException {
        if (!hasLVD) {
            for (MiniJASTNode se : subNodes) {
                checkType((Expression)se, StatementExpr.class);
                ((Expression)se).evaluate(c);
            }
        } else {
            checkType((Statement)subNodes.get(0), LocalVarDec.class);
            ((Statement)subNodes.get(0)).execute(c);
        }

        return null;
    }

    @Override
    public String stringRepr(int blocksDeep) {
        if (!hasLVD) {
            String result = "";
            for (MiniJASTNode se : subNodes)
                result += ((Expression)se).stringRepr() + ", ";
            return result.substring(0, result.length() - 2);
        } else
            return  subNodes.get(0) instanceof LocalVarDec ?
                    ((LocalVarDec)subNodes.get(0)).stringRepr(0).substring(0, ((LocalVarDec)subNodes.get(0)).stringRepr(0).length() - 1) :
                    ((Statement)subNodes.get(0)).stringRepr(0);
    }
}
