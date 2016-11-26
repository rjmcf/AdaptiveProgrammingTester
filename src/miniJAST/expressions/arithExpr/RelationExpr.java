package miniJAST.expressions.arithExpr;

public class RelationExpr extends ArithEqExpr{
    private RelationOp op;
    private RelationExpr leftSide; // Left associative
    private ShiftExpr rightSide;
}
