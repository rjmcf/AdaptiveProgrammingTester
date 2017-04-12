package miniJAST.expressions.arrays;

import miniJAST.expressions.Expression;
import miniJAST.expressions.ExpressionBase;
import miniJAST.types.PrimType;

public abstract class ArrayAssignRightSide extends ExpressionBase implements Expression {
    protected PrimType type;
    protected int sizeOnceEvaluated;

    public PrimType getType() { return type; }
    public int getSizeOnceEvaluated() { return sizeOnceEvaluated; }
}
