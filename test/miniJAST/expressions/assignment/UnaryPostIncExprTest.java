package miniJAST.expressions.assignment;

import miniJAST.Context;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Id;
import miniJAST.expressions.returnValues.ReturnValuesInt;
import miniJAST.types.Type;
import miniJAST.types.UnannType;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UnaryPostIncExprTest {
    UnaryPostIncExpr e;
    Context c;
    Id id;

    @BeforeMethod
    public void setUp() throws Exception {
        e = new UnaryPostIncExpr();
        c = new Context();
        c.namesToTypes.put("t", new Type(UnannType.BOOLEAN, 1));
        c.namesToValues.put("t", true);
        c.namesToTypes.put("i", new Type(UnannType.INT, 1));
        c.namesToValues.put("i", 0);
        id = new Id();
    }

    @Test
    public void testIds() throws Exception {
        id.setUpIdSimple(UnannType.BOOLEAN, "t");
        e.setUpPostIncExpr(true, id);
        try {
            e.evaluate(c);
            fail("Cannot increment a boolean");
        } catch (TypeException te) {
            // pass test
        }

        id.setUpIdSimple(UnannType.INT, "i");
        e.setUpPostIncExpr(true, id);
        Assert.assertEquals(0, ((ReturnValuesInt)e.evaluate(c)).value);
        Assert.assertEquals(1, ((ReturnValuesInt)id.evaluate(c)).value);

        e.setUpPostIncExpr(false, id);
        Assert.assertEquals(1, ((ReturnValuesInt)e.evaluate(c)).value);
        Assert.assertEquals(0, ((ReturnValuesInt)id.evaluate(c)).value);
    }

    // TODO test arrays
}