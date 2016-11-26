package miniJAST.expressions.arithExpr;

public class ShiftExpr extends RelationExpr {
    private ShiftOp op;
    private ShiftExpr leftSide; // Left associative
    private AddExpr rightSide;
}
