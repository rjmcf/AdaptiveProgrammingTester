package miniJAST.expressions.boolExpr;

public class AndExpr extends XOrExpr {
    private AndExpr leftSide; // Left associative
    private BoolEqExpr rightSide;
}
