package miniJAST.expressions.returnValues;

import miniJAST.types.GeneralType;
import miniJAST.types.UnannType;

public class ReturnValuesFloat extends ReturnValues {
    public float value;

    public ReturnValuesFloat(float v) { super(GeneralType.FP, UnannType.FLOAT, 0); value = v; }
}
