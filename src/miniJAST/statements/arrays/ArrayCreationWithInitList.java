package miniJAST.statements.arrays;

import miniJAST.MiniJASTNode;
import miniJAST.expressions.Expression;

import java.util.ArrayList;

public class ArrayCreationWithInitList extends ArrayCreation {
    public ArrayCreationWithInitList() { hasInitList = true; }

    @Override
    public String stringRepr(int blocksDeep) {
        String result = name + "[] = { ";
        for (MiniJASTNode v : subNodes)
            result += ((Expression)v).stringRepr() + ", ";
        String result1 = result.substring(0, result.length()-2);
        result1 += " }";
        return result1;
    }

    public void setUPACWIL(String n) { subNodes.clear(); name = n; }
    public void addExpressionACWIL(Expression e) { subNodes.add(e); }
    public ArrayList<MiniJASTNode> getValues () { return subNodes; }

}
