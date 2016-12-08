package miniJAST.statements.ForLoops;

import miniJAST.Context;
import miniJAST.statements.FlowControl;
import miniJAST.statements.LocalVarDec;
import miniJAST.expressions.StatementExpr;

import java.util.ArrayList;

public class ForInit {
    private boolean isList;
    private ArrayList<StatementExpr> stmnts;
    private LocalVarDec lvd;

    public void execute(Context c) throws Exception {
        if (isList) {
            for (StatementExpr se : stmnts) {
                se.evaluate(c);
            }
        } else
            lvd.execute(c);
    }
}
