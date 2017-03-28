package miniJAST.expressions.returnValues;

import miniJAST.types.Type;

import java.util.ArrayList;

public class ReturnValuesArray<T> extends ReturnValues{
    protected ArrayList<T> values;

    public ReturnValuesArray(Type t, ArrayList<T> vs){
        super(new Type(t.uType, t.size), false);

        values = vs;
    }

    public T get(int index){
        return values.get(index);
    }

    public void set(int index, T e){
        values.set(index, e);
    }

    public int getSize() { return values.size(); }
}
