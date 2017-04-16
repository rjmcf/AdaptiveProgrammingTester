package miniJAST.expressions;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.exceptions.VariableDecException;
import miniJAST.exceptions.VariableNotInitException;
import miniJAST.expressions.arithExpr.UnaryExpr;
import miniJAST.expressions.assignment.AssignLHS;
import miniJAST.expressions.returnValues.*;
import miniJAST.types.Type;

import java.util.ArrayList;

public class Id extends UnaryExpr implements AssignLHS{
    private Type varType;
    private String name;
    private boolean isArray;

    public void setUpId(String n) { name = n; }

    @Override
    public String stringRepr() {
        return name;
    }

    @Override
    public ReturnValues evaluate(Context c) throws MiniJASTException{
        if (c.namesToTypes.peek().get(name) != null) {
            varType = c.namesToTypes.peek().get(name);
            isArray = varType.isArray;
            if (!c.namesToValues.peek().containsKey(name))
                throw new VariableNotInitException(name);
            if (!isArray) {
                switch (varType.uType) {
                    case BOOLEAN:
                        return new ReturnValuesBool((boolean) c.namesToValues.peek().get(name));
                    case CHAR:
                        return new ReturnValuesChar((char) c.namesToValues.peek().get(name));
                    case INT:
                        return new ReturnValuesInt((int) c.namesToValues.peek().get(name));
                    case DOUBLE:
                        return new ReturnValuesDouble((double) c.namesToValues.peek().get(name));
                    default:
                        throw new TypeException("'varType' was not one of possible UnannTypes.");
                }
            } else {
                try {
                    switch (varType.uType) {
                        case BOOLEAN:
                            return new ReturnValuesArray<Boolean>(varType, (ArrayList<Boolean>) c.namesToValues.peek().get(name));
                        case CHAR:
                            return new ReturnValuesArray<Character>(varType, (ArrayList<Character>) c.namesToValues.peek().get(name));
                        case INT:
                            return new ReturnValuesArray<Integer>(varType, (ArrayList<Integer>) c.namesToValues.peek().get(name));
                        default: // DOUBLE
                            return new ReturnValuesArray<Double>(varType, (ArrayList<Double>) c.namesToValues.peek().get(name));
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
    public boolean getIsArray() { return isArray; }
}
