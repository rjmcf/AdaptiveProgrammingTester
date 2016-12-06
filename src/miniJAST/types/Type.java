package miniJAST.types;

public class Type {
    public UnannType uType;
    public GeneralType gType;
    public int dims;

    public Type(GeneralType g, UnannType u, int d) { uType = u; gType = g; dims = d; }
}
