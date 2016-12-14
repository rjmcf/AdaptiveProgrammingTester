package miniJAST.expressions.assignment;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.Id;
import miniJAST.expressions.Literal;
import miniJAST.expressions.arrays.ArrayAccess;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.expressions.returnValues.ReturnValuesBoolAA;
import miniJAST.types.Type;
import miniJAST.types.UnannType;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class AssignExprTest {
    AssignExpr aE;
    Context c;
    Id id;
    ArrayAccess aa;
    Expression eT, eF;

    @BeforeMethod
    public void setUp() throws Exception {
        aE = new AssignExpr();
        c = new Context();
        id = new Id();
        aa = new ArrayAccess();
        eT = new Expression() {
            @Override
            public ReturnValues evaluate(Context c) throws MiniJASTException {
                return new ReturnValuesBool(true);
            }
        };
        eF = new Expression() {
            @Override
            public ReturnValues evaluate(Context c) throws MiniJASTException {
                return new ReturnValuesBool(false);
            }
        };
    }

    @Test
    public void testEqId() throws Exception {
        c.namesToTypes.put("t", new Type(UnannType.BOOLEAN, 1));
        id.setUpId(new Type(UnannType.BOOLEAN, 1), "t");

        aE.setUpAssignExpr(id, AssignOp.EQ, eT);
        aE.evaluate(c);
        Assert.assertTrue(((ReturnValuesBool)id.evaluate(c)).value);

        aE.setUpAssignExpr(id, AssignOp.EQ, eF);
        aE.evaluate(c);
        Assert.assertFalse(((ReturnValuesBool)id.evaluate(c)).value);
    }

    @Test
    public void testEqArray() throws Exception {
        c.namesToTypes.put("boolArray2", new Type(UnannType.BOOLEAN, 2));
        ArrayList<Boolean> bools = new ArrayList<>(2);
        while (bools.size() < 2) {
            bools.add(false);
        }
        c.namesToValues.put("boolArray2", bools);

        id.setUpId(new Type(UnannType.BOOLEAN, 2), "boolArray2");
        Literal one = new Literal();
        one.setUpLiteral(UnannType.INT, "1");
        aa.setUpArrayAccess(id, one);
        aE.setUpAssignExpr(aa, AssignOp.EQ, eT);
        aE.evaluate(c);
        assertTrue(((ReturnValuesBoolAA)aa.evaluate(c)).value);
    }

    // TODO test other operators
}