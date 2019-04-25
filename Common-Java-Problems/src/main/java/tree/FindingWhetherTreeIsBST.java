package tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * FindingWhetherTreeIsBST
 * Learning
 *
 * @author WissenSolutions.
 */
public class FindingWhetherTreeIsBST {
    @Test
    public void testFindingWhetherTreeIsBST() {
        Node<Integer> root = new Node<>(3);
        Node<Integer> node1 = new Node<>(3);
        Node<Integer> node2 = new Node<>(6);
        Node<Integer> node3 = new Node<>(1);
        Node<Integer> node4 = new Node<>(5);
        Node<Integer> node5 = new Node<>(7);
        Node<Integer> node6 = new Node<>(4);
        root.setLeftNode(node1);
        root.setRightNode(node2);
        node1.setLeftNode(node3);
        node2.setLeftNode(node4);
        node2.setRightNode(node5);
        node1.setRightNode(node6);

        Assert.assertFalse(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    private boolean isBST(Node<Integer> rootNode, Integer min, Integer max){
        if(rootNode == null){
            return true;
        }
        if(rootNode.getValue() > min && rootNode.getValue() < max){
            return false;
        }
        return isBST(rootNode.getLeftNode(),min, rootNode.getValue())
                && isBST(rootNode.getRightNode(),rootNode.getValue(),max);
    }
}
