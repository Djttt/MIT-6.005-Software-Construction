/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package minesweeper;

import java.util.*;

/**
 * TODO: Specification
 * Represent Minesweeper game's board, a board consist of squares, each square has three state, untouched, flagged, dug.
 */
public class Board {

    private final Square[][] board;
    private final double generateBoomProb =  0.25;
    private final int xSize;
    private final int ySize;
    public static final String untouched = "-";
    public static final String flagged = "F";
    public static final String dug = " ";
    static final Random rand = new Random(42);
    private final String dugBombs = "";

    // TODO: Abstraction function, rep invariant, rep exposure, thread safety
    // rep invariant
    // each square has 0.25 probability generate a bomb. And all squares' states should be set to untouched,
    // each square have a bomb or not. mutable data type.

    // abstraction function
    // represent a minesweeper board, with x*y size.

    // rep exposure
    // all fields are private,
    // getSquare() method get a reference of square, but it's private, so avoid rep exposure.
    //
    // thread safety argument
    // all accesses to board within Board class,
    // which are all guarded by lock with keyword synchronized


    private void checkRep() {

    }

    // TODO: Specify, test, and implement in problem 2

    /**
     * Board instance should be randomly generated and should have size equal to X by Y. To randomly generate your board,
     * you should assign each square to contain a bomb with probability .25 and otherwise no bomb. All squares’ states should be set to untouched .
     * @param xSize initial the board with xSize, xSize > 0.
     * @param ySize initial the board with ySize, ySize > 0.
     */
    public Board(int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
        board = new Square[ySize][xSize];
        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                board[y][x] = new Square(y, x);
            }
        }
        // init neighbor squares bombs information.
        initNeighborBombs();
        checkRep();
    }

    /**
     * Implement init a board by input val array (this array created by io file)
     * @param xSize initial the board with xSize, xSize > 0.
     * @param ySize initial the board with ySize, ySize > 0.
     * @param val input array for construct board
     */
    public Board(int xSize, int ySize, int[][] val) {
        assert val.length == ySize;
        assert val[0].length == xSize;
        this.xSize = xSize;
        this.ySize = ySize;
        board = new Square[ySize][xSize];
        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                board[y][x] = new Square(y, x);
            }
        }
        for (int y = 0; y < ySize; y+=1) {
            for (int x = 0; x < xSize; x+=1) {
                if (val[y][x] == 0) {
                    board[y][x].setNoBomb();
                }
                else if (val[y][x] == 1) {
                    board[y][x].setBomb();
                }
            }
        }
        initNeighborBombs();
        checkRep();
    }

    /**
     * Just for test! Generate a board with
     *          + - +
     *          - - -
     *          + - +
     * and + represent a bomb, - represent no bomb.
     */
    public Board() {
        xSize = 3;
        ySize = 3;
        board = new Square[ySize][xSize];
        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                board[y][x] = new Square(y, x);
                board[y][x].setNoBomb();
            }
        }
        // init neighbor squares bombs information.
        initNeighborBombs();
        checkRep();
    }


    /**
     * count square(x, y) neighbor information about bombs and
     * init square's neighbor bombs information by setNeighborBombs method.
     */
    private void initNeighborBombs() {
        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                List<Square> neighbors = getNeighborSquares(x, y);
                int countBombs = neighborHasBomb(neighbors);
                Square square = getSquare(x, y);
                square.setNeighborBombs(countBombs);
            }
        }
        checkRep();
    }

    /**
     *
     * @return cols about this board
     */
    public int getxSize() {
        return xSize;
    }

    /**
     *
     * @return rows about this board.
     */
    public int getySize() {
        return ySize;
    }


    /**
     * Get location with (i, j) square's state in the board.
     * @param x the x index in board, x>=0 and x < board.xSize
     * @param y the y index in board, y>=0 and y < board.ySize
     * @return square's state with location (i, j).
     */
    public synchronized String getSquareState(int x, int y) {
        Square square = getSquare(x, y);
        checkRep();
        return square.getState();
    }


    /**
     * Get square with coordinate (y, x) in the board.
     * @param x square's x coordinate.
     * @param y square's y coordinate.
     * @return return a square of index of (x, y).
     */
    private synchronized Square getSquare(int x, int y) {
        return this.board[y][x];
    }

    /**
     * Get a list of square's (x, y) neighbor squares. if exited.
     * @param x current square's x coordinate.
     * @param y current square's y coordinate.
     * @return list of neighbor squares.
     */
    private List<Square> getNeighborSquares(int x, int y) {
        Set<Square> neighborSquares = new HashSet<>();
        if (x - 1 >= 0 ) {
            neighborSquares.add(getSquare(x - 1, y));
            if (y - 1 >= 0) {
                neighborSquares.add(getSquare(x - 1, y - 1));
                neighborSquares.add(getSquare(x, y - 1));
            }
            if (y + 1 < ySize) {
                neighborSquares.add(getSquare(x - 1, y + 1));
                neighborSquares.add(getSquare(x, y + 1));
            }
        }
        if (x + 1 < xSize) {
            neighborSquares.add(getSquare(x + 1, y));
            if (y - 1 >= 0) {
                neighborSquares.add(getSquare(x + 1, y - 1));
                neighborSquares.add(getSquare(x, y - 1));
            }
            if (y + 1 < ySize) {
                neighborSquares.add(getSquare(x + 1, y + 1));
                neighborSquares.add(getSquare(x, y + 1));
            }
        }
        return new ArrayList<>(neighborSquares);
    }

    /**
     * check out neighbor squares whether if has a bomb.
     * @param neighborSquare not null list contains squares data type.
     * @return if in the list of  neighborSquare has one exited a bomb, return bomb count.
     */
    private int neighborHasBomb(List<Square> neighborSquare) {
        int bombCount = 0;
        for (Square square : neighborSquare) {
            if (square.hasBomb()) {
                bombCount += 1;
            }
        }
        return bombCount;
    }

    /**
     * if the square (x, y) has no neighbor squares with bombs, then for each of x,y's untouched neighbor squares,
     * change square to dug state, repeat this step recursively for said neighbor square was already dug.
     * @param x square's x coordinate.
     * @param y square's y coordinate.
     */
    private void changeNeighborState(int x, int y) {
        List<Square> neighbors = getNeighborSquares(x, y);

        if (neighborHasBomb(neighbors) == 0) {
            // modify all neighbor squares state with dug. and recursive this process.
            for (Square square : neighbors) {
                if (square.getState().equals(Board.untouched) ||
                        square.getState().equals(Board.flagged)) {
                    square.modify(Board.dug);
                    changeNeighborState(square.getX(), square.getY());
                }
            }
        }
        checkRep();
    }

    /**
     *
     * If square x,y’s state is untouched , change square x,y’s state to dug.
     * If square x,y contains a bomb, change it so that it contains no bomb and send a BOOM message to the user.
     * Then, if the debug flag is missing terminate the user’s connection.
     * If the square x,y has no neighbor squares with bombs, then for each of x,y’s untouched neighbor squares,
     * change said square to dug and repeat this step recursively for said neighbor square unless said neighbor square was already dug before said change.
     * For any DIG message where a BOOM message is not returned, return a BOARD message.
     * @param x the x index in board, x>=0 and x < board.xSize
     * @param y the y index in board, y>=0 and y < board.ySize
     * @return if  dig the square boom return true, else return false.
     */
    public synchronized boolean dig(int x, int y) {
        Square square = board[y][x];
        String curState = square.getState();
        boolean boom = false;
        if (curState.equals(Board.untouched)) {
            square.modify(Board.dug);
            if (square.hasBomb()) {
                square.setNoBomb();
                boom = true;
            }
            changeNeighborState(x, y);
        }
        return boom;
    }


    /**
     * If x and y are both greater than or equal to 0, and less than the board size,
     * and square x,y is in the untouched state, change it to be in the flagged state.
     * Otherwise, do not mutate any state on the server.
     * @param x the x index in board, x>=0 and x < board.xSize
     * @param y the y index in board, y>=0 and y < board.ySize
     * @return if set the square successful, return true, else return false.
     */
    public synchronized boolean flag(int x, int y) {
        Square square = getSquare(x, y);
        if (square.getState().equals(Board.untouched)) {
            square.modify(Board.flagged);
            return true;
        }
        return false;
    }

    /**
     * If x and y are both greater than or equal to 0, and less than the board size,
     * and square x,y is in the flagged state, change it to be in the untouched state.
     * Otherwise, do not mutate any state on the server.
     * @param x the x index in board, x>=0 and x < board.xSize
     * @param y the y index in board, y>=0 and y < board.ySize
     * @return if set the square successful, return true, else return false.
     */
    public synchronized boolean deFlag(int x, int y) {
        Square square = getSquare(x, y);
        if (square.getState().equals(Board.flagged)) {
            square.modify(Board.untouched);
            return true;
        }
        return false;
    }


    @Override
    public synchronized String toString() {
        String boardMessage = "";
        for (int y = 0; y < ySize; y += 1) {
            for (int x = 0; x < xSize; x += 1) {
                if (board[y][x].getState().equals(Board.dug)) {
                    List<Square> squareList = getNeighborSquares(x, y);
                    int countBombs = neighborHasBomb(squareList);
                    if (countBombs == 0) {
                        if (x == 0) {
                            boardMessage += " ";
                        }
                        else {
                            boardMessage += "  ";
                        }
                    }
                    else {
                        if (x == 0) {
                            boardMessage += String.valueOf(countBombs);
                        }
                        else {
                            boardMessage += " " + String.valueOf(countBombs);
                        }
                    }
                }
                else {
                    if (x == 0) {
                        boardMessage += board[y][x].getState();
                    }
                    else {
                        boardMessage += " " + board[y][x].getState();
                    }
                }
            }
            boardMessage += "\n";
        }
        return boardMessage;
    }
}

/**
 * square data type in a board.
 */
class Square {
    private final int x, y;
    private String state;
    private boolean bomb;
    private int neighborBombs;
    // rep invariant
    // x, y >=0, and x < board.x, y < board.y, state be initialized with untouched.
    // state = '-' or 'F', ' ', '[0-9]', mutable data type, state will change.
    // abstraction function
    // represent a square in a board

    // safety from rep exposure
    // all fields are private
    //
    // thread safety argument
    //      This class if not threadsafe because it's mutable:
    //      - x, y is final
    //      - state, bomb will change, so it's not immutable.
    // if many threads concurrency access same Square object, and change state and bomb variable,
    // which is not thread safe.

    private void checkRep() {
        assert state.equals(Board.untouched) || state.equals(Board.flagged)  || state.equals(Board.dug);
        assert x >= 0;
        assert y >= 0;
    }
    /**
     * @param x x coordinate in grid of board
     * @param y y coordinate in grid of board
     */
    Square(int y, int x) {
        this.state =  Board.untouched;
        this.y = y;
        this.x = x;
        double prob = Board.rand.nextDouble();
        if (prob <= 0.25) {
            this.bomb = true;
        }
        else {
            this.bomb = false;
        }
        checkRep();
    }

    /**
     * Set this square has not a bomb.
     */
    void setNoBomb() {
        if (bomb) {
            bomb = false;
        }
    }

    /**
     * set this square have one bomb.
     */
    void setBomb() {
       if (!bomb) {
           bomb = true;
       }
    }

    /**
     * set this square's neighbor bombs number.
     * @param neighborBombs count of neighbor bombs.
     */
     void setNeighborBombs(int neighborBombs) {
        this.neighborBombs = neighborBombs;
    }

    /**
     * @return Get this square's x coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * @return Get this square's y coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @return if this square has a bomb, return true, else return false.
     */
    public boolean hasBomb() {
        if (bomb) {
            return true;
        }
        return false;
    }

    /**
     * Modify this square with new state
     * @param newState square's new state.
     */
    public void modify(String newState) {
        this.state = newState;
        checkRep();
    }

    /**
     * Get this square's current state
     * @return state of the square
     */
    public String getState() {
        return this.state;
    }
}
