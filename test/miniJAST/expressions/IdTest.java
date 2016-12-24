package miniJAST.expressions;

import miniJAST.Context;
import miniJAST.exceptions.VariableDecException;
import miniJAST.expressions.returnValues.ReturnValuesArray;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.expressions.returnValues.ReturnValuesInt;
import miniJAST.types.Type;
import miniJAST.types.UnannType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class IdTest {
    Id id;
    Context c;

    @BeforeMethod
    public void setUp() throws Exception {
        id = new Id();
        c = new Context();
        c.namesToTypes.put("t", new Type(UnannType.BOOLEAN, 1));
        c.namesToValues.put("t", true);
        c.namesToTypes.put("int2", new Type(UnannType.INT, 1));
        c.namesToValues.put("int2", 2);
        c.namesToTypes.put("message", new Type(UnannType.CHAR, 6));
        ArrayList<Character> m = new ArrayList<>();
        m.add('I');
        m.add('d');
        m.add(' ');
        m.add('t');
        m.add('e');
        m.add('s');
        m.add('t');
        c.namesToValues.put("message", m);
    }

    @Test
    public void testEvaluate() throws Exception {
        id.setUpId(new Type(UnannType.BOOLEAN,1), "t");
        assertTrue(((ReturnValuesBool)id.evaluate(c)).value);

        id.setUpId(new Type(UnannType.BOOLEAN, 2), "t");
        try {
            id.evaluate(c);
            fail("t has wrong type (size)");
        } catch (VariableDecException e) {
            // pass test
        }

        id.setUpId(new Type(UnannType.INT, 1), "t");
        try {
            id.evaluate(c);
            fail("t has wrong type (type)");
        } catch (VariableDecException e) {
            // pass test
        }

        id.setUpId(new Type(UnannType.INT, 1), "int2");
        assertEquals(2, ((ReturnValuesInt)id.evaluate(c)).value);

        id.setUpId(new Type(UnannType.CHAR, 6), "message");
        String s = "Id test";
        ReturnValuesArray ar = (ReturnValuesArray)id.evaluate(c);
        assertEquals(s.length(), ar.getSize());
        for (int i = 0; i < s.length(); i++) {
            assertEquals(s.charAt(i), ar.get(i));
        }
    }
}