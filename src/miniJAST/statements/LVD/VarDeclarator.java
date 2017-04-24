package miniJAST.statements.LVD;

import miniJAST.Context;
import miniJAST.exceptions.IncorrectEvaluationException;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.Expression;
import miniJAST.statements.FlowControl;
import miniJAST.statements.StatementBase;

public class VarDeclarator extends StatementBase {
    private String name;
    private int expr;
    private boolean isArray;
    private boolean hasExpr;

    public void setUpVarDec(String n, boolean isA, Expression e) {
        subNodes.clear();
        name = n;
        expr = 0;
        if (e == null) {
            hasExpr = false;
        } else {
            hasExpr = true;
            subNodes.add(e);
        }
        isArray = isA;
    }

    public String getName() { return name; }
    public Expression getExpr() { return hasExpr ? (Expression)subNodes.get(expr) : null; }
    public boolean getIsArray() { return isArray; }
    public boolean getHasExpr() { return hasExpr; }

    @Override
    public FlowControl execute(Context c) throws MiniJASTException {
        throw new IncorrectEvaluationException("Should not be executing a VarDeclarator");
    }

    @Override
    public String stringRepr(int blocksDeep) {
        return name + (isArray ? "[]" : "") + (hasExpr ? (" = " + ((Expression)subNodes.get(expr)).stringRepr()) : "");
    }
}
