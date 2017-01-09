package miniJAST.statements.arrays;

import miniJAST.expressions.Expression;
import miniJAST.types.UnannType;

public class ArrayCreationWithSize extends ArrayCreation {
    private int size;
    private UnannType type;

    public ArrayCreationWithSize() { hasInitList = false;}

    @Override
    public String stringRepr(int blocksDeep) {
        String result = name + "[] = new " + type.name + "[" + ((Expression)subNodes.get(size)).stringRepr() + "]";
        return result;
    }

    public void setUpACWS(String n, UnannType t, Expression s) { subNodes.clear(); name = n; type = t; size = 0; subNodes.add(s); }

    public Expression getSize() { return (Expression)subNodes.get(size); }
}
