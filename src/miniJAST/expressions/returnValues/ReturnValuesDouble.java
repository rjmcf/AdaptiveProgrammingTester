package miniJAST.expressions.returnValues;

import miniJAST.types.GeneralType;
import miniJAST.types.UnannType;

public class ReturnValuesDouble extends ReturnValues{
    public double value;

    public ReturnValuesDouble(double v) { super(GeneralType.FP, UnannType.DOUBLE, 0); value = v; }
}
