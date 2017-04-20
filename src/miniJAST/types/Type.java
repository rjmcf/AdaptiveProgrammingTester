package miniJAST.types;

public class Type {
    public PrimType pType;
    public boolean isArray;

    public Type(PrimType p, boolean isA) { pType = p; isArray = isA; }
}
