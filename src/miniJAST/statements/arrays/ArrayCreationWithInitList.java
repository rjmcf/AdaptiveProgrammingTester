package miniJAST.statements.arrays;

import miniJAST.expressions.Expression;
import miniJAST.statements.arrays.ArrayCreation;

import java.util.ArrayList;

public class ArrayCreationWithInitList extends ArrayCreation {
    private ArrayList<Expression> values;

    public ArrayCreationWithInitList() { hasInitList = true; }
    public ArrayList<Expression> getValues () { return values; }

}
