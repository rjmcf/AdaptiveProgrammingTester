package miniJAST.statements;

import miniJAST.expressions.boolExpr.BoolExpr;

public class IfThenStmnt implements Statement {
    private BoolExpr cond;
    private Statement stmnt;
}
