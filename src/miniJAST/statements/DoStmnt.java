package miniJAST.statements;

import miniJAST.Context;
import miniJAST.NodeCount;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.types.UnannType;

public class DoStmnt extends StatementBase implements StmntNoTrailSubstmnt{
    private Statement stmnt;
    private Expression cond;

    public void setUpDo(Statement s, Expression c) { stmnt = s; cond = c; }

    @Override
    public NodeCount getTreeSize() {
        NodeCount result = new NodeCount(stmnt.getTreeSize().filled, stmnt.getTreeSize().empty);
        result.add(cond.getTreeSize());
        result.filled++;
        return result;
    }

    @Override
    public String stringRepr() {
        return "do " + stmnt.stringRepr() + " while (" + cond.stringRepr() + ")";
    }

    @Override
    public FlowControl execute(Context c, int d) throws MiniJASTException {
        stmnt.execute(c, d+1);
        removeDecsAtDepth(c, d+1);
        ReturnValues rCond = cond.evaluate(c);
        if (rCond.getType().uType != UnannType.BOOLEAN)
            throw new TypeException("Condition does not have boolean type");
        if (rCond.getIsArray())
            throw new TypeException("Can not operate on arrays!");

        loop:
        while(((ReturnValuesBool)rCond).value) {
            FlowControl fc = stmnt.execute(c, d+1);
            removeDecsAtDepth(c, d+1);
            switch (fc) {
                case BREAK:
                    break loop;
                case CONTINUE:
                    continue loop;
                case RETURN:
                    return fc;
            }
            rCond = cond.evaluate(c);
        }

        return FlowControl.NONE;
    }

    @Override
    public FlowControl executeStart(Context c) throws MiniJASTException {
        return execute(c, 0);
    }
}
