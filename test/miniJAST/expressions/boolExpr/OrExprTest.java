package miniJAST.expressions.boolExpr;

import miniJAST.Context;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Literal;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.types.UnannType;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class OrExprTest {
    OrExpr e;
    Context c;
    Literal t;
    Literal f;
    Literal i;

    @BeforeMethod
    public void setUp() throws Exception {
        e = new OrExpr();
        c = new Context();
        t = new Literal();
        t.setUp(UnannType.BOOLEAN, "true");
        f = new Literal();
        f.setUp(UnannType.BOOLEAN, "false");
        i = new Literal();
        i.setUp(UnannType.INT, "2");
    }

    @Test
    public void testEvaluate() throws Exception {
        e.setUp(t, t);
        Assert.assertTrue(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUp(t, f);
        Assert.assertTrue(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUp(f, t);
        Assert.assertTrue(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUp(f, f);
        Assert.assertFalse(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUp(i, t);
        try {
            e.evaluate(c);
            fail("Cannot use || on integers (left)");
        } catch (TypeException te) {
            // pass test
        }

        e.setUp(t, i);
        try {
            e.evaluate(c);
            fail("Cannot use || on integers (right)");
        } catch (TypeException te) {
            // pass test
        }
    }
}