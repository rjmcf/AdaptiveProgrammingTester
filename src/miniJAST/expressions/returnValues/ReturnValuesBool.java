package miniJAST.expressions.returnValues;

import miniJAST.types.Type;
import miniJAST.types.UnannType;

public class ReturnValuesBool extends ReturnValues {
    public boolean value;

    public ReturnValuesBool(boolean v) { super(new Type(UnannType.BOOLEAN), false); value = v; }
}
