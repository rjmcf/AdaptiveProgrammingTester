package miniJAST.expressions;

import miniJAST.Context;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.returnValues.*;
import miniJAST.types.UnannType;

public class Literal extends PrimaryExpr{
    private UnannType litType;
    private String value;

    public void setUpLiteral(UnannType lT, String v) { litType = lT; value = v; }

    @Override
    public ReturnValues evaluate(Context c) throws TypeException {
        switch(litType) {
            case BOOLEAN:
                boolean v;
                if (value.equals("true"))
                    v = true;
                else if (value.equals("false"))
                    v = false;
                else
                    throw new TypeException("Type is boolean, but val is not true or false.");
                return new ReturnValuesBool(v);
            case CHAR:
                if (value.length() > 1)
                    throw new TypeException("Type is char, but value is more than one character.");
                return new ReturnValuesChar(value.charAt(0));
            case INT:
                return new ReturnValuesInt(Integer.parseInt(value));
            case DOUBLE:
                return new ReturnValuesDouble(Double.parseDouble(value));
            default:
                throw new TypeException("'litType' was not one of possible UnannTypes");
        }
    }
}
