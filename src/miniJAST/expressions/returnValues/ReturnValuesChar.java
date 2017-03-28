package miniJAST.expressions.returnValues;

import miniJAST.types.Type;
import miniJAST.types.PrimType;

public class ReturnValuesChar extends ReturnValues{
    public char value;

    public ReturnValuesChar(char v) { super(new Type(PrimType.CHAR), false); value = v; }
}
