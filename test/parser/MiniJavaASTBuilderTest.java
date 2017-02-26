package parser;

import antlrParser.MiniJavaLexer;
import antlrParser.MiniJavaParser;
import miniJAST.Context;
import miniJAST.MiniJASTNode;
import miniJAST.expressions.Literal;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.expressions.returnValues.ReturnValuesChar;
import miniJAST.expressions.returnValues.ReturnValuesDouble;
import miniJAST.expressions.returnValues.ReturnValuesInt;
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


}