package miniJAST.statements;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.VariableNotInitException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.Id;
import miniJAST.expressions.Literal;
import miniJAST.expressions.assignment.AssignExpr;
import miniJAST.expressions.assignment.AssignOp;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.expressions.returnValues.ReturnValuesInt;
import miniJAST.types.Type;
import miniJAST.types.UnannType;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LocalVarDecTest {
    LocalVarDec lvd;
    Context c;
    VarDeclarator boolDec;
    Literal t;
    VarDeclarator boolDef;
    VarDeclarator intDec1;
    VarDeclarator intDec2;
    Literal int2;
    VarDeclarator intDef1;
    Literal int3;
    VarDeclarator intDef2;
    Id id;
    AssignExpr aE;
    Expression e;

    @BeforeMethod
    public void setUp() throws Exception {
        c = new Context();
        boolDec = new VarDeclarator();
        boolDec.setUp("bDec", null);
        boolDef = new VarDeclarator();
        t = new Literal();
        t.setUp(UnannType.BOOLEAN, "true");
        boolDef.setUp("bDef", t);
        intDec1 = new VarDeclarator();
        intDec1.setUp("iDec1", null);
        intDec2 = new VarDeclarator();
        intDec2.setUp("iDec2", null);
        int2 = new Literal();
        int2.setUp(UnannType.INT, "2");
        intDef1 = new VarDeclarator();
        intDef1.setUp("iDef1", int2);
        int3 = new Literal();
        int3.setUp(UnannType.INT, "3");
        intDef2 = new VarDeclarator();
        intDef2.setUp("iDef2", int3);
        id = new Id();
        aE = new AssignExpr();
    }

    @Test
    public void testSimpleExecute() throws Exception {
        lvd = new LocalVarDec();
        lvd.setUp(UnannType.BOOLEAN);
        lvd.addVarDec(boolDec);
        lvd.execute(c);
        id.setUp(new Type(UnannType.BOOLEAN, 1), "bDec");
        try {
            id.evaluate(c);
            fail("bDec should not be initialised");
        } catch (VariableNotInitException e) {
            // pass test
        }

        e = new Expression() {
            @Override
            public ReturnValues evaluate(Context c) throws MiniJASTException {
                return new ReturnValuesBool(true);
            }
        };
        aE.setUp(id, AssignOp.EQ, e);
        aE.evaluate(c);
        Assert.assertTrue(((ReturnValuesBool)id.evaluate(c)).value);

        lvd = new LocalVarDec();
        lvd.setUp(UnannType.BOOLEAN);
        lvd.addVarDec(boolDef);
        lvd.execute(c);
        id.setUp(new Type(UnannType.BOOLEAN,1), "bDef");
        Assert.assertTrue(((ReturnValuesBool)id.evaluate(c)).value);

        lvd = new LocalVarDec();
        lvd.setUp(UnannType.INT);
        lvd.addVarDec(intDec1);
        lvd.addVarDec(intDef1);
        lvd.addVarDec(intDec2);
        lvd.addVarDec(intDef2);
        lvd.execute(c);
        id.setUp(new Type(UnannType.INT, 1), "iDec1");
        try {
            id.evaluate(c);
            fail("iDec1 should not be initialised");
        } catch (VariableNotInitException e) {
            // pass test
        }
        id.setUp(new Type(UnannType.INT, 1), "iDef1");
        Assert.assertEquals(2, ((ReturnValuesInt)id.evaluate(c)).value);
        id.setUp(new Type(UnannType.INT, 1), "iDec2");
        try {
            id.evaluate(c);
            fail("iDec2 should not be initialised");
        } catch (VariableNotInitException e) {
            // pass test
        }
        id.setUp(new Type(UnannType.INT, 1), "iDef2");
        Assert.assertEquals(3, ((ReturnValuesInt)id.evaluate(c)).value);
    }

    // TODO test ArrayCreation
}