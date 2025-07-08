/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package graph;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

/**
 * Tests for static methods of Graph.
 * 
 * To facilitate testing multiple implementations of Graph, instance methods are
 * tested in GraphInstanceTest.
 */
public class GraphStaticTest {
    
    // Testing strategy
    //   empty()
    //     no inputs, only output is empty graph
    //     observe with vertices()
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    @Test
    public void testEmptyVerticesEmpty() {
        assertEquals("expected empty() graph to have no vertices",
                Collections.emptySet(), Graph.empty().vertices());
    }
    
    // TODO test other vertex label types in Problem 3.2
    // Test Graph with immutable type Integer.
    @Test
    public void testGraphWithIntegerLabel() {
        Graph<Integer> graph = Graph.empty();
        graph.add(22);
        graph.add(33);
        graph.set(22, 33, 12);
        graph.set(33, 34, 22);
        Set<Integer> expected = new HashSet<>();
        expected.add(22);
        expected.add(33);
        expected.add(34);

        assertEquals("expected", expected, graph.vertices());
    }

    // Test Graph with char type
    @Test
    public void testGraphWithCharLabel() {
        Graph<Character> graph = Graph.empty();
        graph.add('c');
        graph.set('c', 'd', 22);

        assertEquals("expected", "Edge: {<c, d, 22>}, Vertices: {c, d}", graph.toString());
    }

}
