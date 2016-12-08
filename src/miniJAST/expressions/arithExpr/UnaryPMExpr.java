package miniJAST.expressions.arithExpr;

import miniJAST.Context;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesChar;
import miniJAST.expressions.returnValues.ReturnValuesDouble;
import miniJAST.expressions.returnValues.ReturnValuesInt;

public class UnaryPMExpr extends UnaryExpr {
    private boolean isPlus;
    private UnaryExpr expr;

    public UnaryPMExpr(boolean p, UnaryExpr e) { isPlus = p; expr = e; }

    @Override
    public ReturnValues evaluate(Context c) throws Exception {
        ReturnValues e = expr.evaluate(c);

        if (e.getIsArray())
            throw new Exception("Cannot operate on whole arrays");

        switch (e.getType().uType) {
            case CHAR:
                return new ReturnValuesInt(isPlus? +((ReturnValuesChar)e).value : -((ReturnValuesChar)e).value);
            case INT:
                return new ReturnValuesInt(isPlus? +((ReturnValuesInt)e).value : -((ReturnValuesInt)e).value);
            case DOUBLE:
                return new ReturnValuesDouble(isPlus? +((ReturnValuesDouble)e).value : -((ReturnValuesDouble)e).value);
            default: // BOOLEAN
                throw new Exception("Cannot apply + or - to boolean value");
        }
    }
}
