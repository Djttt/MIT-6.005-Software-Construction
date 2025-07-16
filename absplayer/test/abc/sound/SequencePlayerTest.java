package abc.sound;

import static org.junit.Assert.*;

import org.junit.Test;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import abc.sound.MusicLanguage;

import java.io.IOException;

public class SequencePlayerTest {

    // TODO: warmup #2
    
    @Test
    public void test() throws MidiUnavailableException, InvalidMidiDataException, IOException {
        String music = ABC.getMusicString("test.abc");
        Music example = MusicLanguage.notes(music);
        System.out.println(example);

        MusicPlayer.play(example);
    }

}
