package miniJAST.statements.ForLoops;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.statements.FlowControl;
import miniJAST.statements.LocalVarDec;
import miniJAST.expressions.StatementExpr;

import java.util.ArrayList;

public class ForInit {
    private ArrayList<StatementExpr> stmnts;
    private LocalVarDec lvd = null;

    public ForInit() { stmnts = new ArrayList<>(); }
    public void addLocalVarDec(LocalVarDec lv) { lvd = lv; }
    public void addStmntExpr(StatementExpr se) { stmnts.add(se); }

    public int getSubNodes() {
        if (lvd == null) {
            int sum = 0;
            for (StatementExpr sE : stmnts)
                sum += sE.getSubNodes();
            return sum + stmnts.size();
        } else {
            return lvd.getSubNodes() + 1;
        }
    }

    public FlowControl execute(Context c, int d) throws MiniJASTException {
        if (lvd == null) {
            for (StatementExpr se : stmnts) {
                se.evaluate(c);
            }
        } else
            lvd.execute(c, d);

        return null;
    }
}
