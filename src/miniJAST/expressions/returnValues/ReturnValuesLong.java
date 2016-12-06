package miniJAST.expressions.returnValues;

import miniJAST.types.GeneralType;
import miniJAST.types.UnannType;

public class ReturnValuesLong extends ReturnValues{
    public long value;

    public ReturnValuesLong(long v) { super(GeneralType.INTEGER, UnannType.LONG, 0); value = v; }
}
