package miniJAST.expressions.returnValues;

import miniJAST.types.Type;
import miniJAST.types.UnannType;

public abstract class ReturnValues {
    protected Type type;
    protected boolean isArrayAccess;
    protected boolean isArray;

    public ReturnValues(UnannType t, int s, boolean a, boolean aa) { type = new Type(t,s); isArray = a; isArrayAccess = aa;}

    public Type getType() {return type;}
    public boolean getIsArrayAccess() { return isArrayAccess; }
    public boolean getIsArray() { return isArray; }
}
