// Generated from MiniJava.g4 by ANTLR 4.5.3
package antlrParser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiniJavaLexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"BOOLEAN", "BREAK", "CHAR", "CONTINUE", "DO", "DOUBLE", "ELSE", "FOR", 
		"IF", "INT", "NEW", "RETURN", "WHILE", "IntegerLiteral", "DecimalIntegerLiteral", 
		"DecimalNumeral", "Digits", "Digit", "NonZeroDigit", "DigitOrUnderscore", 
		"Underscores", "FloatingPointLiteral", "DecimalFloatingPointLiteral", 
		"ExponentPart", "ExponentIndicator", "SignedInteger", "Sign", "BooleanLiteral", 
		"CharacterLiteral", "SingleCharacter", "LPAREN", "RPAREN", "LBRACE", "RBRACE", 
		"LBRACK", "RBRACK", "SEMI", "COMMA", "DOT", "ASSIGN", "GT", "LT", "BANG", 
		"QUESTION", "COLON", "EQUAL", "LE", "GE", "NOTEQUAL", "AND", "OR", "INC", 
		"DEC", "ADD", "SUB", "MUL", "DIV", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", 
		"DIV_ASSIGN", "PRINT", "Identifier", "JavaLetter", "JavaLetterOrDigit", 
		"WS", "COMMENT", "LINE_COMMENT"
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


	public MiniJavaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MiniJava.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\67\u01bd\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\20\3\20\3\21\3\21\3\21\5\21\u00da\n\21\3\21\3\21\3\21\5\21\u00df"+
		"\n\21\5\21\u00e1\n\21\3\22\3\22\7\22\u00e5\n\22\f\22\16\22\u00e8\13\22"+
		"\3\22\5\22\u00eb\n\22\3\23\3\23\5\23\u00ef\n\23\3\24\3\24\3\25\3\25\5"+
		"\25\u00f5\n\25\3\26\6\26\u00f8\n\26\r\26\16\26\u00f9\3\27\3\27\3\30\3"+
		"\30\3\30\5\30\u0101\n\30\3\30\5\30\u0104\n\30\3\30\3\30\3\30\5\30\u0109"+
		"\n\30\3\30\3\30\3\30\3\30\5\30\u010f\n\30\3\31\3\31\3\31\3\32\3\32\3\33"+
		"\5\33\u0117\n\33\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\5\35\u0126\n\35\3\36\3\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3"+
		"\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3"+
		"-\3-\3.\3.\3/\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\62\3\63"+
		"\3\63\3\63\3\64\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3\67\38\3"+
		"8\39\39\3:\3:\3;\3;\3;\3<\3<\3<\3=\3=\3=\3>\3>\3>\3?\3?\3?\3?\3?\3?\3"+
		"?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3@\3@\7@\u018d\n@\f@\16@\u0190\13"+
		"@\3A\3A\3A\3A\5A\u0196\nA\3B\3B\3B\3B\5B\u019c\nB\3C\6C\u019f\nC\rC\16"+
		"C\u01a0\3C\3C\3D\3D\3D\3D\7D\u01a9\nD\fD\16D\u01ac\13D\3D\3D\3D\3D\3D"+
		"\3E\3E\3E\3E\7E\u01b7\nE\fE\16E\u01ba\13E\3E\3E\3\u01aa\2F\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\2!\2#\2%"+
		"\2\'\2)\2+\2-\21/\2\61\2\63\2\65\2\67\29\22;\23=\2?\24A\25C\26E\27G\30"+
		"I\31K\32M\33O\34Q\35S\36U\37W Y![\"]#_$a%c&e\'g(i)k*m+o,q-s.u/w\60y\61"+
		"{\62}\63\177\64\u0081\2\u0083\2\u0085\65\u0087\66\u0089\67\3\2\r\3\2\63"+
		";\4\2GGgg\4\2--//\4\2))^^\6\2&&C\\aac|\4\2\2\u0081\ud802\udc01\3\2\ud802"+
		"\udc01\3\2\udc02\ue001\7\2&&\62;C\\aac|\5\2\13\f\16\17\"\"\4\2\f\f\17"+
		"\17\u01c5\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2-\3\2\2\2\29\3\2\2\2"+
		"\2;\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I"+
		"\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2"+
		"\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2"+
		"\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o"+
		"\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2"+
		"\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089"+
		"\3\2\2\2\3\u008b\3\2\2\2\5\u0093\3\2\2\2\7\u0099\3\2\2\2\t\u009e\3\2\2"+
		"\2\13\u00a7\3\2\2\2\r\u00aa\3\2\2\2\17\u00b1\3\2\2\2\21\u00b6\3\2\2\2"+
		"\23\u00ba\3\2\2\2\25\u00bd\3\2\2\2\27\u00c1\3\2\2\2\31\u00c5\3\2\2\2\33"+
		"\u00cc\3\2\2\2\35\u00d2\3\2\2\2\37\u00d4\3\2\2\2!\u00e0\3\2\2\2#\u00e2"+
		"\3\2\2\2%\u00ee\3\2\2\2\'\u00f0\3\2\2\2)\u00f4\3\2\2\2+\u00f7\3\2\2\2"+
		"-\u00fb\3\2\2\2/\u010e\3\2\2\2\61\u0110\3\2\2\2\63\u0113\3\2\2\2\65\u0116"+
		"\3\2\2\2\67\u011a\3\2\2\29\u0125\3\2\2\2;\u0127\3\2\2\2=\u012b\3\2\2\2"+
		"?\u012d\3\2\2\2A\u012f\3\2\2\2C\u0131\3\2\2\2E\u0133\3\2\2\2G\u0135\3"+
		"\2\2\2I\u0137\3\2\2\2K\u0139\3\2\2\2M\u013b\3\2\2\2O\u013d\3\2\2\2Q\u013f"+
		"\3\2\2\2S\u0141\3\2\2\2U\u0143\3\2\2\2W\u0145\3\2\2\2Y\u0147\3\2\2\2["+
		"\u0149\3\2\2\2]\u014b\3\2\2\2_\u014e\3\2\2\2a\u0151\3\2\2\2c\u0154\3\2"+
		"\2\2e\u0157\3\2\2\2g\u015a\3\2\2\2i\u015d\3\2\2\2k\u0160\3\2\2\2m\u0163"+
		"\3\2\2\2o\u0165\3\2\2\2q\u0167\3\2\2\2s\u0169\3\2\2\2u\u016b\3\2\2\2w"+
		"\u016e\3\2\2\2y\u0171\3\2\2\2{\u0174\3\2\2\2}\u0177\3\2\2\2\177\u018a"+
		"\3\2\2\2\u0081\u0195\3\2\2\2\u0083\u019b\3\2\2\2\u0085\u019e\3\2\2\2\u0087"+
		"\u01a4\3\2\2\2\u0089\u01b2\3\2\2\2\u008b\u008c\7d\2\2\u008c\u008d\7q\2"+
		"\2\u008d\u008e\7q\2\2\u008e\u008f\7n\2\2\u008f\u0090\7g\2\2\u0090\u0091"+
		"\7c\2\2\u0091\u0092\7p\2\2\u0092\4\3\2\2\2\u0093\u0094\7d\2\2\u0094\u0095"+
		"\7t\2\2\u0095\u0096\7g\2\2\u0096\u0097\7c\2\2\u0097\u0098\7m\2\2\u0098"+
		"\6\3\2\2\2\u0099\u009a\7e\2\2\u009a\u009b\7j\2\2\u009b\u009c\7c\2\2\u009c"+
		"\u009d\7t\2\2\u009d\b\3\2\2\2\u009e\u009f\7e\2\2\u009f\u00a0\7q\2\2\u00a0"+
		"\u00a1\7p\2\2\u00a1\u00a2\7v\2\2\u00a2\u00a3\7k\2\2\u00a3\u00a4\7p\2\2"+
		"\u00a4\u00a5\7w\2\2\u00a5\u00a6\7g\2\2\u00a6\n\3\2\2\2\u00a7\u00a8\7f"+
		"\2\2\u00a8\u00a9\7q\2\2\u00a9\f\3\2\2\2\u00aa\u00ab\7f\2\2\u00ab\u00ac"+
		"\7q\2\2\u00ac\u00ad\7w\2\2\u00ad\u00ae\7d\2\2\u00ae\u00af\7n\2\2\u00af"+
		"\u00b0\7g\2\2\u00b0\16\3\2\2\2\u00b1\u00b2\7g\2\2\u00b2\u00b3\7n\2\2\u00b3"+
		"\u00b4\7u\2\2\u00b4\u00b5\7g\2\2\u00b5\20\3\2\2\2\u00b6\u00b7\7h\2\2\u00b7"+
		"\u00b8\7q\2\2\u00b8\u00b9\7t\2\2\u00b9\22\3\2\2\2\u00ba\u00bb\7k\2\2\u00bb"+
		"\u00bc\7h\2\2\u00bc\24\3\2\2\2\u00bd\u00be\7k\2\2\u00be\u00bf\7p\2\2\u00bf"+
		"\u00c0\7v\2\2\u00c0\26\3\2\2\2\u00c1\u00c2\7p\2\2\u00c2\u00c3\7g\2\2\u00c3"+
		"\u00c4\7y\2\2\u00c4\30\3\2\2\2\u00c5\u00c6\7t\2\2\u00c6\u00c7\7g\2\2\u00c7"+
		"\u00c8\7v\2\2\u00c8\u00c9\7w\2\2\u00c9\u00ca\7t\2\2\u00ca\u00cb\7p\2\2"+
		"\u00cb\32\3\2\2\2\u00cc\u00cd\7y\2\2\u00cd\u00ce\7j\2\2\u00ce\u00cf\7"+
		"k\2\2\u00cf\u00d0\7n\2\2\u00d0\u00d1\7g\2\2\u00d1\34\3\2\2\2\u00d2\u00d3"+
		"\5\37\20\2\u00d3\36\3\2\2\2\u00d4\u00d5\5!\21\2\u00d5 \3\2\2\2\u00d6\u00e1"+
		"\7\62\2\2\u00d7\u00de\5\'\24\2\u00d8\u00da\5#\22\2\u00d9\u00d8\3\2\2\2"+
		"\u00d9\u00da\3\2\2\2\u00da\u00df\3\2\2\2\u00db\u00dc\5+\26\2\u00dc\u00dd"+
		"\5#\22\2\u00dd\u00df\3\2\2\2\u00de\u00d9\3\2\2\2\u00de\u00db\3\2\2\2\u00df"+
		"\u00e1\3\2\2\2\u00e0\u00d6\3\2\2\2\u00e0\u00d7\3\2\2\2\u00e1\"\3\2\2\2"+
		"\u00e2\u00ea\5%\23\2\u00e3\u00e5\5)\25\2\u00e4\u00e3\3\2\2\2\u00e5\u00e8"+
		"\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e9\3\2\2\2\u00e8"+
		"\u00e6\3\2\2\2\u00e9\u00eb\5%\23\2\u00ea\u00e6\3\2\2\2\u00ea\u00eb\3\2"+
		"\2\2\u00eb$\3\2\2\2\u00ec\u00ef\7\62\2\2\u00ed\u00ef\5\'\24\2\u00ee\u00ec"+
		"\3\2\2\2\u00ee\u00ed\3\2\2\2\u00ef&\3\2\2\2\u00f0\u00f1\t\2\2\2\u00f1"+
		"(\3\2\2\2\u00f2\u00f5\5%\23\2\u00f3\u00f5\7a\2\2\u00f4\u00f2\3\2\2\2\u00f4"+
		"\u00f3\3\2\2\2\u00f5*\3\2\2\2\u00f6\u00f8\7a\2\2\u00f7\u00f6\3\2\2\2\u00f8"+
		"\u00f9\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa,\3\2\2\2"+
		"\u00fb\u00fc\5/\30\2\u00fc.\3\2\2\2\u00fd\u00fe\5#\22\2\u00fe\u0100\5"+
		"O(\2\u00ff\u0101\5#\22\2\u0100\u00ff\3\2\2\2\u0100\u0101\3\2\2\2\u0101"+
		"\u0103\3\2\2\2\u0102\u0104\5\61\31\2\u0103\u0102\3\2\2\2\u0103\u0104\3"+
		"\2\2\2\u0104\u010f\3\2\2\2\u0105\u0106\5O(\2\u0106\u0108\5#\22\2\u0107"+
		"\u0109\5\61\31\2\u0108\u0107\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010f\3"+
		"\2\2\2\u010a\u010b\5#\22\2\u010b\u010c\5\61\31\2\u010c\u010f\3\2\2\2\u010d"+
		"\u010f\5#\22\2\u010e\u00fd\3\2\2\2\u010e\u0105\3\2\2\2\u010e\u010a\3\2"+
		"\2\2\u010e\u010d\3\2\2\2\u010f\60\3\2\2\2\u0110\u0111\5\63\32\2\u0111"+
		"\u0112\5\65\33\2\u0112\62\3\2\2\2\u0113\u0114\t\3\2\2\u0114\64\3\2\2\2"+
		"\u0115\u0117\5\67\34\2\u0116\u0115\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0118"+
		"\3\2\2\2\u0118\u0119\5#\22\2\u0119\66\3\2\2\2\u011a\u011b\t\4\2\2\u011b"+
		"8\3\2\2\2\u011c\u011d\7v\2\2\u011d\u011e\7t\2\2\u011e\u011f\7w\2\2\u011f"+
		"\u0126\7g\2\2\u0120\u0121\7h\2\2\u0121\u0122\7c\2\2\u0122\u0123\7n\2\2"+
		"\u0123\u0124\7u\2\2\u0124\u0126\7g\2\2\u0125\u011c\3\2\2\2\u0125\u0120"+
		"\3\2\2\2\u0126:\3\2\2\2\u0127\u0128\7)\2\2\u0128\u0129\5=\37\2\u0129\u012a"+
		"\7)\2\2\u012a<\3\2\2\2\u012b\u012c\n\5\2\2\u012c>\3\2\2\2\u012d\u012e"+
		"\7*\2\2\u012e@\3\2\2\2\u012f\u0130\7+\2\2\u0130B\3\2\2\2\u0131\u0132\7"+
		"}\2\2\u0132D\3\2\2\2\u0133\u0134\7\177\2\2\u0134F\3\2\2\2\u0135\u0136"+
		"\7]\2\2\u0136H\3\2\2\2\u0137\u0138\7_\2\2\u0138J\3\2\2\2\u0139\u013a\7"+
		"=\2\2\u013aL\3\2\2\2\u013b\u013c\7.\2\2\u013cN\3\2\2\2\u013d\u013e\7\60"+
		"\2\2\u013eP\3\2\2\2\u013f\u0140\7?\2\2\u0140R\3\2\2\2\u0141\u0142\7@\2"+
		"\2\u0142T\3\2\2\2\u0143\u0144\7>\2\2\u0144V\3\2\2\2\u0145\u0146\7#\2\2"+
		"\u0146X\3\2\2\2\u0147\u0148\7A\2\2\u0148Z\3\2\2\2\u0149\u014a\7<\2\2\u014a"+
		"\\\3\2\2\2\u014b\u014c\7?\2\2\u014c\u014d\7?\2\2\u014d^\3\2\2\2\u014e"+
		"\u014f\7>\2\2\u014f\u0150\7?\2\2\u0150`\3\2\2\2\u0151\u0152\7@\2\2\u0152"+
		"\u0153\7?\2\2\u0153b\3\2\2\2\u0154\u0155\7#\2\2\u0155\u0156\7?\2\2\u0156"+
		"d\3\2\2\2\u0157\u0158\7(\2\2\u0158\u0159\7(\2\2\u0159f\3\2\2\2\u015a\u015b"+
		"\7~\2\2\u015b\u015c\7~\2\2\u015ch\3\2\2\2\u015d\u015e\7-\2\2\u015e\u015f"+
		"\7-\2\2\u015fj\3\2\2\2\u0160\u0161\7/\2\2\u0161\u0162\7/\2\2\u0162l\3"+
		"\2\2\2\u0163\u0164\7-\2\2\u0164n\3\2\2\2\u0165\u0166\7/\2\2\u0166p\3\2"+
		"\2\2\u0167\u0168\7,\2\2\u0168r\3\2\2\2\u0169\u016a\7\61\2\2\u016at\3\2"+
		"\2\2\u016b\u016c\7-\2\2\u016c\u016d\7?\2\2\u016dv\3\2\2\2\u016e\u016f"+
		"\7/\2\2\u016f\u0170\7?\2\2\u0170x\3\2\2\2\u0171\u0172\7,\2\2\u0172\u0173"+
		"\7?\2\2\u0173z\3\2\2\2\u0174\u0175\7\61\2\2\u0175\u0176\7?\2\2\u0176|"+
		"\3\2\2\2\u0177\u0178\7U\2\2\u0178\u0179\7{\2\2\u0179\u017a\7u\2\2\u017a"+
		"\u017b\7v\2\2\u017b\u017c\7g\2\2\u017c\u017d\7o\2\2\u017d\u017e\7\60\2"+
		"\2\u017e\u017f\7q\2\2\u017f\u0180\7w\2\2\u0180\u0181\7v\2\2\u0181\u0182"+
		"\7\60\2\2\u0182\u0183\7r\2\2\u0183\u0184\7t\2\2\u0184\u0185\7k\2\2\u0185"+
		"\u0186\7p\2\2\u0186\u0187\7v\2\2\u0187\u0188\7n\2\2\u0188\u0189\7p\2\2"+
		"\u0189~\3\2\2\2\u018a\u018e\5\u0081A\2\u018b\u018d\5\u0083B\2\u018c\u018b"+
		"\3\2\2\2\u018d\u0190\3\2\2\2\u018e\u018c\3\2\2\2\u018e\u018f\3\2\2\2\u018f"+
		"\u0080\3\2\2\2\u0190\u018e\3\2\2\2\u0191\u0196\t\6\2\2\u0192\u0196\n\7"+
		"\2\2\u0193\u0194\t\b\2\2\u0194\u0196\t\t\2\2\u0195\u0191\3\2\2\2\u0195"+
		"\u0192\3\2\2\2\u0195\u0193\3\2\2\2\u0196\u0082\3\2\2\2\u0197\u019c\t\n"+
		"\2\2\u0198\u019c\n\7\2\2\u0199\u019a\t\b\2\2\u019a\u019c\t\t\2\2\u019b"+
		"\u0197\3\2\2\2\u019b\u0198\3\2\2\2\u019b\u0199\3\2\2\2\u019c\u0084\3\2"+
		"\2\2\u019d\u019f\t\13\2\2\u019e\u019d\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0"+
		"\u019e\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a3\bC"+
		"\2\2\u01a3\u0086\3\2\2\2\u01a4\u01a5\7\61\2\2\u01a5\u01a6\7,\2\2\u01a6"+
		"\u01aa\3\2\2\2\u01a7\u01a9\13\2\2\2\u01a8\u01a7\3\2\2\2\u01a9\u01ac\3"+
		"\2\2\2\u01aa\u01ab\3\2\2\2\u01aa\u01a8\3\2\2\2\u01ab\u01ad\3\2\2\2\u01ac"+
		"\u01aa\3\2\2\2\u01ad\u01ae\7,\2\2\u01ae\u01af\7\61\2\2\u01af\u01b0\3\2"+
		"\2\2\u01b0\u01b1\bD\3\2\u01b1\u0088\3\2\2\2\u01b2\u01b3\7\61\2\2\u01b3"+
		"\u01b4\7\61\2\2\u01b4\u01b8\3\2\2\2\u01b5\u01b7\n\f\2\2\u01b6\u01b5\3"+
		"\2\2\2\u01b7\u01ba\3\2\2\2\u01b8\u01b6\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9"+
		"\u01bb\3\2\2\2\u01ba\u01b8\3\2\2\2\u01bb\u01bc\bE\3\2\u01bc\u008a\3\2"+
		"\2\2\27\2\u00d9\u00de\u00e0\u00e6\u00ea\u00ee\u00f4\u00f9\u0100\u0103"+
		"\u0108\u010e\u0116\u0125\u018e\u0195\u019b\u01a0\u01aa\u01b8\4\b\2\2\2"+
		"\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}