package miniJAST.expressions.boolExpr;

public class CondAndExpr extends CondOrExpr {
    private CondAndExpr leftSide; // Left associative
    private IncOrExpr rightSide;
}
