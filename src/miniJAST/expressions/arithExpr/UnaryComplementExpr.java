package miniJAST.expressions.arithExpr;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.types.Type;
import miniJAST.types.UnannType;

public class UnaryComplementExpr extends UnaryExpr {
    // Only logical complement here
    private UnaryExpr expr;

    public void setUp(UnaryExpr e) { expr = e; }

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
