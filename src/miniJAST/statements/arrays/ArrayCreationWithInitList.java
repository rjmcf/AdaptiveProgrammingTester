package miniJAST.statements.arrays;

import miniJAST.expressions.Expression;
import miniJAST.statements.arrays.ArrayCreation;

import java.util.ArrayList;

public class ArrayCreationWithInitList extends ArrayCreation {
    private ArrayList<Expression> values;

    public ArrayCreationWithInitList() { hasInitList = true; values = new ArrayList<>(); }

    public void setUPACWIL(String n) { name = n; }
    public void addExpressionACWIL(Expression e) { values.add(e); }
    public ArrayList<Expression> getValues () { return values; }

}
