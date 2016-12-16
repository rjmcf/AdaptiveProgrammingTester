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

public class IfThenElseStmntTest {
    Context c;
    Block block1, block2;
    IfThenElseStmnt iTES1, iTES2;
    LocalVarDec iE, jE;
    AssignExpr i1, i2, j1, j2;
    VarDeclarator i, j;
    Literal one, two, t, f;
    Id iID, jID;

    @BeforeMethod
    public void setUp() throws Exception {
        c = new Context();
        i = new VarDeclarator();
        i.setUpVarDec("i", null);
        iE = new LocalVarDec();
        iE.setUpLVD(UnannType.INT);
        iE.addVarDec(i);
        t = new Literal();
        t.setUpLiteral(UnannType.BOOLEAN, "true");
        iID = new Id();
        iID.setUpId(new Type(UnannType.INT, 1), "i");
        one = new Literal();
        one.setUpLiteral(UnannType.INT, "1");
        i1 = new AssignExpr();
        i1.setUpAssignExpr(iID, AssignOp.EQ, one);
        two = new Literal();
        two.setUpLiteral(UnannType.INT, "2");
        i2 = new AssignExpr();
        i2.setUpAssignExpr(iID, AssignOp.EQ, two);
        iTES1 = new IfThenElseStmnt();
        iTES1.setUpITE(t, i1, i2);
        block1 = new Block(true);
        block1.addBlockStmnt(iE);
        block1.addBlockStmnt(iTES1);

        j = new VarDeclarator();
        j.setUpVarDec("j", null);
        jE = new LocalVarDec();
        jE.setUpLVD(UnannType.INT);
        jE.addVarDec(j);
        f = new Literal();
        f.setUpLiteral(UnannType.BOOLEAN, "false");
        jID = new Id();
        jID.setUpId(new Type(UnannType.INT, 1), "j");
        j1 = new AssignExpr();
        j1.setUpAssignExpr(jID, AssignOp.EQ, one);
        j2 = new AssignExpr();
        j2.setUpAssignExpr(jID, AssignOp.EQ, two);
        iTES2 = new IfThenElseStmnt();
        iTES2.setUpITE(f, j1, j2);
        block2 = new Block(true);
        block2.addBlockStmnt(jE);
        block2.addBlockStmnt(iTES2);
    }

    @Test
    public void testExecute() throws Exception {
        /* Code is:
        int i;
        if (true)
            i = 1;
        else
            i = 2;
        check i == 1
         */
        block1.execute(c, 0);
        assertEquals(1, ((ReturnValuesInt)iID.evaluate(c)).value);

        /* Code is:
        int i;
        if (false)
            i = 1;
        else
            i = 2;
        check i == 2
         */
        block2.execute(c, 0);
        assertEquals(2, ((ReturnValuesInt)jID.evaluate(c)).value);
    }
}