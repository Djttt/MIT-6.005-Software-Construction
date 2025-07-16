// Generated from Abc.g4 by ANTLR 4.5.1

package abc.parser;
// Do not edit this .java file! Edit the .g4 file and re-run Antlr.

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AbcParser extends Parser {
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
  public static final int
    RULE_abc_tune = 0, RULE_header = 1, RULE_field_other = 2, RULE_body = 3, 
    RULE_music_line = 4, RULE_music_element = 5, RULE_note = 6, RULE_note_or_rest = 7, 
    RULE_pitch = 8, RULE_note_length = 9, RULE_chord = 10, RULE_tuplet = 11, 
    RULE_barline = 12, RULE_nth_repeat = 13;
  public static final String[] ruleNames = {
    "abc_tune", "header", "field_other", "body", "music_line", "music_element", 
    "note", "note_or_rest", "pitch", "note_length", "chord", "tuplet", "barline", 
    "nth_repeat"
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

  @Override
  public String getGrammarFileName() { return "Abc.g4"; }

  @Override
  public String[] getRuleNames() { return ruleNames; }

  @Override
  public String getSerializedATN() { return _serializedATN; }

  @Override
  public ATN getATN() { return _ATN; }


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

  public AbcParser(TokenStream input) {
    super(input);
    _interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
  }
  public static class Abc_tuneContext extends ParserRuleContext {
    public HeaderContext header() {
      return getRuleContext(HeaderContext.class,0);
    }
    public BodyContext body() {
      return getRuleContext(BodyContext.class,0);
    }
    public TerminalNode EOF() { return getToken(AbcParser.EOF, 0); }
    public Abc_tuneContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_abc_tune; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).enterAbc_tune(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).exitAbc_tune(this);
    }
  }

  public final Abc_tuneContext abc_tune() throws RecognitionException {
    Abc_tuneContext _localctx = new Abc_tuneContext(_ctx, getState());
    enterRule(_localctx, 0, RULE_abc_tune);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(28);
      header();
      setState(29);
      body();
      setState(30);
      match(EOF);
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

  public static class HeaderContext extends ParserRuleContext {
    public TerminalNode FIELD_NUMBER() { return getToken(AbcParser.FIELD_NUMBER, 0); }
    public List<TerminalNode> NEWLINE() { return getTokens(AbcParser.NEWLINE); }
    public TerminalNode NEWLINE(int i) {
      return getToken(AbcParser.NEWLINE, i);
    }
    public TerminalNode FIELD_TITLE() { return getToken(AbcParser.FIELD_TITLE, 0); }
    public TerminalNode FIELD_KEY() { return getToken(AbcParser.FIELD_KEY, 0); }
    public List<Field_otherContext> field_other() {
      return getRuleContexts(Field_otherContext.class);
    }
    public Field_otherContext field_other(int i) {
      return getRuleContext(Field_otherContext.class,i);
    }
    public HeaderContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_header; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).enterHeader(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).exitHeader(this);
    }
  }

  public final HeaderContext header() throws RecognitionException {
    HeaderContext _localctx = new HeaderContext(_ctx, getState());
    enterRule(_localctx, 2, RULE_header);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(32);
      match(FIELD_NUMBER);
      setState(33);
      match(NEWLINE);
      setState(34);
      match(FIELD_TITLE);
      setState(35);
      match(NEWLINE);
      setState(39);
      _errHandler.sync(this);
      _la = _input.LA(1);
      while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FIELD_COMPOSER) | (1L << FIELD_DEFAULT_LENGTH) | (1L << FIELD_METER) | (1L << FIELD_TEMPO) | (1L << FIELD_VOICE))) != 0)) {
        {
        {
        setState(36);
        field_other();
        }
        }
        setState(41);
        _errHandler.sync(this);
        _la = _input.LA(1);
      }
      setState(42);
      match(FIELD_KEY);
      setState(43);
      match(NEWLINE);
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

  public static class Field_otherContext extends ParserRuleContext {
    public TerminalNode FIELD_COMPOSER() { return getToken(AbcParser.FIELD_COMPOSER, 0); }
    public TerminalNode NEWLINE() { return getToken(AbcParser.NEWLINE, 0); }
    public TerminalNode FIELD_DEFAULT_LENGTH() { return getToken(AbcParser.FIELD_DEFAULT_LENGTH, 0); }
    public TerminalNode FIELD_METER() { return getToken(AbcParser.FIELD_METER, 0); }
    public TerminalNode FIELD_TEMPO() { return getToken(AbcParser.FIELD_TEMPO, 0); }
    public TerminalNode FIELD_VOICE() { return getToken(AbcParser.FIELD_VOICE, 0); }
    public Field_otherContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_field_other; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).enterField_other(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).exitField_other(this);
    }
  }

  public final Field_otherContext field_other() throws RecognitionException {
    Field_otherContext _localctx = new Field_otherContext(_ctx, getState());
    enterRule(_localctx, 4, RULE_field_other);
    try {
      setState(55);
      switch (_input.LA(1)) {
      case FIELD_COMPOSER:
        enterOuterAlt(_localctx, 1);
        {
        setState(45);
        match(FIELD_COMPOSER);
        setState(46);
        match(NEWLINE);
        }
        break;
      case FIELD_DEFAULT_LENGTH:
        enterOuterAlt(_localctx, 2);
        {
        setState(47);
        match(FIELD_DEFAULT_LENGTH);
        setState(48);
        match(NEWLINE);
        }
        break;
      case FIELD_METER:
        enterOuterAlt(_localctx, 3);
        {
        setState(49);
        match(FIELD_METER);
        setState(50);
        match(NEWLINE);
        }
        break;
      case FIELD_TEMPO:
        enterOuterAlt(_localctx, 4);
        {
        setState(51);
        match(FIELD_TEMPO);
        setState(52);
        match(NEWLINE);
        }
        break;
      case FIELD_VOICE:
        enterOuterAlt(_localctx, 5);
        {
        setState(53);
        match(FIELD_VOICE);
        setState(54);
        match(NEWLINE);
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

  public static class BodyContext extends ParserRuleContext {
    public List<Music_lineContext> music_line() {
      return getRuleContexts(Music_lineContext.class);
    }
    public Music_lineContext music_line(int i) {
      return getRuleContext(Music_lineContext.class,i);
    }
    public BodyContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_body; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).enterBody(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).exitBody(this);
    }
  }

  public final BodyContext body() throws RecognitionException {
    BodyContext _localctx = new BodyContext(_ctx, getState());
    enterRule(_localctx, 6, RULE_body);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(58); 
      _errHandler.sync(this);
      _la = _input.LA(1);
      do {
        {
        {
        setState(57);
        music_line();
        }
        }
        setState(60); 
        _errHandler.sync(this);
        _la = _input.LA(1);
      } while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << REST) | (1L << NEWLINE) | (1L << ACCIDENTAL) | (1L << BASE_NOTE))) != 0) );
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

  public static class Music_lineContext extends ParserRuleContext {
    public TerminalNode NEWLINE() { return getToken(AbcParser.NEWLINE, 0); }
    public List<Music_elementContext> music_element() {
      return getRuleContexts(Music_elementContext.class);
    }
    public Music_elementContext music_element(int i) {
      return getRuleContext(Music_elementContext.class,i);
    }
    public Music_lineContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_music_line; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).enterMusic_line(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).exitMusic_line(this);
    }
  }

  public final Music_lineContext music_line() throws RecognitionException {
    Music_lineContext _localctx = new Music_lineContext(_ctx, getState());
    enterRule(_localctx, 8, RULE_music_line);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(65);
      _errHandler.sync(this);
      _la = _input.LA(1);
      while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << REST) | (1L << ACCIDENTAL) | (1L << BASE_NOTE))) != 0)) {
        {
        {
        setState(62);
        music_element();
        }
        }
        setState(67);
        _errHandler.sync(this);
        _la = _input.LA(1);
      }
      setState(68);
      match(NEWLINE);
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

  public static class Music_elementContext extends ParserRuleContext {
    public NoteContext note() {
      return getRuleContext(NoteContext.class,0);
    }
    public ChordContext chord() {
      return getRuleContext(ChordContext.class,0);
    }
    public TupletContext tuplet() {
      return getRuleContext(TupletContext.class,0);
    }
    public BarlineContext barline() {
      return getRuleContext(BarlineContext.class,0);
    }
    public Nth_repeatContext nth_repeat() {
      return getRuleContext(Nth_repeatContext.class,0);
    }
    public Music_elementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_music_element; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).enterMusic_element(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).exitMusic_element(this);
    }
  }

  public final Music_elementContext music_element() throws RecognitionException {
    Music_elementContext _localctx = new Music_elementContext(_ctx, getState());
    enterRule(_localctx, 10, RULE_music_element);
    try {
      setState(75);
      switch (_input.LA(1)) {
      case REST:
      case ACCIDENTAL:
      case BASE_NOTE:
        enterOuterAlt(_localctx, 1);
        {
        setState(70);
        note();
        }
        break;
      case T__1:
        enterOuterAlt(_localctx, 2);
        {
        setState(71);
        chord();
        }
        break;
      case T__3:
        enterOuterAlt(_localctx, 3);
        {
        setState(72);
        tuplet();
        }
        break;
      case T__4:
      case T__5:
      case T__6:
      case T__7:
      case T__8:
      case T__9:
        enterOuterAlt(_localctx, 4);
        {
        setState(73);
        barline();
        }
        break;
      case T__10:
      case T__11:
        enterOuterAlt(_localctx, 5);
        {
        setState(74);
        nth_repeat();
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

  public static class NoteContext extends ParserRuleContext {
    public Note_or_restContext note_or_rest() {
      return getRuleContext(Note_or_restContext.class,0);
    }
    public Note_lengthContext note_length() {
      return getRuleContext(Note_lengthContext.class,0);
    }
    public NoteContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_note; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).enterNote(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).exitNote(this);
    }
  }

  public final NoteContext note() throws RecognitionException {
    NoteContext _localctx = new NoteContext(_ctx, getState());
    enterRule(_localctx, 12, RULE_note);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(77);
      note_or_rest();
      setState(79);
      _la = _input.LA(1);
      if (_la==T__0 || _la==INT) {
        {
        setState(78);
        note_length();
        }
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

  public static class Note_or_restContext extends ParserRuleContext {
    public PitchContext pitch() {
      return getRuleContext(PitchContext.class,0);
    }
    public TerminalNode REST() { return getToken(AbcParser.REST, 0); }
    public Note_or_restContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_note_or_rest; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).enterNote_or_rest(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).exitNote_or_rest(this);
    }
  }

  public final Note_or_restContext note_or_rest() throws RecognitionException {
    Note_or_restContext _localctx = new Note_or_restContext(_ctx, getState());
    enterRule(_localctx, 14, RULE_note_or_rest);
    try {
      setState(83);
      switch (_input.LA(1)) {
      case ACCIDENTAL:
      case BASE_NOTE:
        enterOuterAlt(_localctx, 1);
        {
        setState(81);
        pitch();
        }
        break;
      case REST:
        enterOuterAlt(_localctx, 2);
        {
        setState(82);
        match(REST);
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

  public static class PitchContext extends ParserRuleContext {
    public TerminalNode BASE_NOTE() { return getToken(AbcParser.BASE_NOTE, 0); }
    public TerminalNode ACCIDENTAL() { return getToken(AbcParser.ACCIDENTAL, 0); }
    public TerminalNode OCTAVE() { return getToken(AbcParser.OCTAVE, 0); }
    public PitchContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_pitch; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).enterPitch(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).exitPitch(this);
    }
  }

  public final PitchContext pitch() throws RecognitionException {
    PitchContext _localctx = new PitchContext(_ctx, getState());
    enterRule(_localctx, 16, RULE_pitch);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(86);
      _la = _input.LA(1);
      if (_la==ACCIDENTAL) {
        {
        setState(85);
        match(ACCIDENTAL);
        }
      }

      setState(88);
      match(BASE_NOTE);
      setState(90);
      _la = _input.LA(1);
      if (_la==OCTAVE) {
        {
        setState(89);
        match(OCTAVE);
        }
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

  public static class Note_lengthContext extends ParserRuleContext {
    public List<TerminalNode> INT() { return getTokens(AbcParser.INT); }
    public TerminalNode INT(int i) {
      return getToken(AbcParser.INT, i);
    }
    public Note_lengthContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_note_length; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).enterNote_length(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).exitNote_length(this);
    }
  }

  public final Note_lengthContext note_length() throws RecognitionException {
    Note_lengthContext _localctx = new Note_lengthContext(_ctx, getState());
    enterRule(_localctx, 18, RULE_note_length);
    int _la;
    try {
      setState(102);
      switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
      case 1:
        enterOuterAlt(_localctx, 1);
        {
        setState(92);
        match(INT);
        }
        break;
      case 2:
        enterOuterAlt(_localctx, 2);
        {
        setState(93);
        match(T__0);
        setState(95);
        _la = _input.LA(1);
        if (_la==INT) {
          {
          setState(94);
          match(INT);
          }
        }

        }
        break;
      case 3:
        enterOuterAlt(_localctx, 3);
        {
        setState(97);
        match(INT);
        setState(98);
        match(T__0);
        setState(100);
        _la = _input.LA(1);
        if (_la==INT) {
          {
          setState(99);
          match(INT);
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

  public static class ChordContext extends ParserRuleContext {
    public List<NoteContext> note() {
      return getRuleContexts(NoteContext.class);
    }
    public NoteContext note(int i) {
      return getRuleContext(NoteContext.class,i);
    }
    public ChordContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_chord; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).enterChord(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).exitChord(this);
    }
  }

  public final ChordContext chord() throws RecognitionException {
    ChordContext _localctx = new ChordContext(_ctx, getState());
    enterRule(_localctx, 20, RULE_chord);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(104);
      match(T__1);
      setState(106); 
      _errHandler.sync(this);
      _la = _input.LA(1);
      do {
        {
        {
        setState(105);
        note();
        }
        }
        setState(108); 
        _errHandler.sync(this);
        _la = _input.LA(1);
      } while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << REST) | (1L << ACCIDENTAL) | (1L << BASE_NOTE))) != 0) );
      setState(110);
      match(T__2);
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

  public static class TupletContext extends ParserRuleContext {
    public TerminalNode INT() { return getToken(AbcParser.INT, 0); }
    public List<NoteContext> note() {
      return getRuleContexts(NoteContext.class);
    }
    public NoteContext note(int i) {
      return getRuleContext(NoteContext.class,i);
    }
    public TupletContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_tuplet; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).enterTuplet(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).exitTuplet(this);
    }
  }

  public final TupletContext tuplet() throws RecognitionException {
    TupletContext _localctx = new TupletContext(_ctx, getState());
    enterRule(_localctx, 22, RULE_tuplet);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
      setState(112);
      match(T__3);
      setState(113);
      match(INT);
      setState(115); 
      _errHandler.sync(this);
      _alt = 1;
      do {
        switch (_alt) {
        case 1:
          {
          {
          setState(114);
          note();
          }
          }
          break;
        default:
          throw new NoViableAltException(this);
        }
        setState(117); 
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input,13,_ctx);
      } while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

  public static class BarlineContext extends ParserRuleContext {
    public BarlineContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_barline; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).enterBarline(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).exitBarline(this);
    }
  }

  public final BarlineContext barline() throws RecognitionException {
    BarlineContext _localctx = new BarlineContext(_ctx, getState());
    enterRule(_localctx, 24, RULE_barline);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(119);
      _la = _input.LA(1);
      if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9))) != 0)) ) {
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

  public static class Nth_repeatContext extends ParserRuleContext {
    public Nth_repeatContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_nth_repeat; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).enterNth_repeat(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).exitNth_repeat(this);
    }
  }

  public final Nth_repeatContext nth_repeat() throws RecognitionException {
    Nth_repeatContext _localctx = new Nth_repeatContext(_ctx, getState());
    enterRule(_localctx, 26, RULE_nth_repeat);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(121);
      _la = _input.LA(1);
      if ( !(_la==T__10 || _la==T__11) ) {
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

  public static final String _serializedATN =
    "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\36~\4\2\t\2\4\3"+
      "\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
      "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\3\3\3"+
      "\3\3\3\3\3\3\7\3(\n\3\f\3\16\3+\13\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3"+
      "\4\3\4\3\4\3\4\3\4\3\4\5\4:\n\4\3\5\6\5=\n\5\r\5\16\5>\3\6\7\6B\n"+
      "\6\f\6\16\6E\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\5\7N\n\7\3\b\3\b\5\b"+
      "R\n\b\3\t\3\t\5\tV\n\t\3\n\5\nY\n\n\3\n\3\n\5\n]\n\n\3\13\3\13\3\13"+
      "\5\13b\n\13\3\13\3\13\3\13\5\13g\n\13\5\13i\n\13\3\f\3\f\6\fm\n\f"+
      "\r\f\16\fn\3\f\3\f\3\r\3\r\3\r\6\rv\n\r\r\r\16\rw\3\16\3\16\3\17\3"+
      "\17\3\17\2\2\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2\4\3\2\7\f\3"+
      "\2\r\16\u0084\2\36\3\2\2\2\4\"\3\2\2\2\69\3\2\2\2\b<\3\2\2\2\nC\3"+
      "\2\2\2\fM\3\2\2\2\16O\3\2\2\2\20U\3\2\2\2\22X\3\2\2\2\24h\3\2\2\2"+
      "\26j\3\2\2\2\30r\3\2\2\2\32y\3\2\2\2\34{\3\2\2\2\36\37\5\4\3\2\37"+
      " \5\b\5\2 !\7\2\2\3!\3\3\2\2\2\"#\7\20\2\2#$\7\31\2\2$%\7\21\2\2%"+
      ")\7\31\2\2&(\5\6\4\2\'&\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*,\3"+
      "\2\2\2+)\3\2\2\2,-\7\27\2\2-.\7\31\2\2.\5\3\2\2\2/\60\7\22\2\2\60"+
      ":\7\31\2\2\61\62\7\23\2\2\62:\7\31\2\2\63\64\7\24\2\2\64:\7\31\2\2"+
      "\65\66\7\25\2\2\66:\7\31\2\2\678\7\26\2\28:\7\31\2\29/\3\2\2\29\61"+
      "\3\2\2\29\63\3\2\2\29\65\3\2\2\29\67\3\2\2\2:\7\3\2\2\2;=\5\n\6\2"+
      "<;\3\2\2\2=>\3\2\2\2><\3\2\2\2>?\3\2\2\2?\t\3\2\2\2@B\5\f\7\2A@\3"+
      "\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2DF\3\2\2\2EC\3\2\2\2FG\7\31\2"+
      "\2G\13\3\2\2\2HN\5\16\b\2IN\5\26\f\2JN\5\30\r\2KN\5\32\16\2LN\5\34"+
      "\17\2MH\3\2\2\2MI\3\2\2\2MJ\3\2\2\2MK\3\2\2\2ML\3\2\2\2N\r\3\2\2\2"+
      "OQ\5\20\t\2PR\5\24\13\2QP\3\2\2\2QR\3\2\2\2R\17\3\2\2\2SV\5\22\n\2"+
      "TV\7\17\2\2US\3\2\2\2UT\3\2\2\2V\21\3\2\2\2WY\7\33\2\2XW\3\2\2\2X"+
      "Y\3\2\2\2YZ\3\2\2\2Z\\\7\34\2\2[]\7\35\2\2\\[\3\2\2\2\\]\3\2\2\2]"+
      "\23\3\2\2\2^i\7\36\2\2_a\7\3\2\2`b\7\36\2\2a`\3\2\2\2ab\3\2\2\2bi"+
      "\3\2\2\2cd\7\36\2\2df\7\3\2\2eg\7\36\2\2fe\3\2\2\2fg\3\2\2\2gi\3\2"+
      "\2\2h^\3\2\2\2h_\3\2\2\2hc\3\2\2\2i\25\3\2\2\2jl\7\4\2\2km\5\16\b"+
      "\2lk\3\2\2\2mn\3\2\2\2nl\3\2\2\2no\3\2\2\2op\3\2\2\2pq\7\5\2\2q\27"+
      "\3\2\2\2rs\7\6\2\2su\7\36\2\2tv\5\16\b\2ut\3\2\2\2vw\3\2\2\2wu\3\2"+
      "\2\2wx\3\2\2\2x\31\3\2\2\2yz\t\2\2\2z\33\3\2\2\2{|\t\3\2\2|\35\3\2"+
      "\2\2\20)9>CMQUX\\afhnw";
  public static final ATN _ATN =
    new ATNDeserializer().deserialize(_serializedATN.toCharArray());
  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}