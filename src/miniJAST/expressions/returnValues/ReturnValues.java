package miniJAST.expressions.returnValues;

import miniJAST.types.Type;
import miniJAST.types.UnannType;

public abstract class ReturnValues {
    protected Type type;

    public ReturnValues(UnannType t, boolean a) { type = new Type(t,a);}

    public Type getType() {return type;}
}
