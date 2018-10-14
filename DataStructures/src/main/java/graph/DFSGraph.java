package graph;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Stack;

/**
 * DFSGraph
 * Learning
 *
 * @author WissenSolutions.
 */
public class DFSGraph<T> extends Graph<T>{
    private static final Logger logger = LoggerFactory.getLogger(DFSGraph.class);

    public boolean performDFS(Node<T> node, T searchValue){
        Stack<Node<T>> stack = new Stack<>();
        List<Node<T>> connectorNodeList = node.getConnectedNodeList();
        connectorNodeList.forEach(stack::push);
        while(!stack.isEmpty()){
            Node<T> poppedNode = stack.pop();
            if(!poppedNode.isVisited()) {
                if (poppedNode.getData().equals(searchValue)) {
                    return true;
                } else {
                    connectorNodeList = poppedNode.getConnectedNodeList();
                    connectorNodeList.forEach(stack::push);
                }
            }
            poppedNode.setVisited(true);
        }
        return false;
    }
}
