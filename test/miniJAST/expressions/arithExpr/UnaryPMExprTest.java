package miniJAST.expressions.arithExpr;

import miniJAST.Context;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Id;
import miniJAST.expressions.Literal;
import miniJAST.expressions.returnValues.ReturnValuesDouble;
import miniJAST.expressions.returnValues.ReturnValuesInt;
import miniJAST.types.Type;
import miniJAST.types.UnannType;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class UnaryPMExprTest {
    UnaryPMExpr e;
    Context c;
    Literal intE;
    Literal doubE;
    Literal charE;
    Literal boolE;
    Id id;

    @BeforeMethod
    public void setUp() throws Exception {
        e = new UnaryPMExpr();
        c = new Context();
        c.namesToTypes.put("array", new Type(UnannType.INT, 2));
        ArrayList<Integer> ints = new ArrayList<>(2);
        ints.add(1);
        ints.add(2);
        c.namesToValues.put("array", ints);
        id = new Id();
        id.setUpId(new Type(UnannType.INT, 2), "array");
        intE = new Literal();
        intE.setUpLiteral(UnannType.INT, "2");
        doubE = new Literal();
        doubE.setUpLiteral(UnannType.DOUBLE, "0.5");
        charE = new Literal();
        charE.setUpLiteral(UnannType.CHAR, "E");
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

        e.setUpPMExpr(true, charE);
        Assert.assertEquals('E', ((ReturnValuesInt)e.evaluate(c)).value);

        e.setUpPMExpr(false, charE);
        Assert.assertEquals(-'E', ((ReturnValuesInt)e.evaluate(c)).value);

        e.setUpPMExpr(true, boolE);
        try {
            e.evaluate(c);
            fail("Cannot make a boolean expression positive or negative");
        } catch (TypeException te) {
            // pass test
        }

        e.setUpPMExpr(true, id);
        try {
            e.evaluate(c);
            fail("Cannot make an array positive or negative");
        } catch (TypeException te) {
            // pass test
        }
    }
}