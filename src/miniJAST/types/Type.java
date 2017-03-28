package miniJAST.types;

public class Type {
    public PrimType uType;
    public boolean isArray;
    public int size;

    public Type(PrimType u) { uType = u; isArray = false; size = 1; }
    public Type(PrimType u, int s) { uType = u; isArray = true; size = s; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Type type = (Type) o;

        if (size != type.size) return false;
        return uType == type.uType;
    }
}
