package questions;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.Id;
import miniJAST.expressions.Literal;
import miniJAST.expressions.arrays.ArrayAccess;
import miniJAST.expressions.assignment.AssignExpr;
import miniJAST.expressions.assignment.AssignOp;
import miniJAST.expressions.assignment.UnaryPostIncExpr;
import miniJAST.expressions.boolExpr.RelationExpr;
import miniJAST.expressions.boolExpr.RelationOp;
import miniJAST.expressions.returnValues.ReturnValuesArray;
import miniJAST.statements.Block;
import miniJAST.statements.ForLoops.ForInit;
import miniJAST.statements.ForLoops.ForStmnt;
import miniJAST.statements.LocalVarDec;
import miniJAST.statements.VarDeclarator;
import miniJAST.statements.arrays.ArrayCreationWithSize;
import miniJAST.types.Type;
import miniJAST.types.UnannType;

public class FillArrayToNExercise extends AbstractPExercise {
    int max;
    Id nsID;
    Block block;
    Context c;

    public FillArrayToNExercise(int n) {
        super("Fill the array named 'ns' with numbers from 0 to " + n + ".");
        max = n;
    }

    @Override
    public void setUp() {
        /* Code is:
        int ns[] = new int[n];
        for (int i = 0; i < n; i++) {
            ns[i] = i;
        }
         */

        Literal n = new Literal();
        n.setUpLiteral(UnannType.INT, String.valueOf(max));
        ArrayCreationWithSize ns = new ArrayCreationWithSize();
        ns.setUpACWS("ns", n);
        LocalVarDec array = new LocalVarDec();
        array.setUpLVD(UnannType.INT);
        array.addVarDec(ns);
        Literal zero = new Literal();
        zero.setUpLiteral(UnannType.INT, "0");
        VarDeclarator i = new VarDeclarator();
        i.setUpVarDec("i", zero);
        LocalVarDec iDec = new LocalVarDec();
        iDec.setUpLVD(UnannType.INT);
        iDec.addVarDec(i);
        Id iID = new Id();
        iID.setUpId(new Type(UnannType.INT, 1), "i");
        RelationExpr lTN = new RelationExpr();
        lTN.setUpRelationExpr(RelationOp.LT, iID, n);
        UnaryPostIncExpr plus = new UnaryPostIncExpr();
        plus.setUpPostIncExpr(true, iID);
        nsID = new Id();
        nsID.setUpId(new Type(UnannType.INT, max), "ns");
        ArrayAccess nsAcc = new ArrayAccess();
        nsAcc.setUpArrayAccess(nsID, iID);
        AssignExpr updateIndex = new AssignExpr();
        updateIndex.setUpAssignExpr(nsAcc, AssignOp.EQ, iID);
        ForInit init = new ForInit();
        init.addLocalVarDec(iDec);
        ForStmnt fS = new ForStmnt();
        fS.setUpForStmnt(init, lTN);
        fS.addUpdate(plus);
        fS.setBody(updateIndex);
        block = new Block();
        block.addBlockStmnt(array);
        block.addBlockStmnt(fS);
    }

    @Override
    public void runSolution() {
        c = new Context();
        try {
            block.execute(c);
        } catch (MiniJASTException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean checkSolved() {
        try {
            ReturnValuesArray<Integer> result = (ReturnValuesArray) nsID.evaluate(c);
            for (int i = 0; i < max; i++) {
                if (result.get(i) != i)
                    return false;
            }
            return true;
        } catch (MiniJASTException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
