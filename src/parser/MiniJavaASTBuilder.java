package parser;

import antlrParser.MiniJavaBaseVisitor;
import antlrParser.MiniJavaParser;
import miniJAST.MiniJASTNode;
import miniJAST.expressions.Literal;
import miniJAST.types.Type;
import miniJAST.types.TypeCarrier;
import miniJAST.types.UnannType;

public class MiniJavaASTBuilder extends MiniJavaBaseVisitor<MiniJASTNode> {
    @Override
    public MiniJASTNode visitLiteral(MiniJavaParser.LiteralContext ctx) {
        Literal l = new Literal();
        if (ctx.BooleanLiteral() != null)
            l.setUpLiteral(UnannType.BOOLEAN, ctx.getText());
        else if (ctx.CharacterLiteral() != null)
            l.setUpLiteral(UnannType.CHAR, ctx.getText());
        else if (ctx.IntegerLiteral() != null)
            l.setUpLiteral(UnannType.INT, ctx.getText());
        else // Double
            l.setUpLiteral(UnannType.DOUBLE, ctx.getText());
        return l;
    }

    @Override
    public MiniJASTNode visitPrimitiveType(MiniJavaParser.PrimitiveTypeContext ctx) {
        TypeCarrier c;
        if (ctx.BOOLEAN() != null)
            c = new TypeCarrier(new Type(UnannType.BOOLEAN,1));
        else if (ctx.CHAR() != null)
            c = new TypeCarrier(new Type(UnannType.CHAR,1));
        else if (ctx.INT() != null)
            c = new TypeCarrier(new Type(UnannType.INT,1));
        else // Double
            c = new TypeCarrier(new Type(UnannType.DOUBLE,1));
        return c;
    }
}
