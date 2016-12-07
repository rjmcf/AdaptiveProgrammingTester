package miniJAST.expressions.returnValues;

import miniJAST.types.UnannType;

public class ReturnValuesDouble extends ReturnValues{
    public double value;

    public ReturnValuesDouble(double v) { super(UnannType.DOUBLE, 0); value = v; }
}
