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
    FillArrayToNExercise testArrayN;
    FactorialExercise testFac;
    SquareExercise testSq;
    PrintingTest testPr;

    @BeforeMethod
    public void setUp() throws Exception {
        testArrayN = new FillArrayToNExercise(5);
        testArrayN.setUp();
        testFac = new FactorialExercise(5);
        testFac.setUp();
        testSq = new SquareExercise(5);
        testSq.setUp();
        testPr = new PrintingTest(5);
        testPr.setUp();
    }

    @Test
    public void testAddBlank() throws Exception {
        while (testArrayN.addBlank());
        assertFalse(testArrayN.addBlank());

        while (testFac.addBlank());
        assertFalse(testFac.addBlank());

        while (testSq.addBlank());
        assertFalse(testSq.addBlank());

        while (testPr.addBlank());
        assertFalse(testPr.addBlank());
    }

    @Test
    public void testMakeHarder() throws Exception {
        try {
            testArrayN.makeHarder(0);
            fail("Incorrect number");
        } catch (ArithmeticException ae) {
            // pass test
        }
        try {
            testArrayN.makeHarder(-1);
            fail("Incorrect number");
        } catch (ArithmeticException ae) {
            // pass test
        }

        assertEquals(testArrayN.makeHarder(1), 0);
        assertEquals(testArrayN.makeHarder(3), 0);
        assertEquals(testArrayN.makeHarder(15), 0);
        assertTrue(testArrayN.makeHarder(3) > 0);

        testArrayN.setUp();
        assertEquals(testArrayN.makeHarder(21), 0);
        assertTrue(testArrayN.makeHarder(1) > 0);
    }

    @Test
    public void testRemoveBlank() throws Exception {
        assertFalse(testArrayN.removeBlank());

        testArrayN.addBlank();
        assertTrue(testArrayN.removeBlank());

        testArrayN.makeHarder(testArrayN.numNodes());
        assertFalse(testArrayN.addBlank());
        for (int i = 0; i < testArrayN.numNodes(); i++)
            assertTrue(testArrayN.removeBlank());
        assertFalse(testArrayN.removeBlank());
        testArrayN.runSolution();
        assertTrue(testArrayN.checkSolved());

        testFac.makeHarder(testFac.numNodes());
        assertFalse(testFac.addBlank());
        for (int i = 0; i < testFac.numNodes(); i++)
            assertTrue(testFac.removeBlank());
        assertFalse(testFac.removeBlank());
        testFac.runSolution();
        assertTrue(testFac.checkSolved());

        testSq.makeHarder(testSq.numNodes());
        assertFalse(testSq.addBlank());
        for (int i = 0; i < testSq.numNodes(); i++)
            assertTrue(testSq.removeBlank());
        assertFalse(testSq.removeBlank());
        testSq.runSolution();
        assertTrue(testSq.checkSolved());

        testPr.makeHarder(testPr.numNodes());
        assertFalse(testPr.addBlank());
        for (int i = 0; i < testPr.numNodes(); i++)
            assertTrue(testPr.removeBlank());
        assertFalse(testPr.removeBlank());
        testPr.runSolution();
        assertTrue(testPr.checkSolved());
    }

    @Test
    public void testMakeEasier() throws Exception {
        try {
            testArrayN.makeEasier(0);
            fail("Incorrect number");
        } catch (ArithmeticException ae) {
            // pass test
        }
        try {
            testArrayN.makeEasier(-1);
            fail("Incorrect number");
        } catch (ArithmeticException ae) {
            // pass test
        }

        assertTrue(testArrayN.makeEasier(1) > 0);

        testArrayN.addBlank();
        assertEquals(testArrayN.makeEasier(1), 0);

        testArrayN.makeHarder(20);
        assertEquals(testArrayN.makeEasier(20), 0);
        assertTrue(testArrayN.makeEasier(1) > 0);

        testArrayN.makeHarder(10);
        assertTrue(testArrayN.makeEasier(11) > 0);

        assertEquals(testArrayN.getQuestionDiffModifier(), 0f);

        for (int i = 0; i < 20; i++) {
            testArrayN.makeHarder(i + 1);
            assertEquals(testArrayN.makeEasier(i + 1), 0);
            assertEquals(testArrayN.getQuestionDiffModifier(), 0f);
        }
    }

    @Test
    public void testGetQuestionDifficultyModifier() throws Exception {
        float newDifficulty, currentDifficulty = testArrayN.getQuestionDiffModifier();
        assertEquals(currentDifficulty, 0.0f);
        for (int i = 0; i < 21; i++) {
            testArrayN.addBlank();
            newDifficulty = testArrayN.getQuestionDiffModifier();
            assertTrue(newDifficulty >= currentDifficulty, "Test failed on iteration " + i);
            currentDifficulty = newDifficulty;
        }
        assertEquals(currentDifficulty, 1.0f);

        assertFalse(testArrayN.addBlank());
    }

    @Test
    public void testGetQuestionDifficulty() throws Exception {
        float orig = testArrayN.getQuestionDifficulty();
        testArrayN.makeHarder(21);
        assertTrue(orig + 1 == testArrayN.getQuestionDifficulty());
    }

    @Test
    public void testGetBlankIds() throws Exception {
        assertEquals(testArrayN.getBlankIds().size(), 0);

        testArrayN.addBlank();
        assertEquals(testArrayN.getBlankIds().size(), 1);
        testArrayN.removeBlank();
        assertEquals(testArrayN.getBlankIds().size(), 0);
    }

    @Test
    public void testFillBlank() throws Exception {
        for (int i = 0; i < 5; i++) {
            testArrayN.addBlank();
        }

        ArrayList<Integer> ids = testArrayN.getBlankIds();
        FileOutputStream fO = new FileOutputStream("test/testOutput.txt", true);
        PrintStream pW = new PrintStream(fO);
        pW.println(ids);

        Literal five = new Literal();
        five.setUpLiteral(PrimType.INT, "5");
        assertTrue(testArrayN.fillBlank(ids.get(0), five));

        Literal zero = new Literal();
        zero.setUpLiteral(PrimType.INT, "0");
        assertTrue(testArrayN.fillBlank(ids.get(1), zero));

        Id i = new Id();
        i.setUpId("i");
        assertTrue(testArrayN.fillBlank(ids.get(2), i));
        assertTrue(testArrayN.fillBlank(ids.get(3), five));

        Id ns = new Id();
        ns.setUpId("ns");
        assertTrue(testArrayN.fillBlank(ids.get(4), ns));

        assertFalse(testArrayN.fillBlank(ids.get(4) + 10, zero));

        testArrayN.runSolution();
        assertTrue(testArrayN.checkSolved());
    }
}