package miniJAST.statements;

import miniJAST.expressions.boolExpr.BoolExpr;

public class WhileStmnt implements Statement {
    private BoolExpr cond;
    private Statement stmnt;
}
