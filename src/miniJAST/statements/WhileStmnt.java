package miniJAST.statements;

import miniJAST.expressions.BoolExpression;

public class WhileStmnt implements Statement {
    private BoolExpression cond;
    private Statement stmnt;
}
