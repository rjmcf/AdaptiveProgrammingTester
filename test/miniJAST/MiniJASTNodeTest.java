package miniJAST;

import miniJAST.exceptions.BlankEmptyException;
import miniJAST.expressions.FillableBlankExpr;
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
import miniJAST.statements.Block;
import miniJAST.statements.ExpressionStmnt;
import miniJAST.statements.FillableBlankStmnt;
import miniJAST.statements.ForLoops.ForInit;
import miniJAST.statements.ForLoops.ForStmnt;
import miniJAST.statements.IfThenEtc.IfThenStmnt;
import miniJAST.statements.LVD.LocalVarDec;
import miniJAST.statements.LVD.VarDeclarator;
import miniJAST.types.Type;
import miniJAST.types.UnannType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class MiniJASTNodeTest {
    ForStmnt fS1;
    ForInit fI;
    Block block1;
    LocalVarDec sumStat, iStat;
    VarDeclarator sum, i;
    Id iID, sumID;
    AssignExpr sumAss;
    Literal zero, one, five;
    UnaryPostIncExpr minus;
    RelationExpr gT;
    MultExpr sumTimesI;
    Context c;
    ExpressionStmnt eS1;
    FillableBlankExpr fbe1, fbe2;
    FillableBlankStmnt fbs1;
    ArrayList<Integer> blankIds = new ArrayList<>(3);

    @BeforeMethod
    public void setUp() throws Exception {
        c = new Context();

        // set up "int sum = ..."
        sumStat = new LocalVarDec();
        sumStat.setUpLVD(UnannType.INT);
        fbe1 = new FillableBlankExpr();
        blankIds.add(fbe1.getId());
        sum = new VarDeclarator();
        sum.setUpVarDec("sum", fbe1);
        sumStat.addVarDec(sum);

        // set up ForStmnt
        fS1 = new ForStmnt();
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
        fI.setLocalVarDec(iStat);

        fbe2 = new FillableBlankExpr();
        blankIds.add(fbe2.getId());

        // set up "i--"
        iID = new Id();
        iID.setUpId(new Type(UnannType.INT, 1), "i");
        minus = new UnaryPostIncExpr();
        minus.setUpPostIncExpr(false, iID);

        fbs1 = new FillableBlankStmnt();
        blankIds.add(fbs1.getId());
        blankIds.add(fbs1.getId() + 1);

        fS1.setUpForStmnt(fI, fbe2);
        fS1.addUpdate(minus);
        fS1.setBody(fbs1);

        block1 = new Block(true);
        block1.addBlockStmnt(sumStat);
        block1.addBlockStmnt(fS1);


        // Set up replacements!

        one = new Literal();
        one.setUpLiteral(UnannType.INT, "1");

        // set up "i > 0"
        zero = new Literal();
        zero.setUpLiteral(UnannType.INT, "0");
        gT = new RelationExpr();
        gT.setUpRelationExpr(RelationOp.GT, iID, zero);

        // set up "sum = sum * i"
        sumID = new Id();
        sumID.setUpId(new Type(UnannType.INT, 1), "sum");
        sumTimesI = new MultExpr();
        sumTimesI.setUpMultExpr(true, sumID, iID);
        sumAss = new AssignExpr();
        sumAss.setUpAssignExpr(sumID, AssignOp.EQ, sumTimesI);
        eS1 = new ExpressionStmnt(sumAss);
    }

    @Test
    public void testFillBlank() throws Exception {
        try {
            block1.executeStart(c);
            fail("Three blanks left to fill");
        } catch (BlankEmptyException bee) {
            // pass test
        }

        assertTrue(block1.fillBlank(blankIds.get(0), one));
        c = new Context();
        try {
            block1.executeStart(c);
            fail("Two blanks left to fill");
        } catch (BlankEmptyException bee) {
            // pass test
        }

        assertTrue(block1.fillBlank(blankIds.get(1), gT));
        c = new Context();
        try {
            block1.executeStart(c);
            fail("One blank left to fill");
        } catch (BlankEmptyException bee) {
            // pass test
        }

        assertTrue(block1.fillBlank(blankIds.get(2), eS1));
        c = new Context();
        block1.executeStart(c);
        assertEquals(((ReturnValuesInt)sumID.evaluate(c)).value, 120);

        assertTrue(block1.fillBlank(blankIds.get(0), zero));
        c = new Context();
        block1.executeStart(c);
        assertEquals(((ReturnValuesInt)sumID.evaluate(c)).value, 0);

        assertFalse(block1.fillBlank(blankIds.get(3), zero));
    }
}