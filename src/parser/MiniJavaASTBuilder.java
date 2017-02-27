package parser;

import antlrParser.MiniJavaBaseVisitor;
import antlrParser.MiniJavaParser;
import miniJAST.MiniJASTNode;
import miniJAST.expressions.Expression;
import miniJAST.expressions.Id;
import miniJAST.expressions.Literal;
import miniJAST.expressions.arithExpr.AddExpr;
import miniJAST.expressions.arithExpr.MultExpr;
import miniJAST.expressions.arithExpr.UnaryPMExpr;
import miniJAST.expressions.arrays.ArrayAccess;
import miniJAST.expressions.assignment.AssignExpr;
import miniJAST.expressions.assignment.AssignOp;
import miniJAST.expressions.assignment.UnaryPostIncExpr;
import miniJAST.expressions.assignment.UnaryPreIncExpr;
import miniJAST.expressions.boolExpr.*;
import miniJAST.statements.*;
import miniJAST.statements.IfThenEtc.IfThenStmnt;
import miniJAST.statements.LVD.LocalVarDec;
import miniJAST.statements.LVD.VarDeclarator;
import miniJAST.statements.arrays.ArrayCreationWithInitList;
import miniJAST.statements.arrays.ArrayCreationWithSize;
import miniJAST.types.UnannTypeCarrier;
import miniJAST.types.UnannType;

public class MiniJavaASTBuilder extends MiniJavaBaseVisitor<MiniJASTNode> {

    @Override
    public MiniJASTNode visitBlock(MiniJavaParser.BlockContext ctx) {
        Block b = new Block(ctx.isOuter);
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
    public MiniJASTNode visitMakeID(MiniJavaParser.MakeIDContext ctx) {
        Id id = new Id();
        id.setUpId(ctx.Identifier().getText());
        return id;
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

    @Override
    public MiniJASTNode visitCondExpr(MiniJavaParser.CondExprContext ctx) {
        CondExpr cE = new CondExpr();
        cE.setUpCondExpr((Expression)visit(ctx.expression(0)), (Expression)visit(ctx.expression(1)), (Expression)visit(ctx.expression(2)));
        return cE;
    }

    @Override
    public MiniJASTNode visitOrExpr(MiniJavaParser.OrExprContext ctx) {
        OrExpr oE = new OrExpr();
        oE.setUpOrExpr((Expression)visit(ctx.expression(0)), (Expression)visit(ctx.expression(1)));
        return oE;
    }

    @Override
    public MiniJASTNode visitAndExpr(MiniJavaParser.AndExprContext ctx) {
        AndExpr aE = new AndExpr();
        aE.setUpAndExpr((Expression)visit(ctx.expression(0)), (Expression)visit(ctx.expression(1)));
        return aE;
    }

    @Override
    public MiniJASTNode visitEqExpr(MiniJavaParser.EqExprContext ctx) {
        EqExpr eE = new EqExpr();
        eE.setUpEqExpr(ctx.op.getText().equals("=="), (Expression)visit(ctx.expression(0)), (Expression)visit(ctx.expression(1)));
        return eE;
    }

    @Override
    public MiniJASTNode visitRelationalExpr(MiniJavaParser.RelationalExprContext ctx) {
        RelationExpr rE = new RelationExpr();
        RelationOp op;
        switch (ctx.op.getText()) {
            case "<":
                op = RelationOp.LT;
                break;
            case "<=":
                op = RelationOp.LTE;
                break;
            case ">":
                op = RelationOp.GT;
                break;
            default: // >=
                op = RelationOp.GTE;
        }

        rE.setUpRelationExpr(op, (Expression)visit(ctx.expression(0)), (Expression)visit(ctx.expression(1)));
        return rE;
    }

    @Override
    public MiniJASTNode visitAddExpr(MiniJavaParser.AddExprContext ctx) {
        AddExpr aE = new AddExpr();
        aE.setUpAddExpr(ctx.op.getText().equals("+"), (Expression)visit(ctx.expression(0)), (Expression)visit(ctx.expression(1)));
        return aE;
    }

    @Override
    public MiniJASTNode visitMultExpr(MiniJavaParser.MultExprContext ctx) {
        MultExpr mE = new MultExpr();
        mE.setUpMultExpr(ctx.op.getText().equals("*"), (Expression)visit(ctx.expression(0)), (Expression)visit(ctx.expression(1)));
        return mE;
    }

    @Override
    public MiniJASTNode visitMakeNot(MiniJavaParser.MakeNotContext ctx) {
        UnaryComplementExpr ucE = new UnaryComplementExpr();
        ucE.setUpCompExpr((Expression)visit(ctx.expression()));
        return ucE;
    }

    @Override
    public MiniJASTNode visitPreIncEtc(MiniJavaParser.PreIncEtcContext ctx) {
        boolean isAssign, isPlus;
        switch(ctx.op.getText()) {
            case "+":
                isAssign = false;
                isPlus = true;
                break;
            case "-":
                isAssign = false;
                isPlus = false;
                break;
            case "++":
                isAssign = true;
                isPlus = true;
                break;
            default: //--
                isAssign = true;
                isPlus = false;
        }

        if (isAssign) {
            UnaryPreIncExpr upiE = new UnaryPreIncExpr();
            upiE.setUpPreIncExpr(isPlus, (Expression)visit(ctx.expression()));
            return upiE;
        } else {
            UnaryPMExpr upE = new UnaryPMExpr();
            upE.setUpPMExpr(isPlus, (Expression)visit(ctx.expression()));
            return upE;
        }
    }

    @Override
    public MiniJASTNode visitPostInc(MiniJavaParser.PostIncContext ctx) {
        UnaryPostIncExpr upiE = new UnaryPostIncExpr();
        upiE.setUpPostIncExpr(ctx.op.getText().equals("++"), (Expression)visit(ctx.expression()));
        return upiE;
    }

    @Override
    public MiniJASTNode visitArrayAccess(MiniJavaParser.ArrayAccessContext ctx) {
        ArrayAccess aa = new ArrayAccess();
        aa.setUpArrayAccess((Expression)visit(ctx.expression(0)), (Expression)visit(ctx.expression(1)));
        return aa;
    }

    @Override
    public MiniJASTNode visitExpressionStatement(MiniJavaParser.ExpressionStatementContext ctx) {
        return new ExpressionStmnt((Expression)visit(ctx.expression()));
    }

    @Override
    public MiniJASTNode visitReturn(MiniJavaParser.ReturnContext ctx) {
        return SingleWordStmnt.RETURN;
    }

    @Override
    public MiniJASTNode visitReturnNSI(MiniJavaParser.ReturnNSIContext ctx) {
        return SingleWordStmnt.RETURN;
    }

    @Override
    public MiniJASTNode visitBreak(MiniJavaParser.BreakContext ctx) {
        return SingleWordStmnt.BREAK;
    }

    @Override
    public MiniJASTNode visitBreakNSI(MiniJavaParser.BreakNSIContext ctx) {
        return SingleWordStmnt.BREAK;
    }

    @Override
    public MiniJASTNode visitContinue(MiniJavaParser.ContinueContext ctx) {
        return SingleWordStmnt.CONTINUE;
    }

    @Override
    public MiniJASTNode visitContinueNSI(MiniJavaParser.ContinueNSIContext ctx) {
        return SingleWordStmnt.CONTINUE;
    }

    @Override
    public MiniJASTNode visitEmpty(MiniJavaParser.EmptyContext ctx) {
        return SingleWordStmnt.EMPTY;
    }

    @Override
    public MiniJASTNode visitEmptyNSI(MiniJavaParser.EmptyNSIContext ctx) {
        return SingleWordStmnt.EMPTY;
    }
}
