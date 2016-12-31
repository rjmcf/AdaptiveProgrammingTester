package miniJAST.statements;

import miniJAST.Context;
import miniJAST.NodeCount;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.types.Type;
import miniJAST.types.UnannType;

public class IfThenElseStmntNoShortIf extends StatementBase implements StatementNoShortIf {
    private Expression cond;
    private StatementNoShortIf trueStmnt;
    private StatementNoShortIf falseStmnt;

    public void setUpITENSI(Expression c, StatementNoShortIf t, StatementNoShortIf f) { cond = c; trueStmnt = t; falseStmnt = f; }

    @Override
    public NodeCount getTreeSize() {
        NodeCount result = new NodeCount(cond.getTreeSize().filled, cond.getTreeSize().empty);
        result.add(trueStmnt.getTreeSize());
        result.add(falseStmnt.getTreeSize());
        result.filled++;
        return result;
    }

    @Override
    public String stringRepr() {
        return "if (" + cond.stringRepr() + ") " + trueStmnt.stringRepr() + "\nelse " + falseStmnt.stringRepr();
    }

    @Override
    public FlowControl execute(Context c, int d) throws MiniJASTException {
        ReturnValues r = cond.evaluate(c);
        if (r.getType().uType != UnannType.BOOLEAN)
            throw new TypeException("Condition must be Boolean type");
        if (r.getIsArray())
            throw new TypeException("Can not operate on arrays!");

        if (((ReturnValuesBool)r).value) {
            FlowControl result = trueStmnt.execute(c, d+1);
            removeDecsAtDepth(c, d+1);
            return result;
        }
        else {
            FlowControl result = falseStmnt.execute(c, d+1);
            removeDecsAtDepth(c, d+1);
            return result;
        }
    }

    @Override
    public FlowControl executeStart(Context c) throws MiniJASTException {
        return execute(c, 0);
    }
}
