package parser;

import antlrParser.MiniJavaBaseVisitor;
import antlrParser.MiniJavaParser;
import miniJAST.MiniJASTNode;
import miniJAST.expressions.Expression;
import miniJAST.expressions.Literal;
import miniJAST.expressions.assignment.AssignExpr;
import miniJAST.expressions.assignment.AssignOp;
import miniJAST.statements.Block;
import miniJAST.statements.BlockStatement;
import miniJAST.statements.LVD.LocalVarDec;
import miniJAST.statements.LVD.VarDeclarator;
import miniJAST.statements.arrays.ArrayCreationWithInitList;
import miniJAST.statements.arrays.ArrayCreationWithSize;
import miniJAST.types.UnannTypeCarrier;
import miniJAST.types.UnannType;

public class MiniJavaASTBuilder extends MiniJavaBaseVisitor<MiniJASTNode> {

    @Override
    public MiniJASTNode visitFillBlock(MiniJavaParser.FillBlockContext ctx) {
        Block b = new Block(false);
        for (MiniJavaParser.BlockStatementContext c : ctx.blockStatement()) {
            BlockStatement bS = (BlockStatement)visit(c);
            b.addBlockStmnt(bS);
        }

        return b;
    }

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

    @Override
    public MiniJASTNode visitArrayInitializerSize(MiniJavaParser.ArrayInitializerSizeContext ctx) {
        ArrayCreationWithSize acws = new ArrayCreationWithSize();
        acws.setUpACWS(ctx.id, ((UnannTypeCarrier)visit(ctx.primitiveType())).type, (Expression)visit(ctx.expression()));
        return acws;
    }

    @Override
    public MiniJASTNode visitArrayInitializerValues(MiniJavaParser.ArrayInitializerValuesContext ctx) {
        ArrayCreationWithInitList acwil = new ArrayCreationWithInitList();
        acwil.setUPACWIL(ctx.id);
        for (MiniJavaParser.VariableInitializerContext c : ctx.variableInitializer()) {
            Expression e = (Expression)visit(c);
            acwil.addExpressionACWIL(e);
        }
        return acwil;
    }

    @Override
    public MiniJASTNode visitSingleVarDec(MiniJavaParser.SingleVarDecContext ctx) {
        VarDeclarator vD = new VarDeclarator();
        Expression e = ctx.variableInitializer() == null ? null : (Expression)visit(ctx.variableInitializer());
        vD.setUpVarDec(ctx.Identifier().getText(), e);
        return vD;
    }

    @Override
    public MiniJASTNode visitLocalVariableDeclaration(MiniJavaParser.LocalVariableDeclarationContext ctx) {
        LocalVarDec lvd = new LocalVarDec();
        lvd.setUpLVD(((UnannTypeCarrier)visit(ctx.primitiveType())).type);

        for (MiniJavaParser.VariableDeclaratorContext c : ctx.variableDeclarators().variableDeclarator()) {
            VarDeclarator vD = (VarDeclarator)visit(c);
            lvd.addVarDec(vD);
        }
        return lvd;
    }

    @Override
    public MiniJASTNode visitAssignExpr(MiniJavaParser.AssignExprContext ctx) {
        AssignExpr aE = new AssignExpr();
        AssignOp op;
        switch(ctx.op.getText()) {
            case "=":
                op = AssignOp.EQ;
                break;
            case "+=":
                op = AssignOp.PLUSEQ;
                break;
            case "-=":
                op = AssignOp.SUBEQ;
                break;
            case "*=":
                op = AssignOp.TIMESEQ;
                break;
            default: // /=
                op = AssignOp.DIVEQ;
        }
        aE.setUpAssignExpr((Expression)visit(ctx.expression(0)), op, (Expression)visit(ctx.expression(1)));

        return aE;
    }
}
