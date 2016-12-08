package miniJAST.expressions.returnValues;

public class ReturnValuesCharAA extends ReturnValuesChar implements ReturnValuesArrayAccess {
    private String name;
    private int index;

    public ReturnValuesCharAA(String n, int i, char v) {
        super(v);
        name = n;
        index = i;
        isArrayAccess = true;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getIndex() {
        return index;
    }
}