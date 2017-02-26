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
		ADD_ASSIGN=45, SUB_ASSIGN=46, MUL_ASSIGN=47, DIV_ASSIGN=48, Identifier=49, 
		WS=50, COMMENT=51, LINE_COMMENT=52;
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
		"DIV_ASSIGN", "Identifier", "JavaLetter", "JavaLetterOrDigit", "WS", "COMMENT", 
		"LINE_COMMENT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\66\u01a8\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3"+
		"\20\3\20\3\21\3\21\3\21\5\21\u00d8\n\21\3\21\3\21\3\21\5\21\u00dd\n\21"+
		"\5\21\u00df\n\21\3\22\3\22\7\22\u00e3\n\22\f\22\16\22\u00e6\13\22\3\22"+
		"\5\22\u00e9\n\22\3\23\3\23\5\23\u00ed\n\23\3\24\3\24\3\25\3\25\5\25\u00f3"+
		"\n\25\3\26\6\26\u00f6\n\26\r\26\16\26\u00f7\3\27\3\27\3\30\3\30\3\30\5"+
		"\30\u00ff\n\30\3\30\5\30\u0102\n\30\3\30\3\30\3\30\5\30\u0107\n\30\3\30"+
		"\3\30\3\30\3\30\5\30\u010d\n\30\3\31\3\31\3\31\3\32\3\32\3\33\5\33\u0115"+
		"\n\33\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\5\35\u0124\n\35\3\36\3\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#"+
		"\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3"+
		".\3/\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\63"+
		"\3\64\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3\67\38\38\39\39\3"+
		":\3:\3;\3;\3;\3<\3<\3<\3=\3=\3=\3>\3>\3>\3?\3?\7?\u0178\n?\f?\16?\u017b"+
		"\13?\3@\3@\3@\3@\5@\u0181\n@\3A\3A\3A\3A\5A\u0187\nA\3B\6B\u018a\nB\r"+
		"B\16B\u018b\3B\3B\3C\3C\3C\3C\7C\u0194\nC\fC\16C\u0197\13C\3C\3C\3C\3"+
		"C\3C\3D\3D\3D\3D\7D\u01a2\nD\fD\16D\u01a5\13D\3D\3D\3\u0195\2E\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\2!\2"+
		"#\2%\2\'\2)\2+\2-\21/\2\61\2\63\2\65\2\67\29\22;\23=\2?\24A\25C\26E\27"+
		"G\30I\31K\32M\33O\34Q\35S\36U\37W Y![\"]#_$a%c&e\'g(i)k*m+o,q-s.u/w\60"+
		"y\61{\62}\63\177\2\u0081\2\u0083\64\u0085\65\u0087\66\3\2\r\3\2\63;\4"+
		"\2GGgg\4\2--//\4\2))^^\6\2&&C\\aac|\4\2\2\u0081\ud802\udc01\3\2\ud802"+
		"\udc01\3\2\udc02\ue001\7\2&&\62;C\\aac|\5\2\13\f\16\17\"\"\4\2\f\f\17"+
		"\17\u01b0\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2-\3\2\2\2\29\3\2\2\2"+
		"\2;\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I"+
		"\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2"+
		"\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2"+
		"\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o"+
		"\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2"+
		"\2\2\2}\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\3\u0089"+
		"\3\2\2\2\5\u0091\3\2\2\2\7\u0097\3\2\2\2\t\u009c\3\2\2\2\13\u00a5\3\2"+
		"\2\2\r\u00a8\3\2\2\2\17\u00af\3\2\2\2\21\u00b4\3\2\2\2\23\u00b8\3\2\2"+
		"\2\25\u00bb\3\2\2\2\27\u00bf\3\2\2\2\31\u00c3\3\2\2\2\33\u00ca\3\2\2\2"+
		"\35\u00d0\3\2\2\2\37\u00d2\3\2\2\2!\u00de\3\2\2\2#\u00e0\3\2\2\2%\u00ec"+
		"\3\2\2\2\'\u00ee\3\2\2\2)\u00f2\3\2\2\2+\u00f5\3\2\2\2-\u00f9\3\2\2\2"+
		"/\u010c\3\2\2\2\61\u010e\3\2\2\2\63\u0111\3\2\2\2\65\u0114\3\2\2\2\67"+
		"\u0118\3\2\2\29\u0123\3\2\2\2;\u0125\3\2\2\2=\u0129\3\2\2\2?\u012b\3\2"+
		"\2\2A\u012d\3\2\2\2C\u012f\3\2\2\2E\u0131\3\2\2\2G\u0133\3\2\2\2I\u0135"+
		"\3\2\2\2K\u0137\3\2\2\2M\u0139\3\2\2\2O\u013b\3\2\2\2Q\u013d\3\2\2\2S"+
		"\u013f\3\2\2\2U\u0141\3\2\2\2W\u0143\3\2\2\2Y\u0145\3\2\2\2[\u0147\3\2"+
		"\2\2]\u0149\3\2\2\2_\u014c\3\2\2\2a\u014f\3\2\2\2c\u0152\3\2\2\2e\u0155"+
		"\3\2\2\2g\u0158\3\2\2\2i\u015b\3\2\2\2k\u015e\3\2\2\2m\u0161\3\2\2\2o"+
		"\u0163\3\2\2\2q\u0165\3\2\2\2s\u0167\3\2\2\2u\u0169\3\2\2\2w\u016c\3\2"+
		"\2\2y\u016f\3\2\2\2{\u0172\3\2\2\2}\u0175\3\2\2\2\177\u0180\3\2\2\2\u0081"+
		"\u0186\3\2\2\2\u0083\u0189\3\2\2\2\u0085\u018f\3\2\2\2\u0087\u019d\3\2"+
		"\2\2\u0089\u008a\7d\2\2\u008a\u008b\7q\2\2\u008b\u008c\7q\2\2\u008c\u008d"+
		"\7n\2\2\u008d\u008e\7g\2\2\u008e\u008f\7c\2\2\u008f\u0090\7p\2\2\u0090"+
		"\4\3\2\2\2\u0091\u0092\7d\2\2\u0092\u0093\7t\2\2\u0093\u0094\7g\2\2\u0094"+
		"\u0095\7c\2\2\u0095\u0096\7m\2\2\u0096\6\3\2\2\2\u0097\u0098\7e\2\2\u0098"+
		"\u0099\7j\2\2\u0099\u009a\7c\2\2\u009a\u009b\7t\2\2\u009b\b\3\2\2\2\u009c"+
		"\u009d\7e\2\2\u009d\u009e\7q\2\2\u009e\u009f\7p\2\2\u009f\u00a0\7v\2\2"+
		"\u00a0\u00a1\7k\2\2\u00a1\u00a2\7p\2\2\u00a2\u00a3\7w\2\2\u00a3\u00a4"+
		"\7g\2\2\u00a4\n\3\2\2\2\u00a5\u00a6\7f\2\2\u00a6\u00a7\7q\2\2\u00a7\f"+
		"\3\2\2\2\u00a8\u00a9\7f\2\2\u00a9\u00aa\7q\2\2\u00aa\u00ab\7w\2\2\u00ab"+
		"\u00ac\7d\2\2\u00ac\u00ad\7n\2\2\u00ad\u00ae\7g\2\2\u00ae\16\3\2\2\2\u00af"+
		"\u00b0\7g\2\2\u00b0\u00b1\7n\2\2\u00b1\u00b2\7u\2\2\u00b2\u00b3\7g\2\2"+
		"\u00b3\20\3\2\2\2\u00b4\u00b5\7h\2\2\u00b5\u00b6\7q\2\2\u00b6\u00b7\7"+
		"t\2\2\u00b7\22\3\2\2\2\u00b8\u00b9\7k\2\2\u00b9\u00ba\7h\2\2\u00ba\24"+
		"\3\2\2\2\u00bb\u00bc\7k\2\2\u00bc\u00bd\7p\2\2\u00bd\u00be\7v\2\2\u00be"+
		"\26\3\2\2\2\u00bf\u00c0\7p\2\2\u00c0\u00c1\7g\2\2\u00c1\u00c2\7y\2\2\u00c2"+
		"\30\3\2\2\2\u00c3\u00c4\7t\2\2\u00c4\u00c5\7g\2\2\u00c5\u00c6\7v\2\2\u00c6"+
		"\u00c7\7w\2\2\u00c7\u00c8\7t\2\2\u00c8\u00c9\7p\2\2\u00c9\32\3\2\2\2\u00ca"+
		"\u00cb\7y\2\2\u00cb\u00cc\7j\2\2\u00cc\u00cd\7k\2\2\u00cd\u00ce\7n\2\2"+
		"\u00ce\u00cf\7g\2\2\u00cf\34\3\2\2\2\u00d0\u00d1\5\37\20\2\u00d1\36\3"+
		"\2\2\2\u00d2\u00d3\5!\21\2\u00d3 \3\2\2\2\u00d4\u00df\7\62\2\2\u00d5\u00dc"+
		"\5\'\24\2\u00d6\u00d8\5#\22\2\u00d7\u00d6\3\2\2\2\u00d7\u00d8\3\2\2\2"+
		"\u00d8\u00dd\3\2\2\2\u00d9\u00da\5+\26\2\u00da\u00db\5#\22\2\u00db\u00dd"+
		"\3\2\2\2\u00dc\u00d7\3\2\2\2\u00dc\u00d9\3\2\2\2\u00dd\u00df\3\2\2\2\u00de"+
		"\u00d4\3\2\2\2\u00de\u00d5\3\2\2\2\u00df\"\3\2\2\2\u00e0\u00e8\5%\23\2"+
		"\u00e1\u00e3\5)\25\2\u00e2\u00e1\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e2"+
		"\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e7\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7"+
		"\u00e9\5%\23\2\u00e8\u00e4\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9$\3\2\2\2"+
		"\u00ea\u00ed\7\62\2\2\u00eb\u00ed\5\'\24\2\u00ec\u00ea\3\2\2\2\u00ec\u00eb"+
		"\3\2\2\2\u00ed&\3\2\2\2\u00ee\u00ef\t\2\2\2\u00ef(\3\2\2\2\u00f0\u00f3"+
		"\5%\23\2\u00f1\u00f3\7a\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f1\3\2\2\2\u00f3"+
		"*\3\2\2\2\u00f4\u00f6\7a\2\2\u00f5\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7"+
		"\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8,\3\2\2\2\u00f9\u00fa\5/\30\2"+
		"\u00fa.\3\2\2\2\u00fb\u00fc\5#\22\2\u00fc\u00fe\5O(\2\u00fd\u00ff\5#\22"+
		"\2\u00fe\u00fd\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0101\3\2\2\2\u0100\u0102"+
		"\5\61\31\2\u0101\u0100\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u010d\3\2\2\2"+
		"\u0103\u0104\5O(\2\u0104\u0106\5#\22\2\u0105\u0107\5\61\31\2\u0106\u0105"+
		"\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u010d\3\2\2\2\u0108\u0109\5#\22\2\u0109"+
		"\u010a\5\61\31\2\u010a\u010d\3\2\2\2\u010b\u010d\5#\22\2\u010c\u00fb\3"+
		"\2\2\2\u010c\u0103\3\2\2\2\u010c\u0108\3\2\2\2\u010c\u010b\3\2\2\2\u010d"+
		"\60\3\2\2\2\u010e\u010f\5\63\32\2\u010f\u0110\5\65\33\2\u0110\62\3\2\2"+
		"\2\u0111\u0112\t\3\2\2\u0112\64\3\2\2\2\u0113\u0115\5\67\34\2\u0114\u0113"+
		"\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0117\5#\22\2\u0117"+
		"\66\3\2\2\2\u0118\u0119\t\4\2\2\u01198\3\2\2\2\u011a\u011b\7v\2\2\u011b"+
		"\u011c\7t\2\2\u011c\u011d\7w\2\2\u011d\u0124\7g\2\2\u011e\u011f\7h\2\2"+
		"\u011f\u0120\7c\2\2\u0120\u0121\7n\2\2\u0121\u0122\7u\2\2\u0122\u0124"+
		"\7g\2\2\u0123\u011a\3\2\2\2\u0123\u011e\3\2\2\2\u0124:\3\2\2\2\u0125\u0126"+
		"\7)\2\2\u0126\u0127\5=\37\2\u0127\u0128\7)\2\2\u0128<\3\2\2\2\u0129\u012a"+
		"\n\5\2\2\u012a>\3\2\2\2\u012b\u012c\7*\2\2\u012c@\3\2\2\2\u012d\u012e"+
		"\7+\2\2\u012eB\3\2\2\2\u012f\u0130\7}\2\2\u0130D\3\2\2\2\u0131\u0132\7"+
		"\177\2\2\u0132F\3\2\2\2\u0133\u0134\7]\2\2\u0134H\3\2\2\2\u0135\u0136"+
		"\7_\2\2\u0136J\3\2\2\2\u0137\u0138\7=\2\2\u0138L\3\2\2\2\u0139\u013a\7"+
		".\2\2\u013aN\3\2\2\2\u013b\u013c\7\60\2\2\u013cP\3\2\2\2\u013d\u013e\7"+
		"?\2\2\u013eR\3\2\2\2\u013f\u0140\7@\2\2\u0140T\3\2\2\2\u0141\u0142\7>"+
		"\2\2\u0142V\3\2\2\2\u0143\u0144\7#\2\2\u0144X\3\2\2\2\u0145\u0146\7A\2"+
		"\2\u0146Z\3\2\2\2\u0147\u0148\7<\2\2\u0148\\\3\2\2\2\u0149\u014a\7?\2"+
		"\2\u014a\u014b\7?\2\2\u014b^\3\2\2\2\u014c\u014d\7>\2\2\u014d\u014e\7"+
		"?\2\2\u014e`\3\2\2\2\u014f\u0150\7@\2\2\u0150\u0151\7?\2\2\u0151b\3\2"+
		"\2\2\u0152\u0153\7#\2\2\u0153\u0154\7?\2\2\u0154d\3\2\2\2\u0155\u0156"+
		"\7(\2\2\u0156\u0157\7(\2\2\u0157f\3\2\2\2\u0158\u0159\7~\2\2\u0159\u015a"+
		"\7~\2\2\u015ah\3\2\2\2\u015b\u015c\7-\2\2\u015c\u015d\7-\2\2\u015dj\3"+
		"\2\2\2\u015e\u015f\7/\2\2\u015f\u0160\7/\2\2\u0160l\3\2\2\2\u0161\u0162"+
		"\7-\2\2\u0162n\3\2\2\2\u0163\u0164\7/\2\2\u0164p\3\2\2\2\u0165\u0166\7"+
		",\2\2\u0166r\3\2\2\2\u0167\u0168\7\61\2\2\u0168t\3\2\2\2\u0169\u016a\7"+
		"-\2\2\u016a\u016b\7?\2\2\u016bv\3\2\2\2\u016c\u016d\7/\2\2\u016d\u016e"+
		"\7?\2\2\u016ex\3\2\2\2\u016f\u0170\7,\2\2\u0170\u0171\7?\2\2\u0171z\3"+
		"\2\2\2\u0172\u0173\7\61\2\2\u0173\u0174\7?\2\2\u0174|\3\2\2\2\u0175\u0179"+
		"\5\177@\2\u0176\u0178\5\u0081A\2\u0177\u0176\3\2\2\2\u0178\u017b\3\2\2"+
		"\2\u0179\u0177\3\2\2\2\u0179\u017a\3\2\2\2\u017a~\3\2\2\2\u017b\u0179"+
		"\3\2\2\2\u017c\u0181\t\6\2\2\u017d\u0181\n\7\2\2\u017e\u017f\t\b\2\2\u017f"+
		"\u0181\t\t\2\2\u0180\u017c\3\2\2\2\u0180\u017d\3\2\2\2\u0180\u017e\3\2"+
		"\2\2\u0181\u0080\3\2\2\2\u0182\u0187\t\n\2\2\u0183\u0187\n\7\2\2\u0184"+
		"\u0185\t\b\2\2\u0185\u0187\t\t\2\2\u0186\u0182\3\2\2\2\u0186\u0183\3\2"+
		"\2\2\u0186\u0184\3\2\2\2\u0187\u0082\3\2\2\2\u0188\u018a\t\13\2\2\u0189"+
		"\u0188\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u0189\3\2\2\2\u018b\u018c\3\2"+
		"\2\2\u018c\u018d\3\2\2\2\u018d\u018e\bB\2\2\u018e\u0084\3\2\2\2\u018f"+
		"\u0190\7\61\2\2\u0190\u0191\7,\2\2\u0191\u0195\3\2\2\2\u0192\u0194\13"+
		"\2\2\2\u0193\u0192\3\2\2\2\u0194\u0197\3\2\2\2\u0195\u0196\3\2\2\2\u0195"+
		"\u0193\3\2\2\2\u0196\u0198\3\2\2\2\u0197\u0195\3\2\2\2\u0198\u0199\7,"+
		"\2\2\u0199\u019a\7\61\2\2\u019a\u019b\3\2\2\2\u019b\u019c\bC\3\2\u019c"+
		"\u0086\3\2\2\2\u019d\u019e\7\61\2\2\u019e\u019f\7\61\2\2\u019f\u01a3\3"+
		"\2\2\2\u01a0\u01a2\n\f\2\2\u01a1\u01a0\3\2\2\2\u01a2\u01a5\3\2\2\2\u01a3"+
		"\u01a1\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a6\3\2\2\2\u01a5\u01a3\3\2"+
		"\2\2\u01a6\u01a7\bD\3\2\u01a7\u0088\3\2\2\2\27\2\u00d7\u00dc\u00de\u00e4"+
		"\u00e8\u00ec\u00f2\u00f7\u00fe\u0101\u0106\u010c\u0114\u0123\u0179\u0180"+
		"\u0186\u018b\u0195\u01a3\4\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}