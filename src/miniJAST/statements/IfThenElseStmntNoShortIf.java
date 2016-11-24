package miniJAST.statements;

import miniJAST.expressions.BoolExpression;

public class IfThenElseStmntNoShortIf implements StatementNoShortIf {
    private BoolExpression cond;
    private StatementNoShortIf trueStmnt;
    private StatementNoShortIf falseStmnt;
}
