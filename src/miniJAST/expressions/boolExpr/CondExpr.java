package miniJAST.expressions.boolExpr;

import miniJAST.Context;
import miniJAST.expressions.Expression;
import miniJAST.expressions.ReturnValues;
import miniJAST.types.UnannType;

public class CondExpr extends Expression {
    private CondOrExpr cond;
    private Expression trueExpr;
    private CondExpr falseExpr; // Right associative

    @Override
    public ReturnValues evaluate(Context c) throws Exception {
        ReturnValues condV = cond.evaluate(c);
        if (cond.getType() != UnannType.BOOLEAN)
            throw new Exception("Conditional expression must have time Boolean");

        ReturnValues t = trueExpr.evaluate(c);
        ReturnValues f = falseExpr.evaluate(c);

        if (trueExpr.getType() != falseExpr.getType())
            throw new Exception("Both expressions must have same type");

        boolean outcome = condV.boolVal;
        type = trueExpr.getType();

        ReturnValues result = new ReturnValues();

        switch (type) {
            case BOOLEAN:
                result.boolVal = outcome ? t.boolVal : f.boolVal;
                return result;
            case BYTE:
                result.byteVal = outcome ? t.byteVal : f.byteVal;
                return result;
            case CHAR:
                result.cVal = outcome ? t.cVal : f.cVal;
                return result;
            case SHORT:
                result.sVal = outcome ? t.sVal : f.sVal;
                return result;
            case INT:
                result.iVal = outcome ? t.iVal : f.iVal;
                return result;
            case LONG:
                result.lVal = outcome ? t.lVal : f.lVal;
                return result;
            case FLOAT:
                result.fVal = outcome ? t.fVal : f.fVal;
                return result;
            case DOUBLE:
                result.dVal = outcome ? t.dVal : f.dVal;
                return result;
            default:
                throw new Exception("Type of expressions is not one of the possible UnannTypes.");
        }
    }
}
