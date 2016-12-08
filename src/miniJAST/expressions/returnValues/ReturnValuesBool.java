package miniJAST.expressions.returnValues;

import miniJAST.types.UnannType;

public class ReturnValuesBool extends ReturnValues {
    public boolean value;

    public ReturnValuesBool(boolean v) { super(UnannType.BOOLEAN, 1, false, false); value = v; }
}
