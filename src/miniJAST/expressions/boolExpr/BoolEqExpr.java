package miniJAST.expressions.boolExpr;

import miniJAST.expressions.GroundExpr;

public class BoolEqExpr extends AndExpr implements EqExpr {
    private boolean equalityTest;
    private EqExpr leftSide; // Left associative (allows arith eq test on left side)
    private GroundExpr rightSide;
}
