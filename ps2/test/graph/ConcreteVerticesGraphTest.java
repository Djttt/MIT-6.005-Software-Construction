/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package graph;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Tests for ConcreteVerticesGraph.
 * 
 * This class runs the GraphInstanceTest tests against ConcreteVerticesGraph, as
 * well as tests for that particular implementation.
 * 
 * Tests against the Graph spec should be in GraphInstanceTest.
 */
public class ConcreteVerticesGraphTest extends GraphInstanceTest {
    
    /*
     * Provide a ConcreteVerticesGraph for tests in GraphInstanceTest.
     */
    @Override public Graph<String> emptyInstance() {
        return new ConcreteVerticesGraph<String>();
    }
    /*
     * Testing ConcreteVerticesGraph...
     */
    
    // Testing strategy for ConcreteVerticesGraph.toString()
    //   TODO
    
    // TODO tests for ConcreteVerticesGraph.toString()
    @Test
    public void testConcreteVerticesGraphToString() {
       ConcreteVerticesGraph<String> graph = new ConcreteVerticesGraph<String>();
       graph.set("MIT", "Berkeley", 22);
       graph.set("MIT", "Stanford", 29);
       graph.set("kk", "kkk22", 11);
       assertEquals("expected", "Edges: {<MIT, Stanford, 29>, <MIT, Berkeley, 22>, <kk, kkk22, 11>, }," +
               " Vertices: {MIT, Berkeley, Stanford, kk, kkk22}", graph.toString());
    }

    
    /*
     * Testing Vertex...
     */
    
    // Testing strategy for Vertex
    //   TODO
    // all of adjacent is equal = 0,
    // not equal = 0

    
    // TODO tests for operations of Vertex
    @Test
    public void testVertexGetSource() {
        Vertex<String> vertex = new Vertex<String>("MIT");
        assertEquals("expected", "MIT", vertex.getSource());
    }

    @Test
    public void testAddEdge() {
        Vertex<String> vertex = new Vertex<String>("MIT");
        vertex.addEdge("Harvard", 42);
        Map<String, Integer> expected = new HashMap<>();
        expected.put("Harvard", 42);
        assertEquals("expected", expected, vertex.getAdjacentVertices());

        vertex.addEdge("Stanford", 32);
        expected.put("Stanford", 32);
        assertEquals("expected", expected, vertex.getAdjacentVertices());
    }

    @Test
    public void testCheckEdgeExit() {
        Vertex<String> vertex = new Vertex<String>("MIT");
        vertex.addEdge("Harvard", 42);
        assertTrue("expected", vertex.checkEdgeExit("Harvard"));

        assertFalse("expected", vertex.checkEdgeExit("Princeton"));
    }

    @Test
    public void testGetTargetWeight() {
        Vertex<String> vertex = new Vertex<String>("MIT");
        vertex.addEdge("Harvard", 42);

        assertEquals("expected", 42, vertex.getTargetWeight("Harvard"));

        // The edge doesn't exit
        assertEquals("expected", -1, vertex.getTargetWeight("Kro"));
    }

    @Test
    public void testGetAdjacentVertices() {
        Vertex<String> vertex = new Vertex<String>("MIT");
        vertex.addEdge("Harvard", 42);
        vertex.addEdge("UC Berkeley", 22);
        vertex.addEdge("Princeton", 25);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("Harvard", 42);
        expected.put("UC Berkeley", 22);
        expected.put("Princeton", 25);

        assertEquals("expected", expected, vertex.getAdjacentVertices());
    }

    @Test
    public void testRemoveEdge() {
        Vertex<String> vertex = new Vertex<String>("MIT");
        vertex.addEdge("Harvard", 42);
        vertex.addEdge("UC Berkeley", 22);
        vertex.addEdge("Princeton", 25);

        assertTrue("expected",  vertex.removeEdge("Harvard"));
        assertTrue("expected", vertex.removeEdge("UC Berkeley"));

        // target vertex not exited
        assertFalse("expected", vertex.removeEdge("UC"));
    }

    @Test
    public void testToString() {
        Vertex<String> vertex = new Vertex<String>("MIT");
        vertex.addEdge("Harvard", 42);
        vertex.addEdge("UC Berkeley", 22);
        vertex.addEdge("Princeton", 25);

        assertEquals("expected", "<MIT, Harvard, 42>, <MIT, Princeton, 25>, <MIT, UC Berkeley, 22>", vertex.toString());
    }
}
