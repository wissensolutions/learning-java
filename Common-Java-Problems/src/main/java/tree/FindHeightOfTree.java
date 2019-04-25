package tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author : Wissen Solutions.
 */
public class FindHeightOfTree {
    @Test
    public void testHealthy() {
        Node<Integer> root = new Node<>(6);
        Node<Integer> rootLeft = new Node<>(4);
        Node<Integer> rootRight = new Node<>(9);
        Node<Integer> node2 = new Node<>(3);
        Node<Integer> node3 = new Node<>(5);
        rootLeft.setLeftNode(node2);
        rootLeft.setRightNode(node3);
        root.setLeftNode(rootLeft);

        Node<Integer> node4 = new Node<>(8);
        Node<Integer> node5 = new Node<>(10);
        rootRight.setLeftNode(node4);
        rootRight.setRightNode(node5);
        root.setRightNode(rootRight);

        Assert.assertEquals(3, getHeight(root));
    }

    private int getHeight(Node<Integer> node ){
        if(node == null){
            return 0;
        }
        return 1 + Math.max( getHeight(node.getLeftNode()), getHeight(node.getRightNode()));
    }
}
