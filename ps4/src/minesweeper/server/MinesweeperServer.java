/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package minesweeper.server;

import java.io.*;
import java.net.*;
import java.util.*;

import minesweeper.Board;

/**
 * Multiplayer Minesweeper server.
 */
public class MinesweeperServer {

    // System thread safety argument
    //   TODO Problem 5
    // Board object is thread safe, and initialized with lock to guarded only one thread
    // can access the instance at same time.

    /** Default server port. */
    private static final int DEFAULT_PORT = 4444;
    /** Maximum port number as defined by ServerSocket. */
    private static final int MAXIMUM_PORT = 65535;
    /** Default square board size. */
    private static final int DEFAULT_SIZE = 10;

    /** Socket for receiving incoming connections. */
    private final ServerSocket serverSocket;
    /** True if the server should *not* disconnect a client after a BOOM message. */
    private final boolean debug;

    private static Board board;
    private int numberofUser;

    // TODO: Abstraction function, rep invariant, rep exposure
    // rep invariant
    // init port must be range within (0, 65535).


    // abstraction function
    // represent a MinesweeperServer, which can connect to serval client and share information to play within it.

    // rep exposure
    // all fields are private


    /**
     * Make a MinesweeperServer that listens for connections on port.
     * 
     * @param port port number, requires 0 <= port <= 65535
     * @param debug debug mode flag
     * @throws IOException if an error occurs opening the server socket
     */
    public MinesweeperServer(int port, boolean debug) throws IOException {
        serverSocket = new ServerSocket(port);
        this.debug = debug;
    }

    /**
     * Run the server, listening for client connections and handling them.
     * Never returns unless an exception is thrown.
     * 
     * @throws IOException if the main server socket is broken
     *                     (IOExceptions from individual clients do *not* terminate serve())
     */
    public void serve() throws IOException {
        while (true) {
            // block until a client connects
            Socket clientSocket = serverSocket.accept();

            // handle the client
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        handleConnection(clientSocket);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();
        }
    }

    /**
     * Handle a single client connection. Returns when client disconnects.
     * 
     * @param socket socket where the client is connected
     * @throws IOException if the connection encounters an error or terminates unexpectedly
     */
    private void handleConnection(Socket socket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        try {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                String output = handleRequest(line);
                if ("__bye__".equals(output)) {
                    break;
                }
                if (output != null) {
                    // TODO: Consider improving spec of handleRequest to avoid use of null
                    out.println(output);
                }
            }
        } finally {
            out.close();
            in.close();
        }
    }


    /**
     * @return help message, which return to user.
     * the exact content of this message should indicate all the commands the user can send to the server.
     */
    private String getHelpMessage() {
        return "RTFM!\n";
    }

    /**
     * @return boom message, which return to user.
     * once this message pass to client, then the connection will disconnect.
     */
    private String getBoomMessage() {
        return "BOOM!\r\n";
    }

    /**
     * @return return Board message to user
     */
    private String getBoardMessage() {
        return board.toString();
    }

    /**
     * @return hello message, which to return to user.
     */
    private String getHelloMessage() {
        return "Welcome to Minesweeper. Board: " + board.getxSize() + " " + "columns " +
        "by " + board.getySize() + " " + "rows.\n" + "Players: " + numberofUser + " " +
                "including you. Type 'help' for help.\r\n";
    }

    /**
     * Handler for client input, performing requested operations and returning an output message.
     * 
     * @param input message from client
     * @return message to client, or null if none
     */
    private String handleRequest(String input) {
        String regex = "(look)|(help)|(bye)|"
                     + "(dig -?\\d+ -?\\d+)|(flag -?\\d+ -?\\d+)|(deflag -?\\d+ -?\\d+)";
        if ( ! input.matches(regex)) {
            // invalid input
            // TODO Problem 5

        }
        String[] tokens = input.split(" ");
        if (tokens[0].equals("look")) {
            // 'look' request
            return getBoardMessage();
            // TODO Problem 5
        } else if (tokens[0].equals("help")) {
            // 'help' request
            // TODO Problem 5
            return getHelpMessage();
        } else if (tokens[0].equals("bye")) {
            // 'bye' request
            // TODO Problem 5
            return "__bye__";
        } else {
            int x = Integer.parseInt(tokens[1]);
            int y = Integer.parseInt(tokens[2]);
            if (tokens[0].equals("dig")) {
                // 'dig x y' request
                // TODO Problem 5
                if (x < 0 || y < 0 || x >= board.getxSize() || y >= board.getySize()) {
                    return getBoardMessage();
                }
                else {
                    if (!board.getSquareState(x, y).equals(Board.untouched)) {
                        return getBoardMessage();
                    }
                    boolean boom = board.dig(x, y);
                    if (boom) {
                        return getBoomMessage();
                    }
                    return getBoardMessage();
                    // TODO
                }
            } else if (tokens[0].equals("flag")) {
                // 'flag x y' request
                // TODO Problem 5
                if (x >= 0 && y >= 0 && x < board.getxSize() && y < board.getySize()) {
                    board.flag(x, y);
                }
                return getBoardMessage();
            } else if (tokens[0].equals("deflag")) {
                // 'deflag x y' request
                // TODO Problem 5
                if (x >= 0 && y >= 0 && x < board.getxSize() && y < board.getySize()) {
                    board.deFlag(x, y);
                }
                return getBoardMessage();
            }
        }
        // TODO: Should never get here, make sure to return in each of the cases above
        throw new UnsupportedOperationException();
    }

    /**
     * Start a MinesweeperServer using the given arguments.
     * 
     * <br> Usage:
     *      MinesweeperServer [--debug | --no-debug] [--port PORT] [--size SIZE_X,SIZE_Y | --file FILE]
     * 
     * <br> The --debug argument means the server should run in debug mode. The server should disconnect a
     *      client after a BOOM message if and only if the --debug flag was NOT given.
     *      Using --no-debug is the same as using no flag at all.
     * <br> E.g. "MinesweeperServer --debug" starts the server in debug mode.
     * 
     * <br> PORT is an optional integer in the range 0 to 65535 inclusive, specifying the port the server
     *      should be listening on for incoming connections.
     * <br> E.g. "MinesweeperServer --port 1234" starts the server listening on port 1234.
     * 
     * <br> SIZE_X and SIZE_Y are optional positive integer arguments, specifying that a random board of size
     *      SIZE_X*SIZE_Y should be generated.
     * <br> E.g. "MinesweeperServer --size 42,58" starts the server initialized with a random board of size
     *      42*58.
     * 
     * <br> FILE is an optional argument specifying a file pathname where a board has been stored. If this
     *      argument is given, the stored board should be loaded as the starting board.
     * <br> E.g. "MinesweeperServer --file boardfile.txt" starts the server initialized with the board stored
     *      in boardfile.txt.
     * 
     * <br> The board file format, for use with the "--file" option, is specified by the following grammar:
     * <pre>
     *   FILE ::= BOARD LINE+
     *   BOARD ::= X SPACE Y NEWLINE
     *   LINE ::= (VAL SPACE)* VAL NEWLINE
     *   VAL ::= 0 | 1
     *   X ::= INT
     *   Y ::= INT
     *   SPACE ::= " "
     *   NEWLINE ::= "\n" | "\r" "\n"?
     *   INT ::= [0-9]+
     * </pre>
     * 
     * <br> If neither --file nor --size is given, generate a random board of size 10x10.
     * 
     * <br> Note that --file and --size may not be specified simultaneously.
     * 
     * @param args arguments as described
     */
    public static void main(String[] args) {
        // Command-line argument parsing is provided. Do not change this method.
        boolean debug = false;
        int port = DEFAULT_PORT;
        int sizeX = DEFAULT_SIZE;
        int sizeY = DEFAULT_SIZE;
        Optional<File> file = Optional.empty();

        Queue<String> arguments = new LinkedList<String>(Arrays.asList(args));
        try {
            while ( ! arguments.isEmpty()) {
                String flag = arguments.remove();
                try {
                    if (flag.equals("--debug")) {
                        debug = true;
                    } else if (flag.equals("--no-debug")) {
                        debug = false;
                    } else if (flag.equals("--port")) {
                        port = Integer.parseInt(arguments.remove());
                        if (port < 0 || port > MAXIMUM_PORT) {
                            throw new IllegalArgumentException("port " + port + " out of range");
                        }
                    } else if (flag.equals("--size")) {
                        String[] sizes = arguments.remove().split(",");
                        sizeX = Integer.parseInt(sizes[0]);
                        sizeY = Integer.parseInt(sizes[1]);
                        file = Optional.empty();
                    } else if (flag.equals("--file")) {
                        sizeX = -1;
                        sizeY = -1;
                        file = Optional.of(new File(arguments.remove()));
                        if ( ! file.get().isFile()) {
                            throw new IllegalArgumentException("file not found: \"" + file.get() + "\"");
                        }
                    } else {
                        throw new IllegalArgumentException("unknown option: \"" + flag + "\"");
                    }
                } catch (NoSuchElementException nsee) {
                    throw new IllegalArgumentException("missing argument for " + flag);
                } catch (NumberFormatException nfe) {
                    throw new IllegalArgumentException("unable to parse number for " + flag);
                }
            }
        } catch (IllegalArgumentException iae) {
            System.err.println(iae.getMessage());
            System.err.println("usage: MinesweeperServer [--debug | --no-debug] [--port PORT] [--size SIZE_X,SIZE_Y | --file FILE]");
            return;
        }

        try {
            runMinesweeperServer(debug, file, sizeX, sizeY, port);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    /**
     * Start a MinesweeperServer running on the specified port, with either a random new board or a
     * board loaded from a file.
     * 
     * @param debug The server will disconnect a client after a BOOM message if and only if debug is false.
     * @param file If file.isPresent(), start with a board loaded from the specified file,
     *             according to the input file format defined in the documentation for main(..).
     * @param sizeX If (!file.isPresent()), start with a random board with width sizeX
     *              (and require sizeX > 0).
     * @param sizeY If (!file.isPresent()), start with a random board with height sizeY
     *              (and require sizeY > 0).
     * @param port The network port on which the server should listen, requires 0 <= port <= 65535.
     * @throws IOException if a network error occurs
     */
    public static void runMinesweeperServer(boolean debug, Optional<File> file, int sizeX, int sizeY, int port) throws IOException {
        
        // TODO: Continue implementation here in problem 4
        // init a board by reading from a file
        if (file.isPresent()) {
            BufferedReader buffer = new BufferedReader(new FileReader(String.valueOf(file)));
            board = createBoardFromFile(buffer);
        }
        else {
            board = new Board(sizeX, sizeY);
        }

        MinesweeperServer server = new MinesweeperServer(port, debug);
        server.serve();
    }

    /**
     * create init board from input file, which include all information about this board
     * @param buffer BufferReader type, buffer is not null.
     * @return  a board created by buffer's information
     * @throws IOException when the buffer is wrong throw a IO exception.
     */
    private static Board createBoardFromFile(BufferedReader buffer) throws IOException{
        String line;
        int col = -1;
        int row = -1;
        int[][] inputVal = null;
        int firstLineIdx = 0;
        int i = 0;  // represent input val row index.
        int j = 0;  // represent input val col index.
        while ((line = buffer.readLine()) != null) {
            String[] splitLine = line.split(" ");
            if (firstLineIdx == 0) {
                try {
                    col = Integer.parseInt(splitLine[0]);
                    row = Integer.parseInt(splitLine[1]);
                    inputVal = new int[row][col];
                } catch (NumberFormatException e) {
                    throw new RuntimeException("input col and row to set the board formatted wrong!");
                }
            }
            else {
                for (String num : splitLine) {
                    try {
                        int val = Integer.parseInt(num);
                        if (val == 0) {
                            inputVal[i][j] = 0;
                        }
                        else if (val == 1) {
                            inputVal[i][j] = 1;
                        }
                        else {
                            throw new RuntimeException("input val to represent this square whether have a bomb.");
                        }
                        j += 1;
                    } catch (NumberFormatException e) {
                        throw new RuntimeException("input val to represent this square whether have a bomb.");
                    }
                }
                i += 1;
                j = 0;
            }
            firstLineIdx += 1;
        }
        if (col != -1) {
            board = new Board(col, row, inputVal);
        }
        return board;
    }

}
