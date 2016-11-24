package questions;

import miniJAST.MiniJASTNode;

public abstract class AbstractPExercise {
    private String question;
    public abstract void setUp();
    public abstract void runSolution();
    public abstract boolean checkSolved();
    protected MiniJASTNode solutionRoot;

    public AbstractPExercise(String q) { question = q; }
}
