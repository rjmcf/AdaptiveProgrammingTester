import questions.FillArrayToNExercise;

public class Main {
    public static void main(String[] args) {
        FillArrayToNExercise e = new FillArrayToNExercise(10);
        e.setUp();
        System.out.println(e.printSolution());
        while(e.addBlank())
            System.out.println(e.printSolution());
    }
}