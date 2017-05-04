package miniJAST.exceptions;

public class BlankEmptyException extends MiniJASTException {
    public BlankEmptyException() {
        super("A blank has not been filled in the solution");
    }
}
