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

public class MultExprTest {
    MultExpr e;
    Literal intTwo;
    Literal intThree;
    Literal doubHalf;
    Literal boolTrue;
    Context c;


    @BeforeMethod
    public void setUp() throws Exception {
        e = new MultExpr();
        c = new Context();
        intTwo = new Literal();
        intTwo.setUpLiteral(UnannType.INT, "2");
        intThree = new Literal();
        intThree.setUpLiteral(UnannType.INT, "3");
        doubHalf = new Literal();
        doubHalf.setUpLiteral(UnannType.DOUBLE, "0.5");
        boolTrue = new Literal();
        boolTrue.setUpLiteral(UnannType.BOOLEAN, "true");

    }

    @Test
    public void testEvaluate() throws Exception {
        e.setUpMultExpr(true, intTwo, intThree);
        Assert.assertEquals(6, ((ReturnValuesInt)e.evaluate(c)).value);

        e.setUpMultExpr(false, intThree, intTwo);
        Assert.assertEquals(1, ((ReturnValuesInt)e.evaluate(c)).value);

        e.setUpMultExpr(true, doubHalf, intTwo);
        Assert.assertEquals(1.0, ((ReturnValuesDouble)e.evaluate(c)).value);

        e.setUpMultExpr(true, boolTrue, intThree);
        try {
            e.evaluate(c);
            fail("Should not be able to multiply true by 2");
        } catch (TypeException te) {
            // pass test
        }
    }

}