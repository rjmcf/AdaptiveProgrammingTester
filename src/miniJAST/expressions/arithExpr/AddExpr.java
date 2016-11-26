package miniJAST.expressions.arithExpr;

public class AddExpr extends ShiftExpr {
    private boolean isPlus;
    private AddExpr leftSide; // Left associative
    private MultExpr rightSide;
}
