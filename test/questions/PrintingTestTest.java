package questions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PrintingTestTest {

    @Test
    public void testCheckSolved() throws Exception {
        PrintingTest t = new PrintingTest(6);
        t.setUp();
        t.runSolution();
        assertTrue(t.checkSolved());

    }
}