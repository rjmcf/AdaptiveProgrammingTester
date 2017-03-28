package miniJAST.expressions.returnValues;

import miniJAST.types.Type;
import miniJAST.types.PrimType;

public class ReturnValuesBool extends ReturnValues {
    public boolean value;

    public ReturnValuesBool(boolean v) { super(new Type(PrimType.BOOLEAN), false); value = v; }
}
