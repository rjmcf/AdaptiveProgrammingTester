package parser;

import miniJAST.MiniJASTNode;
import miniJAST.expressions.Literal;
import miniJAST.types.UnannType;
import parserClass.MiniJavaBaseVisitor;
import parserClass.MiniJavaParser;

public class MiniJavaASTBuilder extends MiniJavaBaseVisitor<MiniJASTNode> {
    @Override
    public MiniJASTNode visitLiteral(MiniJavaParser.LiteralContext ctx) {
        Literal l = new Literal();
        if (ctx.BooleanLiteral() != null) {
            l.setUpLiteral(UnannType.BOOLEAN, ctx.getText());
        } else if (ctx.CharacterLiteral() != null) {
            l.setUpLiteral(UnannType.CHAR, ctx.getText());
        } else if (ctx.IntegerLiteral() != null) {
            l.setUpLiteral(UnannType.INT, ctx.getText());
        } else /* Double */ {
            l.setUpLiteral(UnannType.DOUBLE, ctx.getText());
        }
        return l;
    }
}
