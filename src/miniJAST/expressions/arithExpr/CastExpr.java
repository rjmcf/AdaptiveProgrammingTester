package miniJAST.expressions.arithExpr;

import miniJAST.Context;
import miniJAST.expressions.ReturnValues;
import miniJAST.types.GeneralType;
import miniJAST.types.UnannType;

public class CastExpr extends UnaryExpr {
    private UnannType castType;
    private UnaryExpr expr;

    @Override
    public ReturnValues evaluate(Context c) throws Exception {
        ReturnValues e = expr.evaluate(c);

        ReturnValues result = new ReturnValues();
        result.type = castType;
        type = castType;


        switch (e.gType) {
            case BOOL:
                result.gType = GeneralType.BOOL;
                if  (type != UnannType.BOOLEAN)
                    throw new Exception("Cannot cast boolean to non-boolean type");
                result.boolVal = e.boolVal;
                break;
            case INTEGER:
                result.gType = GeneralType.INTEGER;
                switch (type) {
                    case BOOLEAN:
                        throw new Exception("Cannot cast numeric type to boolean");
                    case BYTE:
                        result.intVal = (byte) e.intVal;
                        break;
                    case CHAR:
                        result.intVal = (char) e.intVal;
                        break;
                    case SHORT:
                        result.intVal = (short) e.intVal;
                        break;
                    case INT:
                        result.intVal = (int) e.intVal;
                        break;
                    case LONG:
                        result.intVal = e.intVal;
                        break;
                    case FLOAT:
                        result.fpVal = (float) e.intVal;
                        break;
                    case DOUBLE:
                        result.fpVal = (double) e.intVal;
                        break;
                }
                break;
            case FP:
                result.gType = GeneralType.FP;
                switch (type) {
                    case BOOLEAN:
                        throw new Exception("Cannot cast numeric type to boolean");
                    case BYTE:
                        result.intVal = (byte) e.fpVal;
                        break;
                    case CHAR:
                        result.intVal = (char) e.fpVal;
                        break;
                    case SHORT:
                        result.intVal = (short) e.fpVal;
                        break;
                    case INT:
                        result.intVal = (int) e.fpVal;
                        break;
                    case LONG:
                        result.intVal = (long) e.fpVal;
                        break;
                    case FLOAT:
                        result.fpVal = (float) e.fpVal;
                        break;
                    case DOUBLE:
                        result.fpVal = e.fpVal;
                        break;
                }
                break;
        }

        return result;
    }
}
