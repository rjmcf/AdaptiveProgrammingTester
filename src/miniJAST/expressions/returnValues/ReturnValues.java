package miniJAST.expressions.returnValues;

import miniJAST.types.GeneralType;
import miniJAST.types.Type;
import miniJAST.types.UnannType;

public abstract class ReturnValues {
    protected Type type;

    public ReturnValues(GeneralType g, UnannType t, int d) { type = new Type(g,t,d);}

    public Type getType() {return type;}
}
