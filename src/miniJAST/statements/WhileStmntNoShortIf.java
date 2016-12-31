package miniJAST.statements;

import miniJAST.Context;
import miniJAST.NodeCount;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.types.UnannType;

public class WhileStmntNoShortIf extends StatementBase implements StatementNoShortIf {
    private Expression cond;
    private StatementNoShortIf stmnt;

    public void setUpWhileNSI(Expression c, StatementNoShortIf s) { cond = c; stmnt = s; }

    @Override
    public NodeCount getTreeSize() {
        NodeCount result = new NodeCount(cond.getTreeSize().filled, cond.getTreeSize().empty);
        result.add(stmnt.getTreeSize());
        result.filled++;
        return result;
    }

    @Override
    public FlowControl execute(Context c, int d) throws MiniJASTException {
        ReturnValues rC = cond.evaluate(c);
        if (rC.getType().uType != UnannType.BOOLEAN)
            throw new TypeException("Condition must be boolean type");
        if (rC.getIsArray())
            throw new TypeException("Can not operate on arrays!");

        loop:
        while (((ReturnValuesBool)rC).value) {
            FlowControl fC = stmnt.execute(c, d+1);
            removeDecsAtDepth(c, d+1);
            switch (fC) {
                case BREAK:
                    break loop;
                case CONTINUE:
                    continue loop;
                case RETURN:
                    return fC;
            }
            rC = cond.evaluate(c);
        }

        return FlowControl.NONE;
    }

    @Override
    public FlowControl executeStart(Context c) throws MiniJASTException {
        return execute(c, 0);
    }
}
