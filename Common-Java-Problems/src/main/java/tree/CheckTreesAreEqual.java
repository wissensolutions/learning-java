package tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * CheckTreesAreEqual
 * Learning
 *
 * @author WissenSolutions.
 */
public class CheckTreesAreEqual {
    @Test
    public void testCheckTreesAreEqual() {
        Node<Integer> root1 = new Node<Integer>(4);
        Node<Integer> root2 = new Node<Integer>(4);
        Node<Integer> node1 = new Node<Integer>(1);
        Node<Integer> node2 = new Node<Integer>(5);
        Node<Integer> node3 = new Node<Integer>(8);
        root1.setLeftNode(node1);
        root2.setLeftNode(node1);
        root1.setRightNode(node2);
        root2.setRightNode(node2);
        node2.setRightNode(node3);
        Assert.assertTrue(areSame(root1, root2));
    }

    private boolean areSame(Node<Integer> rootNode1, Node<Integer> rootNode2){
        if(rootNode1 == null && rootNode2 == null){
            return true;
        }

        if(rootNode1.getValue().equals(rootNode2.getValue()) ){
            return areSame(rootNode1.getLeftNode(), rootNode2.getLeftNode()) && areSame(rootNode1.getRightNode(), rootNode2.getRightNode());
        }
        return false;
    }
}
