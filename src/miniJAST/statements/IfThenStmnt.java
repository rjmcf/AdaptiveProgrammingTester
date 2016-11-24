package miniJAST.statements;

import miniJAST.expressions.BoolExpression;

public class IfThenStmnt implements Statement {
    private BoolExpression cond;
    private Statement stmnt;
}
