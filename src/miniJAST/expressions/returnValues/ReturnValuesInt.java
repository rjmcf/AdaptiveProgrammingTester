package miniJAST.expressions.returnValues;

import miniJAST.types.UnannType;

public class ReturnValuesInt extends ReturnValues {
    public int value;

    public ReturnValuesInt(int v) { super(UnannType.INT, false); value = v;}
}
