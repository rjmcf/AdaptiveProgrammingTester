package miniJAST.expressions.arithExpr;

import miniJAST.Context;
import miniJAST.NodeCount;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesChar;
import miniJAST.expressions.returnValues.ReturnValuesDouble;
import miniJAST.expressions.returnValues.ReturnValuesInt;

public class UnaryPMExpr extends UnaryExpr {
    private boolean isPlus;
    private UnaryExpr expr;

    public void setUpPMExpr(boolean p, UnaryExpr e) { isPlus = p; expr = e; }

    @Override
    public NodeCount getTreeSize() {
        NodeCount result = expr.getTreeSize();
        result.filled++;
        return result;
    }

    @Override
    public ReturnValues evaluate(Context c) throws MiniJASTException {
        ReturnValues e = expr.evaluate(c);

        if (e.getIsArray())
            throw new TypeException("Cannot operate on whole arrays");

        switch (e.getType().uType) {
            case CHAR:
                return new ReturnValuesInt(isPlus? +((ReturnValuesChar)e).value : -((ReturnValuesChar)e).value);
            case INT:
                return new ReturnValuesInt(isPlus? +((ReturnValuesInt)e).value : -((ReturnValuesInt)e).value);
            case DOUBLE:
                return new ReturnValuesDouble(isPlus? +((ReturnValuesDouble)e).value : -((ReturnValuesDouble)e).value);
            default: // BOOLEAN
                throw new TypeException("Cannot apply + or - to boolean value");
        }
    }
}
