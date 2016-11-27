package miniJAST.expressions.assignment;

import miniJAST.expressions.Expression;
import miniJAST.expressions.StatementExpr;

public class AssignExpr extends Expression implements StatementExpr {
    private AssignLHS lhs;
    private AssignOp op;
    private Expression expr;
}
