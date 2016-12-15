package miniJAST.statements.ForLoops;

import miniJAST.Context;
import miniJAST.expressions.Id;
import miniJAST.expressions.Literal;
import miniJAST.expressions.arithExpr.MultExpr;
import miniJAST.expressions.assignment.AssignExpr;
import miniJAST.expressions.assignment.AssignOp;
import miniJAST.expressions.assignment.UnaryPostIncExpr;
import miniJAST.expressions.boolExpr.RelationExpr;
import miniJAST.expressions.boolExpr.RelationOp;
import miniJAST.expressions.returnValues.ReturnValuesInt;
import miniJAST.statements.Block;
import miniJAST.statements.LocalVarDec;
import miniJAST.statements.VarDeclarator;
import miniJAST.types.Type;
import miniJAST.types.UnannType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ForStmntNoShortIfTest {
    ForStmntNoShortIf fS;
    ForInit fI;
    Block block;
    LocalVarDec sumStat, iStat;
    VarDeclarator sum, i;
    Id iID, sumID;
    AssignExpr sumAss;
    Literal zero, one, five;
    UnaryPostIncExpr minus;
    RelationExpr gT;
    MultExpr sumTimesI;
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
        fS = new ForStmntNoShortIf();
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
        fI.setUpForInit(false, iStat);
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
        fS.setUpForStmntNSI(fI, gT, minus);
        fS.addStmntExpr(sumAss);

        block = new Block();
        block.addBlockStmnt(sumStat);
        block.addBlockStmnt(fS);
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
        block.execute(c);
        assertEquals(120, ((ReturnValuesInt)sumID.evaluate(c)).value);
    }
}