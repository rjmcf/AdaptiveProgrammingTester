package miniJAST.expressions.returnValues;

import miniJAST.types.PrimType;
import miniJAST.types.Type;

public abstract class ReturnValues {
    protected Type type;

    public ReturnValues(Type t) { type = t; }

    public PrimType getPType() {return type.pType;}
    public boolean getIsArray() { return type.isArray; }
    public Type getType() { return type; }
}
