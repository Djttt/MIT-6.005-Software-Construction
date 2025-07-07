/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package graph;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Tests for ConcreteEdgesGraph.
 * 
 * This class runs the GraphInstanceTest tests against ConcreteEdgesGraph, as
 * well as tests for that particular implementation.
 * 
 * Tests against the Graph spec should be in GraphInstanceTest.
 */
public class ConcreteEdgesGraphTest extends GraphInstanceTest {
    
    /*
     * Provide a ConcreteEdgesGraph for tests in GraphInstanceTest.
     */
    @Override public Graph<String> emptyInstance() {
        return new ConcreteEdgesGraph();
    }
    
    /*
     * Testing ConcreteEdgesGraph...
     */
    
    // Testing strategy for ConcreteEdgesGraph.toString()
    //   TODO
    // Partition the input as followed:
    // graph with no edge:
    //      have vertices
    //      no vertex
    // graph with edges
    // TODO tests for ConcreteEdgesGraph.toString()
    @Test
    public void testConcreteEdgesGraphToStringEmptyGraph() {
        ConcreteEdgesGraph graph = new ConcreteEdgesGraph();
        assertEquals("expected", "Edge: {}, Vertices: {}", graph.toString());
    }

    @Test
    public void testConcreteEdgesGraphToStringEmptyEdgeGraph() {
        ConcreteEdgesGraph graph = new ConcreteEdgesGraph();
        graph.add("MIT");
        graph.add("Stanford");
        assertEquals("expected", "Edge: {}, Vertices: {Stanford, MIT}", graph.toString());
    }

    @Test
    public void testConcreteEdgesGraphToStringEdgesGraph() {
        Edge edge1 = new Edge("MIT", "Stanford", 23);
        Edge edge2 = new Edge("MIT", "Harvard", 12);
        List<Edge> edges = new ArrayList<>();
        edges.add(edge1);


        ConcreteEdgesGraph graph = new ConcreteEdgesGraph(edges);
        assertEquals("expected", "Edge: {<MIT, Stanford, 23>}, Vertices: {Stanford, MIT}", graph.toString());

        edges.add(edge2);
        ConcreteEdgesGraph graph2 = new ConcreteEdgesGraph(edges);
        assertEquals("expected", "Edge: {<MIT, Stanford, 23>, <MIT, Harvard, 12>}, Vertices: {Stanford, Harvard, MIT}", graph2.toString());
    }
    
    /*
     * Testing Edge...
     */
    
    // Testing strategy for Edge
    //   TODO
    // test all method of Edge
    // getSource method
    // init a Edge and test it
    //
    // getTarget method:
    // init a Edge and test it
    //
    // getWeight method:
    // init a Edge and test it
    //
    // toString method:
    // init a Edge and test it

    
    // TODO tests for operations of Edge
    @Test
    public void testEdgeToString() {
        Edge edge = new Edge("wode", "New York", 22);
        assertEquals("expected:", "<wode, New York, 22>", edge.toString());
    }

    @Test
    public void testEdgeGetSource() {
        Edge edge = new Edge("wode", "New York", 22);
        assertEquals("expected", "wode", edge.getSource());
    }

    @Test
    public void testEdgeGetTarget() {
        Edge edge = new Edge("wode", "New York", 22);
        assertEquals("expected", "New York", edge.getTarget());
    }

    @Test
    public void testEdgeGetWeight() {
        Edge edge = new Edge("wode", "New York", 22);
        assertEquals("expected", 22, edge.getWeight());
    }

}
