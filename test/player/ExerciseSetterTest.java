package player;

import miniJAST.expressions.Id;
import miniJAST.expressions.Literal;
import miniJAST.statements.LVD.VarDeclarator;
import miniJAST.types.Type;
import miniJAST.types.UnannType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import questions.FactorialExercise;
import questions.FillArrayToNExercise;
import questions.SquareExercise;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class ExerciseSetterTest {
    ExerciseSetter setter;
    SquareExercise sE;
    FactorialExercise fE;
    FillArrayToNExercise aE;

    @BeforeMethod
    public void setUp() throws Exception {
        setter = new ExerciseSetter();
        sE = new SquareExercise(5);
        fE = new FactorialExercise(6);
        aE = new FillArrayToNExercise(10);
        setter.addExercise(sE);
        setter.addExercise(fE);
        setter.addExercise(aE);
        setter.setInitialIndex(1);
    }

    @Test
    public void testAddExercise() throws Exception {
        setter = new ExerciseSetter();
        setter.addExercise(fE);
        assertTrue(setter.getPossExercise(0) instanceof FactorialExercise);

        setter.addExercise(aE);
        assertTrue(setter.getPossExercise(0) instanceof FactorialExercise);
        assertTrue(setter.getPossExercise(1) instanceof FillArrayToNExercise);

        setter.addExercise(sE);
        assertTrue(setter.getPossExercise(0) instanceof SquareExercise);
        assertTrue(setter.getPossExercise(1) instanceof FactorialExercise);
        assertTrue(setter.getPossExercise(2) instanceof FillArrayToNExercise);
    }

    @Test
    public void testSubmitAttempt() throws Exception {
        assertFalse(setter.submitAttempt());
        setter.presentQuestion();

        ArrayList<Integer> blankIds = setter.getBlankIds();

        Literal one = new Literal();
        one.setUpLiteral(UnannType.INT, "1");
        VarDeclarator total = new VarDeclarator();
        total.setUpVarDec("total", one);
        setter.fillBlank(blankIds.get(0), total);
        Literal six = new Literal();
        six.setUpLiteral(UnannType.INT, "6");
        setter.fillBlank(blankIds.get(1), six);
        setter.fillBlank(blankIds.get(3), one);
        Id nId = new Id();
        nId.setUpId(new Type(UnannType.INT, 1), "n");
        setter.fillBlank(blankIds.get(2), nId);
        Id totId = new Id();
        totId.setUpId(new Type(UnannType.INT, 1), "total");
        setter.fillBlank(blankIds.get(4), totId);

        assertFalse(setter.submitAttempt());
        setter.fillBlank(blankIds.get(5), nId);
        setter.presentQuestion();

        assertTrue(setter.submitAttempt());
        assertEquals(setter.attempts, 3);
    }

    @Test
    public void testAdjustQuestion() throws Exception {
        fail("Not implemented yet");
    }

    @Test
    public void testReportPerformance() throws Exception {
        fail("Not implemented yet");
    }
}