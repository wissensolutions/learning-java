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
        binaryTree.addNode(15);
        binaryTree.addNode( 10);
        binaryTree.addNode( 20);
        binaryTree.addNode(  8);
        binaryTree.addNode(12);
        binaryTree.addNode( 17);
        binaryTree.addNode( 25);

        Assert.assertEquals(7,binaryTree.size());
        binaryTree.printTreeInPreOrder();
        binaryTree.printTreeInInOrder();
    }

    @Test
    public void testBinarySearchTree_RemovalLeaf(){
        BinarySearchTree<Integer> binaryTree = new BinarySearchTree<>();
        binaryTree.addNode(15);
        binaryTree.addNode( 10);
        binaryTree.addNode( 20);
        binaryTree.addNode(  8);
        binaryTree.addNode(12);
        binaryTree.addNode( 17);
        binaryTree.addNode( 25);

        Assert.assertEquals(7,binaryTree.size());
        binaryTree.deleteNode(8);
        binaryTree.printTreeInPreOrder();
    }

    @Test
    public void testBinarySearchTree_RemovalNodeWithOneChild(){
        BinarySearchTree<Integer> binaryTree = new BinarySearchTree<>();
        binaryTree.addNode(15);
        binaryTree.addNode( 10);
        binaryTree.addNode( 20);
        binaryTree.addNode(  8);
        binaryTree.addNode(12);
        binaryTree.addNode( 17);
        binaryTree.addNode( 25);
        binaryTree.addNode( 19);

       // binaryTree.printTreeInPreOrder();
        Assert.assertEquals(8,binaryTree.size());
        binaryTree.deleteNode(8);
       // binaryTree.printTreeInPreOrder();
        Assert.assertEquals(7,binaryTree.size());
        binaryTree.deleteNode(17);
        Assert.assertEquals(6,binaryTree.size());
        binaryTree.printTreeInPreOrder();
    }

    @Test
    public void testBinarySearchTree_RemovalNodeWithTwoChild(){
        BinarySearchTree<Integer> binaryTree = new BinarySearchTree<>();
        binaryTree.addNode(15);
        binaryTree.addNode( 10);
        binaryTree.addNode( 20);
        binaryTree.addNode(  8);
        binaryTree.addNode(12);
        binaryTree.addNode( 17);
        binaryTree.addNode( 25);
        binaryTree.addNode( 19);

       binaryTree.printTreeInPreOrder();
        Assert.assertEquals(8,binaryTree.size());
        binaryTree.deleteNode(8);
        // binaryTree.printTreeInPreOrder();
        Assert.assertEquals(7,binaryTree.size());
        binaryTree.deleteNode(17);
        Assert.assertEquals(6,binaryTree.size());
        //binaryTree.printTreeInPreOrder();
        binaryTree.deleteNode(15);
        binaryTree.printTreeInPreOrder();
    }



}
