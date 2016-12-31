package miniJAST.expressions.boolExpr;

import miniJAST.Context;
import miniJAST.NodeCount;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.arithExpr.UnaryExpr;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.types.Type;
import miniJAST.types.UnannType;

public class UnaryComplementExpr extends UnaryExpr {
    // Only logical complement here
    private UnaryExpr expr;

    public void setUpCompExpr(UnaryExpr e) { expr = e; }

    @Override
    public NodeCount getTreeSize() {
        NodeCount result = expr.getTreeSize();
        result.filled++;
        return result;
    }

    @Override
    public String stringRepr() {
        return " !" + expr.stringRepr();
    }

    @Override
    public ReturnValues evaluate(Context c) throws MiniJASTException {
        ReturnValues e = expr.evaluate(c);

        if (e.getType().uType != UnannType.BOOLEAN)
            throw new TypeException("Cannot apply ! to non-boolean type.");

        if (e.getIsArray())
            throw new TypeException("Cannot operate on whole arrays");

        return new ReturnValuesBool(!((ReturnValuesBool)e).value);
    }
}
