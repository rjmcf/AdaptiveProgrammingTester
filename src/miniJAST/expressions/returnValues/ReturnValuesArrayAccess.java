package miniJAST.expressions.returnValues;

import miniJAST.types.UnannType;

public class ReturnValuesArrayAccess<T> extends ReturnValues {
    public int index;
    public String name;
    public T value;

    public ReturnValuesArrayAccess(UnannType t, String n, int i, T e) {
        super(t, 1, false, true);
        name = n;
        index = i;
        value = e;
    }
}
