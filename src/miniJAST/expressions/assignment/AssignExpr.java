package miniJAST.expressions.assignment;

import miniJAST.expressions.Expression;

public class AssignExpr extends Expression {
    private String lhs;
    private AssignOp op;
    private Expression expr;
}
