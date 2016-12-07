package miniJAST.expressions;

import miniJAST.Context;
import miniJAST.expressions.returnValues.ReturnValues;

public abstract class Expression {
    public abstract ReturnValues evaluate(Context c) throws Exception;
}
