package miniJAST.expressions;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.exceptions.VariableDecException;
import miniJAST.exceptions.VariableNotInitException;
import miniJAST.expressions.assignment.AssignLHS;
import miniJAST.expressions.returnValues.*;
import miniJAST.types.Type;
import miniJAST.types.UnannType;

import java.util.ArrayList;

public class Id extends GroundExpr implements AssignLHS{
    private Type varType;
    private String name;

    public void setUpId(Type vT, String n) { varType = vT; name = n; }

    @Override
    public ReturnValues evaluate(Context c) throws MiniJASTException{
        if (c.namesToTypes.get(name).equals(varType)) {
            if (!c.namesToValues.containsKey(name))
                throw new VariableNotInitException(name);
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
                        throw new TypeException("'varType' was not one of possible UnannTypes.");
                }
            } else {
                try {
                    switch (varType.uType) {
                        case BOOLEAN:
                            return new ReturnValuesArray<Boolean>(UnannType.BOOLEAN, (ArrayList<Boolean>) c.namesToValues.get(name));
                        case CHAR:
                            return new ReturnValuesArray<Character>(UnannType.BOOLEAN, (ArrayList<Character>) c.namesToValues.get(name));
                        case INT:
                            return new ReturnValuesArray<Integer>(UnannType.BOOLEAN, (ArrayList<Integer>) c.namesToValues.get(name));
                        default: // DOUBLE
                            return new ReturnValuesArray<Double>(UnannType.BOOLEAN, (ArrayList<Double>) c.namesToValues.get(name));
                    }
                } catch (Exception e) {
                    throw new TypeException("Array cast failed");
                }
            }
        } else
            throw new VariableDecException(name, false);
    }

    public String getName() { return name; }
    public Type getType() { return varType; }
}
