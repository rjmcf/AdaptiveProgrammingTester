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
import miniJAST.types.PrimType;

public class SquareExercise extends AbstractPExercise {
    private static final int MIN = 20;
    private static final int MAX = 40;
    int nSq;
    Id nSqId;

    public SquareExercise() {
        super(0);
        int N = r.nextInt(MAX - MIN + 1) + MIN;
        setQuestion("Calculate the square of '" + N + "' and store it in 'nSq'.");
        setCode("{ int n = " + N + ", nSq; nSq = n * n; }");
        nSq = N*N;
        nSqId = new Id();
        nSqId.setUpId("nSq");
    }

    @Override
    public boolean checkSolved() {
        try {
            ReturnValuesInt result = (ReturnValuesInt) nSqId.evaluate(c);
            return result.value == nSq;
        } catch (MiniJASTException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
