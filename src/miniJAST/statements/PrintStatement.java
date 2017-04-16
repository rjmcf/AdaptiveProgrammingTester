package miniJAST.statements;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.returnValues.*;

import java.io.*;

public class PrintStatement extends StatementBase {
    private int expr;
    String fName;
    boolean append;

    public PrintStatement(String fileName, boolean append) { fName = fileName; this.append = append; }

    public void setUpPrint(Expression e) { subNodes.clear(); expr = 0; subNodes.add(e); }

    @Override
    public String stringRepr(int blocksDeep) {
        return pad(blocksDeep) + "System.out.println(" + ((Expression)subNodes.get(expr)).stringRepr() + ");";
    }

    @Override
    public FlowControl execute(Context c, int d) throws MiniJASTException {
        checkType((Expression)subNodes.get(expr), Expression.class);

        ReturnValues v = ((Expression)subNodes.get(expr)).evaluate(c);
        try {
            FileWriter fw = new FileWriter(fName, append);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter printTo = new PrintWriter(bw);
            if (v.getIsArray()) {
                ReturnValuesArray var = (ReturnValuesArray) v;
                printTo.print("[ ");
                for (int i = 0; i < var.getSize(); i++) {
                    switch (var.getType().uType) {
                        case BOOLEAN:
                            printTo.print((boolean)var.get(i));
                            break;
                        case CHAR:
                            printTo.print((char)var.get(i));
                            break;
                        case INT:
                            printTo.print((int)var.get(i));
                            break;
                        case DOUBLE:
                            printTo.print((double) var.get(i));
                    }

                    if (i != var.getSize() - 1)
                        printTo.print(", ");
                }
                printTo.println(" ]");
            } else {
                switch (v.getType().uType) {
                    case BOOLEAN:
                        printTo.println(((ReturnValuesBool) v).value);
                        break;
                    case CHAR:
                        printTo.println(((ReturnValuesChar) v).value);
                        break;
                    case INT:
                        printTo.println(((ReturnValuesInt) v).value);
                        break;
                    default: // DOUBLE
                        printTo.println(((ReturnValuesDouble) v).value);
                }
            }
            printTo.flush();
            printTo.close();

            return FlowControl.NONE;
        } catch (IOException e) {
            System.err.println("Could not print to file");
            throw new MiniJASTException("Could not print to file");
        }
    }

    @Override
    public FlowControl executeStart(Context c) throws MiniJASTException {
        return execute(c, 0);
    }
}
