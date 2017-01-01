package miniJAST.statements.ForLoops;

import miniJAST.Context;
import miniJAST.MiniJASTNode;
import miniJAST.NodeCount;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.statements.FlowControl;
import miniJAST.statements.LocalVarDec;
import miniJAST.expressions.StatementExpr;
import miniJAST.statements.StatementBase;

import java.util.ArrayList;

public class ForInit extends StatementBase implements MiniJASTNode{
    private ArrayList<StatementExpr> stmnts;
    private LocalVarDec lvd = null;

    public ForInit() { stmnts = new ArrayList<>(); }
    public void addLocalVarDec(LocalVarDec lv) { lvd = lv; subNodes.add(lv); }
    public void addStmntExpr(StatementExpr se) { stmnts.add(se); subNodes.add(se); }

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

    public String stringRepr() {
        if (lvd == null) {
            String result = "";
            for (StatementExpr se : stmnts)
                result += se.stringRepr() + ", ";
            return result.substring(0, result.length() - 2);
        } else
            return lvd.stringRepr(0).substring(0, lvd.stringRepr(0).length() - 1);
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
