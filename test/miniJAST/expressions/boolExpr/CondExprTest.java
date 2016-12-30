package miniJAST.expressions.boolExpr;

import miniJAST.Context;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.BracketedExpr;
import miniJAST.expressions.Id;
import miniJAST.expressions.Literal;
import miniJAST.expressions.assignment.AssignExpr;
import miniJAST.expressions.assignment.AssignOp;
import miniJAST.expressions.returnValues.ReturnValuesDouble;
import miniJAST.expressions.returnValues.ReturnValuesInt;
import miniJAST.statements.Block;
import miniJAST.statements.LocalVarDec;
import miniJAST.statements.VarDeclarator;
import miniJAST.types.Type;
import miniJAST.types.UnannType;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.IAnnotation;
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
        t.setUpLiteral(UnannType.BOOLEAN, "true");
        f = new Literal();
        f.setUpLiteral(UnannType.BOOLEAN, "false");
        int2 = new Literal();
        int2.setUpLiteral(UnannType.INT, "2");
        int3 = new Literal();
        int3.setUpLiteral(UnannType.INT, "3");
        doubHalf = new Literal();
        doubHalf.setUpLiteral(UnannType.DOUBLE, "0.5");
        doubQuart = new Literal();
        doubQuart.setUpLiteral(UnannType.DOUBLE, "0.25");

        iDec = new VarDeclarator();
        iDec.setUpVarDec("i", null);
        jDec = new VarDeclarator();
        jDec.setUpVarDec("j", null);
        lvd = new LocalVarDec();
        lvd.setUpLVD(UnannType.INT);
        lvd.addVarDec(iDec);
        lvd.addVarDec(jDec);
        i = new Id();
        i.setUpId(new Type(UnannType.INT, 1), "i");
        tE = new AssignExpr();
        tE.setUpAssignExpr(i, AssignOp.EQ, int2);
        fE = new AssignExpr();
        fE.setUpAssignExpr(i, AssignOp.EQ, int3);
        bE = new BracketedExpr();
        bE.setUpBracketExpr(fE);
        j = new Id();
        j.setUpId(new Type(UnannType.INT, 1), "j");
        outer = new AssignExpr();
        outer.setUpAssignExpr(j, AssignOp.EQ, e);
        b = new Block(true);
        b.addBlockStmnt(lvd);
        b.addBlockStmnt(outer);
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