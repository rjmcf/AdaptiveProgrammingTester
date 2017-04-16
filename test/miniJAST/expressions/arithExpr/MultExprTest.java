package miniJAST.expressions.arithExpr;

import miniJAST.Context;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Id;
import miniJAST.expressions.Literal;
import miniJAST.expressions.returnValues.ReturnValuesDouble;
import miniJAST.expressions.returnValues.ReturnValuesInt;
import miniJAST.types.Type;
import miniJAST.types.PrimType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class MultExprTest {
    MultExpr e;
    Literal int2;
    Literal int3;
    Literal doubHalf;
    Literal doubQuart;
    Literal charA;
    Literal charB;
    Literal boolTrue;
    Id id;
    Context c;


    @BeforeMethod
    public void setUp() throws Exception {
        e = new MultExpr();
        c = new Context();
        c.namesToTypes.peek().put("array", new Type(PrimType.INT, 2));
        ArrayList<Integer> ints = new ArrayList<>(2);
        ints.add(1);
        ints.add(2);
        c.namesToValues.peek().put("array", ints);
        id = new Id();
        id.setUpId("array");
        int2 = new Literal();
        int2.setUpLiteral(PrimType.INT, "2");
        int3 = new Literal();
        int3.setUpLiteral(PrimType.INT, "3");
        doubHalf = new Literal();
        doubHalf.setUpLiteral(PrimType.DOUBLE, "0.5");
        doubQuart = new Literal();
        doubQuart.setUpLiteral(PrimType.DOUBLE, "0.25");
        charA = new Literal();
        charA.setUpLiteral(PrimType.CHAR, "A");
        charB = new Literal();
        charB.setUpLiteral(PrimType.CHAR, "B");
        boolTrue = new Literal();
        boolTrue.setUpLiteral(PrimType.BOOLEAN, "true");

    }

    @Test
    public void testEvaluate() throws Exception {
        e.setUpMultExpr(true, int2, int3);
        assertEquals(6, ((ReturnValuesInt)e.evaluate(c)).value);

        e.setUpMultExpr(false, int3, int2);
        assertEquals(1, ((ReturnValuesInt)e.evaluate(c)).value);

        e.setUpMultExpr(true, doubHalf, int2);
        assertEquals(1.0, ((ReturnValuesDouble)e.evaluate(c)).value);

        e.setUpMultExpr(false, int2, doubHalf);
        assertEquals(4.0, ((ReturnValuesDouble)e.evaluate(c)).value);

        e.setUpMultExpr(true, int2, charA);
        assertEquals(2 * 'A', ((ReturnValuesInt)e.evaluate(c)).value);

        e.setUpMultExpr(false, charB, int3);
        assertEquals('B' / 3, ((ReturnValuesInt)e.evaluate(c)).value);

        e.setUpMultExpr(true, doubHalf, doubQuart);
        assertEquals(0.125, ((ReturnValuesDouble)e.evaluate(c)).value);

        e.setUpMultExpr(false, doubQuart, doubHalf);
        assertEquals(0.5, ((ReturnValuesDouble)e.evaluate(c)).value);

        e.setUpMultExpr(true, doubHalf, charA);
        assertEquals(0.5 * 'A', ((ReturnValuesDouble)e.evaluate(c)).value);

        e.setUpMultExpr(false, charB, doubHalf);
        assertEquals('B' / 0.5, ((ReturnValuesDouble)e.evaluate(c)).value);

        e.setUpMultExpr(true, charB, charA);
        assertEquals('B' * 'A', ((ReturnValuesInt)e.evaluate(c)).value);

        e.setUpMultExpr(false, charA, charB);
        assertEquals('A' / 'B', ((ReturnValuesInt)e.evaluate(c)).value);

        e.setUpMultExpr(true, boolTrue, int3);
        try {
            e.evaluate(c);
            fail("Should not be able to multiply true by 3");
        } catch (TypeException te) {
            // pass test
        }

        e.setUpMultExpr(false, int2, boolTrue);
        try {
            e.evaluate(c);
            fail("Should not be able to divide 2 by true");
        } catch (TypeException te) {
            // pass test
        }

        e.setUpMultExpr(true, int2, id);
        try {
            e.evaluate(c);
            fail("Can't multiply arrays");
        } catch (TypeException te) {
            // pass test
        }

        e.setUpMultExpr(false, id, int3);
        try {
            e.evaluate(c);
            fail("Can't divide arrays");
        } catch (TypeException te) {
            // pass test
        }
    }

}