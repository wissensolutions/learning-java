package tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * FindingMinAndMaxInBST
 * Learning
 *
 * @author WissenSolutions.
 */
public class FindingMinAndMaxInBST {
    @Test
    public void testFindingMinAndMaxInBST() {
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

        Assert.assertEquals(3, getMin(root).intValue());
        Assert.assertEquals(3, getMinRecursive(root).intValue());
        Assert.assertEquals(23, getMax(root).intValue());
        Assert.assertEquals(23, getMaxRecursive(root).intValue());
    }

    private Integer getMin(Node<Integer> node){
        if(node == null){
            return null;
        }
        while(node.getLeftNode() != null){
            node = node.getLeftNode();
        }
        return node.getValue();
    }

    private Integer getMinRecursive(Node<Integer> node){
        if(node == null){
            return null;
        }
        if(node.getLeftNode() == null){
            return node.getValue();
        }
        return getMinRecursive(node.getLeftNode());

    }

    private Integer getMaxRecursive(Node<Integer> node){
        if(node == null){
            return null;
        }
        if(node.getRightNode() == null){
            return node.getValue();
        }
        return getMaxRecursive(node.getRightNode());

    }

    private Integer getMax(Node<Integer> node){
        if(node == null){
            return null;
        }
        while(node.getRightNode() != null){
            node = node.getRightNode();
        }
        return node.getValue();
    }
}
