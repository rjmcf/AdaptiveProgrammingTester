package miniJAST.exceptions;

public class VariableDecException extends MiniJASTException {
    public VariableDecException(String n, boolean deced) {
        super(deced ? "Variable " + n + " already declared in this scope" :
                        "Variable " + n + " not declared in this scope");
    }
}
