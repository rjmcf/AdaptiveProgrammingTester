package miniJAST.exceptions;

public class VariableNotInitException extends MiniJASTException{
    public VariableNotInitException(String n) {
        super("Variable " + n + " not initialised in this scope");
    }
}
