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
    int nodesToRemove;

    public void addExercise(AbstractPExercise e) { possibleExs.add(e); Collections.sort(possibleExs);}

    public AbstractPExercise getPossExercise(int i) { return possibleExs.get(i); }

    public float getCurrentDifficulty() { return exercise.getQuestionDifficulty(); }

    public void setInitialIndex(int i) {
        currentIndex = i;
        exercise = possibleExs.get(i);
        exercise.setUp();
        numNodes = exercise.numNodes();
        nodesToRemove = numNodes/2;
        setUp();
    }

    public void setUp() {
        exercise.setUp();
        if (nodesToRemove == 0)
            nodesToRemove = 2;
        exercise.makeHarder(nodesToRemove);
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
        try {
            if (!exercise.fillBlank(bId, replacement)) {
                // Report that the blank could not be filled
                System.err.println("There was no blank with that id!");
                return false;
            }
            return true;
        } catch (MiniJASTException e) {
            System.err.println("Blank with id " + bId + " cannot be filled with object of type " + replacement.getClass() + ".");
            return false;
        }
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
        exercise.setUp();
        exercise.makeHarder(nodesToRemove);
        nodesToRemove += determiner;
        if (determiner > 0) {
            determiner = exercise.makeHarder(determiner);
            while (determiner > 0) {
                currentIndex++;
                if (currentIndex >= possibleExs.size())
                    throw new ArrayIndexOutOfBoundsException("No more harder exercises!");
                exercise = possibleExs.get(currentIndex);
                exercise.setUp();
                nodesToRemove = determiner;
                determiner = exercise.makeHarder(determiner);
            }
        } else if (determiner < 0) {
            determiner *= -1;
            determiner = exercise.makeEasier(determiner);
            while (determiner > 0) {
                currentIndex--;
                if (currentIndex < 0)
                    throw new ArrayIndexOutOfBoundsException("No more easier exercises!");
                exercise = possibleExs.get(currentIndex);
                exercise.setUp();
                nodesToRemove = exercise.numNodes() - determiner;
                boolean cont = true;
                while (cont)
                    cont = exercise.addBlank();
                determiner = exercise.makeEasier(determiner);
            }
        }
        setUp();
    }

    public float reportPerformance() {
        // TODO improve
        // Negative means bad, positive means good
        float result = (2.5f - attempts) * 2;
        if (result < -10)
            result = -10;
        int difference = numNodes - exercise.numNodes();
        int multipler = difference < 0 ? -1 : 1;
        result += (difference * difference * multipler) / 10f;
        return result;
    }
}
