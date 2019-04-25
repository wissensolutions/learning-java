package tree;

import org.junit.Assert;
import org.junit.Test;


/**
 * InOrderSuccessorInBST
 * Learning
 * 1. If the node doesn't have right element, then next ancestor ( Parent Node) will become inorder successor
 * 2. if the node has right element, then take right sub tree and min in that tree path
 * https://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
 * @author WissenSolutions.
 */
public class InOrderSuccessorInBST {
    @Test
    public void testInOrderSuccessorInBST() {
        Node<Integer> root = new Node<>(20);
        Node<Integer> node1 = new Node<>(8);
        Node<Integer> node2 = new Node<>(22);
        Node<Integer> node3 = new Node<>(4);
        Node<Integer> node4 = new Node<>(12);
        Node<Integer> node5 = new Node<>(10);
        Node<Integer> node6 = new Node<>(14);
        Node<Integer> tempNode = new Node<>(72);

        root.setLeftNode(node1);
        root.setRightNode(node2);
        node1.setLeftNode(node3);
        node1.setRightNode(node4);
        node4.setLeftNode(node5);
        node4.setRightNode(node6);

       // Assert.assertEquals(10,findInOrderSuccessor(root, node1).intValue());
        Assert.assertEquals(12,findInOrderSuccessor(root, 10).intValue());
    }

    private Integer findInOrderSuccessor(Node<Integer> currentNode, Integer value){
        if( value == null || currentNode == null){
            return  null;
        }

        Integer successor = null;

        while(currentNode != null){
            if(currentNode.getValue().compareTo(value) < 0){
                currentNode = currentNode.getRightNode();
            } else if(currentNode.getValue().compareTo(value) > 0){
                successor = currentNode.getValue();
                currentNode = currentNode.getLeftNode();
            } else {
                // if the current node's value is equal then search is success
                // then find in-order successor for this node
                if(currentNode.getRightNode() != null) {
                    successor = findMinValue(currentNode.getRightNode());

                }
                break;
            }
        }

        return successor;
    }

    private Integer findMinValue(Node<Integer> minNode) {

        Integer minValue = null;
        while (minNode != null) {
            minValue = minNode.getValue();
            minNode = minNode.getLeftNode();

        }
        return minValue;
    }

}
