import miniJAST.expressions.Id;
import miniJAST.expressions.Literal;
import miniJAST.expressions.assignment.AssignExpr;
import miniJAST.expressions.assignment.AssignOp;
import miniJAST.statements.ExpressionStmnt;
import miniJAST.types.PrimType;

public class Main {

    public static void main(String[] args) {
        AssignExpr aE = new AssignExpr();
        Id i = new Id();
        i.setUpId("i");
        Literal four = new Literal();
        four.setUpLiteral(PrimType.INT, "4");
        aE.setUpAssignExpr(i, AssignOp.EQ, four);
        ExpressionStmnt eS = new ExpressionStmnt(aE);

    }
}