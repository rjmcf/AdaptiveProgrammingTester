package miniJAST.statements.ForLoops;

import miniJAST.Context;
import miniJAST.expressions.Id;
import miniJAST.expressions.Literal;
import miniJAST.expressions.arithExpr.MultExpr;
import miniJAST.expressions.assignment.AssignExpr;
import miniJAST.expressions.assignment.AssignOp;
import miniJAST.expressions.assignment.UnaryPostIncExpr;
import miniJAST.expressions.boolExpr.EqExpr;
import miniJAST.expressions.boolExpr.RelationExpr;
import miniJAST.expressions.boolExpr.RelationOp;
import miniJAST.expressions.returnValues.ReturnValuesInt;
import miniJAST.statements.*;
import miniJAST.statements.IfThenEtc.IfThenStmnt;
import miniJAST.statements.LVD.LocalVarDec;
import miniJAST.statements.LVD.VarDeclarator;
import miniJAST.types.PrimType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ForStmntTest {
    ForStmnt fS1, fS2;
    ForInit fI;
    Block block1, block2;
    LocalVarDec sumStat, iStat, jStat;
    VarDeclarator sum, i, j;
    Id iID, sumID, jID;
    AssignExpr sumAss;
    Literal zero, one, five;
    UnaryPostIncExpr minus, plus;
    RelationExpr gT;
    MultExpr sumTimesI;
    IfThenStmnt if2;
    EqExpr check5;
    Context c;

    @BeforeMethod
    public void setUp() throws Exception {
        c = new Context();

        // set up "int sum = 1"
        sumStat = new LocalVarDec();
        sumStat.setUpLVD(PrimType.INT);
        one = new Literal();
        one.setUpLiteral(PrimType.INT, "1");
        sum = new VarDeclarator();
        sum.setUpVarDec("sum", false, one);
        sumStat.addVarDec(sum);

        // set up ForStmnt
        fS1 = new ForStmnt();
        // set up ForInit
        fI = new ForInit();

        // set up "int i = 5"
        iStat = new LocalVarDec();
        iStat.setUpLVD(PrimType.INT);
        five = new Literal();
        five.setUpLiteral(PrimType.INT, "5");
        i = new VarDeclarator();
        i.setUpVarDec("i", false, five);
        iStat.addVarDec(i);
        fI.setLocalVarDec(iStat);

        // set up "i > 0"
        iID = new Id();
        iID.setUpId("i");
        zero = new Literal();
        zero.setUpLiteral(PrimType.INT, "0");
        gT = new RelationExpr();
        gT.setUpRelationExpr(RelationOp.GT, iID, zero);

        // set up "i--"
        minus = new UnaryPostIncExpr();
        minus.setUpPostIncExpr(false, iID);

        // set up "sum = sum * i"
        sumID = new Id();
        sumID.setUpId("sum");
        sumTimesI = new MultExpr();
        sumTimesI.setUpMultExpr(true, sumID, iID);
        sumAss = new AssignExpr();
        sumAss.setUpAssignExpr(sumID, AssignOp.EQ, sumTimesI);
        ExpressionStmnt eS1 = new ExpressionStmnt(sumAss);

        fS1.setUpForStmnt(fI, gT);
        fS1.addUpdate(minus);
        fS1.setBody(eS1);

        block1 = new Block(true);
        block1.addBlockStmnt(sumStat);
        block1.addBlockStmnt(fS1);


        j = new VarDeclarator();
        j.setUpVarDec("j", false, zero);
        jStat = new LocalVarDec();
        jStat.setUpLVD(PrimType.INT);
        jStat.addVarDec(j);
        jID = new Id();
        jID.setUpId("j");
        plus = new UnaryPostIncExpr();
        plus.setUpPostIncExpr(true, jID);
        check5 = new EqExpr();
        check5.setUpEqExpr(true, jID, five);
        if2 = new IfThenStmnt();
        if2.setUpIfThen(check5, SingleWordStmnt.BREAK);
        fS2 = new ForStmnt();
        fS2.setUpForStmnt(null, null);
        fS2.addUpdate(plus);
        fS2.setBody(if2);
        block2 = new Block(true);
        block2.addBlockStmnt(jStat);
        block2.addBlockStmnt(fS2);
    }

    @Test
    public void testExecute() throws Exception {
        /* Code is:
        int sum = 1;
        for (int i = 5; i > 0; i--) {
         sum = sum * i;
        }
        Check sum = 5! = 120
         */
        block1.execute(c);
        assertEquals(120, ((ReturnValuesInt)sumID.evaluate(c)).value);

        /* Code is:
        int j = 0;
        for (; ; j++) {
            if (j == 5)
                break;
        }
        Check j == 5
         */
        block2.execute(c);
        assertEquals(5, ((ReturnValuesInt)jID.evaluate(c)).value);
    }
}