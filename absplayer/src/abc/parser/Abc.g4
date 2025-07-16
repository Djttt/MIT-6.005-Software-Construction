// Compile all your grammars using
//       java -jar ../../../lib/antlr.jar *.g4
// then Refresh in Eclipse.
//
grammar Abc;
import Configuration;

abc_tune
    : header body EOF
    ;

// Header parsing: each header field is a single lexer token
header
    : FIELD_NUMBER NEWLINE
      FIELD_TITLE NEWLINE
      field_other*
      FIELD_KEY NEWLINE
    ;

field_other
    : FIELD_COMPOSER   NEWLINE
    | FIELD_DEFAULT_LENGTH NEWLINE
    | FIELD_METER      NEWLINE
    | FIELD_TEMPO      NEWLINE
    | FIELD_VOICE      NEWLINE
    ;

// Music body: one or more lines
body
    : music_line+
    ;

// Each line must end with a newline, so it cannot be empty
music_line
    : music_element* NEWLINE
    ;

music_element
    : note
    | chord
    | tuplet
    | barline
    | nth_repeat
    ;

// Note definitions
note
    : note_or_rest note_length?
    ;

note_or_rest
    : pitch
    | REST  // fixed: use REST token
    ;


pitch
    : ACCIDENTAL? BASE_NOTE OCTAVE?
    ;

note_length
    : INT                  // e.g. 2
    | '/' INT?             // e.g. /2 or /
    | INT '/' INT?         // e.g. 3/4
    ;

// Chords and tuplets
chord
    : '[' note+ ']'
    ;

tuplet
    : '(' INT note+
    ;

// Bar lines and repeats
barline
    : '|'  | '||' | '[|' | '|]' | ':|' | '|:'
    ;

nth_repeat
    : '[1' | '[2'
    ;

// ================= Lexer rules =================

// Header fields as single tokens
REST         : 'z' ; // Add this!

FIELD_NUMBER        : 'X:' [0-9]+ ;
FIELD_TITLE         : 'T:' ~[\r\n]+ ;
FIELD_COMPOSER      : 'C:' ~[\r\n]+ ;
FIELD_DEFAULT_LENGTH: 'L:' [0-9]+ '/' [0-9]+ ;
FIELD_METER         : 'M:' ~[\r\n]+ ;
FIELD_TEMPO         : 'Q:' ~[\r\n]+ ;
FIELD_VOICE         : 'V:' ~[\r\n]+ ;
FIELD_KEY           : 'K:' ~[\r\n]+ ;

// Comments are skipped
COMMENT             : '%' ~[\r\n]* NEWLINE -> skip ;

NEWLINE             : '\r'? '\n' ;
WS                  : [ \t]+ -> skip ;

// Accidentals: two-char before one-char to ensure longest match
ACCIDENTAL   : '^^' | '__' | '^' | '_' | '=' ;

// Notes and octave marks
BASE_NOTE           : [A-Ga-g] ;
OCTAVE       : (','+ | '\''+); // fixed

// Integers
INT                 : [0-9]+ ;


