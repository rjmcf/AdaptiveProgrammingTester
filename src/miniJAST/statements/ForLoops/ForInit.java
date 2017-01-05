package miniJAST.statements.ForLoops;

import miniJAST.Context;
import miniJAST.MiniJASTNode;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.Expression;
import miniJAST.statements.BlockStatement;
import miniJAST.statements.FlowControl;
import miniJAST.statements.LVD.LocalVarDec;
import miniJAST.expressions.StatementExpr;
import miniJAST.statements.StatementBase;

import java.util.ArrayList;

public class ForInit extends StatementBase implements BlockStatement{
    private ArrayList<Expression> stmnts;
    private BlockStatement lvd = null;

    public ForInit() { stmnts = new ArrayList<>(); }
    public void addLocalVarDec(BlockStatement lv) { lvd = lv; subNodes.add(lv); }
    public void addStmntExpr(Expression se) { stmnts.add(se); subNodes.add(se); }

    public String stringRepr() {
        if (lvd == null) {
            String result = "";
            for (Expression se : stmnts)
                result += se.stringRepr() + ", ";
            return result.substring(0, result.length() - 2);
        } else
            return lvd.stringRepr(0).substring(0, lvd.stringRepr(0).length() - 1);
    }

    public FlowControl execute(Context c, int d) throws MiniJASTException {
        if (lvd == null) {
            for (Expression se : stmnts) {
                checkType(se, StatementExpr.class);
                se.evaluate(c);
            }
        } else {
            checkType(lvd, LocalVarDec.class);
            lvd.execute(c, d);
        }

        return null;
    }

    @Override
    public FlowControl executeStart(Context c) throws MiniJASTException {
        return null;
    }

    @Override
    public String stringRepr(int blocksDeep) {
        return null;
    }
}
