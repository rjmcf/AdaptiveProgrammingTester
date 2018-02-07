package miniJAST.types;

public enum PrimType {
    BOOLEAN, CHAR, INT, DOUBLE;

    public String name;
    public Object defaultVal;

    static {
        BOOLEAN.name = "boolean";
        BOOLEAN.defaultVal = false;
        CHAR.name = "char";
        CHAR.defaultVal = '\0';
        INT.name = "int";
        INT.defaultVal = 0;
        DOUBLE.name = "double";
        DOUBLE.defaultVal = 0.0;
    }
}
