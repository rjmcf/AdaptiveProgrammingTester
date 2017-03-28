package miniJAST.expressions.arrays;

import miniJAST.Context;
import miniJAST.exceptions.OutOfBoundsException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Id;
import miniJAST.expressions.Literal;
import miniJAST.expressions.returnValues.*;
import miniJAST.types.Type;
import miniJAST.types.PrimType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class ArrayAccessTest {
    ArrayAccess aa;
    Id id;
    Literal zero;
    Literal one;
    Literal two;
    Literal minus;
    Literal dub;
    Literal ch;
    Literal bool;
    Context c;

    @BeforeMethod
    public void setUp() throws Exception {
        aa = new ArrayAccess();
        id = new Id();
        c = new Context();
        c.namesToTypes.put("boolArray", new Type(PrimType.BOOLEAN, 2));
        ArrayList<Boolean> bools = new ArrayList<>(2);
        bools.add(true);
        bools.add(false);
        c.namesToValues.put("boolArray", bools);
        c.namesToTypes.put("intArray", new Type(PrimType.INT, 2));
        ArrayList<Integer> ints = new ArrayList<>(2);
        ints.add(1);
        ints.add(-1);
        c.namesToValues.put("intArray", ints);
        c.namesToTypes.put("dubArray", new Type(PrimType.DOUBLE, 2));
        ArrayList<Double> dubs = new ArrayList<>(2);
        dubs.add(0.5);
        dubs.add(0.25);
        c.namesToValues.put("dubArray", dubs);
        c.namesToTypes.put("charArray", new Type(PrimType.CHAR, 2));
        ArrayList<Character> chars = new ArrayList<>(2);
        chars.add('A');
        chars.add('!');
        c.namesToValues.put("charArray", chars);
        c.namesToTypes.put("singleInt", new Type(PrimType.INT, 1));
        ArrayList<Integer> oneInt = new ArrayList<>(1);
        oneInt.add(3);
        c.namesToValues.put("singleInt", oneInt);
        zero = new Literal();
        zero.setUpLiteral(PrimType.INT, "0");
        one = new Literal();
        one.setUpLiteral(PrimType.INT, "1");
        two = new Literal();
        two.setUpLiteral(PrimType.INT, "2");
        minus = new Literal();
        minus.setUpLiteral(PrimType.INT, "-1");
        dub = new Literal();
        dub.setUpLiteral(PrimType.DOUBLE, "0.5");
        ch = new Literal();
        ch.setUpLiteral(PrimType.CHAR, "A");
        bool = new Literal();
        bool.setUpLiteral(PrimType.BOOLEAN, "true");
    }

    @Test
    public void testEvaluate() throws Exception {
        id.setUpId("boolArray");
        aa.setUpArrayAccess(id, zero);
        assertTrue(((ReturnValuesBoolAA)aa.evaluate(c)).value);
        assertEquals("boolArray", ((ReturnValuesBoolAA)aa.evaluate(c)).getName());
        assertEquals(0, ((ReturnValuesBoolAA)aa.evaluate(c)).getIndex());

        aa.setUpArrayAccess(id, one);
        assertFalse(((ReturnValuesBoolAA)aa.evaluate(c)).value);

        aa.setUpArrayAccess(id, two);
        try {
            aa.evaluate(c);
            fail("Cannot index bool array with index 2");
        } catch (OutOfBoundsException ex) {
            // pass test
        }

        aa.setUpArrayAccess(id, minus);
        try {
            aa.evaluate(c);
            fail("Cannot index bool array with index -1");
        } catch (OutOfBoundsException ex) {
            // pass test
        }

        aa.setUpArrayAccess(id, dub);
        try {
            aa.evaluate(c);
            fail("Cannot index bool array with double");
        } catch (TypeException ex) {
            // pass test
        }

        aa.setUpArrayAccess(id, ch);
        try {
            aa.evaluate(c);
            fail("Cannot index bool array with char");
        } catch (TypeException ex) {
            // pass test
        }

        aa.setUpArrayAccess(id, bool);
        try {
            aa.evaluate(c);
            fail("Cannot index bool array with bool");
        } catch (TypeException ex) {
            // pass test
        }

        id.setUpId("intArray");
        aa.setUpArrayAccess(id, zero);
        assertEquals(1, ((ReturnValuesIntAA)aa.evaluate(c)).value);

        aa.setUpArrayAccess(id, one);
        assertEquals(-1, ((ReturnValuesIntAA)aa.evaluate(c)).value);

        aa.setUpArrayAccess(id, id);
        try {
            aa.evaluate(c);
            fail("cannot index using array");
        } catch (TypeException ex) {
            // pass test
        }

        id.setUpId("dubArray");
        aa.setUpArrayAccess(id, zero);
        assertEquals(0.5, ((ReturnValuesDoubleAA)aa.evaluate(c)).value);

        aa.setUpArrayAccess(id, one);
        assertEquals(0.25, ((ReturnValuesDoubleAA)aa.evaluate(c)).value);

        id.setUpId("charArray");
        aa.setUpArrayAccess(id, zero);
        assertEquals('A', ((ReturnValuesCharAA)aa.evaluate(c)).value);

        aa.setUpArrayAccess(id, one);
        assertEquals('!', ((ReturnValuesCharAA)aa.evaluate(c)).value);

        id.setUpId("singleInt");
        aa.setUpArrayAccess(id, zero);
        aa.evaluate(c);
        assertEquals(((ReturnValuesInt)aa.evaluate(c)).value, 3);
    }
}