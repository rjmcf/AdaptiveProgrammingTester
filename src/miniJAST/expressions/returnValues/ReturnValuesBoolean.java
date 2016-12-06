package miniJAST.expressions.returnValues;

import miniJAST.types.GeneralType;
import miniJAST.types.UnannType;

public class ReturnValuesBoolean extends ReturnValues {
    public boolean value;

    public ReturnValuesBoolean(boolean v) { super(GeneralType.BOOL, UnannType.BOOLEAN, 0); value = v; }
}
