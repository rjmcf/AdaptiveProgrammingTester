package miniJAST.ForLoops;

import miniJAST.BoolExpression;
import miniJAST.StatementExpr;
import miniJAST.StatementNoShortIf;

import java.util.ArrayList;

public class ForStmntNoShortIf implements StatementNoShortIf {
    private ForInit init;
    private BoolExpression cond;
    private ArrayList<StatementExpr> updates;
    private StatementNoShortIf stmnt;
}
