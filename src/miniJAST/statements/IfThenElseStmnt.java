package miniJAST.statements;

import miniJAST.expressions.boolExpr.BoolExpr;

public class IfThenElseStmnt implements Statement{
    private BoolExpr cond;
    private StatementNoShortIf trueStmnt;
    private Statement falseStmnt;
}
