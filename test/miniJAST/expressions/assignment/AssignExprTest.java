package miniJAST.expressions.assignment;

import miniJAST.Context;
import miniJAST.expressions.Id;
import miniJAST.expressions.Literal;
import miniJAST.expressions.arrays.ArrayAccess;
import miniJAST.expressions.returnValues.*;
import miniJAST.types.Type;
import miniJAST.types.PrimType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class AssignExprTest {
    AssignExpr aE;
    Context c;
    Id id;
    ArrayAccess aa;
    Literal eT, eF, one, half, A;

    @BeforeMethod
    public void setUp() throws Exception {
        aE = new AssignExpr();
        c = new Context();
        id = new Id();
        aa = new ArrayAccess();
        eT = new Literal();
        eT.setUpLiteral(PrimType.BOOLEAN, "true");
        eF = new Literal();
        eF.setUpLiteral(PrimType.BOOLEAN, "false");
        one = new Literal();
        one.setUpLiteral(PrimType.INT, "1");
        half = new Literal();
        half.setUpLiteral(PrimType.DOUBLE, "0.5");
        A = new Literal();
        A.setUpLiteral(PrimType.CHAR, "A");
    }

    @Test
    public void testEqId() throws Exception {
        c.namesToTypes.peek().put("t", new Type(PrimType.BOOLEAN, false));
        c.namesToTypes.peek().put("o", new Type(PrimType.INT, false));
        c.namesToTypes.peek().put("h", new Type(PrimType.DOUBLE, false));
        c.namesToTypes.peek().put("a", new Type(PrimType.CHAR, false));

        id.setUpId("t");
        aE.setUpAssignExpr(id, AssignOp.EQ, eT);
        aE.evaluate(c);
        assertTrue(((ReturnValuesBool)id.evaluate(c)).value);

        aE.setUpAssignExpr(id, AssignOp.EQ, eF);
        aE.evaluate(c);
        assertFalse(((ReturnValuesBool)id.evaluate(c)).value);

        id.setUpId("o");
        aE.setUpAssignExpr(id, AssignOp.EQ, one);
        aE.evaluate(c);
        assertEquals(1, ((ReturnValuesInt)id.evaluate(c)).value);

        id.setUpId("h");
        aE.setUpAssignExpr(id, AssignOp.EQ, half);
        aE.evaluate(c);
        assertEquals(0.5, ((ReturnValuesDouble)id.evaluate(c)).value);

        id.setUpId("a");
        aE.setUpAssignExpr(id, AssignOp.EQ, A);
        aE.evaluate(c);
        assertEquals('A', ((ReturnValuesChar)id.evaluate(c)).value);
    }

    @Test
    public void testEqArray() throws Exception {
        c.namesToTypes.peek().put("boolArray2", new Type(PrimType.BOOLEAN, true));
        ArrayList<Boolean> bools = new ArrayList<>(2);
        while (bools.size() < 2) {
            bools.add(false);
        }
        c.namesToValues.peek().put("boolArray2", bools);

        c.namesToTypes.peek().put("intArray2", new Type(PrimType.INT, true));
        ArrayList<Integer> ints = new ArrayList<>(2);
        while (ints.size() < 2) {
            ints.add(0);
        }
        c.namesToValues.peek().put("intArray2", ints);

        c.namesToTypes.peek().put("dubArray2", new Type(PrimType.DOUBLE, true));
        ArrayList<Double> dubs = new ArrayList<>(2);
        while (dubs.size() < 2) {
            dubs.add(0.5);
        }
        c.namesToValues.peek().put("dubArray2", dubs);

        c.namesToTypes.peek().put("charArray2", new Type(PrimType.CHAR, true));
        ArrayList<Character> chars = new ArrayList<>(2);
        while (chars.size() < 2) {
            chars.add('\0');
        }
        c.namesToValues.peek().put("charArray2", chars);

        id.setUpId("boolArray2");
        aa.setUpArrayAccess(id, one);
        aE.setUpAssignExpr(aa, AssignOp.EQ, eT);
        aE.evaluate(c);
        assertTrue(((ReturnValuesBoolAA)aa.evaluate(c)).value);

        id.setUpId("intArray2");
        aa.setUpArrayAccess(id, one);
        aE.setUpAssignExpr(aa, AssignOp.EQ, one);
        aE.evaluate(c);
        assertEquals(1, ((ReturnValuesIntAA)aa.evaluate(c)).value);

        id.setUpId("dubArray2");
        aa.setUpArrayAccess(id, one);
        aE.setUpAssignExpr(aa, AssignOp.EQ, half);
        aE.evaluate(c);
        assertEquals(0.5, ((ReturnValuesDoubleAA)aa.evaluate(c)).value);

        id.setUpId("charArray2");
        aa.setUpArrayAccess(id, one);
        aE.setUpAssignExpr(aa, AssignOp.EQ, A);
        aE.evaluate(c);
        assertEquals('A', ((ReturnValuesCharAA)aa.evaluate(c)).value);
    }
    // TODO test other operators
}