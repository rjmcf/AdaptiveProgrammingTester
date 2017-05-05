package questions;

import miniJAST.expressions.Id;
import miniJAST.expressions.Literal;
import miniJAST.expressions.assignment.AssignExpr;
import miniJAST.expressions.assignment.AssignOp;
import miniJAST.expressions.assignment.UnaryPostIncExpr;
import miniJAST.expressions.boolExpr.RelationExpr;
import miniJAST.expressions.boolExpr.RelationOp;
import miniJAST.statements.Block;
import miniJAST.statements.ExpressionStmnt;
import miniJAST.statements.ForLoops.ForInit;
import miniJAST.statements.ForLoops.ForStmnt;
import miniJAST.statements.LVD.LocalVarDec;
import miniJAST.statements.LVD.VarDeclarator;
import miniJAST.statements.PrintStatement;
import miniJAST.types.PrimType;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class PrintingTest extends AbstractPExercise {
    int N;
    int NthNum;

    public PrintingTest () {
        super(0);
        int n = r.nextInt(8) + 2;
        setQuestion("Print the " + n + "th triangle number");
        setCode("{ int j = 0;" +
                        "for (int i = 1; i <= " + n + "; i++) j += i;" +
                        "System.out.println(j); }");
        N = n;
        int j = 0;
        for (int i = 1; i <= N; i++)
            j += i;
        NthNum = j;
    }

    @Override
    public boolean checkSolved() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("standardOut.txt"));
            return Integer.valueOf(lines.get(0)) == NthNum;
        } catch (FileNotFoundException fE) {
            System.err.println("Could not find file");
            return false;
        } catch (IOException iE) {
            System.err.println("Could not read file");
            return false;
        }
    }
}
