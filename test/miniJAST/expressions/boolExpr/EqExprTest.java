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
        t.setUp(UnannType.BOOLEAN, "true");
        f = new Literal();
        f.setUp(UnannType.BOOLEAN, "false");
        c1 = new Literal();
        c1.setUp(UnannType.CHAR, "a");
        c2 = new Literal();
        c2.setUp(UnannType.CHAR, "b");
        int2 = new Literal();
        int2.setUp(UnannType.INT, "2");
        int3 = new Literal();
        int3.setUp(UnannType.INT, "3");
    }

    @Test
    public void testEvaluate() throws Exception {
        e.setUp(true, t, t);
        Assert.assertTrue(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUp(true, f, f);
        Assert.assertTrue(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUp(false, t, f);
        Assert.assertTrue(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUp(false, f, t);
        Assert.assertTrue(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUp(false, t, t);
        Assert.assertFalse(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUp(false, f, f);
        Assert.assertFalse(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUp(true, f, t);
        Assert.assertFalse(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUp(true, t, f);
        Assert.assertFalse(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUp(true, int2, int2);
        Assert.assertTrue(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUp(true, int3, int3);
        Assert.assertTrue(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUp(false, int2, int3);
        Assert.assertTrue(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUp(false, int3, int2);
        Assert.assertTrue(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUp(false, int2, int2);
        Assert.assertFalse(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUp(false, int3, int3);
        Assert.assertFalse(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUp(true, int3, int2);
        Assert.assertFalse(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUp(true, int2, int3);
        Assert.assertFalse(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUp(true, c1, c1);
        Assert.assertTrue(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUp(true, c2, c2);
        Assert.assertTrue(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUp(false, c1, c2);
        Assert.assertTrue(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUp(false, c2, c1);
        Assert.assertTrue(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUp(false, c1, c1);
        Assert.assertFalse(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUp(false, c2, c2);
        Assert.assertFalse(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUp(true, c2, c1);
        Assert.assertFalse(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUp(true, c1, c2);
        Assert.assertFalse(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUp(true, t, int2);
        try {
            e.evaluate(c);
            fail("Cannot compare expressions of different types");
        } catch (TypeException te) {
            // pass test
        }

    }
}