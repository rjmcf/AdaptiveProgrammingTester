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
		ADD_ASSIGN=45, SUB_ASSIGN=46, MUL_ASSIGN=47, DIV_ASSIGN=48, PRINT=49, 
		Identifier=50, WS=51, COMMENT=52, LINE_COMMENT=53;
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
		null, "'boolean'", "'break'", "'char'", "'continue'", "'do'", "'double'", 
		"'else'", "'for'", "'if'", "'int'", "'new'", "'return'", "'while'", null, 
		null, null, null, "'('", "')'", "'{'", "'}'", "'['", "']'", "';'", "','", 
		"'.'", "'='", "'>'", "'<'", "'!'", "'?'", "':'", "'=='", "'<='", "'>='", 
		"'!='", "'&&'", "'||'", "'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'+='", 
		"'-='", "'*='", "'/='", "'System.out.println'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "BOOLEAN", "BREAK", "CHAR", "CONTINUE", "DO", "DOUBLE", "ELSE", 
		"FOR", "IF", "INT", "NEW", "RETURN", "WHILE", "IntegerLiteral", "FloatingPointLiteral", 
		"BooleanLiteral", "CharacterLiteral", "LPAREN", "RPAREN", "LBRACE", "RBRACE", 
		"LBRACK", "RBRACK", "SEMI", "COMMA", "DOT", "ASSIGN", "GT", "LT", "BANG", 
		"QUESTION", "COLON", "EQUAL", "LE", "GE", "NOTEQUAL", "AND", "OR", "INC", 
		"DEC", "ADD", "SUB", "MUL", "DIV", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", 
		"DIV_ASSIGN", "PRINT", "Identifier", "WS", "COMMENT", "LINE_COMMENT"
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

	public final EntryContext entry() throws RecognitionException {
		EntryContext _localctx = new EntryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_entry);
		int _la;
		try {
			setState(46);
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
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BREAK) | (1L << CHAR) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << RETURN) | (1L << WHILE) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << LPAREN) | (1L << LBRACE) | (1L << SEMI) | (1L << BANG) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << PRINT) | (1L << Identifier))) != 0) );
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
			setState(48);
			match(LBRACE);
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BREAK) | (1L << CHAR) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << RETURN) | (1L << WHILE) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << LPAREN) | (1L << LBRACE) | (1L << SEMI) | (1L << BANG) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << PRINT) | (1L << Identifier))) != 0)) {
				{
				{
				setState(49);
				blockStatement();
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55);
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
			setState(63);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new LocalVariableDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				primitiveType();
				setState(58);
				variableDeclarators();
				setState(59);
				match(SEMI);
				}
				break;
			case 2:
				_localctx = new MakeStmntContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				statement();
				}
				break;
			case 3:
				_localctx = new MakeVarDecContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(62);
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
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new StmntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				statement();
				}
				break;
			case 2:
				_localctx = new StmntNSIContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
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
		enterRule(_localctx, 8, RULE_statement);
		int _la;
		try {
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new MakeBlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				block(false);
				}
				break;
			case 2:
				_localctx = new MakeIfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				match(IF);
				setState(71);
				parExpression();
				setState(72);
				statement();
				}
				break;
			case 3:
				_localctx = new MakeITEContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				match(IF);
				setState(75);
				parExpression();
				setState(76);
				statementNSI();
				setState(77);
				match(ELSE);
				setState(78);
				statement();
				}
				break;
			case 4:
				_localctx = new MakeForContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(80);
				match(FOR);
				setState(81);
				match(LPAREN);
				setState(83);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << CHAR) | (1L << DOUBLE) | (1L << INT) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << LPAREN) | (1L << BANG) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << Identifier))) != 0)) {
					{
					setState(82);
					forInit();
					}
				}

				setState(85);
				match(SEMI);
				setState(87);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << LPAREN) | (1L << BANG) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << Identifier))) != 0)) {
					{
					setState(86);
					expression(0);
					}
				}

				setState(89);
				match(SEMI);
				setState(91);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << LPAREN) | (1L << BANG) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << Identifier))) != 0)) {
					{
					setState(90);
					expressionList();
					}
				}

				setState(93);
				match(RPAREN);
				setState(94);
				statement();
				}
				break;
			case 5:
				_localctx = new MakeWhileContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(95);
				match(WHILE);
				setState(96);
				parExpression();
				setState(97);
				statement();
				}
				break;
			case 6:
				_localctx = new MakeStatementNTSContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(99);
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
		enterRule(_localctx, 10, RULE_statementNSI);
		int _la;
		try {
			setState(129);
			switch (_input.LA(1)) {
			case LBRACE:
				_localctx = new MakeBlockNSIContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				block(false);
				}
				break;
			case IF:
				_localctx = new MakeITENSIContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				match(IF);
				setState(104);
				parExpression();
				setState(105);
				statementNSI();
				setState(106);
				match(ELSE);
				setState(107);
				statementNSI();
				}
				break;
			case FOR:
				_localctx = new MakeForNSIContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(109);
				match(FOR);
				setState(110);
				match(LPAREN);
				setState(112);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << CHAR) | (1L << DOUBLE) | (1L << INT) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << LPAREN) | (1L << BANG) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << Identifier))) != 0)) {
					{
					setState(111);
					forInit();
					}
				}

				setState(114);
				match(SEMI);
				setState(116);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << LPAREN) | (1L << BANG) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << Identifier))) != 0)) {
					{
					setState(115);
					expression(0);
					}
				}

				setState(118);
				match(SEMI);
				setState(120);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << LPAREN) | (1L << BANG) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << Identifier))) != 0)) {
					{
					setState(119);
					expressionList();
					}
				}

				setState(122);
				match(RPAREN);
				setState(123);
				statementNSI();
				}
				break;
			case WHILE:
				_localctx = new MakeWhileNSIContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(124);
				match(WHILE);
				setState(125);
				parExpression();
				setState(126);
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
			case PRINT:
			case Identifier:
				_localctx = new MakeStatementNTSNSIContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(128);
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
	public static class MakePrintContext extends StatementNTSContext {
		public TerminalNode PRINT() { return getToken(MiniJavaParser.PRINT, 0); }
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
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
			setState(151);
			switch (_input.LA(1)) {
			case DO:
				_localctx = new MakeDoContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				match(DO);
				setState(132);
				statement();
				setState(133);
				match(WHILE);
				setState(134);
				parExpression();
				setState(135);
				match(SEMI);
				}
				break;
			case RETURN:
				_localctx = new ReturnContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				match(RETURN);
				setState(138);
				match(SEMI);
				}
				break;
			case BREAK:
				_localctx = new BreakContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(139);
				match(BREAK);
				setState(140);
				match(SEMI);
				}
				break;
			case CONTINUE:
				_localctx = new ContinueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(141);
				match(CONTINUE);
				setState(142);
				match(SEMI);
				}
				break;
			case SEMI:
				_localctx = new EmptyContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(143);
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
				setState(144);
				expressionStatement();
				setState(145);
				match(SEMI);
				}
				break;
			case PRINT:
				_localctx = new MakePrintContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(147);
				match(PRINT);
				setState(148);
				parExpression();
				setState(149);
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
			setState(157);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case CHAR:
			case DOUBLE:
			case INT:
				_localctx = new ForInitLVDContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				primitiveType();
				setState(154);
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
				setState(156);
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
			setState(159);
			match(LPAREN);
			setState(160);
			expression(0);
			setState(161);
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
			setState(163);
			expression(0);
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(164);
				match(COMMA);
				setState(165);
				expression(0);
				}
				}
				setState(170);
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
			setState(171);
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			switch (_input.LA(1)) {
			case Identifier:
				{
				_localctx = new MakeIDContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(174);
				match(Identifier);
				}
				break;
			case LPAREN:
				{
				_localctx = new MakeBracketedContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(175);
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
				setState(176);
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
				setState(181);
				switch (_input.LA(1)) {
				case ADD:
					{
					setState(177);
					((PreIncEtcContext)_localctx).op = match(ADD);
					}
					break;
				case SUB:
					{
					setState(178);
					((PreIncEtcContext)_localctx).op = match(SUB);
					}
					break;
				case INC:
					{
					setState(179);
					((PreIncEtcContext)_localctx).op = match(INC);
					}
					break;
				case DEC:
					{
					setState(180);
					((PreIncEtcContext)_localctx).op = match(DEC);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(183);
				expression(10);
				}
				break;
			case BANG:
				{
				_localctx = new MakeNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(184);
				match(BANG);
				setState(185);
				expression(9);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(247);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(245);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						_localctx = new MultExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(188);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(191);
						switch (_input.LA(1)) {
						case MUL:
							{
							setState(189);
							((MultExprContext)_localctx).op = match(MUL);
							}
							break;
						case DIV:
							{
							setState(190);
							((MultExprContext)_localctx).op = match(DIV);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(193);
						expression(9);
						}
						break;
					case 2:
						{
						_localctx = new AddExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(194);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(197);
						switch (_input.LA(1)) {
						case ADD:
							{
							setState(195);
							((AddExprContext)_localctx).op = match(ADD);
							}
							break;
						case SUB:
							{
							setState(196);
							((AddExprContext)_localctx).op = match(SUB);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(199);
						expression(8);
						}
						break;
					case 3:
						{
						_localctx = new RelationalExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(200);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(205);
						switch (_input.LA(1)) {
						case LE:
							{
							setState(201);
							((RelationalExprContext)_localctx).op = match(LE);
							}
							break;
						case GE:
							{
							setState(202);
							((RelationalExprContext)_localctx).op = match(GE);
							}
							break;
						case GT:
							{
							setState(203);
							((RelationalExprContext)_localctx).op = match(GT);
							}
							break;
						case LT:
							{
							setState(204);
							((RelationalExprContext)_localctx).op = match(LT);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(207);
						expression(7);
						}
						break;
					case 4:
						{
						_localctx = new EqExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(208);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(211);
						switch (_input.LA(1)) {
						case EQUAL:
							{
							setState(209);
							((EqExprContext)_localctx).op = match(EQUAL);
							}
							break;
						case NOTEQUAL:
							{
							setState(210);
							((EqExprContext)_localctx).op = match(NOTEQUAL);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(213);
						expression(6);
						}
						break;
					case 5:
						{
						_localctx = new AndExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(214);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(215);
						match(AND);
						setState(216);
						expression(5);
						}
						break;
					case 6:
						{
						_localctx = new OrExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(217);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(218);
						match(OR);
						setState(219);
						expression(4);
						}
						break;
					case 7:
						{
						_localctx = new CondExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(220);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(221);
						match(QUESTION);
						setState(222);
						expression(0);
						setState(223);
						match(COLON);
						setState(224);
						expression(2);
						}
						break;
					case 8:
						{
						_localctx = new AssignExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(226);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(232);
						switch (_input.LA(1)) {
						case ASSIGN:
							{
							setState(227);
							((AssignExprContext)_localctx).op = match(ASSIGN);
							}
							break;
						case ADD_ASSIGN:
							{
							setState(228);
							((AssignExprContext)_localctx).op = match(ADD_ASSIGN);
							}
							break;
						case SUB_ASSIGN:
							{
							setState(229);
							((AssignExprContext)_localctx).op = match(SUB_ASSIGN);
							}
							break;
						case MUL_ASSIGN:
							{
							setState(230);
							((AssignExprContext)_localctx).op = match(MUL_ASSIGN);
							}
							break;
						case DIV_ASSIGN:
							{
							setState(231);
							((AssignExprContext)_localctx).op = match(DIV_ASSIGN);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(234);
						expression(1);
						}
						break;
					case 9:
						{
						_localctx = new ArrayAccessContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(235);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(236);
						match(LBRACK);
						setState(237);
						expression(0);
						setState(238);
						match(RBRACK);
						}
						break;
					case 10:
						{
						_localctx = new PostIncContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(240);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(243);
						switch (_input.LA(1)) {
						case INC:
							{
							setState(241);
							((PostIncContext)_localctx).op = match(INC);
							}
							break;
						case DEC:
							{
							setState(242);
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
				setState(249);
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
			setState(250);
			variableDeclarator();
			setState(255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(251);
				match(COMMA);
				setState(252);
				variableDeclarator();
				}
				}
				setState(257);
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
			setState(270);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				_localctx = new ArrayVarDecContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(258);
				match(Identifier);
				setState(259);
				match(LBRACK);
				setState(260);
				match(RBRACK);
				setState(263);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(261);
					match(ASSIGN);
					setState(262);
					variableInitializer();
					}
				}

				}
				break;
			case 2:
				_localctx = new SingleVarDecContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(265);
				match(Identifier);
				setState(268);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(266);
					match(ASSIGN);
					setState(267);
					variableInitializer();
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
			setState(275);
			switch (_input.LA(1)) {
			case LBRACE:
				_localctx = new ArrayInitValsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(272);
				arrayInitializerValues();
				}
				break;
			case NEW:
				_localctx = new ArrayInitSizeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(273);
				arrayInitializerSize();
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
				setState(274);
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
			setState(277);
			match(LBRACE);
			setState(278);
			variableInitializer();
			setState(283);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(279);
					match(COMMA);
					setState(280);
					variableInitializer();
					}
					} 
				}
				setState(285);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			setState(287);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(286);
				match(COMMA);
				}
			}

			setState(289);
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
			setState(291);
			match(NEW);
			setState(292);
			primitiveType();
			setState(293);
			match(LBRACK);
			setState(294);
			expression(0);
			setState(295);
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
			setState(297);
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
			setState(299);
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
			return precpred(_ctx, 14);
		case 9:
			return precpred(_ctx, 11);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\67\u0130\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\6\2+\n\2\r\2\16\2,\3\2\3\2\5\2\61\n\2\3\3"+
		"\3\3\7\3\65\n\3\f\3\16\38\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4B\n"+
		"\4\3\5\3\5\5\5F\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\5\6V\n\6\3\6\3\6\5\6Z\n\6\3\6\3\6\5\6^\n\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\5\6g\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7s\n\7\3\7"+
		"\3\7\5\7w\n\7\3\7\3\7\5\7{\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0084\n"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\5\b\u009a\n\b\3\t\3\t\3\t\3\t\5\t\u00a0\n\t\3\n\3\n\3\n\3"+
		"\n\3\13\3\13\3\13\7\13\u00a9\n\13\f\13\16\13\u00ac\13\13\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00b8\n\r\3\r\3\r\3\r\5\r\u00bd\n\r\3\r"+
		"\3\r\3\r\5\r\u00c2\n\r\3\r\3\r\3\r\3\r\5\r\u00c8\n\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\5\r\u00d0\n\r\3\r\3\r\3\r\3\r\5\r\u00d6\n\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00eb\n\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00f6\n\r\7\r\u00f8\n\r\f\r\16"+
		"\r\u00fb\13\r\3\16\3\16\3\16\7\16\u0100\n\16\f\16\16\16\u0103\13\16\3"+
		"\17\3\17\3\17\3\17\3\17\5\17\u010a\n\17\3\17\3\17\3\17\5\17\u010f\n\17"+
		"\5\17\u0111\n\17\3\20\3\20\3\20\5\20\u0116\n\20\3\21\3\21\3\21\3\21\7"+
		"\21\u011c\n\21\f\21\16\21\u011f\13\21\3\21\5\21\u0122\n\21\3\21\3\21\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\24\2\3\30\25\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\4\6\2\3\3\5\5\b\b\f\f\3\2\20"+
		"\23\u015f\2\60\3\2\2\2\4\62\3\2\2\2\6A\3\2\2\2\bE\3\2\2\2\nf\3\2\2\2\f"+
		"\u0083\3\2\2\2\16\u0099\3\2\2\2\20\u009f\3\2\2\2\22\u00a1\3\2\2\2\24\u00a5"+
		"\3\2\2\2\26\u00ad\3\2\2\2\30\u00bc\3\2\2\2\32\u00fc\3\2\2\2\34\u0110\3"+
		"\2\2\2\36\u0115\3\2\2\2 \u0117\3\2\2\2\"\u0125\3\2\2\2$\u012b\3\2\2\2"+
		"&\u012d\3\2\2\2(\61\5\4\3\2)+\5\6\4\2*)\3\2\2\2+,\3\2\2\2,*\3\2\2\2,-"+
		"\3\2\2\2-\61\3\2\2\2.\61\5\b\5\2/\61\5\30\r\2\60(\3\2\2\2\60*\3\2\2\2"+
		"\60.\3\2\2\2\60/\3\2\2\2\61\3\3\2\2\2\62\66\7\26\2\2\63\65\5\6\4\2\64"+
		"\63\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\679\3\2\2\28\66\3"+
		"\2\2\29:\7\27\2\2:\5\3\2\2\2;<\5$\23\2<=\5\32\16\2=>\7\32\2\2>B\3\2\2"+
		"\2?B\5\n\6\2@B\5\34\17\2A;\3\2\2\2A?\3\2\2\2A@\3\2\2\2B\7\3\2\2\2CF\5"+
		"\n\6\2DF\5\f\7\2EC\3\2\2\2ED\3\2\2\2F\t\3\2\2\2Gg\5\4\3\2HI\7\13\2\2I"+
		"J\5\22\n\2JK\5\n\6\2Kg\3\2\2\2LM\7\13\2\2MN\5\22\n\2NO\5\f\7\2OP\7\t\2"+
		"\2PQ\5\n\6\2Qg\3\2\2\2RS\7\n\2\2SU\7\24\2\2TV\5\20\t\2UT\3\2\2\2UV\3\2"+
		"\2\2VW\3\2\2\2WY\7\32\2\2XZ\5\30\r\2YX\3\2\2\2YZ\3\2\2\2Z[\3\2\2\2[]\7"+
		"\32\2\2\\^\5\24\13\2]\\\3\2\2\2]^\3\2\2\2^_\3\2\2\2_`\7\25\2\2`g\5\n\6"+
		"\2ab\7\17\2\2bc\5\22\n\2cd\5\n\6\2dg\3\2\2\2eg\5\16\b\2fG\3\2\2\2fH\3"+
		"\2\2\2fL\3\2\2\2fR\3\2\2\2fa\3\2\2\2fe\3\2\2\2g\13\3\2\2\2h\u0084\5\4"+
		"\3\2ij\7\13\2\2jk\5\22\n\2kl\5\f\7\2lm\7\t\2\2mn\5\f\7\2n\u0084\3\2\2"+
		"\2op\7\n\2\2pr\7\24\2\2qs\5\20\t\2rq\3\2\2\2rs\3\2\2\2st\3\2\2\2tv\7\32"+
		"\2\2uw\5\30\r\2vu\3\2\2\2vw\3\2\2\2wx\3\2\2\2xz\7\32\2\2y{\5\24\13\2z"+
		"y\3\2\2\2z{\3\2\2\2{|\3\2\2\2|}\7\25\2\2}\u0084\5\f\7\2~\177\7\17\2\2"+
		"\177\u0080\5\22\n\2\u0080\u0081\5\f\7\2\u0081\u0084\3\2\2\2\u0082\u0084"+
		"\5\16\b\2\u0083h\3\2\2\2\u0083i\3\2\2\2\u0083o\3\2\2\2\u0083~\3\2\2\2"+
		"\u0083\u0082\3\2\2\2\u0084\r\3\2\2\2\u0085\u0086\7\7\2\2\u0086\u0087\5"+
		"\n\6\2\u0087\u0088\7\17\2\2\u0088\u0089\5\22\n\2\u0089\u008a\7\32\2\2"+
		"\u008a\u009a\3\2\2\2\u008b\u008c\7\16\2\2\u008c\u009a\7\32\2\2\u008d\u008e"+
		"\7\4\2\2\u008e\u009a\7\32\2\2\u008f\u0090\7\6\2\2\u0090\u009a\7\32\2\2"+
		"\u0091\u009a\7\32\2\2\u0092\u0093\5\26\f\2\u0093\u0094\7\32\2\2\u0094"+
		"\u009a\3\2\2\2\u0095\u0096\7\63\2\2\u0096\u0097\5\22\n\2\u0097\u0098\7"+
		"\32\2\2\u0098\u009a\3\2\2\2\u0099\u0085\3\2\2\2\u0099\u008b\3\2\2\2\u0099"+
		"\u008d\3\2\2\2\u0099\u008f\3\2\2\2\u0099\u0091\3\2\2\2\u0099\u0092\3\2"+
		"\2\2\u0099\u0095\3\2\2\2\u009a\17\3\2\2\2\u009b\u009c\5$\23\2\u009c\u009d"+
		"\5\32\16\2\u009d\u00a0\3\2\2\2\u009e\u00a0\5\24\13\2\u009f\u009b\3\2\2"+
		"\2\u009f\u009e\3\2\2\2\u00a0\21\3\2\2\2\u00a1\u00a2\7\24\2\2\u00a2\u00a3"+
		"\5\30\r\2\u00a3\u00a4\7\25\2\2\u00a4\23\3\2\2\2\u00a5\u00aa\5\30\r\2\u00a6"+
		"\u00a7\7\33\2\2\u00a7\u00a9\5\30\r\2\u00a8\u00a6\3\2\2\2\u00a9\u00ac\3"+
		"\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\25\3\2\2\2\u00ac"+
		"\u00aa\3\2\2\2\u00ad\u00ae\5\30\r\2\u00ae\27\3\2\2\2\u00af\u00b0\b\r\1"+
		"\2\u00b0\u00bd\7\64\2\2\u00b1\u00bd\5\22\n\2\u00b2\u00bd\5&\24\2\u00b3"+
		"\u00b8\7+\2\2\u00b4\u00b8\7,\2\2\u00b5\u00b8\7)\2\2\u00b6\u00b8\7*\2\2"+
		"\u00b7\u00b3\3\2\2\2\u00b7\u00b4\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b6"+
		"\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00bd\5\30\r\f\u00ba\u00bb\7 \2\2\u00bb"+
		"\u00bd\5\30\r\13\u00bc\u00af\3\2\2\2\u00bc\u00b1\3\2\2\2\u00bc\u00b2\3"+
		"\2\2\2\u00bc\u00b7\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00f9\3\2\2\2\u00be"+
		"\u00c1\f\n\2\2\u00bf\u00c2\7-\2\2\u00c0\u00c2\7.\2\2\u00c1\u00bf\3\2\2"+
		"\2\u00c1\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00f8\5\30\r\13\u00c4"+
		"\u00c7\f\t\2\2\u00c5\u00c8\7+\2\2\u00c6\u00c8\7,\2\2\u00c7\u00c5\3\2\2"+
		"\2\u00c7\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00f8\5\30\r\n\u00ca"+
		"\u00cf\f\b\2\2\u00cb\u00d0\7$\2\2\u00cc\u00d0\7%\2\2\u00cd\u00d0\7\36"+
		"\2\2\u00ce\u00d0\7\37\2\2\u00cf\u00cb\3\2\2\2\u00cf\u00cc\3\2\2\2\u00cf"+
		"\u00cd\3\2\2\2\u00cf\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00f8\5\30"+
		"\r\t\u00d2\u00d5\f\7\2\2\u00d3\u00d6\7#\2\2\u00d4\u00d6\7&\2\2\u00d5\u00d3"+
		"\3\2\2\2\u00d5\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00f8\5\30\r\b"+
		"\u00d8\u00d9\f\6\2\2\u00d9\u00da\7\'\2\2\u00da\u00f8\5\30\r\7\u00db\u00dc"+
		"\f\5\2\2\u00dc\u00dd\7(\2\2\u00dd\u00f8\5\30\r\6\u00de\u00df\f\4\2\2\u00df"+
		"\u00e0\7!\2\2\u00e0\u00e1\5\30\r\2\u00e1\u00e2\7\"\2\2\u00e2\u00e3\5\30"+
		"\r\4\u00e3\u00f8\3\2\2\2\u00e4\u00ea\f\3\2\2\u00e5\u00eb\7\35\2\2\u00e6"+
		"\u00eb\7/\2\2\u00e7\u00eb\7\60\2\2\u00e8\u00eb\7\61\2\2\u00e9\u00eb\7"+
		"\62\2\2\u00ea\u00e5\3\2\2\2\u00ea\u00e6\3\2\2\2\u00ea\u00e7\3\2\2\2\u00ea"+
		"\u00e8\3\2\2\2\u00ea\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00f8\5\30"+
		"\r\3\u00ed\u00ee\f\20\2\2\u00ee\u00ef\7\30\2\2\u00ef\u00f0\5\30\r\2\u00f0"+
		"\u00f1\7\31\2\2\u00f1\u00f8\3\2\2\2\u00f2\u00f5\f\r\2\2\u00f3\u00f6\7"+
		")\2\2\u00f4\u00f6\7*\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f4\3\2\2\2\u00f6"+
		"\u00f8\3\2\2\2\u00f7\u00be\3\2\2\2\u00f7\u00c4\3\2\2\2\u00f7\u00ca\3\2"+
		"\2\2\u00f7\u00d2\3\2\2\2\u00f7\u00d8\3\2\2\2\u00f7\u00db\3\2\2\2\u00f7"+
		"\u00de\3\2\2\2\u00f7\u00e4\3\2\2\2\u00f7\u00ed\3\2\2\2\u00f7\u00f2\3\2"+
		"\2\2\u00f8\u00fb\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa"+
		"\31\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc\u0101\5\34\17\2\u00fd\u00fe\7\33"+
		"\2\2\u00fe\u0100\5\34\17\2\u00ff\u00fd\3\2\2\2\u0100\u0103\3\2\2\2\u0101"+
		"\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\33\3\2\2\2\u0103\u0101\3\2\2"+
		"\2\u0104\u0105\7\64\2\2\u0105\u0106\7\30\2\2\u0106\u0109\7\31\2\2\u0107"+
		"\u0108\7\35\2\2\u0108\u010a\5\36\20\2\u0109\u0107\3\2\2\2\u0109\u010a"+
		"\3\2\2\2\u010a\u0111\3\2\2\2\u010b\u010e\7\64\2\2\u010c\u010d\7\35\2\2"+
		"\u010d\u010f\5\36\20\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0111"+
		"\3\2\2\2\u0110\u0104\3\2\2\2\u0110\u010b\3\2\2\2\u0111\35\3\2\2\2\u0112"+
		"\u0116\5 \21\2\u0113\u0116\5\"\22\2\u0114\u0116\5\30\r\2\u0115\u0112\3"+
		"\2\2\2\u0115\u0113\3\2\2\2\u0115\u0114\3\2\2\2\u0116\37\3\2\2\2\u0117"+
		"\u0118\7\26\2\2\u0118\u011d\5\36\20\2\u0119\u011a\7\33\2\2\u011a\u011c"+
		"\5\36\20\2\u011b\u0119\3\2\2\2\u011c\u011f\3\2\2\2\u011d\u011b\3\2\2\2"+
		"\u011d\u011e\3\2\2\2\u011e\u0121\3\2\2\2\u011f\u011d\3\2\2\2\u0120\u0122"+
		"\7\33\2\2\u0121\u0120\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0123\3\2\2\2"+
		"\u0123\u0124\7\27\2\2\u0124!\3\2\2\2\u0125\u0126\7\r\2\2\u0126\u0127\5"+
		"$\23\2\u0127\u0128\7\30\2\2\u0128\u0129\5\30\r\2\u0129\u012a\7\31\2\2"+
		"\u012a#\3\2\2\2\u012b\u012c\t\2\2\2\u012c%\3\2\2\2\u012d\u012e\t\3\2\2"+
		"\u012e\'\3\2\2\2#,\60\66AEUY]frvz\u0083\u0099\u009f\u00aa\u00b7\u00bc"+
		"\u00c1\u00c7\u00cf\u00d5\u00ea\u00f5\u00f7\u00f9\u0101\u0109\u010e\u0110"+
		"\u0115\u011d\u0121";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}