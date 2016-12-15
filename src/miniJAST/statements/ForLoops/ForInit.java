package miniJAST.statements.ForLoops;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.statements.FlowControl;
import miniJAST.statements.LocalVarDec;
import miniJAST.expressions.StatementExpr;

import java.util.ArrayList;

public class ForInit {
    private boolean isList;
    private ArrayList<StatementExpr> stmnts;
    private LocalVarDec lvd;

    public ForInit() { stmnts = new ArrayList<>(); }
    public void setUpForInit(boolean l, LocalVarDec lv) { isList = l; lvd = lv; }
    public void addStmntExpr(StatementExpr se) { stmnts.add(se); }

    public FlowControl execute(Context c) throws MiniJASTException {
        if (isList) {
            for (StatementExpr se : stmnts) {
                se.evaluate(c);
            }
        } else
            lvd.execute(c);

        return null;
    }
}
