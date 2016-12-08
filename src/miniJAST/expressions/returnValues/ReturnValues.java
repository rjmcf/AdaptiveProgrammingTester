package miniJAST.expressions.returnValues;

import miniJAST.types.Type;
import miniJAST.types.UnannType;

public abstract class ReturnValues {
    protected Type type;

    public ReturnValues(UnannType t, int s) { type = new Type(t,s);}

    public Type getType() {return type;}
}
