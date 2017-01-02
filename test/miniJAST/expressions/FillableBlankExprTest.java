package miniJAST.expressions;

import miniJAST.Context;
import miniJAST.exceptions.BlankEmptyException;
import miniJAST.expressions.arithExpr.AddExpr;
import miniJAST.expressions.arithExpr.MultExpr;
import miniJAST.expressions.arithExpr.UnaryPMExpr;
import miniJAST.expressions.arrays.ArrayAccess;
import miniJAST.expressions.assignment.AssignExpr;
import miniJAST.expressions.assignment.AssignOp;
import miniJAST.expressions.assignment.UnaryPostIncExpr;
import miniJAST.expressions.assignment.UnaryPreIncExpr;
import miniJAST.expressions.boolExpr.*;
import miniJAST.types.Type;
import miniJAST.types.UnannType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class FillableBlankExprTest {
    Context c;
    FillableBlankExpr fbe;
    Literal lit0;
    Literal litF;
    Literal litT;
    Id id;

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
        id = new Id();
        id.setUpId(new Type(UnannType.INT, 2), "fakeArray");
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
        aE.evaluate(c);
        // test passes since evaluation order takes precedence over type-safety
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
        cE.setUpCondExpr(litT, lit0, fbe);
        cE.evaluate(c);
        // test passes since evaluation order takes precedence over type-safety
        cE.setUpCondExpr(litT, fbe, lit0);
        try {
            cE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
        cE.setUpCondExpr(litF, lit0, fbe);
        try {
            cE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
        cE.setUpCondExpr(litF, fbe, lit0);
        cE.evaluate(c);
        // test passes since evaluation order takes precedence over type-safety

        EqExpr eE = new EqExpr();
        eE.setUpEqExpr(true, fbe, lit0);
        try {
            eE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
        eE.setUpEqExpr(false, lit0, fbe);
        try {
            eE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }

        OrExpr oE = new OrExpr();
        oE.setUpOrExpr(litF, fbe);
        try {
            oE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
        oE.setUpOrExpr(fbe, litT);
        try {
            oE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }

        RelationExpr rE = new RelationExpr();
        rE.setUpRelationExpr(RelationOp.LT, fbe, lit0);
        try {
            rE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
        rE.setUpRelationExpr(RelationOp.GTE, lit0, fbe);
        try {
            rE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }

        UnaryComplementExpr ucE = new UnaryComplementExpr();
        ucE.setUpCompExpr(fbe);
        try {
            ucE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
    }

    @Test
    public void testEmptyEvaluateArray() throws Exception {
        c.namesToTypes.put("fakeArray", new Type(UnannType.INT, 2));
        c.namesToValues.put("fakeArray", new ArrayList<Integer>(2));
        ArrayAccess aaE = new ArrayAccess();
        aaE.setUpArrayAccess(id, fbe);
        try {
            aaE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
        aaE.setUpArrayAccess(fbe, lit0);
        try {
            aaE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
    }

    @Test
    public void testEmptyEvaluateAssign() throws Exception {
        AssignExpr aeE = new AssignExpr();
        aeE.setUpAssignExpr(fbe, AssignOp.EQ, lit0);
        try {
            aeE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
        aeE.setUpAssignExpr(id, AssignOp.EQ, fbe);
        try {
            aeE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }

        UnaryPostIncExpr upoIE = new UnaryPostIncExpr();
        upoIE.setUpPostIncExpr(true, fbe);
        try {
            upoIE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
        upoIE.setUpPostIncExpr(false, fbe);
        try {
            upoIE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }

        UnaryPreIncExpr uprIE = new UnaryPreIncExpr();
        uprIE.setUpPreIncExpr(true, fbe);
        try {
            uprIE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
        uprIE.setUpPreIncExpr(false, fbe);
        try {
            uprIE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
    }

    @Test
    public void testEmptyEvaluateBracketed() throws Exception {
        BracketedExpr bE = new BracketedExpr();
        bE.setUpBracketExpr(fbe);
        try {
            bE.evaluate(c);
            fail("Blank not filled in");
        } catch (BlankEmptyException bee) {
            // pass test
        }
    }
    
    // TODO test when blank filled
}