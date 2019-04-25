package tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * SubTreeCheck
 * Problem Statement: Given two binary trees, check if the first tree is subtree
 * of the second one. A subtree of a tree T is a tree S consisting of a node in T
 * and all of its descendants in T. The subtree corresponding to the root node is
 * the entire tree; the subtree corresponding to any other node is called a proper subtree.
 *
 * @author WissenSolutions.
 */
public class SubTreeCheck {
    @Test
    public void testSubTreeCheck() {
        //Main tree
        Node<Integer> root = new Node<>(6);
        Node<Integer> rootLeft = new Node<>(4);
        Node<Integer> rootRight = new Node<>(9);
        rootLeft.setRightNode(new Node<>(5));
        rootLeft.setLeftNode(new Node<>(3));
        rootRight.setRightNode(new Node<>(10));
        rootRight.setLeftNode(new Node<>(8));
        root.setLeftNode(rootLeft);
        root.setRightNode(rootRight);

        // sub Tree 1
        Node<Integer> subRoot1 = new Node<>(4);
        Node<Integer> subRoot1Left = new Node<>(3);
        Node<Integer> subRoot1Right = new Node<>(5);
        subRoot1.setLeftNode(subRoot1Left);
        subRoot1.setRightNode(subRoot1Right);

        // sub Tree 2
        Node<Integer> subRoot2 = new Node<>(4);
        Node<Integer> subRoot2Left = new Node<>(3);
        Node<Integer> subRoot2Right = new Node<>(6);
        subRoot2.setLeftNode(subRoot2Left);
        subRoot2.setRightNode(subRoot2Right);

        Assert.assertTrue(isSubTree(root, subRoot1));
        Assert.assertFalse(isSubTree(root, subRoot2));
    }

    private boolean isSubTree(Node<Integer> root, Node<Integer> subRoot){
        if( root == null && subRoot == null){
            return true;
        }
        if( root == null || subRoot == null){
            return false;
        }
        if(root.getValue().compareTo( subRoot.getValue()) == 0){
            return areTreesEquals(root, subRoot);
        } else {
           return areTreesEquals(root.getLeftNode(), subRoot) || areTreesEquals(root.getRightNode(), subRoot);
        }
    }

    private boolean areTreesEquals(Node<Integer> root1, Node<Integer> root2){
        if( root1 == null && root2 == null){
            return true;
        }
        if( root1 == null || root2 == null){
            return false;
        }
        if(root1.getValue().compareTo(root2.getValue()) == 0){
            return areTreesEquals(root1.getLeftNode(),root2.getLeftNode()) &&
                    areTreesEquals(root1.getRightNode(),root2.getRightNode());
        }
        return false;
    }
}
