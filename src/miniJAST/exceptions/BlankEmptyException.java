package miniJAST.exceptions;

public class BlankEmptyException extends MiniJASTException {
    public BlankEmptyException() {
        super("A Blank has not been filled in the solution");
    }
}
