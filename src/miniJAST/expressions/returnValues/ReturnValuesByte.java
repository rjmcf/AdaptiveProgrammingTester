package miniJAST.expressions.returnValues;

import miniJAST.types.GeneralType;
import miniJAST.types.UnannType;

public class ReturnValuesByte extends ReturnValues{
    public byte value;

    public ReturnValuesByte(byte v) { super(GeneralType.INTEGER, UnannType.BYTE, 0); value = v; }
}
