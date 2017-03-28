package miniJAST.expressions.boolExpr;

import miniJAST.Context;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Literal;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.types.PrimType;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RelationExprTest {
    RelationExpr e;
    Context c;
    Literal t;
    Literal int2;
    Literal int3;
    Literal doubHalf;
    Literal c1;

    @BeforeMethod
    public void setUp() throws Exception {
        e = new RelationExpr();
        c = new Context();
        t = new Literal();
        t.setUpLiteral(PrimType.BOOLEAN, "true");
        int2 = new Literal();
        int2.setUpLiteral(PrimType.INT, "2");
        int3 = new Literal();
        int3.setUpLiteral(PrimType.INT, "3");
        doubHalf = new Literal();
        doubHalf.setUpLiteral(PrimType.DOUBLE, "0.5");
        c1 = new Literal();
        c1.setUpLiteral(PrimType.CHAR, "a");
    }

    @Test
    public void testEvaluate() throws Exception {
        e.setUpRelationExpr(RelationOp.LT, int2, int2);
        Assert.assertFalse(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpRelationExpr(RelationOp.LTE, int2, int2);
        Assert.assertTrue(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpRelationExpr(RelationOp.GT, int2, int2);
        Assert.assertFalse(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpRelationExpr(RelationOp.GTE, int2, int2);
        Assert.assertTrue(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpRelationExpr(RelationOp.LT, int2, int3);
        Assert.assertTrue(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpRelationExpr(RelationOp.LT, int3, int2);
        Assert.assertFalse(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpRelationExpr(RelationOp.LT, int2, doubHalf);
        Assert.assertFalse(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpRelationExpr(RelationOp.LT, doubHalf, int2);
        Assert.assertTrue(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpRelationExpr(RelationOp.LT, int2, c1);
        Assert.assertTrue(((ReturnValuesBool)e.evaluate(c)).value);

        e.setUpRelationExpr(RelationOp.GTE, t, int2);
        try {
            e.evaluate(c);
            fail("Cannot relate boolean values to arithmetic ones");
        } catch (TypeException te) {
            // pass test
        }
    }
}