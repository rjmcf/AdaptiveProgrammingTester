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

    public void setUpId(String n) { name = n; }

    @Override
    public String stringRepr() {
        return name;
    }

    public boolean checkDefined(Context c) throws MiniJASTException {
        Type vT = c.namesToTypes.peek().get(name);
        if (vT == null)
            throw new VariableDecException(name, false);
        varType = vT;
        return c.namesToValues.peek().get(name) != null;
    }

    @Override
    public ReturnValues evaluate(Context c) throws MiniJASTException{
        if (c.namesToTypes.peek().get(name) != null) {
            varType = c.namesToTypes.peek().get(name);
            if (!c.namesToValues.peek().containsKey(name))
                throw new VariableNotInitException(name);
            if (!varType.isArray) {
                switch (varType.pType) {
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
                    switch (varType.pType) {
                        case BOOLEAN:
                            return new ReturnValuesArray<Boolean>(varType.pType, (ArrayList<Boolean>) c.namesToValues.peek().get(name));
                        case CHAR:
                            return new ReturnValuesArray<Character>(varType.pType, (ArrayList<Character>) c.namesToValues.peek().get(name));
                        case INT:
                            return new ReturnValuesArray<Integer>(varType.pType, (ArrayList<Integer>) c.namesToValues.peek().get(name));
                        default: // DOUBLE
                            return new ReturnValuesArray<Double>(varType.pType, (ArrayList<Double>) c.namesToValues.peek().get(name));
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
    public boolean getIsArray() { return varType.isArray; }
}
