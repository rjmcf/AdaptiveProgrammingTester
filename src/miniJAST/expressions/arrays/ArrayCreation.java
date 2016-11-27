package miniJAST.expressions.arrays;

import miniJAST.expressions.PrimaryExpr;
import miniJAST.types.UnannType;

import java.util.ArrayList;


public abstract class ArrayCreation extends PrimaryExpr {
    protected UnannType type;
    protected ArrayList<Integer> dims;
}
