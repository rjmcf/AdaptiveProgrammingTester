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

public class PrintingTest extends AbstractPExercise {
    int N;
    int NthNum;

    public PrintingTest (int n) {
        super("", 0);
        N = n;
        int j = 0;
        for (int i = 1; i <= N; i++)
            j += i;
        NthNum = j;
    }

    @Override
    public void setUp() {
        /* Code
        int j = 0;
        for (int i = 1; i <= N; i++) {
            j += i;
        }
        System.out.println(j);
        // Check that j is Nth triangle number
         */

        Literal zero = new Literal(), one = new Literal(), Nint = new Literal();
        zero.setUpLiteral(PrimType.INT, "0");
        one.setUpLiteral(PrimType.INT, "1");
        Nint.setUpLiteral(PrimType.INT, Integer.toString(N));

        VarDeclarator jDec = new VarDeclarator();
        jDec.setUpVarDec("j", false, zero);
        LocalVarDec lvd = new LocalVarDec();
        lvd.setUpLVD(PrimType.INT);
        lvd.addVarDec(jDec);

        VarDeclarator iDec= new VarDeclarator();
        iDec.setUpVarDec("i", false, one);
        LocalVarDec lvdF = new LocalVarDec();
        lvdF.setUpLVD(PrimType.INT);
        lvdF.addVarDec(iDec);
        ForInit fI = new ForInit();
        fI.setLocalVarDec(lvdF);

        Id i = new Id(), j = new Id();
        i.setUpId("i"); j.setUpId("j");

        RelationExpr rE = new RelationExpr();
        rE.setUpRelationExpr(RelationOp.LTE, i, Nint);
        UnaryPostIncExpr upiE = new UnaryPostIncExpr();
        upiE.setUpPostIncExpr(true, i);

        AssignExpr aE= new AssignExpr();
        aE.setUpAssignExpr(j, AssignOp.PLUSEQ, i);
        ExpressionStmnt eS = new ExpressionStmnt(aE);

        ForStmnt fS = new ForStmnt();
        fS.setUpForStmnt(fI, rE);
        fS.addUpdate(upiE);
        fS.setBody(eS);

        PrintStatement pS = new PrintStatement("src/questions/PrintingTestOut.txt", false);
        pS.setUpPrint(j);

        Block b = new Block(true);
        b.addBlockStmnt(lvd);
        b.addBlockStmnt(fS);
        b.addBlockStmnt(pS);

        solution = b;
    }

    @Override
    public boolean checkSolved() {
        try {
            FileReader fIS = new FileReader("src/questions/PrintingTestOut.txt");
            BufferedReader bR = new BufferedReader(fIS);
            return Integer.parseInt(bR.readLine()) == NthNum;
        } catch (FileNotFoundException fE) {
            System.err.println("Could not find file");
            return false;
        } catch (IOException iE) {
            System.err.println("Could not read file");
            return false;
        }
    }
}
