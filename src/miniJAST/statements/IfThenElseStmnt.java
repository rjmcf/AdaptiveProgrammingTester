package miniJAST.statements;

import miniJAST.expressions.BoolExpression;

public class IfThenElseStmnt implements Statement{
    private BoolExpression cond;
    private StatementNoShortIf trueStmnt;
    private Statement falseStmnt;
}
