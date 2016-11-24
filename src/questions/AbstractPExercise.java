package questions;

public abstract class AbstractPExercise {
    private String question;
    public abstract void setUp();
    public abstract void runSolution();
    public abstract boolean checkSolved();

    public AbstractPExercise(String q) { question = q; }
}
