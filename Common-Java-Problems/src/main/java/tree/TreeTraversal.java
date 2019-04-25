package tree;

import org.junit.Test;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author : Wissen Solutions.
 */
public class TreeTraversal<T extends Comparable<T>> {
    public enum TraversalMode{
        DFS, BFS
    }

    public Node<T> searchValue(Node<T> root, T searchValue, TraversalMode mode) {
        Node<T> returnValue = null;
        switch (mode){
            case DFS: returnValue = traverseInDFS(root, searchValue);
                    break;
            case BFS: returnValue = traverseInBFS(root, searchValue);
                break;
        }
        return returnValue;
    }

    private Node<T> traverseInBFS(Node<T> root, T searchValue){
        if(root == null){
            return null;
        }
        Queue<Node<T>> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node<T> node = queue.poll();
            if(node != null){
                System.out.println(node + " --> ");
                if(node.getValue().compareTo(searchValue) == 0){
                    return node;
                } else {
                    queue.add(node.getLeftNode());
                    queue.add(node.getRightNode());
                }
            }
        }
        return null;
    }

    private Node<T> traverseInDFS(Node<T> root, T searchValue){
        if(root == null){
            return null;
        }
        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node<T> node = stack.pop();
            if(node != null) {
                System.out.println(node + " --> ");
                if (node.getValue().compareTo(searchValue) == 0) {
                    return node;
                } else {
                    stack.push(node.getRightNode());
                    stack.push(node.getLeftNode());
                }
            }
        }
        return null;
    }
}
