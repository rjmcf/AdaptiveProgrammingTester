package miniJAST.statements.DoAndWhileLoops;

import miniJAST.expressions.Expression;
import miniJAST.statements.StatementNoShortIf;

public class WhileStmntNoShortIf extends WhileStmntBase implements StatementNoShortIf {
    public void setUpWhileNSI(Expression c, StatementNoShortIf s) { baseSetUpCondLoop(c, s); }
}
