package miniJAST.statements;

import miniJAST.expressions.boolExpr.BoolExpr;

public class IfThenElseStmntNoShortIf implements StatementNoShortIf {
    private BoolExpr cond;
    private StatementNoShortIf trueStmnt;
    private StatementNoShortIf falseStmnt;
}
