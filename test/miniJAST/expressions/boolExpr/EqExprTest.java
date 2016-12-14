package miniJAST.expressions.boolExpr;

import miniJAST.Context;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Literal;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.types.UnannType;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class EqExprTest {
    EqExpr e;
    Context c;
    Literal t;
    Literal f;
    Literal c1;
    Literal c2;
    Literal int2;
    Literal int3;

    @BeforeMethod
    public void setUp() throws Exception {
        e = new EqExpr();
        c = new Context();
        t = new Literal();
        t.setUpLiteral(UnannType.BOOLEAN, "true");
        f = new Literal();
        f.setUpLiteral(UnannType.BOOLEAN, "false");
        c1 = new Literal();
        c1.setUpLiteral(UnannType.CHAR, "a");
        c2 = new Literal();
        c2.setUpLiteral(UnannType.CHAR, "b");
        int2 = new Literal();
        int2.setUpLiteral(UnannType.INT, "2");
        int3 = new Literal();
        int3.setUpLiteral(UnannType.INT, "3");
    }

    @Test
    public void testEvaluate() throws Exception {
        e.setUpEqExpr(true, t, t);
        Assert.assertTrue(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpEqExpr(true, f, f);
        Assert.assertTrue(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpEqExpr(false, t, f);
        Assert.assertTrue(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpEqExpr(false, f, t);
        Assert.assertTrue(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpEqExpr(false, t, t);
        Assert.assertFalse(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpEqExpr(false, f, f);
        Assert.assertFalse(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpEqExpr(true, f, t);
        Assert.assertFalse(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpEqExpr(true, t, f);
        Assert.assertFalse(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpEqExpr(true, int2, int2);
        Assert.assertTrue(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpEqExpr(true, int3, int3);
        Assert.assertTrue(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpEqExpr(false, int2, int3);
        Assert.assertTrue(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpEqExpr(false, int3, int2);
        Assert.assertTrue(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpEqExpr(false, int2, int2);
        Assert.assertFalse(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpEqExpr(false, int3, int3);
        Assert.assertFalse(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpEqExpr(true, int3, int2);
        Assert.assertFalse(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpEqExpr(true, int2, int3);
        Assert.assertFalse(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpEqExpr(true, c1, c1);
        Assert.assertTrue(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpEqExpr(true, c2, c2);
        Assert.assertTrue(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpEqExpr(false, c1, c2);
        Assert.assertTrue(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpEqExpr(false, c2, c1);
        Assert.assertTrue(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpEqExpr(false, c1, c1);
        Assert.assertFalse(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpEqExpr(false, c2, c2);
        Assert.assertFalse(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpEqExpr(true, c2, c1);
        Assert.assertFalse(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpEqExpr(true, c1, c2);
        Assert.assertFalse(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpEqExpr(true, t, int2);
        try {
            e.evaluate(c);
            fail("Cannot compare expressions of different types");
        } catch (TypeException te) {
            // pass test
        }

    }
}