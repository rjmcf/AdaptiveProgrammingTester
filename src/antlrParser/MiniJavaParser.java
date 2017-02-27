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
		RULE_entry = 0, RULE_block = 1, RULE_blockStatement = 2, RULE_statement = 3, 
		RULE_statementNSI = 4, RULE_statementNTS = 5, RULE_forInit = 6, RULE_parExpression = 7, 
		RULE_expressionList = 8, RULE_expressionStatement = 9, RULE_expression = 10, 
		RULE_variableDeclarators = 11, RULE_variableDeclarator = 12, RULE_variableInitializer = 13, 
		RULE_arrayInitializerValues = 14, RULE_arrayInitializerSize = 15, RULE_primitiveType = 16, 
		RULE_literal = 17;
	public static final String[] ruleNames = {
		"entry", "block", "blockStatement", "statement", "statementNSI", "statementNTS", 
		"forInit", "parExpression", "expressionList", "expressionStatement", "expression", 
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
	public static class EntryContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public EntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entry; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitEntry(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EntryContext entry() throws RecognitionException {
		EntryContext _localctx = new EntryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_entry);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			block(true);
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

	public static class BlockContext extends ParserRuleContext {
		public boolean isOuter;
		public TerminalNode LBRACE() { return getToken(MiniJavaParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(MiniJavaParser.RBRACE, 0); }
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public BlockContext(ParserRuleContext parent, int invokingState, boolean isOuter) {
			super(parent, invokingState);
			this.isOuter = isOuter;
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block(boolean isOuter) throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState(), isOuter);
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(LBRACE);
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BREAK) | (1L << CHAR) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << RETURN) | (1L << WHILE) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << LPAREN) | (1L << LBRACE) | (1L << SEMI) | (1L << BANG) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << Identifier))) != 0)) {
				{
				{
				setState(39);
				blockStatement();
				}
				}
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(45);
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
		enterRule(_localctx, 4, RULE_blockStatement);
		try {
			setState(52);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case CHAR:
			case DOUBLE:
			case INT:
				_localctx = new LocalVariableDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				primitiveType();
				setState(48);
				variableDeclarators();
				setState(49);
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
				setState(51);
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
	public static class MakeStatementNTSContext extends StatementContext {
		public StatementNTSContext statementNTS() {
			return getRuleContext(StatementNTSContext.class,0);
		}
		public MakeStatementNTSContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMakeStatementNTS(this);
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
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public MakeForContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMakeFor(this);
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

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		int _la;
		try {
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new MakeBlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				block(false);
				}
				break;
			case 2:
				_localctx = new MakeIfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				match(IF);
				setState(56);
				parExpression();
				setState(57);
				statement();
				}
				break;
			case 3:
				_localctx = new MakeITEContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(59);
				match(IF);
				setState(60);
				parExpression();
				setState(61);
				statementNSI();
				setState(62);
				match(ELSE);
				setState(63);
				statement();
				}
				break;
			case 4:
				_localctx = new MakeForContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(65);
				match(FOR);
				setState(66);
				match(LPAREN);
				setState(68);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << CHAR) | (1L << DOUBLE) | (1L << INT) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << LPAREN) | (1L << BANG) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << Identifier))) != 0)) {
					{
					setState(67);
					forInit();
					}
				}

				setState(70);
				match(SEMI);
				setState(72);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << LPAREN) | (1L << BANG) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << Identifier))) != 0)) {
					{
					setState(71);
					expression(0);
					}
				}

				setState(74);
				match(SEMI);
				setState(76);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << LPAREN) | (1L << BANG) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << Identifier))) != 0)) {
					{
					setState(75);
					expressionList();
					}
				}

				setState(78);
				match(RPAREN);
				setState(79);
				statement();
				}
				break;
			case 5:
				_localctx = new MakeWhileContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(80);
				match(WHILE);
				setState(81);
				parExpression();
				setState(82);
				statement();
				}
				break;
			case 6:
				_localctx = new MakeStatementNTSContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(84);
				statementNTS();
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
	public static class MakeStatementNTSNSIContext extends StatementNSIContext {
		public StatementNTSContext statementNTS() {
			return getRuleContext(StatementNTSContext.class,0);
		}
		public MakeStatementNTSNSIContext(StatementNSIContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMakeStatementNTSNSI(this);
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
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public MakeForNSIContext(StatementNSIContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMakeForNSI(this);
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
		enterRule(_localctx, 8, RULE_statementNSI);
		int _la;
		try {
			setState(114);
			switch (_input.LA(1)) {
			case LBRACE:
				_localctx = new MakeBlockNSIContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				block(false);
				}
				break;
			case IF:
				_localctx = new MakeITENSIContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				match(IF);
				setState(89);
				parExpression();
				setState(90);
				statementNSI();
				setState(91);
				match(ELSE);
				setState(92);
				statementNSI();
				}
				break;
			case FOR:
				_localctx = new MakeForNSIContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(94);
				match(FOR);
				setState(95);
				match(LPAREN);
				setState(97);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << CHAR) | (1L << DOUBLE) | (1L << INT) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << LPAREN) | (1L << BANG) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << Identifier))) != 0)) {
					{
					setState(96);
					forInit();
					}
				}

				setState(99);
				match(SEMI);
				setState(101);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << LPAREN) | (1L << BANG) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << Identifier))) != 0)) {
					{
					setState(100);
					expression(0);
					}
				}

				setState(103);
				match(SEMI);
				setState(105);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << LPAREN) | (1L << BANG) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << Identifier))) != 0)) {
					{
					setState(104);
					expressionList();
					}
				}

				setState(107);
				match(RPAREN);
				setState(108);
				statementNSI();
				}
				break;
			case WHILE:
				_localctx = new MakeWhileNSIContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(109);
				match(WHILE);
				setState(110);
				parExpression();
				setState(111);
				statementNSI();
				}
				break;
			case BREAK:
			case CONTINUE:
			case DO:
			case RETURN:
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case LPAREN:
			case SEMI:
			case BANG:
			case INC:
			case DEC:
			case ADD:
			case SUB:
			case Identifier:
				_localctx = new MakeStatementNTSNSIContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(113);
				statementNTS();
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

	public static class StatementNTSContext extends ParserRuleContext {
		public StatementNTSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementNTS; }
	 
		public StatementNTSContext() { }
		public void copyFrom(StatementNTSContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MakeDoContext extends StatementNTSContext {
		public TerminalNode DO() { return getToken(MiniJavaParser.DO, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(MiniJavaParser.WHILE, 0); }
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MiniJavaParser.SEMI, 0); }
		public MakeDoContext(StatementNTSContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMakeDo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BreakContext extends StatementNTSContext {
		public TerminalNode BREAK() { return getToken(MiniJavaParser.BREAK, 0); }
		public TerminalNode SEMI() { return getToken(MiniJavaParser.SEMI, 0); }
		public BreakContext(StatementNTSContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitBreak(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ContinueContext extends StatementNTSContext {
		public TerminalNode CONTINUE() { return getToken(MiniJavaParser.CONTINUE, 0); }
		public TerminalNode SEMI() { return getToken(MiniJavaParser.SEMI, 0); }
		public ContinueContext(StatementNTSContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitContinue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MakeStmntExprContext extends StatementNTSContext {
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MiniJavaParser.SEMI, 0); }
		public MakeStmntExprContext(StatementNTSContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMakeStmntExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnContext extends StatementNTSContext {
		public TerminalNode RETURN() { return getToken(MiniJavaParser.RETURN, 0); }
		public TerminalNode SEMI() { return getToken(MiniJavaParser.SEMI, 0); }
		public ReturnContext(StatementNTSContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitReturn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EmptyContext extends StatementNTSContext {
		public TerminalNode SEMI() { return getToken(MiniJavaParser.SEMI, 0); }
		public EmptyContext(StatementNTSContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitEmpty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementNTSContext statementNTS() throws RecognitionException {
		StatementNTSContext _localctx = new StatementNTSContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statementNTS);
		try {
			setState(132);
			switch (_input.LA(1)) {
			case DO:
				_localctx = new MakeDoContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				match(DO);
				setState(117);
				statement();
				setState(118);
				match(WHILE);
				setState(119);
				parExpression();
				setState(120);
				match(SEMI);
				}
				break;
			case RETURN:
				_localctx = new ReturnContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				match(RETURN);
				setState(123);
				match(SEMI);
				}
				break;
			case BREAK:
				_localctx = new BreakContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(124);
				match(BREAK);
				setState(125);
				match(SEMI);
				}
				break;
			case CONTINUE:
				_localctx = new ContinueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(126);
				match(CONTINUE);
				setState(127);
				match(SEMI);
				}
				break;
			case SEMI:
				_localctx = new EmptyContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(128);
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
				_localctx = new MakeStmntExprContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(129);
				expressionStatement();
				setState(130);
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
		enterRule(_localctx, 12, RULE_forInit);
		try {
			setState(138);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case CHAR:
			case DOUBLE:
			case INT:
				_localctx = new ForInitLVDContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				primitiveType();
				setState(135);
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
				setState(137);
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
		enterRule(_localctx, 14, RULE_parExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(LPAREN);
			setState(141);
			expression(0);
			setState(142);
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
		enterRule(_localctx, 16, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			expression(0);
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(145);
				match(COMMA);
				setState(146);
				expression(0);
				}
				}
				setState(151);
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

	public static class ExpressionStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitExpressionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			switch (_input.LA(1)) {
			case LPAREN:
				{
				_localctx = new MakeBracketedContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(155);
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
				setState(156);
				literal();
				}
				break;
			case Identifier:
				{
				_localctx = new MakeIDContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(157);
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
				setState(162);
				switch (_input.LA(1)) {
				case ADD:
					{
					setState(158);
					((PreIncEtcContext)_localctx).op = match(ADD);
					}
					break;
				case SUB:
					{
					setState(159);
					((PreIncEtcContext)_localctx).op = match(SUB);
					}
					break;
				case INC:
					{
					setState(160);
					((PreIncEtcContext)_localctx).op = match(INC);
					}
					break;
				case DEC:
					{
					setState(161);
					((PreIncEtcContext)_localctx).op = match(DEC);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(164);
				expression(10);
				}
				break;
			case BANG:
				{
				_localctx = new MakeNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(165);
				match(BANG);
				setState(166);
				expression(9);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(228);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(226);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new MultExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(169);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(172);
						switch (_input.LA(1)) {
						case MUL:
							{
							setState(170);
							((MultExprContext)_localctx).op = match(MUL);
							}
							break;
						case DIV:
							{
							setState(171);
							((MultExprContext)_localctx).op = match(DIV);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(174);
						expression(9);
						}
						break;
					case 2:
						{
						_localctx = new AddExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(175);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(178);
						switch (_input.LA(1)) {
						case ADD:
							{
							setState(176);
							((AddExprContext)_localctx).op = match(ADD);
							}
							break;
						case SUB:
							{
							setState(177);
							((AddExprContext)_localctx).op = match(SUB);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(180);
						expression(8);
						}
						break;
					case 3:
						{
						_localctx = new RelationalExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(181);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(186);
						switch (_input.LA(1)) {
						case LE:
							{
							setState(182);
							((RelationalExprContext)_localctx).op = match(LE);
							}
							break;
						case GE:
							{
							setState(183);
							((RelationalExprContext)_localctx).op = match(GE);
							}
							break;
						case GT:
							{
							setState(184);
							((RelationalExprContext)_localctx).op = match(GT);
							}
							break;
						case LT:
							{
							setState(185);
							((RelationalExprContext)_localctx).op = match(LT);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(188);
						expression(7);
						}
						break;
					case 4:
						{
						_localctx = new EqExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(189);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(192);
						switch (_input.LA(1)) {
						case EQUAL:
							{
							setState(190);
							((EqExprContext)_localctx).op = match(EQUAL);
							}
							break;
						case NOTEQUAL:
							{
							setState(191);
							((EqExprContext)_localctx).op = match(NOTEQUAL);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(194);
						expression(6);
						}
						break;
					case 5:
						{
						_localctx = new AndExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(195);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(196);
						match(AND);
						setState(197);
						expression(5);
						}
						break;
					case 6:
						{
						_localctx = new OrExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(198);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(199);
						match(OR);
						setState(200);
						expression(4);
						}
						break;
					case 7:
						{
						_localctx = new CondExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(201);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(202);
						match(QUESTION);
						setState(203);
						expression(0);
						setState(204);
						match(COLON);
						setState(205);
						expression(3);
						}
						break;
					case 8:
						{
						_localctx = new AssignExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(207);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(213);
						switch (_input.LA(1)) {
						case ASSIGN:
							{
							setState(208);
							((AssignExprContext)_localctx).op = match(ASSIGN);
							}
							break;
						case ADD_ASSIGN:
							{
							setState(209);
							((AssignExprContext)_localctx).op = match(ADD_ASSIGN);
							}
							break;
						case SUB_ASSIGN:
							{
							setState(210);
							((AssignExprContext)_localctx).op = match(SUB_ASSIGN);
							}
							break;
						case MUL_ASSIGN:
							{
							setState(211);
							((AssignExprContext)_localctx).op = match(MUL_ASSIGN);
							}
							break;
						case DIV_ASSIGN:
							{
							setState(212);
							((AssignExprContext)_localctx).op = match(DIV_ASSIGN);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(215);
						expression(1);
						}
						break;
					case 9:
						{
						_localctx = new ArrayAccessContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(216);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(217);
						match(LBRACK);
						setState(218);
						expression(0);
						setState(219);
						match(RBRACK);
						}
						break;
					case 10:
						{
						_localctx = new PostIncContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(221);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(224);
						switch (_input.LA(1)) {
						case INC:
							{
							setState(222);
							((PostIncContext)_localctx).op = match(INC);
							}
							break;
						case DEC:
							{
							setState(223);
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
				setState(230);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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
		enterRule(_localctx, 22, RULE_variableDeclarators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			variableDeclarator();
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(232);
				match(COMMA);
				setState(233);
				variableDeclarator();
				}
				}
				setState(238);
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
		enterRule(_localctx, 24, RULE_variableDeclarator);
		int _la;
		try {
			setState(249);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				_localctx = new ArrayVarDecContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(239);
				((ArrayVarDecContext)_localctx).Identifier = match(Identifier);
				setState(240);
				match(LBRACK);
				setState(241);
				match(RBRACK);
				setState(242);
				match(ASSIGN);
				setState(243);
				variableInitializer((((ArrayVarDecContext)_localctx).Identifier!=null?((ArrayVarDecContext)_localctx).Identifier.getText():null));
				}
				break;
			case 2:
				_localctx = new SingleVarDecContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(244);
				((SingleVarDecContext)_localctx).Identifier = match(Identifier);
				setState(247);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(245);
					match(ASSIGN);
					setState(246);
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
		enterRule(_localctx, 26, RULE_variableInitializer);
		try {
			setState(254);
			switch (_input.LA(1)) {
			case LBRACE:
				_localctx = new ArrayInitValsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(251);
				arrayInitializerValues(id);
				}
				break;
			case NEW:
				_localctx = new ArrayInitSizeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(252);
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
				setState(253);
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
		enterRule(_localctx, 28, RULE_arrayInitializerValues);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			match(LBRACE);
			setState(257);
			variableInitializer(id);
			setState(262);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(258);
					match(COMMA);
					setState(259);
					variableInitializer(id);
					}
					} 
				}
				setState(264);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			setState(266);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(265);
				match(COMMA);
				}
			}

			setState(268);
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
		enterRule(_localctx, 30, RULE_arrayInitializerSize);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(NEW);
			setState(271);
			primitiveType();
			setState(272);
			match(LBRACK);
			setState(273);
			expression(0);
			setState(274);
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
		enterRule(_localctx, 32, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
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
		enterRule(_localctx, 34, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
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
		case 10:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\66\u011b\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\3\3\3\7\3+\n\3\f\3\16\3.\13\3\3\3\3\3\3\4\3\4\3\4"+
		"\3\4\3\4\5\4\67\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\5\5G\n\5\3\5\3\5\5\5K\n\5\3\5\3\5\5\5O\n\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\5\5X\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6d\n\6\3\6"+
		"\3\6\5\6h\n\6\3\6\3\6\5\6l\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6u\n\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0087"+
		"\n\7\3\b\3\b\3\b\3\b\5\b\u008d\n\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\7\n\u0096"+
		"\n\n\f\n\16\n\u0099\13\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f"+
		"\u00a5\n\f\3\f\3\f\3\f\5\f\u00aa\n\f\3\f\3\f\3\f\5\f\u00af\n\f\3\f\3\f"+
		"\3\f\3\f\5\f\u00b5\n\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00bd\n\f\3\f\3\f\3"+
		"\f\3\f\5\f\u00c3\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00d8\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\5\f\u00e3\n\f\7\f\u00e5\n\f\f\f\16\f\u00e8\13\f\3\r\3\r\3\r\7\r"+
		"\u00ed\n\r\f\r\16\r\u00f0\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\5\16\u00fa\n\16\5\16\u00fc\n\16\3\17\3\17\3\17\5\17\u0101\n\17\3\20\3"+
		"\20\3\20\3\20\7\20\u0107\n\20\f\20\16\20\u010a\13\20\3\20\5\20\u010d\n"+
		"\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\2"+
		"\3\26\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\4\6\2\3\3\5\5\b"+
		"\b\f\f\3\2\20\23\u0143\2&\3\2\2\2\4(\3\2\2\2\6\66\3\2\2\2\bW\3\2\2\2\n"+
		"t\3\2\2\2\f\u0086\3\2\2\2\16\u008c\3\2\2\2\20\u008e\3\2\2\2\22\u0092\3"+
		"\2\2\2\24\u009a\3\2\2\2\26\u00a9\3\2\2\2\30\u00e9\3\2\2\2\32\u00fb\3\2"+
		"\2\2\34\u0100\3\2\2\2\36\u0102\3\2\2\2 \u0110\3\2\2\2\"\u0116\3\2\2\2"+
		"$\u0118\3\2\2\2&\'\5\4\3\2\'\3\3\2\2\2(,\7\26\2\2)+\5\6\4\2*)\3\2\2\2"+
		"+.\3\2\2\2,*\3\2\2\2,-\3\2\2\2-/\3\2\2\2.,\3\2\2\2/\60\7\27\2\2\60\5\3"+
		"\2\2\2\61\62\5\"\22\2\62\63\5\30\r\2\63\64\7\32\2\2\64\67\3\2\2\2\65\67"+
		"\5\b\5\2\66\61\3\2\2\2\66\65\3\2\2\2\67\7\3\2\2\28X\5\4\3\29:\7\13\2\2"+
		":;\5\20\t\2;<\5\b\5\2<X\3\2\2\2=>\7\13\2\2>?\5\20\t\2?@\5\n\6\2@A\7\t"+
		"\2\2AB\5\b\5\2BX\3\2\2\2CD\7\n\2\2DF\7\24\2\2EG\5\16\b\2FE\3\2\2\2FG\3"+
		"\2\2\2GH\3\2\2\2HJ\7\32\2\2IK\5\26\f\2JI\3\2\2\2JK\3\2\2\2KL\3\2\2\2L"+
		"N\7\32\2\2MO\5\22\n\2NM\3\2\2\2NO\3\2\2\2OP\3\2\2\2PQ\7\25\2\2QX\5\b\5"+
		"\2RS\7\17\2\2ST\5\20\t\2TU\5\b\5\2UX\3\2\2\2VX\5\f\7\2W8\3\2\2\2W9\3\2"+
		"\2\2W=\3\2\2\2WC\3\2\2\2WR\3\2\2\2WV\3\2\2\2X\t\3\2\2\2Yu\5\4\3\2Z[\7"+
		"\13\2\2[\\\5\20\t\2\\]\5\n\6\2]^\7\t\2\2^_\5\n\6\2_u\3\2\2\2`a\7\n\2\2"+
		"ac\7\24\2\2bd\5\16\b\2cb\3\2\2\2cd\3\2\2\2de\3\2\2\2eg\7\32\2\2fh\5\26"+
		"\f\2gf\3\2\2\2gh\3\2\2\2hi\3\2\2\2ik\7\32\2\2jl\5\22\n\2kj\3\2\2\2kl\3"+
		"\2\2\2lm\3\2\2\2mn\7\25\2\2nu\5\n\6\2op\7\17\2\2pq\5\20\t\2qr\5\n\6\2"+
		"ru\3\2\2\2su\5\f\7\2tY\3\2\2\2tZ\3\2\2\2t`\3\2\2\2to\3\2\2\2ts\3\2\2\2"+
		"u\13\3\2\2\2vw\7\7\2\2wx\5\b\5\2xy\7\17\2\2yz\5\20\t\2z{\7\32\2\2{\u0087"+
		"\3\2\2\2|}\7\16\2\2}\u0087\7\32\2\2~\177\7\4\2\2\177\u0087\7\32\2\2\u0080"+
		"\u0081\7\6\2\2\u0081\u0087\7\32\2\2\u0082\u0087\7\32\2\2\u0083\u0084\5"+
		"\24\13\2\u0084\u0085\7\32\2\2\u0085\u0087\3\2\2\2\u0086v\3\2\2\2\u0086"+
		"|\3\2\2\2\u0086~\3\2\2\2\u0086\u0080\3\2\2\2\u0086\u0082\3\2\2\2\u0086"+
		"\u0083\3\2\2\2\u0087\r\3\2\2\2\u0088\u0089\5\"\22\2\u0089\u008a\5\30\r"+
		"\2\u008a\u008d\3\2\2\2\u008b\u008d\5\22\n\2\u008c\u0088\3\2\2\2\u008c"+
		"\u008b\3\2\2\2\u008d\17\3\2\2\2\u008e\u008f\7\24\2\2\u008f\u0090\5\26"+
		"\f\2\u0090\u0091\7\25\2\2\u0091\21\3\2\2\2\u0092\u0097\5\26\f\2\u0093"+
		"\u0094\7\33\2\2\u0094\u0096\5\26\f\2\u0095\u0093\3\2\2\2\u0096\u0099\3"+
		"\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\23\3\2\2\2\u0099"+
		"\u0097\3\2\2\2\u009a\u009b\5\26\f\2\u009b\25\3\2\2\2\u009c\u009d\b\f\1"+
		"\2\u009d\u00aa\5\20\t\2\u009e\u00aa\5$\23\2\u009f\u00aa\7\63\2\2\u00a0"+
		"\u00a5\7+\2\2\u00a1\u00a5\7,\2\2\u00a2\u00a5\7)\2\2\u00a3\u00a5\7*\2\2"+
		"\u00a4\u00a0\3\2\2\2\u00a4\u00a1\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a3"+
		"\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00aa\5\26\f\f\u00a7\u00a8\7 \2\2\u00a8"+
		"\u00aa\5\26\f\13\u00a9\u009c\3\2\2\2\u00a9\u009e\3\2\2\2\u00a9\u009f\3"+
		"\2\2\2\u00a9\u00a4\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00e6\3\2\2\2\u00ab"+
		"\u00ae\f\n\2\2\u00ac\u00af\7-\2\2\u00ad\u00af\7.\2\2\u00ae\u00ac\3\2\2"+
		"\2\u00ae\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00e5\5\26\f\13\u00b1"+
		"\u00b4\f\t\2\2\u00b2\u00b5\7+\2\2\u00b3\u00b5\7,\2\2\u00b4\u00b2\3\2\2"+
		"\2\u00b4\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00e5\5\26\f\n\u00b7"+
		"\u00bc\f\b\2\2\u00b8\u00bd\7$\2\2\u00b9\u00bd\7%\2\2\u00ba\u00bd\7\36"+
		"\2\2\u00bb\u00bd\7\37\2\2\u00bc\u00b8\3\2\2\2\u00bc\u00b9\3\2\2\2\u00bc"+
		"\u00ba\3\2\2\2\u00bc\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00e5\5\26"+
		"\f\t\u00bf\u00c2\f\7\2\2\u00c0\u00c3\7#\2\2\u00c1\u00c3\7&\2\2\u00c2\u00c0"+
		"\3\2\2\2\u00c2\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00e5\5\26\f\b"+
		"\u00c5\u00c6\f\6\2\2\u00c6\u00c7\7\'\2\2\u00c7\u00e5\5\26\f\7\u00c8\u00c9"+
		"\f\5\2\2\u00c9\u00ca\7(\2\2\u00ca\u00e5\5\26\f\6\u00cb\u00cc\f\4\2\2\u00cc"+
		"\u00cd\7!\2\2\u00cd\u00ce\5\26\f\2\u00ce\u00cf\7\"\2\2\u00cf\u00d0\5\26"+
		"\f\5\u00d0\u00e5\3\2\2\2\u00d1\u00d7\f\3\2\2\u00d2\u00d8\7\35\2\2\u00d3"+
		"\u00d8\7/\2\2\u00d4\u00d8\7\60\2\2\u00d5\u00d8\7\61\2\2\u00d6\u00d8\7"+
		"\62\2\2\u00d7\u00d2\3\2\2\2\u00d7\u00d3\3\2\2\2\u00d7\u00d4\3\2\2\2\u00d7"+
		"\u00d5\3\2\2\2\u00d7\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00e5\5\26"+
		"\f\3\u00da\u00db\f\16\2\2\u00db\u00dc\7\30\2\2\u00dc\u00dd\5\26\f\2\u00dd"+
		"\u00de\7\31\2\2\u00de\u00e5\3\2\2\2\u00df\u00e2\f\r\2\2\u00e0\u00e3\7"+
		")\2\2\u00e1\u00e3\7*\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e1\3\2\2\2\u00e3"+
		"\u00e5\3\2\2\2\u00e4\u00ab\3\2\2\2\u00e4\u00b1\3\2\2\2\u00e4\u00b7\3\2"+
		"\2\2\u00e4\u00bf\3\2\2\2\u00e4\u00c5\3\2\2\2\u00e4\u00c8\3\2\2\2\u00e4"+
		"\u00cb\3\2\2\2\u00e4\u00d1\3\2\2\2\u00e4\u00da\3\2\2\2\u00e4\u00df\3\2"+
		"\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7"+
		"\27\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00ee\5\32\16\2\u00ea\u00eb\7\33"+
		"\2\2\u00eb\u00ed\5\32\16\2\u00ec\u00ea\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee"+
		"\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\31\3\2\2\2\u00f0\u00ee\3\2\2"+
		"\2\u00f1\u00f2\7\63\2\2\u00f2\u00f3\7\30\2\2\u00f3\u00f4\7\31\2\2\u00f4"+
		"\u00f5\7\35\2\2\u00f5\u00fc\5\34\17\2\u00f6\u00f9\7\63\2\2\u00f7\u00f8"+
		"\7\35\2\2\u00f8\u00fa\5\34\17\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2"+
		"\2\u00fa\u00fc\3\2\2\2\u00fb\u00f1\3\2\2\2\u00fb\u00f6\3\2\2\2\u00fc\33"+
		"\3\2\2\2\u00fd\u0101\5\36\20\2\u00fe\u0101\5 \21\2\u00ff\u0101\5\26\f"+
		"\2\u0100\u00fd\3\2\2\2\u0100\u00fe\3\2\2\2\u0100\u00ff\3\2\2\2\u0101\35"+
		"\3\2\2\2\u0102\u0103\7\26\2\2\u0103\u0108\5\34\17\2\u0104\u0105\7\33\2"+
		"\2\u0105\u0107\5\34\17\2\u0106\u0104\3\2\2\2\u0107\u010a\3\2\2\2\u0108"+
		"\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010c\3\2\2\2\u010a\u0108\3\2"+
		"\2\2\u010b\u010d\7\33\2\2\u010c\u010b\3\2\2\2\u010c\u010d\3\2\2\2\u010d"+
		"\u010e\3\2\2\2\u010e\u010f\7\27\2\2\u010f\37\3\2\2\2\u0110\u0111\7\r\2"+
		"\2\u0111\u0112\5\"\22\2\u0112\u0113\7\30\2\2\u0113\u0114\5\26\f\2\u0114"+
		"\u0115\7\31\2\2\u0115!\3\2\2\2\u0116\u0117\t\2\2\2\u0117#\3\2\2\2\u0118"+
		"\u0119\t\3\2\2\u0119%\3\2\2\2\37,\66FJNWcgkt\u0086\u008c\u0097\u00a4\u00a9"+
		"\u00ae\u00b4\u00bc\u00c2\u00d7\u00e2\u00e4\u00e6\u00ee\u00f9\u00fb\u0100"+
		"\u0108\u010c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}