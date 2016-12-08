package miniJAST.expressions.returnValues;

import miniJAST.types.UnannType;

public class ReturnValuesInt extends ReturnValues {
    public int value;

    public ReturnValuesInt(int v) { super(UnannType.INT, 1, false, false); value = v;}
}
