package questions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FillArrayToNExerciseTest {

    @Test
    public void returnsTrue() throws Exception {
        FillArrayToNExercise test = new FillArrayToNExercise();
        test.setUp();
        test.runSolution();
        assertTrue(test.checkSolved());
    }

}