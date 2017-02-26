// Generated from MiniJava.g4 by ANTLR 4.5.3
package antlrParser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiniJavaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BOOLEAN=1, BREAK=2, CHAR=3, CONTINUE=4, DO=5, DOUBLE=6, ELSE=7, FOR=8, 
		IF=9, INT=10, NEW=11, RETURN=12, WHILE=13, IntegerLiteral=14, FloatingPointLiteral=15, 
		BooleanLiteral=16, CharacterLiteral=17, LPAREN=18, RPAREN=19, LBRACE=20, 
		RBRACE=21, LBRACK=22, RBRACK=23, SEMI=24, COMMA=25, DOT=26, ASSIGN=27, 
		GT=28, LT=29, BANG=30, QUESTION=31, COLON=32, EQUAL=33, LE=34, GE=35, 
		NOTEQUAL=36, AND=37, OR=38, INC=39, DEC=40, ADD=41, SUB=42, MUL=43, DIV=44, 
		ADD_ASSIGN=45, SUB_ASSIGN=46, MUL_ASSIGN=47, DIV_ASSIGN=48, Identifier=49, 
		WS=50, COMMENT=51, LINE_COMMENT=52;
	public static final int
		RULE_block = 0, RULE_blockStatement = 1, RULE_statement = 2, RULE_statementNSI = 3, 
		RULE_forInit = 4, RULE_forUpdate = 5, RULE_parExpression = 6, RULE_expressionList = 7, 
		RULE_statementExpression = 8, RULE_expression = 9, RULE_variableDeclarators = 10, 
		RULE_variableDeclarator = 11, RULE_variableInitializer = 12, RULE_arrayInitializerValues = 13, 
		RULE_arrayInitializerSize = 14, RULE_primitiveType = 15, RULE_literal = 16;
	public static final String[] ruleNames = {
		"block", "blockStatement", "statement", "statementNSI", "forInit", "forUpdate", 
		"parExpression", "expressionList", "statementExpression", "expression", 
		"variableDeclarators", "variableDeclarator", "variableInitializer", "arrayInitializerValues", 
		"arrayInitializerSize", "primitiveType", "literal"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'boolean'", "'break'", "'char'", "'continue'", "'do'", "'double'", 
		"'else'", "'for'", "'if'", "'int'", "'new'", "'return'", "'while'", null, 
		null, null, null, "'('", "')'", "'{'", "'}'", "'['", "']'", "';'", "','", 
		"'.'", "'='", "'>'", "'<'", "'!'", "'?'", "':'", "'=='", "'<='", "'>='", 
		"'!='", "'&&'", "'||'", "'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'+='", 
		"'-='", "'*='", "'/='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "BOOLEAN", "BREAK", "CHAR", "CONTINUE", "DO", "DOUBLE", "ELSE", 
		"FOR", "IF", "INT", "NEW", "RETURN", "WHILE", "IntegerLiteral", "FloatingPointLiteral", 
		"BooleanLiteral", "CharacterLiteral", "LPAREN", "RPAREN", "LBRACE", "RBRACE", 
		"LBRACK", "RBRACK", "SEMI", "COMMA", "DOT", "ASSIGN", "GT", "LT", "BANG", 
		"QUESTION", "COLON", "EQUAL", "LE", "GE", "NOTEQUAL", "AND", "OR", "INC", 
		"DEC", "ADD", "SUB", "MUL", "DIV", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", 
		"DIV_ASSIGN", "Identifier", "WS", "COMMENT", "LINE_COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MiniJava.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniJavaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class BlockContext extends ParserRuleContext {
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	 
		public BlockContext() { }
		public void copyFrom(BlockContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FillBlockContext extends BlockContext {
		public TerminalNode LBRACE() { return getToken(MiniJavaParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(MiniJavaParser.RBRACE, 0); }
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public FillBlockContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitFillBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_block);
		int _la;
		try {
			_localctx = new FillBlockContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(LBRACE);
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BREAK) | (1L << CHAR) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << RETURN) | (1L << WHILE) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << LPAREN) | (1L << LBRACE) | (1L << SEMI) | (1L << BANG) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << Identifier))) != 0)) {
				{
				{
				setState(35);
				blockStatement();
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockStatementContext extends ParserRuleContext {
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
	 
		public BlockStatementContext() { }
		public void copyFrom(BlockStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LocalVariableDeclarationContext extends BlockStatementContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public VariableDeclaratorsContext variableDeclarators() {
			return getRuleContext(VariableDeclaratorsContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MiniJavaParser.SEMI, 0); }
		public LocalVariableDeclarationContext(BlockStatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitLocalVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MakeStmntContext extends BlockStatementContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public MakeStmntContext(BlockStatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMakeStmnt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_blockStatement);
		try {
			setState(48);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case CHAR:
			case DOUBLE:
			case INT:
				_localctx = new LocalVariableDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				primitiveType();
				setState(44);
				variableDeclarators();
				setState(45);
				match(SEMI);
				}
				break;
			case BREAK:
			case CONTINUE:
			case DO:
			case FOR:
			case IF:
			case RETURN:
			case WHILE:
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case LPAREN:
			case LBRACE:
			case SEMI:
			case BANG:
			case INC:
			case DEC:
			case ADD:
			case SUB:
			case Identifier:
				_localctx = new MakeStmntContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MakeDoContext extends StatementContext {
		public TerminalNode DO() { return getToken(MiniJavaParser.DO, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(MiniJavaParser.WHILE, 0); }
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MiniJavaParser.SEMI, 0); }
		public MakeDoContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMakeDo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MakeBlockContext extends StatementContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MakeBlockContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMakeBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MakeIfContext extends StatementContext {
		public TerminalNode IF() { return getToken(MiniJavaParser.IF, 0); }
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public MakeIfContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMakeIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BreakContext extends StatementContext {
		public TerminalNode BREAK() { return getToken(MiniJavaParser.BREAK, 0); }
		public TerminalNode SEMI() { return getToken(MiniJavaParser.SEMI, 0); }
		public BreakContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitBreak(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ContinueContext extends StatementContext {
		public TerminalNode CONTINUE() { return getToken(MiniJavaParser.CONTINUE, 0); }
		public TerminalNode SEMI() { return getToken(MiniJavaParser.SEMI, 0); }
		public ContinueContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitContinue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MakeWhileContext extends StatementContext {
		public TerminalNode WHILE() { return getToken(MiniJavaParser.WHILE, 0); }
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public MakeWhileContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMakeWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MakeForContext extends StatementContext {
		public TerminalNode FOR() { return getToken(MiniJavaParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(MiniJavaParser.LPAREN, 0); }
		public List<TerminalNode> SEMI() { return getTokens(MiniJavaParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(MiniJavaParser.SEMI, i);
		}
		public TerminalNode RPAREN() { return getToken(MiniJavaParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForUpdateContext forUpdate() {
			return getRuleContext(ForUpdateContext.class,0);
		}
		public MakeForContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMakeFor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MakeStmntExprContext extends StatementContext {
		public StatementExpressionContext statementExpression() {
			return getRuleContext(StatementExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MiniJavaParser.SEMI, 0); }
		public MakeStmntExprContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMakeStmntExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MakeITEContext extends StatementContext {
		public TerminalNode IF() { return getToken(MiniJavaParser.IF, 0); }
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public StatementNSIContext statementNSI() {
			return getRuleContext(StatementNSIContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(MiniJavaParser.ELSE, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public MakeITEContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMakeITE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnContext extends StatementContext {
		public TerminalNode RETURN() { return getToken(MiniJavaParser.RETURN, 0); }
		public TerminalNode SEMI() { return getToken(MiniJavaParser.SEMI, 0); }
		public ReturnContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitReturn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EmptyContext extends StatementContext {
		public TerminalNode SEMI() { return getToken(MiniJavaParser.SEMI, 0); }
		public EmptyContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitEmpty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		int _la;
		try {
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new MakeBlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				block();
				}
				break;
			case 2:
				_localctx = new MakeIfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				match(IF);
				setState(52);
				parExpression();
				setState(53);
				statement();
				}
				break;
			case 3:
				_localctx = new MakeITEContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(55);
				match(IF);
				setState(56);
				parExpression();
				setState(57);
				statementNSI();
				setState(58);
				match(ELSE);
				setState(59);
				statement();
				}
				break;
			case 4:
				_localctx = new MakeForContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(61);
				match(FOR);
				setState(62);
				match(LPAREN);
				setState(64);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << CHAR) | (1L << DOUBLE) | (1L << INT) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << LPAREN) | (1L << BANG) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << Identifier))) != 0)) {
					{
					setState(63);
					forInit();
					}
				}

				setState(66);
				match(SEMI);
				setState(68);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << LPAREN) | (1L << BANG) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << Identifier))) != 0)) {
					{
					setState(67);
					expression(0);
					}
				}

				setState(70);
				match(SEMI);
				setState(72);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << LPAREN) | (1L << BANG) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << Identifier))) != 0)) {
					{
					setState(71);
					forUpdate();
					}
				}

				setState(74);
				match(RPAREN);
				setState(75);
				statement();
				}
				break;
			case 5:
				_localctx = new MakeWhileContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(76);
				match(WHILE);
				setState(77);
				parExpression();
				setState(78);
				statement();
				}
				break;
			case 6:
				_localctx = new MakeDoContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(80);
				match(DO);
				setState(81);
				statement();
				setState(82);
				match(WHILE);
				setState(83);
				parExpression();
				setState(84);
				match(SEMI);
				}
				break;
			case 7:
				_localctx = new ReturnContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(86);
				match(RETURN);
				setState(87);
				match(SEMI);
				}
				break;
			case 8:
				_localctx = new BreakContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(88);
				match(BREAK);
				setState(89);
				match(SEMI);
				}
				break;
			case 9:
				_localctx = new ContinueContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(90);
				match(CONTINUE);
				setState(91);
				match(SEMI);
				}
				break;
			case 10:
				_localctx = new EmptyContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(92);
				match(SEMI);
				}
				break;
			case 11:
				_localctx = new MakeStmntExprContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(93);
				statementExpression();
				setState(94);
				match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementNSIContext extends ParserRuleContext {
		public StatementNSIContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementNSI; }
	 
		public StatementNSIContext() { }
		public void copyFrom(StatementNSIContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MakeITENSIContext extends StatementNSIContext {
		public TerminalNode IF() { return getToken(MiniJavaParser.IF, 0); }
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public List<StatementNSIContext> statementNSI() {
			return getRuleContexts(StatementNSIContext.class);
		}
		public StatementNSIContext statementNSI(int i) {
			return getRuleContext(StatementNSIContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MiniJavaParser.ELSE, 0); }
		public MakeITENSIContext(StatementNSIContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMakeITENSI(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MakeDoNSIContext extends StatementNSIContext {
		public TerminalNode DO() { return getToken(MiniJavaParser.DO, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(MiniJavaParser.WHILE, 0); }
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MiniJavaParser.SEMI, 0); }
		public MakeDoNSIContext(StatementNSIContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMakeDoNSI(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EmptyNSIContext extends StatementNSIContext {
		public TerminalNode SEMI() { return getToken(MiniJavaParser.SEMI, 0); }
		public EmptyNSIContext(StatementNSIContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitEmptyNSI(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ContinueNSIContext extends StatementNSIContext {
		public TerminalNode CONTINUE() { return getToken(MiniJavaParser.CONTINUE, 0); }
		public TerminalNode SEMI() { return getToken(MiniJavaParser.SEMI, 0); }
		public ContinueNSIContext(StatementNSIContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitContinueNSI(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MakeForNSIContext extends StatementNSIContext {
		public TerminalNode FOR() { return getToken(MiniJavaParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(MiniJavaParser.LPAREN, 0); }
		public List<TerminalNode> SEMI() { return getTokens(MiniJavaParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(MiniJavaParser.SEMI, i);
		}
		public TerminalNode RPAREN() { return getToken(MiniJavaParser.RPAREN, 0); }
		public StatementNSIContext statementNSI() {
			return getRuleContext(StatementNSIContext.class,0);
		}
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForUpdateContext forUpdate() {
			return getRuleContext(ForUpdateContext.class,0);
		}
		public MakeForNSIContext(StatementNSIContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMakeForNSI(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnNSIContext extends StatementNSIContext {
		public TerminalNode RETURN() { return getToken(MiniJavaParser.RETURN, 0); }
		public TerminalNode SEMI() { return getToken(MiniJavaParser.SEMI, 0); }
		public ReturnNSIContext(StatementNSIContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitReturnNSI(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MakeWhileNSIContext extends StatementNSIContext {
		public TerminalNode WHILE() { return getToken(MiniJavaParser.WHILE, 0); }
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public StatementNSIContext statementNSI() {
			return getRuleContext(StatementNSIContext.class,0);
		}
		public MakeWhileNSIContext(StatementNSIContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMakeWhileNSI(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BreakNSIContext extends StatementNSIContext {
		public TerminalNode BREAK() { return getToken(MiniJavaParser.BREAK, 0); }
		public TerminalNode SEMI() { return getToken(MiniJavaParser.SEMI, 0); }
		public BreakNSIContext(StatementNSIContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitBreakNSI(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MakeStmntExprNSIContext extends StatementNSIContext {
		public StatementExpressionContext statementExpression() {
			return getRuleContext(StatementExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MiniJavaParser.SEMI, 0); }
		public MakeStmntExprNSIContext(StatementNSIContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMakeStmntExprNSI(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MakeBlockNSIContext extends StatementNSIContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MakeBlockNSIContext(StatementNSIContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMakeBlockNSI(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementNSIContext statementNSI() throws RecognitionException {
		StatementNSIContext _localctx = new StatementNSIContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statementNSI);
		int _la;
		try {
			setState(140);
			switch (_input.LA(1)) {
			case LBRACE:
				_localctx = new MakeBlockNSIContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				block();
				}
				break;
			case IF:
				_localctx = new MakeITENSIContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				match(IF);
				setState(100);
				parExpression();
				setState(101);
				statementNSI();
				setState(102);
				match(ELSE);
				setState(103);
				statementNSI();
				}
				break;
			case FOR:
				_localctx = new MakeForNSIContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(105);
				match(FOR);
				setState(106);
				match(LPAREN);
				setState(108);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << CHAR) | (1L << DOUBLE) | (1L << INT) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << LPAREN) | (1L << BANG) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << Identifier))) != 0)) {
					{
					setState(107);
					forInit();
					}
				}

				setState(110);
				match(SEMI);
				setState(112);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << LPAREN) | (1L << BANG) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << Identifier))) != 0)) {
					{
					setState(111);
					expression(0);
					}
				}

				setState(114);
				match(SEMI);
				setState(116);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << LPAREN) | (1L << BANG) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << Identifier))) != 0)) {
					{
					setState(115);
					forUpdate();
					}
				}

				setState(118);
				match(RPAREN);
				setState(119);
				statementNSI();
				}
				break;
			case WHILE:
				_localctx = new MakeWhileNSIContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(120);
				match(WHILE);
				setState(121);
				parExpression();
				setState(122);
				statementNSI();
				}
				break;
			case DO:
				_localctx = new MakeDoNSIContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(124);
				match(DO);
				setState(125);
				statement();
				setState(126);
				match(WHILE);
				setState(127);
				parExpression();
				setState(128);
				match(SEMI);
				}
				break;
			case RETURN:
				_localctx = new ReturnNSIContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(130);
				match(RETURN);
				setState(131);
				match(SEMI);
				}
				break;
			case BREAK:
				_localctx = new BreakNSIContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(132);
				match(BREAK);
				setState(133);
				match(SEMI);
				}
				break;
			case CONTINUE:
				_localctx = new ContinueNSIContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(134);
				match(CONTINUE);
				setState(135);
				match(SEMI);
				}
				break;
			case SEMI:
				_localctx = new EmptyNSIContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(136);
				match(SEMI);
				}
				break;
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case LPAREN:
			case BANG:
			case INC:
			case DEC:
			case ADD:
			case SUB:
			case Identifier:
				_localctx = new MakeStmntExprNSIContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(137);
				statementExpression();
				setState(138);
				match(SEMI);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForInitContext extends ParserRuleContext {
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
	 
		public ForInitContext() { }
		public void copyFrom(ForInitContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ForInitExprsContext extends ForInitContext {
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ForInitExprsContext(ForInitContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitForInitExprs(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForInitLVDContext extends ForInitContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public VariableDeclaratorsContext variableDeclarators() {
			return getRuleContext(VariableDeclaratorsContext.class,0);
		}
		public ForInitLVDContext(ForInitContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitForInitLVD(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_forInit);
		try {
			setState(146);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case CHAR:
			case DOUBLE:
			case INT:
				_localctx = new ForInitLVDContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				primitiveType();
				setState(143);
				variableDeclarators();
				}
				break;
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case LPAREN:
			case BANG:
			case INC:
			case DEC:
			case ADD:
			case SUB:
			case Identifier:
				_localctx = new ForInitExprsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				expressionList();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForUpdateContext extends ParserRuleContext {
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ForUpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forUpdate; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitForUpdate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForUpdateContext forUpdate() throws RecognitionException {
		ForUpdateContext _localctx = new ForUpdateContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_forUpdate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			expressionList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParExpressionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(MiniJavaParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MiniJavaParser.RPAREN, 0); }
		public ParExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitParExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParExpressionContext parExpression() throws RecognitionException {
		ParExpressionContext _localctx = new ParExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_parExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(LPAREN);
			setState(151);
			expression(0);
			setState(152);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniJavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniJavaParser.COMMA, i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			expression(0);
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(155);
				match(COMMA);
				setState(156);
				expression(0);
				}
				}
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitStatementExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementExpressionContext statementExpression() throws RecognitionException {
		StatementExpressionContext _localctx = new StatementExpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statementExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MakeIDContext extends ExpressionContext {
		public TerminalNode Identifier() { return getToken(MiniJavaParser.Identifier, 0); }
		public MakeIDContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMakeID(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PreIncEtcContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ADD() { return getToken(MiniJavaParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(MiniJavaParser.SUB, 0); }
		public TerminalNode INC() { return getToken(MiniJavaParser.INC, 0); }
		public TerminalNode DEC() { return getToken(MiniJavaParser.DEC, 0); }
		public PreIncEtcContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitPreIncEtc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MakeNotContext extends ExpressionContext {
		public TerminalNode BANG() { return getToken(MiniJavaParser.BANG, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public MakeNotContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMakeNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode QUESTION() { return getToken(MiniJavaParser.QUESTION, 0); }
		public TerminalNode COLON() { return getToken(MiniJavaParser.COLON, 0); }
		public CondExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitCondExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OR() { return getToken(MiniJavaParser.OR, 0); }
		public OrExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelationalExprContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LE() { return getToken(MiniJavaParser.LE, 0); }
		public TerminalNode GE() { return getToken(MiniJavaParser.GE, 0); }
		public TerminalNode GT() { return getToken(MiniJavaParser.GT, 0); }
		public TerminalNode LT() { return getToken(MiniJavaParser.LT, 0); }
		public RelationalExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitRelationalExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MakeBracketedContext extends ExpressionContext {
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public MakeBracketedContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMakeBracketed(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultExprContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MUL() { return getToken(MiniJavaParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(MiniJavaParser.DIV, 0); }
		public MultExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMultExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PostIncContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode INC() { return getToken(MiniJavaParser.INC, 0); }
		public TerminalNode DEC() { return getToken(MiniJavaParser.DEC, 0); }
		public PostIncContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitPostInc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqExprContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQUAL() { return getToken(MiniJavaParser.EQUAL, 0); }
		public TerminalNode NOTEQUAL() { return getToken(MiniJavaParser.NOTEQUAL, 0); }
		public EqExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitEqExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddExprContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ADD() { return getToken(MiniJavaParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(MiniJavaParser.SUB, 0); }
		public AddExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitAddExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayAccessContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LBRACK() { return getToken(MiniJavaParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(MiniJavaParser.RBRACK, 0); }
		public ArrayAccessContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitArrayAccess(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MakeLiteralContext extends ExpressionContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public MakeLiteralContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMakeLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignExprContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ASSIGN() { return getToken(MiniJavaParser.ASSIGN, 0); }
		public TerminalNode ADD_ASSIGN() { return getToken(MiniJavaParser.ADD_ASSIGN, 0); }
		public TerminalNode SUB_ASSIGN() { return getToken(MiniJavaParser.SUB_ASSIGN, 0); }
		public TerminalNode MUL_ASSIGN() { return getToken(MiniJavaParser.MUL_ASSIGN, 0); }
		public TerminalNode DIV_ASSIGN() { return getToken(MiniJavaParser.DIV_ASSIGN, 0); }
		public AssignExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitAssignExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(MiniJavaParser.AND, 0); }
		public AndExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			switch (_input.LA(1)) {
			case LPAREN:
				{
				_localctx = new MakeBracketedContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(165);
				parExpression();
				}
				break;
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
				{
				_localctx = new MakeLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(166);
				literal();
				}
				break;
			case Identifier:
				{
				_localctx = new MakeIDContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(167);
				match(Identifier);
				}
				break;
			case INC:
			case DEC:
			case ADD:
			case SUB:
				{
				_localctx = new PreIncEtcContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(172);
				switch (_input.LA(1)) {
				case ADD:
					{
					setState(168);
					((PreIncEtcContext)_localctx).op = match(ADD);
					}
					break;
				case SUB:
					{
					setState(169);
					((PreIncEtcContext)_localctx).op = match(SUB);
					}
					break;
				case INC:
					{
					setState(170);
					((PreIncEtcContext)_localctx).op = match(INC);
					}
					break;
				case DEC:
					{
					setState(171);
					((PreIncEtcContext)_localctx).op = match(DEC);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(174);
				expression(10);
				}
				break;
			case BANG:
				{
				_localctx = new MakeNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(175);
				match(BANG);
				setState(176);
				expression(9);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(238);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(236);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new MultExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(179);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(182);
						switch (_input.LA(1)) {
						case MUL:
							{
							setState(180);
							((MultExprContext)_localctx).op = match(MUL);
							}
							break;
						case DIV:
							{
							setState(181);
							((MultExprContext)_localctx).op = match(DIV);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(184);
						expression(9);
						}
						break;
					case 2:
						{
						_localctx = new AddExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(185);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(188);
						switch (_input.LA(1)) {
						case ADD:
							{
							setState(186);
							((AddExprContext)_localctx).op = match(ADD);
							}
							break;
						case SUB:
							{
							setState(187);
							((AddExprContext)_localctx).op = match(SUB);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(190);
						expression(8);
						}
						break;
					case 3:
						{
						_localctx = new RelationalExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(191);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(196);
						switch (_input.LA(1)) {
						case LE:
							{
							setState(192);
							((RelationalExprContext)_localctx).op = match(LE);
							}
							break;
						case GE:
							{
							setState(193);
							((RelationalExprContext)_localctx).op = match(GE);
							}
							break;
						case GT:
							{
							setState(194);
							((RelationalExprContext)_localctx).op = match(GT);
							}
							break;
						case LT:
							{
							setState(195);
							((RelationalExprContext)_localctx).op = match(LT);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(198);
						expression(7);
						}
						break;
					case 4:
						{
						_localctx = new EqExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(199);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(202);
						switch (_input.LA(1)) {
						case EQUAL:
							{
							setState(200);
							((EqExprContext)_localctx).op = match(EQUAL);
							}
							break;
						case NOTEQUAL:
							{
							setState(201);
							((EqExprContext)_localctx).op = match(NOTEQUAL);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(204);
						expression(6);
						}
						break;
					case 5:
						{
						_localctx = new AndExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(205);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(206);
						match(AND);
						setState(207);
						expression(5);
						}
						break;
					case 6:
						{
						_localctx = new OrExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(208);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(209);
						match(OR);
						setState(210);
						expression(4);
						}
						break;
					case 7:
						{
						_localctx = new CondExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(211);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(212);
						match(QUESTION);
						setState(213);
						expression(0);
						setState(214);
						match(COLON);
						setState(215);
						expression(3);
						}
						break;
					case 8:
						{
						_localctx = new AssignExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(217);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(223);
						switch (_input.LA(1)) {
						case ASSIGN:
							{
							setState(218);
							((AssignExprContext)_localctx).op = match(ASSIGN);
							}
							break;
						case ADD_ASSIGN:
							{
							setState(219);
							((AssignExprContext)_localctx).op = match(ADD_ASSIGN);
							}
							break;
						case SUB_ASSIGN:
							{
							setState(220);
							((AssignExprContext)_localctx).op = match(SUB_ASSIGN);
							}
							break;
						case MUL_ASSIGN:
							{
							setState(221);
							((AssignExprContext)_localctx).op = match(MUL_ASSIGN);
							}
							break;
						case DIV_ASSIGN:
							{
							setState(222);
							((AssignExprContext)_localctx).op = match(DIV_ASSIGN);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(225);
						expression(1);
						}
						break;
					case 9:
						{
						_localctx = new ArrayAccessContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(226);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(227);
						match(LBRACK);
						setState(228);
						expression(0);
						setState(229);
						match(RBRACK);
						}
						break;
					case 10:
						{
						_localctx = new PostIncContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(231);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(234);
						switch (_input.LA(1)) {
						case INC:
							{
							setState(232);
							((PostIncContext)_localctx).op = match(INC);
							}
							break;
						case DEC:
							{
							setState(233);
							((PostIncContext)_localctx).op = match(DEC);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					}
					} 
				}
				setState(240);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class VariableDeclaratorsContext extends ParserRuleContext {
		public List<VariableDeclaratorContext> variableDeclarator() {
			return getRuleContexts(VariableDeclaratorContext.class);
		}
		public VariableDeclaratorContext variableDeclarator(int i) {
			return getRuleContext(VariableDeclaratorContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniJavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniJavaParser.COMMA, i);
		}
		public VariableDeclaratorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarators; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitVariableDeclarators(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclaratorsContext variableDeclarators() throws RecognitionException {
		VariableDeclaratorsContext _localctx = new VariableDeclaratorsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_variableDeclarators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			variableDeclarator();
			setState(246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(242);
				match(COMMA);
				setState(243);
				variableDeclarator();
				}
				}
				setState(248);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclaratorContext extends ParserRuleContext {
		public VariableDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarator; }
	 
		public VariableDeclaratorContext() { }
		public void copyFrom(VariableDeclaratorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SingleVarDecContext extends VariableDeclaratorContext {
		public Token Identifier;
		public TerminalNode Identifier() { return getToken(MiniJavaParser.Identifier, 0); }
		public TerminalNode ASSIGN() { return getToken(MiniJavaParser.ASSIGN, 0); }
		public VariableInitializerContext variableInitializer() {
			return getRuleContext(VariableInitializerContext.class,0);
		}
		public SingleVarDecContext(VariableDeclaratorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitSingleVarDec(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayVarDecContext extends VariableDeclaratorContext {
		public Token Identifier;
		public TerminalNode Identifier() { return getToken(MiniJavaParser.Identifier, 0); }
		public TerminalNode LBRACK() { return getToken(MiniJavaParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(MiniJavaParser.RBRACK, 0); }
		public TerminalNode ASSIGN() { return getToken(MiniJavaParser.ASSIGN, 0); }
		public VariableInitializerContext variableInitializer() {
			return getRuleContext(VariableInitializerContext.class,0);
		}
		public ArrayVarDecContext(VariableDeclaratorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitArrayVarDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclaratorContext variableDeclarator() throws RecognitionException {
		VariableDeclaratorContext _localctx = new VariableDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_variableDeclarator);
		int _la;
		try {
			setState(259);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				_localctx = new ArrayVarDecContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(249);
				((ArrayVarDecContext)_localctx).Identifier = match(Identifier);
				setState(250);
				match(LBRACK);
				setState(251);
				match(RBRACK);
				setState(252);
				match(ASSIGN);
				setState(253);
				variableInitializer((((ArrayVarDecContext)_localctx).Identifier!=null?((ArrayVarDecContext)_localctx).Identifier.getText():null));
				}
				break;
			case 2:
				_localctx = new SingleVarDecContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(254);
				((SingleVarDecContext)_localctx).Identifier = match(Identifier);
				setState(257);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(255);
					match(ASSIGN);
					setState(256);
					variableInitializer((((SingleVarDecContext)_localctx).Identifier!=null?((SingleVarDecContext)_localctx).Identifier.getText():null));
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableInitializerContext extends ParserRuleContext {
		public String id;
		public VariableInitializerContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public VariableInitializerContext(ParserRuleContext parent, int invokingState, String id) {
			super(parent, invokingState);
			this.id = id;
		}
		@Override public int getRuleIndex() { return RULE_variableInitializer; }
	 
		public VariableInitializerContext() { }
		public void copyFrom(VariableInitializerContext ctx) {
			super.copyFrom(ctx);
			this.id = ctx.id;
		}
	}
	public static class ArrayInitSizeContext extends VariableInitializerContext {
		public ArrayInitializerSizeContext arrayInitializerSize() {
			return getRuleContext(ArrayInitializerSizeContext.class,0);
		}
		public ArrayInitSizeContext(VariableInitializerContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitArrayInitSize(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayInitValsContext extends VariableInitializerContext {
		public ArrayInitializerValuesContext arrayInitializerValues() {
			return getRuleContext(ArrayInitializerValuesContext.class,0);
		}
		public ArrayInitValsContext(VariableInitializerContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitArrayInitVals(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InitExprContext extends VariableInitializerContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public InitExprContext(VariableInitializerContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitInitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableInitializerContext variableInitializer(String id) throws RecognitionException {
		VariableInitializerContext _localctx = new VariableInitializerContext(_ctx, getState(), id);
		enterRule(_localctx, 24, RULE_variableInitializer);
		try {
			setState(264);
			switch (_input.LA(1)) {
			case LBRACE:
				_localctx = new ArrayInitValsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(261);
				arrayInitializerValues(id);
				}
				break;
			case NEW:
				_localctx = new ArrayInitSizeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(262);
				arrayInitializerSize(id);
				}
				break;
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case LPAREN:
			case BANG:
			case INC:
			case DEC:
			case ADD:
			case SUB:
			case Identifier:
				_localctx = new InitExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(263);
				expression(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayInitializerValuesContext extends ParserRuleContext {
		public String id;
		public TerminalNode LBRACE() { return getToken(MiniJavaParser.LBRACE, 0); }
		public List<VariableInitializerContext> variableInitializer() {
			return getRuleContexts(VariableInitializerContext.class);
		}
		public VariableInitializerContext variableInitializer(int i) {
			return getRuleContext(VariableInitializerContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(MiniJavaParser.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MiniJavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniJavaParser.COMMA, i);
		}
		public ArrayInitializerValuesContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ArrayInitializerValuesContext(ParserRuleContext parent, int invokingState, String id) {
			super(parent, invokingState);
			this.id = id;
		}
		@Override public int getRuleIndex() { return RULE_arrayInitializerValues; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitArrayInitializerValues(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayInitializerValuesContext arrayInitializerValues(String id) throws RecognitionException {
		ArrayInitializerValuesContext _localctx = new ArrayInitializerValuesContext(_ctx, getState(), id);
		enterRule(_localctx, 26, RULE_arrayInitializerValues);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			match(LBRACE);
			setState(267);
			variableInitializer(id);
			setState(272);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(268);
					match(COMMA);
					setState(269);
					variableInitializer(id);
					}
					} 
				}
				setState(274);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			setState(276);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(275);
				match(COMMA);
				}
			}

			setState(278);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayInitializerSizeContext extends ParserRuleContext {
		public String id;
		public TerminalNode NEW() { return getToken(MiniJavaParser.NEW, 0); }
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TerminalNode LBRACK() { return getToken(MiniJavaParser.LBRACK, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(MiniJavaParser.RBRACK, 0); }
		public ArrayInitializerSizeContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ArrayInitializerSizeContext(ParserRuleContext parent, int invokingState, String id) {
			super(parent, invokingState);
			this.id = id;
		}
		@Override public int getRuleIndex() { return RULE_arrayInitializerSize; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitArrayInitializerSize(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayInitializerSizeContext arrayInitializerSize(String id) throws RecognitionException {
		ArrayInitializerSizeContext _localctx = new ArrayInitializerSizeContext(_ctx, getState(), id);
		enterRule(_localctx, 28, RULE_arrayInitializerSize);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			match(NEW);
			setState(281);
			primitiveType();
			setState(282);
			match(LBRACK);
			setState(283);
			expression(0);
			setState(284);
			match(RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimitiveTypeContext extends ParserRuleContext {
		public TerminalNode BOOLEAN() { return getToken(MiniJavaParser.BOOLEAN, 0); }
		public TerminalNode CHAR() { return getToken(MiniJavaParser.CHAR, 0); }
		public TerminalNode INT() { return getToken(MiniJavaParser.INT, 0); }
		public TerminalNode DOUBLE() { return getToken(MiniJavaParser.DOUBLE, 0); }
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << CHAR) | (1L << DOUBLE) | (1L << INT))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode IntegerLiteral() { return getToken(MiniJavaParser.IntegerLiteral, 0); }
		public TerminalNode FloatingPointLiteral() { return getToken(MiniJavaParser.FloatingPointLiteral, 0); }
		public TerminalNode CharacterLiteral() { return getToken(MiniJavaParser.CharacterLiteral, 0); }
		public TerminalNode BooleanLiteral() { return getToken(MiniJavaParser.BooleanLiteral, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 2);
		case 7:
			return precpred(_ctx, 1);
		case 8:
			return precpred(_ctx, 12);
		case 9:
			return precpred(_ctx, 11);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\66\u0125\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\7\2\'\n\2\f\2\16\2*\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3\63\n"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4C\n\4\3"+
		"\4\3\4\5\4G\n\4\3\4\3\4\5\4K\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4c\n\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5o\n\5\3\5\3\5\5\5s\n\5\3\5\3\5\5\5w"+
		"\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\5\5\u008f\n\5\3\6\3\6\3\6\3\6\5\6\u0095\n\6\3\7"+
		"\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\7\t\u00a0\n\t\f\t\16\t\u00a3\13\t\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00af\n\13\3\13\3\13"+
		"\3\13\5\13\u00b4\n\13\3\13\3\13\3\13\5\13\u00b9\n\13\3\13\3\13\3\13\3"+
		"\13\5\13\u00bf\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00c7\n\13\3\13"+
		"\3\13\3\13\3\13\5\13\u00cd\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00e2\n\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00ed\n\13\7\13\u00ef"+
		"\n\13\f\13\16\13\u00f2\13\13\3\f\3\f\3\f\7\f\u00f7\n\f\f\f\16\f\u00fa"+
		"\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0104\n\r\5\r\u0106\n\r\3\16"+
		"\3\16\3\16\5\16\u010b\n\16\3\17\3\17\3\17\3\17\7\17\u0111\n\17\f\17\16"+
		"\17\u0114\13\17\3\17\5\17\u0117\n\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\22\3\22\3\22\2\3\24\23\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"\2\4\6\2\3\3\5\5\b\b\f\f\3\2\20\23\u0153\2$\3\2\2\2\4\62\3"+
		"\2\2\2\6b\3\2\2\2\b\u008e\3\2\2\2\n\u0094\3\2\2\2\f\u0096\3\2\2\2\16\u0098"+
		"\3\2\2\2\20\u009c\3\2\2\2\22\u00a4\3\2\2\2\24\u00b3\3\2\2\2\26\u00f3\3"+
		"\2\2\2\30\u0105\3\2\2\2\32\u010a\3\2\2\2\34\u010c\3\2\2\2\36\u011a\3\2"+
		"\2\2 \u0120\3\2\2\2\"\u0122\3\2\2\2$(\7\26\2\2%\'\5\4\3\2&%\3\2\2\2\'"+
		"*\3\2\2\2(&\3\2\2\2()\3\2\2\2)+\3\2\2\2*(\3\2\2\2+,\7\27\2\2,\3\3\2\2"+
		"\2-.\5 \21\2./\5\26\f\2/\60\7\32\2\2\60\63\3\2\2\2\61\63\5\6\4\2\62-\3"+
		"\2\2\2\62\61\3\2\2\2\63\5\3\2\2\2\64c\5\2\2\2\65\66\7\13\2\2\66\67\5\16"+
		"\b\2\678\5\6\4\28c\3\2\2\29:\7\13\2\2:;\5\16\b\2;<\5\b\5\2<=\7\t\2\2="+
		">\5\6\4\2>c\3\2\2\2?@\7\n\2\2@B\7\24\2\2AC\5\n\6\2BA\3\2\2\2BC\3\2\2\2"+
		"CD\3\2\2\2DF\7\32\2\2EG\5\24\13\2FE\3\2\2\2FG\3\2\2\2GH\3\2\2\2HJ\7\32"+
		"\2\2IK\5\f\7\2JI\3\2\2\2JK\3\2\2\2KL\3\2\2\2LM\7\25\2\2Mc\5\6\4\2NO\7"+
		"\17\2\2OP\5\16\b\2PQ\5\6\4\2Qc\3\2\2\2RS\7\7\2\2ST\5\6\4\2TU\7\17\2\2"+
		"UV\5\16\b\2VW\7\32\2\2Wc\3\2\2\2XY\7\16\2\2Yc\7\32\2\2Z[\7\4\2\2[c\7\32"+
		"\2\2\\]\7\6\2\2]c\7\32\2\2^c\7\32\2\2_`\5\22\n\2`a\7\32\2\2ac\3\2\2\2"+
		"b\64\3\2\2\2b\65\3\2\2\2b9\3\2\2\2b?\3\2\2\2bN\3\2\2\2bR\3\2\2\2bX\3\2"+
		"\2\2bZ\3\2\2\2b\\\3\2\2\2b^\3\2\2\2b_\3\2\2\2c\7\3\2\2\2d\u008f\5\2\2"+
		"\2ef\7\13\2\2fg\5\16\b\2gh\5\b\5\2hi\7\t\2\2ij\5\b\5\2j\u008f\3\2\2\2"+
		"kl\7\n\2\2ln\7\24\2\2mo\5\n\6\2nm\3\2\2\2no\3\2\2\2op\3\2\2\2pr\7\32\2"+
		"\2qs\5\24\13\2rq\3\2\2\2rs\3\2\2\2st\3\2\2\2tv\7\32\2\2uw\5\f\7\2vu\3"+
		"\2\2\2vw\3\2\2\2wx\3\2\2\2xy\7\25\2\2y\u008f\5\b\5\2z{\7\17\2\2{|\5\16"+
		"\b\2|}\5\b\5\2}\u008f\3\2\2\2~\177\7\7\2\2\177\u0080\5\6\4\2\u0080\u0081"+
		"\7\17\2\2\u0081\u0082\5\16\b\2\u0082\u0083\7\32\2\2\u0083\u008f\3\2\2"+
		"\2\u0084\u0085\7\16\2\2\u0085\u008f\7\32\2\2\u0086\u0087\7\4\2\2\u0087"+
		"\u008f\7\32\2\2\u0088\u0089\7\6\2\2\u0089\u008f\7\32\2\2\u008a\u008f\7"+
		"\32\2\2\u008b\u008c\5\22\n\2\u008c\u008d\7\32\2\2\u008d\u008f\3\2\2\2"+
		"\u008ed\3\2\2\2\u008ee\3\2\2\2\u008ek\3\2\2\2\u008ez\3\2\2\2\u008e~\3"+
		"\2\2\2\u008e\u0084\3\2\2\2\u008e\u0086\3\2\2\2\u008e\u0088\3\2\2\2\u008e"+
		"\u008a\3\2\2\2\u008e\u008b\3\2\2\2\u008f\t\3\2\2\2\u0090\u0091\5 \21\2"+
		"\u0091\u0092\5\26\f\2\u0092\u0095\3\2\2\2\u0093\u0095\5\20\t\2\u0094\u0090"+
		"\3\2\2\2\u0094\u0093\3\2\2\2\u0095\13\3\2\2\2\u0096\u0097\5\20\t\2\u0097"+
		"\r\3\2\2\2\u0098\u0099\7\24\2\2\u0099\u009a\5\24\13\2\u009a\u009b\7\25"+
		"\2\2\u009b\17\3\2\2\2\u009c\u00a1\5\24\13\2\u009d\u009e\7\33\2\2\u009e"+
		"\u00a0\5\24\13\2\u009f\u009d\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3"+
		"\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\21\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4"+
		"\u00a5\5\24\13\2\u00a5\23\3\2\2\2\u00a6\u00a7\b\13\1\2\u00a7\u00b4\5\16"+
		"\b\2\u00a8\u00b4\5\"\22\2\u00a9\u00b4\7\63\2\2\u00aa\u00af\7+\2\2\u00ab"+
		"\u00af\7,\2\2\u00ac\u00af\7)\2\2\u00ad\u00af\7*\2\2\u00ae\u00aa\3\2\2"+
		"\2\u00ae\u00ab\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00ad\3\2\2\2\u00af\u00b0"+
		"\3\2\2\2\u00b0\u00b4\5\24\13\f\u00b1\u00b2\7 \2\2\u00b2\u00b4\5\24\13"+
		"\13\u00b3\u00a6\3\2\2\2\u00b3\u00a8\3\2\2\2\u00b3\u00a9\3\2\2\2\u00b3"+
		"\u00ae\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b4\u00f0\3\2\2\2\u00b5\u00b8\f\n"+
		"\2\2\u00b6\u00b9\7-\2\2\u00b7\u00b9\7.\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b7"+
		"\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00ef\5\24\13\13\u00bb\u00be\f\t\2"+
		"\2\u00bc\u00bf\7+\2\2\u00bd\u00bf\7,\2\2\u00be\u00bc\3\2\2\2\u00be\u00bd"+
		"\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00ef\5\24\13\n\u00c1\u00c6\f\b\2\2"+
		"\u00c2\u00c7\7$\2\2\u00c3\u00c7\7%\2\2\u00c4\u00c7\7\36\2\2\u00c5\u00c7"+
		"\7\37\2\2\u00c6\u00c2\3\2\2\2\u00c6\u00c3\3\2\2\2\u00c6\u00c4\3\2\2\2"+
		"\u00c6\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00ef\5\24\13\t\u00c9\u00cc"+
		"\f\7\2\2\u00ca\u00cd\7#\2\2\u00cb\u00cd\7&\2\2\u00cc\u00ca\3\2\2\2\u00cc"+
		"\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00ef\5\24\13\b\u00cf\u00d0\f"+
		"\6\2\2\u00d0\u00d1\7\'\2\2\u00d1\u00ef\5\24\13\7\u00d2\u00d3\f\5\2\2\u00d3"+
		"\u00d4\7(\2\2\u00d4\u00ef\5\24\13\6\u00d5\u00d6\f\4\2\2\u00d6\u00d7\7"+
		"!\2\2\u00d7\u00d8\5\24\13\2\u00d8\u00d9\7\"\2\2\u00d9\u00da\5\24\13\5"+
		"\u00da\u00ef\3\2\2\2\u00db\u00e1\f\3\2\2\u00dc\u00e2\7\35\2\2\u00dd\u00e2"+
		"\7/\2\2\u00de\u00e2\7\60\2\2\u00df\u00e2\7\61\2\2\u00e0\u00e2\7\62\2\2"+
		"\u00e1\u00dc\3\2\2\2\u00e1\u00dd\3\2\2\2\u00e1\u00de\3\2\2\2\u00e1\u00df"+
		"\3\2\2\2\u00e1\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00ef\5\24\13\3"+
		"\u00e4\u00e5\f\16\2\2\u00e5\u00e6\7\30\2\2\u00e6\u00e7\5\24\13\2\u00e7"+
		"\u00e8\7\31\2\2\u00e8\u00ef\3\2\2\2\u00e9\u00ec\f\r\2\2\u00ea\u00ed\7"+
		")\2\2\u00eb\u00ed\7*\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00eb\3\2\2\2\u00ed"+
		"\u00ef\3\2\2\2\u00ee\u00b5\3\2\2\2\u00ee\u00bb\3\2\2\2\u00ee\u00c1\3\2"+
		"\2\2\u00ee\u00c9\3\2\2\2\u00ee\u00cf\3\2\2\2\u00ee\u00d2\3\2\2\2\u00ee"+
		"\u00d5\3\2\2\2\u00ee\u00db\3\2\2\2\u00ee\u00e4\3\2\2\2\u00ee\u00e9\3\2"+
		"\2\2\u00ef\u00f2\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1"+
		"\25\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f3\u00f8\5\30\r\2\u00f4\u00f5\7\33"+
		"\2\2\u00f5\u00f7\5\30\r\2\u00f6\u00f4\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8"+
		"\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\27\3\2\2\2\u00fa\u00f8\3\2\2"+
		"\2\u00fb\u00fc\7\63\2\2\u00fc\u00fd\7\30\2\2\u00fd\u00fe\7\31\2\2\u00fe"+
		"\u00ff\7\35\2\2\u00ff\u0106\5\32\16\2\u0100\u0103\7\63\2\2\u0101\u0102"+
		"\7\35\2\2\u0102\u0104\5\32\16\2\u0103\u0101\3\2\2\2\u0103\u0104\3\2\2"+
		"\2\u0104\u0106\3\2\2\2\u0105\u00fb\3\2\2\2\u0105\u0100\3\2\2\2\u0106\31"+
		"\3\2\2\2\u0107\u010b\5\34\17\2\u0108\u010b\5\36\20\2\u0109\u010b\5\24"+
		"\13\2\u010a\u0107\3\2\2\2\u010a\u0108\3\2\2\2\u010a\u0109\3\2\2\2\u010b"+
		"\33\3\2\2\2\u010c\u010d\7\26\2\2\u010d\u0112\5\32\16\2\u010e\u010f\7\33"+
		"\2\2\u010f\u0111\5\32\16\2\u0110\u010e\3\2\2\2\u0111\u0114\3\2\2\2\u0112"+
		"\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0116\3\2\2\2\u0114\u0112\3\2"+
		"\2\2\u0115\u0117\7\33\2\2\u0116\u0115\3\2\2\2\u0116\u0117\3\2\2\2\u0117"+
		"\u0118\3\2\2\2\u0118\u0119\7\27\2\2\u0119\35\3\2\2\2\u011a\u011b\7\r\2"+
		"\2\u011b\u011c\5 \21\2\u011c\u011d\7\30\2\2\u011d\u011e\5\24\13\2\u011e"+
		"\u011f\7\31\2\2\u011f\37\3\2\2\2\u0120\u0121\t\2\2\2\u0121!\3\2\2\2\u0122"+
		"\u0123\t\3\2\2\u0123#\3\2\2\2\36(\62BFJbnrv\u008e\u0094\u00a1\u00ae\u00b3"+
		"\u00b8\u00be\u00c6\u00cc\u00e1\u00ec\u00ee\u00f0\u00f8\u0103\u0105\u010a"+
		"\u0112\u0116";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}