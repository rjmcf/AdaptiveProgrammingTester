package miniJAST.expressions.returnValues;

import miniJAST.types.Type;
import miniJAST.types.UnannType;

public abstract class ReturnValues {
    protected Type type;
    protected boolean isArrayAccess;

    public ReturnValues(UnannType t, int s, boolean aa) { type = new Type(t,s); isArrayAccess = aa;}

    public Type getType() {return type;}
}
