package miniJAST.statements.DoAndWhileLoops;

import miniJAST.expressions.Expression;
import miniJAST.statements.Statement;

public class WhileStmnt extends WhileStmntBase implements Statement {
    public void setUpWhile(Expression c, Statement s) { baseSetUpCondLoop(c, s); }
}
