package miniJAST.statements.ForLoops;

import miniJAST.statements.StatementNoShortIf;

public class ForStmntNoShortIf extends ForStmntBase implements StatementNoShortIf {
    public void setBodyNSI(StatementNoShortIf s) { baseSetBody(s); }
}
