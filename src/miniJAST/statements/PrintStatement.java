package miniJAST.statements;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.returnValues.*;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class PrintStatement extends StatementBase {
    private int expr;
    OutputStream printTo;

    public PrintStatement(OutputStream out) { printTo = out; }

    public void setUpPrint(Expression e) { subNodes.clear(); expr = 0; subNodes.add(e); }

    @Override
    public String stringRepr(int blocksDeep) {
        return pad(blocksDeep) + "System.out.println(" + ((Expression)subNodes.get(expr)).stringRepr() + ");";
    }

    @Override
    public FlowControl execute(Context c, int d) throws MiniJASTException {
        checkType((Expression)subNodes.get(expr), Expression.class);

        ReturnValues v = ((Expression)subNodes.get(expr)).evaluate(c);
        PrintStream writer = new PrintStream(printTo);
        if (v.getIsArray()) {
            ReturnValuesArray var = (ReturnValuesArray) v;
            writer.print("[ ");
            for (int i = 0; i < var.getSize(); i++) {
                writer.print(var.get(i));
                if (i != var.getSize() - 1)
                    writer.print(", ");
            }
            writer.println(" ]");
        } else {
            switch (v.getType().uType) {
                case BOOLEAN:
                    writer.println(((ReturnValuesBool) v).value);
                    break;
                case CHAR:
                    writer.println(((ReturnValuesChar) v).value);
                    break;
                case INT:
                    writer.println(((ReturnValuesInt) v).value);
                    break;
                default: // DOUBLE
                    writer.println(((ReturnValuesDouble) v).value);
            }
        }
        writer.flush();
        writer.close();

        return FlowControl.NONE;
    }

    @Override
    public FlowControl executeStart(Context c) throws MiniJASTException {
        return execute(c, 0);
    }
}
