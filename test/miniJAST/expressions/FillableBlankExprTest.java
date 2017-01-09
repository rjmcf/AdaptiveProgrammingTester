package miniJAST.expressions;

import miniJAST.Context;
import miniJAST.exceptions.BlankEmptyException;
import miniJAST.expressions.arithExpr.AddExpr;
import miniJAST.expressions.arithExpr.MultExpr;
import miniJAST.expressions.arithExpr.UnaryPMExpr;
import miniJAST.expressions.arrays.ArrayAccess;
import miniJAST.expressions.assignment.AssignExpr;
import miniJAST.expressions.assignment.AssignOp;
import miniJAST.expressions.assignment.UnaryPostIncExpr;
import miniJAST.expressions.assignment.UnaryPreIncExpr;
import miniJAST.expressions.boolExpr.*;
import miniJAST.expressions.returnValues.*;
import miniJAST.statements.DoAndWhileLoops.DoStmnt;
import miniJAST.statements.DoAndWhileLoops.WhileStmnt;
import miniJAST.statements.DoAndWhileLoops.WhileStmntNoShortIf;
import miniJAST.statements.ExpressionStmnt;
import miniJAST.statements.ForLoops.ForInit;
import miniJAST.statements.ForLoops.ForStmnt;
import miniJAST.statements.ForLoops.ForStmntNoShortIf;
import miniJAST.statements.IfThenEtc.IfThenElseStmnt;
import miniJAST.statements.IfThenEtc.IfThenElseStmntNoShortIf;
import miniJAST.statements.IfThenEtc.IfThenStmnt;
import miniJAST.statements.LVD.LocalVarDec;
import miniJAST.statements.LVD.VarDeclarator;
import miniJAST.statements.PrintStatement;
import miniJAST.statements.SingleWordStmnt;
import miniJAST.statements.arrays.ArrayCreationWithInitList;
import miniJAST.statements.arrays.ArrayCreationWithSize;
import miniJAST.types.Type;
import miniJAST.types.UnannType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class FillableBlankExprTest {
    Context c;
    FillableBlankExpr fbe;
    Literal lit0, lit1, lit2, lit3, litT, litF;
    Id id;
    LocalVarDec lvd;
    PrintStatement testS;

    @BeforeMethod
    public void setUp() throws Exception {
        c = new Context();
        fbe = new FillableBlankExpr(0);
        lit0 = new Literal(); lit1 = new Literal();
        lit0.setUpLiteral(UnannType.INT, "0"); lit1.setUpLiteral(UnannType.INT, "1");
        lit2 = new Literal(); lit3 = new Literal();
        lit2.setUpLiteral(UnannType.INT, "2"); lit3.setUpLiteral(UnannType.INT, "3");
        litF = new Literal();
        litF.setUpLiteral(UnannType.BOOLEAN, "false");
        litT = new Literal();
        litT.setUpLiteral(UnannType.BOOLEAN, "true");
        id = new Id();
        id.setUpId(new Type(UnannType.INT, 2), "fakeArray");
        lvd = new LocalVarDec();
        testS = new PrintStatement();
        testS.setUpPrint(lit0);
    }

    @Test
    public void testEmptyEvaluateArith() throws Exception {
        AddExpr aE = new AddExpr();
        aE.setUpAddExpr(true, fbe, lit0);
        try {
            aE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
        aE.setUpAddExpr(false, lit0, fbe);
        try {
            aE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }

        MultExpr mE = new MultExpr();
        mE.setUpMultExpr(false, fbe, lit0);
        try {
            mE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
        mE.setUpMultExpr(true, lit0, fbe);
        try {
            mE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }

        UnaryPMExpr uE = new UnaryPMExpr();
        uE.setUpPMExpr(true, fbe);
        try {
            uE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
        uE.setUpPMExpr(false, fbe);
        try {
            uE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
    }

    @Test
    public void testEmptyEvaluateBool() throws Exception {
        AndExpr aE = new AndExpr();
        aE.setUpAndExpr(litF, fbe);
        try {
            aE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
        aE.setUpAndExpr(fbe, litT);
        try {
            aE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }

        CondExpr cE = new CondExpr();
        cE.setUpCondExpr(fbe, lit0, lit0);
        try {
            cE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
        cE.setUpCondExpr(litT, lit0, fbe);
        try {
            cE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
        cE.setUpCondExpr(litT, fbe, lit0);
        try {
            cE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
        cE.setUpCondExpr(litF, lit0, fbe);
        try {
            cE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
        cE.setUpCondExpr(litF, fbe, lit0);
        try {
            cE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }

        EqExpr eE = new EqExpr();
        eE.setUpEqExpr(true, fbe, lit0);
        try {
            eE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
        eE.setUpEqExpr(false, lit0, fbe);
        try {
            eE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }

        OrExpr oE = new OrExpr();
        oE.setUpOrExpr(litF, fbe);
        try {
            oE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
        oE.setUpOrExpr(fbe, litT);
        try {
            oE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }

        RelationExpr rE = new RelationExpr();
        rE.setUpRelationExpr(RelationOp.LT, fbe, lit0);
        try {
            rE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
        rE.setUpRelationExpr(RelationOp.GTE, lit0, fbe);
        try {
            rE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }

        UnaryComplementExpr ucE = new UnaryComplementExpr();
        ucE.setUpCompExpr(fbe);
        try {
            ucE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
    }

    @Test
    public void testEmptyEvaluateArray() throws Exception {
        c.namesToTypes.put("fakeArray", new Type(UnannType.INT, 2));
        c.namesToValues.put("fakeArray", new ArrayList<Integer>(2));
        ArrayAccess aaE = new ArrayAccess();
        aaE.setUpArrayAccess(id, fbe);
        try {
            aaE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
        aaE.setUpArrayAccess(fbe, lit0);
        try {
            aaE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
    }

    @Test
    public void testEmptyEvaluateAssign() throws Exception {
        AssignExpr aeE = new AssignExpr();
        aeE.setUpAssignExpr(fbe, AssignOp.EQ, lit0);
        try {
            aeE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
        aeE.setUpAssignExpr(id, AssignOp.EQ, fbe);
        try {
            aeE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }

        UnaryPostIncExpr upoIE = new UnaryPostIncExpr();
        upoIE.setUpPostIncExpr(true, fbe);
        try {
            upoIE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
        upoIE.setUpPostIncExpr(false, fbe);
        try {
            upoIE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }

        UnaryPreIncExpr uprIE = new UnaryPreIncExpr();
        uprIE.setUpPreIncExpr(true, fbe);
        try {
            uprIE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
        uprIE.setUpPreIncExpr(false, fbe);
        try {
            uprIE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
    }

    @Test
    public void testEmptyEvaluateBracketed() throws Exception {
        BracketedExpr bE = new BracketedExpr();
        bE.setUpBracketExpr(fbe);
        try {
            bE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
    }

    @Test
    public void testEmptyEvaluateArrayCreationList() throws Exception {
        ArrayCreationWithInitList acwil = new ArrayCreationWithInitList();
        acwil.setUPACWIL("fakeArray");
        acwil.addExpressionACWIL(lit0);
        acwil.addExpressionACWIL(fbe);
        lvd.setUpLVD(UnannType.INT);
        lvd.addVarDec(acwil);
        try {
            lvd.executeStart(c);
            fail("Blank not filled.");
        } catch (BlankEmptyException bee) {
            // pass test
        }
    }

    @Test
    public void testEmptyEvaluateArrayCreationSize() throws Exception {
        ArrayCreationWithSize acws = new ArrayCreationWithSize();
        acws.setUpACWS("fakeArray", UnannType.INT, fbe);
        lvd.setUpLVD(UnannType.INT);
        lvd.addVarDec(acws);
        try {
            lvd.executeStart(c);
            fail("Blank not filled.");
        } catch (BlankEmptyException bee) {
            // pass test
        }
    }

    @Test
    public void testEmptyEvaluateDo() throws Exception {
        DoStmnt dS = new DoStmnt();
        dS.setUpDo(testS, fbe);
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
        wS.setUpWhile(fbe, testS);
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
        wS.setUpWhileNSI(fbe, testS);
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
        fS.setUpForStmnt(null, fbe);
        fS.setBody(testS);
        try {
            fS.executeStart(c);
            fail("Blank not filled");
        } catch (BlankEmptyException bee){
            // pass test
        }

        ForInit fI = new ForInit();
        fI.addStmntExpr(fbe);
        fS = new ForStmnt();
        fS.setUpForStmnt(fI, null);
        try {
            fS.executeStart(c);
            fail("Blank not filled");
        } catch (BlankEmptyException bee){
            // pass test
        }

        fS = new ForStmnt();
        fS.setUpForStmnt(null, null);
        fS.addUpdate(fbe);
        fS.setBody(testS);
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
        fS.setUpForStmnt(null, fbe);
        fS.setBodyNSI(testS);
        try {
            fS.executeStart(c);
            fail("Blank not filled");
        } catch (BlankEmptyException bee){
            // pass test
        }

        ForInit fI = new ForInit();
        fI.addStmntExpr(fbe);
        fS = new ForStmntNoShortIf();
        fS.setUpForStmnt(fI, null);
        try {
            fS.executeStart(c);
            fail("Blank not filled");
        } catch (BlankEmptyException bee){
            // pass test
        }

        fS = new ForStmntNoShortIf();
        fS.setUpForStmnt(null, null);
        fS.addUpdate(fbe);
        fS.setBodyNSI(testS);
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
        iteS.setUpITE(fbe, testS, testS);
        try {
            iteS.executeStart(c);
            fail("Blank not filled");
        } catch (BlankEmptyException bee){
            // pass test
        }
    }

    @Test
    public void testEmptyEvaluateITENSI() throws Exception {
        IfThenElseStmntNoShortIf itensiS = new IfThenElseStmntNoShortIf();
        itensiS.setUpITENSI(fbe, testS, testS);
        try {
            itensiS.executeStart(c);
            fail("Blank not filled");
        } catch (BlankEmptyException bee){
            // pass test
        }
    }

    @Test
    public void testEmptyEvaluateIT() throws Exception {
        IfThenStmnt itS = new IfThenStmnt();
        itS.setUpIfThen(fbe, testS);
        try {
            itS.executeStart(c);
            fail("Blank not filled");
        } catch (BlankEmptyException bee){
            // pass test
        }
    }

    @Test
    public void testEmptyEvaluateLVD() throws Exception {
        VarDeclarator fakeId = new VarDeclarator();
        fakeId.setUpVarDec("fake", fbe);
        LocalVarDec lvd = new LocalVarDec();
        lvd.setUpLVD(UnannType.INT);
        lvd.addVarDec(fakeId);
        try {
            lvd.executeStart(c);
            fail("Blank not filled");
        } catch (BlankEmptyException bee){
            // pass test
        }
    }

    @Test
    public void testEmptyEvaluateExprStmnt() throws Exception {
        ExpressionStmnt eS = new ExpressionStmnt(fbe);
        try {
            eS.executeStart(c);
            fail("Blank not filled");
        } catch (BlankEmptyException bee){
            // pass test
        }
    }

    @Test
    public void testEmptyEvaluatePrStmnt() throws Exception {
        PrintStatement pS = new PrintStatement();
        pS.setUpPrint(fbe);
        try {
            pS.executeStart(c);
            fail("Blank not filled");
        } catch (BlankEmptyException bee){
            // pass test
        }
    }

    @Test
    public void testFilledEvaluateArith() throws Exception {
        AddExpr aE = new AddExpr();
        aE.setUpAddExpr(true, lit2, lit3);
        fbe.setStudentExpr(aE);
        assertEquals(((ReturnValuesInt)fbe.evaluate(c)).value, 5);
        assertEquals(fbe.stringRepr(), "2 + 3");

        aE.setUpAddExpr(false, lit3, lit2);
        assertEquals(((ReturnValuesInt)fbe.evaluate(c)).value, 1);
        assertEquals(fbe.stringRepr(), "3 - 2");

        MultExpr mE = new MultExpr();
        mE.setUpMultExpr(true, lit2, lit3);
        fbe.setStudentExpr(mE);
        assertEquals(((ReturnValuesInt)fbe.evaluate(c)).value, 6);
        assertEquals(fbe.stringRepr(), "2 * 3");

        mE.setUpMultExpr(false, lit3, lit2);
        assertEquals(((ReturnValuesInt)fbe.evaluate(c)).value, 1);
        assertEquals(fbe.stringRepr(), "3 / 2");

        UnaryPMExpr uE = new UnaryPMExpr();
        uE.setUpPMExpr(true, lit2);
        fbe.setStudentExpr(uE);
        assertEquals(((ReturnValuesInt)fbe.evaluate(c)).value, 2);
        assertEquals(fbe.stringRepr(), "+ 2");

        uE.setUpPMExpr(false, lit3);
        assertEquals(((ReturnValuesInt)fbe.evaluate(c)).value, -3);
        assertEquals(fbe.stringRepr(), "- 3");
    }

    @Test
    public void testFilledEvaluateArrayAccess() throws Exception {
        c.namesToTypes.put("ar", new Type(UnannType.INT, 2));
        ArrayList<Integer> vals = new ArrayList<>(2);
        vals.add(2);
        vals.add(3);
        c.namesToValues.put("ar", vals);

        Id ar = new Id();
        ar.setUpId(new Type(UnannType.INT, 2), "ar");
        ArrayAccess aa = new ArrayAccess();
        aa.setUpArrayAccess(ar, lit1);

        fbe.setStudentExpr(aa);
        assertEquals(((ReturnValuesInt)fbe.evaluate(c)).value, 3);
        assertEquals(fbe.stringRepr(), "ar[1]");
    }

    @Test
    public void testFilledEvaluateAssignment() throws Exception {
        c.namesToTypes.put("fakeInt", new Type(UnannType.INT, 1));

        Id fId = new Id();
        fId.setUpId(new Type(UnannType.INT, 1), "fakeInt");
        AssignExpr aE = new AssignExpr();
        aE.setUpAssignExpr(fId, AssignOp.EQ, lit1);
        fbe.setStudentExpr(aE);
        fbe.evaluate(c);
        assertEquals(((ReturnValuesInt)fId.evaluate(c)).value, 1);
        assertEquals(fbe.stringRepr(), "fakeInt = 1");

        aE.setUpAssignExpr(fId, AssignOp.PLUSEQ, lit1);
        fbe.evaluate(c);
        assertEquals(((ReturnValuesInt)fId.evaluate(c)).value, 2);
        assertEquals(fbe.stringRepr(), "fakeInt += 1");

        UnaryPostIncExpr upostE = new UnaryPostIncExpr();
        upostE.setUpPostIncExpr(true, fId);
        fbe.setStudentExpr(upostE);
        assertEquals(((ReturnValuesInt)fbe.evaluate(c)).value, 2);
        assertEquals(((ReturnValuesInt)fId.evaluate(c)).value, 3);
        assertEquals(fbe.stringRepr(), "fakeInt++");

        UnaryPreIncExpr upreE = new UnaryPreIncExpr();
        upreE.setUpPreIncExpr(true, fId);
        fbe.setStudentExpr(upreE);
        assertEquals(((ReturnValuesInt)fbe.evaluate(c)).value, 4);
        assertEquals(((ReturnValuesInt)fId.evaluate(c)).value, 4);
        assertEquals(fbe.stringRepr(), "++fakeInt");
    }

    @Test
    public void testFilledEvaluateBool() throws Exception {
        AndExpr aE = new AndExpr();
        aE.setUpAndExpr(litT, litF);
        fbe.setStudentExpr(aE);
        assertFalse(((ReturnValuesBool)fbe.evaluate(c)).value);
        assertEquals(fbe.stringRepr(), "true && false");

        EqExpr eE = new EqExpr();
        eE.setUpEqExpr(true, lit1, lit1);
        fbe.setStudentExpr(eE);
        assertTrue(((ReturnValuesBool)fbe.evaluate(c)).value);
        assertEquals(fbe.stringRepr(), "1 == 1");

        OrExpr oE = new OrExpr();
        oE.setUpOrExpr(litF, litF);
        fbe.setStudentExpr(oE);
        assertFalse(((ReturnValuesBool)fbe.evaluate(c)).value);
        assertEquals(fbe.stringRepr(), "false || false");

        RelationExpr rE = new RelationExpr();
        rE.setUpRelationExpr(RelationOp.GT, lit3, lit1);
        fbe.setStudentExpr(rE);
        assertTrue(((ReturnValuesBool)fbe.evaluate(c)).value);
        assertEquals(fbe.stringRepr(), "3 > 1");

        UnaryComplementExpr ucE = new UnaryComplementExpr();
        ucE.setUpCompExpr(litT);
        fbe.setStudentExpr(ucE);
        assertFalse(((ReturnValuesBool)fbe.evaluate(c)).value);
        assertEquals(fbe.stringRepr(), "!true");

        CondExpr cE = new CondExpr();
        cE.setUpCondExpr(litT, lit2, lit3);
        fbe.setStudentExpr(cE);
        assertEquals(((ReturnValuesInt)fbe.evaluate(c)).value, 2);
        assertEquals(fbe.stringRepr(), "true ? 2 : 3");
    }

    @Test
    public void testFilledEvaluateBracketed() throws Exception {
        BracketedExpr bE = new BracketedExpr();
        bE.setUpBracketExpr(lit2);
        fbe.setStudentExpr(bE);
        assertEquals(((ReturnValuesInt)fbe.evaluate(c)).value, 2);
        assertEquals(fbe.stringRepr(), "(2)");
    }

    @Test
    public void testFilledEvaluateId() throws Exception {
        c.namesToTypes.put("fakeId", new Type(UnannType.INT, 1));
        c.namesToValues.put("fakeId", 2);
        Id fakeId = new Id();
        fakeId.setUpId(new Type(UnannType.INT, 1), "fakeId");
        fbe.setStudentExpr(fakeId);
        assertEquals(((ReturnValuesInt)fbe.evaluate(c)).value, 2);
        assertEquals(fbe.stringRepr(), "fakeId");
    }

    @Test
    public void testFilledEvaluateLiteral() throws Exception {
        fbe.setStudentExpr(litT);
        assertTrue(((ReturnValuesBool)fbe.evaluate(c)).value);
        assertEquals(fbe.stringRepr(), "true");

        fbe.setStudentExpr(lit3);
        assertEquals(((ReturnValuesInt)fbe.evaluate(c)).value, 3);
        assertEquals(fbe.stringRepr(), "3");

        Literal half = new Literal();
        half.setUpLiteral(UnannType.DOUBLE, "0.5");
        fbe.setStudentExpr(half);
        assertEquals(((ReturnValuesDouble)fbe.evaluate(c)).value, 0.5);
        assertEquals(fbe.stringRepr(), "0.5");

        Literal a = new Literal();
        a.setUpLiteral(UnannType.CHAR, "a");
        fbe.setStudentExpr(a);
        assertEquals(((ReturnValuesChar)fbe.evaluate(c)).value, 'a');
        assertEquals(fbe.stringRepr(), "a");
    }

    @Test
    public void testFilledEvaluateArrayCreationList() throws Exception {
        FillableBlankExpr fbe1 = new FillableBlankExpr(1);
        ArrayCreationWithInitList acwil = new ArrayCreationWithInitList();
        acwil.setUPACWIL("fakeAr");
        fbe.setStudentExpr(lit1);
        fbe1.setStudentExpr(lit0);
        acwil.addExpressionACWIL(fbe);
        acwil.addExpressionACWIL(fbe1);

        lvd.setUpLVD(UnannType.INT);
        lvd.addVarDec(acwil);

        assertEquals(lvd.stringRepr(0), "int fakeAr[] = { 1, 0 };");
        lvd.executeStart(c);
        Id fakeAr = new Id();
        fakeAr.setUpId(new Type(UnannType.INT, 2), "fakeAr");
        ArrayAccess aa = new ArrayAccess();
        aa.setUpArrayAccess(fakeAr, lit1);
        assertEquals(((ReturnValuesIntAA)aa.evaluate(c)).value, 0);
    }

    @Test
    public void testFilledEvaluateArrayCreationSize() throws Exception {
    }

    @Test
    public void testFilledEvaluateDo() throws Exception {
    }

    @Test
    public void testFilledEvaluateWhile() throws Exception {
    }

    @Test
    public void testFilledEvaluateWhileNSI() throws Exception {
    }

    @Test
    public void testFilledEvaluateFor() throws Exception {
    }

    @Test
    public void testFilledEvaluateForNSI() throws Exception {
    }

    @Test
    public void testFilledEvaluateITE() throws Exception {
    }

    @Test
    public void testFilledEvaluateITENSI() throws Exception {
    }

    @Test
    public void testFilledEvaluateIT() throws Exception {
    }

    @Test
    public void testFilledEvaluateLVD() throws Exception {
    }

    @Test
    public void testFilledEvaluateExprStmnt() throws Exception {
    }

    @Test
    public void testFilledEvaluatePrStmnt() throws Exception {

    }
}