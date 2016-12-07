package miniJAST.expressions;

import miniJAST.Context;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.types.Type;

public abstract class Expression {
    protected Type type;
    public abstract ReturnValues evaluate(Context c) throws Exception;
    public Type getType() { return type; }
}
