package parser;

import antlrParser.MiniJavaLexer;
import antlrParser.MiniJavaParser;
import miniJAST.Context;
import miniJAST.MiniJASTNode;
import miniJAST.exceptions.VariableNotInitException;
import miniJAST.expressions.Id;
import miniJAST.expressions.Literal;
import miniJAST.expressions.assignment.AssignExpr;
import miniJAST.expressions.returnValues.*;
import miniJAST.statements.Block;
import miniJAST.statements.DoAndWhileLoops.DoStmnt;
import miniJAST.statements.DoAndWhileLoops.WhileStmnt;
import miniJAST.statements.ForLoops.ForStmnt;
import miniJAST.statements.ForLoops.ForStmntNoShortIf;
import miniJAST.statements.IfThenEtc.IfThenElseStmnt;
import miniJAST.statements.IfThenEtc.IfThenElseStmntNoShortIf;
import miniJAST.statements.IfThenEtc.IfThenStmnt;
import miniJAST.statements.LVD.LocalVarDec;
import miniJAST.types.Type;
import miniJAST.types.PrimType;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import static org.testng.Assert.*;

public class MiniJavaASTBuilderTest {
    MiniJavaASTBuilder builder;
    MiniJavaParser parser;
    ParseTree tree;
    MiniJASTNode result;
    Context c;

    @BeforeMethod
    public void setUp() throws Exception {
        builder = new MiniJavaASTBuilder();
        c = new Context();
    }

    @Test
    public void testVisitBlock() throws Exception {
        parser = getParser("{ int i = 42; boolean t = true; }");
        tree = parser.entry(); // parse
        result = builder.visit(tree);
        assertTrue(result instanceof Block);
        Block b = (Block)result;
        b.executeStart(c);

        Id i = new Id(), t = new Id();
        i.setUpId("i"); t.setUpId("t");
        assertEquals(((ReturnValuesInt)i.evaluate(c)).value, 42);
        assertTrue(((ReturnValuesBool)t.evaluate(c)).value);
    }

    @Test
    public void testVisitLiteral() throws Exception {
        parser = getParser("true");
        tree = parser.literal(); // parse
        result = builder.visit(tree);
        assertTrue(result instanceof Literal);
        Literal l = (Literal)result;
        assertTrue(((ReturnValuesBool)l.evaluate(c)).value);

        parser = getParser("'A'");
        tree = parser.literal(); // parse
        result = builder.visit(tree);
        assertTrue(result instanceof Literal);
        l = (Literal)result;
        assertEquals(((ReturnValuesChar)l.evaluate(c)).value, 'A');

        parser = getParser("42");
        tree = parser.literal(); // parse
        result = builder.visit(tree);
        assertTrue(result instanceof Literal);
        l = (Literal)result;
        assertEquals(((ReturnValuesInt)l.evaluate(c)).value, 42);

        parser = getParser("0.5");
        tree = parser.literal(); // parse
        result = builder.visit(tree);
        assertTrue(result instanceof Literal);
        l = (Literal)result;
        assertEquals(((ReturnValuesDouble)l.evaluate(c)).value, 0.5);
    }

    @Test
    public void testVisitArrayInitializerSize() throws Exception {
        parser = getParser("int ar1[] = new int[2], ar2[] = new int[4];");
        tree = parser.blockStatement(); // parse
        result = builder.visit(tree);

        assertTrue(result instanceof LocalVarDec);
        LocalVarDec lvd = (LocalVarDec) result;
        lvd.executeStart(c);

        Id ar1 = new Id();
        ar1.setUpId("ar1");
        ReturnValuesArray<Integer> rva1 = (ReturnValuesArray<Integer>)ar1.evaluate(c);
        assertEquals(rva1.getSize(), 2);
        assertEquals((int)rva1.get(0), 0);

        Id ar2 = new Id();
        ar2.setUpId("ar2");
        ReturnValuesArray<Integer> rva2 = (ReturnValuesArray<Integer>)ar2.evaluate(c);
        assertEquals(rva2.getSize(), 4);
        assertEquals((int)rva2.get(0), 0);
    }

    @Test
    public void testVisitArrayInitializerValues() throws Exception {
        parser = getParser("boolean ar1[] = {true, false}, ar2[] = {false, true};");
        tree = parser.blockStatement(); // parse
        result = builder.visit(tree);

        assertTrue(result instanceof LocalVarDec);
        LocalVarDec lvd = (LocalVarDec) result;
        lvd.executeStart(c);

        Id ar1 = new Id();
        ar1.setUpId("ar1");
        ReturnValuesArray<Boolean> rva1 = (ReturnValuesArray<Boolean>)ar1.evaluate(c);
        assertEquals(rva1.getSize(), 2);
        assertTrue(rva1.get(0));
        assertFalse(rva1.get(1));

        Id ar2 = new Id();
        ar2.setUpId("ar2");
        ReturnValuesArray<Boolean> rva2 = (ReturnValuesArray<Boolean>)ar2.evaluate(c);
        assertEquals(rva2.getSize(), 2);
        assertFalse(rva2.get(0));
        assertTrue(rva2.get(1));
    }

    @Test
    public void testVisitSingleVarDec() throws Exception {
        parser = getParser("double half = 0.5, empty;");
        tree = parser.blockStatement(); // parse
        result = builder.visit(tree);

        assertTrue(result instanceof LocalVarDec);
        LocalVarDec lvd = (LocalVarDec) result;
        lvd.executeStart(c);

        Id half = new Id();
        half.setUpId("half");
        ReturnValuesDouble rvd = (ReturnValuesDouble)half.evaluate(c);
        assertEquals(rvd.value, 0.5);

        Id empty = new Id();
        empty.setUpId("empty");
        try {
            ReturnValuesDouble rvd2 = (ReturnValuesDouble) empty.evaluate(c);
            fail("Id not actually defined");
        } catch (VariableNotInitException e) {
            //pass
        }
    }

    @Test
    public void testVisitMakeID() throws Exception {
        c.namesToTypes.put("i", new Type(PrimType.INT));
        parser = getParser("i");
        tree = parser.expression(); // parse
        result = builder.visit(tree);
        assertTrue(result instanceof Id);
        Id i1 = (Id) result;

        try {
            i1.evaluate(c);
            fail("i is not initialised");
        } catch (VariableNotInitException e) {
            // pass
        }
        c.namesToValues.put("i", 2);
        assertEquals(((ReturnValuesInt)i1.evaluate(c)).value, 2);

        c.namesToTypes.put("ar", new Type(PrimType.INT, 2));
        ArrayList<Integer> ar = new ArrayList<>(2);
        ar.add(42);
        ar.add(17);
        c.namesToValues.put("ar", ar);
        parser = getParser("ar");
        tree = parser.expression(); // parse
        result = builder.visit(tree);
        assertTrue(result instanceof Id);
        Id i2 = (Id) result;
        assertEquals(((ReturnValuesArray<Integer>)i2.evaluate(c)).getSize(), 2);
        assertEquals((int)((ReturnValuesArray<Integer>)i2.evaluate(c)).get(0), 42);
        assertEquals((int)((ReturnValuesArray<Integer>)i2.evaluate(c)).get(1), 17);
    }

    @Test
    public void testVisitAssignExpr() throws Exception {
        c.namesToTypes.put("i", new Type(PrimType.INT));
        parser = getParser("i = 3");
        tree = parser.expression(); // parse
        result = builder.visit(tree);
        assertTrue(result instanceof AssignExpr);
        AssignExpr aE = (AssignExpr) result;
        aE.evaluate(c);

        Id i = new Id();
        i.setUpId("i");
        assertEquals(((ReturnValuesInt)i.evaluate(c)).value, 3);

        parser = getParser("i += 3");
        tree = parser.expression(); // parse
        result = builder.visit(tree);
        AssignExpr aE1 = (AssignExpr) result;
        aE1.evaluate(c);
        assertEquals(((ReturnValuesInt)i.evaluate(c)).value, 6);
    }

    @Test
    public void testExpressions() throws Exception {
        BufferedReader bR = new BufferedReader(new FileReader("test/parser/exprTestInput.txt"));
        parser = getParser(bR.readLine());
        tree = parser.blockStatement();
        result = builder.visit(tree);
        assertTrue(result instanceof LocalVarDec);
        LocalVarDec lvd = (LocalVarDec) result;
        lvd.executeStart(c);
        Id id = new Id();
        id.setUpId("t");
        assertTrue(((ReturnValuesBool)id.evaluate(c)).value);

        parser = getParser(bR.readLine());
        tree = parser.entry();
        result = builder.visit(tree);
        assertTrue(result instanceof Block);
        Block b = (Block) result;
        b.executeStart(c);
        id.setUpId("a");
        assertEquals(((ReturnValuesInt)id.evaluate(c)).value, 2);

        parser = getParser(bR.readLine());
        tree = parser.entry();
        result = builder.visit(tree);
        assertTrue(result instanceof Block);
        b = (Block) result;
        b.executeStart(c);
        id.setUpId("i");
        assertEquals(((ReturnValuesInt)id.evaluate(c)).value, 5);
        id.setUpId("j");
        assertEquals(((ReturnValuesInt)id.evaluate(c)).value, 4);

        parser = getParser(bR.readLine());
        tree = parser.entry();
        result = builder.visit(tree);
        assertTrue(result instanceof Block);
        b = (Block) result;
        b.executeStart(c);
        id.setUpId("l");
        assertEquals(((ReturnValuesInt)id.evaluate(c)).value, 3);
        id.setUpId("k");
        assertEquals(((ReturnValuesInt)id.evaluate(c)).value, 3);

        parser = getParser(bR.readLine());
        tree = parser.entry();
        result = builder.visit(tree);
        assertTrue(result instanceof Block);
        b = (Block) result;
        b.executeStart(c);
        id.setUpId("n");
        assertEquals(((ReturnValuesInt)id.evaluate(c)).value, -2);

        parser = getParser(bR.readLine());
        tree = parser.blockStatement();
        result = builder.visit(tree);
        assertTrue(result instanceof LocalVarDec);
        lvd = (LocalVarDec) result;
        lvd.executeStart(c);
        id.setUpId("f");
        assertTrue(((ReturnValuesBool)id.evaluate(c)).value);

        parser = getParser(bR.readLine());
        tree = parser.blockStatement();
        result = builder.visit(tree);
        assertTrue(result instanceof LocalVarDec);
        lvd = (LocalVarDec) result;
        lvd.executeStart(c);
        id.setUpId("x");
        assertEquals(((ReturnValuesInt)id.evaluate(c)).value, 6);

        parser = getParser(bR.readLine());
        tree = parser.blockStatement();
        result = builder.visit(tree);
        assertTrue(result instanceof LocalVarDec);
        lvd = (LocalVarDec) result;
        lvd.executeStart(c);
        id.setUpId("y");
        assertEquals(((ReturnValuesInt)id.evaluate(c)).value, -1);

        parser = getParser(bR.readLine());
        tree = parser.blockStatement();
        result = builder.visit(tree);
        assertTrue(result instanceof LocalVarDec);
        lvd = (LocalVarDec) result;
        lvd.executeStart(c);
        id.setUpId("g");
        assertTrue(((ReturnValuesBool)id.evaluate(c)).value);

        parser = getParser(bR.readLine());
        tree = parser.blockStatement();
        result = builder.visit(tree);
        assertTrue(result instanceof LocalVarDec);
        lvd = (LocalVarDec) result;
        lvd.executeStart(c);
        id.setUpId("e");
        assertTrue(((ReturnValuesBool)id.evaluate(c)).value);

        parser = getParser(bR.readLine());
        tree = parser.blockStatement();
        result = builder.visit(tree);
        assertTrue(result instanceof LocalVarDec);
        lvd = (LocalVarDec) result;
        lvd.executeStart(c);
        id.setUpId("c");
        assertFalse(((ReturnValuesBool)id.evaluate(c)).value);

        parser = getParser(bR.readLine());
        tree = parser.blockStatement();
        result = builder.visit(tree);
        assertTrue(result instanceof LocalVarDec);
        lvd = (LocalVarDec) result;
        lvd.executeStart(c);
        id.setUpId("d");
        assertTrue(((ReturnValuesBool)id.evaluate(c)).value);

        parser = getParser(bR.readLine());
        tree = parser.blockStatement();
        result = builder.visit(tree);
        assertTrue(result instanceof LocalVarDec);
        lvd = (LocalVarDec) result;
        lvd.executeStart(c);
        id.setUpId("cond");
        assertEquals(((ReturnValuesInt)id.evaluate(c)).value, 1);
    }

    @Test
    public void testIfs() throws Exception {
        parser = getParser("if (true) ;");
        tree = parser.statement(); // parse
        result = builder.visit(tree);
        assertTrue(result instanceof IfThenStmnt);

        parser = getParser("if (true) ; else break;");
        tree = parser.statement(); // parse
        result = builder.visit(tree);
        assertTrue(result instanceof IfThenElseStmnt);

        parser = getParser("if (true) continue; else return;");
        tree = parser.statementNSI(); // parse
        result = builder.visit(tree);
        assertTrue(result instanceof IfThenElseStmntNoShortIf);
    }

    @Test
    public void testFors() throws Exception {
        parser = getParser("for (int i = 0; i < 10; i++) ;");
        tree = parser.statement(); // parse
        result = builder.visit(tree);
        assertTrue(result instanceof ForStmnt);

        parser = getParser("for (int i = 0; i < 10; i++) ;");
        tree = parser.statementNSI(); // parse
        result = builder.visit(tree);
        assertTrue(result instanceof ForStmntNoShortIf);
    }

    @Test
    public void testWhiles() throws Exception {
        parser = getParser("while (true) ;");
        tree = parser.statement(); // parse
        result = builder.visit(tree);
        assertTrue(result instanceof WhileStmnt);
    }

    @Test
    public void testVisitDo() throws Exception {
        parser = getParser("do ; while (true);");
        tree = parser.statement(); // parse
        result = builder.visit(tree);
        assertTrue(result instanceof DoStmnt);

        parser = getParser("do ; while (true);");
        tree = parser.statementNSI(); // parse
        result = builder.visit(tree);
        assertTrue(result instanceof DoStmnt);
    }

    @Test
    public void testInput() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("test/parser/testInput.txt"));
        StringBuilder s = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            s.append(line);
        }
        parser = getParser(s.toString());
        tree = parser.entry(); // parse
        result = builder.visit(tree);
        assertTrue(result instanceof Block);
        Block b = (Block)result;

        b.executeStart(c);
        Id nsID = new Id();
        nsID.setUpId("ns");
        ReturnValuesArray<Integer> result = (ReturnValuesArray) nsID.evaluate(c);
        for (int i = 0; i < 5; i++) {
            if (result.get(i) != i)
                fail("Incorrect values");
        }
    }

    private MiniJavaParser getParser(String s) throws Exception {
        InputStream is = new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
        ANTLRInputStream input = new ANTLRInputStream(is);
        MiniJavaLexer lexer = new MiniJavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new MiniJavaParser(tokens);
    }
}