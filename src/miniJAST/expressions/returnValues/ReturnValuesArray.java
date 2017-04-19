package miniJAST.expressions.returnValues;

import miniJAST.types.PrimType;
import miniJAST.types.Type;

import java.util.ArrayList;

public class ReturnValuesArray<T> extends ReturnValues{
    protected ArrayList<T> values;

    public ReturnValuesArray(PrimType t, ArrayList<T> vs){
        super(new Type(t, true));

        values = vs;
    }

    public T get(int index){
        return values.get(index);
    }
    public ArrayList<T> getArray() { return values; }
    public int getSize() { return values.size(); }
}
