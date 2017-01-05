package miniJAST.statements.arrays;

import miniJAST.expressions.Expression;
import miniJAST.types.UnannType;

public class ArrayCreationWithSize extends ArrayCreation {
    private int size;

    public ArrayCreationWithSize() { hasInitList = false;}

    @Override
    public String stringRepr(UnannType t) {
        String result = name + "[] = new " + t.name + "[" + ((Expression)subNodes.get(size)).stringRepr() + "]";
        return result;
    }

    public void setUpACWS(String n, Expression s) { subNodes.clear(); name = n; size = 0; subNodes.add(s); }

    public Expression getSize() { return (Expression)subNodes.get(size); }
}
