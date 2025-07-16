package abc.sound;

import abc.parser.AbcLexer;
import abc.parser.AbcParser;
import org.antlr.v4.runtime.ANTLRInputStream;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.*;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * represent an abc file music, which can read data from abc file, and play the music.
 */
public class ABC {

    // translate abc file => string data type.
    public static String getMusicString(String fileName) throws IOException {

        String input = new String(Files.readAllBytes(Paths.get(fileName)));
        AbcLexer lexer = new AbcLexer(new ANTLRInputStream(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);


        AbcParser parser = new AbcParser(tokens);
        ParseTree tree = parser.abc_tune();
        System.out.println(tree.toStringTree(parser));

        ParseTreeWalker walker = new ParseTreeWalker();
        MyAbcListener listener = new MyAbcListener();
        walker.walk(listener, tree);

        System.out.println(String.join(" ", listener.getNotes()));
        return String.join(" ", listener.getNotes());
    }


    /**
     * play a piece of music.
     * @param musicString input abc file in string
     * @throws IOException if file don't exit
     * @throws MidiUnavailableException if midi not available.
     * @throws InvalidMidiDataException invalid midi data
     */
    public static void play(String musicString) throws IOException, MidiUnavailableException, InvalidMidiDataException {
        Music example = MusicLanguage.notes(musicString);
        MusicPlayer.play(example);
    }
}
