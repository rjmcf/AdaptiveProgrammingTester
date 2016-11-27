package miniJAST.expressions;

import miniJAST.types.UnannType;

public class ReturnValues {
    public boolean boolVal;
    public byte byteVal;
    public short sVal;
    public int iVal;
    public long lVal;
    public char cVal;
    public float fVal;
    public double dVal;

    public Object objectVal(UnannType t) throws Exception{
        switch (t) {
            case BOOLEAN:
                return boolVal;
            case BYTE:
                return byteVal;
            case CHAR:
                return cVal;
            case SHORT:
                return sVal;
            case INT:
                return iVal;
            case LONG:
                return lVal;
            case FLOAT:
                return fVal;
            case DOUBLE:
                return dVal;
            default:
                throw new Exception("'type' not one of possible UnannTypes in ReturnValues.objectVal");
        }
    }
}
