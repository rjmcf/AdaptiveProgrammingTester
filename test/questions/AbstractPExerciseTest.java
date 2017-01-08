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

    @Test
    public void testRemoveBlank() throws Exception {
        assertFalse(test.removeBlank());

        test.addBlank();
        assertTrue(test.removeBlank());

        test.makeHarder(20);
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
        assertFalse(test.makeEasier(0));
        assertFalse(test.makeEasier(-1));
        assertFalse(test.makeEasier(1));

        test.addBlank();
        assertTrue(test.makeEasier(1));

        test.makeHarder(20);
        assertTrue(test.makeEasier(20));
        assertFalse(test.makeEasier(1));

        test.makeHarder(10);
        assertFalse(test.makeEasier(11));

        assertEquals(test.getQuestionDiffModifier(), 0f);

        for (int i = 0; i < 20; i++) {
            test.makeHarder(i + 1);
            assertTrue(test.makeEasier(i + 1));
            assertEquals(test.getQuestionDiffModifier(), 0f);
        }
    }
}