package miniJAST.statements;

import miniJAST.expressions.Expression;

public class IfThenElseStmnt implements Statement{
    private Expression cond;
    private StatementNoShortIf trueStmnt;
    private Statement falseStmnt;
}
