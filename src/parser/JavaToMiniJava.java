package parser;

import antlrParser.MiniJavaLexer;
import antlrParser.MiniJavaParser;
import miniJAST.MiniJASTNode;
import miniJAST.expressions.Expression;
import miniJAST.statements.BlockStatement;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class JavaToMiniJava {
    MiniJavaASTBuilder builder = new MiniJavaASTBuilder();

    public MiniJASTNode makeAST(String input) {
        try {
            InputStream is = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
            ANTLRInputStream inputS = new ANTLRInputStream(is);
            MiniJavaLexer lexer = new MiniJavaLexer(inputS);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            MiniJavaParser parser = new MiniJavaParser(tokens);
            ParseTree tree = parser.entry(); // parse
            return builder.visit(tree);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public Expression makeExpr(String input) {
        try {
            InputStream is = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
            ANTLRInputStream inputS = new ANTLRInputStream(is);
            MiniJavaLexer lexer = new MiniJavaLexer(inputS);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            MiniJavaParser parser = new MiniJavaParser(tokens);
            ParseTree tree = parser.expression(); // parse
            return (Expression)builder.visit(tree);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public BlockStatement makeStmnt(String input) {
        try {
            InputStream is = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
            ANTLRInputStream inputS = new ANTLRInputStream(is);
            MiniJavaLexer lexer = new MiniJavaLexer(inputS);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            MiniJavaParser parser = new MiniJavaParser(tokens);
            ParseTree tree = parser.blockStatement(); // parse
            return (BlockStatement) builder.visit(tree);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
