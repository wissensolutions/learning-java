package tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * InorderPredecessorInBST
 * Learning
 *
 * https://algorithms.tutorialhorizon.com/inorder-predecessor-and-successor-in-binary-search-tree/
 * @author WissenSolutions.
 */
public class InorderPredecessorInBST {
    @Test
    public void testInorderPredecessorInBST() {
        Node<Integer> root = new Node<>(20);
        Node<Integer> node1 = new Node<>(8);
        Node<Integer> node2 = new Node<>(22);
        Node<Integer> node3 = new Node<>(4);
        Node<Integer> node4 = new Node<>(12);
        Node<Integer> node5 = new Node<>(10);
        Node<Integer> node6 = new Node<>(14);

        root.setLeftNode(node1);
        root.setRightNode(node2);
        node1.setLeftNode(node3);
        node1.setRightNode(node4);
        node4.setLeftNode(node5);
        node4.setRightNode(node6);

        Assert.assertEquals(20, findPredecessor(root, 22).intValue());
        Assert.assertEquals(12, findPredecessor(root, 14).intValue());
    }

    private Integer findPredecessor(Node<Integer> root, Integer value){
        if( root == null || value == null){
            return null;
        }
        Integer predessor = null;
        while( root != null){
            if( root.getValue().compareTo(value) < 0) {
                predessor = root.getValue();
                root = root.getRightNode();
            } else if( root.getValue().compareTo(value) > 0) {
                root = root.getLeftNode();
            } else {
                if( root.getLeftNode() != null){
                    predessor = findMaximum(root.getLeftNode());
                }
                break;
            }
        }
        return predessor;
    }
    private Integer findMaximum(Node<Integer> node){

        if(node.getRightNode()!= null){
            node = node.getRightNode();

        }
        return node.getValue();
    }
}
