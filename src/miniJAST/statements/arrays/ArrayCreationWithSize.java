package miniJAST.statements.arrays;

import miniJAST.NodeCount;
import miniJAST.expressions.Expression;
import miniJAST.statements.arrays.ArrayCreation;

public class ArrayCreationWithSize extends ArrayCreation {
    private Expression size;

    public ArrayCreationWithSize() { hasInitList = false;}

    @Override
    public NodeCount getTreeSize() {
        NodeCount result = size.getTreeSize();
        result.filled++;
        return result;
    }

    public void setUpACWS(String n, Expression s) { name = n; size = s; }

    public Expression getSize() { return size; }
}
