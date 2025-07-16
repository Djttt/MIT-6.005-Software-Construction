package abc.player;

import abc.sound.ABC;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import java.io.IOException;

/**
 * Main entry point of your application.
 */
public class Main {

    /**
     * Plays the input file using Java MIDI API and displays
     * header information to the standard output stream.
     * 
     * (Your code should not exit the application abnormally using
     * System.exit().)
     * 
     * @param file the name of input abc file
     */
    public static void play(String file) throws IOException, MidiUnavailableException, InvalidMidiDataException {
        // YOUR CODE HERE
        String musicString = ABC.getMusicString(file);
        ABC.play(musicString);
    }

    public static void main(String[] args) throws MidiUnavailableException, InvalidMidiDataException, IOException {
        // CALL play() HERE USING ARGS
        if (args.length != 1) {
            System.out.println("please support one argument for the abc's file name");
        }
        play(args[0]);
    }
}
