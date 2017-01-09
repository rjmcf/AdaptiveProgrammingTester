package miniJAST.statements;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.returnValues.*;

public class PrintStatement extends StatementBase implements StmntNoTrailSubstmnt {
    private int expr;

    public void setUpPrint(Expression e) { subNodes.clear(); expr = 0; subNodes.add(e); }

    @Override
    public String stringRepr(int blocksDeep) {
        return pad(blocksDeep) + "System.out.println(" + ((Expression)subNodes.get(expr)).stringRepr() + ");";
    }

    @Override
    public FlowControl execute(Context c, int d) throws MiniJASTException {
        checkType((Expression)subNodes.get(expr), Expression.class);

        ReturnValues v = ((Expression)subNodes.get(expr)).evaluate(c);

        if (v.getIsArray()) {
            ReturnValuesArray var = (ReturnValuesArray) v;
            System.out.print("[ ");
            for (int i = 0; i < var.getSize(); i++) {
                System.out.print(var.get(i));
                if (i != var.getSize() - 1)
                    System.out.print(", ");
            }
            System.out.println(" ]");
        } else {
            switch (v.getType().uType) {
                case BOOLEAN:
                    System.out.println(((ReturnValuesBool) v).value);
                    break;
                case CHAR:
                    System.out.println(((ReturnValuesChar) v).value);
                    break;
                case INT:
                    System.out.println(((ReturnValuesInt) v).value);
                    break;
                default: // DOUBLE
                    System.out.println(((ReturnValuesDouble) v).value);
            }
        }

        return FlowControl.NONE;
    }

    @Override
    public FlowControl executeStart(Context c) throws MiniJASTException {
        return execute(c, 0);
    }
}
