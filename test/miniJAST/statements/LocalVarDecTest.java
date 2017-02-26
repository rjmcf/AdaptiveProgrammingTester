package miniJAST.statements;

import miniJAST.Context;
import miniJAST.MiniJASTNode;
import miniJAST.NodeCount;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.exceptions.VariableDecException;
import miniJAST.exceptions.VariableNotInitException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.Id;
import miniJAST.expressions.Literal;
import miniJAST.expressions.assignment.AssignExpr;
import miniJAST.expressions.assignment.AssignOp;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesArray;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.expressions.returnValues.ReturnValuesInt;
import miniJAST.statements.LVD.LocalVarDec;
import miniJAST.statements.LVD.VarDeclarator;
import miniJAST.statements.arrays.ArrayCreationWithInitList;
import miniJAST.statements.arrays.ArrayCreationWithSize;
import miniJAST.types.Type;
import miniJAST.types.UnannType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class LocalVarDecTest {
    LocalVarDec lvd;
    Context c;
    Literal t, f;
    Id id;

    @BeforeMethod
    public void setUp() throws Exception {
        c = new Context();
        t = new Literal();
        t.setUpLiteral(UnannType.BOOLEAN, "true");
        f = new Literal();
        f.setUpLiteral(UnannType.BOOLEAN, "false");
        id = new Id();
    }

    @Test
    public void testSimpleExecute() throws Exception {
        VarDeclarator boolDec = new VarDeclarator();
        boolDec.setUpVarDec("bDec", null);
        VarDeclarator boolDef = new VarDeclarator();
        boolDef.setUpVarDec("bDef", t);
        VarDeclarator intDec1 = new VarDeclarator();
        intDec1.setUpVarDec("iDec1", null);
        VarDeclarator intDec2 = new VarDeclarator();
        intDec2.setUpVarDec("iDec2", null);
        Literal int2 = new Literal();
        int2.setUpLiteral(UnannType.INT, "2");
        VarDeclarator intDef1 = new VarDeclarator();
        intDef1.setUpVarDec("iDef1", int2);
        Literal int3 = new Literal();
        int3.setUpLiteral(UnannType.INT, "3");
        VarDeclarator intDef2 = new VarDeclarator();
        intDef2.setUpVarDec("iDef2", int3);
        AssignExpr aE = new AssignExpr();

        lvd = new LocalVarDec();
        lvd.setUpLVD(UnannType.BOOLEAN);
        lvd.addVarDec(boolDec);
        lvd.execute(c, 0);
        id.setUpId("bDec");
        try {
            id.evaluate(c);
            fail("bDec should not be initialised");
        } catch (VariableNotInitException e) {
            // pass test
        }

        Expression e = new Expression() {
            @Override
            public ReturnValues evaluate(Context c) throws MiniJASTException {
                return new ReturnValuesBool(true);
            }

            @Override
            public boolean getIsLeaf() { return false; }

            @Override
            public boolean getIsMarked() { return false; }

            @Override
            public void setMarked(boolean b) { }

            @Override
            public void setIsLeaf(boolean b) { }

            @Override
            public ArrayList<? extends MiniJASTNode> getSubNodes() { return null; }

            @Override
            public NodeCount getTreeSize() {
                return new NodeCount(1,0);
            }

            @Override
            public String stringRepr() {
                return "true";
            }
        };
        aE.setUpAssignExpr(id, AssignOp.EQ, e);
        aE.evaluate(c);
        assertTrue(((ReturnValuesBool)id.evaluate(c)).value);

        try {
            lvd.execute(c, 0);
            fail("bDec is already declared");
        } catch (VariableDecException vde) {
            // pass test
        }

        lvd = new LocalVarDec();
        lvd.setUpLVD(UnannType.BOOLEAN);
        lvd.addVarDec(boolDef);
        lvd.execute(c, 0);
        id.setUpId("bDef");
        assertTrue(((ReturnValuesBool)id.evaluate(c)).value);

        lvd = new LocalVarDec();
        lvd.setUpLVD(UnannType.INT);
        lvd.addVarDec(intDec1);
        lvd.addVarDec(intDef1);
        lvd.addVarDec(intDec2);
        lvd.addVarDec(intDef2);
        lvd.execute(c, 0);
        id.setUpId("iDec1");
        try {
            id.evaluate(c);
            fail("iDec1 should not be initialised");
        } catch (VariableNotInitException vnie) {
            // pass test
        }
        id.setUpId("iDef1");
        assertEquals(2, ((ReturnValuesInt)id.evaluate(c)).value);
        id.setUpId("iDec2");
        try {
            id.evaluate(c);
            fail("iDec2 should not be initialised");
        } catch (VariableNotInitException vnie) {
            // pass test
        }
        id.setUpId("iDef2");
        assertEquals(3, ((ReturnValuesInt)id.evaluate(c)).value);
    }

    @Test
    public void testArraySizeExecute() throws Exception {
        Expression two = new Expression() {
            @Override
            public ReturnValues evaluate(Context c) throws MiniJASTException {
                return new ReturnValuesInt(2);
            }

            @Override
            public boolean getIsLeaf() { return false; }

            @Override
            public boolean getIsMarked() { return false; }

            @Override
            public void setMarked(boolean b) { }

            @Override
            public void setIsLeaf(boolean b) { }

            @Override
            public ArrayList<? extends MiniJASTNode> getSubNodes() { return null; }

            @Override
            public NodeCount getTreeSize() {
                return new NodeCount(1,0);
            }

            @Override
            public String stringRepr() {
                return "2";
            }
        };

        ArrayCreationWithSize aCSize = new ArrayCreationWithSize();
        aCSize.setUpACWS("boolArray2", UnannType.BOOLEAN, two);

        lvd = new LocalVarDec();
        lvd.setUpLVD(UnannType.BOOLEAN);
        lvd.addVarDec(aCSize);
        lvd.execute(c, 0);

        id.setUpId("boolArray2");
        ReturnValuesArray ar = (ReturnValuesArray)id.evaluate(c);

        assertEquals(2, ar.getType().size);

        aCSize.setUpACWS("boolArrayT", UnannType.BOOLEAN, t);

        lvd.setUpLVD(UnannType.BOOLEAN);
        lvd.addVarDec(aCSize);
        try {
            lvd.execute(c, 0);
            fail("Size must be integer type");
        } catch (TypeException te) {
            // pass test
        }

        Literal one = new Literal();
        one.setUpLiteral(UnannType.INT, "1");
        ArrayCreationWithSize aCSize1 = new ArrayCreationWithSize();
        aCSize1.setUpACWS("boolArray3", UnannType.BOOLEAN, one);

        lvd = new LocalVarDec();
        lvd.setUpLVD(UnannType.BOOLEAN);
        lvd.addVarDec(aCSize1);
        lvd.execute(c, 0);

        Id id1 = new Id();
        id1.setUpId("boolArray3");
        ReturnValuesArray ar1 = (ReturnValuesArray)id1.evaluate(c);

        assertEquals(ar1.getType().size, 1);
    }

    @Test
    public void testArrayInitListExecute() throws Exception {
        ArrayCreationWithInitList aCWIL = new ArrayCreationWithInitList();
        aCWIL.setUPACWIL("boolArray");
        aCWIL.addExpressionACWIL(t);
        aCWIL.addExpressionACWIL(f);
        aCWIL.addExpressionACWIL(t);

        lvd = new LocalVarDec();
        lvd.setUpLVD(UnannType.BOOLEAN);
        lvd.addVarDec(aCWIL);
        lvd.executeStart(c);

        id.setUpId("boolArray");
        ReturnValuesArray<Boolean> ar = (ReturnValuesArray)id.evaluate(c);

        assertEquals(3, ar.getType().size);
        assertTrue(ar.get(0));
        assertFalse(ar.get(1));
        assertTrue(ar.get(2));

        try {
            ar.get(3);
            fail("Array access out of bounds");
        } catch (IndexOutOfBoundsException ex) {
            // pass test
        }

        c = new Context();
        Literal two = new Literal();
        two.setUpLiteral(UnannType.INT, "2");
        aCWIL.addExpressionACWIL(two);

        lvd = new LocalVarDec();
        lvd.setUpLVD(UnannType.BOOLEAN);
        lvd.addVarDec(aCWIL);
        try {
            lvd.executeStart(c);
            fail("Types do not match");
        } catch (TypeException te) {
            // pass test
        }

        ArrayCreationWithInitList aCWIL1 = new ArrayCreationWithInitList();
        aCWIL1.setUPACWIL("boolArray1");
        aCWIL1.addExpressionACWIL(t);

        lvd = new LocalVarDec();
        lvd.setUpLVD(UnannType.BOOLEAN);
        lvd.addVarDec(aCWIL1);
        lvd.executeStart(c);

        id.setUpId("boolArray1");
        ReturnValuesArray<Boolean> ar1 = (ReturnValuesArray)id.evaluate(c);

        assertEquals(1, ar1.getType().size);
        assertTrue(ar1.get(0));
    }
}