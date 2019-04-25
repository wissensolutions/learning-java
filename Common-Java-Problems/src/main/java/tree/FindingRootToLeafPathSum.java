package tree;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * * <br> Problem Statement :
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 *
 * </br>
 *
 * @author : Wissen Solutions.
 */
public class FindingRootToLeafPathSum {
    @Test
    public void testHealthy() {
        Node<Integer> root = new Node<>(6);
        Node<Integer> rootLeft = new Node<>(4);
        Node<Integer> rootRight = new Node<>(9);
        rootLeft.setRightNode(new Node<>(5));
        rootLeft.setLeftNode(new Node<>(3));
        rootRight.setRightNode(new Node<>(10));
        rootRight.setLeftNode(new Node<>(8));
        root.setLeftNode(rootLeft);
        root.setRightNode(rootRight);

        Assert.assertTrue( findRootToLeafSum(root, 13));
        Assert.assertTrue( findRootToLeafSum(root, 15));

        Assert.assertTrue( findRootToLeafSum(root, 13, 0 ));
        Assert.assertTrue( findRootToLeafSum(root, 15, 0));
    }

    private boolean findRootToLeafSum(Node<Integer> node, Integer expectedSum){
        if(node == null || expectedSum == null){
            return false;
        }

        int difference = expectedSum - node.getValue();
        if( difference == 0 && node.getLeftNode() == null && node.getRightNode() == null){
            return true;
        }
        return findRootToLeafSum(node.getLeftNode(), difference) || findRootToLeafSum(node.getRightNode() , difference);
    }

    private boolean findRootToLeafSum(Node<Integer> node, Integer expectedSum, int sumValue){
        if(node == null || expectedSum == null){
            return false;
        }

        sumValue = sumValue + node.getValue();
        if( sumValue == expectedSum && node.getLeftNode() == null && node.getRightNode() == null){
            return true;
        }
        return findRootToLeafSum(node.getLeftNode(), expectedSum, sumValue) || findRootToLeafSum(node.getRightNode() ,expectedSum, sumValue);
    }

}
