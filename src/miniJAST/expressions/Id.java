package miniJAST.expressions;

import miniJAST.Context;
import miniJAST.expressions.assignment.AssignLHS;
import miniJAST.types.GeneralType;
import miniJAST.types.UnannType;

public class Id extends GroundExpr implements AssignLHS{
    private UnannType varType;
    private String name;

    @Override
    public ReturnValues evaluate(Context c) throws Exception{
        if (c.namesToTypes.get(name).equals(varType)) {
            type = varType;
            ReturnValues result = new ReturnValues();
            result.type = varType;
            Object v = c.namesToValues.get(name);
            switch (varType) {
                case BOOLEAN:
                    result.gType = GeneralType.BOOL;
                    result.boolVal = (boolean) v;
                    return result;
                case BYTE:
                case CHAR:
                case SHORT:
                case INT:
                case LONG:
                    result.gType = GeneralType.INTEGER;
                    result.intVal = (long) v;
                    return result;
                case FLOAT:
                case DOUBLE:
                    result.gType = GeneralType.FP;
                    result.fpVal = (double) v;
                    return result;
                default:
                    throw new Exception("'varType' was not one of possible UnannTypes.");
            }
        } else
            throw new Exception("Variable " + name + " not available in context.");
    }

    public String getName() { return name; }
}
