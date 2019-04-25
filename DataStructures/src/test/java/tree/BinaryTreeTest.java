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
public class BinaryTreeTest {
    private static final Logger logger = LoggerFactory.getLogger(BinaryTreeTest.class);

    @Test
    public void testBinaryTree(){
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        BinaryTree<Integer>.Node<Integer> rootNode = binaryTree.addLeftNode(1);
        binaryTree.addLeftNode( 2); //returns the root node only
        binaryTree.addLeftNode( 3);//returns the root node only
        binaryTree.addRightNodeRecursively( rootNode.getLeftNode(), 4);
        binaryTree.addRightNodeRecursively(rootNode,5);
        binaryTree.addLeftNodeRecursively( rootNode.getRightNode(),6);
        binaryTree.addRightNodeRecursively( rootNode.getRightNode(),7);

        Assert.assertEquals(7,binaryTree.size());
        binaryTree.printTreeInPreOrder();
    }

    @Test
    public void testBinaryTreeDFS(){
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        BinaryTree<Integer>.Node<Integer> rootNode = binaryTree.addLeftNode(1);
        binaryTree.addLeftNode( 2); //returns the root node only
        binaryTree.addLeftNode( 3);//returns the root node only
        binaryTree.addRightNodeRecursively( rootNode.getLeftNode(), 4);
        binaryTree.addRightNodeRecursively(rootNode,5);
        binaryTree.addLeftNodeRecursively( rootNode.getRightNode(),6);
        binaryTree.addRightNodeRecursively( rootNode.getRightNode(),7);

        Assert.assertEquals(7,binaryTree.size());

        BinaryTree<Integer>.Node<Integer> node  = binaryTree.dfsTravesel(7);
        Assert.assertNotNull(node);
    }

    @Test
    public void testBinaryTreeBFS(){
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        BinaryTree<Integer>.Node<Integer> rootNode = binaryTree.addLeftNode(1);
        binaryTree.addLeftNode( 2); //returns the root node only
        binaryTree.addLeftNode( 3);//returns the root node only
        binaryTree.addRightNodeRecursively( rootNode.getLeftNode(), 4);
        binaryTree.addRightNodeRecursively(rootNode,5);
        binaryTree.addLeftNodeRecursively( rootNode.getRightNode(),6);
        binaryTree.addRightNodeRecursively( rootNode.getRightNode(),7);

        Assert.assertEquals(7,binaryTree.size());

        BinaryTree<Integer>.Node<Integer> node  = binaryTree.bfsTravesel(7);
        Assert.assertNotNull(node);
    }


    @Test
    public void testBinaryTreeDelete(){
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.addLeftNode( 13);
        binaryTree.addLeftNode(12);
        BinaryTree<Integer>.Node<Integer> rootNode = binaryTree.addRightNode(10);
        binaryTree.addLeftNodeRecursively(rootNode.getLeftNode(), 4);
        binaryTree.addRightNodeRecursively(rootNode.getLeftNode(), 19);
        binaryTree.addLeftNodeRecursively(rootNode.getRightNode(), 16);
        binaryTree.addRightNodeRecursively(rootNode.getRightNode(), 9);
//        System.out.println("\n Pre");
//        binaryTree.printTreeInPreOrder();
//        System.out.println("\n In");
//        binaryTree.printTreeInInOrder();
//        System.out.println("\n Post");
//        binaryTree.printTreeInPostOrder();
        binaryTree.delete(12);
        binaryTree.printTreeInPreOrder();

    }
}
