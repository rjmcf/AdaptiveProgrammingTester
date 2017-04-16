package miniJAST.statements;

import miniJAST.Context;
import miniJAST.exceptions.BlankEmptyException;
import miniJAST.expressions.Id;
import miniJAST.expressions.Literal;
import miniJAST.expressions.assignment.AssignExpr;
import miniJAST.expressions.assignment.AssignOp;
import miniJAST.expressions.returnValues.ReturnValuesInt;
import miniJAST.statements.DoAndWhileLoops.DoStmnt;
import miniJAST.statements.DoAndWhileLoops.WhileStmnt;
import miniJAST.statements.ForLoops.ForInit;
import miniJAST.statements.ForLoops.ForStmnt;
import miniJAST.statements.IfThenEtc.IfThenElseStmnt;
import miniJAST.statements.IfThenEtc.IfThenStmnt;
import miniJAST.statements.LVD.LocalVarDec;
import miniJAST.statements.LVD.VarDeclarator;
import miniJAST.types.Type;
import miniJAST.types.PrimType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileOutputStream;

import static org.testng.Assert.*;

public class FillableBlankStmntTest {
    Context c;
    FillableBlankStmnt fbs;
    Literal lit0, lit1, lit2, litF, litT;
    PrintStatement testS;

    @BeforeMethod
    public void setUp() throws Exception {
        c = new Context();
        fbs = new FillableBlankStmnt(0);
        lit0 = new Literal();
        lit0.setUpLiteral(PrimType.INT, "0");
        lit1 = new Literal();
        lit1.setUpLiteral(PrimType.INT, "1");
        lit2 = new Literal();
        lit2.setUpLiteral(PrimType.INT, "2");
        litT = new Literal();
        litT.setUpLiteral(PrimType.BOOLEAN, "true");
        litF = new Literal();
        litF.setUpLiteral(PrimType.BOOLEAN, "false");
        testS = new PrintStatement("test/testOutput.txt", true);
        testS.setUpPrint(lit0);
    }

    @Test
    public void testEmptyEvaluateDo() throws Exception {
        DoStmnt dS = new DoStmnt();
        dS.setUpDo(fbs, litT);
        try {
            dS.execute(c);
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
            wS.execute(c);
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
            fS.execute(c);
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
            iteS.execute(c);
            fail("Blank not filled");
        } catch (BlankEmptyException bee){
            // pass test
        }

        iteS.setUpITE(litF, testS, fbs);
        try {
            iteS.execute(c);
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
            iteS.execute(c);
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
            b.execute(c);
            fail("Blank not filled");
        } catch (BlankEmptyException bee){
            // pass test
        }
    }

    @Test
    public void testFilledDo() throws Exception {
        c.namesToTypes.peek().put("i", new Type(PrimType.INT));
        Id i = new Id();
        i.setUpId("i");
        AssignExpr aE = new AssignExpr();
        aE.setUpAssignExpr(i, AssignOp.EQ, lit1);
        ExpressionStmnt eS = new ExpressionStmnt(aE);
        fbs.setStudentStmnt(eS);

        DoStmnt dS = new DoStmnt();
        dS.setUpDo(fbs, litF);
        dS.execute(c);

        assertEquals(((ReturnValuesInt)i.evaluate(c)).value, 1);
        assertEquals(dS.stringRepr(0), "do \n    i = 1; while (false)");
    }

    @Test
    public void testFilledWhile() throws Exception {
        c.namesToTypes.peek().put("i", new Type(PrimType.INT));
        c.namesToTypes.peek().put("cond", new Type(PrimType.BOOLEAN));
        c.namesToValues.peek().put("cond", true);
        Id i = new Id(), cond = new Id();
        i.setUpId("i");
        cond.setUpId("cond");
        AssignExpr aE1 = new AssignExpr();
        aE1.setUpAssignExpr(i, AssignOp.EQ, lit1);
        ExpressionStmnt eS1 = new ExpressionStmnt(aE1);
        AssignExpr aE2 = new AssignExpr();
        aE2.setUpAssignExpr(cond, AssignOp.EQ, litF);
        ExpressionStmnt eS2 = new ExpressionStmnt(aE2);
        Block b = new Block(false);
        b.addBlockStmnt(eS1);
        b.addBlockStmnt(eS2);

        fbs.setStudentStmnt(b);

        WhileStmnt wS = new WhileStmnt();
        wS.setUpWhile(cond, fbs);

        wS.execute(c);

        assertEquals(((ReturnValuesInt)i.evaluate(c)).value, 1);
        assertEquals(wS.stringRepr(0), "while (cond) \n{\n    i = 1;\n    cond = false;\n}");
    }

    @Test
    public void testFilledFor() throws Exception {
        VarDeclarator iDec = new VarDeclarator();
        iDec.setUpVarDec("i", false, lit0);
        LocalVarDec lvd = new LocalVarDec();
        lvd.setUpLVD(PrimType.INT);
        lvd.addVarDec(iDec);
        ForInit fI = new ForInit();
        fI.setLocalVarDec(lvd);
        fbs.setStudentStmnt(fI);

        FillableBlankStmnt fbs1 = new FillableBlankStmnt(0);
        fbs1.setStudentStmnt(SingleWordStmnt.BREAK);

        ForStmnt fS = new ForStmnt();
        fS.setUpForStmnt(fbs, litT);
        fS.setBody(fbs1);

        fS.execute(c);
        assertEquals(fS.stringRepr(0), "for (int i = 0; true; ) \n    break;");
    }

    @Test
    public void testFilledITE() throws Exception {
        c.namesToTypes.peek().put("i", new Type(PrimType.INT));
        Id iId = new Id();
        iId.setUpId("i");

        AssignExpr aE1 = new AssignExpr();
        aE1.setUpAssignExpr(iId, AssignOp.EQ, lit1);
        ExpressionStmnt eS1 = new ExpressionStmnt(aE1);
        fbs.setStudentStmnt(eS1);
        AssignExpr aE2 = new AssignExpr();
        aE2.setUpAssignExpr(iId, AssignOp.EQ, lit2);
        ExpressionStmnt eS2 = new ExpressionStmnt(aE2);
        FillableBlankStmnt fbs1 = new FillableBlankStmnt(0);
        fbs1.setStudentStmnt(eS2);

        IfThenElseStmnt ite = new IfThenElseStmnt();
        ite.setUpITE(litT, fbs, fbs1);
        ite.execute(c);

        assertEquals(((ReturnValuesInt)iId.evaluate(c)).value, 1);
        assertEquals(ite.stringRepr(0), "if (true) \n    i = 1;\nelse \n    i = 2;");

        ite.setUpITE(litF, fbs, fbs1);
        ite.execute(c);

        assertEquals(((ReturnValuesInt)iId.evaluate(c)).value, 2);
    }

    @Test
    public void testFilledIT() throws Exception {
        c.namesToTypes.peek().put("i", new Type(PrimType.INT));
        Id iId = new Id();
        iId.setUpId("i");

        AssignExpr aE1 = new AssignExpr();
        aE1.setUpAssignExpr(iId, AssignOp.EQ, lit1);
        ExpressionStmnt eS1 = new ExpressionStmnt(aE1);
        fbs.setStudentStmnt(eS1);

        IfThenStmnt ite = new IfThenStmnt();
        ite.setUpIfThen(litT, fbs);
        ite.execute(c);

        assertEquals(((ReturnValuesInt)iId.evaluate(c)).value, 1);
        assertEquals(ite.stringRepr(0), "if (true) \n    i = 1;");
    }

    @Test
    public void testFilledBlock() throws Exception {
        VarDeclarator v = new VarDeclarator();
        v.setUpVarDec("i", false, lit0);
        LocalVarDec lvd = new LocalVarDec();
        lvd.setUpLVD(PrimType.INT);
        lvd.addVarDec(v);
        fbs.setStudentStmnt(lvd);

        Id iId = new Id();
        iId.setUpId("i");
        AssignExpr aE = new AssignExpr();
        aE.setUpAssignExpr(iId, AssignOp.PLUSEQ, lit2);
        ExpressionStmnt eS = new ExpressionStmnt(aE);
        FillableBlankStmnt fbs1 = new FillableBlankStmnt(0);
        fbs1.setStudentStmnt(eS);

        Block b = new Block(true);
        b.addBlockStmnt(fbs);
        b.addBlockStmnt(fbs1);

        b.execute(c);
        assertEquals(((ReturnValuesInt)iId.evaluate(c)).value, 2);
        assertEquals(b.stringRepr(1), "{\n    int i = 0;\n    i += 2;\n}");
    }

    @Test
    public void testFilledLVD() throws Exception {
        VarDeclarator v = new VarDeclarator();
        v.setUpVarDec("i", false, lit1);
        fbs.setStudentStmnt(v);
        LocalVarDec lvd = new LocalVarDec();
        lvd.setUpLVD(PrimType.INT);
        lvd.addVarDec(fbs);

        lvd.execute(c);
        Id iId = new Id();
        iId.setUpId("i");
        assertEquals(((ReturnValuesInt)iId.evaluate(c)).value, 1);
        assertEquals(lvd.stringRepr(0), "int i = 1;");
    }
}