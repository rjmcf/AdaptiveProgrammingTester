package miniJAST.statements;

import miniJAST.Context;
import miniJAST.expressions.Expression;
import miniJAST.expressions.returnValues.*;

public class PrintStatement implements BlockStatement {
    Expression expr;

    @Override
    public FlowControl execute(Context c) throws Exception {
        ReturnValues v = expr.evaluate(c);

        if (v.getIsArray()) {
            ReturnValuesArray var = (ReturnValuesArray) v;
            System.out.print("[ ");
            for (int i = 0; i < var.getSize(); i++) {
                System.out.print(var.get(i));
                if (i != var.getSize() - 1)
                    System.out.print(", ");
            }
            System.out.print(" ]");
        }

        switch (v.getType().uType) {
            case BOOLEAN:
                System.out.println(((ReturnValuesBool)v).value);
                break;
            case CHAR:
                System.out.println(((ReturnValuesChar)v).value);
                break;
            case INT:
                System.out.println(((ReturnValuesInt)v).value);
                break;
            default: // DOUBLE
                System.out.println(((ReturnValuesDouble)v).value);
        }

        return FlowControl.NONE;
    }
}