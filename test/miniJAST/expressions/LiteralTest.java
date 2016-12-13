package miniJAST.expressions;

import miniJAST.Context;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.expressions.returnValues.ReturnValuesChar;
import miniJAST.expressions.returnValues.ReturnValuesDouble;
import miniJAST.expressions.returnValues.ReturnValuesInt;
import miniJAST.types.UnannType;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LiteralTest {
    Literal l;
    Context c;

    @BeforeMethod
    public void setUp() {
        l = new Literal();
        c = new Context();
    }

    @Test
    public void testBoolean() throws Exception{
        l.setUp(UnannType.BOOLEAN, "true");
        Assert.assertTrue(((ReturnValuesBool)l.evaluate(c)).value);

        l.setUp(UnannType.BOOLEAN, "false");
        Assert.assertFalse(((ReturnValuesBool)l.evaluate(c)).value);

        l.setUp(UnannType.BOOLEAN, "failPlease");
        try {
            l.evaluate(c);
            fail("'failPlease' not true or false.");
        } catch (TypeException t) {
            // test passes
        }
    }

    @Test
    public void testChar() throws Exception {
        l.setUp(UnannType.CHAR, "e");
        Assert.assertEquals('e', ((ReturnValuesChar)l.evaluate(c)).value);

        l.setUp(UnannType.CHAR, "!");
        Assert.assertEquals('!', ((ReturnValuesChar)l.evaluate(c)).value);

        l.setUp(UnannType.CHAR, "no");
        try {
            l.evaluate(c);
            fail("'no' has more than one character");
        } catch (TypeException te) {
            // test passes
        }
    }

    @Test
    public void testInt() throws Exception {
        l.setUp(UnannType.INT, "102");
        Assert.assertEquals(102, ((ReturnValuesInt)l.evaluate(c)).value);

        l.setUp(UnannType.INT, "0102");
        Assert.assertEquals(102, ((ReturnValuesInt)l.evaluate(c)).value);

        l.setUp(UnannType.INT, "1o2");
        try {
            l.evaluate(c);
            fail("String contains letter");
        } catch (NumberFormatException nfe) {
            // test passes
        }
    }

    @Test
    public void TestDouble() throws Exception {
        l.setUp(UnannType.DOUBLE, "1.02");
        Assert.assertEquals(1.02, ((ReturnValuesDouble)l.evaluate(c)).value);

        l.setUp(UnannType.DOUBLE, "1.o2");
        try {
            l.evaluate(c);
            fail("String contains letter");
        } catch (NumberFormatException nfe) {
            // test passes
        }
    }
}