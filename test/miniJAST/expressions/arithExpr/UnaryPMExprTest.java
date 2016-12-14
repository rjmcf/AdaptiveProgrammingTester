package miniJAST.expressions.arithExpr;

import miniJAST.Context;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Literal;
import miniJAST.expressions.returnValues.ReturnValuesDouble;
import miniJAST.expressions.returnValues.ReturnValuesInt;
import miniJAST.types.UnannType;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UnaryPMExprTest {
    UnaryPMExpr e;
    Context c;
    Literal intE;
    Literal doubE;
    Literal boolE;

    @BeforeMethod
    public void setUp() throws Exception {
        e = new UnaryPMExpr();
        c = new Context();
        intE = new Literal();
        intE.setUpLiteral(UnannType.INT, "2");
        doubE = new Literal();
        doubE.setUpLiteral(UnannType.DOUBLE, "0.5");
        boolE = new Literal();
        boolE.setUpLiteral(UnannType.BOOLEAN, "false");
    }

    @Test
    public void testEvaluate() throws Exception {
        e.setUpPMExpr(true, intE);
        Assert.assertEquals(2, ((ReturnValuesInt)e.evaluate(c)).value);

        e.setUpPMExpr(false, intE);
        Assert.assertEquals(-2, ((ReturnValuesInt)e.evaluate(c)).value);

        e.setUpPMExpr(true, doubE);
        Assert.assertEquals(0.5, ((ReturnValuesDouble)e.evaluate(c)).value);

        e.setUpPMExpr(false, doubE);
        Assert.assertEquals(-0.5, ((ReturnValuesDouble)e.evaluate(c)).value);

        e.setUpPMExpr(true, boolE);
        try {
            e.evaluate(c);
            fail("Cannot make a boolean expression positive or negative");
        } catch (TypeException te) {
            // pass test
        }
    }
}