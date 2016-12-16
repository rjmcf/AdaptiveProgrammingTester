package miniJAST.statements;

import miniJAST.Context;

public class StatementBase {
    protected void removeDecsAtDepth(Context c, int d) {
        for (String n : c.namesToDepths.keySet()) {
            if (c.namesToDepths.get(n) >= d) {
                c.namesToDepths.remove(n);
                c.namesToValues.remove(n);
                c.namesToTypes.remove(n);
            }
        }
    }
}
