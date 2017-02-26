package miniJAST.expressions.returnValues;

import miniJAST.types.Type;
import miniJAST.types.UnannType;

public class ReturnValuesDouble extends ReturnValues{
    public double value;

    public ReturnValuesDouble(double v) { super(new Type(UnannType.DOUBLE), false); value = v; }
}
