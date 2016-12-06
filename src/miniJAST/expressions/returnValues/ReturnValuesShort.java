package miniJAST.expressions.returnValues;

import miniJAST.types.GeneralType;
import miniJAST.types.UnannType;

public class ReturnValuesShort extends ReturnValues {
    public short value;

    public ReturnValuesShort(short v) { super(GeneralType.INTEGER, UnannType.SHORT, 0); value = v; }
}
