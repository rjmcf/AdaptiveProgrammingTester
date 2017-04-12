package miniJAST.expressions.arrays;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.ExpressionBase;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesArray;
import miniJAST.expressions.returnValues.ReturnValuesInt;
import miniJAST.types.PrimType;
import miniJAST.types.Type;

import java.util.ArrayList;

public class ArrayCreation extends ArrayAssignRightSide {
    private int size;

    public ArrayCreation(PrimType t, Expression s) {
        subNodes.clear();
        type = t;
        size = 0;
        subNodes.add(s);
    }

    @Override
    public ReturnValues evaluate(Context c) throws MiniJASTException {
        checkType(subNodes.get(size), Expression.class);
        ReturnValues r = subNodes.get(size).evaluate(c);
        if (r.getType().uType != PrimType.INT) {
            throw new TypeException("Size must be an integer!");
        }
        ReturnValuesInt s = (ReturnValuesInt)r;
        sizeOnceEvaluated = s.value;
        ArrayList list = new ArrayList(s.value);
        for (int i = 0; i < s.value; i++) {
            list.add(type.defaultVal);
        }
        return new ReturnValuesArray<>(new Type(type, s.value), list);
    }

    @Override
    public String stringRepr() {
        return "new " + type.name + "[" + subNodes.get(size).stringRepr() + "]";
    }
}
