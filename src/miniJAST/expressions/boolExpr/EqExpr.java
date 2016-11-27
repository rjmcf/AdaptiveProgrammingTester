package miniJAST.expressions.boolExpr;

public class EqExpr extends AndExpr {
    private boolean equalityTest;
    private EqExpr leftSide; // Left associative (allows arith eq test on left side)
    private RelationExpr rightSide;
}
