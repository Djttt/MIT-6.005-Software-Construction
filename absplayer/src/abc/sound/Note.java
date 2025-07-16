package abc.sound;

/**
 * Note represents a note played by an instrument.
 */
public class Note implements Music{

    private final int duration;
    private final Pitch pitch;

    // rep invariant
    // duration >= 0, pitch is non-null, instrument is not null

    // abstraction function
    // represent a note played by an instrument.

    // rep exposure
    // all fields are private

    private void checkRep() {
        assert this.duration >= 0;
        assert this.pitch != null;
    }


    /**
     * Make a Note played by instrument for duration beats.
     * @param duration duration in beats, must be >= 0.
     * @param pitch pitch to play.
     */
    public Note(int duration, Pitch pitch) {
        this.duration = duration;
        this.pitch = pitch;
        checkRep();
    }

    /**
     * @return pitch of this note
     */
    public Pitch pitch() {
        return pitch;
    }

    /**
     * @return duration of this note
     */
    public int duration() {
        return duration;
    }

    /**
     * Play this note.
     */
    public void play(SequencePlayer player, int atBeat) {
        player.addNote(pitch.toMidiNote(), atBeat, duration);
    }

    @Override
    public int hashCode() {
        long durationBits = Double.doubleToLongBits(duration);
        return (int) (durationBits ^ (durationBits >>> 32))
                + pitch.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        final Note other = (Note) obj;
        return duration == other.duration
                && pitch.equals(other.pitch);
    }

    @Override
    public String toString() {
        return pitch.toString() + duration;
    }



}
