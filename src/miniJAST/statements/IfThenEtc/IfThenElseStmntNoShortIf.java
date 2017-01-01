package miniJAST.statements.IfThenEtc;

import miniJAST.expressions.Expression;
import miniJAST.statements.StatementNoShortIf;

public class IfThenElseStmntNoShortIf extends IfThenElseBase implements StatementNoShortIf {
    public void setUpITENSI(Expression c, StatementNoShortIf t, StatementNoShortIf f) { baseSetUpITE(c, t, f); }
}
