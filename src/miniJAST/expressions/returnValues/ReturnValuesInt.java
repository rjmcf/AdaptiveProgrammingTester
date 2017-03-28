package miniJAST.expressions.returnValues;

import miniJAST.types.Type;
import miniJAST.types.PrimType;

public class ReturnValuesInt extends ReturnValues {
    public int value;

    public ReturnValuesInt(int v) { super(new Type(PrimType.INT), false); value = v;}
}
