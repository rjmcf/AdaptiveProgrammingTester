package miniJAST.expressions.returnValues;

import miniJAST.types.UnannType;

public class ReturnValuesChar extends ReturnValues{
    public char value;

    public ReturnValuesChar(char v) { super(UnannType.CHAR, 0); value = v; }
}
