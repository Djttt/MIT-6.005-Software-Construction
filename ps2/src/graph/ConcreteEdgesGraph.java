/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package graph;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * An implementation of Graph.
 * 
 * <p>PS2 instructions: you MUST use the provided rep.
 */
public class ConcreteEdgesGraph implements Graph<String> {
    
    private final Set<String> vertices = new HashSet<>();
    private final List<Edge> edges = new ArrayList<>();

    // Abstraction function:
    //   TODO
    // represents a concrete graph with a set of edges.
    // <a, b, 4>, <b, c, 12>
    // Representation invariant:
    //   TODO
    // mutable graph, a graph is a list of edges, and use vertices set to guarantee vertex only.
    // so edges and vertices is not null, that is good.
    // Safety from rep exposure:
    //   TODO
    // all fields are private
    // vertices and edges is mutable data, so vertices() make defensive copies and avoid sharing the rep's data with clients.
    
    // TODO constructor
    public ConcreteEdgesGraph() {

    }

    public ConcreteEdgesGraph(List<Edge> edges) {
        this.edges.addAll(edges);
        for (Edge e : edges) {
            vertices.add(e.getSource());
            vertices.add(e.getTarget());
        }
    }
    
    // TODO checkRep
    private void checkRep() {

    }
    
    @Override public boolean add(String vertex) {
        if (!vertices.contains(vertex)) {
            vertices.add(vertex);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Judge this graph whether contain an edge.
     * @param edge input edge wait to check it out.
     * @return if edges have this edge return true, else return false.
     */
    private boolean containEdge(Edge edge) {
        for (Edge e : edges) {
            if (e.equals(edge)) {
                return true;
            }
        }
        return false;
    }

    /**
     * insert an edge into graph, if edge already exit, then update it, else insert a new edge.
     * @param weight edge's weight.
     * @param source edge's source vertex.
     * @param target edge's target vertex.
     */
    private void insertEdge (String source, String target, int weight) {
        Edge edge = new Edge(source, target, weight);
        if (containEdge(edge)) {
            Edge newEdge = new Edge(source, target, weight);
            edges.remove(edge);
            edges.add(newEdge);
        }
        else {
             Edge newEdge = new Edge(source, target, weight);
             edges.add(newEdge);
        }
    }

    @Override public int set(String source, String target, int weight) {
        Edge edge = new Edge(source, target, weight);
        if (weight == 0) {
            if (containEdge(edge)) {
                edges.remove(edge);
                return edge.getWeight();
            }
            return 0;
        }
        else {
            insertEdge(source, target, weight);
            vertices.add(source);
            vertices.add(target);
            return 0;
        }
    }
    
    @Override public boolean remove(String vertex) {
        List<Edge> waitToRemoveEdge = new ArrayList<>();
        if (vertices.contains(vertex)) {
            vertices.remove(vertex);
            for (Edge e: edges) {
                String source = e.getSource();
                String target = e.getTarget();
                if (source.equals(vertex) || target.equals(vertex)) {
                    // edges.remove(e);
                    waitToRemoveEdge.add(e);
                }
            }
            edges.removeAll(waitToRemoveEdge);
            return true;
        }
        return false;
    }
    
    @Override public Set<String> vertices() {
        return vertices;
    }
    
    @Override public Map<String, Integer> sources(String target) {
        Map<String, Integer> sourceVertices = new HashMap<>();
        for (Edge e : edges) {
            String eTarget = e.getTarget();
            if (eTarget.equals(target)) {
                sourceVertices.put(e.getSource(), e.getWeight());
            }
        }
        return sourceVertices;
    }
    
    @Override public Map<String, Integer> targets(String source) {
        Map<String, Integer> targetVertices = new HashMap<>();
        for (Edge e: edges) {
            String eSource = e.getSource();
            if (eSource.equals(source)) {
                targetVertices.put(e.getTarget(), e.getWeight());
            }
        }
        return targetVertices;
    }
    
    // TODO toString()
    @Override
    public String toString() {
        String str  = "Edge: {";
        Edge lastEdge = null;
        if (edges.size() - 1 >= 0) {
            lastEdge = edges.get(edges.size() - 1);
        }
        for (Edge e : edges) {
            if (e.equals(lastEdge)) {
                str += e.toString();

            }
            else {
                str += e.toString() + ", ";
            }
        }
        str += "}, Vertices: {";
        int lastVertexIndex = vertices.size() - 1;
        int count = 0;
        for (String vertex : vertices) {
            if (lastVertexIndex == count) {
                str += vertex;
                continue;
            }
            str += vertex + ", ";
            count += 1;
        }
        str += "}";
        return str;
    }
}

/**
 * TODO specification
 * Immutable.
 * This class is internal to the rep of ConcreteEdgesGraph.
 * 
 * <p>PS2 instructions: the specification and implementation of this class is
 * up to you.
 */
class Edge {
    
    // TODO fields
    private final String source;
    private final String target;
    private final int weight;
    // Abstraction function:
    //   TODO
    // represents one edge of edge's list
    // every edge have source and target vertex and weight.
    // Representation invariant:
    //   TODO
    // weight >= 0, source and target vertex must different, immutable object.
    //
    // Safety from rep exposure:
    //   TODO
    // use private keyword to declare source and target vertex, also weight.
    
    // TODO constructor
    public Edge(String source, String target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
        checkRep();
    }
    
    // TODO checkRep
    private void checkRep() {
        assert weight >= 0 : "weight must >= 0";
        assert !source.equals(target) : "source vertex must not equal target";
    }
    
    // TODO methods
    /**
     * get edge's source vertex.
     * @return this edge's source vertex.
     */
    public String getSource() {
        return source;
    }

    /**
     * get edge's target vertex.
     * @return this edge's target vertex.
     */
    public String getTarget() {
        return target;
    }

    /**
     * get edge's weight(weight >= 0)
     * @return edge's weight
     */
    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Edge otherEdge = (Edge) other;
        if (otherEdge.getSource().equals(source) && otherEdge.getTarget().equals(target)) {
            return true;
        }
        return false;
    }

    // TODO toString()
    @Override
    public String toString() {
        return "<" + getSource() + ", " + getTarget() + ", " + getWeight() + ">";
    }
}
