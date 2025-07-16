package abc.sound;

import static abc.sound.Pitch.OCTAVE;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * MusicLanguage defines static methods for constructing and manipulating Music expressions.
 */
public class MusicLanguage {

    // Prevent instantiation
    protected MusicLanguage() {}

    ////////////////////////////////////////////////////
    // Factory methods
    ////////////////////////////////////////////////////

    /**
     * Make Music from a string using a variant of abc notation
     *    (see http://www.walshaw.plus.com/abc/examples/).
     *
     * The notation consists of whitespace-delimited symbols representing either
     * notes or rests. The vertical bar | may be used as a delimiter
     * for measures; notes() treats it as a space.
     * Grammar:
     *     notes ::= symbol*
     *     symbol ::= . duration          // for a rest
     *              | pitch duration      // for a note
     *     pitch ::= accidental letter octave*
     *     accidental ::= empty string    // for natural,
     *                  | _               // for flat,
     *                  | ^               // for sharp
     *     letter ::= [A-G]
     *     octave ::= '                   // to raise one octave
     *              | ,                   // to lower one octave
     *     duration ::= empty string      // for 1-beat duration
     *                | /n                // for 1/n-beat duration
     *                | n                 // for n-beat duration
     *                | n/m               // for n/m-beat duration
     *
     * Examples (assuming 4/4 common time, i.e. 4 beats per measure):
     *     C     quarter note, middle C
     *     A'2   half note, high A
     *     _D/2  eighth note, middle D flat
     *
     * @param notes string of notes and rests in simplified abc notation given above
     */
    public static Music notes(String notes) {
        Music music = rest(0);
        for (String sym : notes.split("[\\s|]+")) {
            if (!sym.isEmpty()) {
                music = concat(music, parseSymbol(sym));
            }
        }
        return music;
    }

    private static Music parseSymbol(String symbol) {
        // 处理休止符 z
        if (symbol.startsWith("z")) {
            Matcher m = Pattern.compile("z([0-9]*)?(?:/([0-9]*))?").matcher(symbol);
            if (!m.matches()) {
                throw new IllegalArgumentException("couldn't understand rest " + symbol);
            }

            double duration = 1.0;
            String num = m.group(1);
            String denom = m.group(2);

            if (num != null && !num.isEmpty()) {
                duration *= Double.parseDouble(num);
            }

            if (denom != null && !denom.isEmpty()) {
                duration /= Double.parseDouble(denom);
            } else if (symbol.endsWith("/")) {
                duration *= 0.5;
            }

            return rest((int)duration);
        }

        // 处理音符
        Matcher m = Pattern.compile("([_^=]*[A-Ga-g][,']*)([0-9]*)?(?:/([0-9]*))?").matcher(symbol);
        if (!m.matches()) {
            throw new IllegalArgumentException("couldn't understand " + symbol);
        }

        String pitchSymbol = m.group(1);
        String numeratorStr = m.group(2);
        String denominatorStr = m.group(3);

        Pitch pitch = parsePitch(pitchSymbol);
        double duration = 1.0;

        if (numeratorStr != null && !numeratorStr.isEmpty()) {
            duration *= Double.parseDouble(numeratorStr);
        }

        if (denominatorStr != null && !denominatorStr.isEmpty()) {
            duration /= Double.parseDouble(denominatorStr);
        } else if (symbol.endsWith("/")) {
            duration *= 0.5;
        }

        return note((int)duration, pitch);
    }

    /* Parse a symbol into a Pitch. */
    private static Pitch parsePitch(String symbol) {
        if (symbol.endsWith("'")) return parsePitch(symbol.substring(0, symbol.length()-1)).transpose(OCTAVE);
        else if (symbol.endsWith(",")) return parsePitch(symbol.substring(0, symbol.length()-1)).transpose(-OCTAVE);
        else if (symbol.startsWith("^")) return parsePitch(symbol.substring(1)).transpose(1);
        else if (symbol.startsWith("_")) return parsePitch(symbol.substring(1)).transpose(-1);
        else if (symbol.length() != 1) throw new IllegalArgumentException("can't understand " + symbol);
        else return new Pitch(symbol.charAt(0));
    }

    /**
     * @param duration duration in beats, must be >= 0
     * @param pitch pitch to play

     * @return pitch played by instrument for duration beats
     */
    public static Music note(int duration, Pitch pitch) {
        return new Note(duration, pitch);
    }

    /**
     * @param duration duration in beats, must be >= 0
     * @return rest that lasts for duration beats
     */
    public static Music rest(int duration) {
        return new Rest(duration);
    }

    ////////////////////////////////////////////////////
    // Producers
    ////////////////////////////////////////////////////

    /**
     * @param m1 first piece of music
     * @param m2 second piece of music
     * @return m1 followed by m2
     */
    public static Music concat(Music m1, Music m2) {
        return new Concat(m1, m2);
    }
}
