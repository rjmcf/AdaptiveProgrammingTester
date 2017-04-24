package questions;

import miniJAST.expressions.Id;
import miniJAST.expressions.Literal;
import miniJAST.types.PrimType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;

import static org.testng.Assert.*;

public class AbstractPExerciseTest {
    FillArrayToNExercise test;

    @BeforeMethod
    public void setUp() throws Exception {
        test = new FillArrayToNExercise(5);
        test.setUp();
    }

    @Test
    public void testAddBlank() throws Exception {
        System.out.println(test.printSolution());
        while (test.addBlank())
            System.out.println(test.printSolution());

        assertFalse(test.addBlank());
    }

    @Test
    public void testMakeHarder() throws Exception {
        try {
            test.makeHarder(0);
            fail("Incorrect number");
        } catch (ArithmeticException ae) {
            // pass test
        }
        try {
            test.makeHarder(-1);
            fail("Incorrect number");
        } catch (ArithmeticException ae) {
            // pass test
        }

        assertEquals(test.makeHarder(1), 0);
        assertEquals(test.makeHarder(3), 0);
        assertEquals(test.makeHarder(15), 0);
        assertTrue(test.makeHarder(3) > 0);

        test.setUp();
        assertEquals(test.makeHarder(21), 0);
        assertTrue(test.makeHarder(1) > 0);
    }

    @Test
    public void testRemoveBlank() throws Exception {
        assertFalse(test.removeBlank());

        test.addBlank();
        assertTrue(test.removeBlank());

        test.makeHarder(21);
        assertFalse(test.addBlank());

        assertTrue(test.removeBlank());
        assertTrue(test.removeBlank());
        assertTrue(test.removeBlank());
        assertTrue(test.removeBlank());
        assertTrue(test.removeBlank());

        assertTrue(test.removeBlank());
        assertTrue(test.removeBlank());
        assertTrue(test.removeBlank());
        assertTrue(test.removeBlank());
        assertTrue(test.removeBlank());

        assertTrue(test.removeBlank());
        assertTrue(test.removeBlank());
        assertTrue(test.removeBlank());
        assertTrue(test.removeBlank());
        assertTrue(test.removeBlank());

        assertTrue(test.removeBlank());
        assertTrue(test.removeBlank());
        assertTrue(test.removeBlank());
        assertTrue(test.removeBlank());
        assertTrue(test.removeBlank());

        assertTrue(test.removeBlank());

        assertFalse(test.removeBlank());
    }

    @Test
    public void testMakeEasier() throws Exception {
        try {
            test.makeEasier(0);
            fail("Incorrect number");
        } catch (ArithmeticException ae) {
            // pass test
        }
        try {
            test.makeEasier(-1);
            fail("Incorrect number");
        } catch (ArithmeticException ae) {
            // pass test
        }

        assertTrue(test.makeEasier(1) > 0);

        test.addBlank();
        assertEquals(test.makeEasier(1), 0);

        test.makeHarder(20);
        assertEquals(test.makeEasier(20), 0);
        assertTrue(test.makeEasier(1) > 0);

        test.makeHarder(10);
        assertTrue(test.makeEasier(11) > 0);

        assertEquals(test.getQuestionDiffModifier(), 0f);

        for (int i = 0; i < 20; i++) {
            test.makeHarder(i + 1);
            assertEquals(test.makeEasier(i + 1), 0);
            assertEquals(test.getQuestionDiffModifier(), 0f);
        }
    }

    @Test
    public void testGetQuestionDifficultyModifier() throws Exception {
        float newDifficulty, currentDifficulty = test.getQuestionDiffModifier();
        assertEquals(currentDifficulty, 0.0f);
        for (int i = 0; i < 21; i++) {
            test.addBlank();
            newDifficulty = test.getQuestionDiffModifier();
            assertTrue(newDifficulty >= currentDifficulty, "Test failed on iteration " + i);
            currentDifficulty = newDifficulty;
        }
        assertEquals(currentDifficulty, 1.0f);

        assertFalse(test.addBlank());
    }

    @Test
    public void testGetQuestionDifficulty() throws Exception {
        float orig = test.getQuestionDifficulty();
        test.makeHarder(21);
        assertTrue(orig + 1 == test.getQuestionDifficulty());
    }

    @Test
    public void testGetBlankIds() throws Exception {
        assertEquals(test.getBlankIds().size(), 0);

        test.addBlank();
        assertEquals(test.getBlankIds().size(), 1);
        test.removeBlank();
        assertEquals(test.getBlankIds().size(), 0);
    }

    @Test
    public void testFillBlank() throws Exception {
        for (int i = 0; i < 5; i++) {
            test.addBlank();
        }

        ArrayList<Integer> ids = test.getBlankIds();
        FileOutputStream fO = new FileOutputStream("test/testOutput.txt", true);
        PrintStream pW = new PrintStream(fO);
        pW.println(ids);

        Literal five = new Literal();
        five.setUpLiteral(PrimType.INT, "5");
        assertTrue(test.fillBlank(ids.get(0), five));

        Literal zero = new Literal();
        zero.setUpLiteral(PrimType.INT, "0");
        assertTrue(test.fillBlank(ids.get(1), zero));

        Id i = new Id();
        i.setUpId("i");
        assertTrue(test.fillBlank(ids.get(2), i));
        assertTrue(test.fillBlank(ids.get(3), five));

        Id ns = new Id();
        ns.setUpId("ns");
        assertTrue(test.fillBlank(ids.get(4), ns));

        assertFalse(test.fillBlank(ids.get(4) + 10, zero));

        test.runSolution();
        assertTrue(test.checkSolved());
    }
}