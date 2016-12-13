package miniJAST.expressions.arithExpr;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.Literal;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesDouble;
import miniJAST.expressions.returnValues.ReturnValuesInt;
import miniJAST.types.UnannType;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AddExprTest {
    AddExpr e;
    Literal intTwo;
    Literal intThree;
    Literal doubHalf;
    Literal boolTrue;

    Context c;


    @BeforeMethod
    public void setUp() throws Exception {
        e = new AddExpr();
        c = new Context();
        intTwo = new Literal();
        intTwo.setUp(UnannType.INT, "2");
        intThree = new Literal();
        intThree.setUp(UnannType.INT, "3");
        doubHalf = new Literal();
        doubHalf.setUp(UnannType.DOUBLE, "0.5");
        boolTrue = new Literal();
        boolTrue.setUp(UnannType.BOOLEAN, "true");

    }

    @Test
    public void testEvaluate() throws Exception {
        e.setUp(true, intTwo, intThree);
        Assert.assertEquals(5, ((ReturnValuesInt)e.evaluate(c)).value);

        e.setUp(false, intThree, intTwo);
        Assert.assertEquals(1, ((ReturnValuesInt)e.evaluate(c)).value);

        e.setUp(true, doubHalf, intTwo);
        Assert.assertEquals(2.5, ((ReturnValuesDouble)e.evaluate(c)).value);

        e.setUp(true, boolTrue, intThree);
        try {
            e.evaluate(c);
            fail("Should not be able to add true to 2");
        } catch (TypeException te) {
            // pass test
        }
    }
}