package miniJAST.expressions;

import miniJAST.Context;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.types.GeneralType;
import miniJAST.types.UnannType;

public class Literal extends PrimaryExpr{
    private UnannType litType;
    private String value;

    @Override
    public ReturnValues evaluate(Context c) throws Exception {
        ReturnValues result = new ReturnValues();
        result.type = litType;
        switch(litType) {
            case BOOLEAN:
                result.gType = GeneralType.BOOL;
                if (value.equals("true"))
                    result.boolVal = true;
                else if (value.equals("false"))
                    result.boolVal = false;
                else
                    throw new Exception("Type is boolean, but val is not true or false.");
                break;
            case CHAR:
                result.gType = GeneralType.INTEGER;
                if (value.length() > 1)
                    throw new Exception("Type is char, but value is more than one character.");
                result.intVal = value.charAt(0);
                break;
            case BYTE:
            case SHORT:
            case INT:
            case LONG:
                result.gType = GeneralType.INTEGER;
                result.intVal = Long.valueOf(value);
                break;
            case FLOAT:
            case DOUBLE:
                result.gType = GeneralType.FP;
                result.fpVal = Double.valueOf(value);
                break;
            default:
                throw new Exception("'litType' was not one of possible UnannTypes");
        }
        type = litType;
        return result;
    }
}
