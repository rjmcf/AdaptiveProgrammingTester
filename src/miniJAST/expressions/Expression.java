package miniJAST.expressions;

import miniJAST.Context;
import miniJAST.types.UnannType;

public abstract class Expression {
    protected UnannType type;
    public abstract ReturnValues evaluate(Context c);
}
