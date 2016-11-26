package miniJAST.expressions.arithExpr;

import miniJAST.expressions.Expression;
import miniJAST.expressions.boolExpr.EqExpr;

public class ArithEqExpr extends Expression implements EqExpr {
    private boolean equalTest;
    private ArithEqExpr leftSide; // Left associative
    private RelationExpr rightSide;
}
