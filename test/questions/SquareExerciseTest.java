package questions;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SquareExerciseTest {
    SquareExercise sE;

    @BeforeMethod
    public void setUp() throws Exception {
        sE = new SquareExercise();
        sE.setUp();
    }

    @Test
    public void testCheckSolved() throws Exception {
        sE.runSolution();
        assertTrue(sE.checkSolved());
    }
}
