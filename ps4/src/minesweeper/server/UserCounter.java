package minesweeper.server;


/**
 * Counter how many users connected to MinesweeperServer
 */
public class UserCounter {
    private int numberofUser;
    // rep invariant
    // numberofUser should >= 0

    // abstraction function
    // represent now have how many users connect to the server.

    // rep exposure
    // all fields are private.

    // thread safe argument
    // use synchronized key word init method, keep sure
    // this object instance only have one thread access it at same time.

    private void checkRep() {
        assert numberofUser >= 0;
    }

    /**
     * construct an instance with value = 0.
     */
    public UserCounter() {
        numberofUser = 0;
        checkRep();
    }

    /**
     * increment user numbers plus 1.
     */
    public synchronized void increment() {
        numberofUser += 1;
        checkRep();
    }

    /**
     * decrement user numbers minus 1.
     */
    public synchronized void decrement() {
        numberofUser -= 1;
        checkRep();
    }

    /**
     * @return Get this time, users connected numbers.
     */
    public synchronized int getCount() {
        return numberofUser;
    }


}
