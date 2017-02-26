package parser;

import antlrParser.MiniJavaBaseVisitor;
import antlrParser.MiniJavaParser;
import miniJAST.MiniJASTNode;
import miniJAST.expressions.Literal;
import miniJAST.types.Type;
import miniJAST.types.UnannTypeCarrier;
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
        UnannTypeCarrier c;
        if (ctx.BOOLEAN() != null)
            c = new UnannTypeCarrier(UnannType.BOOLEAN);
        else if (ctx.CHAR() != null)
            c = new UnannTypeCarrier(UnannType.CHAR);
        else if (ctx.INT() != null)
            c = new UnannTypeCarrier(UnannType.INT);
        else // Double
            c = new UnannTypeCarrier(UnannType.DOUBLE);
        return c;
    }
}
