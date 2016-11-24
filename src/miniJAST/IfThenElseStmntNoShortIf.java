package miniJAST;

public class IfThenElseStmntNoShortIf implements StatementNoShortIf {
    private BoolExpression cond;
    private StatementNoShortIf trueStmnt;
    private StatementNoShortIf falseStmnt;
}
