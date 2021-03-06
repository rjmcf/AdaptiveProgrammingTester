package miniJAST.statements;

import miniJAST.Context;
import miniJAST.expressions.Id;
import miniJAST.expressions.Literal;
import miniJAST.expressions.assignment.AssignExpr;
import miniJAST.expressions.assignment.AssignOp;
import miniJAST.expressions.assignment.UnaryPostIncExpr;
import miniJAST.expressions.boolExpr.RelationExpr;
import miniJAST.expressions.boolExpr.RelationOp;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.expressions.returnValues.ReturnValuesInt;
import miniJAST.statements.DoAndWhileLoops.DoStmnt;
import miniJAST.statements.LVD.LocalVarDec;
import miniJAST.statements.LVD.VarDeclarator;
import miniJAST.types.PrimType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DoStmntTest {
    Context c;
    VarDeclarator cont, i, thing;
    LocalVarDec contDec, dec2;
    Literal t, f, zero, five;
    Id contID, iID, thingID;
    AssignExpr contFalse, thingToI;
    UnaryPostIncExpr plus;
    RelationExpr lT5;
    DoStmnt doS1, doS2;
    Block block1, block2;

    @BeforeMethod
    public void setUp() throws Exception {
        c = new Context();
        t = new Literal();
        t.setUpLiteral(PrimType.BOOLEAN, "true");
        cont = new VarDeclarator();
        cont.setUpVarDec("cont", false, t);
        contDec = new LocalVarDec();
        contDec.setUpLVD(PrimType.BOOLEAN);
        contDec.addVarDec(cont);

        f = new Literal();
        f.setUpLiteral(PrimType.BOOLEAN, "false");
        contID = new Id();
        contID.setUpId("cont");
        contFalse = new AssignExpr();
        contFalse.setUpAssignExpr(contID, AssignOp.EQ, f);
        ExpressionStmnt eS1 = new ExpressionStmnt(contFalse);

        doS1 = new DoStmnt();
        doS1.setUpDo(eS1, contID);
        block1 = new Block(true);
        block1.addBlockStmnt(contDec);
        block1.addBlockStmnt(doS1);

        zero = new Literal();
        zero.setUpLiteral(PrimType.INT, "0");
        i = new VarDeclarator();
        i.setUpVarDec("i", false, zero);
        thing = new VarDeclarator();
        thing.setUpVarDec("thing", false, null);
        dec2 = new LocalVarDec();
        dec2.setUpLVD(PrimType.INT);
        dec2.addVarDec(i);
        dec2.addVarDec(thing);

        iID = new Id();
        iID.setUpId("i");
        thingID = new Id();
        thingID.setUpId("thing");
        plus = new UnaryPostIncExpr();
        plus.setUpPostIncExpr(true, iID);
        thingToI = new AssignExpr();
        thingToI.setUpAssignExpr(thingID, AssignOp.EQ, plus);
        five = new Literal();
        five.setUpLiteral(PrimType.INT, "5");
        lT5 = new RelationExpr();
        lT5.setUpRelationExpr(RelationOp.LT, thingID, five);
        ExpressionStmnt eS2 = new ExpressionStmnt(thingToI);
        doS2 = new DoStmnt();
        doS2.setUpDo(eS2, lT5);
        block2 = new Block(true);
        block2.addBlockStmnt(dec2);
        block2.addBlockStmnt(doS2);
    }

    @Test
    public void testExecute() throws Exception {
        /* Code is:
        boolean cont = true;
        do {
            cont = false;
        } while (cont);
         */
        block1.execute(c);
        assertFalse(((ReturnValuesBool)contID.evaluate(c)).value);

        /* Code is:
        int i = 0, thing;
        do {
            thing = i++;
        } while (thing < 5)
        check thing == 5; i == 6;
         */
        block2.execute(c);
        assertEquals(5, ((ReturnValuesInt)thingID.evaluate(c)).value);
        assertEquals(6, ((ReturnValuesInt)iID.evaluate(c)).value);
    }
}