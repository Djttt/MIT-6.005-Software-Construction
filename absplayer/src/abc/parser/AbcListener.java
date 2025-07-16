// Generated from Abc.g4 by ANTLR 4.5.1

package abc.parser;
// Do not edit this .java file! Edit the .g4 file and re-run Antlr.

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AbcParser}.
 */
public interface AbcListener extends ParseTreeListener {
  /**
   * Enter a parse tree produced by {@link AbcParser#abc_tune}.
   * @param ctx the parse tree
   */
  void enterAbc_tune(AbcParser.Abc_tuneContext ctx);
  /**
   * Exit a parse tree produced by {@link AbcParser#abc_tune}.
   * @param ctx the parse tree
   */
  void exitAbc_tune(AbcParser.Abc_tuneContext ctx);
  /**
   * Enter a parse tree produced by {@link AbcParser#header}.
   * @param ctx the parse tree
   */
  void enterHeader(AbcParser.HeaderContext ctx);
  /**
   * Exit a parse tree produced by {@link AbcParser#header}.
   * @param ctx the parse tree
   */
  void exitHeader(AbcParser.HeaderContext ctx);
  /**
   * Enter a parse tree produced by {@link AbcParser#field_other}.
   * @param ctx the parse tree
   */
  void enterField_other(AbcParser.Field_otherContext ctx);
  /**
   * Exit a parse tree produced by {@link AbcParser#field_other}.
   * @param ctx the parse tree
   */
  void exitField_other(AbcParser.Field_otherContext ctx);
  /**
   * Enter a parse tree produced by {@link AbcParser#body}.
   * @param ctx the parse tree
   */
  void enterBody(AbcParser.BodyContext ctx);
  /**
   * Exit a parse tree produced by {@link AbcParser#body}.
   * @param ctx the parse tree
   */
  void exitBody(AbcParser.BodyContext ctx);
  /**
   * Enter a parse tree produced by {@link AbcParser#music_line}.
   * @param ctx the parse tree
   */
  void enterMusic_line(AbcParser.Music_lineContext ctx);
  /**
   * Exit a parse tree produced by {@link AbcParser#music_line}.
   * @param ctx the parse tree
   */
  void exitMusic_line(AbcParser.Music_lineContext ctx);
  /**
   * Enter a parse tree produced by {@link AbcParser#music_element}.
   * @param ctx the parse tree
   */
  void enterMusic_element(AbcParser.Music_elementContext ctx);
  /**
   * Exit a parse tree produced by {@link AbcParser#music_element}.
   * @param ctx the parse tree
   */
  void exitMusic_element(AbcParser.Music_elementContext ctx);
  /**
   * Enter a parse tree produced by {@link AbcParser#note}.
   * @param ctx the parse tree
   */
  void enterNote(AbcParser.NoteContext ctx);
  /**
   * Exit a parse tree produced by {@link AbcParser#note}.
   * @param ctx the parse tree
   */
  void exitNote(AbcParser.NoteContext ctx);
  /**
   * Enter a parse tree produced by {@link AbcParser#note_or_rest}.
   * @param ctx the parse tree
   */
  void enterNote_or_rest(AbcParser.Note_or_restContext ctx);
  /**
   * Exit a parse tree produced by {@link AbcParser#note_or_rest}.
   * @param ctx the parse tree
   */
  void exitNote_or_rest(AbcParser.Note_or_restContext ctx);
  /**
   * Enter a parse tree produced by {@link AbcParser#pitch}.
   * @param ctx the parse tree
   */
  void enterPitch(AbcParser.PitchContext ctx);
  /**
   * Exit a parse tree produced by {@link AbcParser#pitch}.
   * @param ctx the parse tree
   */
  void exitPitch(AbcParser.PitchContext ctx);
  /**
   * Enter a parse tree produced by {@link AbcParser#note_length}.
   * @param ctx the parse tree
   */
  void enterNote_length(AbcParser.Note_lengthContext ctx);
  /**
   * Exit a parse tree produced by {@link AbcParser#note_length}.
   * @param ctx the parse tree
   */
  void exitNote_length(AbcParser.Note_lengthContext ctx);
  /**
   * Enter a parse tree produced by {@link AbcParser#chord}.
   * @param ctx the parse tree
   */
  void enterChord(AbcParser.ChordContext ctx);
  /**
   * Exit a parse tree produced by {@link AbcParser#chord}.
   * @param ctx the parse tree
   */
  void exitChord(AbcParser.ChordContext ctx);
  /**
   * Enter a parse tree produced by {@link AbcParser#tuplet}.
   * @param ctx the parse tree
   */
  void enterTuplet(AbcParser.TupletContext ctx);
  /**
   * Exit a parse tree produced by {@link AbcParser#tuplet}.
   * @param ctx the parse tree
   */
  void exitTuplet(AbcParser.TupletContext ctx);
  /**
   * Enter a parse tree produced by {@link AbcParser#barline}.
   * @param ctx the parse tree
   */
  void enterBarline(AbcParser.BarlineContext ctx);
  /**
   * Exit a parse tree produced by {@link AbcParser#barline}.
   * @param ctx the parse tree
   */
  void exitBarline(AbcParser.BarlineContext ctx);
  /**
   * Enter a parse tree produced by {@link AbcParser#nth_repeat}.
   * @param ctx the parse tree
   */
  void enterNth_repeat(AbcParser.Nth_repeatContext ctx);
  /**
   * Exit a parse tree produced by {@link AbcParser#nth_repeat}.
   * @param ctx the parse tree
   */
  void exitNth_repeat(AbcParser.Nth_repeatContext ctx);
}