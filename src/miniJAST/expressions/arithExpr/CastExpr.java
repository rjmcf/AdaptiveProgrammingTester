package miniJAST.expressions.arithExpr;

import miniJAST.types.UnannType;

public class CastExpr extends UnaryExpr {
    private UnannType type;
    private UnaryExpr expr;
}
