package miniJAST.statements.arrays;

import miniJAST.expressions.Expression;
import miniJAST.statements.arrays.ArrayCreation;

public class ArrayCreationWithSize extends ArrayCreation {
    private Expression size;

    public ArrayCreationWithSize() { hasInitList = false;}

    @Override
    public int getSubNodes() {
        int s = size.getSubNodes();
        return s + 1;
    }

    public void setUpACWS(String n, Expression s) { name = n; size = s; }

    public Expression getSize() { return size; }
}
