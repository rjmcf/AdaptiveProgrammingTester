package miniJAST.expressions.boolExpr;

import miniJAST.Context;
import miniJAST.expressions.BracketedExpr;
import miniJAST.expressions.Id;
import miniJAST.expressions.Literal;
import miniJAST.expressions.assignment.AssignExpr;
import miniJAST.expressions.assignment.AssignOp;
import miniJAST.expressions.returnValues.ReturnValuesDouble;
import miniJAST.expressions.returnValues.ReturnValuesInt;
import miniJAST.statements.Block;
import miniJAST.statements.ExpressionStmnt;
import miniJAST.statements.LVD.LocalVarDec;
import miniJAST.statements.LVD.VarDeclarator;
import miniJAST.types.PrimType;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CondExprTest {
    CondExpr e;
    Context c;
    Literal t;
    Literal f;
    Literal int2;
    Literal int3;
    Literal doubHalf;
    Literal doubQuart;
    VarDeclarator iDec, jDec;
    LocalVarDec lvd;
    Id i, j;
    AssignExpr tE, fE, outer;
    BracketedExpr bE;
    Block b;

    @BeforeMethod
    public void setUp() throws Exception {
        e = new CondExpr();
        c = new Context();
        t = new Literal();
        t.setUpLiteral(PrimType.BOOLEAN, "true");
        f = new Literal();
        f.setUpLiteral(PrimType.BOOLEAN, "false");
        int2 = new Literal();
        int2.setUpLiteral(PrimType.INT, "2");
        int3 = new Literal();
        int3.setUpLiteral(PrimType.INT, "3");
        doubHalf = new Literal();
        doubHalf.setUpLiteral(PrimType.DOUBLE, "0.5");
        doubQuart = new Literal();
        doubQuart.setUpLiteral(PrimType.DOUBLE, "0.25");

        iDec = new VarDeclarator();
        iDec.setUpVarDec("i", null);
        jDec = new VarDeclarator();
        jDec.setUpVarDec("j", null);
        lvd = new LocalVarDec();
        lvd.setUpLVD(PrimType.INT);
        lvd.addVarDec(iDec);
        lvd.addVarDec(jDec);
        i = new Id();
        i.setUpId("i");
        tE = new AssignExpr();
        tE.setUpAssignExpr(i, AssignOp.EQ, int2);
        fE = new AssignExpr();
        fE.setUpAssignExpr(i, AssignOp.EQ, int3);
        bE = new BracketedExpr();
        bE.setUpBracketExpr(fE);
        j = new Id();
        j.setUpId("j");
        outer = new AssignExpr();
        outer.setUpAssignExpr(j, AssignOp.EQ, e);
        b = new Block(true);
        b.addBlockStmnt(lvd);
        ExpressionStmnt eS = new ExpressionStmnt(outer);
        b.addBlockStmnt(eS);
    }

    @Test
    public void testEvaluate() throws Exception {
        e.setUpCondExpr(t, int2, int3);
        Assert.assertEquals(2, ((ReturnValuesInt)e.evaluate(c)).value);

        e.setUpCondExpr(f, int2, int3);
        Assert.assertEquals(3, ((ReturnValuesInt)e.evaluate(c)).value);

        e.setUpCondExpr(t, doubHalf, doubQuart);
        Assert.assertEquals(0.5, ((ReturnValuesDouble)e.evaluate(c)).value);

        e.setUpCondExpr(f, doubHalf, doubQuart);
        Assert.assertEquals(0.25, ((ReturnValuesDouble)e.evaluate(c)).value);

        e.setUpCondExpr(t, f, int2);
        // test passes since evaluation order takes precedence over type-safety
    }

    @Test
    public void testEvaluationOrder() throws Exception {
        /* code is:
        int i, j;
        j = true ? i = 2 : i = 3;
        Check both j and i are 2
        */
        e.setUpCondExpr(t, tE, bE);
        b.executeStart(c);

        assertEquals(2, ((ReturnValuesInt)i.evaluate(c)).value);
        assertEquals(2, ((ReturnValuesInt)j.evaluate(c)).value);
    }
}