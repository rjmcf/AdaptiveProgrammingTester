package miniJAST.ForLoops;

import miniJAST.BoolExpression;
import miniJAST.Statement;
import miniJAST.StatementExpr;

import java.util.ArrayList;

public class ForStmnt implements Statement {
    private ForInit init;
    private BoolExpression cond;
    private ArrayList<StatementExpr> updates;
    private Statement stmnt;
}
