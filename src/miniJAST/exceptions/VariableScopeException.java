package miniJAST.exceptions;

public class VariableScopeException extends MiniJASTException{
    public VariableScopeException(String n, boolean inited) {
        super(inited ? "Variable " + n + " already initialised in this scope" :
                "Variable " + n + " not initialised in this scope");
    }
}
