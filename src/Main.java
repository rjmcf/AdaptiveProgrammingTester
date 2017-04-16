import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.Literal;
import miniJAST.statements.PrintStatement;
import miniJAST.types.PrimType;

public class Main {

    public static void main(String[] args) {
        try {
            PrintStatement p = new PrintStatement("test/testOutput.txt");
            Literal l = new Literal(), m = new Literal();
            l.setUpLiteral(PrimType.INT, "42"); m.setUpLiteral(PrimType.CHAR, "\n");
            p.setUpPrint(l);
            p.executeStart(new Context());
            p.setUpPrint(m);
            p.executeStart(new Context());
            p.setUpPrint(l);
            p.executeStart(new Context());
        } catch (MiniJASTException mE) {
            System.out.println("Oh fuck son");
        }
    }
}