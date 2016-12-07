package miniJAST.expressions.returnValues;

import miniJAST.types.UnannType;

import java.util.ArrayList;
import java.util.Arrays;

public class ReturnValuesMDArray<T> extends ReturnValues{
    public ArrayList<Integer> dimensionSizes;
    public int size;
    protected ArrayList<T> values;

    public ReturnValuesMDArray(UnannType t, int dims,  ArrayList<Integer> dimSizes) throws Exception{
        super(t, dims);
        if (dimSizes.size() != dims) {
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
            for (int j = i+1; j < dimensionSizes.size(); j++) {
                valCount *= dimensionSizes.get(j);
            }
            index += indices[i]*valCount;
            valCount = 1;
        }

        if (indices.length == type.dims) {
            switch (t) {
                case BOOLEAN:
                    return new ReturnValuesBoolean((Boolean)values.get(index));
                case CHAR:
                    return new ReturnValuesChar((Character) values.get(index));
                case INT:
                    return new ReturnValuesInt((Integer) values.get(index));
                case DOUBLE:
                    return new ReturnValuesDouble((Double) values.get(index));
                default:
                    throw new Exception("t is not one of possible UnanTypes");
            }
        }

        int newDims = type.dims - indices.length;
        int numValues = 1;
        for (int i = indices.length; i < dimensionSizes.size(); i++) {
            numValues *= dimensionSizes.get(i);
        }
        ArrayList<T> newVals = (ArrayList<T>)values.subList(index,index+numValues);

        ReturnValuesMDArray<T> r = new ReturnValuesMDArray<>(t, newDims, (ArrayList<Integer>) dimensionSizes.subList(indices.length, dimensionSizes.size()));
        r.values = newVals;

        return r;
    }

    public void set(int[] indices, T e) throws Exception{
        if (indices.length != type.dims) {
            throw new Exception("Cannot assign to array with single element");
        }

        int index = 0;
        int valCount = 1;
        for (int i = 0; i < indices.length; i++) {
            for (int j = i+1; j < dimensionSizes.size(); j++) {
                valCount *= dimensionSizes.get(j);
            }
            index += indices[i]*valCount;
            valCount = 1;
        }

        values.set(index, e);
    }
}
