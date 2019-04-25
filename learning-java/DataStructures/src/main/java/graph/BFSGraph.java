package graph;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * BFSGraph
 * Learning
 *
 * @author WissenSolutions.
 */
/**
 * Breadth First Search implemented for Graphs
 *
 * <p> Algorithm :
 * 	1. Push the root node in the Queue.
 * 	2. Loop until the Queue is empty.
 * 	3. Remove the Node from the Queue.
 * 	4. If the removed node has unvisited children, mark them as visited and insert the unvisited children in the Queue.
 * </p>
 *
 */
public class BFSGraph<T> extends Graph<T>{
    private static final Logger logger = LoggerFactory.getLogger(BFSGraph.class);

    public boolean performBFS(Node<T> rootNode, T searchValue){
        Queue<Node<T>> queue = new ArrayDeque<>();
        if(rootNode == null){
            throw new IllegalStateException("Please provide valid root node");
        }
        List<Node<T>> nodeList = rootNode.getConnectedNodeList();
        // Push the all connectedNodeList to queue
        nodeList.forEach(queue::add);

        //Node take out all the nodes and search for it
        while(!queue.isEmpty()) {
            Node<T> node = queue.poll();
            if(!node.isVisited()) {
                if (node.getData().equals(searchValue)) {
                    return true;
                } else {
                    node.setVisited(true);
                    if(node.getConnectedNodeList() != null) {
                        node.getConnectedNodeList().forEach(queue::add);
                    }
                }
            }
        }
        return false;
    }

}
