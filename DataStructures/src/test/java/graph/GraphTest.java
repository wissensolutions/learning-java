package graph;

import org.junit.Test;

/**
 * GraphTest
 * Learning
 *
 * @author WissenSolutions.
 */
public class GraphTest {
    /**
     * Method to test graph creation
     */
    @Test
    public void testGraphCreation() throws Exception {
        Graph<Integer> graph = new Graph<>();
        graph.addVertex(7);
        graph.addVertex(1);
        graph.addEdge(7, 1);
        graph.addVertex(12);
        graph.addEdge(1, 12);
        graph.addVertex(21);
        graph.addEdge(12, 21);
        graph.addVertex(14);
        graph.addEdge(21, 14);
        graph.addOneWayEdge(14,16);
        graph.printGraph();
    }
}
