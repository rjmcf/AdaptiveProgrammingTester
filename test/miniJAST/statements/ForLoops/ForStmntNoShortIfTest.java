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
import miniJAST.types.Type;
import miniJAST.types.UnannType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ForStmntNoShortIfTest {
    ForStmntNoShortIf fS1, fS2;
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
    IfThenElseStmntNoShortIf if2;
    EqExpr check5;
    Context c;

    @BeforeMethod
    public void setUp() throws Exception {
        c = new Context();

        // set up "int sum = 1"
        sumStat = new LocalVarDec();
        sumStat.setUpLVD(UnannType.INT);
        one = new Literal();
        one.setUpLiteral(UnannType.INT, "1");
        sum = new VarDeclarator();
        sum.setUpVarDec("sum", one);
        sumStat.addVarDec(sum);

        // set up ForStmnt
        fS1 = new ForStmntNoShortIf();
        // set up ForInit
        fI = new ForInit();
        // set up "int i = 5"
        iStat = new LocalVarDec();
        iStat.setUpLVD(UnannType.INT);
        five = new Literal();
        five.setUpLiteral(UnannType.INT, "5");
        i = new VarDeclarator();
        i.setUpVarDec("i", five);
        iStat.addVarDec(i);
        fI.addLocalVarDec(iStat);
        // set up "i > 0"
        iID = new Id();
        iID.setUpId(new Type(UnannType.INT, 1), "i");
        zero = new Literal();
        zero.setUpLiteral(UnannType.INT, "0");
        gT = new RelationExpr();
        gT.setUpRelationExpr(RelationOp.GT, iID, zero);
        // set up "i--"
        minus = new UnaryPostIncExpr();
        minus.setUpPostIncExpr(false, iID);
        // set up "sum = sum * i"
        sumID = new Id();
        sumID.setUpId(new Type(UnannType.INT, 1), "sum");
        sumTimesI = new MultExpr();
        sumTimesI.setUpMultExpr(true, sumID, iID);
        sumAss = new AssignExpr();
        sumAss.setUpAssignExpr(sumID, AssignOp.EQ, sumTimesI);
        fS1.setUpForStmntNSI(fI, gT);
        fS1.addUpdate(minus);
        fS1.setBody(sumAss);

        block1 = new Block();
        block1.addBlockStmnt(sumStat);
        block1.addBlockStmnt(fS1);

        j = new VarDeclarator();
        j.setUpVarDec("j", zero);
        jStat = new LocalVarDec();
        jStat.setUpLVD(UnannType.INT);
        jStat.addVarDec(j);
        jID = new Id();
        jID.setUpId(new Type(UnannType.INT, 1), "j");
        plus = new UnaryPostIncExpr();
        plus.setUpPostIncExpr(true, jID);
        check5 = new EqExpr();
        check5.setUpEqExpr(true, jID, five);
        if2 = new IfThenElseStmntNoShortIf();
        if2.setUpITENSI(check5, SingleWordStmnt.BREAK, SingleWordStmnt.CONTINUE);
        fS2 = new ForStmntNoShortIf();
        fS2.setUpForStmntNSI(null, null);
        fS2.addUpdate(plus);
        fS2.setBody(if2);
        block2 = new Block();
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
        block1.execute(c, -1);
        assertEquals(120, ((ReturnValuesInt)sumID.evaluate(c)).value);

        /* Code is:
        int j = 0;
        for (; ; j++) {
            if (j == 5)
                break;
            else
                continue;
        }
        Check j == 5
         */
        block2.execute(c, -1);
        assertEquals(5, ((ReturnValuesInt)jID.evaluate(c)).value);
    }
}