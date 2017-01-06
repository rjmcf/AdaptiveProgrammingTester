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
        assertFalse(test.addBlank());
    }
}