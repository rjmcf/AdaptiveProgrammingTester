package miniJAST.types;

public class Type {
    public UnannType uType;
    public int size;

    public Type(UnannType u, int s) { uType = u; size = s; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Type type = (Type) o;

        if (size != type.size) return false;
        return uType == type.uType;
    }
}
