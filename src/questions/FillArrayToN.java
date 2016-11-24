package questions;

import miniJAST.*;

public class FillArrayToN extends AbstractPExercise {
    private int[] a = new int[10];
    private int items;
    public FillArrayToN(int n) {
        super("Fill the built-in array 'a' with integers from 0 to " + n);
        items = n;
        buildSolution();
    }

    @Override
    public void setUp() {

    }

    @Override
    public void runSolution() {

    }

    @Override
    public boolean checkSolved() {
        for (int i=0; i < items; i++)
            if (a[i] != i)
                return false;

        return true;
    }

    private void buildSolution() {
        /* Code
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        */

        solutionRoot = new ForLoopNode(
                new AssignExpr("int i", new GenExpr("0", true), true),
                new BoolExpr("i < " + items, true),
                new GenExpr("i++", true),
                new AssignExpr("a[i]", new GenExpr("i", true), true),
                true
        );
    }
}
