package miniJAST.expressions.returnValues;

public class ReturnValuesDoubleAA extends ReturnValuesDouble implements ReturnValuesArrayAccess {
    private String name;
    private int index;

    public ReturnValuesDoubleAA(String n, int i, double v) {
        super(v);
        name = n;
        index = i;
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