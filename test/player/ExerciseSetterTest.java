package player;

import miniJAST.expressions.Id;
import miniJAST.expressions.Literal;
import miniJAST.expressions.arithExpr.AddExpr;
import miniJAST.expressions.assignment.AssignExpr;
import miniJAST.expressions.assignment.AssignOp;
import miniJAST.expressions.assignment.UnaryPostIncExpr;
import miniJAST.expressions.assignment.UnaryPreIncExpr;
import miniJAST.expressions.boolExpr.RelationExpr;
import miniJAST.expressions.boolExpr.RelationOp;
import miniJAST.statements.LVD.LocalVarDec;
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
        nId.setUpIdSimple(UnannType.INT, "n");
        setter.fillBlank(blankIds.get(2), nId);
        Id totId = new Id();
        totId.setUpIdSimple(UnannType.INT, "total");
        setter.fillBlank(blankIds.get(4), totId);

        assertFalse(setter.submitAttempt());
        setter.fillBlank(blankIds.get(5), nId);

        assertTrue(setter.submitAttempt());
        assertEquals(setter.attempts, 3);
    }

    @Test
    public void testReportPerformance() throws Exception {

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
        nId.setUpIdSimple(UnannType.INT, "n");
        setter.fillBlank(blankIds.get(2), nId);
        Id totId = new Id();
        totId.setUpIdSimple(UnannType.INT, "total");
        setter.fillBlank(blankIds.get(4), totId);

        setter.submitAttempt();
        setter.fillBlank(blankIds.get(5), nId);

        assertTrue(setter.submitAttempt());
        assertEquals(setter.attempts, 2);

        assertTrue(setter.reportPerformance() > 0 && setter.reportPerformance() < 5);

        setter.setUp();
        assertFalse(setter.submitAttempt());
        setter.submitAttempt();

        blankIds = setter.getBlankIds();
        setter.fillBlank(blankIds.get(0), total);
        setter.fillBlank(blankIds.get(1), six);
        setter.fillBlank(blankIds.get(3), one);
        setter.fillBlank(blankIds.get(2), nId);
        setter.fillBlank(blankIds.get(4), totId);
        setter.fillBlank(blankIds.get(5), nId);

        assertTrue(setter.submitAttempt());
        assertEquals(setter.attempts, 3);

        assertTrue(setter.reportPerformance() < 0 && setter.reportPerformance() > -5);

        setter.setUp();
        setter.presentQuestion();
        assertFalse(setter.submitAttempt());

        AddExpr aE = new AddExpr();
        Literal zero = new Literal();
        zero.setUpLiteral(UnannType.INT, "0");
        aE.setUpAddExpr(true, zero, one);
        total.setUpVarDec("total", aE);

        Literal five = new Literal();
        five.setUpLiteral(UnannType.INT, "5");
        AddExpr aE2 = new AddExpr();
        aE2.setUpAddExpr(true, one, five);

        blankIds = setter.getBlankIds();
        setter.fillBlank(blankIds.get(0), total);
        setter.fillBlank(blankIds.get(1), aE2);
        setter.fillBlank(blankIds.get(3), one);
        setter.fillBlank(blankIds.get(2), nId);
        setter.fillBlank(blankIds.get(4), totId);
        setter.fillBlank(blankIds.get(5), nId);

        assertTrue(setter.submitAttempt());
        assertEquals(setter.attempts, 2);
        System.out.println(setter.reportPerformance());
        assertTrue(setter.reportPerformance() < 0 && setter.reportPerformance() > -5);
    }

    @Test
    public void testAdjustQuestion() throws Exception {
        float difficulty = setter.getCurrentDifficulty();

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
        nId.setUpIdSimple(UnannType.INT, "n");
        setter.fillBlank(blankIds.get(2), nId);
        Id totId = new Id();
        totId.setUpIdSimple(UnannType.INT, "total");
        setter.fillBlank(blankIds.get(4), totId);

        setter.submitAttempt();
        setter.fillBlank(blankIds.get(5), nId);

        assertTrue(setter.submitAttempt());
        assertEquals(setter.attempts, 2);

        assertTrue(setter.reportPerformance() > 0 && setter.reportPerformance() < 5);

        setter.adjustQuestion();
        assertTrue(setter.getCurrentDifficulty() > difficulty);
        difficulty = setter.getCurrentDifficulty();

        setter.presentQuestion();

        for (int i = 0; i < 5; i++)
            setter.submitAttempt();

        VarDeclarator n = new VarDeclarator();
        n.setUpVarDec("n", six);
        LocalVarDec lvd = new LocalVarDec();
        lvd.setUpLVD(UnannType.INT);
        lvd.addVarDec(total);
        lvd.addVarDec(n);

        RelationExpr gT = new RelationExpr();
        gT.setUpRelationExpr(RelationOp.GT, nId, one);

        UnaryPostIncExpr minus = new UnaryPostIncExpr();
        minus.setUpPostIncExpr(false, nId);

        AssignExpr times = new AssignExpr();
        times.setUpAssignExpr(totId, AssignOp.TIMESEQ, minus);

        blankIds = setter.getBlankIds();
        assertTrue(setter.fillBlank(blankIds.get(0), lvd));
        assertTrue(setter.fillBlank(blankIds.get(1), gT));
        assertTrue(setter.fillBlank(blankIds.get(2), times));
        assertTrue(setter.submitAttempt());

        assertTrue(setter.reportPerformance() < 0);
        System.out.println(setter.reportPerformance());

        setter.adjustQuestion();

        setter.presentQuestion();

        assertTrue(setter.getCurrentDifficulty() < difficulty);

    }
}