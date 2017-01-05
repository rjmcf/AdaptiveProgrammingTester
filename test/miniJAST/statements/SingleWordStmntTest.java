package miniJAST.statements;

import miniJAST.Context;
import miniJAST.expressions.Id;
import miniJAST.expressions.Literal;
import miniJAST.expressions.arithExpr.AddExpr;
import miniJAST.expressions.arrays.ArrayAccess;
import miniJAST.expressions.assignment.AssignExpr;
import miniJAST.expressions.assignment.AssignOp;
import miniJAST.expressions.assignment.UnaryPostIncExpr;
import miniJAST.expressions.boolExpr.CondExpr;
import miniJAST.expressions.boolExpr.EqExpr;
import miniJAST.expressions.boolExpr.RelationExpr;
import miniJAST.expressions.boolExpr.RelationOp;
import miniJAST.expressions.returnValues.ReturnValuesArray;
import miniJAST.statements.ForLoops.ForInit;
import miniJAST.statements.ForLoops.ForStmnt;
import miniJAST.statements.IfThenEtc.IfThenStmnt;
import miniJAST.statements.LVD.LocalVarDec;
import miniJAST.statements.LVD.VarDeclarator;
import miniJAST.statements.arrays.ArrayCreationWithInitList;
import miniJAST.statements.arrays.ArrayCreationWithSize;
import miniJAST.types.Type;
import miniJAST.types.UnannType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SingleWordStmntTest {
    Context c;
    Literal H, e, l, o, exc, ques, six, zero, nine, two, seven, three, one;
    ArrayCreationWithInitList orig;
    ArrayCreationWithSize result;
    VarDeclarator i, j;
    ForInit init2;
    ForStmnt forStmnt1, forStmnt2;
    LocalVarDec arrays, iDec, jDec;
    Id iID, origID, resultID, jID;
    RelationExpr lT9, lT3, lT1;
    EqExpr eq2, eq7;
    UnaryPostIncExpr iPlus, jPlus;
    IfThenStmnt contIf, breakIf;
    ArrayAccess resAcc, origAcc, fakeAcc;
    CondExpr which;
    AddExpr minus;
    AssignExpr r6, indexAssign;
    Block outer, inner;

    @BeforeMethod
    public void setUp() throws Exception {
        c = new Context();

        H = new Literal();
        H.setUpLiteral(UnannType.CHAR, "H");
        e = new Literal();
        e.setUpLiteral(UnannType.CHAR, "e");
        l = new Literal();
        l.setUpLiteral(UnannType.CHAR, "l");
        o = new Literal();
        o.setUpLiteral(UnannType.CHAR, "o");
        exc = new Literal();
        exc.setUpLiteral(UnannType.CHAR, "!");
        six = new Literal();
        six.setUpLiteral(UnannType.INT, "6");
        orig = new ArrayCreationWithInitList();
        orig.setUPACWIL("orig");
        Literal[] letters = new Literal[] {H, e, l, l, l, o, exc, exc, exc};
        for (Literal l : letters)
            orig.addExpressionACWIL(l);
        result = new ArrayCreationWithSize();
        result.setUpACWS("result", six);
        arrays = new LocalVarDec();
        arrays.setUpLVD(UnannType.CHAR);
        arrays.addVarDec(orig);
        arrays.addVarDec(result);

        zero = new Literal();
        zero.setUpLiteral(UnannType.INT, "0");
        i = new VarDeclarator();
        i.setUpVarDec("i", zero);
        iDec = new LocalVarDec();
        iDec.setUpLVD(UnannType.INT);
        iDec.addVarDec(i);

        iID = new Id();
        iID.setUpId(new Type(UnannType.INT, 1), "i");
        two = new Literal();
        two.setUpLiteral(UnannType.INT, "2");
        eq2 = new EqExpr();
        eq2.setUpEqExpr(true, iID, two);
        contIf = new IfThenStmnt();
        contIf.setUpIfThen(eq2, SingleWordStmnt.CONTINUE);

        seven = new Literal();
        seven.setUpLiteral(UnannType.INT, "7");
        eq7 = new EqExpr();
        eq7.setUpEqExpr(true, iID, seven);
        breakIf = new IfThenStmnt();
        breakIf.setUpIfThen(eq7, SingleWordStmnt.BREAK);

        three = new Literal();
        three.setUpLiteral(UnannType.INT, "3");
        lT3 = new RelationExpr();
        lT3.setUpRelationExpr(RelationOp.LT, iID, three);
        one = new Literal();
        one.setUpLiteral(UnannType.INT, "1");
        minus = new AddExpr();
        minus.setUpAddExpr(false, iID, one);
        which = new CondExpr();
        which.setUpCondExpr(lT3, iID, minus);
        resultID = new Id();
        resultID.setUpId(new Type(UnannType.CHAR, 6), "result");
        resAcc = new ArrayAccess();
        resAcc.setUpArrayAccess(resultID, which);
        origID = new Id();
        origID.setUpId(new Type(UnannType.CHAR, 9), "orig");
        origAcc = new ArrayAccess();
        origAcc.setUpArrayAccess(origID, iID);
        indexAssign = new AssignExpr();
        indexAssign.setUpAssignExpr(resAcc, AssignOp.EQ, origAcc);

        nine = new Literal();
        nine.setUpLiteral(UnannType.INT, "9");
        lT9 = new RelationExpr();
        lT9.setUpRelationExpr(RelationOp.LT, iID, nine);
        iPlus = new UnaryPostIncExpr();
        iPlus.setUpPostIncExpr(true, iID);
        ExpressionStmnt eS1 = new ExpressionStmnt(indexAssign);
        inner = new Block(false);
        inner.addBlockStmnt(contIf);
        inner.addBlockStmnt(breakIf);
        inner.addBlockStmnt(eS1);
        forStmnt1 = new ForStmnt();
        forStmnt1.setUpForStmnt(null, lT9);
        forStmnt1.addUpdate(iPlus);
        forStmnt1.setBody(inner);

        ques = new Literal();
        ques.setUpLiteral(UnannType.CHAR, "?");
        fakeAcc = new ArrayAccess();
        fakeAcc.setUpArrayAccess(resultID, six);
        r6 = new AssignExpr();
        r6.setUpAssignExpr(fakeAcc, AssignOp.EQ, ques);
        ExpressionStmnt eS2 = new ExpressionStmnt(r6);

        outer = new Block(true);
        outer.addBlockStmnt(arrays);
        outer.addBlockStmnt(iDec);
        outer.addBlockStmnt(forStmnt1);
        outer.addBlockStmnt(SingleWordStmnt.RETURN);
        outer.addBlockStmnt(eS2);

        j = new VarDeclarator();
        j.setUpVarDec("j", zero);
        jDec = new LocalVarDec();
        jDec.setUpLVD(UnannType.INT);
        jDec.addVarDec(j);
        jID = new Id();
        jID.setUpId(new Type(UnannType.INT, 1), "j");
        lT1 = new RelationExpr();
        lT1.setUpRelationExpr(RelationOp.LT, jID, one);
        jPlus = new UnaryPostIncExpr();
        jPlus.setUpPostIncExpr(true, jID);
        init2 = new ForInit();
        init2.setLocalVarDec(jDec);
        forStmnt2 = new ForStmnt();
        forStmnt2.setUpForStmnt(init2, lT1);
        forStmnt2.addUpdate(jPlus);
        forStmnt2.setBody(SingleWordStmnt.EMPTY);
    }

    @Test
    public void testAll() throws Exception {
        /* Code is:
        char[] orig = new char[] {'H', 'e', 'l', 'l', 'l', 'o', '!', '!', '!'}, result = new char[6];
        int i = 0;
        for (; i < 9; i++) {
            if (i == 2)
                continue;
            if (i == 7)
                break;
            result[i < 3 ? i : i - 1] = orig[i];
         }
         return;
         result[6] = '?'
         */
        outer.executeStart(c);
        String proper = "Hello!";
        ReturnValuesArray ar = (ReturnValuesArray)resultID.evaluate(c);
        assertEquals(proper.length(), ar.getSize());
        for (int i = 0; i < proper.length(); i++) {
            assertEquals(proper.charAt(i), ar.get(i));
        }

        /* Code is:
        for (int j = 0; j < 1; j++) ;
        Check it terminates
         */
        forStmnt2.executeStart(c);
    }
}