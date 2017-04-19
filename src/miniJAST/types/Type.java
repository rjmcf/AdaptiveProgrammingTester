package miniJAST.types;

public class Type {
    public PrimType uType;
    public boolean isArray;

    public Type(PrimType u, boolean isA) { uType = u; isArray = isA; }
}
