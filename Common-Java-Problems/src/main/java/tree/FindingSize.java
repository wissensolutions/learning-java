package tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * FindingSize
 * Learning
 *
 * @author WissenSolutions.
 */
public class FindingSize {
    @Test
    public void testFindingSize() {
        Node<Integer> root = new Node<>(10);
        Node<Integer> node1 = new Node<>(6);
        Node<Integer> node2 = new Node<>(17);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(12);
        Node<Integer> node5 = new Node<>(23);
        Node<Integer> node6 = new Node<>(19);
        root.setLeftNode(node1);
        root.setRightNode(node2);
        node1.setLeftNode(node3);
        node2.setLeftNode(node4);
        node2.setRightNode(node5);
        node5.setLeftNode(node6);
        Assert.assertEquals(7, getSize(root));
    }

    private int getSize(Node<Integer> node){
        if( node == null){
            return 0;
        }
        return getSize(node.getLeftNode())+ getSize(node.getRightNode()) + 1;
    }
}
