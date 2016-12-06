package miniJAST.expressions.returnValues;

import miniJAST.types.GeneralType;
import miniJAST.types.UnannType;

public class ReturnValuesInt extends ReturnValues {
    public int value;

    public ReturnValuesInt(int v) { super(GeneralType.INTEGER, UnannType.INT, 0); }
}
