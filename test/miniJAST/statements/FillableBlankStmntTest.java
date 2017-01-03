package miniJAST.statements;

import miniJAST.Context;
import miniJAST.expressions.Literal;
import miniJAST.types.UnannType;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.*;

public class FillableBlankStmntTest {
    Context c;
    FillableBlankStmnt fbs;
    Literal lit0;
    Literal litF;
    Literal litT;

    @BeforeMethod
    public void setUp() throws Exception {
        c = new Context();
        fbs = new FillableBlankStmnt();
        lit0 = new Literal();
        lit0.setUpLiteral(UnannType.INT, "0");
        litT = new Literal();
        litT.setUpLiteral(UnannType.BOOLEAN, "true");
        litF = new Literal();
        litF.setUpLiteral(UnannType.BOOLEAN, "false");
    }


}