package miniJAST.statements.ForLoops;

import miniJAST.expressions.StatementExpr;
import miniJAST.statements.StatementNoShortIf;

import java.util.ArrayList;

public class ForStmntNoShortIf implements StatementNoShortIf {
    private ForInit init;
    //private BoolExpression cond;
    private ArrayList<StatementExpr> updates;
    private StatementNoShortIf stmnt;
}
