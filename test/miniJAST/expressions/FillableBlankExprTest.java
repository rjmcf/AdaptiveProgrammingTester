package miniJAST.expressions;

import miniJAST.Context;
import miniJAST.exceptions.BlankEmptyException;
import miniJAST.expressions.arithExpr.AddExpr;
import miniJAST.expressions.arithExpr.MultExpr;
import miniJAST.expressions.arithExpr.UnaryPMExpr;
import miniJAST.expressions.boolExpr.AndExpr;
import miniJAST.expressions.boolExpr.CondExpr;
import miniJAST.types.UnannType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FillableBlankExprTest {
    Context c;
    FillableBlankExpr fbe;
    Literal lit0;
    Literal litF;
    Literal litT;

    @BeforeMethod
    public void setUp() throws Exception {
        c = new Context();
        fbe = new FillableBlankExpr();
        lit0 = new Literal();
        lit0.setUpLiteral(UnannType.INT, "0");
        litF = new Literal();
        litF.setUpLiteral(UnannType.BOOLEAN, "false");
        litT = new Literal();
        litT.setUpLiteral(UnannType.BOOLEAN, "true");
    }

    @Test
    public void testEmptyEvaluateArith() throws Exception {
        AddExpr aE = new AddExpr();
        aE.setUpAddExpr(true, fbe, lit0);
        try {
            aE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
        aE.setUpAddExpr(false, lit0, fbe);
        try {
            aE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }

        MultExpr mE = new MultExpr();
        mE.setUpMultExpr(false, fbe, lit0);
        try {
            mE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
        mE.setUpMultExpr(true, lit0, fbe);
        try {
            mE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }

        UnaryPMExpr uE = new UnaryPMExpr();
        uE.setUpPMExpr(true, fbe);
        try {
            uE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
        uE.setUpPMExpr(false, fbe);
        try {
            uE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
    }

    @Test
    public void testEmptyEvaluateBool() throws Exception {
        AndExpr aE = new AndExpr();
        aE.setUpAndExpr(litF, fbe);
        try {
            aE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
        aE.setUpAndExpr(fbe, litT);
        try {
            aE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }

        CondExpr cE = new CondExpr();
        cE.setUpCondExpr(fbe, lit0, lit0);
        try {
            cE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
        // TODO finish test
    }
}