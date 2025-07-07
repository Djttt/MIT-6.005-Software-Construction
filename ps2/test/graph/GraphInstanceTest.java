/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package graph;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

/**
 * Tests for instance methods of Graph.
 * 
 * <p>PS2 instructions: you MUST NOT add constructors, fields, or non-@Test
 * methods to this class, or change the spec of {@link #emptyInstance()}.
 * Your tests MUST only obtain Graph instances by calling emptyInstance().
 * Your tests MUST NOT refer to specific concrete implementations.
 */
public abstract class GraphInstanceTest {
    
    // Testing strategy
    //   TODO
    //
    // Test the graph instance method.
    //
    // add method:
    // partition the inputs
    // if the vertex already exited and not exited.
    //
    // set method:
    // Partition the precondition as followed:
    // the weight is zero, remove the edge if exited.
    // weight is nonzero, and the source and target vertex exit, update the weight.
    // weight is nonzero, and the source and target may be not exit, add the vertex into the graph and update the weight edge.
    //
    // remove method:
    // Partition the inputs as followed:
    // the graph doesn't include the vertex return false;
    // graph include the vertex, remove any edges to or from the vertex are also removed.
    //
    // vertices method:
    // Partition the inputs:
    // graph is empty, return empty set
    // graph is not empty.
    //
    // sources method:
    // Partition the inputs:
    // the graph's source vertices is empty
    // graph's source vertices is not empty
    //
    // targets method:
    // Partition the inputs
    // graph's targets vertices is empty
    // graph's targets vertices is not empty



    /**
     * Overridden by implementation-specific test classes.
     * 
     * @return a new empty graph of the particular implementation being tested
     */
    public abstract Graph<String> emptyInstance();
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    @Test
    public void testInitialVerticesEmpty() {
        // TODO you may use, change, or remove this test
        assertEquals("expected new graph to have no vertices",
                Collections.emptySet(), emptyInstance().vertices());
    }
    
    // TODO other tests for instance methods of Graph
    // Cover add method if the vertex label already exited.
    @Test
    public void testGrapyAddVertexExited() {
        Graph<String> graph = emptyInstance();
        graph.add("Andrew");
        assertFalse("expected false", graph.add("Andrew"));
    }

    // Cover add method if the vertex label doesn't exit.
    @Test
    public void testGrapyAddVertexNotExited() {
        Graph<String> graph = emptyInstance();
        assertTrue("expected true", graph.add("Andrew"));
        Set<String> expected = new HashSet<>();
        expected.add("Andrew");
        assertEquals("expected get a set contains Andrew", expected, graph.vertices());
    }

    // Cover weight = 0, then remove the edge if exited.
    @Test
    public void testGraphSetWeightZero() {
        Graph<String> graph = emptyInstance();
        graph.set("andrew", "john", 33);
        // Edge already exit, so remove the edge.
        graph.set("andrew", "john", 0);
        Map<String, Integer> sources = graph.sources("john");

        assertEquals("expected returned map size equals 0",
                0, sources.size());

        Map<String, Integer> targets = graph.targets("andrew");
        assertEquals("expected returned map size equals 0",
                0, targets.size());

    }

    @Test
    public void testSetWeightNonZeroVertexAlreadyExit() {
        Graph<String> graph = emptyInstance();
        graph.set("andrew", "john", 33);
        graph.set("andrew", "joash", 44);
        Map<String, Integer> sources = graph.sources("john");
        Map<String, Integer> expected = new HashMap<>();
        expected.put("andrew", 33);
        assertEquals("expected", expected, sources);

        Map<String, Integer> targets = graph.targets("andrew");
        expected = new HashMap<>();
        expected.put("john", 33);
        expected.put("joash", 44);
        assertEquals("expected", expected, targets);
    }

    // Cover weight is nonzero, and the source and target vertex exit, update the weight.
    @Test
    public void testSetWeightWithEdgeExited() {
        Graph<String> graph = emptyInstance();
        graph.set("andrew", "john", 33);
        graph.set("andrew", "john", 44);
        Map<String, Integer> sources = graph.sources("john");
        Map<String, Integer> expected = new HashMap<>();
        expected.put("andrew", 44);
        assertEquals("expected", expected, sources);
    }

    // Cover the graph doesn't include the vertex return false;
    @Test
    public void testRemoveVertexWithNotExit() {
        Graph<String> graph = emptyInstance();
        assertFalse("expected", graph.remove("cat"));
        graph.add("dog");
        assertFalse("expected", graph.remove("cat"));
    }

    // Cover graph include the vertex, remove any edges to or from the vertex are also removed.
    @Test
    public void testRemoveVertexWithExit() {
        Graph<String> graph = emptyInstance();
        graph.add("cat");
        assertTrue("expected", graph.remove("cat"));

        graph.set("cat", "dog", 33);
        graph.set("cat", "mewo", 44);
        assertTrue("expected", graph.remove("cat"));

        Map<String, Integer> sources = graph.sources("dog");
        assertEquals("expected",0 ,sources.size());
    }

    // Cover graph is empty, return empty set
    @Test
    public void testVerticesWithEmptyGraph() {
        Graph<String> graph = emptyInstance();
        Set<String> vertices = graph.vertices();
        assertEquals("expect set size equal 0", 0, vertices.size());
    }

    // Cover graph is not empty.
    @Test
    public void testVerticesWithGraph() {
        Graph<String> graph = emptyInstance();

        graph.set("cat", "dog", 33);
        graph.set("cat", "mewo", 44);
        graph.set("mewo", "bob", 44);
        Set<String> vertices = graph.vertices();
        Set<String> expected = new HashSet<>();
        expected.add("cat");
        expected.add("dog");
        expected.add("mewo");
        expected.add("bob");
        assertTrue("expected", expected.containsAll(vertices));
    }

    // Cover the graph's source vertices is empty
    @Test
    public void testSourcesWithEmpty() {
        Graph<String> graph = emptyInstance();
        graph.add("cat");
        Map<String, Integer> sources = graph.sources("cat");
        assertEquals("expected",0 ,sources.size());
    }

    // Cover graph's source vertices is not empty
    @Test
    public void testSourcesWithNotEmpty() {
        Graph<String> graph = emptyInstance();
        graph.set("cat", "dog", 33);
        graph.set("cat", "mewo", 44);
        graph.set("bird", "mewo", 4);
        graph.set("lion", "mewo", 45);
        graph.set("mewo", "bob", 44);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("cat", 44);
        expected.put("bird", 4);
        expected.put("lion", 45);


        Map<String, Integer> sources = graph.sources("mewo");
        assertEquals("expected", expected, sources);
    }

    // Cover the graph's target vertices is empty
    @Test
    public void testTargetsWithEmpty() {
        Graph<String> graph = emptyInstance();
        graph.add("cat");
        Map<String, Integer> targets = graph.targets("cat");
        assertEquals("expected",0 ,targets.size());
    }

    // Cover graph's target vertices is not empty
    @Test
    public void testTargetsWithNotEmpty() {
        Graph<String> graph = emptyInstance();
        graph.set("cat", "dog", 33);
        graph.set("cat", "mewo", 44);
        graph.set("bird", "mewo", 4);
        graph.set("lion", "mewo", 45);
        graph.set("mewo", "bob", 44);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("dog", 33);
        expected.put("mewo", 44);

        Map<String, Integer> targets = graph.targets("cat");
        assertEquals("expected", expected, targets);

        // only one target connected with source vertex.
        targets = graph.targets("mewo");
        expected.clear();
        expected.put("bob", 44);
        assertEquals("expected", expected, targets);
    }

}
