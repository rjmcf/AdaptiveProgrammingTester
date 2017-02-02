package questions;

import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.Id;
import miniJAST.expressions.Literal;
import miniJAST.expressions.arithExpr.MultExpr;
import miniJAST.expressions.assignment.AssignExpr;
import miniJAST.expressions.assignment.AssignOp;
import miniJAST.expressions.returnValues.ReturnValuesInt;
import miniJAST.statements.Block;
import miniJAST.statements.ExpressionStmnt;
import miniJAST.statements.LVD.LocalVarDec;
import miniJAST.statements.LVD.VarDeclarator;
import miniJAST.types.Type;
import miniJAST.types.UnannType;

public class SquareExercise extends AbstractPExercise {
    int n;
    Id nSqId;

    public SquareExercise(int N) {
        super("Calculate the square of '" + N + "' and store it in 'nSq'.", 0);
        n = N;
    }

    @Override
    public void setUp() {
        /* Code is
        int n = n, nSq;
        nSq = n * n;
         */

        baseSetUp();

        Literal nLit = new Literal();
        nLit.setUpLiteral(UnannType.INT, String.valueOf(n));
        VarDeclarator nDec = new VarDeclarator();
        nDec.setUpVarDec("n", nLit);
        VarDeclarator nSqDec = new VarDeclarator();
        nSqDec.setUpVarDec("nSq", null);
        LocalVarDec lvd = new LocalVarDec();
        lvd.setUpLVD(UnannType.INT);
        lvd.addVarDec(nDec);
        lvd.addVarDec(nSqDec);

        nSqId = new Id();
        nSqId.setUpIdSimple(UnannType.INT, "nSq");
        Id nId = new Id();
        nId.setUpIdSimple(UnannType.INT, "n");
        MultExpr times = new MultExpr();
        times.setUpMultExpr(true, nId, nId);
        AssignExpr eq = new AssignExpr();
        eq.setUpAssignExpr(nSqId, AssignOp.EQ, times);
        ExpressionStmnt eS = new ExpressionStmnt(eq);

        Block block = new Block(true);
        block.addBlockStmnt(lvd);
        block.addBlockStmnt(eS);

        solution = block;
    }

    @Override
    public boolean checkSolved() {
        try {
            ReturnValuesInt result = (ReturnValuesInt) nSqId.evaluate(c);
            return result.value == n*n;
        } catch (MiniJASTException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
