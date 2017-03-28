package miniJAST.expressions.returnValues;

import miniJAST.types.Type;
import miniJAST.types.PrimType;

public class ReturnValuesDouble extends ReturnValues{
    public double value;

    public ReturnValuesDouble(double v) { super(new Type(PrimType.DOUBLE), false); value = v; }
}
