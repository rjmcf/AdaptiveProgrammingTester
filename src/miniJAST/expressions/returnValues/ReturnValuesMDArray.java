package miniJAST.expressions.returnValues;

import miniJAST.types.GeneralType;
import miniJAST.types.UnannType;

import java.util.ArrayList;
import java.util.Arrays;

public class ReturnValuesMDArray<T> extends ReturnValues{
    public int[] dimensionSizes;
    public int size;
    protected ArrayList<T> values;

    public ReturnValuesMDArray(UnannType t, int dims, int[] dimSizes) throws Exception{
        super(t==UnannType.BOOLEAN ? GeneralType.BOOL : t.compareTo(UnannType.FLOAT) < 0 ? GeneralType.INTEGER : GeneralType.FP,
                t, dims);
        if (dimSizes.length != dims) {
            throw new Exception("Dimension size must be specified for all dimensions!");
        }
        dimensionSizes = dimSizes;

        size = 1;
        for (int i : dimensionSizes) {
            size *= i;
        }

        values = new ArrayList<>(size);
    }

    public ReturnValues get(UnannType t, int[] indices) throws Exception{
        if (indices.length > type.dims) {
            throw new Exception("Cannot use more indices than there are dimensions!");
        }
        int index = 0;
        int valCount = 1;
        for (int i = 0; i < indices.length; i++) {
            for (int j = i+1; j < dimensionSizes.length; j++) {
                valCount *= dimensionSizes[j];
            }
            index += indices[i]*valCount;
            valCount = 1;
        }

        ReturnValues r;
        if (indices.length == type.dims) {
            switch (t) {
                case BOOLEAN:
                    r = new ReturnValuesBoolean((Boolean)values.get(index));
                    return r;
                case BYTE:
                    r = new ReturnValuesByte((Byte)values.get(index));
                    return r;
                case CHAR:
                    r = new ReturnValuesChar((Character) values.get(index));
                    return r;
                case SHORT:
                    r = new ReturnValuesShort((Short) values.get(index));
                    return r;
                case INT:
                    r = new ReturnValuesInt((Integer) values.get(index));
                    return r;
                case LONG:
                    r = new ReturnValuesLong((Long) values.get(index));
                    return r;
                case FLOAT:
                    r = new ReturnValuesFloat((Float) values.get(index));
                    return r;
                case DOUBLE:
                    r = new ReturnValuesDouble((Double) values.get(index));
                    return r;
                default:
                    throw new Exception("t is not one of possible UnanTypes");
            }
        }

        int newDims = type.dims - indices.length;
        int numValues = 1;
        for (int i = indices.length; i < dimensionSizes.length; i++) {
            numValues *= dimensionSizes[i];
        }
        ArrayList<T> newVals = (ArrayList<T>)values.subList(index,index+numValues);

        r = new ReturnValuesMDArray<T>(t, newDims, Arrays.copyOfRange(dimensionSizes, indices.length, dimensionSizes.length));
        ((ReturnValuesMDArray<T>)r).values = newVals;

        return r;
    }

    public void set(int[] indices, T e) throws Exception{
        if (indices.length != type.dims) {
            throw new Exception("Cannot assign to array with single element");
        }

        int index = 0;
        int valCount = 1;
        for (int i = 0; i < indices.length; i++) {
            for (int j = i+1; j < dimensionSizes.length; j++) {
                valCount *= dimensionSizes[j];
            }
            index += indices[i]*valCount;
            valCount = 1;
        }

        values.set(index, e);
    }
}
