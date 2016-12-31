package player;

import questions.AbstractPExercise;

public class ExerciseSetter {
    AbstractPExercise exercise;

    public void presentQuestion() {
        exercise.deliverQuestion();
    }
}
