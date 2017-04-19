import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.Id;
import miniJAST.expressions.Literal;
import miniJAST.expressions.arrays.ArrayAccess;
import miniJAST.expressions.arrays.ArrayCreation;
import miniJAST.expressions.assignment.AssignExpr;
import miniJAST.expressions.assignment.AssignOp;
import miniJAST.statements.Block;
import miniJAST.statements.ExpressionStmnt;
import miniJAST.statements.LVD.LocalVarDec;
import miniJAST.statements.LVD.VarDeclarator;
import miniJAST.statements.PrintStatement;
import miniJAST.types.PrimType;

public class Main {

    public static void main(String[] args) {
        int a[] = new int[4], b[] = new int[2];
        a = b;
        b[0] = 4;
        //System.out.println(a[0]); //prints 4
        b = new int[3];
        //System.out.println(a[0]); //prints 4
        //System.out.println(b[2]); //prints 0
        try {
            System.out.println(a[2]); // error
            assert(false);
        } catch (ArrayIndexOutOfBoundsException aE) {
            //pass
        }

        Literal four = new Literal(), two = new Literal(), zero = new Literal();
        four.setUpLiteral(PrimType.INT, "4"); two.setUpLiteral(PrimType.INT, "2"); zero.setUpLiteral(PrimType.INT, "0");
        ArrayCreation aC = new ArrayCreation(PrimType.INT, four), bC = new ArrayCreation(PrimType.INT, two);
        VarDeclarator aDec = new VarDeclarator(), bDec = new VarDeclarator();
        aDec.setUpVarDec("a", true, aC);
        bDec.setUpVarDec("b", true, bC);
        LocalVarDec lvd= new LocalVarDec();
        lvd.setUpLVD(PrimType.INT);
        lvd.addVarDec(aDec);
        lvd.addVarDec(bDec);
        Id aId = new Id(), bId = new Id();
        aId.setUpId("a"); bId.setUpId("b");
        AssignExpr aE1 = new AssignExpr(), aE2 = new AssignExpr();
        aE1.setUpAssignExpr(aId, AssignOp.EQ, bId);
        ExpressionStmnt eS1 = new ExpressionStmnt(aE1);
        ArrayAccess aa1 = new ArrayAccess(), aa2 = new ArrayAccess();
        aa1.setUpArrayAccess(bId, zero);
        aE2.setUpAssignExpr(aa1, AssignOp.EQ, four);
        ExpressionStmnt eS2 = new ExpressionStmnt(aE2);
        aa2.setUpArrayAccess(aId, zero);
        PrintStatement pS1 = new PrintStatement("arrayTest.txt", true);
        pS1.setUpPrint(aa2);
        ArrayCreation bC1 = new ArrayCreation(PrimType.INT, four);
        AssignExpr aE3 = new AssignExpr();
        aE3.setUpAssignExpr(bId, AssignOp.EQ, bC1);
        ExpressionStmnt eS3 = new ExpressionStmnt(aE3);
        ArrayAccess aa3 = new ArrayAccess();
        aa3.setUpArrayAccess(bId, two);
        PrintStatement pS2 = new PrintStatement("arrayTest.txt", true);
        pS2.setUpPrint(aa3);
        Block block = new Block(true);
        block.addBlockStmnt(lvd);
        block.addBlockStmnt(eS1);
        block.addBlockStmnt(eS2);
        block.addBlockStmnt(pS1);
        block.addBlockStmnt(eS3);
        block.addBlockStmnt(pS1);
        block.addBlockStmnt(pS2);
        try {
            block.execute(new Context());
        } catch (MiniJASTException me) {
            System.err.println("Something fucked up");
        }
    }
}