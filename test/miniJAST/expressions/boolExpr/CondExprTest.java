package miniJAST.expressions.boolExpr;

import miniJAST.Context;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Literal;
import miniJAST.expressions.returnValues.ReturnValuesDouble;
import miniJAST.expressions.returnValues.ReturnValuesInt;
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
        try {
            e.evaluate(c);
            fail("Should not have expressions of different types");
        } catch (TypeException te) {
            // pass test
        }
    }
}