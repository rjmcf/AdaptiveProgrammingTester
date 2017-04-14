package questions;

import miniJAST.statements.Block;

public class PrintingTest extends AbstractPExercise {
    int N;
    int NthNum;

    public PrintingTest (int n) {
        super("", 0);
        N = n;
        int j = 0;
        for (int i = 1; i <= N; i++)
            j += i;
        NthNum = j;
    }

    @Override
    public void setUp() {
        /* Code
        int j = 0;
        for (int i = 1; i <= N; i++) {
            j += i;
        }
        System.out.println(j);
        // Check that j is Nth triangle number
         */



    }

    @Override
    public boolean checkSolved() {
        return false;
    }
}
