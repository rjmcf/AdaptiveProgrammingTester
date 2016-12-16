package miniJAST.statements;

import miniJAST.Context;
import miniJAST.expressions.Id;
import miniJAST.expressions.Literal;
import miniJAST.expressions.arrays.ArrayAccess;
import miniJAST.expressions.assignment.AssignExpr;
import miniJAST.expressions.assignment.AssignOp;
import miniJAST.expressions.assignment.UnaryPostIncExpr;
import miniJAST.expressions.boolExpr.RelationExpr;
import miniJAST.expressions.boolExpr.RelationOp;
import miniJAST.expressions.returnValues.ReturnValuesInt;
import miniJAST.statements.arrays.ArrayCreationWithInitList;
import miniJAST.types.Type;
import miniJAST.types.UnannType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class WhileStmntTest {
    Context c;
    Block outer, inner, block2;
    LocalVarDec ints, dec2;
    VarDeclarator i0, sum0, j0;
    ArrayCreationWithInitList nsInit;
    Literal zero, one, two, three, four, five;
    Literal f;
    Id sumID, iID, nsID, jID;
    RelationExpr lT5;
    AssignExpr plusEquals, j1;
    ArrayAccess access;
    UnaryPostIncExpr plus;
    WhileStmnt wS1, wS2;

    @BeforeMethod
    public void setUp() throws Exception {
        c = new Context();
        zero = new Literal();
        zero.setUpLiteral(UnannType.INT, "0");
        i0 = new VarDeclarator();
        i0.setUpVarDec("i", zero);
        sum0 = new VarDeclarator();
        sum0.setUpVarDec("sum", zero);
        one = new Literal();
        one.setUpLiteral(UnannType.INT, "1");
        two = new Literal();
        two.setUpLiteral(UnannType.INT, "2");
        three = new Literal();
        three.setUpLiteral(UnannType.INT, "3");
        four = new Literal();
        four.setUpLiteral(UnannType.INT, "4");
        nsInit = new ArrayCreationWithInitList();
        nsInit.setUPACWIL("ns");
        nsInit.addExpressionACWIL(one);
        nsInit.addExpressionACWIL(two);
        nsInit.addExpressionACWIL(three);
        nsInit.addExpressionACWIL(four);
        ints = new LocalVarDec();
        ints.setUpLVD(UnannType.INT);
        ints.addVarDec(i0);
        ints.addVarDec(sum0);
        ints.addVarDec(nsInit);

        five = new Literal();
        five.setUpLiteral(UnannType.INT, "5");
        sumID = new Id();
        sumID.setUpId(new Type(UnannType.INT, 1), "sum");
        lT5 = new RelationExpr();
        lT5.setUpRelationExpr(RelationOp.LT, sumID, five);
        nsID = new Id();
        nsID.setUpId(new Type(UnannType.INT, 4), "ns");
        iID = new Id();
        iID.setUpId(new Type(UnannType.INT, 1), "i");
        access = new ArrayAccess();
        access.setUpArrayAccess(nsID, iID);
        plusEquals = new AssignExpr();
        plusEquals.setUpAssignExpr(sumID, AssignOp.PLUSEQ, access);
        plus = new UnaryPostIncExpr();
        plus.setUpPostIncExpr(true, iID);
        inner = new Block();
        inner.addBlockStmnt(plusEquals);
        inner.addBlockStmnt(plus);
        wS1 = new WhileStmnt();
        wS1.setUpWhile(lT5, inner);

        outer = new Block();
        outer.addBlockStmnt(ints);
        outer.addBlockStmnt(wS1);

        j0 = new VarDeclarator();
        j0.setUpVarDec("j", zero);
        dec2 = new LocalVarDec();
        dec2.setUpLVD(UnannType.INT);
        dec2.addVarDec(j0);
        f = new Literal();
        f.setUpLiteral(UnannType.BOOLEAN, "false");
        jID = new Id();
        jID.setUpId(new Type(UnannType.INT, 1), "j");
        j1 = new AssignExpr();
        j1.setUpAssignExpr(jID, AssignOp.EQ, one);
        wS2 = new WhileStmnt();
        wS2.setUpWhile(f, j1);

        block2 = new Block();
        block2.addBlockStmnt(dec2);
        block2.addBlockStmnt(wS2);
    }

    @Test
    public void testExecute() throws Exception {
        /* Code is:
        int i = 0, sum = 0, ns[] = new int[] {1, 2, 3, 4};
        while (sum < 5) {
            sum += ns[i]
            i++;
        }
        check sum == 6
         */
        outer.execute(c, -1);
        assertEquals(6, ((ReturnValuesInt)sumID.evaluate(c)).value);

        /* Code is:
        int j = 0;
        while (false) {
            j = 1;
        }
        check j == 0;
        */
        block2.execute(c, -1);
        assertEquals(0, ((ReturnValuesInt)jID.evaluate(c)).value);
    }
}