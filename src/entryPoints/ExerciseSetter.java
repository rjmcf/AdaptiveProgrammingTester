package entryPoints;

import miniJAST.MiniJASTNode;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.statements.Statement;
import parser.JavaToMiniJava;
import questions.*;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class ExerciseSetter {
    ArrayList<AbstractPExercise> possibleExs = new ArrayList<>();
    private static final int INITIAL_EX = 1;
    private int currentIndex;
    AbstractPExercise exercise;
    int attempts = 0;
    int numNodes;
    int nodesToRemove;
    Writer output;

    public ExerciseSetter(Writer o) {
        output = o;
        possibleExs.add(new SquareExercise());
        possibleExs.add(new FactorialExercise());
        possibleExs.add(new FillArrayToNExercise());
        setIndex(INITIAL_EX);
    }

    public Difficulty getCurrentDifficulty() { return new Difficulty(exercise.getBaseDifficulty(), exercise.getNodesBlank()); }

    public void reinitEx() {
        try {
            exercise = exercise.getClass().newInstance();

        } catch (IllegalAccessException iaE) {
            System.err.println("IllegalAccessException");
            iaE.printStackTrace();
        } catch (InstantiationException iE) {
            System.err.println("InstantiationException");
            iE.printStackTrace();
        }
    }

    public void setCurrentDifficulty(Difficulty d) {
        if (d.base != currentIndex) {
            currentIndex = d.base;
            exercise = possibleExs.get(currentIndex);
        }
        reinitEx();
        exercise.setUp();
        numNodes = exercise.numNodes();
        nodesToRemove = d.nodesBlank;
        for (int i = 0; i < nodesToRemove; i++) {
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

    public void resetAttempts() { attempts = 0; }

    public int getMinBaseDifficulty() { return 0; }
    public int getMaxBaseDifficulty() { return possibleExs.size() - 1; }
    public int getNumNodes() { return numNodes; }

    public void setUp() {
        // TODO remove repeated exercise.setUp()
        exercise.setUp();
        if (nodesToRemove == 0)
            nodesToRemove = 2;
        exercise.makeHarder(nodesToRemove);
        attempts = 0;
        // TODO maybe remove repetition
        numNodes = exercise.numNodes();
    }

    public void presentQuestion() {
        try {
            output.write(exercise.deliverQuestion());
            output.flush();
        } catch (IOException e) {
            System.err.println("stream error");
        }
    }

    public String getQuestion() {
        return exercise.getQuestion();
    }

    public String getSolution() {
        return exercise.printSolution();
    }

    public void setSolution(String s) {
        exercise.setSolution((Statement)JavaToMiniJava.makeAST(s));
    }

    public ArrayList<Integer> getBlankIds() {
        return exercise.getBlankIds();
    }

    public boolean fillBlank(int bId, String input) throws MiniJASTException {
        if (exercise.blankIsExpression(bId)) {
            return fillBlank(bId, JavaToMiniJava.makeExpr(input));
        } else {
            return fillBlank(bId, JavaToMiniJava.makeStmnt(input));
        }
    }

    public boolean fillBlank(int bId, MiniJASTNode replacement) throws MiniJASTException{
        if (!exercise.fillBlank(bId, replacement)) {
            // Report that the blank could not be filled
            System.err.println("There was no blank with that id!");
            return false;
        }
        return true;
    }

    public boolean emptyBlank(int bId) {
        if (!exercise.emptyBlank(bId)) {
            System.err.println("There was no blank with that id!");
            return false;
        }
        return true;
    }

    public boolean runSolution() throws MiniJASTException{
        try {
            exercise.runSolution();
            if (exercise.checkSolved()) {
                // report succesful submission
                output.write("Correct submission in " + attempts + " attempts.\n");
                output.flush();
                return true;
            }
            // report failed submission
            output.write("Incorrect submission.\n");
            output.flush();
            return false;
        } catch (IOException e) {
            System.out.println("Stream error");
            return false;
        }
    }

    public boolean submitAttempt() throws MiniJASTException{
        attempts++;
        return runSolution();
    }

    public void adjustQuestion(float performance) {
        int determiner = (int)performance;
        exercise.setUp();
        exercise.makeHarder(nodesToRemove);
        nodesToRemove += determiner;
        if (determiner > 0) {
            determiner = exercise.makeHarder(determiner);
            if (determiner > 0) {
                currentIndex++;
                if (currentIndex >= possibleExs.size())
                    throw new ArrayIndexOutOfBoundsException("No more harder exercises!");
                exercise = possibleExs.get(currentIndex);
                exercise.setUp();
                nodesToRemove = exercise.numNodes() * 3 / 4;
                exercise.makeHarder(nodesToRemove);
            }
        } else if (determiner < 0) {
            determiner *= -1;
            determiner = exercise.makeEasier(determiner);
            if (determiner > 0) {
                currentIndex--;
                if (currentIndex < 0)
                    throw new ArrayIndexOutOfBoundsException("No more easier exercises!");
                exercise = possibleExs.get(currentIndex);
                exercise.setUp();
                nodesToRemove = exercise.numNodes() * 3 / 4;
                exercise.makeEasier(nodesToRemove);
            }
        }
        setUp();
    }

    public float reportPerformance() {
        // Negative means bad, positive means good
        float result = (2.5f - attempts) * 2;
        int mult = result < 0 ? -1 : 1;
        result *= result * mult;
        int difference = numNodes - exercise.numNodes();
        difference = difference > 0 ? 0 : difference;
        result += difference;
        return result / 4f;
    }
}
