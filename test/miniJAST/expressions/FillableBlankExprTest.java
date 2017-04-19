package miniJAST.expressions;

import miniJAST.Context;
import miniJAST.exceptions.BlankEmptyException;
import miniJAST.expressions.arithExpr.AddExpr;
import miniJAST.expressions.arithExpr.MultExpr;
import miniJAST.expressions.arithExpr.UnaryPMExpr;
import miniJAST.expressions.arrays.ArrayAccess;
import miniJAST.expressions.arrays.ArrayCreation;
import miniJAST.expressions.arrays.ArrayInit;
import miniJAST.expressions.assignment.AssignExpr;
import miniJAST.expressions.assignment.AssignOp;
import miniJAST.expressions.assignment.UnaryPostIncExpr;
import miniJAST.expressions.assignment.UnaryPreIncExpr;
import miniJAST.expressions.boolExpr.*;
import miniJAST.expressions.returnValues.*;
import miniJAST.statements.DoAndWhileLoops.DoStmnt;
import miniJAST.statements.DoAndWhileLoops.WhileStmnt;
import miniJAST.statements.ExpressionStmnt;
import miniJAST.statements.ForLoops.ForInit;
import miniJAST.statements.ForLoops.ForStmnt;
import miniJAST.statements.IfThenEtc.IfThenElseStmnt;
import miniJAST.statements.IfThenEtc.IfThenStmnt;
import miniJAST.statements.LVD.LocalVarDec;
import miniJAST.statements.LVD.VarDeclarator;
import miniJAST.statements.PrintStatement;
import miniJAST.types.Type;
import miniJAST.types.PrimType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
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
        lit0.setUpLiteral(PrimType.INT, "0"); lit1.setUpLiteral(PrimType.INT, "1");
        lit2 = new Literal(); lit3 = new Literal();
        lit2.setUpLiteral(PrimType.INT, "2"); lit3.setUpLiteral(PrimType.INT, "3");
        litF = new Literal();
        litF.setUpLiteral(PrimType.BOOLEAN, "false");
        litT = new Literal();
        litT.setUpLiteral(PrimType.BOOLEAN, "true");
        id = new Id();
        id.setUpId("fakeArray");
        lvd = new LocalVarDec();
        testS = new PrintStatement("test/testOutput.txt", true);
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
        c.namesToTypes.peek().put("fakeArray", new Type(PrimType.INT, true));
        c.namesToValues.peek().put("fakeArray", new ArrayList<Integer>(2));
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
        ArrayInit aI = new ArrayInit();
        aI.addExpression(lit0);
        aI.addExpression(fbe);
        VarDeclarator vD = new VarDeclarator();
        vD.setUpVarDec("fakeArray", true, aI);
        lvd.setUpLVD(PrimType.INT);
        lvd.addVarDec(vD);
        try {
            lvd.execute(c);
            fail("Blank not filled.");
        } catch (BlankEmptyException bee) {
            // pass test
        }
    }

    @Test
    public void testEmptyEvaluateArrayCreationSize() throws Exception {
        ArrayCreation aC = new ArrayCreation(PrimType.INT, fbe);
        VarDeclarator vD = new VarDeclarator();
        vD.setUpVarDec("fakeArray", true, aC);
        lvd.setUpLVD(PrimType.INT);
        lvd.addVarDec(vD);
        try {
            lvd.execute(c);
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
            dS.execute(c);
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
            wS.execute(c);
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
            fS.execute(c);
            fail("Blank not filled");
        } catch (BlankEmptyException bee){
            // pass test
        }

        ForInit fI = new ForInit();
        fI.addStmntExpr(fbe);
        fS = new ForStmnt();
        fS.setUpForStmnt(fI, null);
        try {
            fS.execute(c);
            fail("Blank not filled");
        } catch (BlankEmptyException bee){
            // pass test
        }

        fS = new ForStmnt();
        fS.setUpForStmnt(null, null);
        fS.addUpdate(fbe);
        fS.setBody(testS);
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
        iteS.setUpITE(fbe, testS, testS);
        try {
            iteS.execute(c);
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
            itS.execute(c);
            fail("Blank not filled");
        } catch (BlankEmptyException bee){
            // pass test
        }
    }

    @Test
    public void testEmptyEvaluateLVD() throws Exception {
        VarDeclarator fakeId = new VarDeclarator();
        fakeId.setUpVarDec("fake", false, fbe);
        LocalVarDec lvd = new LocalVarDec();
        lvd.setUpLVD(PrimType.INT);
        lvd.addVarDec(fakeId);
        try {
            lvd.execute(c);
            fail("Blank not filled");
        } catch (BlankEmptyException bee){
            // pass test
        }
    }

    @Test
    public void testEmptyEvaluateExprStmnt() throws Exception {
        ExpressionStmnt eS = new ExpressionStmnt(fbe);
        try {
            eS.execute(c);
            fail("Blank not filled");
        } catch (BlankEmptyException bee){
            // pass test
        }
    }

    @Test
    public void testEmptyEvaluatePrStmnt() throws Exception {
        PrintStatement pS = new PrintStatement("test/testOutput.txt", true);
        pS.setUpPrint(fbe);
        try {
            pS.execute(c);
            fail("Blank not filled");
        } catch (BlankEmptyException bee){
            // pass test
        }
    }

    @Test
    public void testEvaluateAsArith() throws Exception {
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
    public void testFilledArith() throws Exception {
        fbe.setStudentExpr(lit2);
        FillableBlankExpr fbe1 = new FillableBlankExpr(0);
        fbe1.setStudentExpr(lit3);

        AddExpr aE = new AddExpr();
        aE.setUpAddExpr(true, fbe, fbe1);
        assertEquals(((ReturnValuesInt)aE.evaluate(c)).value, 5);
        assertEquals(aE.stringRepr(), "2 + 3");

        MultExpr mE = new MultExpr();
        mE.setUpMultExpr(true, fbe, fbe1);
        assertEquals(((ReturnValuesInt)mE.evaluate(c)).value, 6);
        assertEquals(mE.stringRepr(), "2 * 3");

        UnaryPMExpr uE = new UnaryPMExpr();
        uE.setUpPMExpr(false, fbe);
        assertEquals(((ReturnValuesInt)uE.evaluate(c)).value, -2);
        assertEquals(uE.stringRepr(), "- 2");
    }

    @Test
    public void testEvaluateAsArrayAccess() throws Exception {
        c.namesToTypes.peek().put("ar", new Type(PrimType.INT, true));
        ArrayList<Integer> vals = new ArrayList<>(2);
        vals.add(2);
        vals.add(3);
        c.namesToValues.peek().put("ar", vals);

        Id ar = new Id();
        ar.setUpId("ar");
        ArrayAccess aa = new ArrayAccess();
        aa.setUpArrayAccess(ar, lit1);

        fbe.setStudentExpr(aa);
        assertEquals(((ReturnValuesInt)fbe.evaluate(c)).value, 3);
        assertEquals(fbe.stringRepr(), "ar[1]");
    }

    @Test
    public void testFilledArrayAcces() throws Exception {
        c.namesToTypes.peek().put("ar", new Type(PrimType.INT, true));
        ArrayList<Integer> array = new ArrayList<>();
        array.add(2); array.add(3);
        c.namesToValues.peek().put("ar", array);

        ArrayAccess aa = new ArrayAccess();
        Id ar = new Id();
        ar.setUpId("ar");
        fbe.setStudentExpr(ar);
        FillableBlankExpr fbe1 = new FillableBlankExpr(0);
        fbe1.setStudentExpr(lit1);
        aa.setUpArrayAccess(fbe, fbe1);
        assertEquals(((ReturnValuesInt)aa.evaluate(c)).value, 3);
        assertEquals(aa.stringRepr(), "ar[1]");
    }

    @Test
    public void testEvaluateAsAssignment() throws Exception {
        c.namesToTypes.peek().put("fakeInt", new Type(PrimType.INT, false));

        Id fId = new Id();
        fId.setUpId("fakeInt");
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
    public void testFilledAssignment() throws Exception {
        c.namesToTypes.peek().put("fakeInt", new Type(PrimType.INT, false));
        Id fId = new Id();
        fId.setUpId("fakeInt");
        fbe.setStudentExpr(fId);
        FillableBlankExpr fbe1 = new FillableBlankExpr(0);
        fbe1.setStudentExpr(lit3);

        AssignExpr aE = new AssignExpr();
        aE.setUpAssignExpr(fbe, AssignOp.EQ, fbe1);
        aE.evaluate(c);
        assertEquals(((ReturnValuesInt)fId.evaluate(c)).value, 3);
        assertEquals(aE.stringRepr(), "fakeInt = 3");

        aE.setUpAssignExpr(fbe, AssignOp.PLUSEQ, fbe1);
        aE.evaluate(c);
        assertEquals(((ReturnValuesInt)fId.evaluate(c)).value, 6);
        assertEquals(aE.stringRepr(), "fakeInt += 3");

        UnaryPostIncExpr uPostE = new UnaryPostIncExpr();
        uPostE.setUpPostIncExpr(true, fbe);
        assertEquals(((ReturnValuesInt)uPostE.evaluate(c)).value, 6);
        assertEquals(((ReturnValuesInt)fId.evaluate(c)).value, 7);
        assertEquals(uPostE.stringRepr(), "fakeInt++");

        UnaryPreIncExpr uPreE = new UnaryPreIncExpr();
        uPreE.setUpPreIncExpr(false, fbe);
        assertEquals(((ReturnValuesInt)uPreE.evaluate(c)).value, 6);
        assertEquals(((ReturnValuesInt)fId.evaluate(c)).value, 6);
        assertEquals(uPreE.stringRepr(), "--fakeInt");
    }

    @Test
    public void testEvaluateAsBool() throws Exception {
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
    public void testFilledBool() throws Exception {
        FillableBlankExpr fbe1 = new FillableBlankExpr(0);

        fbe.setStudentExpr(litT);
        fbe1.setStudentExpr(litF);

        AndExpr aE = new AndExpr();
        aE.setUpAndExpr(fbe, fbe1);
        assertFalse(((ReturnValuesBool)aE.evaluate(c)).value);
        assertEquals(aE.stringRepr(), "true && false");

        EqExpr eE = new EqExpr();
        fbe.setStudentExpr(lit1);
        eE.setUpEqExpr(true, fbe, fbe);
        assertTrue(((ReturnValuesBool)eE.evaluate(c)).value);
        assertEquals(eE.stringRepr(), "1 == 1");

        OrExpr oE = new OrExpr();
        oE.setUpOrExpr(fbe1, fbe1);
        assertFalse(((ReturnValuesBool)oE.evaluate(c)).value);
        assertEquals(oE.stringRepr(), "false || false");

        RelationExpr rE = new RelationExpr();
        fbe1.setStudentExpr(lit3);
        rE.setUpRelationExpr(RelationOp.GT, fbe1, fbe);
        assertTrue(((ReturnValuesBool)rE.evaluate(c)).value);
        assertEquals(rE.stringRepr(), "3 > 1");

        UnaryComplementExpr uCE = new UnaryComplementExpr();
        fbe.setStudentExpr(litT);
        uCE.setUpCompExpr(fbe);
        assertFalse(((ReturnValuesBool)uCE.evaluate(c)).value);
        assertEquals(uCE.stringRepr(), "!true");

        CondExpr cE = new CondExpr();
        FillableBlankExpr fbe2 = new FillableBlankExpr(0);
        fbe2.setStudentExpr(lit2);
        cE.setUpCondExpr(fbe, fbe2, fbe1);
        assertEquals(((ReturnValuesInt)cE.evaluate(c)).value, 2);
        assertEquals(cE.stringRepr(), "true ? 2 : 3");
    }

    @Test
    public void testEvaluateAsBracketed() throws Exception {
        BracketedExpr bE = new BracketedExpr();
        bE.setUpBracketExpr(lit2);
        fbe.setStudentExpr(bE);
        assertEquals(((ReturnValuesInt)fbe.evaluate(c)).value, 2);
        assertEquals(fbe.stringRepr(), "(2)");
    }

    @Test
    public void testFilledBracketed() throws Exception {
        BracketedExpr bE = new BracketedExpr();
        fbe.setStudentExpr(lit2);
        bE.setUpBracketExpr(fbe);
        assertEquals(((ReturnValuesInt)bE.evaluate(c)).value, 2);
        assertEquals(bE.stringRepr(), "(2)");
    }

    @Test
    public void testEvaluateAsId() throws Exception {
        c.namesToTypes.peek().put("fakeId", new Type(PrimType.INT, false));
        c.namesToValues.peek().put("fakeId", 2);
        Id fakeId = new Id();
        fakeId.setUpId("fakeId");
        fbe.setStudentExpr(fakeId);
        assertEquals(((ReturnValuesInt)fbe.evaluate(c)).value, 2);
        assertEquals(fbe.stringRepr(), "fakeId");
    }

    @Test
    public void testEvaluateAsLiteral() throws Exception {
        fbe.setStudentExpr(litT);
        assertTrue(((ReturnValuesBool)fbe.evaluate(c)).value);
        assertEquals(fbe.stringRepr(), "true");

        fbe.setStudentExpr(lit3);
        assertEquals(((ReturnValuesInt)fbe.evaluate(c)).value, 3);
        assertEquals(fbe.stringRepr(), "3");

        Literal half = new Literal();
        half.setUpLiteral(PrimType.DOUBLE, "0.5");
        fbe.setStudentExpr(half);
        assertEquals(((ReturnValuesDouble)fbe.evaluate(c)).value, 0.5);
        assertEquals(fbe.stringRepr(), "0.5");

        Literal a = new Literal();
        a.setUpLiteral(PrimType.CHAR, "a");
        fbe.setStudentExpr(a);
        assertEquals(((ReturnValuesChar)fbe.evaluate(c)).value, 'a');
        assertEquals(fbe.stringRepr(), "a");
    }

    @Test
    public void testFilledArrayCreationList() throws Exception {
        FillableBlankExpr fbe1 = new FillableBlankExpr(1);
        ArrayInit aC = new ArrayInit();
        fbe.setStudentExpr(lit1);
        fbe1.setStudentExpr(lit0);
        aC.addExpression(fbe);
        aC.addExpression(fbe1);
        VarDeclarator vD = new VarDeclarator();
        vD.setUpVarDec("fakeAr", true, aC);
        assertEquals(vD.stringRepr(0), "fakeAr[] = { 1, 0 }");

        lvd.setUpLVD(PrimType.INT);
        lvd.addVarDec(vD);

        assertEquals(lvd.stringRepr(0), "int fakeAr[] = { 1, 0 };");
        lvd.execute(c);
        Id fakeAr = new Id();
        fakeAr.setUpId("fakeAr");
        ArrayAccess aa = new ArrayAccess();
        aa.setUpArrayAccess(fakeAr, lit1);
        assertEquals(((ReturnValuesIntAA)aa.evaluate(c)).value, 0);
    }

    @Test
    public void testFilledArrayCreationSize() throws Exception {
        fbe.setStudentExpr(lit2);
        ArrayCreation aI = new ArrayCreation(PrimType.INT, fbe);
        VarDeclarator vD = new VarDeclarator();
        vD.setUpVarDec("fakeAr", true, aI);
        assertEquals(vD.stringRepr(0), "fakeAr[] = new int[2]");

        lvd.setUpLVD(PrimType.INT);
        lvd.addVarDec(vD);
        lvd.execute(c);

        Id fakeAr = new Id();
        fakeAr.setUpId("fakeAr");
        ArrayAccess aa = new ArrayAccess();
        aa.setUpArrayAccess(fakeAr, lit1);
        AssignExpr aE = new AssignExpr();
        aE.setUpAssignExpr(aa, AssignOp.EQ, lit2);
        aE.evaluate(c);
        assertEquals(((ReturnValuesInt)aa.evaluate(c)).value, 2);
    }

    @Test
    public void testFilledDo() throws Exception {
        c.namesToTypes.peek().put("cond", new Type(PrimType.BOOLEAN, false));
        c.namesToValues.peek().put("cond", false);
        c.namesToTypes.peek().put("i", new Type(PrimType.INT, false));
        c.namesToValues.peek().put("i", 1);
        Id condId = new Id(), i = new Id();
        condId.setUpId("cond");
        i.setUpId("i");
        UnaryPostIncExpr upiE = new UnaryPostIncExpr();
        upiE.setUpPostIncExpr(true, i);
        ExpressionStmnt eS = new ExpressionStmnt(upiE);
        fbe.setStudentExpr(condId);

        DoStmnt dS = new DoStmnt();
        dS.setUpDo(eS, fbe);
        assertEquals(dS.stringRepr(0), "do \n    i++; while (cond)");

        dS.execute(c);
        assertEquals(((ReturnValuesInt)i.evaluate(c)).value, 2);

    }

    @Test
    public void testFilledWhile() throws Exception {
        c.namesToTypes.peek().put("cond", new Type(PrimType.BOOLEAN, false));
        c.namesToValues.peek().put("cond", true);
        Id condId = new Id();
        condId.setUpId("cond");
        AssignExpr aE = new AssignExpr();
        aE.setUpAssignExpr(condId, AssignOp.EQ, litF);
        ExpressionStmnt eS = new ExpressionStmnt(aE);
        fbe.setStudentExpr(condId);

        WhileStmnt wS = new WhileStmnt();
        wS.setUpWhile(fbe, eS);
        assertEquals(wS.stringRepr(0), "while (cond) \n    cond = false;");
        wS.execute(c);
        assertFalse(((ReturnValuesBool)condId.evaluate(c)).value);
    }

    @Test
    public void testFilledFor() throws Exception {
        c.namesToTypes.peek().put("i", new Type(PrimType.INT, false));
        c.namesToTypes.peek().put("res", new Type(PrimType.INT, false));
        c.namesToValues.peek().put("res", 0);
        Id i = new Id();
        i.setUpId("i");
        AssignExpr init = new AssignExpr();
        init.setUpAssignExpr(i, AssignOp.EQ, lit0);
        fbe.setStudentExpr(init);
        ForInit fI = new ForInit();
        fI.addStmntExpr(fbe);

        RelationExpr rE = new RelationExpr();
        rE.setUpRelationExpr(RelationOp.LT, i, lit1);
        FillableBlankExpr fbe1 = new FillableBlankExpr(0);
        fbe1.setStudentExpr(rE);

        UnaryPostIncExpr upiE = new UnaryPostIncExpr();
        upiE.setUpPostIncExpr(true, i);
        FillableBlankExpr fbe2 = new FillableBlankExpr(0);
        fbe2.setStudentExpr(upiE);

        Id res = new Id();
        res.setUpId("res");
        AssignExpr aE = new AssignExpr();
        aE.setUpAssignExpr(res, AssignOp.PLUSEQ, lit3);
        ExpressionStmnt eS = new ExpressionStmnt(aE);

        ForStmnt fS = new ForStmnt();
        fS.setUpForStmnt(fI, fbe1);
        fS.addUpdate(fbe2);
        fS.setBody(eS);

        assertEquals(fS.stringRepr(0), "for (i = 0; i < 1; i++) \n    res += 3;");

        fS.execute(c);
        assertEquals(((ReturnValuesInt)res.evaluate(c)).value, 3);
    }

    @Test
    public void testFilledITE() throws Exception {
        c.namesToTypes.peek().put("res", new Type(PrimType.INT, false));

        fbe.setStudentExpr(litT);
        Id resId = new Id();
        resId.setUpId("res");
        AssignExpr ae1 = new AssignExpr();
        ae1.setUpAssignExpr(resId, AssignOp.EQ, lit2);
        ExpressionStmnt eS1 = new ExpressionStmnt(ae1);
        AssignExpr ae2 = new AssignExpr();
        ae2.setUpAssignExpr(resId, AssignOp.EQ, lit3);
        ExpressionStmnt eS2 = new ExpressionStmnt(ae2);

        IfThenElseStmnt ite = new IfThenElseStmnt();
        ite.setUpITE(fbe, eS1, eS2);
        assertEquals(ite.stringRepr(0), "if (true) \n    res = 2;\nelse \n    res = 3;");

        ite.execute(c);
        assertEquals(((ReturnValuesInt)resId.evaluate(c)).value, 2);
    }

    @Test
    public void testFilledIT() throws Exception {
        c.namesToTypes.peek().put("res", new Type(PrimType.INT, false));

        fbe.setStudentExpr(litT);
        Id resId = new Id();
        resId.setUpId("res");
        AssignExpr ae1 = new AssignExpr();
        ae1.setUpAssignExpr(resId, AssignOp.EQ, lit2);
        ExpressionStmnt eS1 = new ExpressionStmnt(ae1);

        IfThenStmnt ite = new IfThenStmnt();
        ite.setUpIfThen(fbe, eS1);
        assertEquals(ite.stringRepr(0), "if (true) \n    res = 2;");

        ite.execute(c);
        assertEquals(((ReturnValuesInt)resId.evaluate(c)).value, 2);
    }

    @Test
    public void testFilledLVD() throws Exception {
        fbe.setStudentExpr(lit2);
        VarDeclarator i = new VarDeclarator();
        i.setUpVarDec("i", false, fbe);

        lvd.setUpLVD(PrimType.INT);
        lvd.addVarDec(i);

        assertEquals(lvd.stringRepr(0), "int i = 2;");

        lvd.execute(c);

        Id iId = new Id();
        iId.setUpId("i");
        assertEquals(((ReturnValuesInt)iId.evaluate(c)).value, 2);
    }

    @Test
    public void testFilledExprStmnt() throws Exception {
        c.namesToTypes.peek().put("i", new Type(PrimType.INT, false));

        Id iId = new Id();
        iId.setUpId("i");
        AssignExpr aE = new AssignExpr();
        aE.setUpAssignExpr(iId, AssignOp.EQ, lit3);
        fbe.setStudentExpr(aE);
        ExpressionStmnt eS = new ExpressionStmnt(fbe);

        assertEquals(eS.stringRepr(0), "i = 3;");
        eS.execute(c);
        assertEquals(((ReturnValuesInt)iId.evaluate(c)).value, 3);
    }

    @Test
    public void testFilledPrStmnt() throws Exception {
        fbe.setStudentExpr(lit2);
        PrintStatement pS = new PrintStatement("test/testOutput.txt", true);
        pS.setUpPrint(fbe);
        assertEquals(pS.stringRepr(0), "System.out.println(2);");
        pS.execute(c);
    }
}