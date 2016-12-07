package miniJAST.expressions.returnValues;

import miniJAST.types.UnannType;

public class ReturnValuesBoolean extends ReturnValues {
    public boolean value;

    public ReturnValuesBoolean(boolean v) { super(UnannType.BOOLEAN, 0); value = v; }
}
