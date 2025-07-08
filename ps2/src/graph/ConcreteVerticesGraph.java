/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package graph;

import java.util.*;

/**
 * An implementation of Graph.
 * 
 * <p>PS2 instructions: you MUST use the provided rep.
 */
public class ConcreteVerticesGraph<L> implements Graph<L> {
    
    private final List<Vertex<L>> vertices = new ArrayList<>();
    
    // Abstraction function:
    //   TODO
    // Represent graph by a list of vertices adjacent table.
    // Representation invariant:
    //   TODO
    // vertices is mutable data type, every Vertex has a source vertex and a list of adjacent vertex.
    // every vertex object must keep unique.
    // Safety from rep exposure:
    //   TODO
    // all fields is private
    // sources() and targets() method should copy defensive to avoid data to client.
    
    // TODO constructor
    public ConcreteVerticesGraph() {
        checkRep();
    }

    public ConcreteVerticesGraph(L vertex) {
        Vertex ver = new Vertex(vertex);
        vertices.add(ver);
        checkRep();
    }

    // TODO checkRep
    private void checkRep() {
        int verticesSize = vertices.size();
        Set<L> uniqueVertices = new HashSet<>();
        for (Vertex<L> ver : vertices) {
            uniqueVertices.add(ver.getSource());
        }
        assert uniqueVertices.size() == verticesSize : "don't keep source node unique";
    }

    /**
     * check string vertex whether exit in vertices list
     * @param vertex target string vertex.
     * @return boolean if target vertex exit in vertices list, else return false.
     */
    private boolean checkOccurVertex(L vertex) {
        for (Vertex<L> ver : vertices) {
            if (ver.getSource().equals(vertex)) {
                checkRep();
                return true;
            }
        }
        checkRep();
        return false;
    }

    /**
     * Get the target Vertex in vertices list. if exited.
     * @param target target vertex string
     * @return Vertex object of target string, if exited, else return a null.
     */
    private Vertex<L> getTargetVertex(L target) {
        for (Vertex<L> vertex : vertices) {
            if (vertex.getSource().equals(target)) {
                checkRep();
                return vertex;
            }
        }
        checkRep();
        return null;
    }


    @Override public boolean add(L vertex) {
        if (checkOccurVertex(vertex)) {
            checkRep();
            return false;
        }
        Vertex<L> ver = new Vertex<L>(vertex);
        this.vertices.add(ver);
        checkRep();
        return true;
    }
    
    @Override public int set(L source, L target, int weight) {
        if (weight == 0) {
            if (checkOccurVertex(source)) {
                Vertex ver = getTargetVertex(source);
                if (ver.checkEdgeExit(target)){
                    int previousWeight = ver.getTargetWeight(target);
                    ver.removeEdge(target);
                    checkRep();
                    return previousWeight;
                }
            }
            checkRep();
            return 0;
        }
        else {
            if (checkOccurVertex(source) && checkOccurVertex(target)) {
                Vertex ver = getTargetVertex(source);
                int previousWeight = 0;
                if (ver.checkEdgeExit(target)) {
                    previousWeight = ver.getTargetWeight(target);
                }
                ver.addEdge(target, weight);
                checkRep();
                return previousWeight;
            }
            else if (checkOccurVertex(source) && !checkOccurVertex(target)) {
                Vertex newVer = new Vertex(target);
                Vertex sourceVer = getTargetVertex(source);
                sourceVer.addEdge(target, weight);
                vertices.add(newVer);
                checkRep();
                return 0;
            }
            else if (!checkOccurVertex(source) && checkOccurVertex(target)) {
                // source vertex don't exit, and target vertex exit.
                Vertex newVer = new Vertex(source);
                newVer.addEdge(target, weight);
                vertices.add(newVer);
                return 0;
            }
            else if (!checkOccurVertex(source) && !checkOccurVertex(target)) {
                // source vertex don't exit, and target vertex don't exit.
                Vertex newVer1 = new Vertex(source);
                Vertex newVer2 = new Vertex(target);
                newVer1.addEdge(target, weight);
                vertices.add(newVer1);
                vertices.add(newVer2);
                return 0;
            }
        }
        return 0;
    }
    
    @Override public boolean remove(L vertex) {
        if (checkOccurVertex(vertex)) {
            Vertex<L> sourceVertex = getTargetVertex(vertex);
            // remove all edges from this vertex.
            vertices.remove(sourceVertex);

            // remove all edges to this vertex.
            for (Vertex<L> ver : vertices) {
                ver.removeEdge(vertex);
            }
            checkRep();
            return true;
        }
        checkRep();
        return false;
    }
    
    @Override public Set<L> vertices() {
        Set<L> verticesLabels = new HashSet<>();
        for (Vertex<L> ver : vertices) {
            verticesLabels.add(ver.getSource());
        }
        checkRep();
        return verticesLabels;
    }
    
    @Override public Map<L, Integer> sources(L target) {
        Map<L, Integer> sourcesMap = new HashMap<>();
        for (Vertex<L> ver : vertices) {
            if (ver.checkEdgeExit(target)) {
                sourcesMap.put(ver.getSource(), ver.getTargetWeight(target));
            }
        }
        checkRep();
        return sourcesMap;
    }
    
    @Override public Map<L, Integer> targets(L source) {
        Vertex<L> ver = getTargetVertex(source);
        if (ver != null) {
            checkRep();
            return ver.getAdjacentVertices();
        }
        return new HashMap<>();
    }
    
    // TODO toString()
    @Override
    public String toString() {
        String graphString = "Edges: {";
        int count = 0;
        int verticesSize = vertices.size() - 1;
        for (Vertex<L> ver : vertices) {
            if (count == verticesSize) {
                graphString += ver.toString();
                break;
            }
            count += 1;
            if (!ver.getAdjacentVertices().isEmpty()) {
                graphString += ver.toString() + ", ";
            }
        }

        graphString += "}" + ", " + "Vertices: {";
        count = 0;
        for (Vertex<L> ver : vertices) {
            if (count == verticesSize) {
                graphString += ver.getSource();
                break;
            }
            count += 1;
            graphString += ver.getSource() + ", ";
        }
        graphString += "}";
        checkRep();
        return graphString;
    }
    
}

/**
 * TODO specification
 * Mutable.
 * This class is internal to the rep of ConcreteVerticesGraph.
 * 
 * <p>PS2 instructions: the specification and implementation of this class is
 * up to you.
 */
class Vertex<L> {
    
    // TODO fields
    private final L source;
    private final Map<L, Integer> adjVertex = new HashMap<>();
    // Abstraction function:
    //   TODO
    // a graph is a set of vertices and its adjacent vertices.
    // Representation invariant:
    //   TODO
    // use source and adjVertex to represent a set of edges. And source is not null.
    // Safety from rep exposure:
    //   TODO
    // all fields is private
    // adjVertex is mutable, so
    
    // TODO constructor
    public Vertex(L source) {
        this.source = source;
        checkRep();
    }

    // TODO checkRep
    private void checkRep() {
        assert source != null;
    }
    
    // TODO methods
    /**
     * get Vertex class source vertex
     * @return Vertex class source vertex
     */
    public L getSource() {
        checkRep();
        return source;
    }

    /**
     * check source => target this edge whether exit
     * @param target target vertex.
     * @return if source => target exit, return true, otherwise return false;
     */
    public boolean checkEdgeExit(L target) {
        for (L key : adjVertex.keySet()) {
            if (key.equals(target)) {
                checkRep();
                return true;
            }
        }
        checkRep();
        return false;
    }

    /**
     * if Target exit, get source => target edge's weight, otherwise return -1.
     * @param Target target vertex.
     * @return edge(source => target) exit, return weight, else return -1.
     */
    public int getTargetWeight(L Target) {
        if (checkEdgeExit(Target)) {
            checkRep();
            return adjVertex.get(Target);
        }
        checkRep();
        return -1;
    }

    /**
     * Get all Adjacent vertices, which connect to source vertex.
     * @return a map of all adjacent vertices, which include adjacent vertex and weight.
     */
    public Map<L, Integer> getAdjacentVertices() {
        Map<L, Integer> adjacent = new HashMap<>();
        for (Map.Entry<L, Integer> entry : adjVertex.entrySet()) {
            adjacent.put(entry.getKey(), entry.getValue());
        }
        checkRep();
        return adjacent;
    }

    /**
     *  Add an edge to the graph, represent an edge of (source => target). if target not exit, add edge, else update weight.
     * @param target require to add the vertex.
     */
    public void addEdge(L target, int weight) {
        adjVertex.put(target, weight);
        checkRep();
    }

    /**
     * Edge exited, remove this edge in the graph and return true, else return false.
     * @param target target vertex.
     */
    public boolean removeEdge(L target) {
        if (checkEdgeExit(target)) {
            adjVertex.remove(target);
            checkRep();
            return true;
        }
        checkRep();
        return false;
    }


    // TODO toString()
    @Override
    public String toString() {
        String adjacentGraph = "";
        int lastIndex = adjVertex.size() - 1;
        int count = 0;
        for (L target : adjVertex.keySet()) {
            if (count == lastIndex) {
                adjacentGraph += "<" + this.source + ", " + target + ", " + adjVertex.get(target) + ">";
                break;
            }
            count += 1;
            adjacentGraph += "<" + this.source + ", " + target + ", " + adjVertex.get(target) + ">" + ", ";
        }
        return adjacentGraph;
    }
}
