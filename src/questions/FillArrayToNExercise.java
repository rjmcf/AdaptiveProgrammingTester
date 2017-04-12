package questions;

import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.Id;
import miniJAST.expressions.Literal;
import miniJAST.expressions.arrays.ArrayAccess;
import miniJAST.expressions.arrays.ArrayCreation;
import miniJAST.expressions.assignment.AssignExpr;
import miniJAST.expressions.assignment.AssignOp;
import miniJAST.expressions.assignment.UnaryPostIncExpr;
import miniJAST.expressions.boolExpr.RelationExpr;
import miniJAST.expressions.boolExpr.RelationOp;
import miniJAST.expressions.returnValues.ReturnValuesArray;
import miniJAST.statements.Block;
import miniJAST.statements.ExpressionStmnt;
import miniJAST.statements.ForLoops.ForInit;
import miniJAST.statements.ForLoops.ForStmnt;
import miniJAST.statements.LVD.LocalVarDec;
import miniJAST.statements.LVD.VarDeclarator;
import miniJAST.types.PrimType;

public class FillArrayToNExercise extends AbstractPExercise {
    int max;
    Id nsID;

    public FillArrayToNExercise(int n) {
        super("Fill the array named 'ns' with numbers from 0 to " + (n - 1) + ".", 2); // initial estimate of difficulty
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

        baseSetUp();

        Literal n = new Literal();
        n.setUpLiteral(PrimType.INT, String.valueOf(max));
        ArrayCreation nsR = new ArrayCreation(PrimType.INT, n);
        VarDeclarator ns = new VarDeclarator();
        ns.setUpVarDec("ns", true, nsR);
        LocalVarDec array = new LocalVarDec();
        array.setUpLVD(PrimType.INT);
        array.addVarDec(ns);
        Literal zero = new Literal();
        zero.setUpLiteral(PrimType.INT, "0");
        VarDeclarator i = new VarDeclarator();
        i.setUpVarDec("i", false, zero);
        LocalVarDec iDec = new LocalVarDec();
        iDec.setUpLVD(PrimType.INT);
        iDec.addVarDec(i);
        Id iID = new Id();
        iID.setUpId("i");
        RelationExpr lTN = new RelationExpr();
        lTN.setUpRelationExpr(RelationOp.LT, iID, n);
        UnaryPostIncExpr plus = new UnaryPostIncExpr();
        plus.setUpPostIncExpr(true, iID);
        nsID = new Id();
        nsID.setUpId("ns");
        ArrayAccess nsAcc = new ArrayAccess();
        nsAcc.setUpArrayAccess(nsID, iID);
        AssignExpr updateIndex = new AssignExpr();
        updateIndex.setUpAssignExpr(nsAcc, AssignOp.EQ, iID);
        ForInit init = new ForInit();
        init.setLocalVarDec(iDec);
        ForStmnt fS = new ForStmnt();
        fS.setUpForStmnt(init, lTN);
        fS.addUpdate(plus);
        ExpressionStmnt body = new ExpressionStmnt(updateIndex);
        fS.setBody(body);
        Block block = new Block(true);
        block.addBlockStmnt(array);
        block.addBlockStmnt(fS);

        solution = block;
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
