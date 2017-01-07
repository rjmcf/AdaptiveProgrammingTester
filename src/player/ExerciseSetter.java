package player;

import miniJAST.MiniJASTNode;
import questions.AbstractPExercise;

public class ExerciseSetter {
    AbstractPExercise exercise;
    int attempts = 0;
    int numNodes;


    public void setUp() {
        exercise.setUp();
        attempts = 0;
        numNodes = exercise.numNodes();
    }

    public void setExercise(AbstractPExercise e) { exercise = e; setUp(); }

    public void presentQuestion() {
        exercise.deliverQuestion();
    }

    public boolean fillBlank(int bId, MiniJASTNode replacement) {
        if (!exercise.fillBlank(bId, replacement)) {
            // Report that the blank could not be filled
            System.err.println("There was no blank with that id!");
            return false;
        }
        return true;
    }

    public boolean submitAttempt() {
        attempts++;
        exercise.runSolution();
        if (exercise.checkSolved()) {
            // report succesful submission
            System.out.println("Correct submission in " + attempts + " attempts.");
            return true;
        }
        // report failed submission
        System.out.println("Incorrect submission.");
        return false;
    }

    public float reportPerformance() {
        // TODO improve
        // Negative means bad, positive means good
        float result = 2 - attempts;
        int difference = numNodes - exercise.numNodes();
        int multipler = difference < 0 ? -1 : 1;
        result += (difference * difference * multipler) / 10f;
        return result;
    }
}
