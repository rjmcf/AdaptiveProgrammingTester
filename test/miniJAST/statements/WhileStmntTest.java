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
import miniJAST.statements.DoAndWhileLoops.WhileStmnt;
import miniJAST.statements.LVD.LocalVarDec;
import miniJAST.statements.LVD.VarDeclarator;
import miniJAST.statements.arrays.ArrayCreationWithInitList;
import miniJAST.types.PrimType;
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
        zero.setUpLiteral(PrimType.INT, "0");
        i0 = new VarDeclarator();
        i0.setUpVarDec("i", zero);
        sum0 = new VarDeclarator();
        sum0.setUpVarDec("sum", zero);
        one = new Literal();
        one.setUpLiteral(PrimType.INT, "1");
        two = new Literal();
        two.setUpLiteral(PrimType.INT, "2");
        three = new Literal();
        three.setUpLiteral(PrimType.INT, "3");
        four = new Literal();
        four.setUpLiteral(PrimType.INT, "4");
        nsInit = new ArrayCreationWithInitList();
        nsInit.setUPACWIL("ns");
        nsInit.addExpressionACWIL(one);
        nsInit.addExpressionACWIL(two);
        nsInit.addExpressionACWIL(three);
        nsInit.addExpressionACWIL(four);
        ints = new LocalVarDec();
        ints.setUpLVD(PrimType.INT);
        ints.addVarDec(i0);
        ints.addVarDec(sum0);
        ints.addVarDec(nsInit);

        five = new Literal();
        five.setUpLiteral(PrimType.INT, "5");
        sumID = new Id();
        sumID.setUpId("sum");
        lT5 = new RelationExpr();
        lT5.setUpRelationExpr(RelationOp.LT, sumID, five);
        nsID = new Id();
        nsID.setUpId("ns");
        iID = new Id();
        iID.setUpId("i");
        access = new ArrayAccess();
        access.setUpArrayAccess(nsID, iID);
        plusEquals = new AssignExpr();
        plusEquals.setUpAssignExpr(sumID, AssignOp.PLUSEQ, access);
        ExpressionStmnt eS1 = new ExpressionStmnt(plusEquals);
        plus = new UnaryPostIncExpr();
        plus.setUpPostIncExpr(true, iID);
        ExpressionStmnt eS2 = new ExpressionStmnt(plus);
        inner = new Block(false);
        inner.addBlockStmnt(eS1);
        inner.addBlockStmnt(eS2);
        wS1 = new WhileStmnt();
        wS1.setUpWhile(lT5, inner);

        outer = new Block(true);
        outer.addBlockStmnt(ints);
        outer.addBlockStmnt(wS1);

        j0 = new VarDeclarator();
        j0.setUpVarDec("j", zero);
        dec2 = new LocalVarDec();
        dec2.setUpLVD(PrimType.INT);
        dec2.addVarDec(j0);
        f = new Literal();
        f.setUpLiteral(PrimType.BOOLEAN, "false");
        jID = new Id();
        jID.setUpId("j");
        j1 = new AssignExpr();
        j1.setUpAssignExpr(jID, AssignOp.EQ, one);
        ExpressionStmnt eS3 = new ExpressionStmnt(j1);
        wS2 = new WhileStmnt();
        wS2.setUpWhile(f, eS3);

        block2 = new Block(true);
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
        outer.executeStart(c);
        assertEquals(6, ((ReturnValuesInt)sumID.evaluate(c)).value);

        /* Code is:
        int j = 0;
        while (false) {
            j = 1;
        }
        check j == 0;
        */
        block2.executeStart(c);
        assertEquals(0, ((ReturnValuesInt)jID.evaluate(c)).value);
    }
}