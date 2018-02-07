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
import miniJAST.types.PrimType;

import java.util.Random;

public class FactorialExercise extends AbstractPExercise {
    private static final int MIN = 10;
    private static final int MAX = 20;
    int N;
    int nFact;
    Id totalId;

    public FactorialExercise() {
        super(1);
        N = r.nextInt(MAX - MIN + 1) + MIN;
        setQuestion("Calculate the factorial of '" + N + "' and store it in 'total'.");
        setCode("{ int total = 1, n = " + N + "; while (n > 1) total *= n--; }");
        nFact = 1;
        int count = N;
        while (count > 1) {
            nFact *= count--;
        }
        totalId = new Id();
        totalId.setUpId("total");
    }

    public int getN_TEST() { return N; }

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
