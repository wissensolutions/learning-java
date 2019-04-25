package tree;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * tree.BinaryTreeTest
 * Learning
 *
 * @author WissenSolutions.
 */
public class BinarySearchTreeTest {
    private static final Logger logger = LoggerFactory.getLogger(BinarySearchTreeTest.class);

    @Test
    public void testBinarySearchTree(){
        BinarySearchTree<Integer> binaryTree = new BinarySearchTree<>();
        binaryTree.insert(15);
        binaryTree.insert( 10);
        binaryTree.insert( 20);
        binaryTree.insert(  8);
        binaryTree.insert(12);
        binaryTree.insert( 17);
        binaryTree.insert( 25);

        Assert.assertEquals(7,binaryTree.size());
        binaryTree.traverse(Tree.TraverseMode.PRE_ORDER);
    }

    @Test
    public void testBinarySearchTree_RemovalLeaf(){
        BinarySearchTree<Integer> binaryTree = new BinarySearchTree<>();
        binaryTree.insert(15);
        binaryTree.insert( 10);
        binaryTree.insert( 20);
        binaryTree.insert(  8);
        binaryTree.insert(12);
        binaryTree.insert( 17);
        binaryTree.insert( 25);

        Assert.assertEquals(7,binaryTree.size());
        binaryTree.remove(8);
        binaryTree.traverse(Tree.TraverseMode.PRE_ORDER);
        Assert.assertEquals(6,binaryTree.size());
    }

    @Test
    public void testBinarySearchTree_RemovalNodeWithOneChild(){
        BinarySearchTree<Integer> binaryTree = new BinarySearchTree<>();
        binaryTree.insert(15);
        binaryTree.insert( 10);
        binaryTree.insert( 20);
        binaryTree.insert(  8);
        binaryTree.insert(12);
        binaryTree.insert( 17);
        binaryTree.insert( 25);
        binaryTree.insert( 19);

        binaryTree.traverse(Tree.TraverseMode.PRE_ORDER );
        System.out.println( "\n\n ");
        Assert.assertEquals(8,binaryTree.size());
        binaryTree.remove(8);
        Assert.assertEquals(7,binaryTree.size());
        binaryTree.remove(17);
        Assert.assertEquals(6,binaryTree.size());
        binaryTree.traverse(Tree.TraverseMode.PRE_ORDER);
    }

    @Test
    public void testBinarySearchTree_RemovalNodeWithTwoChild(){
        BinarySearchTree<Integer> binaryTree = new BinarySearchTree<>();
        binaryTree.insert(15);
        binaryTree.insert( 10);
        binaryTree.insert( 20);
        binaryTree.insert(  8);
        binaryTree.insert(12);
        binaryTree.insert( 17);
        binaryTree.insert( 25);
        binaryTree.insert( 19);

        binaryTree.traverse(Tree.TraverseMode.PRE_ORDER);
        System.out.println( "\n\n ");

        Assert.assertEquals(8,binaryTree.size());
        binaryTree.remove(15);
        binaryTree.traverse(Tree.TraverseMode.PRE_ORDER);
    }



}
