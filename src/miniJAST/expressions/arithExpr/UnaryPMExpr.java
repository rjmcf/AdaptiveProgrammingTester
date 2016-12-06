package miniJAST.expressions.arithExpr;

import miniJAST.Context;
import miniJAST.expressions.returnValues.ReturnValues;

public class UnaryPMExpr extends UnaryExpr {
    private boolean isPlus;
    private UnaryExpr expr;

    @Override
    public ReturnValues evaluate(Context c) throws Exception {
        ReturnValues e = expr.evaluate(c);

        ReturnValues result = new ReturnValues();
        type = e.type;
        result.type = type;
        result.gType = e.gType;

        switch (e.gType) {
            case BOOL:
                throw new Exception("+ or - cannot be used on expression of type bool");
            case INTEGER:
                result.intVal = isPlus ? +e.intVal : -e.intVal;
                break;
            case FP:
                result.fpVal = isPlus ? +e.fpVal : -e.fpVal;
                break;
        }

        return result;

    }
}
