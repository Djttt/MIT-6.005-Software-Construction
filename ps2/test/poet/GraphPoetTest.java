/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package poet;

import static org.junit.Assert.*;

import graph.Graph;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Tests for GraphPoet.
 */
public class GraphPoetTest {
    
    // Testing strategy
    //   TODO
    // for constructor method
    // use the some simple case to test
    // for example, corpus like This is a test of the Mugar Omni Theater sound system.
    // input: Test the system.
    // output: Test of the system.

    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    // TODO tests
    @Test
    public void testInitGraphPoet() throws IOException {
        File corpus = new File("./src/poet/mugar-omni-theater.txt");
        GraphPoet poet = new GraphPoet(corpus);
//        Set<String> expected = new HashSet<>(Arrays.asList("this", "is", "a", "test", "of", "the", "Mugar", "Omni", "Theater", "sound", "system."));

        assertEquals("expected", "Edge: {<this, is, 1>, <is, a, 1>, <a, test, 1>, <test, of, 1>, <of, the, 1>, " +
                "<the, mugar, 1>, <mugar, omni, 1>, <omni, theater, 1>, <theater, sound, 1>, <sound, system., 1>}, Vertices: {the, a, test, mugar, " +
                "theater, of, sound, this, is, omni, system.}", poet.toString());
    }

    @Test
    public void testPoemGenerator() throws IOException {
        File corpus = new File("./src/poet/mugar-omni-theater.txt");
        GraphPoet poet = new GraphPoet(corpus);

        String input = "Test the system.";
        assertEquals("expected", "Test of the system.", poet.poem(input));
    }
}
