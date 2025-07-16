package abc.sound;

/**
 * Music represents a piece of music played by multiple instruments.
 */
public interface Music {


    /**
     *
     * @return total duration of this piece of beats
     */
    int duration();


    /**
     * Play this piece.
     * @param player player to play on
     * @param atBeat when to play
     */
    void play(SequencePlayer player, int atBeat);

}
