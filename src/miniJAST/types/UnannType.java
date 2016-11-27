package miniJAST.types;

public enum UnannType {
    BOOLEAN, BYTE, CHAR, SHORT, INT, LONG, FLOAT, DOUBLE;

    public static boolean canBeAssigned(UnannType l, UnannType r) {
        if (l == BOOLEAN && r == BOOLEAN)
            return true;
        else if (l != BOOLEAN && r != BOOLEAN) {
            if (l.compareTo(r) >= 0)
                return true;
        }
        return false;
    }
}
