package miniJAST.expressions;

import miniJAST.Context;
import miniJAST.expressions.assignment.AssignLHS;
import miniJAST.expressions.returnValues.*;
import miniJAST.types.Type;
import miniJAST.types.UnannType;

import java.util.ArrayList;

public class Id extends GroundExpr implements AssignLHS{
    private Type varType;
    private String name;

    public Id(Type vT, String n) { varType = vT; name = n; }

    @Override
    public ReturnValues evaluate(Context c) throws Exception{
        if (c.namesToTypes.get(name).equals(varType)) {
            if (!c.namesToValues.containsKey(name))
                throw new Exception("Variable not initialised");
            if (varType.size == 1) {
                switch (varType.uType) {
                    case BOOLEAN:
                        return new ReturnValuesBool((boolean) c.namesToValues.get(name));
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
                switch (varType.uType) {
                    case BOOLEAN:
                        return new ReturnValuesArray<Boolean>(UnannType.BOOLEAN, (ArrayList<Boolean>)c.namesToValues.get(name));
                    case CHAR:
                        return new ReturnValuesArray<Character>(UnannType.BOOLEAN, (ArrayList<Character>)c.namesToValues.get(name));
                    case INT:
                        return new ReturnValuesArray<Integer>(UnannType.BOOLEAN, (ArrayList<Integer>)c.namesToValues.get(name));
                    default: // DOUBLE
                        return new ReturnValuesArray<Double>(UnannType.BOOLEAN, (ArrayList<Double>)c.namesToValues.get(name));
                }
            }
        } else
            throw new Exception("Variable " + name + " not available in context.");
    }

    public String getName() { return name; }
}
