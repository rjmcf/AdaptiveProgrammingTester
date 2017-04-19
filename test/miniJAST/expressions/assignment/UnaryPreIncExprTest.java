package miniJAST.expressions.assignment;

import miniJAST.Context;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Id;
import miniJAST.expressions.returnValues.ReturnValuesInt;
import miniJAST.types.Type;
import miniJAST.types.PrimType;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UnaryPreIncExprTest {
    UnaryPreIncExpr e;
    Context c;
    Id id;

    @BeforeMethod
    public void setUp() throws Exception {
        e = new UnaryPreIncExpr();
        c = new Context();
        c.namesToTypes.peek().put("t", new Type(PrimType.BOOLEAN, false));
        c.namesToValues.peek().put("t", true);
        c.namesToTypes.peek().put("i", new Type(PrimType.INT, false));
        c.namesToValues.peek().put("i", 0);
        id = new Id();
    }

    @Test
    public void testIds() throws Exception {
        id.setUpId("t");
        e.setUpPreIncExpr(true, id);
        try {
            e.evaluate(c);
            fail("Cannot increment a boolean");
        } catch (TypeException te) {
            // pass test
        }

        id.setUpId("i");
        e.setUpPreIncExpr(true, id);
        Assert.assertEquals(1, ((ReturnValuesInt)e.evaluate(c)).value);
        Assert.assertEquals(1, ((ReturnValuesInt)id.evaluate(c)).value);

        e.setUpPreIncExpr(false, id);
        Assert.assertEquals(0, ((ReturnValuesInt)e.evaluate(c)).value);
        Assert.assertEquals(0, ((ReturnValuesInt)id.evaluate(c)).value);
    }

    // TODO test arrays
}