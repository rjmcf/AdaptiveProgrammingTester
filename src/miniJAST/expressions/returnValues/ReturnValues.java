package miniJAST.expressions.returnValues;

import miniJAST.types.Type;
import miniJAST.types.UnannType;

public abstract class ReturnValues {
    protected Type type;
    protected boolean isArrayAccess;

    public ReturnValues(Type t, boolean aa) { type = t; isArrayAccess = aa;}

    public Type getType() {return type;}
    public boolean getIsArrayAccess() { return isArrayAccess; }
    public boolean getIsArray() { return type.isArray; }
}
