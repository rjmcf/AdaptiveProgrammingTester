package entryPoints;

import questions.Difficulty;

import java.io.FileWriter;
import java.io.IOException;

public class ExerciseSetterEvaluator {
    ExerciseSetter eS;

    public void evaluateDifficultyAdjustment() {
        float adjustment = 1;
        FileWriter fW;
        try {
            fW = new FileWriter("src/entryPoints/evaluationDiff.txt", false);
            eS = new ExerciseSetter(fW);
            eS.setCurrentDifficulty(new Difficulty(0,1)); //The lowest difficulty
            fW.write(String.format("%.3f", eS.getCurrentDifficulty().base + ((double)eS.getCurrentDifficulty().nodesBlank / eS.getNumExNodes())));
            while (true) {
                try {
                    eS.adjustQuestion(adjustment);
                } catch (ArrayIndexOutOfBoundsException aE) {
                    break;
                }
                fW.write(", " + String.format("%.3f", eS.getCurrentDifficulty().base + ((double)eS.getCurrentDifficulty().nodesBlank / eS.getNumExNodes())));
                fW.flush();
            }
            fW.write("\n");
            fW.flush();
        } catch (IOException iE) {
            System.err.println("File could not be opened.");
        }
    }

    public void evaluatePerformance() {
        boolean CSV = true;
        int nodesLess = 5;
        int nodesMore = 10;
        int minAttempts = 1;
        int maxAttempts = 5;
        FileWriter fW;
        try {
            fW = new FileWriter("src/entryPoints/evaluationPerf.txt", false);
            eS = new ExerciseSetter(fW);
            int exNodes = eS.exercise.numNodes();
            String topRow = "";
            for (int i = -nodesLess; i <= nodesMore; i++) {
                topRow += (CSV ? ",\t" : "\t\t") + i;
            }
            topRow += "\n";
            fW.write(topRow);
            fW.flush();

            String row;
            for (int r = minAttempts; r <= maxAttempts; r++) {
                row = String.valueOf(r);
                for (int c = -nodesLess; c <= nodesMore; c++) {
                    eS.attempts = r;
                    eS.numNodes = exNodes - c;
                    row += (CSV ? ",\t" : "\t") + String.format("%.2f",eS.reportPerformance());
                }
                row += "\n";
                fW.write(row);
                fW.flush();
            }


            fW.close();
        } catch (IOException iE) {
            System.err.println("File could not be opened.");
        }
    }

    public static void main(String[] args) {
        ExerciseSetterEvaluator eval = new ExerciseSetterEvaluator();
        eval.evaluateDifficultyAdjustment();
        //eval.evaluatePerformance();
    }
}
