package abc.sound;


import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

/**
 * MusicPlayer can play a Music expression on the MIDI synthesizer.
 */
public class MusicPlayer {

    /**
     * Play music.
     * @param music music to play
     */
    public static void play(Music music) throws MidiUnavailableException, InvalidMidiDataException {
        final SequencePlayer player = new SequencePlayer(120, 2);

        // load the player with a sequence created from music (add a small delay at the beginning)
        final int warmup = 1;
        music.play(player, warmup);

        // start playing
        player.play();
    }
}
