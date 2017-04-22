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
    int nSq;
    Id nSqId;

    public SquareExercise(int N) {
        super("Calculate the square of '" + N + "' and store it in 'nSq'.",
                "{ int n = " + N + ", nSq; " +
                        "nSq = n * n; }",
                0);
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
