import questions.FillArrayToNExercise;

public class Main {

    public static void main(String[] args) {
        FillArrayToNExercise test = new FillArrayToNExercise(10);
        test.setUp();
        test.runSolution();
        System.out.println(test.checkSolved());
    }
}