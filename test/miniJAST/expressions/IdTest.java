package miniJAST.expressions;

import miniJAST.Context;
import miniJAST.expressions.returnValues.ReturnValuesArray;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.expressions.returnValues.ReturnValuesInt;
import miniJAST.types.Type;
import miniJAST.types.PrimType;
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
        c.namesToTypes.peek().put("t", new Type(PrimType.BOOLEAN, false));
        c.namesToValues.peek().put("t", true);
        c.namesToTypes.peek().put("int2", new Type(PrimType.INT, false));
        c.namesToValues.peek().put("int2", 2);
        c.namesToTypes.peek().put("message", new Type(PrimType.CHAR, true));
        ArrayList<Character> m = new ArrayList<>();
        m.add('I');
        m.add('d');
        m.add(' ');
        m.add('t');
        m.add('e');
        m.add('s');
        m.add('t');
        c.namesToValues.peek().put("message", m);
    }

    @Test
    public void testEvaluate() throws Exception {
        id.setUpId("t");
        assertTrue(((ReturnValuesBool)id.evaluate(c)).value);

        id.setUpId("int2");
        assertEquals(2, ((ReturnValuesInt)id.evaluate(c)).value);

        id.setUpId("message");
        String s = "Id test";
        ReturnValuesArray ar = (ReturnValuesArray)id.evaluate(c);
        assertEquals(s.length(), ar.getSize());
        for (int i = 0; i < s.length(); i++) {
            assertEquals(s.charAt(i), ar.get(i));
        }
    }
}