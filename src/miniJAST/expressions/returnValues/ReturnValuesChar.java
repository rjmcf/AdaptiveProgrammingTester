package miniJAST.expressions.returnValues;

import miniJAST.types.Type;
import miniJAST.types.UnannType;

public class ReturnValuesChar extends ReturnValues{
    public char value;

    public ReturnValuesChar(char v) { super(new Type(UnannType.CHAR), false); value = v; }
}
