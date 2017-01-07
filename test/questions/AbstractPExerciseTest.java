package questions;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        assertTrue(test.addBlank());
        assertTrue(test.addBlank());
        assertTrue(test.addBlank());
        assertTrue(test.addBlank());
        assertTrue(test.addBlank());

        assertTrue(test.addBlank());
        assertTrue(test.addBlank());
        assertTrue(test.addBlank());
        assertTrue(test.addBlank());
        assertTrue(test.addBlank());

        assertTrue(test.addBlank());
        assertTrue(test.addBlank());
        assertTrue(test.addBlank());
        assertTrue(test.addBlank());
        assertTrue(test.addBlank());

        assertTrue(test.addBlank());
        assertTrue(test.addBlank());
        assertTrue(test.addBlank());
        assertTrue(test.addBlank());
        assertTrue(test.addBlank());

        assertFalse(test.addBlank());
    }

    @Test
    public void testMakeHarder() throws Exception {
        assertFalse(test.makeHarder(0));
        assertFalse(test.makeHarder(-1));

        assertTrue(test.makeHarder(1));
        assertTrue(test.makeHarder(3));
        assertTrue(test.makeHarder(15));
        assertFalse(test.makeHarder(2));

        test.setUp();
        assertTrue(test.makeHarder(20));
        assertFalse(test.makeHarder(1));
    }

    @Test
    public void testGetQuestionDifficulty() throws Exception {
        float newDifficulty, currentDifficulty = test.getQuestionDiffModifier();
        assertEquals(currentDifficulty, 0.0f);
        for (int i = 0; i < 20; i++) {
            test.addBlank();
            newDifficulty = test.getQuestionDiffModifier();
            assertTrue(newDifficulty >= currentDifficulty, "Test failed on iteration " + i);
            currentDifficulty = newDifficulty;
        }
        assertEquals(currentDifficulty, 1.0f);

        assertFalse(test.addBlank());
    }
}