package miniJAST.statements.ForLoops;

import miniJAST.Context;
import miniJAST.NodeCount;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.StatementExpr;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.statements.FlowControl;
import miniJAST.statements.Statement;
import miniJAST.statements.StatementBase;
import miniJAST.statements.StatementNoShortIf;
import miniJAST.types.UnannType;

import java.util.ArrayList;

public class ForStmntNoShortIf extends ForStmntBase implements StatementNoShortIf {
    public void setBodyNSI(StatementNoShortIf s) { baseSetBody(s); }
}
