package miniJAST.expressions.boolExpr;

import miniJAST.Context;
import miniJAST.expressions.Expression;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.types.GeneralType;
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
        result.type = trueExpr.getType();

        switch (type) {
            case BOOLEAN:
                result.gType = GeneralType.BOOL;
                result.boolVal = outcome ? t.boolVal : f.boolVal;
                return result;
            case BYTE:
            case CHAR:
            case SHORT:
            case INT:
            case LONG:
                result.gType = GeneralType.INTEGER;
                result.intVal = outcome ? t.intVal : f.intVal;
                return result;
            case FLOAT:
            case DOUBLE:
                result.gType = GeneralType.FP;
                result.fpVal = outcome ? t.fpVal : f.fpVal;
                return result;
            default:
                throw new Exception("Type of expressions is not one of the possible UnannTypes.");
        }
    }
}
