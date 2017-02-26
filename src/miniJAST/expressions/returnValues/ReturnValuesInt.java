package miniJAST.expressions.returnValues;

import miniJAST.types.Type;
import miniJAST.types.UnannType;

public class ReturnValuesInt extends ReturnValues {
    public int value;

    public ReturnValuesInt(int v) { super(new Type(UnannType.INT), false); value = v;}
}
