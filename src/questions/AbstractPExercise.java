package questions;

import miniJAST.NodeCount;
import miniJAST.statements.Statement;

public abstract class AbstractPExercise {
    public String question;
    protected Statement solution;
    private float baseDifficulty;
    public abstract void setUp();
    public abstract void runSolution();
    public abstract boolean checkSolved();

    public AbstractPExercise(String q, float diff) { question = q; baseDifficulty = diff; }

    public float getQuestionDifficulty() {
        NodeCount count = solution.getTreeSize();
        float percentageEmpty = count.empty / (count.filled + count.empty);
        return baseDifficulty + percentageEmpty;
    }

    public void deliverQuestion() {
        System.out.println(question);
        System.out.println();
        System.out.println(solution.stringRepr());
    }
}
