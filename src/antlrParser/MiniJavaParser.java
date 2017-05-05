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
		BLANK=1, BOOLEAN=2, BREAK=3, CHAR=4, CONTINUE=5, DO=6, DOUBLE=7, ELSE=8, 
		FOR=9, IF=10, INT=11, NEW=12, RETURN=13, WHILE=14, IntegerLiteral=15, 
		FloatingPointLiteral=16, BooleanLiteral=17, CharacterLiteral=18, LPAREN=19, 
		RPAREN=20, LBRACE=21, RBRACE=22, LBRACK=23, RBRACK=24, SEMI=25, COMMA=26, 
		DOT=27, ASSIGN=28, GT=29, LT=30, BANG=31, QUESTION=32, COLON=33, EQUAL=34, 
		LE=35, GE=36, NOTEQUAL=37, AND=38, OR=39, INC=40, DEC=41, ADD=42, SUB=43, 
		MUL=44, DIV=45, ADD_ASSIGN=46, SUB_ASSIGN=47, MUL_ASSIGN=48, DIV_ASSIGN=49, 
		PRINT=50, Identifier=51, WS=52, COMMENT=53, LINE_COMMENT=54;
	public static final int
		RULE_entry = 0, RULE_block = 1, RULE_blockStatement = 2, RULE_statementTop = 3, 
		RULE_statement = 4, RULE_statementNSI = 5, RULE_statementNTS = 6, RULE_forInit = 7, 
		RULE_parExpression = 8, RULE_expressionList = 9, RULE_expressionStatement = 10, 
		RULE_expression = 11, RULE_variableDeclarators = 12, RULE_variableDeclarator = 13, 
		RULE_variableInitializer = 14, RULE_arrayInitializerValues = 15, RULE_arrayInitializerSize = 16, 
		RULE_primitiveType = 17, RULE_literal = 18;
	public static final String[] ruleNames = {
		"entry", "block", "blockStatement", "statementTop", "statement", "statementNSI", 
		"statementNTS", "forInit", "parExpression", "expressionList", "expressionStatement", 
		"expression", "variableDeclarators", "variableDeclarator", "variableInitializer", 
		"arrayInitializerValues", "arrayInitializerSize", "primitiveType", "literal"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'boolean'", "'break'", "'char'", "'continue'", "'do'", "'double'", 
		"'else'", "'for'", "'if'", "'int'", "'new'", "'return'", "'while'", null, 
		null, null, null, "'('", "')'", "'{'", "'}'", "'['", "']'", "';'", "','", 
		"'.'", "'='", "'>'", "'<'", "'!'", "'?'", "':'", "'=='", "'<='", "'>='", 
		"'!='", "'&&'", "'||'", "'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'+='", 
		"'-='", "'*='", "'/='", "'System.out.println'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "BLANK", "BOOLEAN", "BREAK", "CHAR", "CONTINUE", "DO", "DOUBLE", 
		"ELSE", "FOR", "IF", "INT", "NEW", "RETURN", "WHILE", "IntegerLiteral", 
		"FloatingPointLiteral", "BooleanLiteral", "CharacterLiteral", "LPAREN", 
		"RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "COMMA", "DOT", 
		"ASSIGN", "GT", "LT", "BANG", "QUESTION", "COLON", "EQUAL", "LE", "GE", 
		"NOTEQUAL", "AND", "OR", "INC", "DEC", "ADD", "SUB", "MUL", "DIV", "ADD_ASSIGN", 
		"SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "PRINT", "Identifier", "WS", 
		"COMMENT", "LINE_COMMENT"
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
		public EntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entry; }
	 
		public EntryContext() { }
		public void copyFrom(EntryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BlockStatementsEntryContext extends EntryContext {
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public BlockStatementsEntryContext(EntryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitBlockStatementsEntry(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementEntryContext extends EntryContext {
		public StatementTopContext statementTop() {
			return getRuleContext(StatementTopContext.class,0);
		}
		public StatementEntryContext(EntryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitStatementEntry(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionEntryContext extends EntryContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionEntryContext(EntryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitExpressionEntry(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockEntryContext extends EntryContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockEntryContext(EntryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitBlockEntry(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlankBlockContext extends EntryContext {
		public TerminalNode BLANK() { return getToken(MiniJavaParser.BLANK, 0); }
		public BlankBlockContext(EntryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitBlankBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EntryContext entry() throws RecognitionException {
		EntryContext _localctx = new EntryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_entry);
		int _la;
		try {
			setState(47);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new BlockEntryContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				block(true);
				}
				break;
			case 2:
				_localctx = new BlockStatementsEntryContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(40); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(39);
					blockStatement();
					}
					}
					setState(42); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BLANK) | (1L << BOOLEAN) | (1L << BREAK) | (1L << CHAR) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << RETURN) | (1L << WHILE) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << LPAREN) | (1L << LBRACE) | (1L << SEMI) | (1L << BANG) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << PRINT) | (1L << Identifier))) != 0) );
				}
				break;
			case 3:
				_localctx = new StatementEntryContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(44);
				statementTop();
				}
				break;
			case 4:
				_localctx = new ExpressionEntryContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(45);
				expression(0);
				}
				break;
			case 5:
				_localctx = new BlankBlockContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(46);
				match(BLANK);
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
			setState(49);
			match(LBRACE);
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BLANK) | (1L << BOOLEAN) | (1L << BREAK) | (1L << CHAR) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << RETURN) | (1L << WHILE) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << LPAREN) | (1L << LBRACE) | (1L << SEMI) | (1L << BANG) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << PRINT) | (1L << Identifier))) != 0)) {
				{
				{
				setState(50);
				blockStatement();
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(56);
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
	public static class MakeVarDecContext extends BlockStatementContext {
		public VariableDeclaratorContext variableDeclarator() {
			return getRuleContext(VariableDeclaratorContext.class,0);
		}
		public MakeVarDecContext(BlockStatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMakeVarDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_blockStatement);
		try {
			setState(64);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new LocalVariableDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				primitiveType();
				setState(59);
				variableDeclarators();
				setState(60);
				match(SEMI);
				}
				break;
			case 2:
				_localctx = new MakeStmntContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				statement();
				}
				break;
			case 3:
				_localctx = new MakeVarDecContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(63);
				variableDeclarator();
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

	public static class StatementTopContext extends ParserRuleContext {
		public StatementTopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementTop; }
	 
		public StatementTopContext() { }
		public void copyFrom(StatementTopContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StmntContext extends StatementTopContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StmntContext(StatementTopContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitStmnt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StmntNSIContext extends StatementTopContext {
		public StatementNSIContext statementNSI() {
			return getRuleContext(StatementNSIContext.class,0);
		}
		public StmntNSIContext(StatementTopContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitStmntNSI(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementTopContext statementTop() throws RecognitionException {
		StatementTopContext _localctx = new StatementTopContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statementTop);
		try {
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new StmntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				statement();
				}
				break;
			case 2:
				_localctx = new StmntNSIContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				statementNSI();
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
		public TerminalNode LPAREN() { return getToken(MiniJavaParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MiniJavaParser.RPAREN, 0); }
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
	public static class BlankStmntContext extends StatementContext {
		public TerminalNode BLANK() { return getToken(MiniJavaParser.BLANK, 0); }
		public BlankStmntContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitBlankStmnt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MakeWhileContext extends StatementContext {
		public TerminalNode WHILE() { return getToken(MiniJavaParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(MiniJavaParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MiniJavaParser.RPAREN, 0); }
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
		public TerminalNode LPAREN() { return getToken(MiniJavaParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MiniJavaParser.RPAREN, 0); }
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
		enterRule(_localctx, 8, RULE_statement);
		int _la;
		try {
			setState(108);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new MakeBlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				block(false);
				}
				break;
			case 2:
				_localctx = new MakeIfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				match(IF);
				setState(72);
				match(LPAREN);
				setState(73);
				expression(0);
				setState(74);
				match(RPAREN);
				setState(75);
				statement();
				}
				break;
			case 3:
				_localctx = new MakeITEContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(77);
				match(IF);
				setState(78);
				match(LPAREN);
				setState(79);
				expression(0);
				setState(80);
				match(RPAREN);
				setState(81);
				statementNSI();
				setState(82);
				match(ELSE);
				setState(83);
				statement();
				}
				break;
			case 4:
				_localctx = new MakeForContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(85);
				match(FOR);
				setState(86);
				match(LPAREN);
				setState(88);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BLANK) | (1L << BOOLEAN) | (1L << CHAR) | (1L << DOUBLE) | (1L << INT) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << LPAREN) | (1L << BANG) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << Identifier))) != 0)) {
					{
					setState(87);
					forInit();
					}
				}

				setState(90);
				match(SEMI);
				setState(92);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BLANK) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << LPAREN) | (1L << BANG) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << Identifier))) != 0)) {
					{
					setState(91);
					expression(0);
					}
				}

				setState(94);
				match(SEMI);
				setState(96);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BLANK) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << LPAREN) | (1L << BANG) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << Identifier))) != 0)) {
					{
					setState(95);
					expressionList();
					}
				}

				setState(98);
				match(RPAREN);
				setState(99);
				statement();
				}
				break;
			case 5:
				_localctx = new MakeWhileContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(100);
				match(WHILE);
				setState(101);
				match(LPAREN);
				setState(102);
				expression(0);
				setState(103);
				match(RPAREN);
				setState(104);
				statement();
				}
				break;
			case 6:
				_localctx = new MakeStatementNTSContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(106);
				statementNTS();
				}
				break;
			case 7:
				_localctx = new BlankStmntContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(107);
				match(BLANK);
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
		public TerminalNode LPAREN() { return getToken(MiniJavaParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MiniJavaParser.RPAREN, 0); }
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
	public static class BlankStmntNSIContext extends StatementNSIContext {
		public TerminalNode BLANK() { return getToken(MiniJavaParser.BLANK, 0); }
		public BlankStmntNSIContext(StatementNSIContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitBlankStmntNSI(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MakeWhileNSIContext extends StatementNSIContext {
		public TerminalNode WHILE() { return getToken(MiniJavaParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(MiniJavaParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MiniJavaParser.RPAREN, 0); }
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
		enterRule(_localctx, 10, RULE_statementNSI);
		int _la;
		try {
			setState(142);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new MakeBlockNSIContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				block(false);
				}
				break;
			case 2:
				_localctx = new MakeITENSIContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				match(IF);
				setState(112);
				match(LPAREN);
				setState(113);
				expression(0);
				setState(114);
				match(RPAREN);
				setState(115);
				statementNSI();
				setState(116);
				match(ELSE);
				setState(117);
				statementNSI();
				}
				break;
			case 3:
				_localctx = new MakeForNSIContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(119);
				match(FOR);
				setState(120);
				match(LPAREN);
				setState(122);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BLANK) | (1L << BOOLEAN) | (1L << CHAR) | (1L << DOUBLE) | (1L << INT) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << LPAREN) | (1L << BANG) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << Identifier))) != 0)) {
					{
					setState(121);
					forInit();
					}
				}

				setState(124);
				match(SEMI);
				setState(126);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BLANK) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << LPAREN) | (1L << BANG) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << Identifier))) != 0)) {
					{
					setState(125);
					expression(0);
					}
				}

				setState(128);
				match(SEMI);
				setState(130);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BLANK) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << LPAREN) | (1L << BANG) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << Identifier))) != 0)) {
					{
					setState(129);
					expressionList();
					}
				}

				setState(132);
				match(RPAREN);
				setState(133);
				statementNSI();
				}
				break;
			case 4:
				_localctx = new MakeWhileNSIContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(134);
				match(WHILE);
				setState(135);
				match(LPAREN);
				setState(136);
				expression(0);
				setState(137);
				match(RPAREN);
				setState(138);
				statementNSI();
				}
				break;
			case 5:
				_localctx = new MakeStatementNTSNSIContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(140);
				statementNTS();
				}
				break;
			case 6:
				_localctx = new BlankStmntNSIContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(141);
				match(BLANK);
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
		public TerminalNode LPAREN() { return getToken(MiniJavaParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MiniJavaParser.RPAREN, 0); }
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
	public static class MakePrintContext extends StatementNTSContext {
		public TerminalNode PRINT() { return getToken(MiniJavaParser.PRINT, 0); }
		public TerminalNode LPAREN() { return getToken(MiniJavaParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MiniJavaParser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(MiniJavaParser.SEMI, 0); }
		public MakePrintContext(StatementNTSContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMakePrint(this);
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
		enterRule(_localctx, 12, RULE_statementNTS);
		try {
			setState(168);
			switch (_input.LA(1)) {
			case DO:
				_localctx = new MakeDoContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				match(DO);
				setState(145);
				statement();
				setState(146);
				match(WHILE);
				setState(147);
				match(LPAREN);
				setState(148);
				expression(0);
				setState(149);
				match(RPAREN);
				setState(150);
				match(SEMI);
				}
				break;
			case RETURN:
				_localctx = new ReturnContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(152);
				match(RETURN);
				setState(153);
				match(SEMI);
				}
				break;
			case BREAK:
				_localctx = new BreakContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(154);
				match(BREAK);
				setState(155);
				match(SEMI);
				}
				break;
			case CONTINUE:
				_localctx = new ContinueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(156);
				match(CONTINUE);
				setState(157);
				match(SEMI);
				}
				break;
			case SEMI:
				_localctx = new EmptyContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(158);
				match(SEMI);
				}
				break;
			case BLANK:
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
				setState(159);
				expressionStatement();
				setState(160);
				match(SEMI);
				}
				break;
			case PRINT:
				_localctx = new MakePrintContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(162);
				match(PRINT);
				setState(163);
				match(LPAREN);
				setState(164);
				expression(0);
				setState(165);
				match(RPAREN);
				setState(166);
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
		enterRule(_localctx, 14, RULE_forInit);
		try {
			setState(174);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case CHAR:
			case DOUBLE:
			case INT:
				_localctx = new ForInitLVDContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				primitiveType();
				setState(171);
				variableDeclarators();
				}
				break;
			case BLANK:
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
				setState(173);
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
		enterRule(_localctx, 16, RULE_parExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(LPAREN);
			setState(177);
			expression(0);
			setState(178);
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
		enterRule(_localctx, 18, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			expression(0);
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(181);
				match(COMMA);
				setState(182);
				expression(0);
				}
				}
				setState(187);
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
		enterRule(_localctx, 20, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
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
	public static class BlankExprContext extends ExpressionContext {
		public TerminalNode BLANK() { return getToken(MiniJavaParser.BLANK, 0); }
		public BlankExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitBlankExpr(this);
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			switch (_input.LA(1)) {
			case Identifier:
				{
				_localctx = new MakeIDContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(191);
				match(Identifier);
				}
				break;
			case LPAREN:
				{
				_localctx = new MakeBracketedContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(192);
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
				setState(193);
				literal();
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
				setState(198);
				switch (_input.LA(1)) {
				case ADD:
					{
					setState(194);
					((PreIncEtcContext)_localctx).op = match(ADD);
					}
					break;
				case SUB:
					{
					setState(195);
					((PreIncEtcContext)_localctx).op = match(SUB);
					}
					break;
				case INC:
					{
					setState(196);
					((PreIncEtcContext)_localctx).op = match(INC);
					}
					break;
				case DEC:
					{
					setState(197);
					((PreIncEtcContext)_localctx).op = match(DEC);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(200);
				expression(11);
				}
				break;
			case BANG:
				{
				_localctx = new MakeNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(201);
				match(BANG);
				setState(202);
				expression(10);
				}
				break;
			case BLANK:
				{
				_localctx = new BlankExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(203);
				match(BLANK);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(265);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(263);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						_localctx = new MultExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(206);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(209);
						switch (_input.LA(1)) {
						case MUL:
							{
							setState(207);
							((MultExprContext)_localctx).op = match(MUL);
							}
							break;
						case DIV:
							{
							setState(208);
							((MultExprContext)_localctx).op = match(DIV);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(211);
						expression(10);
						}
						break;
					case 2:
						{
						_localctx = new AddExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(212);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(215);
						switch (_input.LA(1)) {
						case ADD:
							{
							setState(213);
							((AddExprContext)_localctx).op = match(ADD);
							}
							break;
						case SUB:
							{
							setState(214);
							((AddExprContext)_localctx).op = match(SUB);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(217);
						expression(9);
						}
						break;
					case 3:
						{
						_localctx = new RelationalExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(218);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(223);
						switch (_input.LA(1)) {
						case LE:
							{
							setState(219);
							((RelationalExprContext)_localctx).op = match(LE);
							}
							break;
						case GE:
							{
							setState(220);
							((RelationalExprContext)_localctx).op = match(GE);
							}
							break;
						case GT:
							{
							setState(221);
							((RelationalExprContext)_localctx).op = match(GT);
							}
							break;
						case LT:
							{
							setState(222);
							((RelationalExprContext)_localctx).op = match(LT);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(225);
						expression(8);
						}
						break;
					case 4:
						{
						_localctx = new EqExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(226);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(229);
						switch (_input.LA(1)) {
						case EQUAL:
							{
							setState(227);
							((EqExprContext)_localctx).op = match(EQUAL);
							}
							break;
						case NOTEQUAL:
							{
							setState(228);
							((EqExprContext)_localctx).op = match(NOTEQUAL);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(231);
						expression(7);
						}
						break;
					case 5:
						{
						_localctx = new AndExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(232);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(233);
						match(AND);
						setState(234);
						expression(6);
						}
						break;
					case 6:
						{
						_localctx = new OrExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(235);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(236);
						match(OR);
						setState(237);
						expression(5);
						}
						break;
					case 7:
						{
						_localctx = new CondExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(238);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(239);
						match(QUESTION);
						setState(240);
						expression(0);
						setState(241);
						match(COLON);
						setState(242);
						expression(3);
						}
						break;
					case 8:
						{
						_localctx = new AssignExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(244);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(250);
						switch (_input.LA(1)) {
						case ASSIGN:
							{
							setState(245);
							((AssignExprContext)_localctx).op = match(ASSIGN);
							}
							break;
						case ADD_ASSIGN:
							{
							setState(246);
							((AssignExprContext)_localctx).op = match(ADD_ASSIGN);
							}
							break;
						case SUB_ASSIGN:
							{
							setState(247);
							((AssignExprContext)_localctx).op = match(SUB_ASSIGN);
							}
							break;
						case MUL_ASSIGN:
							{
							setState(248);
							((AssignExprContext)_localctx).op = match(MUL_ASSIGN);
							}
							break;
						case DIV_ASSIGN:
							{
							setState(249);
							((AssignExprContext)_localctx).op = match(DIV_ASSIGN);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(252);
						expression(2);
						}
						break;
					case 9:
						{
						_localctx = new ArrayAccessContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(253);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(254);
						match(LBRACK);
						setState(255);
						expression(0);
						setState(256);
						match(RBRACK);
						}
						break;
					case 10:
						{
						_localctx = new PostIncContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(258);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(261);
						switch (_input.LA(1)) {
						case INC:
							{
							setState(259);
							((PostIncContext)_localctx).op = match(INC);
							}
							break;
						case DEC:
							{
							setState(260);
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
				setState(267);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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
		enterRule(_localctx, 24, RULE_variableDeclarators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			variableDeclarator();
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(269);
				match(COMMA);
				setState(270);
				variableDeclarator();
				}
				}
				setState(275);
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
	public static class BlankVarDecContext extends VariableDeclaratorContext {
		public TerminalNode BLANK() { return getToken(MiniJavaParser.BLANK, 0); }
		public BlankVarDecContext(VariableDeclaratorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitBlankVarDec(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayVarDecContext extends VariableDeclaratorContext {
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
		enterRule(_localctx, 26, RULE_variableDeclarator);
		int _la;
		try {
			setState(289);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				_localctx = new ArrayVarDecContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(276);
				match(Identifier);
				setState(277);
				match(LBRACK);
				setState(278);
				match(RBRACK);
				setState(281);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(279);
					match(ASSIGN);
					setState(280);
					variableInitializer();
					}
				}

				}
				break;
			case 2:
				_localctx = new SingleVarDecContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(283);
				match(Identifier);
				setState(286);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(284);
					match(ASSIGN);
					setState(285);
					variableInitializer();
					}
				}

				}
				break;
			case 3:
				_localctx = new BlankVarDecContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(288);
				match(BLANK);
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
		public VariableInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableInitializer; }
	 
		public VariableInitializerContext() { }
		public void copyFrom(VariableInitializerContext ctx) {
			super.copyFrom(ctx);
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

	public final VariableInitializerContext variableInitializer() throws RecognitionException {
		VariableInitializerContext _localctx = new VariableInitializerContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_variableInitializer);
		try {
			setState(294);
			switch (_input.LA(1)) {
			case LBRACE:
				_localctx = new ArrayInitValsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(291);
				arrayInitializerValues();
				}
				break;
			case NEW:
				_localctx = new ArrayInitSizeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(292);
				arrayInitializerSize();
				}
				break;
			case BLANK:
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
				setState(293);
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
		public ArrayInitializerValuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayInitializerValues; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitArrayInitializerValues(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayInitializerValuesContext arrayInitializerValues() throws RecognitionException {
		ArrayInitializerValuesContext _localctx = new ArrayInitializerValuesContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_arrayInitializerValues);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			match(LBRACE);
			setState(297);
			variableInitializer();
			setState(302);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(298);
					match(COMMA);
					setState(299);
					variableInitializer();
					}
					} 
				}
				setState(304);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			setState(306);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(305);
				match(COMMA);
				}
			}

			setState(308);
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
		public TerminalNode NEW() { return getToken(MiniJavaParser.NEW, 0); }
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TerminalNode LBRACK() { return getToken(MiniJavaParser.LBRACK, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(MiniJavaParser.RBRACK, 0); }
		public ArrayInitializerSizeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayInitializerSize; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitArrayInitializerSize(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayInitializerSizeContext arrayInitializerSize() throws RecognitionException {
		ArrayInitializerSizeContext _localctx = new ArrayInitializerSizeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_arrayInitializerSize);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			match(NEW);
			setState(311);
			primitiveType();
			setState(312);
			match(LBRACK);
			setState(313);
			expression(0);
			setState(314);
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
		enterRule(_localctx, 34, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
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
		enterRule(_localctx, 36, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
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
		case 11:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 2);
		case 8:
			return precpred(_ctx, 15);
		case 9:
			return precpred(_ctx, 12);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\38\u0143\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\6\2+\n\2\r\2\16\2,\3\2\3\2\3\2\5\2\62\n\2"+
		"\3\3\3\3\7\3\66\n\3\f\3\16\39\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4"+
		"C\n\4\3\5\3\5\5\5G\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\5\6[\n\6\3\6\3\6\5\6_\n\6\3\6\3\6\5\6c\n\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6o\n\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7}\n\7\3\7\3\7\5\7\u0081\n\7\3\7\3\7\5\7"+
		"\u0085\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0091\n\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\5\b\u00ab\n\b\3\t\3\t\3\t\3\t\5\t\u00b1\n\t\3\n\3"+
		"\n\3\n\3\n\3\13\3\13\3\13\7\13\u00ba\n\13\f\13\16\13\u00bd\13\13\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00c9\n\r\3\r\3\r\3\r\3\r\5\r\u00cf"+
		"\n\r\3\r\3\r\3\r\5\r\u00d4\n\r\3\r\3\r\3\r\3\r\5\r\u00da\n\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\5\r\u00e2\n\r\3\r\3\r\3\r\3\r\5\r\u00e8\n\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00fd"+
		"\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0108\n\r\7\r\u010a\n\r\f"+
		"\r\16\r\u010d\13\r\3\16\3\16\3\16\7\16\u0112\n\16\f\16\16\16\u0115\13"+
		"\16\3\17\3\17\3\17\3\17\3\17\5\17\u011c\n\17\3\17\3\17\3\17\5\17\u0121"+
		"\n\17\3\17\5\17\u0124\n\17\3\20\3\20\3\20\5\20\u0129\n\20\3\21\3\21\3"+
		"\21\3\21\7\21\u012f\n\21\f\21\16\21\u0132\13\21\3\21\5\21\u0135\n\21\3"+
		"\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\24\2\3\30"+
		"\25\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\4\6\2\4\4\6\6\t\t\r"+
		"\r\3\2\21\24\u0177\2\61\3\2\2\2\4\63\3\2\2\2\6B\3\2\2\2\bF\3\2\2\2\nn"+
		"\3\2\2\2\f\u0090\3\2\2\2\16\u00aa\3\2\2\2\20\u00b0\3\2\2\2\22\u00b2\3"+
		"\2\2\2\24\u00b6\3\2\2\2\26\u00be\3\2\2\2\30\u00ce\3\2\2\2\32\u010e\3\2"+
		"\2\2\34\u0123\3\2\2\2\36\u0128\3\2\2\2 \u012a\3\2\2\2\"\u0138\3\2\2\2"+
		"$\u013e\3\2\2\2&\u0140\3\2\2\2(\62\5\4\3\2)+\5\6\4\2*)\3\2\2\2+,\3\2\2"+
		"\2,*\3\2\2\2,-\3\2\2\2-\62\3\2\2\2.\62\5\b\5\2/\62\5\30\r\2\60\62\7\3"+
		"\2\2\61(\3\2\2\2\61*\3\2\2\2\61.\3\2\2\2\61/\3\2\2\2\61\60\3\2\2\2\62"+
		"\3\3\2\2\2\63\67\7\27\2\2\64\66\5\6\4\2\65\64\3\2\2\2\669\3\2\2\2\67\65"+
		"\3\2\2\2\678\3\2\2\28:\3\2\2\29\67\3\2\2\2:;\7\30\2\2;\5\3\2\2\2<=\5$"+
		"\23\2=>\5\32\16\2>?\7\33\2\2?C\3\2\2\2@C\5\n\6\2AC\5\34\17\2B<\3\2\2\2"+
		"B@\3\2\2\2BA\3\2\2\2C\7\3\2\2\2DG\5\n\6\2EG\5\f\7\2FD\3\2\2\2FE\3\2\2"+
		"\2G\t\3\2\2\2Ho\5\4\3\2IJ\7\f\2\2JK\7\25\2\2KL\5\30\r\2LM\7\26\2\2MN\5"+
		"\n\6\2No\3\2\2\2OP\7\f\2\2PQ\7\25\2\2QR\5\30\r\2RS\7\26\2\2ST\5\f\7\2"+
		"TU\7\n\2\2UV\5\n\6\2Vo\3\2\2\2WX\7\13\2\2XZ\7\25\2\2Y[\5\20\t\2ZY\3\2"+
		"\2\2Z[\3\2\2\2[\\\3\2\2\2\\^\7\33\2\2]_\5\30\r\2^]\3\2\2\2^_\3\2\2\2_"+
		"`\3\2\2\2`b\7\33\2\2ac\5\24\13\2ba\3\2\2\2bc\3\2\2\2cd\3\2\2\2de\7\26"+
		"\2\2eo\5\n\6\2fg\7\20\2\2gh\7\25\2\2hi\5\30\r\2ij\7\26\2\2jk\5\n\6\2k"+
		"o\3\2\2\2lo\5\16\b\2mo\7\3\2\2nH\3\2\2\2nI\3\2\2\2nO\3\2\2\2nW\3\2\2\2"+
		"nf\3\2\2\2nl\3\2\2\2nm\3\2\2\2o\13\3\2\2\2p\u0091\5\4\3\2qr\7\f\2\2rs"+
		"\7\25\2\2st\5\30\r\2tu\7\26\2\2uv\5\f\7\2vw\7\n\2\2wx\5\f\7\2x\u0091\3"+
		"\2\2\2yz\7\13\2\2z|\7\25\2\2{}\5\20\t\2|{\3\2\2\2|}\3\2\2\2}~\3\2\2\2"+
		"~\u0080\7\33\2\2\177\u0081\5\30\r\2\u0080\177\3\2\2\2\u0080\u0081\3\2"+
		"\2\2\u0081\u0082\3\2\2\2\u0082\u0084\7\33\2\2\u0083\u0085\5\24\13\2\u0084"+
		"\u0083\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\7\26"+
		"\2\2\u0087\u0091\5\f\7\2\u0088\u0089\7\20\2\2\u0089\u008a\7\25\2\2\u008a"+
		"\u008b\5\30\r\2\u008b\u008c\7\26\2\2\u008c\u008d\5\f\7\2\u008d\u0091\3"+
		"\2\2\2\u008e\u0091\5\16\b\2\u008f\u0091\7\3\2\2\u0090p\3\2\2\2\u0090q"+
		"\3\2\2\2\u0090y\3\2\2\2\u0090\u0088\3\2\2\2\u0090\u008e\3\2\2\2\u0090"+
		"\u008f\3\2\2\2\u0091\r\3\2\2\2\u0092\u0093\7\b\2\2\u0093\u0094\5\n\6\2"+
		"\u0094\u0095\7\20\2\2\u0095\u0096\7\25\2\2\u0096\u0097\5\30\r\2\u0097"+
		"\u0098\7\26\2\2\u0098\u0099\7\33\2\2\u0099\u00ab\3\2\2\2\u009a\u009b\7"+
		"\17\2\2\u009b\u00ab\7\33\2\2\u009c\u009d\7\5\2\2\u009d\u00ab\7\33\2\2"+
		"\u009e\u009f\7\7\2\2\u009f\u00ab\7\33\2\2\u00a0\u00ab\7\33\2\2\u00a1\u00a2"+
		"\5\26\f\2\u00a2\u00a3\7\33\2\2\u00a3\u00ab\3\2\2\2\u00a4\u00a5\7\64\2"+
		"\2\u00a5\u00a6\7\25\2\2\u00a6\u00a7\5\30\r\2\u00a7\u00a8\7\26\2\2\u00a8"+
		"\u00a9\7\33\2\2\u00a9\u00ab\3\2\2\2\u00aa\u0092\3\2\2\2\u00aa\u009a\3"+
		"\2\2\2\u00aa\u009c\3\2\2\2\u00aa\u009e\3\2\2\2\u00aa\u00a0\3\2\2\2\u00aa"+
		"\u00a1\3\2\2\2\u00aa\u00a4\3\2\2\2\u00ab\17\3\2\2\2\u00ac\u00ad\5$\23"+
		"\2\u00ad\u00ae\5\32\16\2\u00ae\u00b1\3\2\2\2\u00af\u00b1\5\24\13\2\u00b0"+
		"\u00ac\3\2\2\2\u00b0\u00af\3\2\2\2\u00b1\21\3\2\2\2\u00b2\u00b3\7\25\2"+
		"\2\u00b3\u00b4\5\30\r\2\u00b4\u00b5\7\26\2\2\u00b5\23\3\2\2\2\u00b6\u00bb"+
		"\5\30\r\2\u00b7\u00b8\7\34\2\2\u00b8\u00ba\5\30\r\2\u00b9\u00b7\3\2\2"+
		"\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\25"+
		"\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00bf\5\30\r\2\u00bf\27\3\2\2\2\u00c0"+
		"\u00c1\b\r\1\2\u00c1\u00cf\7\65\2\2\u00c2\u00cf\5\22\n\2\u00c3\u00cf\5"+
		"&\24\2\u00c4\u00c9\7,\2\2\u00c5\u00c9\7-\2\2\u00c6\u00c9\7*\2\2\u00c7"+
		"\u00c9\7+\2\2\u00c8\u00c4\3\2\2\2\u00c8\u00c5\3\2\2\2\u00c8\u00c6\3\2"+
		"\2\2\u00c8\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cf\5\30\r\r\u00cb"+
		"\u00cc\7!\2\2\u00cc\u00cf\5\30\r\f\u00cd\u00cf\7\3\2\2\u00ce\u00c0\3\2"+
		"\2\2\u00ce\u00c2\3\2\2\2\u00ce\u00c3\3\2\2\2\u00ce\u00c8\3\2\2\2\u00ce"+
		"\u00cb\3\2\2\2\u00ce\u00cd\3\2\2\2\u00cf\u010b\3\2\2\2\u00d0\u00d3\f\13"+
		"\2\2\u00d1\u00d4\7.\2\2\u00d2\u00d4\7/\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d2"+
		"\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u010a\5\30\r\f\u00d6\u00d9\f\n\2\2"+
		"\u00d7\u00da\7,\2\2\u00d8\u00da\7-\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00d8"+
		"\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u010a\5\30\r\13\u00dc\u00e1\f\t\2\2"+
		"\u00dd\u00e2\7%\2\2\u00de\u00e2\7&\2\2\u00df\u00e2\7\37\2\2\u00e0\u00e2"+
		"\7 \2\2\u00e1\u00dd\3\2\2\2\u00e1\u00de\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1"+
		"\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u010a\5\30\r\n\u00e4\u00e7\f"+
		"\b\2\2\u00e5\u00e8\7$\2\2\u00e6\u00e8\7\'\2\2\u00e7\u00e5\3\2\2\2\u00e7"+
		"\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u010a\5\30\r\t\u00ea\u00eb\f"+
		"\7\2\2\u00eb\u00ec\7(\2\2\u00ec\u010a\5\30\r\b\u00ed\u00ee\f\6\2\2\u00ee"+
		"\u00ef\7)\2\2\u00ef\u010a\5\30\r\7\u00f0\u00f1\f\5\2\2\u00f1\u00f2\7\""+
		"\2\2\u00f2\u00f3\5\30\r\2\u00f3\u00f4\7#\2\2\u00f4\u00f5\5\30\r\5\u00f5"+
		"\u010a\3\2\2\2\u00f6\u00fc\f\4\2\2\u00f7\u00fd\7\36\2\2\u00f8\u00fd\7"+
		"\60\2\2\u00f9\u00fd\7\61\2\2\u00fa\u00fd\7\62\2\2\u00fb\u00fd\7\63\2\2"+
		"\u00fc\u00f7\3\2\2\2\u00fc\u00f8\3\2\2\2\u00fc\u00f9\3\2\2\2\u00fc\u00fa"+
		"\3\2\2\2\u00fc\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u010a\5\30\r\4"+
		"\u00ff\u0100\f\21\2\2\u0100\u0101\7\31\2\2\u0101\u0102\5\30\r\2\u0102"+
		"\u0103\7\32\2\2\u0103\u010a\3\2\2\2\u0104\u0107\f\16\2\2\u0105\u0108\7"+
		"*\2\2\u0106\u0108\7+\2\2\u0107\u0105\3\2\2\2\u0107\u0106\3\2\2\2\u0108"+
		"\u010a\3\2\2\2\u0109\u00d0\3\2\2\2\u0109\u00d6\3\2\2\2\u0109\u00dc\3\2"+
		"\2\2\u0109\u00e4\3\2\2\2\u0109\u00ea\3\2\2\2\u0109\u00ed\3\2\2\2\u0109"+
		"\u00f0\3\2\2\2\u0109\u00f6\3\2\2\2\u0109\u00ff\3\2\2\2\u0109\u0104\3\2"+
		"\2\2\u010a\u010d\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c"+
		"\31\3\2\2\2\u010d\u010b\3\2\2\2\u010e\u0113\5\34\17\2\u010f\u0110\7\34"+
		"\2\2\u0110\u0112\5\34\17\2\u0111\u010f\3\2\2\2\u0112\u0115\3\2\2\2\u0113"+
		"\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114\33\3\2\2\2\u0115\u0113\3\2\2"+
		"\2\u0116\u0117\7\65\2\2\u0117\u0118\7\31\2\2\u0118\u011b\7\32\2\2\u0119"+
		"\u011a\7\36\2\2\u011a\u011c\5\36\20\2\u011b\u0119\3\2\2\2\u011b\u011c"+
		"\3\2\2\2\u011c\u0124\3\2\2\2\u011d\u0120\7\65\2\2\u011e\u011f\7\36\2\2"+
		"\u011f\u0121\5\36\20\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0124"+
		"\3\2\2\2\u0122\u0124\7\3\2\2\u0123\u0116\3\2\2\2\u0123\u011d\3\2\2\2\u0123"+
		"\u0122\3\2\2\2\u0124\35\3\2\2\2\u0125\u0129\5 \21\2\u0126\u0129\5\"\22"+
		"\2\u0127\u0129\5\30\r\2\u0128\u0125\3\2\2\2\u0128\u0126\3\2\2\2\u0128"+
		"\u0127\3\2\2\2\u0129\37\3\2\2\2\u012a\u012b\7\27\2\2\u012b\u0130\5\36"+
		"\20\2\u012c\u012d\7\34\2\2\u012d\u012f\5\36\20\2\u012e\u012c\3\2\2\2\u012f"+
		"\u0132\3\2\2\2\u0130\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0134\3\2"+
		"\2\2\u0132\u0130\3\2\2\2\u0133\u0135\7\34\2\2\u0134\u0133\3\2\2\2\u0134"+
		"\u0135\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0137\7\30\2\2\u0137!\3\2\2\2"+
		"\u0138\u0139\7\16\2\2\u0139\u013a\5$\23\2\u013a\u013b\7\31\2\2\u013b\u013c"+
		"\5\30\r\2\u013c\u013d\7\32\2\2\u013d#\3\2\2\2\u013e\u013f\t\2\2\2\u013f"+
		"%\3\2\2\2\u0140\u0141\t\3\2\2\u0141\'\3\2\2\2#,\61\67BFZ^bn|\u0080\u0084"+
		"\u0090\u00aa\u00b0\u00bb\u00c8\u00ce\u00d3\u00d9\u00e1\u00e7\u00fc\u0107"+
		"\u0109\u010b\u0113\u011b\u0120\u0123\u0128\u0130\u0134";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}