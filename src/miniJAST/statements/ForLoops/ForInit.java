package miniJAST.statements.ForLoops;

import miniJAST.Context;
import miniJAST.NodeCount;
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

    public NodeCount getTreeSize() {
        NodeCount result = new NodeCount();
        if (lvd == null) {
            for (StatementExpr sE : stmnts)
                result.add(sE.getTreeSize());
            result.filled++;
            return result;
        } else {
            result.add(lvd.getTreeSize());
            result.filled++;
            return result;
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
