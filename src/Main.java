import questions.FactorialExercise;

public class Main {
    public static void main(String[] args) {
        // TODO test chars
        FactorialExercise fE = new FactorialExercise();
        fE.setUp();
        System.out.println(fE.printSolution());
        for (int i = 0; i < 7; i++) {
            fE.addBlank();
            System.out.println(fE.printSolution());
        }
    }
}