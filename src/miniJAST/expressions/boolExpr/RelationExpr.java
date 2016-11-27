package miniJAST.expressions.boolExpr;

import miniJAST.expressions.arithExpr.RelationOp;
import miniJAST.expressions.arithExpr.ShiftExpr;

public class RelationExpr extends EqExpr {
    private RelationOp op;
    private RelationExpr leftSide; // Left associative
    private ShiftExpr rightSide;
}
