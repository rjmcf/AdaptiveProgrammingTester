package miniJAST.expressions.arithExpr;

public class MultExpr extends AddExpr {
    private MultOp op;
    private MultExpr leftSide; // Left associative
    private UnaryPrefixExpr rightSide;
}
