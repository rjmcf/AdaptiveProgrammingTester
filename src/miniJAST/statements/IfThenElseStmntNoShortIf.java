package miniJAST.statements;

import miniJAST.expressions.Expression;

public class IfThenElseStmntNoShortIf implements StatementNoShortIf {
    private Expression cond;
    private StatementNoShortIf trueStmnt;
    private StatementNoShortIf falseStmnt;
}
