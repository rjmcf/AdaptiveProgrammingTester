package miniJAST;

import miniJAST.exceptions.VariableDecException;
import miniJAST.expressions.Id;
import miniJAST.expressions.Literal;
import miniJAST.expressions.assignment.UnaryPostIncExpr;
import miniJAST.expressions.boolExpr.RelationExpr;
import miniJAST.expressions.boolExpr.RelationOp;
import miniJAST.statements.Block;
import miniJAST.statements.ForLoops.ForInit;
import miniJAST.statements.ForLoops.ForStmnt;
import miniJAST.statements.LVD.LocalVarDec;
import miniJAST.statements.LVD.VarDeclarator;
import miniJAST.types.PrimType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ContextTest {
    Context c;
    VarDeclarator i, j;
    LocalVarDec iDec, jDec;
    Literal zero, two;
    Id iID, jID;
    RelationExpr lT2;
    UnaryPostIncExpr plus;
    ForInit init;
    ForStmnt fS;
    Block b1;

    @BeforeMethod
    public void setUp() throws Exception {
        c = new Context();

        zero = new Literal();
        zero.setUpLiteral(PrimType.INT, "0");
        i = new VarDeclarator();
        i.setUpVarDec("i", false, zero);
        iDec = new LocalVarDec();
        iDec.setUpLVD(PrimType.INT);
        iDec.addVarDec(i);
        two = new Literal();
        two.setUpLiteral(PrimType.INT, "2");
        iID = new Id();
        iID.setUpId("i");
        lT2 = new RelationExpr();
        lT2.setUpRelationExpr(RelationOp.LT, iID, two);
        plus = new UnaryPostIncExpr();
        plus.setUpPostIncExpr(true, iID);
        j = new VarDeclarator();
        j.setUpVarDec("j", false, iID);
        jDec = new LocalVarDec();
        jDec.setUpLVD(PrimType.INT);
        jDec.addVarDec(j);
        jID = new Id();
        jID.setUpId("j");
        init = new ForInit();
        init.setLocalVarDec(iDec);
        fS = new ForStmnt();
        fS.setUpForStmnt(init, lT2);
        fS.addUpdate(plus);
        b1 = new Block(false);
        b1.addBlockStmnt(jDec);
        fS.setBody(b1);
    }

    @Test
    public void testScope() throws Exception {
        /* Code is
        for (int i = 0; i < 2; i++) {
            int j = i;
        }
        Check that i and j are not defined
         */
        fS.execute(c);
        try {
            iID.evaluate(c);
            fail("'i' should not be defined here");
        } catch (VariableDecException ex) {
            // pass test
        }
    }
}