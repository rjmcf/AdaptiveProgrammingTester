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
        super("Fill the array named 'ns' with numbers from 0 to " + (n - 1) + ".",
                "{ int ns[] = new int[" + n + "]; " +
                        "for (int i = 0; i < " + n + "; i++) ns[i] = i; }",
                2);
        max = n;
        nsID = new Id();
        nsID.setUpId("ns");
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
