// Generated from Abc.g4 by ANTLR 4.5.1

package abc.parser;
// Do not edit this .java file! Edit the .g4 file and re-run Antlr.

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AbcLexer extends Lexer {
  static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache =
    new PredictionContextCache();
  public static final int
    T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
    T__9=10, T__10=11, T__11=12, REST=13, FIELD_NUMBER=14, FIELD_TITLE=15, 
    FIELD_COMPOSER=16, FIELD_DEFAULT_LENGTH=17, FIELD_METER=18, FIELD_TEMPO=19, 
    FIELD_VOICE=20, FIELD_KEY=21, COMMENT=22, NEWLINE=23, WS=24, ACCIDENTAL=25, 
    BASE_NOTE=26, OCTAVE=27, INT=28;
  public static String[] modeNames = {
    "DEFAULT_MODE"
  };

  public static final String[] ruleNames = {
    "T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
    "T__9", "T__10", "T__11", "REST", "FIELD_NUMBER", "FIELD_TITLE", "FIELD_COMPOSER", 
    "FIELD_DEFAULT_LENGTH", "FIELD_METER", "FIELD_TEMPO", "FIELD_VOICE", 
    "FIELD_KEY", "COMMENT", "NEWLINE", "WS", "ACCIDENTAL", "BASE_NOTE", 
    "OCTAVE", "INT"
  };

  private static final String[] _LITERAL_NAMES = {
    null, "'/'", "'['", "']'", "'('", "'|'", "'||'", "'[|'", "'|]'", "':|'", 
    "'|:'", "'[1'", "'[2'", "'z'"
  };
  private static final String[] _SYMBOLIC_NAMES = {
    null, null, null, null, null, null, null, null, null, null, null, null, 
    null, "REST", "FIELD_NUMBER", "FIELD_TITLE", "FIELD_COMPOSER", "FIELD_DEFAULT_LENGTH", 
    "FIELD_METER", "FIELD_TEMPO", "FIELD_VOICE", "FIELD_KEY", "COMMENT", 
    "NEWLINE", "WS", "ACCIDENTAL", "BASE_NOTE", "OCTAVE", "INT"
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


      // This method makes the parser stop running if it encounters
      // invalid input and throw a RuntimeException.
      public void reportErrorsAsExceptions() {
          // To prevent any reports to standard error, add this line:
          //removeErrorListeners();
          
          addErrorListener(new BaseErrorListener() {
              public void syntaxError(Recognizer<?, ?> recognizer,
                                      Object offendingSymbol, 
                                      int line, int charPositionInLine,
                                      String msg, RecognitionException e) {
                  throw new ParseCancellationException(msg, e);
              }
          });
      }


  public AbcLexer(CharStream input) {
    super(input);
    _interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
  }

  @Override
  public String getGrammarFileName() { return "Abc.g4"; }

  @Override
  public String[] getRuleNames() { return ruleNames; }

  @Override
  public String getSerializedATN() { return _serializedATN; }

  @Override
  public String[] getModeNames() { return modeNames; }

  @Override
  public ATN getATN() { return _ATN; }

  public static final String _serializedATN =
    "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\36\u00d3\b\1\4"+
      "\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n"+
      "\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21"+
      "\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
      "\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3"+
      "\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t"+
      "\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16"+
      "\3\17\3\17\3\17\3\17\6\17a\n\17\r\17\16\17b\3\20\3\20\3\20\3\20\6"+
      "\20i\n\20\r\20\16\20j\3\21\3\21\3\21\3\21\6\21q\n\21\r\21\16\21r\3"+
      "\22\3\22\3\22\3\22\6\22y\n\22\r\22\16\22z\3\22\3\22\6\22\177\n\22"+
      "\r\22\16\22\u0080\3\23\3\23\3\23\3\23\6\23\u0087\n\23\r\23\16\23\u0088"+
      "\3\24\3\24\3\24\3\24\6\24\u008f\n\24\r\24\16\24\u0090\3\25\3\25\3"+
      "\25\3\25\6\25\u0097\n\25\r\25\16\25\u0098\3\26\3\26\3\26\3\26\6\26"+
      "\u009f\n\26\r\26\16\26\u00a0\3\27\3\27\7\27\u00a5\n\27\f\27\16\27"+
      "\u00a8\13\27\3\27\3\27\3\27\3\27\3\30\5\30\u00af\n\30\3\30\3\30\3"+
      "\31\6\31\u00b4\n\31\r\31\16\31\u00b5\3\31\3\31\3\32\3\32\3\32\3\32"+
      "\3\32\5\32\u00bf\n\32\3\33\3\33\3\34\6\34\u00c4\n\34\r\34\16\34\u00c5"+
      "\3\34\6\34\u00c9\n\34\r\34\16\34\u00ca\5\34\u00cd\n\34\3\35\6\35\u00d0"+
      "\n\35\r\35\16\35\u00d1\2\2\36\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
      "\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
      "/\31\61\32\63\33\65\34\67\359\36\3\2\7\3\2\62;\4\2\f\f\17\17\4\2\13"+
      "\13\"\"\4\2??`a\4\2CIci\u00e4\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
      "\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
      "\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
      "\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
      "\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63"+
      "\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\3;\3\2\2\2\5=\3\2\2"+
      "\2\7?\3\2\2\2\tA\3\2\2\2\13C\3\2\2\2\rE\3\2\2\2\17H\3\2\2\2\21K\3"+
      "\2\2\2\23N\3\2\2\2\25Q\3\2\2\2\27T\3\2\2\2\31W\3\2\2\2\33Z\3\2\2\2"+
      "\35\\\3\2\2\2\37d\3\2\2\2!l\3\2\2\2#t\3\2\2\2%\u0082\3\2\2\2\'\u008a"+
      "\3\2\2\2)\u0092\3\2\2\2+\u009a\3\2\2\2-\u00a2\3\2\2\2/\u00ae\3\2\2"+
      "\2\61\u00b3\3\2\2\2\63\u00be\3\2\2\2\65\u00c0\3\2\2\2\67\u00cc\3\2"+
      "\2\29\u00cf\3\2\2\2;<\7\61\2\2<\4\3\2\2\2=>\7]\2\2>\6\3\2\2\2?@\7"+
      "_\2\2@\b\3\2\2\2AB\7*\2\2B\n\3\2\2\2CD\7~\2\2D\f\3\2\2\2EF\7~\2\2"+
      "FG\7~\2\2G\16\3\2\2\2HI\7]\2\2IJ\7~\2\2J\20\3\2\2\2KL\7~\2\2LM\7_"+
      "\2\2M\22\3\2\2\2NO\7<\2\2OP\7~\2\2P\24\3\2\2\2QR\7~\2\2RS\7<\2\2S"+
      "\26\3\2\2\2TU\7]\2\2UV\7\63\2\2V\30\3\2\2\2WX\7]\2\2XY\7\64\2\2Y\32"+
      "\3\2\2\2Z[\7|\2\2[\34\3\2\2\2\\]\7Z\2\2]^\7<\2\2^`\3\2\2\2_a\t\2\2"+
      "\2`_\3\2\2\2ab\3\2\2\2b`\3\2\2\2bc\3\2\2\2c\36\3\2\2\2de\7V\2\2ef"+
      "\7<\2\2fh\3\2\2\2gi\n\3\2\2hg\3\2\2\2ij\3\2\2\2jh\3\2\2\2jk\3\2\2"+
      "\2k \3\2\2\2lm\7E\2\2mn\7<\2\2np\3\2\2\2oq\n\3\2\2po\3\2\2\2qr\3\2"+
      "\2\2rp\3\2\2\2rs\3\2\2\2s\"\3\2\2\2tu\7N\2\2uv\7<\2\2vx\3\2\2\2wy"+
      "\t\2\2\2xw\3\2\2\2yz\3\2\2\2zx\3\2\2\2z{\3\2\2\2{|\3\2\2\2|~\7\61"+
      "\2\2}\177\t\2\2\2~}\3\2\2\2\177\u0080\3\2\2\2\u0080~\3\2\2\2\u0080"+
      "\u0081\3\2\2\2\u0081$\3\2\2\2\u0082\u0083\7O\2\2\u0083\u0084\7<\2"+
      "\2\u0084\u0086\3\2\2\2\u0085\u0087\n\3\2\2\u0086\u0085\3\2\2\2\u0087"+
      "\u0088\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089&\3\2"+
      "\2\2\u008a\u008b\7S\2\2\u008b\u008c\7<\2\2\u008c\u008e\3\2\2\2\u008d"+
      "\u008f\n\3\2\2\u008e\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u008e"+
      "\3\2\2\2\u0090\u0091\3\2\2\2\u0091(\3\2\2\2\u0092\u0093\7X\2\2\u0093"+
      "\u0094\7<\2\2\u0094\u0096\3\2\2\2\u0095\u0097\n\3\2\2\u0096\u0095"+
      "\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2"+
      "\2\u0099*\3\2\2\2\u009a\u009b\7M\2\2\u009b\u009c\7<\2\2\u009c\u009e"+
      "\3\2\2\2\u009d\u009f\n\3\2\2\u009e\u009d\3\2\2\2\u009f\u00a0\3\2\2"+
      "\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1,\3\2\2\2\u00a2\u00a6"+
      "\7\'\2\2\u00a3\u00a5\n\3\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a8\3\2\2"+
      "\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a9\3\2\2\2\u00a8"+
      "\u00a6\3\2\2\2\u00a9\u00aa\5/\30\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac"+
      "\b\27\2\2\u00ac.\3\2\2\2\u00ad\u00af\7\17\2\2\u00ae\u00ad\3\2\2\2"+
      "\u00ae\u00af\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\7\f\2\2\u00b1"+
      "\60\3\2\2\2\u00b2\u00b4\t\4\2\2\u00b3\u00b2\3\2\2\2\u00b4\u00b5\3"+
      "\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\3\2\2\2"+
      "\u00b7\u00b8\b\31\2\2\u00b8\62\3\2\2\2\u00b9\u00ba\7`\2\2\u00ba\u00bf"+
      "\7`\2\2\u00bb\u00bc\7a\2\2\u00bc\u00bf\7a\2\2\u00bd\u00bf\t\5\2\2"+
      "\u00be\u00b9\3\2\2\2\u00be\u00bb\3\2\2\2\u00be\u00bd\3\2\2\2\u00bf"+
      "\64\3\2\2\2\u00c0\u00c1\t\6\2\2\u00c1\66\3\2\2\2\u00c2\u00c4\7.\2"+
      "\2\u00c3\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5"+
      "\u00c6\3\2\2\2\u00c6\u00cd\3\2\2\2\u00c7\u00c9\7)\2\2\u00c8\u00c7"+
      "\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2"+
      "\2\u00cb\u00cd\3\2\2\2\u00cc\u00c3\3\2\2\2\u00cc\u00c8\3\2\2\2\u00cd"+
      "8\3\2\2\2\u00ce\u00d0\t\2\2\2\u00cf\u00ce\3\2\2\2\u00d0\u00d1\3\2"+
      "\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2:\3\2\2\2\24\2b"+
      "jrz\u0080\u0088\u0090\u0098\u00a0\u00a6\u00ae\u00b5\u00be\u00c5\u00ca"+
      "\u00cc\u00d1\3\b\2\2";
  public static final ATN _ATN =
    new ATNDeserializer().deserialize(_serializedATN.toCharArray());
  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}