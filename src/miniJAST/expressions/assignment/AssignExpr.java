package miniJAST.expressions.assignment;

import miniJAST.expressions.Expression;
import miniJAST.expressions.StatementExpr;

public class AssignExpr extends Expression implements StatementExpr {
    private String lhs;
    private AssignOp op;
    private Expression expr;
}
