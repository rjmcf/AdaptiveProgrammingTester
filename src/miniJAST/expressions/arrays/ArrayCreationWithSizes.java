package miniJAST.expressions.arrays;

import miniJAST.expressions.Expression;
import miniJAST.types.Type;

import java.util.ArrayList;

public class ArrayCreationWithSizes {
    protected Type type;
    protected ArrayList<Integer> dims;
    private ArrayList<Expression> dimExprs;
}
