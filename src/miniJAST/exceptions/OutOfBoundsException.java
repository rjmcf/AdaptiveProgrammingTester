package miniJAST.exceptions;

public class OutOfBoundsException extends MiniJASTException {
    public OutOfBoundsException(int i, int s) {
        super(i + " cannot be used to index array of size " + s);
    }
}
