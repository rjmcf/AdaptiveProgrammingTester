package miniJAST.expressions.returnValues;

import miniJAST.types.Type;

public abstract class ReturnValues {
    protected Type type;

    public ReturnValues(Type t) { type = t; }

    public Type getType() {return type;}
    public boolean getIsArray() { return type.isArray; }
}
