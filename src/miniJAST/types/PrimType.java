package miniJAST.types;

public enum PrimType {
    BOOLEAN, CHAR, INT, DOUBLE;

    public String name;

    static {
        BOOLEAN.name = "boolean";
        CHAR.name = "char";
        INT.name = "int";
        DOUBLE.name = "double";
    }
}
