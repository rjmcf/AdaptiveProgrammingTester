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
import miniJAST.expressions.arrays.ArrayCreation;
import miniJAST.expressions.arrays.ArrayInit;
import miniJAST.expressions.assignment.AssignExpr;
import miniJAST.expressions.assignment.AssignOp;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesArray;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.expressions.returnValues.ReturnValuesInt;
import miniJAST.statements.LVD.LocalVarDec;
import miniJAST.statements.LVD.VarDeclarator;
import miniJAST.types.PrimType;
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
        t.setUpLiteral(PrimType.BOOLEAN, "true");
        f = new Literal();
        f.setUpLiteral(PrimType.BOOLEAN, "false");
        id = new Id();
    }

    @Test
    public void testSimpleExecute() throws Exception {
        VarDeclarator boolDec = new VarDeclarator();
        boolDec.setUpVarDec("bDec", false, null);
        VarDeclarator boolDef = new VarDeclarator();
        boolDef.setUpVarDec("bDef", false, t);
        VarDeclarator intDec1 = new VarDeclarator();
        intDec1.setUpVarDec("iDec1", false, null);
        VarDeclarator intDec2 = new VarDeclarator();
        intDec2.setUpVarDec("iDec2", false, null);
        Literal int2 = new Literal();
        int2.setUpLiteral(PrimType.INT, "2");
        VarDeclarator intDef1 = new VarDeclarator();
        intDef1.setUpVarDec("iDef1", false, int2);
        Literal int3 = new Literal();
        int3.setUpLiteral(PrimType.INT, "3");
        VarDeclarator intDef2 = new VarDeclarator();
        intDef2.setUpVarDec("iDef2", false, int3);
        AssignExpr aE = new AssignExpr();

        lvd = new LocalVarDec();
        lvd.setUpLVD(PrimType.BOOLEAN);
        lvd.addVarDec(boolDec);
        lvd.execute(c);
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
            lvd.execute(c);
            fail("bDec is already declared");
        } catch (VariableDecException vde) {
            // pass test
        }

        lvd = new LocalVarDec();
        lvd.setUpLVD(PrimType.BOOLEAN);
        lvd.addVarDec(boolDef);
        lvd.execute(c);
        id.setUpId("bDef");
        assertTrue(((ReturnValuesBool)id.evaluate(c)).value);

        lvd = new LocalVarDec();
        lvd.setUpLVD(PrimType.INT);
        lvd.addVarDec(intDec1);
        lvd.addVarDec(intDef1);
        lvd.addVarDec(intDec2);
        lvd.addVarDec(intDef2);
        lvd.execute(c);
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

        ArrayCreation aC = new ArrayCreation(PrimType.BOOLEAN, two);
        VarDeclarator vD = new VarDeclarator();
        vD.setUpVarDec("boolArray2", true, aC);

        lvd = new LocalVarDec();
        lvd.setUpLVD(PrimType.BOOLEAN);
        lvd.addVarDec(vD);
        lvd.execute(c);

        id.setUpId("boolArray2");
        ReturnValuesArray ar = (ReturnValuesArray)id.evaluate(c);

        aC = new ArrayCreation(PrimType.BOOLEAN, t);
        vD.setUpVarDec("boolArrayT", true, aC);

        lvd.setUpLVD(PrimType.BOOLEAN);
        lvd.addVarDec(vD);
        try {
            lvd.execute(c);
            fail("Size must be integer type");
        } catch (TypeException te) {
            // pass test
        }

        Literal one = new Literal();
        one.setUpLiteral(PrimType.INT, "1");
        ArrayCreation aC1 = new ArrayCreation(PrimType.BOOLEAN, one);
        vD.setUpVarDec("boolArray3", true, aC1);

        lvd = new LocalVarDec();
        lvd.setUpLVD(PrimType.BOOLEAN);
        lvd.addVarDec(vD);
        lvd.execute(c);

        Id id1 = new Id();
        id1.setUpId("boolArray3");
        ReturnValuesArray ar1 = (ReturnValuesArray)id1.evaluate(c);
    }

    @Test
    public void testArrayInitListExecute() throws Exception {
        ArrayInit aI = new ArrayInit();
        aI.addExpression(t);
        aI.addExpression(f);
        aI.addExpression(t);

        VarDeclarator vD = new VarDeclarator();
        vD.setUpVarDec("boolArray", true, aI);

        lvd = new LocalVarDec();
        lvd.setUpLVD(PrimType.BOOLEAN);
        lvd.addVarDec(vD);
        lvd.execute(c);

        id.setUpId("boolArray");
        ReturnValuesArray<Boolean> ar = (ReturnValuesArray)id.evaluate(c);
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
        two.setUpLiteral(PrimType.INT, "2");
        aI.addExpression(two);

        lvd = new LocalVarDec();
        lvd.setUpLVD(PrimType.BOOLEAN);
        lvd.addVarDec(vD);
        try {
            lvd.execute(c);
            fail("Types do not match");
        } catch (TypeException te) {
            // pass test
        }

        ArrayInit aI1 = new ArrayInit();
        aI1.addExpression(t);

        vD.setUpVarDec("boolArray1", true, aI1);

        lvd = new LocalVarDec();
        lvd.setUpLVD(PrimType.BOOLEAN);
        lvd.addVarDec(vD);
        lvd.execute(c);

        id.setUpId("boolArray1");
        ReturnValuesArray<Boolean> ar1 = (ReturnValuesArray)id.evaluate(c);
        assertTrue(ar1.get(0));
    }

    @Test
    public void testArrayNotInitialised() throws Exception {
        /* Code is:
        int i[], j[];
        i = new int[2];
        j = {1,2}; //Should fail
         */

        VarDeclarator iDec = new VarDeclarator(), jDec = new VarDeclarator();
        iDec.setUpVarDec("i", true, null);
        jDec.setUpVarDec("j", true, null);

        Id i = new Id(), j = new Id();
        i.setUpId("i"); j.setUpId("j");

        Literal two = new Literal(), one = new Literal();
        one.setUpLiteral(PrimType.INT, "1");
        two.setUpLiteral(PrimType.INT, "2");
        ArrayCreation aC = new ArrayCreation(PrimType.INT, two);
        ArrayInit aI = new ArrayInit();
        aI.addExpression(one);
        aI.addExpression(two);

        LocalVarDec lvd = new LocalVarDec();
        lvd.setUpLVD(PrimType.INT);
        lvd.addVarDec(iDec);
        lvd.addVarDec(jDec);
        lvd.execute(c);

        AssignExpr aE1 = new AssignExpr(), aE2 = new AssignExpr();
        aE1.setUpAssignExpr(i, AssignOp.EQ, aC);
        aE1.evaluate(c);
        ReturnValues rV = i.evaluate(c);
        assertTrue(rV.getIsArray());
        assertEquals(rV.getType().pType, PrimType.INT);

        aE2.setUpAssignExpr(j, AssignOp.EQ, aI);
        try {
            aE2.evaluate(c);
            fail("Array initialiser not allowed in assign expression");
        } catch (TypeException te) {
            //pass
        }
    }

    @Test
    public void testEmptyInitialiser() throws Exception {
        /* Code is:
        int i[] = {};
         */
        ArrayInit aI = new ArrayInit();
        VarDeclarator vD = new VarDeclarator();
        vD.setUpVarDec("i", true, aI);
        LocalVarDec lvd = new LocalVarDec();
        lvd.setUpLVD(PrimType.INT);
        lvd.addVarDec(vD);
        lvd.execute(c);

        Id i = new Id();
        i.setUpId("i");
        ReturnValues rV = i.evaluate(c);
        assertTrue(rV.getIsArray());
        assertEquals(rV.getType().pType, PrimType.INT);
    }
}