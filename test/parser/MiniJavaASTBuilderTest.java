package parser;

import antlrParser.MiniJavaLexer;
import antlrParser.MiniJavaParser;
import miniJAST.Context;
import miniJAST.MiniJASTNode;
import miniJAST.exceptions.VariableNotInitException;
import miniJAST.expressions.Id;
import miniJAST.expressions.Literal;
import miniJAST.expressions.arrays.ArrayAccess;
import miniJAST.expressions.assignment.AssignExpr;
import miniJAST.expressions.returnValues.*;
import miniJAST.statements.Block;
import miniJAST.statements.LVD.LocalVarDec;
import miniJAST.types.Type;
import miniJAST.types.UnannType;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.testng.Assert.*;

public class MiniJavaASTBuilderTest {
    MiniJavaASTBuilder builder;
    InputStream is;
    ANTLRInputStream input;
    MiniJavaLexer lexer;
    CommonTokenStream tokens;
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
        is = new ByteArrayInputStream("int d; {int a = 1; d = a;}".getBytes(StandardCharsets.UTF_8));
        input = new ANTLRInputStream(is);
        lexer = new MiniJavaLexer(input);
        tokens = new CommonTokenStream(lexer);
        parser = new MiniJavaParser(tokens);
        tree = parser.block(); // parse
        result = builder.visit(tree);
        assertTrue(result instanceof Block);
        Block b = (Block) result;
        b.executeStart(c);

        Id d = new Id();
        d.setUpId("d");
        assertEquals(((ReturnValuesInt)d.evaluate(c)).value, 1);
    }

    @Test
    public void testVisitLiteral() throws Exception {
        is = new ByteArrayInputStream("true".getBytes(StandardCharsets.UTF_8));
        input = new ANTLRInputStream(is);
        lexer = new MiniJavaLexer(input);
        tokens = new CommonTokenStream(lexer);
        parser = new MiniJavaParser(tokens);
        tree = parser.literal(); // parse
        result = builder.visit(tree);
        assertTrue(result instanceof Literal);
        Literal l = (Literal)result;
        assertTrue(((ReturnValuesBool)l.evaluate(c)).value);

        is = new ByteArrayInputStream("'A'".getBytes(StandardCharsets.UTF_8));
        input = new ANTLRInputStream(is);
        lexer = new MiniJavaLexer(input);
        tokens = new CommonTokenStream(lexer);
        parser = new MiniJavaParser(tokens);
        tree = parser.literal(); // parse
        result = builder.visit(tree);
        assertTrue(result instanceof Literal);
        l = (Literal)result;
        assertEquals(((ReturnValuesChar)l.evaluate(c)).value, 'A');

        is = new ByteArrayInputStream("42".getBytes(StandardCharsets.UTF_8));
        input = new ANTLRInputStream(is);
        lexer = new MiniJavaLexer(input);
        tokens = new CommonTokenStream(lexer);
        parser = new MiniJavaParser(tokens);
        tree = parser.literal(); // parse
        result = builder.visit(tree);
        assertTrue(result instanceof Literal);
        l = (Literal)result;
        assertEquals(((ReturnValuesInt)l.evaluate(c)).value, 42);

        is = new ByteArrayInputStream("0.5".getBytes(StandardCharsets.UTF_8));
        input = new ANTLRInputStream(is);
        lexer = new MiniJavaLexer(input);
        tokens = new CommonTokenStream(lexer);
        parser = new MiniJavaParser(tokens);
        tree = parser.literal(); // parse
        result = builder.visit(tree);
        assertTrue(result instanceof Literal);
        l = (Literal)result;
        assertEquals(((ReturnValuesDouble)l.evaluate(c)).value, 0.5);
    }

    @Test
    public void testVisitArrayInitializerSize() throws Exception {
        is = new ByteArrayInputStream("int ar1[] = new int[2], ar2[] = new int[4];".getBytes(StandardCharsets.UTF_8));
        input = new ANTLRInputStream(is);
        lexer = new MiniJavaLexer(input);
        tokens = new CommonTokenStream(lexer);
        parser = new MiniJavaParser(tokens);
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
        is = new ByteArrayInputStream("boolean ar1[] = {true, false}, ar2[] = {false, true};".getBytes(StandardCharsets.UTF_8));
        input = new ANTLRInputStream(is);
        lexer = new MiniJavaLexer(input);
        tokens = new CommonTokenStream(lexer);
        parser = new MiniJavaParser(tokens);
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
        is = new ByteArrayInputStream("double half = 0.5, empty;".getBytes(StandardCharsets.UTF_8));
        input = new ANTLRInputStream(is);
        lexer = new MiniJavaLexer(input);
        tokens = new CommonTokenStream(lexer);
        parser = new MiniJavaParser(tokens);
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
    public void testVisitAssignExpr() throws Exception {
        c.namesToTypes.put("i", new Type(UnannType.INT));
        is = new ByteArrayInputStream("i = 3".getBytes(StandardCharsets.UTF_8));
        input = new ANTLRInputStream(is);
        lexer = new MiniJavaLexer(input);
        tokens = new CommonTokenStream(lexer);
        parser = new MiniJavaParser(tokens);
        tree = parser.expression(); // parse
        result = builder.visit(tree);
        assertTrue(result instanceof AssignExpr);
        AssignExpr aE = (AssignExpr) result;
        aE.evaluate(c);

        Id i = new Id();
        i.setUpId("i");
        assertEquals(((ReturnValuesInt)i.evaluate(c)).value, 3);

        is = new ByteArrayInputStream("i += 3".getBytes(StandardCharsets.UTF_8));
        input = new ANTLRInputStream(is);
        lexer = new MiniJavaLexer(input);
        tokens = new CommonTokenStream(lexer);
        parser = new MiniJavaParser(tokens);
        tree = parser.expression(); // parse
        result = builder.visit(tree);
        AssignExpr aE1 = (AssignExpr) result;
        aE1.evaluate(c);
        assertEquals(((ReturnValuesInt)i.evaluate(c)).value, 6);
    }


}