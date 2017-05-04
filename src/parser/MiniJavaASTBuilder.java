package parser;

import antlrParser.MiniJavaBaseVisitor;
import antlrParser.MiniJavaParser;
import miniJAST.MiniJASTNode;
import miniJAST.expressions.Expression;
import miniJAST.expressions.FillableBlankExpr;
import miniJAST.expressions.Id;
import miniJAST.expressions.Literal;
import miniJAST.expressions.arithExpr.AddExpr;
import miniJAST.expressions.arithExpr.MultExpr;
import miniJAST.expressions.arithExpr.UnaryPMExpr;
import miniJAST.expressions.arrays.ArrayAccess;
import miniJAST.expressions.arrays.ArrayCreation;
import miniJAST.expressions.arrays.ArrayInit;
import miniJAST.expressions.assignment.AssignExpr;
import miniJAST.expressions.assignment.AssignOp;
import miniJAST.expressions.assignment.UnaryPostIncExpr;
import miniJAST.expressions.assignment.UnaryPreIncExpr;
import miniJAST.expressions.boolExpr.*;
import miniJAST.statements.*;
import miniJAST.statements.DoAndWhileLoops.DoStmnt;
import miniJAST.statements.DoAndWhileLoops.WhileStmnt;
import miniJAST.statements.ForLoops.ForInit;
import miniJAST.statements.ForLoops.ForStmnt;
import miniJAST.statements.IfThenEtc.IfThenElseStmnt;
import miniJAST.statements.IfThenEtc.IfThenStmnt;
import miniJAST.statements.LVD.LocalVarDec;
import miniJAST.statements.LVD.VarDeclarator;
import miniJAST.types.PrimTypeCarrier;
import miniJAST.types.PrimType;

public class MiniJavaASTBuilder extends MiniJavaBaseVisitor<MiniJASTNode> {

    @Override
    public MiniJASTNode visitBlankBlock(MiniJavaParser.BlankBlockContext ctx) {
        return new FillableBlankStmnt(0);
    }

    @Override
    public MiniJASTNode visitBlankStmnt(MiniJavaParser.BlankStmntContext ctx) {
        return new FillableBlankStmnt(0);
    }

    @Override
    public MiniJASTNode visitBlankStmntNSI(MiniJavaParser.BlankStmntNSIContext ctx) {
        return new FillableBlankStmnt(0);
    }

    @Override
    public MiniJASTNode visitBlankExpr(MiniJavaParser.BlankExprContext ctx) {
        return new FillableBlankExpr(0);
    }

    @Override
    public MiniJASTNode visitBlankVarDec(MiniJavaParser.BlankVarDecContext ctx) {
        return new FillableBlankStmnt(0);
    }

    @Override
    public MiniJASTNode visitBlock(MiniJavaParser.BlockContext ctx) {
        Block b = new Block(ctx.isOuter);
        for (MiniJavaParser.BlockStatementContext c : ctx.blockStatement()) {
            Statement bS = (Statement)visit(c);
            b.addBlockStmnt(bS);
        }

        return b;
    }

    @Override
    public MiniJASTNode visitBlockStatementsEntry(MiniJavaParser.BlockStatementsEntryContext ctx) {
        Block b = new Block(true);
        for (MiniJavaParser.BlockStatementContext c : ctx.blockStatement()) {
            Statement bS = (Statement)visit(c);
            b.addBlockStmnt(bS);
        }

        return b;
    }

    @Override
    public MiniJASTNode visitLiteral(MiniJavaParser.LiteralContext ctx) {
        Literal l = new Literal();
        if (ctx.BooleanLiteral() != null)
            l.setUpLiteral(PrimType.BOOLEAN, ctx.getText());
        else if (ctx.CharacterLiteral() != null)
            l.setUpLiteral(PrimType.CHAR, ctx.getText());
        else if (ctx.IntegerLiteral() != null)
            l.setUpLiteral(PrimType.INT, ctx.getText());
        else // Double
            l.setUpLiteral(PrimType.DOUBLE, ctx.getText());
        return l;
    }

    @Override
    public MiniJASTNode visitPrimitiveType(MiniJavaParser.PrimitiveTypeContext ctx) {
        PrimTypeCarrier c;
        if (ctx.BOOLEAN() != null)
            c = new PrimTypeCarrier(PrimType.BOOLEAN);
        else if (ctx.CHAR() != null)
            c = new PrimTypeCarrier(PrimType.CHAR);
        else if (ctx.INT() != null)
            c = new PrimTypeCarrier(PrimType.INT);
        else // Double
            c = new PrimTypeCarrier(PrimType.DOUBLE);
        return c;
    }

    @Override
    public MiniJASTNode visitArrayInitializerSize(MiniJavaParser.ArrayInitializerSizeContext ctx) {
        ArrayCreation aC = new ArrayCreation(((PrimTypeCarrier)visit(ctx.primitiveType())).type, (Expression)visit(ctx.expression()));
        return aC;
    }

    @Override
    public MiniJASTNode visitArrayInitializerValues(MiniJavaParser.ArrayInitializerValuesContext ctx) {
        ArrayInit aI = new ArrayInit();
        for (MiniJavaParser.VariableInitializerContext c : ctx.variableInitializer()) {
            Expression e = (Expression)visit(c);
            aI.addExpression(e);
        }
        return aI;
    }

    @Override
    public MiniJASTNode visitArrayVarDec(MiniJavaParser.ArrayVarDecContext ctx) {
        VarDeclarator vD = new VarDeclarator();
        Expression e = ctx.variableInitializer() == null ? null : (Expression)visit(ctx.variableInitializer());
        vD.setUpVarDec(ctx.Identifier().getText(), true, e);
        return vD;
    }

    @Override
    public MiniJASTNode visitSingleVarDec(MiniJavaParser.SingleVarDecContext ctx) {
        VarDeclarator vD = new VarDeclarator();
        Expression e = ctx.variableInitializer() == null ? null : (Expression)visit(ctx.variableInitializer());
        vD.setUpVarDec(ctx.Identifier().getText(), false, e);
        return vD;
    }

    @Override
    public MiniJASTNode visitLocalVariableDeclaration(MiniJavaParser.LocalVariableDeclarationContext ctx) {
        LocalVarDec lvd = new LocalVarDec();
        lvd.setUpLVD(((PrimTypeCarrier)visit(ctx.primitiveType())).type);

        for (MiniJavaParser.VariableDeclaratorContext c : ctx.variableDeclarators().variableDeclarator()) {
            Statement vD = (Statement)visit(c);
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
    public MiniJASTNode visitMakePrint(MiniJavaParser.MakePrintContext ctx) {
        PrintStatement pS = new PrintStatement("standardOut.txt", false);
        Expression e = (Expression)visit(ctx.parExpression());
        pS.setUpPrint(e);
        return pS;
    }

    @Override
    public MiniJASTNode visitParExpression(MiniJavaParser.ParExpressionContext ctx) {
        return visit(ctx.expression());
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
    public MiniJASTNode visitMakeStmntExpr(MiniJavaParser.MakeStmntExprContext ctx) {
        return visit(ctx.expressionStatement());
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
    public MiniJASTNode visitBreak(MiniJavaParser.BreakContext ctx) {
        return SingleWordStmnt.BREAK;
    }

    @Override
    public MiniJASTNode visitContinue(MiniJavaParser.ContinueContext ctx) {
        return SingleWordStmnt.CONTINUE;
    }

    @Override
    public MiniJASTNode visitEmpty(MiniJavaParser.EmptyContext ctx) {
        return SingleWordStmnt.EMPTY;
    }

    @Override
    public MiniJASTNode visitMakeIf(MiniJavaParser.MakeIfContext ctx) {
        IfThenStmnt itS = new IfThenStmnt();
        itS.setUpIfThen((Expression)visit(ctx.parExpression()), (Statement)visit(ctx.statement()));
        return itS;
    }

    @Override
    public MiniJASTNode visitMakeITE(MiniJavaParser.MakeITEContext ctx) {
        IfThenElseStmnt iteS = new IfThenElseStmnt();
        iteS.setUpITE((Expression)visit(ctx.parExpression()), (Statement)visit(ctx.statementNSI()), (Statement)visit(ctx.statement()));
        return iteS;
    }

    @Override
    public MiniJASTNode visitMakeITENSI(MiniJavaParser.MakeITENSIContext ctx) {
        IfThenElseStmnt itensi = new IfThenElseStmnt();
        itensi.setUpITE((Expression)visit(ctx.parExpression()), (Statement)visit(ctx.statementNSI(0)), (Statement)visit(ctx.statementNSI(1)));
        return itensi;
    }

    @Override
    public MiniJASTNode visitForInitLVD(MiniJavaParser.ForInitLVDContext ctx) {
        ForInit fI = new ForInit();
        LocalVarDec lvd = new LocalVarDec();
        lvd.setUpLVD(((PrimTypeCarrier)visit(ctx.primitiveType())).type);

        for (MiniJavaParser.VariableDeclaratorContext c : ctx.variableDeclarators().variableDeclarator()) {
            VarDeclarator vD = (VarDeclarator)visit(c);
            lvd.addVarDec(vD);
        }

        fI.setLocalVarDec(lvd);
        return fI;
    }

    @Override
    public MiniJASTNode visitForInitExprs(MiniJavaParser.ForInitExprsContext ctx) {
        ForInit fI = new ForInit();
        for (MiniJavaParser.ExpressionContext c : ctx.expressionList().expression()) {
            fI.addStmntExpr((Expression)visit(c));
        }

        return fI;
    }

    @Override
    public MiniJASTNode visitMakeFor(MiniJavaParser.MakeForContext ctx) {
        ForStmnt fS = new ForStmnt();
        ForInit fI = ctx.forInit() == null ? null : (ForInit)visit(ctx.forInit());
        Expression cond = ctx.expression() == null ? null : (Expression)visit(ctx.expression());
        fS.setUpForStmnt(fI, cond);
        Statement s = ctx.statement() == null ? null : (Statement)visit(ctx.statement());
        fS.setBody(s);
        if (ctx.expressionList() != null) {
            for (MiniJavaParser.ExpressionContext c : ctx.expressionList().expression()) {
                fS.addUpdate((Expression) visit(c));
            }
        }

        return fS;
    }

    @Override
    public MiniJASTNode visitMakeForNSI(MiniJavaParser.MakeForNSIContext ctx) {
        ForStmnt fS = new ForStmnt();
        ForInit fI = ctx.forInit() == null ? null : (ForInit)visit(ctx.forInit());
        Expression cond = ctx.expression() == null ? null : (Expression)visit(ctx.expression());
        fS.setUpForStmnt(fI, cond);
        Statement s = ctx.statementNSI() == null ? null : (Statement) visit(ctx.statementNSI());
        fS.setBody(s);
        if (ctx.expressionList() != null) {
            for (MiniJavaParser.ExpressionContext c : ctx.expressionList().expression()) {
                fS.addUpdate((Expression) visit(c));
            }
        }

        return fS;
    }

    @Override
    public MiniJASTNode visitMakeWhile(MiniJavaParser.MakeWhileContext ctx) {
        WhileStmnt wS = new WhileStmnt();
        wS.setUpWhile((Expression)visit(ctx.parExpression()), (Statement)visit(ctx.statement()));
        return wS;
    }

    @Override
    public MiniJASTNode visitMakeWhileNSI(MiniJavaParser.MakeWhileNSIContext ctx) {
        WhileStmnt wS = new WhileStmnt();
        wS.setUpWhile((Expression)visit(ctx.parExpression()), (Statement) visit(ctx.statementNSI()));
        return wS;
    }

    @Override
    public MiniJASTNode visitMakeDo(MiniJavaParser.MakeDoContext ctx) {
        DoStmnt dS = new DoStmnt();
        dS.setUpDo((Statement)visit(ctx.statement()), (Expression)visit(ctx.parExpression()));
        return dS;
    }
}
