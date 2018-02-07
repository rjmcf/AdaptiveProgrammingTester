package miniJAST.expressions.boolExpr;

import miniJAST.Context;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Literal;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.types.PrimType;
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
        t.setUpLiteral(PrimType.BOOLEAN, "true");
        f = new Literal();
        f.setUpLiteral(PrimType.BOOLEAN, "false");
        i = new Literal();
        i.setUpLiteral(PrimType.INT, "2");
    }

    @Test
    public void testEvaluate() throws Exception {
        e.setUpOrExpr(t, t);
        Assert.assertTrue(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpOrExpr(t, f);
        Assert.assertTrue(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpOrExpr(f, t);
        Assert.assertTrue(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpOrExpr(f, f);
        Assert.assertFalse(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpOrExpr(i, t);
        try {
            e.evaluate(c);
            fail("Cannot use || on integers (left)");
        } catch (TypeException te) {
            // pass test
        }

        e.setUpOrExpr(t, i);
        // test passes since evaluation order now takes precedence over type-safety.
    }
}