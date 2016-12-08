package miniJAST.types;

public class Type {
    public UnannType uType;
    public boolean isArray;

    public Type(UnannType u, boolean a) { uType = u; isArray = a; }
}
