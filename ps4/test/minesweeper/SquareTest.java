package minesweeper;

import org.junit.Test;

import static org.junit.Assert.*;


public class SquareTest {

    // TODO: Test Strategy
    // Test Square's every method
    // Constructor function:
    // judge initial state == Board.untouched
    //
    // modify with flag
    // Partition input as followed.
    // currently square's state equals untouched and not.

    // modify with Dug.
    // Partition input as followed.
    // currently square's state equals untouched and not.

    // modify with deFlag
    // Partition input as followed.
    // currently square's state equals flagged and not.


    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }

    // TODO: Test

    @Test
    public void testInitSquare() {
        Square square = new Square(0, 3);
        String state = square.getState();

        assertEquals(Board.untouched, state);
    }

    @Test
    public void testSquareModifyFlagged() {
        Square square = new Square(0, 3);
        String state = square.getState();

        assertEquals("-", state);

        square.modify(Board.flagged);
        state = square.getState();

        assertEquals(Board.flagged, state);

    }

    @Test
    public void testSquareModifyDug() {
        Square square = new Square(0, 3);
        String state = square.getState();


        square.modify(Board.dug);
        state = square.getState();

        assertEquals(Board.dug, state);


        square.modify(Board.flagged);
        assertEquals(Board.dug, state);
    }

    @Test
    public void testSquareModifyDeFlag() {
        Square square = new Square(0, 3);
        String state = square.getState();

        assertEquals(Board.untouched, state);

        square.modify(Board.flagged);
        state = square.getState();

        assertEquals(Board.flagged, state);

        square.modify(Board.untouched);
        state = square.getState();

        assertEquals(Board.untouched, state);

        // currently state not equals flag

    }


    @Test
    public void testSquareHasBomb() {
        Square square = new Square(0, 3);

        assertFalse(square.hasBomb());
        // currently state not equals flag

    }
}

