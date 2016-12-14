package miniJAST.expressions.assignment;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.Id;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.types.Type;
import miniJAST.types.UnannType;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AssignExprTest {
    AssignExpr aE;
    Context c;
    Id id;
    Expression eT, eF;

    @BeforeMethod
    public void setUp() throws Exception {
        aE = new AssignExpr();
        c = new Context();
        c.namesToTypes.put("t", new Type(UnannType.BOOLEAN, 1));
        id = new Id();
        id.setUp(new Type(UnannType.BOOLEAN, 1), "t");
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
    public void testEq() throws Exception {
        aE.setUp(id, AssignOp.EQ, eT);
        aE.evaluate(c);
        Assert.assertTrue(((ReturnValuesBool)id.evaluate(c)).value);

        aE.setUp(id, AssignOp.EQ, eF);
        aE.evaluate(c);
        Assert.assertFalse(((ReturnValuesBool)id.evaluate(c)).value);
    }

    // TODO test other operators
    // TODO test arrays
}