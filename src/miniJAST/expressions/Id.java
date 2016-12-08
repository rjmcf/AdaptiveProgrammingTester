package miniJAST.expressions;

import miniJAST.Context;
import miniJAST.expressions.assignment.AssignLHS;
import miniJAST.expressions.returnValues.*;
import miniJAST.types.Type;

public class Id extends GroundExpr implements AssignLHS{
    private Type varType;
    private String name;

    @Override
    public ReturnValues evaluate(Context c) throws Exception{
        if (c.namesToTypes.get(name).equals(varType)) {
            if (varType.size == 1) {
                switch (varType.uType) {
                    case BOOLEAN:
                        return new ReturnValuesBoolean((boolean) c.namesToValues.get(name));
                    case CHAR:
                        return new ReturnValuesChar((char) c.namesToValues.get(name));
                    case INT:
                        return new ReturnValuesInt((int) c.namesToValues.get(name));
                    case DOUBLE:
                        return new ReturnValuesDouble((double) c.namesToValues.get(name));
                    default:
                        throw new Exception("'varType' was not one of possible UnannTypes.");
                }
            } else {
                return new ReturnValuesArray(varType.uType, varType.size);
            }
        } else
            throw new Exception("Variable " + name + " not available in context.");
    }

    public String getName() { return name; }
}
