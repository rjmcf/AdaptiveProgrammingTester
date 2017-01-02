package miniJAST.statements;

import miniJAST.Context;
import miniJAST.MiniJASTNode;
import miniJAST.NodeCount;
import miniJAST.expressions.Expression;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class StatementBase implements MiniJASTNode {
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

    @Override
    public NodeCount getTreeSize() {
        NodeCount result = new NodeCount();
        for (MiniJASTNode e : subNodes) {
            result.filled += e.getTreeSize().filled;
            result.empty += e.getTreeSize().empty;
        }
        result.filled++;
        return result;
    }

    protected String pad(int count) {
        return new String(new char[count]).replace("\0", "    ");
    }
}
