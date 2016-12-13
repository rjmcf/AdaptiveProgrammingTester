package miniJAST.expressions.returnValues;

import miniJAST.types.UnannType;

import java.util.ArrayList;
import java.util.Arrays;

public class ReturnValuesArray<T> extends ReturnValues{
    protected ArrayList<T> values;

    public ReturnValuesArray(UnannType t, ArrayList<T> vs) throws Exception{
        super(t, vs.size(), true, false);

        values = vs;
    }

    public T get(int index) throws Exception{
        return values.get(index);
    }

    public void set(int index, T e) throws Exception{
        values.set(index, e);
    }

    public int getSize() { return values.size(); }
}
