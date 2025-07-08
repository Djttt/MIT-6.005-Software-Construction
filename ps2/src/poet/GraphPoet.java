/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package poet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import graph.Graph;
import sun.security.provider.certpath.Vertex;

/**
 * A graph-based poetry generator.
 * 
 * <p>GraphPoet is initialized with a corpus of text, which it uses to derive a
 * word affinity graph.
 * Vertices in the graph are words. Words are defined as non-empty
 * case-insensitive strings of non-space non-newline characters. They are
 * delimited in the corpus by spaces, newlines, or the ends of the file.
 * Edges in the graph count adjacencies: the number of times "w1" is followed by
 * "w2" in the corpus is the weight of the edge from w1 to w2.
 * 
 * <p>For example, given this corpus:
 * <pre>    Hello, HELLO, hello, goodbye!    </pre>
 * <p>the graph would contain two edges:
 * <ul><li> ("hello,") -> ("hello,")   with weight 2
 *     <li> ("hello,") -> ("goodbye!") with weight 1 </ul>
 * <p>where the vertices represent case-insensitive {@code "hello,"} and
 * {@code "goodbye!"}.
 * 
 * <p>Given an input string, GraphPoet generates a poem by attempting to
 * insert a bridge word between every adjacent pair of words in the input.
 * The bridge word between input words "w1" and "w2" will be some "b" such that
 * w1 -> b -> w2 is a two-edge-long path with maximum-weight weight among all
 * the two-edge-long paths from w1 to w2 in the affinity graph.
 * If there are no such paths, no bridge word is inserted.
 * In the output poem, input words retain their original case, while bridge
 * words are lower case. The whitespace between every word in the poem is a
 * single space.
 * 
 * <p>For example, given this corpus:
 * <pre>    This is a test of the Mugar Omni Theater sound system.    </pre>
 * <p>on this input:
 * <pre>    Test the system.    </pre>
 * <p>the output poem would be:
 * <pre>    Test of the system.    </pre>
 * 
 * <p>PS2 instructions: this is a required ADT class, and you MUST NOT weaken
 * the required specifications. However, you MAY strengthen the specifications
 * and you MAY add additional methods.
 * You MUST use Graph in your rep, but otherwise the implementation of this
 * class is up to you.
 */
public class GraphPoet {
    
    private final Graph<String> graph = Graph.empty();
    private int graphSize = 0;
    // Abstraction function:
    //   TODO
    // a poet initialized with a corpus
    // Representation invariant:
    //   TODO
    // represent words relationship by graph, graph is immutable.
    // Safety from rep exposure:
    //   TODO
    // all fields is private.
    
    /**
     * Create a new poet with the graph from corpus (as described above).
     * 
     * @param corpus text file from which to derive the poet's affinity graph
     * @throws IOException if the corpus file cannot be found or read
     */
    public GraphPoet(File corpus) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(corpus));
        String line;
        while((line = br.readLine()) != null) {
            String[] lineWords = line.split(" ");
            for (int i = 0; i < lineWords.length; i++) {
                // Convert to lower case and add into graph.
                String currentWord = lineWords[i].toLowerCase();
                graph.add(currentWord);
                graphSize += 1;
                if (i + 1 < lineWords.length) {
                    int nextIndex = i + 1;
                    String pairWord = lineWords[nextIndex].toLowerCase();
                    while (nextIndex + 1 < lineWords.length &&
                            lineWords[nextIndex].equals(lineWords[nextIndex + 1])) {
                        nextIndex += 1;
                    }
                    graph.set(currentWord, pairWord, nextIndex - i);
                    i = nextIndex - 1;
                }
            }
        }
        checkRep();
    }
    
    // TODO checkRep
    private void checkRep() {
        assert graph.vertices().size() == graphSize;
    }


    /**
     * from start to end, get a max weight two-edge-long path node. If it don't exit, return null, else return the vertex
     * @param start start vertex
     * @param end end vertex
     * @return list of all two-edge-long path node.
     */
    private String getTwoEdgeLongMaxWeightNode(String start, String end) {
        Map<String, Integer> vertices1 = graph.targets(start.toLowerCase());
        Map<String, Integer> vertices2 = graph.sources(end.toLowerCase());
        int maxWeight = 0;
        String twoEdgeString = null;
        for (String key : vertices1.keySet()) {
            if (vertices2.containsKey(key)) {
                int sumWeight = vertices1.get(key) + vertices2.get(key);
                if (sumWeight > maxWeight) {
                    maxWeight = sumWeight;
                    twoEdgeString = key;
                }
            }
        }
        checkRep();
        return twoEdgeString;
    }


    /**
     * Generate a poem.
     * 
     * @param input string from which to create the poem
     * @return poem (as described above)
     */
    public String poem(String input) {
        String[] words = input.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.length - 1; i++) {
            String pairWord1 = words[i];
            String pairWord2 = words[i + 1];
            String insertStr = getTwoEdgeLongMaxWeightNode(pairWord1, pairWord2);
            if (i == 0) {
                stringBuilder.append(pairWord1);
            }
            if (insertStr != null) {
                stringBuilder.append(" ");
                stringBuilder.append(insertStr);
                stringBuilder.append(" ");
                stringBuilder.append(pairWord2);
            }
            else {
                stringBuilder.append(" ");
                stringBuilder.append(pairWord2);
            }
        }
        checkRep();
        return stringBuilder.toString();
    }
    
    // TODO toString()
    @Override
    public String toString() {
        return graph.toString();
    }
    
}
