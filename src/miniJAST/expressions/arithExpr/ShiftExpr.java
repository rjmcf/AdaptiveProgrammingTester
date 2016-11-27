package miniJAST.expressions.arithExpr;

import miniJAST.expressions.boolExpr.RelationExpr;

public class ShiftExpr extends RelationExpr {
    private ShiftOp op;
    private ShiftExpr leftSide; // Left associative
    private AddExpr rightSide;
}
