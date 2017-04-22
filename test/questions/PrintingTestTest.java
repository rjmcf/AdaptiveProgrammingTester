package questions;

import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

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