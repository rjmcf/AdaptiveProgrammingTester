package miniJAST.expressions.boolExpr;

public class IncOrExpr extends CondAndExpr {
    private IncOrExpr leftSide; // Left associative
    private XOrExpr rightSide;
}
