package miniJAST.expressions.returnValues;

import miniJAST.types.GeneralType;
import miniJAST.types.UnannType;

public class ReturnValuesChar extends ReturnValues{
    public char value;

    public ReturnValuesChar(char v) { super(GeneralType.INTEGER, UnannType.CHAR, 0); value = v; }
}
