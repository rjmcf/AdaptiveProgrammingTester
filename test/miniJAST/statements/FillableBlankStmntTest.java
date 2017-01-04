package miniJAST.statements;

import miniJAST.Context;
import miniJAST.exceptions.BlankEmptyException;
import miniJAST.expressions.Literal;
import miniJAST.statements.DoAndWhileLoops.DoStmnt;
import miniJAST.statements.DoAndWhileLoops.WhileStmnt;
import miniJAST.statements.DoAndWhileLoops.WhileStmntNoShortIf;
import miniJAST.statements.ForLoops.ForInit;
import miniJAST.statements.ForLoops.ForStmnt;
import miniJAST.statements.ForLoops.ForStmntNoShortIf;
import miniJAST.statements.IfThenEtc.IfThenElseStmnt;
import miniJAST.statements.IfThenEtc.IfThenElseStmntNoShortIf;
import miniJAST.statements.IfThenEtc.IfThenStmnt;
import miniJAST.types.UnannType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FillableBlankStmntTest {
    Context c;
    FillableBlankStmnt fbs;
    Literal lit0, litF, litT;
    PrintStatement testS;

    @BeforeMethod
    public void setUp() throws Exception {
        c = new Context();
        fbs = new FillableBlankStmnt();
        lit0 = new Literal();
        lit0.setUpLiteral(UnannType.INT, "0");
        litT = new Literal();
        litT.setUpLiteral(UnannType.BOOLEAN, "true");
        litF = new Literal();
        litF.setUpLiteral(UnannType.BOOLEAN, "false");
        testS = new PrintStatement();
        testS.setUpPrint(lit0);
    }

    @Test
    public void testEmptyEvaluateDo() throws Exception {
        DoStmnt dS = new DoStmnt();
        dS.setUpDo(fbs, litT);
        try {
            dS.executeStart(c);
            fail("Blank not filled");
        } catch (BlankEmptyException bee){
            // pass test
        }
    }

    @Test
    public void testEmptyEvaluateWhile() throws Exception {
        WhileStmnt wS = new WhileStmnt();
        wS.setUpWhile(litT, fbs);
        try {
            wS.executeStart(c);
            fail("Blank not filled");
        } catch (BlankEmptyException bee){
            // pass test
        }
    }

    @Test
    public void testEmptyEvaluateWhileNSI() throws Exception {
        WhileStmntNoShortIf wS = new WhileStmntNoShortIf();
        wS.setUpWhileNSI(litT, fbs);
        try {
            wS.executeStart(c);
            fail("Blank not filled");
        } catch (BlankEmptyException bee){
            // pass test
        }
    }

    @Test
    public void testEmptyEvaluateFor() throws Exception {
        ForStmnt fS = new ForStmnt();
        fS.setUpForStmnt(null, litT);
        fS.setBody(fbs);
        try {
            fS.executeStart(c);
            fail("Blank not filled");
        } catch (BlankEmptyException bee){
            // pass test
        }
    }

    @Test
    public void testEmptyEvaluateForNSI() throws Exception {
        ForStmntNoShortIf fS = new ForStmntNoShortIf();
        fS.setUpForStmnt(null, litT);
        fS.setBodyNSI(fbs);
        try {
            fS.executeStart(c);
            fail("Blank not filled");
        } catch (BlankEmptyException bee){
            // pass test
        }
    }

    @Test
    public void testEmptyEvaluateITE() throws Exception {
        IfThenElseStmnt iteS = new IfThenElseStmnt();
        iteS.setUpITE(litT, fbs, testS);
        try {
            iteS.executeStart(c);
            fail("Blank not filled");
        } catch (BlankEmptyException bee){
            // pass test
        }

        iteS.setUpITE(litF, testS, fbs);
        try {
            iteS.executeStart(c);
            fail("Blank not filled");
        } catch (BlankEmptyException bee){
            // pass test
        }
    }

    @Test
    public void testEmptyEvaluateITENSI() throws Exception {
        IfThenElseStmntNoShortIf iteS = new IfThenElseStmntNoShortIf();
        iteS.setUpITENSI(litT, fbs, testS);
        try {
            iteS.executeStart(c);
            fail("Blank not filled");
        } catch (BlankEmptyException bee){
            // pass test
        }

        iteS.setUpITENSI(litF, testS, fbs);
        try {
            iteS.executeStart(c);
            fail("Blank not filled");
        } catch (BlankEmptyException bee){
            // pass test
        }
    }

    @Test
    public void testEmptyEvaluateIT() throws Exception {
        IfThenStmnt iteS = new IfThenStmnt();
        iteS.setUpIfThen(litT, fbs);
        try {
            iteS.executeStart(c);
            fail("Blank not filled");
        } catch (BlankEmptyException bee){
            // pass test
        }
    }

    @Test
    public void testEmptyEvaluateBlock() throws Exception {
        Block b = new Block(true);
        b.addBlockStmnt(fbs);
        try {
            b.executeStart(c);
            fail("Blank not filled");
        } catch (BlankEmptyException bee){
            // pass test
        }
    }

    // TODO test when statment filled
}