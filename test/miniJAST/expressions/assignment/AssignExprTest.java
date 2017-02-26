package miniJAST.expressions.assignment;

import miniJAST.Context;
import miniJAST.expressions.Id;
import miniJAST.expressions.Literal;
import miniJAST.expressions.arrays.ArrayAccess;
import miniJAST.expressions.returnValues.*;
import miniJAST.types.Type;
import miniJAST.types.UnannType;
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
        eT.setUpLiteral(UnannType.BOOLEAN, "true");
        eF = new Literal();
        eF.setUpLiteral(UnannType.BOOLEAN, "false");
        one = new Literal();
        one.setUpLiteral(UnannType.INT, "1");
        half = new Literal();
        half.setUpLiteral(UnannType.DOUBLE, "0.5");
        A = new Literal();
        A.setUpLiteral(UnannType.CHAR, "A");
    }

    @Test
    public void testEqId() throws Exception {
        c.namesToTypes.put("t", new Type(UnannType.BOOLEAN));
        c.namesToTypes.put("o", new Type(UnannType.INT));
        c.namesToTypes.put("h", new Type(UnannType.DOUBLE));
        c.namesToTypes.put("a", new Type(UnannType.CHAR));

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
        c.namesToTypes.put("boolArray2", new Type(UnannType.BOOLEAN, 2));
        ArrayList<Boolean> bools = new ArrayList<>(2);
        while (bools.size() < 2) {
            bools.add(false);
        }
        c.namesToValues.put("boolArray2", bools);
        c.namesToTypes.put("intArray2", new Type(UnannType.INT, 2));
        ArrayList<Integer> ints = new ArrayList<>(2);
        while (ints.size() < 2) {
            ints.add(0);
        }
        c.namesToValues.put("intArray2", ints);
        c.namesToTypes.put("dubArray2", new Type(UnannType.DOUBLE, 2));
        ArrayList<Double> dubs = new ArrayList<>(2);
        while (dubs.size() < 2) {
            dubs.add(0.5);
        }
        c.namesToValues.put("dubArray2", dubs);
        c.namesToTypes.put("charArray2", new Type(UnannType.CHAR, 2));
        ArrayList<Character> chars = new ArrayList<>(2);
        while (chars.size() < 2) {
            chars.add('\0');
        }
        c.namesToValues.put("charArray2", chars);

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