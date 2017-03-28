package miniJAST.expressions.returnValues;

public class ReturnValuesBoolAA extends ReturnValuesBool implements ReturnValuesArrayAccess {
    private String name;
    private int index;

    public ReturnValuesBoolAA(String n, int i, boolean v) {
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
