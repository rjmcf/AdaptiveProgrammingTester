package miniJAST.statements;

import miniJAST.Context;
import miniJAST.expressions.Id;
import miniJAST.expressions.Literal;
import miniJAST.expressions.assignment.AssignExpr;
import miniJAST.expressions.assignment.AssignOp;
import miniJAST.expressions.returnValues.ReturnValuesInt;
import miniJAST.types.Type;
import miniJAST.types.UnannType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class IfThenStmntTest {
    Context c;
    Block block1, block2;
    IfThenStmnt iTS1, iTS2;
    LocalVarDec i0, j0;
    AssignExpr i1, j1;
    VarDeclarator i, j;
    Literal zero, one, t, f;
    Id iID, jID;


    @BeforeMethod
    public void setUp() throws Exception {
        c = new Context();
        zero = new Literal();
        zero.setUpLiteral(UnannType.INT, "0");
        i = new VarDeclarator();
        i.setUpVarDec("i", zero);
        i0 = new LocalVarDec();
        i0.setUpLVD(UnannType.INT);
        i0.addVarDec(i);
        t = new Literal();
        t.setUpLiteral(UnannType.BOOLEAN, "true");
        iID = new Id();
        iID.setUpId(new Type(UnannType.INT, 1), "i");
        one = new Literal();
        one.setUpLiteral(UnannType.INT, "1");
        i1 = new AssignExpr();
        i1.setUpAssignExpr(iID, AssignOp.EQ, one);
        ExpressionStmnt eS1 = new ExpressionStmnt(i1);
        iTS1 = new IfThenStmnt();
        iTS1.setUpIfThen(t, eS1);
        block1 = new Block(true);
        block1.addBlockStmnt(i0);
        block1.addBlockStmnt(iTS1);

        j = new VarDeclarator();
        j.setUpVarDec("j", zero);
        j0 = new LocalVarDec();
        j0.setUpLVD(UnannType.INT);
        j0.addVarDec(j);
        f = new Literal();
        f.setUpLiteral(UnannType.BOOLEAN, "false");
        jID = new Id();
        jID.setUpId(new Type(UnannType.INT, 1), "j");
        j1 = new AssignExpr();
        j1.setUpAssignExpr(jID, AssignOp.EQ, one);
        ExpressionStmnt eS2 = new ExpressionStmnt(j1);
        iTS2 = new IfThenStmnt();
        iTS2.setUpIfThen(f, eS2);
        block2 = new Block(true);
        block2.addBlockStmnt(j0);
        block2.addBlockStmnt(iTS2);
    }

    @Test
    public void testExecute() throws Exception {
        /* Code is:
        int i = 0;
        if (true)
            i = 1;
        check i == 1
         */
        block1.executeStart(c);
        assertEquals(1, ((ReturnValuesInt)iID.evaluate(c)).value);

        /* Code is:
        int j = 0;
        if (false)
            j = 1;
        check j == 0
         */
        block2.executeStart(c);
        assertEquals(0, ((ReturnValuesInt)jID.evaluate(c)).value);
    }
}