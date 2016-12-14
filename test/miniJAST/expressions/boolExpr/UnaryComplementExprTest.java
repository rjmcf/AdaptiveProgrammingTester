package miniJAST.expressions.boolExpr;

import miniJAST.Context;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Literal;
import miniJAST.expressions.boolExpr.UnaryComplementExpr;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.types.UnannType;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UnaryComplementExprTest {
    UnaryComplementExpr e;
    Context c;
    Literal t;
    Literal f;
    Literal fail;

    @BeforeMethod
    public void setUp() throws Exception {
        e = new UnaryComplementExpr();
        c = new Context();
        t = new Literal();
        t.setUpLiteral(UnannType.BOOLEAN, "true");
        f = new Literal();
        f.setUpLiteral(UnannType.BOOLEAN, "false");
        fail = new Literal();
        fail.setUpLiteral(UnannType.INT, "2");
    }

    @Test
    public void testEvaluate() throws Exception {
        e.setUpCompExpr(t);
        Assert.assertFalse(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpCompExpr(f);
        Assert.assertTrue(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpCompExpr(fail);
        try {
            e.evaluate(c);
            fail("Cannot complement non-boolean value");
        } catch (TypeException te) {
            // pass test
        }
    }
}