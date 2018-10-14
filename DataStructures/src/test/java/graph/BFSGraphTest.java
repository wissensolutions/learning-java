package graph;

import org.junit.Assert;
import org.junit.Test;

/**
 * BFSGraphTest
 * Learning
 *
 * @author WissenSolutions.
 */
public class BFSGraphTest {

    @Test
    public void testBFSHealthy() throws Exception {
        BFSGraph<Integer> graph = new BFSGraph<>();
        Graph<Integer>.Node<Integer> rootNode = graph.addVertex(7);
        graph.addVertex(1);
        graph.addEdge(7, 1);
        graph.addVertex(12);
        graph.addEdge(1, 12);
        graph.addVertex(21);
        graph.addEdge(12, 21);
        graph.addVertex(14);
        graph.addEdge(21, 14);
        graph.addOneWayEdge(14,16);

        Assert.assertTrue(graph.performBFS(rootNode,21));
    }

    @Test
    public void testBFSUnavailabilityCase() throws Exception {
        BFSGraph<Integer> graph = new BFSGraph<>();
        Graph<Integer>.Node<Integer> rootNode = graph.addVertex(7);
        graph.addVertex(1);
        graph.addEdge(7, 1);
        graph.addVertex(12);
        graph.addEdge(1, 12);
        graph.addVertex(21);
        graph.addEdge(12, 21);
        graph.addVertex(14);
        graph.addEdge(21, 14);
        graph.addOneWayEdge(14,16);

        Assert.assertFalse(graph.performBFS(rootNode,123));
    }
}
