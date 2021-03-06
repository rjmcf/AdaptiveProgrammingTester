package miniJAST;

import miniJAST.expressions.FillableBlankExpr;
import miniJAST.expressions.Id;
import miniJAST.expressions.Literal;
import miniJAST.expressions.arithExpr.MultExpr;
import miniJAST.expressions.assignment.AssignExpr;
import miniJAST.expressions.assignment.AssignOp;
import miniJAST.expressions.assignment.UnaryPostIncExpr;
import miniJAST.expressions.boolExpr.RelationExpr;
import miniJAST.expressions.boolExpr.RelationOp;
import miniJAST.statements.Block;
import miniJAST.statements.ExpressionStmnt;
import miniJAST.statements.FillableBlankStmnt;
import miniJAST.statements.ForLoops.ForInit;
import miniJAST.statements.ForLoops.ForStmnt;
import miniJAST.statements.LVD.LocalVarDec;
import miniJAST.statements.LVD.VarDeclarator;
import miniJAST.types.PrimType;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;

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
        sumStat.setUpLVD(PrimType.INT);
        fbe1 = new FillableBlankExpr(0);
        blankIds.add(fbe1.getId());
        sum = new VarDeclarator();
        sum.setUpVarDec("sum", false, fbe1);
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

        fbe2 = new FillableBlankExpr(0);
        blankIds.add(fbe2.getId());

        // set up "i--"
        iID = new Id();
        iID.setUpId("i");
        minus = new UnaryPostIncExpr();
        minus.setUpPostIncExpr(false, iID);

        fbs1 = new FillableBlankStmnt(0);
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
        one.setUpLiteral(PrimType.INT, "1");

        // set up "i > 0"
        zero = new Literal();
        zero.setUpLiteral(PrimType.INT, "0");
        gT = new RelationExpr();
        gT.setUpRelationExpr(RelationOp.GT, iID, zero);

        // set up "sum = sum * i"
        sumID = new Id();
        sumID.setUpId("sum");
        sumTimesI = new MultExpr();
        sumTimesI.setUpMultExpr(true, sumID, iID);
        sumAss = new AssignExpr();
        sumAss.setUpAssignExpr(sumID, AssignOp.EQ, sumTimesI);
        eS1 = new ExpressionStmnt(sumAss);
    }
}