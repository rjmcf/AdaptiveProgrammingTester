package miniJAST;

import miniJAST.exceptions.VariableDecException;
import miniJAST.expressions.Id;
import miniJAST.expressions.Literal;
import miniJAST.expressions.assignment.UnaryPostIncExpr;
import miniJAST.expressions.boolExpr.RelationExpr;
import miniJAST.expressions.boolExpr.RelationOp;
import miniJAST.statements.ForLoops.ForInit;
import miniJAST.statements.ForLoops.ForStmnt;
import miniJAST.statements.LocalVarDec;
import miniJAST.statements.SingleWordStmnt;
import miniJAST.statements.VarDeclarator;
import miniJAST.types.Type;
import miniJAST.types.UnannType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ContextTest {
    Context c;
    VarDeclarator i;
    LocalVarDec iDec;
    Literal zero, two;
    Id iID;
    RelationExpr lT2;
    UnaryPostIncExpr plus;
    ForInit init;
    ForStmnt fS;

    @BeforeMethod
    public void setUp() throws Exception {
        c = new Context();

        zero = new Literal();
        zero.setUpLiteral(UnannType.INT, "0");
        i = new VarDeclarator();
        i.setUpVarDec("i", zero);
        iDec = new LocalVarDec();
        iDec.setUpLVD(UnannType.INT);
        iDec.addVarDec(i);
        two = new Literal();
        two.setUpLiteral(UnannType.INT, "2");
        iID = new Id();
        iID.setUpId(new Type(UnannType.INT, 1), "i");
        lT2 = new RelationExpr();
        lT2.setUpRelationExpr(RelationOp.LT, iID, two);
        plus = new UnaryPostIncExpr();
        plus.setUpPostIncExpr(true, iID);
        init = new ForInit();
        init.addLocalVarDec(iDec);
        fS = new ForStmnt();
        fS.setUpForStmnt(init, lT2);
        fS.addUpdate(plus);
        fS.setBody(SingleWordStmnt.EMPTY);
    }

    @Test
    public void testScope() throws Exception {
        /* Code is
        for (int i = 0; i < 2; i++) ;
        Check that i is not defined
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