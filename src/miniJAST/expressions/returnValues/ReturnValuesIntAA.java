package miniJAST.expressions.returnValues;

public class ReturnValuesIntAA extends ReturnValuesInt implements ReturnValuesArrayAccess {
    private String name;
    private int index;

    public ReturnValuesIntAA(String n, int i, int v) {
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
