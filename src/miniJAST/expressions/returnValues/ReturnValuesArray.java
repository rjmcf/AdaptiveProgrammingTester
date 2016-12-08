package miniJAST.expressions.returnValues;

import miniJAST.types.UnannType;

import java.util.ArrayList;
import java.util.Arrays;

public class ReturnValuesArray<T> extends ReturnValues{
    protected ArrayList<T> values;

    public ReturnValuesArray(UnannType t, int s) throws Exception{
        super(t, s);

        values = new ArrayList<>(type.size);
    }

    public ReturnValues get(UnannType t, int index) throws Exception{
        switch (t) {
            case BOOLEAN:
                return new ReturnValuesBoolean((Boolean) values.get(index));
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

    public void set(int index, T e) throws Exception{
        values.set(index, e);
    }
}
