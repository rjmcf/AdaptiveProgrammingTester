package player;

import miniJAST.MiniJASTNode;
import miniJAST.exceptions.MiniJASTException;
import questions.AbstractPExercise;

import java.util.ArrayList;
import java.util.Collections;

public class ExerciseSetter {
    ArrayList<AbstractPExercise> possibleExs = new ArrayList<>();
    int currentIndex = 0;
    AbstractPExercise exercise;
    public int attempts = 0;
    int numNodes;

    public void addExercise(AbstractPExercise e) { possibleExs.add(e); Collections.sort(possibleExs);}

    public AbstractPExercise getPossExercise(int i) { return possibleExs.get(i); }

    public void setInitialIndex(int i) {
        currentIndex = i;
        exercise = possibleExs.get(i);
        setUp();
        exercise.makeHarder(numNodes/2);
    }

    public void setUp() {
        exercise.setUp();
        attempts = 0;
        numNodes = exercise.numNodes();
    }

    public void presentQuestion() {
        exercise.deliverQuestion();
    }

    public ArrayList<Integer> getBlankIds() {
        return exercise.getBlankIds();
    }

    public boolean fillBlank(int bId, MiniJASTNode replacement) {
        if (!exercise.fillBlank(bId, replacement)) {
            // Report that the blank could not be filled
            System.err.println("There was no blank with that id!");
            return false;
        }
        return true;
    }

    public boolean runSolution() {
        try {
            exercise.runSolution();
            if (exercise.checkSolved()) {
                // report succesful submission
                System.out.println("Correct submission in " + attempts + " attempts.");
                return true;
            }
            // report failed submission
            System.out.println("Incorrect submission.");
            return false;
        } catch (MiniJASTException mE) {
            // report failed submission
            System.out.println("Incorrect submission.");
            return false;
        }
    }

    public boolean submitAttempt() {
        attempts++;
        return runSolution();
    }

    public void adjustQuestion() {
        float performance = reportPerformance();
        int determiner = (int)(performance * 5f);
        if (determiner > 0) {
            determiner = exercise.makeHarder(determiner);
            if (determiner > 0) {
                currentIndex++;
                if (currentIndex >= possibleExs.size())
                    throw new ArrayIndexOutOfBoundsException("No more harder exercises!");
                exercise = possibleExs.get(currentIndex);
                setUp();
                exercise.makeHarder(determiner);
            }
        } else if (determiner < 0) {
            determiner *= -1;
            determiner = exercise.makeEasier(determiner);
            if (determiner > 0) {
                currentIndex--;
                if (currentIndex < 0)
                    throw new ArrayIndexOutOfBoundsException("No more easier exercises!");
                exercise = possibleExs.get(currentIndex);
                setUp();
                boolean cont = true;
                while (cont)
                    cont = exercise.addBlank();
                exercise.makeEasier(determiner);
            }
        }

        setUp();
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
