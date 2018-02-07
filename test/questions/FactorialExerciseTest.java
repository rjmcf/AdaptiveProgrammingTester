package questions;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FactorialExerciseTest {
    FactorialExercise fE;

    @BeforeMethod
    public void setUp() throws Exception {
        fE = new FactorialExercise();
        fE.setUp();
    }

    @Test
    public void testCheckSolved() throws Exception {
        fE.runSolution();
        assertTrue(fE.checkSolved());
    }
}