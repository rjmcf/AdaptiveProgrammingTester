package miniJAST.types;

public enum UnannType {
    BOOLEAN, CHAR, INT, DOUBLE;

    public String name;

    static {
        BOOLEAN.name = "boolean";
        CHAR.name = "char";
        INT.name = "int";
        DOUBLE.name = "double";
    }
}
