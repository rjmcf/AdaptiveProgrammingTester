package entryPoints;

import miniJAST.MiniJASTNode;
import miniJAST.exceptions.MiniJASTException;
import parser.JavaToMiniJava;
import questions.*;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class ExerciseSetter {
    JavaToMiniJava translator = new JavaToMiniJava();
    ArrayList<AbstractPExercise> possibleExs = new ArrayList<>();
    private int currentIndex = 0;
    AbstractPExercise exercise;
    private int attempts = 0;
    int numNodes;
    int nodesToRemove;
    OutputStream output;

    public ExerciseSetter(OutputStream o) {
        output = o;
        possibleExs.add(new SquareExercise(5));
        possibleExs.add(new FactorialExercise(6));
        possibleExs.add(new FillArrayToNExercise(10));
        setIndex(1);
    }

    public Difficulty getCurrentDifficulty() { return new Difficulty(exercise.getBaseDifficulty(), exercise.getNodesBlank()); }

    public void setOutput(OutputStream o) { output = o; }

    public void setCurrentDifficulty(Difficulty d) {
        if (d.base != currentIndex) {
            currentIndex = d.base;
            exercise = possibleExs.get(currentIndex);
        }
        exercise.setUp();
        numNodes = exercise.numNodes();
        for (int i = 0; i < d.nodesBlank; i++) {
            if (!exercise.addBlank()) {
                break;
            }
        }
    }

    public void setIndex(int i) {
        currentIndex = i;
        exercise = possibleExs.get(i);
        exercise.setUp();
        numNodes = exercise.numNodes();
        nodesToRemove = numNodes/2;
        setUp();
    }

    public int getIndex() { return currentIndex; }

    public int getAttempts() { return attempts; }

    public int getMinBaseDifficulty() { return 0; }
    public int getMaxBaseDifficulty() { return possibleExs.size() - 1; }
    public int getNumNodes() { return numNodes; }

    public void setUp() {
        // TODO remove repeated exercise.setUp()
        exercise.setUp();
        // TODO make sure this is ok
        if (nodesToRemove == 0)
            nodesToRemove = 2;
        exercise.makeHarder(nodesToRemove);
        attempts = 0;
        // TODO maybe remove repetition
        numNodes = exercise.numNodes();
    }

    public void presentQuestion() {
        OutputStreamWriter writer = new OutputStreamWriter(output);
        try {
            writer.write(exercise.deliverQuestion());
            writer.flush();
        } catch (IOException e) {
            System.err.println("stream error");
        }
    }

    public ArrayList<Integer> getBlankIds() {
        return exercise.getBlankIds();
    }

    public boolean fillBlank(int bId, String input) {
        return fillBlank(bId, translator.makeNode(input));
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
        OutputStreamWriter writer = new OutputStreamWriter(output);
        try {
            exercise.runSolution();
            if (exercise.checkSolved()) {
                // report succesful submission
                writer.write("Correct submission in " + attempts + " attempts.\n");
                writer.flush();
                return true;
            }
            // report failed submission
            writer.write("Incorrect submission.\n");
            writer.flush();
            return false;
        } catch (MiniJASTException mE) {
            // report failed submission
            try {
                writer.write("Incorrect submission.\n");
                writer.flush();
                return false;
            } catch (IOException e) {
                System.out.println("Stream error");
                return false;
            }
        } catch (IOException e) {
            System.out.println("Stream error");
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
