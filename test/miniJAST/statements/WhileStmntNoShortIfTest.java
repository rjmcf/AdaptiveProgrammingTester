package miniJAST.statements;

import miniJAST.Context;
import miniJAST.expressions.Id;
import miniJAST.expressions.Literal;
import miniJAST.expressions.arrays.ArrayAccess;
import miniJAST.expressions.assignment.AssignExpr;
import miniJAST.expressions.assignment.AssignOp;
import miniJAST.expressions.assignment.UnaryPostIncExpr;
import miniJAST.expressions.boolExpr.RelationExpr;
import miniJAST.expressions.boolExpr.RelationOp;
import miniJAST.expressions.returnValues.ReturnValuesInt;
import miniJAST.statements.arrays.ArrayCreationWithInitList;
import miniJAST.types.Type;
import miniJAST.types.UnannType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class WhileStmntNoShortIfTest {
    Context c;
    Block outer, inner;
    LocalVarDec ints;
    VarDeclarator i0, sum0;
    ArrayCreationWithInitList nsInit;
    Literal zero, one, two, three, four, five;
    Id sumID, iID, nsID;
    RelationExpr lT5;
    AssignExpr plusEquals;
    ArrayAccess access;
    UnaryPostIncExpr plus;
    WhileStmntNoShortIf wS;

    @BeforeMethod
    public void setUp() throws Exception {
        c = new Context();
        zero = new Literal();
        zero.setUpLiteral(UnannType.INT, "0");
        i0 = new VarDeclarator();
        i0.setUpVarDec("i", zero);
        sum0 = new VarDeclarator();
        sum0.setUpVarDec("sum", zero);
        one = new Literal();
        one.setUpLiteral(UnannType.INT, "1");
        two = new Literal();
        two.setUpLiteral(UnannType.INT, "2");
        three = new Literal();
        three.setUpLiteral(UnannType.INT, "3");
        four = new Literal();
        four.setUpLiteral(UnannType.INT, "4");
        nsInit = new ArrayCreationWithInitList();
        nsInit.setUPACWIL("ns");
        nsInit.addExpressionACWIL(one);
        nsInit.addExpressionACWIL(two);
        nsInit.addExpressionACWIL(three);
        nsInit.addExpressionACWIL(four);
        ints = new LocalVarDec();
        ints.setUpLVD(UnannType.INT);
        ints.addVarDec(i0);
        ints.addVarDec(sum0);
        ints.addVarDec(nsInit);

        five = new Literal();
        five.setUpLiteral(UnannType.INT, "5");
        sumID = new Id();
        sumID.setUpId(new Type(UnannType.INT, 1), "sum");
        lT5 = new RelationExpr();
        lT5.setUpRelationExpr(RelationOp.LT, sumID, five);
        nsID = new Id();
        nsID.setUpId(new Type(UnannType.INT, 4), "ns");
        iID = new Id();
        iID.setUpId(new Type(UnannType.INT, 1), "i");
        access = new ArrayAccess();
        access.setUpArrayAccess(nsID, iID);
        plusEquals = new AssignExpr();
        plusEquals.setUpAssignExpr(sumID, AssignOp.PLUSEQ, access);
        plus = new UnaryPostIncExpr();
        plus.setUpPostIncExpr(true, iID);
        inner = new Block();
        inner.addBlockStmnt(plusEquals);
        inner.addBlockStmnt(plus);
        wS = new WhileStmntNoShortIf();
        wS.setUpWhileNSI(lT5, inner);

        outer = new Block();
        outer.addBlockStmnt(ints);
        outer.addBlockStmnt(wS);
    }

    @Test
    public void testExecute() throws Exception {
        /* Code is:
        int i = 0, sum = 0, ns[] = new int[] {1, 2, 3, 4};
        while (sum < 5) {
            sum += ns[i]
            i++;
        }
        check sum == 6
         */
        outer.execute(c);
        assertEquals(6, ((ReturnValuesInt)sumID.evaluate(c)).value);
    }
}