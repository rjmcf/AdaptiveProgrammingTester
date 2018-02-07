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
		BLANK=1, BOOLEAN=2, BREAK=3, CHAR=4, CONTINUE=5, DO=6, DOUBLE=7, ELSE=8, 
		FOR=9, IF=10, INT=11, NEW=12, RETURN=13, WHILE=14, IntegerLiteral=15, 
		FloatingPointLiteral=16, BooleanLiteral=17, CharacterLiteral=18, LPAREN=19, 
		RPAREN=20, LBRACE=21, RBRACE=22, LBRACK=23, RBRACK=24, SEMI=25, COMMA=26, 
		DOT=27, ASSIGN=28, GT=29, LT=30, BANG=31, QUESTION=32, COLON=33, EQUAL=34, 
		LE=35, GE=36, NOTEQUAL=37, AND=38, OR=39, INC=40, DEC=41, ADD=42, SUB=43, 
		MUL=44, DIV=45, ADD_ASSIGN=46, SUB_ASSIGN=47, MUL_ASSIGN=48, DIV_ASSIGN=49, 
		PRINT=50, Identifier=51, WS=52, COMMENT=53, LINE_COMMENT=54;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"BLANK", "BOOLEAN", "BREAK", "CHAR", "CONTINUE", "DO", "DOUBLE", "ELSE", 
		"FOR", "IF", "INT", "NEW", "RETURN", "WHILE", "IntegerLiteral", "DecimalIntegerLiteral", 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\28\u01d3\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\3\2\6\2\u008f\n"+
		"\2\r\2\16\2\u0090\3\2\6\2\u0094\n\2\r\2\16\2\u0095\3\2\3\2\3\2\3\2\6\2"+
		"\u009c\n\2\r\2\16\2\u009d\5\2\u00a0\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\22\5\22\u00f0\n\22\3\22\3\22\3\22\5\22\u00f5\n"+
		"\22\5\22\u00f7\n\22\3\23\3\23\7\23\u00fb\n\23\f\23\16\23\u00fe\13\23\3"+
		"\23\5\23\u0101\n\23\3\24\3\24\5\24\u0105\n\24\3\25\3\25\3\26\3\26\5\26"+
		"\u010b\n\26\3\27\6\27\u010e\n\27\r\27\16\27\u010f\3\30\3\30\3\31\3\31"+
		"\3\31\5\31\u0117\n\31\3\31\5\31\u011a\n\31\3\31\3\31\3\31\5\31\u011f\n"+
		"\31\3\31\3\31\3\31\3\31\5\31\u0125\n\31\3\32\3\32\3\32\3\33\3\33\3\34"+
		"\5\34\u012d\n\34\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\5\36\u013c\n\36\3\37\3\37\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#"+
		"\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3"+
		".\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\63\3"+
		"\64\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3\67\3\67\38\38\39\3"+
		"9\3:\3:\3;\3;\3<\3<\3<\3=\3=\3=\3>\3>\3>\3?\3?\3?\3@\3@\3@\3@\3@\3@\3"+
		"@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3A\3A\7A\u01a3\nA\fA\16A\u01a6\13"+
		"A\3B\3B\3B\3B\5B\u01ac\nB\3C\3C\3C\3C\5C\u01b2\nC\3D\6D\u01b5\nD\rD\16"+
		"D\u01b6\3D\3D\3E\3E\3E\3E\7E\u01bf\nE\fE\16E\u01c2\13E\3E\3E\3E\3E\3E"+
		"\3F\3F\3F\3F\7F\u01cd\nF\fF\16F\u01d0\13F\3F\3F\3\u01c0\2G\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\2#\2"+
		"%\2\'\2)\2+\2-\2/\22\61\2\63\2\65\2\67\29\2;\23=\24?\2A\25C\26E\27G\30"+
		"I\31K\32M\33O\34Q\35S\36U\37W Y![\"]#_$a%c&e\'g(i)k*m+o,q-s.u/w\60y\61"+
		"{\62}\63\177\64\u0081\65\u0083\2\u0085\2\u0087\66\u0089\67\u008b8\3\2"+
		"\r\3\2\63;\4\2GGgg\4\2--//\4\2))^^\6\2&&C\\aac|\4\2\2\u0081\ud802\udc01"+
		"\3\2\ud802\udc01\3\2\udc02\ue001\7\2&&\62;C\\aac|\5\2\13\f\16\17\"\"\4"+
		"\2\f\f\17\17\u01df\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"/\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3"+
		"\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2"+
		"\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2"+
		"a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3"+
		"\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2"+
		"\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0087\3\2\2\2"+
		"\2\u0089\3\2\2\2\2\u008b\3\2\2\2\3\u009f\3\2\2\2\5\u00a1\3\2\2\2\7\u00a9"+
		"\3\2\2\2\t\u00af\3\2\2\2\13\u00b4\3\2\2\2\r\u00bd\3\2\2\2\17\u00c0\3\2"+
		"\2\2\21\u00c7\3\2\2\2\23\u00cc\3\2\2\2\25\u00d0\3\2\2\2\27\u00d3\3\2\2"+
		"\2\31\u00d7\3\2\2\2\33\u00db\3\2\2\2\35\u00e2\3\2\2\2\37\u00e8\3\2\2\2"+
		"!\u00ea\3\2\2\2#\u00f6\3\2\2\2%\u00f8\3\2\2\2\'\u0104\3\2\2\2)\u0106\3"+
		"\2\2\2+\u010a\3\2\2\2-\u010d\3\2\2\2/\u0111\3\2\2\2\61\u0124\3\2\2\2\63"+
		"\u0126\3\2\2\2\65\u0129\3\2\2\2\67\u012c\3\2\2\29\u0130\3\2\2\2;\u013b"+
		"\3\2\2\2=\u013d\3\2\2\2?\u0141\3\2\2\2A\u0143\3\2\2\2C\u0145\3\2\2\2E"+
		"\u0147\3\2\2\2G\u0149\3\2\2\2I\u014b\3\2\2\2K\u014d\3\2\2\2M\u014f\3\2"+
		"\2\2O\u0151\3\2\2\2Q\u0153\3\2\2\2S\u0155\3\2\2\2U\u0157\3\2\2\2W\u0159"+
		"\3\2\2\2Y\u015b\3\2\2\2[\u015d\3\2\2\2]\u015f\3\2\2\2_\u0161\3\2\2\2a"+
		"\u0164\3\2\2\2c\u0167\3\2\2\2e\u016a\3\2\2\2g\u016d\3\2\2\2i\u0170\3\2"+
		"\2\2k\u0173\3\2\2\2m\u0176\3\2\2\2o\u0179\3\2\2\2q\u017b\3\2\2\2s\u017d"+
		"\3\2\2\2u\u017f\3\2\2\2w\u0181\3\2\2\2y\u0184\3\2\2\2{\u0187\3\2\2\2}"+
		"\u018a\3\2\2\2\177\u018d\3\2\2\2\u0081\u01a0\3\2\2\2\u0083\u01ab\3\2\2"+
		"\2\u0085\u01b1\3\2\2\2\u0087\u01b4\3\2\2\2\u0089\u01ba\3\2\2\2\u008b\u01c8"+
		"\3\2\2\2\u008d\u008f\7\60\2\2\u008e\u008d\3\2\2\2\u008f\u0090\3\2\2\2"+
		"\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u00a0\3\2\2\2\u0092\u0094"+
		"\7\60\2\2\u0093\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0093\3\2\2\2"+
		"\u0095\u0096\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\7*\2\2\u0098\u0099"+
		"\5\37\20\2\u0099\u009b\7+\2\2\u009a\u009c\7\60\2\2\u009b\u009a\3\2\2\2"+
		"\u009c\u009d\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a0"+
		"\3\2\2\2\u009f\u008e\3\2\2\2\u009f\u0093\3\2\2\2\u00a0\4\3\2\2\2\u00a1"+
		"\u00a2\7d\2\2\u00a2\u00a3\7q\2\2\u00a3\u00a4\7q\2\2\u00a4\u00a5\7n\2\2"+
		"\u00a5\u00a6\7g\2\2\u00a6\u00a7\7c\2\2\u00a7\u00a8\7p\2\2\u00a8\6\3\2"+
		"\2\2\u00a9\u00aa\7d\2\2\u00aa\u00ab\7t\2\2\u00ab\u00ac\7g\2\2\u00ac\u00ad"+
		"\7c\2\2\u00ad\u00ae\7m\2\2\u00ae\b\3\2\2\2\u00af\u00b0\7e\2\2\u00b0\u00b1"+
		"\7j\2\2\u00b1\u00b2\7c\2\2\u00b2\u00b3\7t\2\2\u00b3\n\3\2\2\2\u00b4\u00b5"+
		"\7e\2\2\u00b5\u00b6\7q\2\2\u00b6\u00b7\7p\2\2\u00b7\u00b8\7v\2\2\u00b8"+
		"\u00b9\7k\2\2\u00b9\u00ba\7p\2\2\u00ba\u00bb\7w\2\2\u00bb\u00bc\7g\2\2"+
		"\u00bc\f\3\2\2\2\u00bd\u00be\7f\2\2\u00be\u00bf\7q\2\2\u00bf\16\3\2\2"+
		"\2\u00c0\u00c1\7f\2\2\u00c1\u00c2\7q\2\2\u00c2\u00c3\7w\2\2\u00c3\u00c4"+
		"\7d\2\2\u00c4\u00c5\7n\2\2\u00c5\u00c6\7g\2\2\u00c6\20\3\2\2\2\u00c7\u00c8"+
		"\7g\2\2\u00c8\u00c9\7n\2\2\u00c9\u00ca\7u\2\2\u00ca\u00cb\7g\2\2\u00cb"+
		"\22\3\2\2\2\u00cc\u00cd\7h\2\2\u00cd\u00ce\7q\2\2\u00ce\u00cf\7t\2\2\u00cf"+
		"\24\3\2\2\2\u00d0\u00d1\7k\2\2\u00d1\u00d2\7h\2\2\u00d2\26\3\2\2\2\u00d3"+
		"\u00d4\7k\2\2\u00d4\u00d5\7p\2\2\u00d5\u00d6\7v\2\2\u00d6\30\3\2\2\2\u00d7"+
		"\u00d8\7p\2\2\u00d8\u00d9\7g\2\2\u00d9\u00da\7y\2\2\u00da\32\3\2\2\2\u00db"+
		"\u00dc\7t\2\2\u00dc\u00dd\7g\2\2\u00dd\u00de\7v\2\2\u00de\u00df\7w\2\2"+
		"\u00df\u00e0\7t\2\2\u00e0\u00e1\7p\2\2\u00e1\34\3\2\2\2\u00e2\u00e3\7"+
		"y\2\2\u00e3\u00e4\7j\2\2\u00e4\u00e5\7k\2\2\u00e5\u00e6\7n\2\2\u00e6\u00e7"+
		"\7g\2\2\u00e7\36\3\2\2\2\u00e8\u00e9\5!\21\2\u00e9 \3\2\2\2\u00ea\u00eb"+
		"\5#\22\2\u00eb\"\3\2\2\2\u00ec\u00f7\7\62\2\2\u00ed\u00f4\5)\25\2\u00ee"+
		"\u00f0\5%\23\2\u00ef\u00ee\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f5\3\2"+
		"\2\2\u00f1\u00f2\5-\27\2\u00f2\u00f3\5%\23\2\u00f3\u00f5\3\2\2\2\u00f4"+
		"\u00ef\3\2\2\2\u00f4\u00f1\3\2\2\2\u00f5\u00f7\3\2\2\2\u00f6\u00ec\3\2"+
		"\2\2\u00f6\u00ed\3\2\2\2\u00f7$\3\2\2\2\u00f8\u0100\5\'\24\2\u00f9\u00fb"+
		"\5+\26\2\u00fa\u00f9\3\2\2\2\u00fb\u00fe\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc"+
		"\u00fd\3\2\2\2\u00fd\u00ff\3\2\2\2\u00fe\u00fc\3\2\2\2\u00ff\u0101\5\'"+
		"\24\2\u0100\u00fc\3\2\2\2\u0100\u0101\3\2\2\2\u0101&\3\2\2\2\u0102\u0105"+
		"\7\62\2\2\u0103\u0105\5)\25\2\u0104\u0102\3\2\2\2\u0104\u0103\3\2\2\2"+
		"\u0105(\3\2\2\2\u0106\u0107\t\2\2\2\u0107*\3\2\2\2\u0108\u010b\5\'\24"+
		"\2\u0109\u010b\7a\2\2\u010a\u0108\3\2\2\2\u010a\u0109\3\2\2\2\u010b,\3"+
		"\2\2\2\u010c\u010e\7a\2\2\u010d\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f"+
		"\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110.\3\2\2\2\u0111\u0112\5\61\31"+
		"\2\u0112\60\3\2\2\2\u0113\u0114\5%\23\2\u0114\u0116\5Q)\2\u0115\u0117"+
		"\5%\23\2\u0116\u0115\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0119\3\2\2\2\u0118"+
		"\u011a\5\63\32\2\u0119\u0118\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u0125\3"+
		"\2\2\2\u011b\u011c\5Q)\2\u011c\u011e\5%\23\2\u011d\u011f\5\63\32\2\u011e"+
		"\u011d\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0125\3\2\2\2\u0120\u0121\5%"+
		"\23\2\u0121\u0122\5\63\32\2\u0122\u0125\3\2\2\2\u0123\u0125\5%\23\2\u0124"+
		"\u0113\3\2\2\2\u0124\u011b\3\2\2\2\u0124\u0120\3\2\2\2\u0124\u0123\3\2"+
		"\2\2\u0125\62\3\2\2\2\u0126\u0127\5\65\33\2\u0127\u0128\5\67\34\2\u0128"+
		"\64\3\2\2\2\u0129\u012a\t\3\2\2\u012a\66\3\2\2\2\u012b\u012d\59\35\2\u012c"+
		"\u012b\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u012f\5%"+
		"\23\2\u012f8\3\2\2\2\u0130\u0131\t\4\2\2\u0131:\3\2\2\2\u0132\u0133\7"+
		"v\2\2\u0133\u0134\7t\2\2\u0134\u0135\7w\2\2\u0135\u013c\7g\2\2\u0136\u0137"+
		"\7h\2\2\u0137\u0138\7c\2\2\u0138\u0139\7n\2\2\u0139\u013a\7u\2\2\u013a"+
		"\u013c\7g\2\2\u013b\u0132\3\2\2\2\u013b\u0136\3\2\2\2\u013c<\3\2\2\2\u013d"+
		"\u013e\7)\2\2\u013e\u013f\5? \2\u013f\u0140\7)\2\2\u0140>\3\2\2\2\u0141"+
		"\u0142\n\5\2\2\u0142@\3\2\2\2\u0143\u0144\7*\2\2\u0144B\3\2\2\2\u0145"+
		"\u0146\7+\2\2\u0146D\3\2\2\2\u0147\u0148\7}\2\2\u0148F\3\2\2\2\u0149\u014a"+
		"\7\177\2\2\u014aH\3\2\2\2\u014b\u014c\7]\2\2\u014cJ\3\2\2\2\u014d\u014e"+
		"\7_\2\2\u014eL\3\2\2\2\u014f\u0150\7=\2\2\u0150N\3\2\2\2\u0151\u0152\7"+
		".\2\2\u0152P\3\2\2\2\u0153\u0154\7\60\2\2\u0154R\3\2\2\2\u0155\u0156\7"+
		"?\2\2\u0156T\3\2\2\2\u0157\u0158\7@\2\2\u0158V\3\2\2\2\u0159\u015a\7>"+
		"\2\2\u015aX\3\2\2\2\u015b\u015c\7#\2\2\u015cZ\3\2\2\2\u015d\u015e\7A\2"+
		"\2\u015e\\\3\2\2\2\u015f\u0160\7<\2\2\u0160^\3\2\2\2\u0161\u0162\7?\2"+
		"\2\u0162\u0163\7?\2\2\u0163`\3\2\2\2\u0164\u0165\7>\2\2\u0165\u0166\7"+
		"?\2\2\u0166b\3\2\2\2\u0167\u0168\7@\2\2\u0168\u0169\7?\2\2\u0169d\3\2"+
		"\2\2\u016a\u016b\7#\2\2\u016b\u016c\7?\2\2\u016cf\3\2\2\2\u016d\u016e"+
		"\7(\2\2\u016e\u016f\7(\2\2\u016fh\3\2\2\2\u0170\u0171\7~\2\2\u0171\u0172"+
		"\7~\2\2\u0172j\3\2\2\2\u0173\u0174\7-\2\2\u0174\u0175\7-\2\2\u0175l\3"+
		"\2\2\2\u0176\u0177\7/\2\2\u0177\u0178\7/\2\2\u0178n\3\2\2\2\u0179\u017a"+
		"\7-\2\2\u017ap\3\2\2\2\u017b\u017c\7/\2\2\u017cr\3\2\2\2\u017d\u017e\7"+
		",\2\2\u017et\3\2\2\2\u017f\u0180\7\61\2\2\u0180v\3\2\2\2\u0181\u0182\7"+
		"-\2\2\u0182\u0183\7?\2\2\u0183x\3\2\2\2\u0184\u0185\7/\2\2\u0185\u0186"+
		"\7?\2\2\u0186z\3\2\2\2\u0187\u0188\7,\2\2\u0188\u0189\7?\2\2\u0189|\3"+
		"\2\2\2\u018a\u018b\7\61\2\2\u018b\u018c\7?\2\2\u018c~\3\2\2\2\u018d\u018e"+
		"\7U\2\2\u018e\u018f\7{\2\2\u018f\u0190\7u\2\2\u0190\u0191\7v\2\2\u0191"+
		"\u0192\7g\2\2\u0192\u0193\7o\2\2\u0193\u0194\7\60\2\2\u0194\u0195\7q\2"+
		"\2\u0195\u0196\7w\2\2\u0196\u0197\7v\2\2\u0197\u0198\7\60\2\2\u0198\u0199"+
		"\7r\2\2\u0199\u019a\7t\2\2\u019a\u019b\7k\2\2\u019b\u019c\7p\2\2\u019c"+
		"\u019d\7v\2\2\u019d\u019e\7n\2\2\u019e\u019f\7p\2\2\u019f\u0080\3\2\2"+
		"\2\u01a0\u01a4\5\u0083B\2\u01a1\u01a3\5\u0085C\2\u01a2\u01a1\3\2\2\2\u01a3"+
		"\u01a6\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u0082\3\2"+
		"\2\2\u01a6\u01a4\3\2\2\2\u01a7\u01ac\t\6\2\2\u01a8\u01ac\n\7\2\2\u01a9"+
		"\u01aa\t\b\2\2\u01aa\u01ac\t\t\2\2\u01ab\u01a7\3\2\2\2\u01ab\u01a8\3\2"+
		"\2\2\u01ab\u01a9\3\2\2\2\u01ac\u0084\3\2\2\2\u01ad\u01b2\t\n\2\2\u01ae"+
		"\u01b2\n\7\2\2\u01af\u01b0\t\b\2\2\u01b0\u01b2\t\t\2\2\u01b1\u01ad\3\2"+
		"\2\2\u01b1\u01ae\3\2\2\2\u01b1\u01af\3\2\2\2\u01b2\u0086\3\2\2\2\u01b3"+
		"\u01b5\t\13\2\2\u01b4\u01b3\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01b4\3"+
		"\2\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01b9\bD\2\2\u01b9"+
		"\u0088\3\2\2\2\u01ba\u01bb\7\61\2\2\u01bb\u01bc\7,\2\2\u01bc\u01c0\3\2"+
		"\2\2\u01bd\u01bf\13\2\2\2\u01be\u01bd\3\2\2\2\u01bf\u01c2\3\2\2\2\u01c0"+
		"\u01c1\3\2\2\2\u01c0\u01be\3\2\2\2\u01c1\u01c3\3\2\2\2\u01c2\u01c0\3\2"+
		"\2\2\u01c3\u01c4\7,\2\2\u01c4\u01c5\7\61\2\2\u01c5\u01c6\3\2\2\2\u01c6"+
		"\u01c7\bE\3\2\u01c7\u008a\3\2\2\2\u01c8\u01c9\7\61\2\2\u01c9\u01ca\7\61"+
		"\2\2\u01ca\u01ce\3\2\2\2\u01cb\u01cd\n\f\2\2\u01cc\u01cb\3\2\2\2\u01cd"+
		"\u01d0\3\2\2\2\u01ce\u01cc\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d1\3\2"+
		"\2\2\u01d0\u01ce\3\2\2\2\u01d1\u01d2\bF\3\2\u01d2\u008c\3\2\2\2\33\2\u0090"+
		"\u0095\u009d\u009f\u00ef\u00f4\u00f6\u00fc\u0100\u0104\u010a\u010f\u0116"+
		"\u0119\u011e\u0124\u012c\u013b\u01a4\u01ab\u01b1\u01b6\u01c0\u01ce\4\b"+
		"\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}