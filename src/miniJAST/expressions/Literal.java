package miniJAST.expressions;

import miniJAST.Context;
import miniJAST.types.UnannType;

public class Literal extends PrimaryExpr{
    private UnannType litType;
    private String value;

    @Override
    public ReturnValues evaluate(Context c) throws Exception {
        ReturnValues result = new ReturnValues();
        switch(litType) {
            case BOOLEAN:
                if (value.equals("true"))
                    result.boolVal = true;
                else if (value.equals("false"))
                    result.boolVal = false;
                else
                    throw new Exception("Type is boolean, but val is not true or false.");
                break;
            case BYTE:
                result.byteVal = Byte.valueOf(value);
                break;
            case CHAR:
                if (value.length() > 1)
                    throw new Exception("Type is char, but value is more than one character.");
                result.cVal = value.charAt(0);
                break;
            case SHORT:
                result.sVal = Short.valueOf(value);
                break;
            case INT:
                result.iVal = Integer.valueOf(value);
                break;
            case LONG:
                result.lVal = Long.valueOf(value);
                break;
            case FLOAT:
                result.fVal = Float.valueOf(value);
                break;
            case DOUBLE:
                result.dVal = Double.valueOf(value);
                break;
            default:
                throw new Exception("'litType' was not one of possible UnannTypes");
        }
        type = litType;
        return result;
    }
}
