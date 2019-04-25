package graph;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DFSGraphTest
 * Learning
 *
 * @author WissenSolutions.
 */
public class DFSGraphTest {
    private static final Logger logger = LoggerFactory.getLogger(DFSGraphTest.class);

    @Test
    public void dfsGraphHealthyTest(){
        DFSGraph<Integer> graph = new DFSGraph<>();
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

        Assert.assertTrue(graph.performDFS(rootNode,21));
    }

    @Test
    public void dfsGraphNegativeTest(){
        DFSGraph<Integer> graph = new DFSGraph<>();
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

        Assert.assertFalse(graph.performDFS(rootNode,2231));
    }
}
