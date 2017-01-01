package miniJAST.statements;

import miniJAST.Context;
import miniJAST.MiniJASTNode;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class StatementBase {
    protected ArrayList<MiniJASTNode> subNodes = new ArrayList<>();
    protected void removeDecsAtDepth(Context c, int d) {
        if (d == 0)
            return;
        Iterator<String> nTDs = c.namesToDepths.keySet().iterator();
        Iterator<String> nTVs = c.namesToValues.keySet().iterator();
        Iterator<String> nTTs = c.namesToTypes.keySet().iterator();
        while (nTDs.hasNext()) {
            nTVs.next();
            nTTs.next();
            if (c.namesToDepths.get(nTDs.next()) >= d) {
                nTVs.remove();
                nTTs.remove();
                nTDs.remove();
            }
        }
    }

    protected String pad(int count) {
        return new String(new char[count]).replace("\0", "    ");
    }
}
