package miniJAST.expressions.arithExpr;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesChar;
import miniJAST.expressions.returnValues.ReturnValuesDouble;
import miniJAST.expressions.returnValues.ReturnValuesInt;

public class UnaryPMExpr extends UnaryExpr {
    private boolean isPlus;
    private int expr;

    public void setUpPMExpr(boolean p, Expression e) {
        subNodes.clear();
        isPlus = p; expr = 0; subNodes.add(e);
    }

    @Override
    public String stringRepr() {
        return (isPlus ? "+ " : "- ") + subNodes.get(expr).stringRepr();
    }

    @Override
    public ReturnValues evaluate(Context c) throws MiniJASTException {
        checkType(subNodes.get(expr), UnaryExpr.class);

        ReturnValues e = subNodes.get(expr).evaluate(c);

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
