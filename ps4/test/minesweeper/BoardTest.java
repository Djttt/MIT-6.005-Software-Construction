/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package minesweeper;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * TODO: Description
 * Test Board all kinds of methods
 */
public class BoardTest {
    
    // TODO: Testing strategy
    // dig method:
    // test recursive dig and do not recursive dig

    // flag method:
    // test two condition
    // if one square already dig and not.

    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    // TODO: Tests
    @Test
    public void testBoardDug() {
        // x = 2, y = 3, this square hase a bomb.
        Board gameBoard = new Board();
        gameBoard.dig(2, 1);

        String state = gameBoard.getSquareState(2, 2);
        assertEquals(Board.dug, state);

    }

    @Test
    public void testBoardFlag() {
        // x = 2, y = 3, this square hase a bomb.
        Board gameBoard = new Board(4, 4);
        gameBoard.flag(2, 2);

        String state = gameBoard.getSquareState(2, 2);
        assertEquals(Board.flagged, state);

        // first dig square, then flag it. Expected do nothing
        gameBoard.dig(2, 1);
        gameBoard.flag(2, 1);
        assertEquals(Board.dug, gameBoard.getSquareState(2, 1));

    }

    @Test
    public void testBoardDeFlag() {
        Board gameBoard = new Board(4, 4);
        gameBoard.flag(2, 2);

        String state = gameBoard.getSquareState(2, 2);
        assertEquals(Board.flagged, state);

        gameBoard.deFlag(2, 2);
        state = gameBoard.getSquareState(2, 2);

        assertEquals(Board.untouched, state);


        // current square's state is untouched, so do nothing.
        gameBoard.deFlag(2, 2);
        state = gameBoard.getSquareState(3, 3);
        assertEquals(Board.untouched, state);
    }

    @Test
    public void testGetSquareState() {
        // x = 2, y = 3, this square hase a bomb.
        Board gameBoard = new Board(4, 4);
        assertEquals(Board.untouched, gameBoard.getSquareState(2, 2));

        assertEquals(Board.untouched, gameBoard.getSquareState(2, 1));
    }

    @Test
    public void testToString() {
        Board gameBoard = new Board(4, 4);
        System.out.println(gameBoard.toString());


        gameBoard.flag(0, 0);
        System.out.println(gameBoard.toString());

        gameBoard.dig(1, 1);
        System.out.println(gameBoard.toString());


    }

}
