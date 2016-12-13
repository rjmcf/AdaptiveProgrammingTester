package miniJAST.statements.arrays;

import miniJAST.expressions.Expression;
import miniJAST.statements.arrays.ArrayCreation;

public class ArrayCreationWithSize extends ArrayCreation {
    private Expression size;

    public ArrayCreationWithSize() { hasInitList = false;}

    public void setUp(Expression s) { size = s; }

    public Expression getSize() { return size; }
}
