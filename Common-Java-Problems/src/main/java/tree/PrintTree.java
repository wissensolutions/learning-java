package tree;

import org.junit.Test;

/**
 * @author : Wissen Solutions.
 */
public class PrintTree<T>{
    @Test
    public void testHealthy() {

    }

    enum TraverseMode {
        PRE_ORDER, IN_ORDER, POST_ORDER
    }

    public void traverse(TraverseMode mode, Node<T> root) {
        switch (mode){
            case IN_ORDER: printInOrder(root);
                break;
            case PRE_ORDER: printInPreOrder(root);
                break;
            case POST_ORDER: printInPostOrder(root);
                break;
        }
    }

    // left - > Node value - > Right
    private void printInOrder(Node<T> rootNode){
        if(rootNode == null){
            return;
        }
        printInOrder(rootNode.getLeftNode());
        System.out.print(rootNode + " --> ");
        printInOrder(rootNode.getRightNode());
    }

    //  Node value - > left - > Right
    private void printInPreOrder(Node<T> rootNode){
        if(rootNode == null){
            return;
        }
        System.out.print(rootNode + " --> ");
        printInPreOrder(rootNode.getLeftNode());
        printInPreOrder(rootNode.getRightNode());
    }
    // left - >  Right  - > Node value
    private void printInPostOrder(Node<T> rootNode){
        if(rootNode == null){
            return;
        }
        printInPostOrder(rootNode.getLeftNode());
        printInPostOrder(rootNode.getRightNode());
        System.out.print(rootNode + " --> ");
    }

}
