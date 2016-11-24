package miniJAST;

public class BoolExpression extends Expression {
    private boolean isVar;
    private String var; // var is "true", "false", or an identifier

    private OpResultBool op;
    private BoolExpression b1;
    private BoolExpression b2;
}
