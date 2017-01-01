package miniJAST.statements.IfThenEtc;

import miniJAST.expressions.Expression;
import miniJAST.statements.Statement;
import miniJAST.statements.StatementNoShortIf;

public class IfThenElseStmnt extends IfThenElseBase implements Statement {
    public void setUpITE(Expression c, StatementNoShortIf t, Statement f) { baseSetUpITE(c, t, f); }
}
