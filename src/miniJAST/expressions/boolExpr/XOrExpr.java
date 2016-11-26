package miniJAST.expressions.boolExpr;

public class XOrExpr extends IncOrExpr {
    private XOrExpr leftSide; // Left associative
    private AndExpr rightSide;
}
