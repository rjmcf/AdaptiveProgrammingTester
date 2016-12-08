package miniJAST.expressions;

import miniJAST.Context;
import miniJAST.expressions.returnValues.*;
import miniJAST.types.UnannType;

public class Literal extends PrimaryExpr{
    private UnannType litType;
    private String value;

    public Literal(UnannType lT, String v) { litType = lT; value = v; }

    @Override
    public ReturnValues evaluate(Context c) throws Exception {
        switch(litType) {
            case BOOLEAN:
                boolean v;
                if (value.equals("true"))
                    v = true;
                else if (value.equals("false"))
                    v = false;
                else
                    throw new Exception("Type is boolean, but val is not true or false.");
                return new ReturnValuesBool(v);
            case CHAR:
                if (value.length() > 1)
                    throw new Exception("Type is char, but value is more than one character.");
                return new ReturnValuesChar(value.charAt(0));
            case INT:
                return new ReturnValuesInt(Integer.valueOf(value));
            case DOUBLE:
                return new ReturnValuesDouble(Double.valueOf(value));
            default:
                throw new Exception("'litType' was not one of possible UnannTypes");
        }
    }
}
