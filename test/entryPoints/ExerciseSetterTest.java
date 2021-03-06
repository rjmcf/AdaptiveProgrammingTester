package entryPoints;

import miniJAST.exceptions.BlankEmptyException;
import miniJAST.expressions.Id;
import miniJAST.expressions.Literal;
import miniJAST.expressions.arithExpr.AddExpr;
import miniJAST.expressions.assignment.AssignExpr;
import miniJAST.expressions.assignment.AssignOp;
import miniJAST.expressions.assignment.UnaryPostIncExpr;
import miniJAST.expressions.boolExpr.RelationExpr;
import miniJAST.expressions.boolExpr.RelationOp;
import miniJAST.statements.LVD.VarDeclarator;
import miniJAST.types.PrimType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import questions.Difficulty;
import questions.FactorialExercise;

import java.io.*;
import java.util.ArrayList;

import static org.testng.Assert.*;

public class ExerciseSetterTest {
    ExerciseSetter setter;

    @BeforeMethod
    public void setUp() throws Exception {
        FileWriter fw = new FileWriter("test/testOutput.txt", true);
        setter = new ExerciseSetter(fw);
    }

    @Test
    public void testSubmitAttempt() throws Exception {
        try {
            setter.submitAttempt();
            fail("No error thrown");
        } catch (BlankEmptyException be) {
            //pass
        }

        ArrayList<Integer> blankIds = setter.getBlankIds();

        Literal one = new Literal();
        one.setUpLiteral(PrimType.INT, "1");
        VarDeclarator total = new VarDeclarator();
        total.setUpVarDec("total", false, one);
        setter.fillBlank(blankIds.get(0), total);
        Literal N = new Literal();
        N.setUpLiteral(PrimType.INT, String.valueOf(((FactorialExercise)setter.exercise).getN_TEST()));
        setter.fillBlank(blankIds.get(1), N);
        setter.fillBlank(blankIds.get(3), one);
        Id nId = new Id();
        nId.setUpId("n");
        setter.fillBlank(blankIds.get(2), nId);
        Id totId = new Id();
        totId.setUpId("total");
        setter.fillBlank(blankIds.get(4), totId);

        try {
            setter.submitAttempt();
            fail("No error thrown");
        } catch (BlankEmptyException be) {
            //pass
        }
        setter.fillBlank(blankIds.get(5), nId);

        assertTrue(setter.submitAttempt());
        assertEquals(setter.getAttempts(), 3);
    }

    @Test
    public void testReportPerformance() throws Exception {
        ArrayList<Integer> blankIds = setter.getBlankIds();

        Literal one = new Literal();
        one.setUpLiteral(PrimType.INT, "1");
        VarDeclarator total = new VarDeclarator();
        total.setUpVarDec("total", false, one);
        setter.fillBlank(blankIds.get(0), total);
        Literal N = new Literal();
        N.setUpLiteral(PrimType.INT, String.valueOf(((FactorialExercise)setter.exercise).getN_TEST()));
        setter.fillBlank(blankIds.get(1), N);
        setter.fillBlank(blankIds.get(3), one);
        Id nId = new Id();
        nId.setUpId("n");
        setter.fillBlank(blankIds.get(2), nId);
        Id totId = new Id();
        totId.setUpId("total");
        setter.fillBlank(blankIds.get(4), totId);

        try {
            setter.submitAttempt();
            fail("No error thrown.");
        } catch (BlankEmptyException be) {
            //pass
        }
        setter.fillBlank(blankIds.get(5), nId);

        assertTrue(setter.submitAttempt());
        assertEquals(setter.getAttempts(), 2);

        assertTrue(setter.reportPerformance() > 0 && setter.reportPerformance() < 5);

        setter.setUp();
        try {
            setter.submitAttempt();
            fail("No error thrown");
        } catch (BlankEmptyException be) {
            //pass
        }
        // Artificially force attempts to be larger.
        try {
            setter.submitAttempt();
            fail("No error thrown");
        } catch (BlankEmptyException be) {
            //pass
        }

        blankIds = setter.getBlankIds();
        setter.fillBlank(blankIds.get(0), total);
        setter.fillBlank(blankIds.get(1), N);
        setter.fillBlank(blankIds.get(3), one);
        setter.fillBlank(blankIds.get(2), nId);
        setter.fillBlank(blankIds.get(4), totId);
        setter.fillBlank(blankIds.get(5), nId);

        assertTrue(setter.submitAttempt());
        assertEquals(setter.getAttempts(), 3);

        assertTrue(setter.reportPerformance() < 0 && setter.reportPerformance() > -5);

        setter.setUp();
        setter.presentQuestion();
        try {
            assertFalse(setter.submitAttempt());
            fail("No error thrown");
        } catch (BlankEmptyException bE) {
            //pass
        }

        AddExpr aE = new AddExpr();
        Literal zero = new Literal();
        zero.setUpLiteral(PrimType.INT, "0");
        aE.setUpAddExpr(true, zero, one);
        total.setUpVarDec("total", false, aE);

        AddExpr aE2 = new AddExpr();
        aE2.setUpAddExpr(true, zero, N);

        blankIds = setter.getBlankIds();
        setter.fillBlank(blankIds.get(0), total);
        setter.fillBlank(blankIds.get(1), aE2);
        setter.fillBlank(blankIds.get(2), nId);
        setter.fillBlank(blankIds.get(3), one);
        setter.fillBlank(blankIds.get(4), totId);
        setter.fillBlank(blankIds.get(5), nId);

        assertTrue(setter.submitAttempt());
        assertEquals(setter.getAttempts(), 2);
        assertTrue(setter.reportPerformance() < 2 && setter.reportPerformance() > -2);
    }

    @Test
    public void testAdjustQuestion() throws Exception {
        Difficulty diff = setter.getCurrentDifficulty();

        ArrayList<Integer> blankIds = setter.getBlankIds();

        setter.presentQuestion();

        Literal one = new Literal();
        one.setUpLiteral(PrimType.INT, "1");
        VarDeclarator total = new VarDeclarator();
        total.setUpVarDec("total", false, one);
        setter.fillBlank(blankIds.get(0), total);
        Literal n = new Literal();
        n.setUpLiteral(PrimType.INT, String.valueOf(((FactorialExercise)setter.exercise).getN_TEST()));
        setter.fillBlank(blankIds.get(1), n);
        setter.fillBlank(blankIds.get(3), one);
        Id nId = new Id();
        nId.setUpId("n");
        setter.fillBlank(blankIds.get(2), nId);
        Id totId = new Id();
        totId.setUpId("total");
        setter.fillBlank(blankIds.get(4), totId);

        try {
            setter.submitAttempt();
            fail("No error thrown");
        } catch (BlankEmptyException be) {
            //pass
        }
        setter.fillBlank(blankIds.get(5), nId);

        assertTrue(setter.submitAttempt());
        assertEquals(setter.getAttempts(), 2);

        assertTrue(setter.reportPerformance() > 0 && setter.reportPerformance() < 5);

        setter.adjustQuestion(setter.reportPerformance());
        assertTrue(setter.getCurrentDifficulty().nodesBlank > diff.nodesBlank);
        diff = setter.getCurrentDifficulty();

        for (int i = 0; i < 3; i++)
            try {
                assertFalse(setter.submitAttempt());
                fail("No error thrown");
            } catch (BlankEmptyException bE) {
                //pass
            }

        VarDeclarator nDec = new VarDeclarator();
        nDec.setUpVarDec("n", false, n);

        RelationExpr gT = new RelationExpr();
        gT.setUpRelationExpr(RelationOp.GT, nId, one);

        UnaryPostIncExpr minus = new UnaryPostIncExpr();
        minus.setUpPostIncExpr(false, nId);

        AssignExpr times = new AssignExpr();
        times.setUpAssignExpr(totId, AssignOp.TIMESEQ, minus);

        blankIds = setter.getBlankIds();
        assertTrue(setter.fillBlank(blankIds.get(0), total));
        assertTrue(setter.fillBlank(blankIds.get(1), nDec));
        assertTrue(setter.fillBlank(blankIds.get(2), nId));
        assertTrue(setter.fillBlank(blankIds.get(3), one));
        assertTrue(setter.fillBlank(blankIds.get(4), totId));
        assertTrue(setter.fillBlank(blankIds.get(5), nId));

        setter.presentQuestion();
        assertTrue(setter.submitAttempt());

        assertTrue(setter.reportPerformance() < 0);

        setter.adjustQuestion(setter.reportPerformance());

        setter.presentQuestion();

        assertTrue(setter.getCurrentDifficulty().nodesBlank < diff.nodesBlank ||
                setter.getCurrentDifficulty().base < diff.base);

    }
}