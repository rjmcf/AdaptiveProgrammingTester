package miniJAST.expressions;

import miniJAST.Context;
import miniJAST.expressions.assignment.AssignLHS;
import miniJAST.types.UnannType;

public class Id extends GroundExpr implements AssignLHS{
    private UnannType varType;
    private String name;

    @Override
    public ReturnValues evaluate(Context c) throws Exception{
        if (c.namesToTypes.get(name).equals(varType)) {
            type = varType;
            ReturnValues result = new ReturnValues();
            Object v = c.namesToValues.get(name);
            switch (varType) {
                case BOOLEAN:
                    result.boolVal = (boolean) v;
                    return result;
                case BYTE:
                    result.byteVal = (byte) v;
                    return result;
                case CHAR:
                    result.cVal = (char) v;
                    return result;
                case SHORT:
                    result.sVal = (short) v;
                    return result;
                case INT:
                    result.iVal = (int) v;
                    return result;
                case LONG:
                    result.lVal = (long) v;
                    return result;
                case FLOAT:
                    result.fVal = (float) v;
                    return result;
                case DOUBLE:
                    result.dVal = (double) v;
                    return result;
                default:
                    throw new Exception("'varType' was not one of possible UnannTypes.");
            }
        } else
            throw new Exception("Variable " + name + " not available in context.");
    }
}
