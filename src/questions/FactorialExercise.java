package questions;

import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.Id;
import miniJAST.expressions.Literal;
import miniJAST.expressions.assignment.AssignExpr;
import miniJAST.expressions.assignment.AssignOp;
import miniJAST.expressions.assignment.UnaryPostIncExpr;
import miniJAST.expressions.boolExpr.RelationExpr;
import miniJAST.expressions.boolExpr.RelationOp;
import miniJAST.expressions.returnValues.ReturnValuesInt;
import miniJAST.statements.Block;
import miniJAST.statements.DoAndWhileLoops.WhileStmnt;
import miniJAST.statements.ExpressionStmnt;
import miniJAST.statements.LVD.LocalVarDec;
import miniJAST.statements.LVD.VarDeclarator;
import miniJAST.types.Type;
import miniJAST.types.UnannType;

public class FactorialExercise extends AbstractPExercise {
    int n;
    int nFact;
    Id totalId;

    public FactorialExercise(int N) {
        super("Calculate the factorial of '" + N + "' and store it in 'total'.", 1);
        n = N;
        nFact = 1;
        while (N > 1) {
            nFact *= N--;
        }
    }

    @Override
    public void setUp() {
        /* Code is
        int total = 1, n = n;
        while (n > 1) {
            total *= n--;
        }
         */

        baseSetUp();

        Literal one = new Literal();
        one.setUpLiteral(UnannType.INT, "1");
        VarDeclarator totalDec = new VarDeclarator();
        totalDec.setUpVarDec("total", one);
        Literal nLit = new Literal();
        nLit.setUpLiteral(UnannType.INT, String.valueOf(n));
        VarDeclarator nDec = new VarDeclarator();
        nDec.setUpVarDec("n", nLit);
        LocalVarDec lvd = new LocalVarDec();
        lvd.setUpLVD(UnannType.INT);
        lvd.addVarDec(totalDec);
        lvd.addVarDec(nDec);

        Id nID = new Id();
        nID.setUpId("n");
        RelationExpr gT1 = new RelationExpr();
        gT1.setUpRelationExpr(RelationOp.GT, nID, one);

        UnaryPostIncExpr minus = new UnaryPostIncExpr();
        minus.setUpPostIncExpr(false, nID);
        totalId = new Id();
        totalId.setUpId("total");
        AssignExpr times = new AssignExpr();
        times.setUpAssignExpr(totalId, AssignOp.TIMESEQ, minus);
        ExpressionStmnt eS = new ExpressionStmnt(times);

        WhileStmnt w = new WhileStmnt();
        w.setUpWhile(gT1, eS);

        Block block = new Block(true);
        block.addBlockStmnt(lvd);
        block.addBlockStmnt(w);

        solution = block;
    }

    @Override
    public boolean checkSolved() {
        try {
            ReturnValuesInt result = (ReturnValuesInt) totalId.evaluate(c);
            return result.value == nFact;
        } catch (MiniJASTException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
