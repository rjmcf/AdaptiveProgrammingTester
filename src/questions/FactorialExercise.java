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

public class FactorialExercise extends AbstractPExercise {
    int nFact;
    Id totalId;

    public FactorialExercise(int N) {
        super("Calculate the factorial of '" + N + "' and store it in 'total'.",
                "{ int total = 1, n = " + N + "; " +
                        "while (n > 1) total *= n--; }",
                1);
        nFact = 1;
        while (N > 1) {
            nFact *= N--;
        }
        totalId = new Id();
        totalId.setUpId("total");
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
