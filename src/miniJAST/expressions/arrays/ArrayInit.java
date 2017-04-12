package miniJAST.expressions.arrays;

import miniJAST.Context;
import miniJAST.MiniJASTNode;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.returnValues.*;
import miniJAST.types.PrimType;
import miniJAST.types.Type;

import java.util.ArrayList;

public class ArrayInit extends ArrayAssignRightSide {

    public ArrayInit() { subNodes.clear(); }
    public void addExpression(Expression e) { subNodes.add(e); }

    @Override
    public ReturnValues evaluate(Context c) throws MiniJASTException {
        sizeOnceEvaluated = subNodes.size();
        if (subNodes.size() == 0) {
            return new ReturnValuesArray<>(new Type(null, 0), new ArrayList<>());
        }
        Expression first = subNodes.get(0);
        ReturnValues r = first.evaluate(c);
        type = r.getType().uType;
        switch (type) {
            case BOOLEAN:
                ArrayList<Boolean> bList = new ArrayList<>();
                bList.add(((ReturnValuesBool)r).value);
                try {
                    for (int i = 1; i < subNodes.size(); i++) {
                        bList.add(((ReturnValuesBool) subNodes.get(i).evaluate(c)).value);
                    }
                    return new ReturnValuesArray<>(new Type(PrimType.BOOLEAN, subNodes.size()), bList);
                } catch (ClassCastException ce) {
                    throw new TypeException("All values must be of type Boolean.");
                }
            case CHAR:
                ArrayList<Character> cList = new ArrayList<>();
                cList.add(((ReturnValuesChar)r).value);
                try {
                    for (int i = 1; i < subNodes.size(); i++) {
                        cList.add(((ReturnValuesChar) subNodes.get(i).evaluate(c)).value);
                    }
                    return new ReturnValuesArray<>(new Type(PrimType.CHAR, subNodes.size()), cList);
                } catch (ClassCastException ce) {
                    throw new TypeException("All values must be of type Character.");
                }
            case INT:
                ArrayList<Integer> iList = new ArrayList<>();
                iList.add(((ReturnValuesInt)r).value);
                try {
                    for (int i = 1; i < subNodes.size(); i++) {
                        iList.add(((ReturnValuesInt) subNodes.get(i).evaluate(c)).value);
                    }
                    return new ReturnValuesArray<>(new Type(PrimType.INT, subNodes.size()), iList);
                } catch (ClassCastException ce) {
                    throw new TypeException("All values must be of type Integer.");
                }
            default: //double
                ArrayList<Double> dList = new ArrayList<>();
                dList.add(((ReturnValuesDouble)r).value);
                try {
                    for (int i = 1; i < subNodes.size(); i++) {
                        dList.add(((ReturnValuesDouble) subNodes.get(i).evaluate(c)).value);
                    }
                    return new ReturnValuesArray<>(new Type(PrimType.DOUBLE, subNodes.size()), dList);
                } catch (ClassCastException ce) {
                    throw new TypeException("All values must be of type Double.");
                }
        }
    }

    @Override
    public String stringRepr() {
        String result = "{ ";
        for (MiniJASTNode v : subNodes)
            result += ((Expression)v).stringRepr() + ", ";
        String result1 = result.substring(0, result.length()-2);
        result1 += " }";
        return result1;
    }
}
