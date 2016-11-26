package miniJAST.statements.ForLoops;

import miniJAST.statements.Statement;
import miniJAST.expressions.StatementExpr;

import java.util.ArrayList;

public class ForStmnt implements Statement {
    private ForInit init;
    //private BoolExpression cond;
    private ArrayList<StatementExpr> updates;
    private Statement stmnt;
}
