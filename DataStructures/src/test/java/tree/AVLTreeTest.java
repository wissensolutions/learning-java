package tree;

import org.junit.Test;

/**
 * @author : Wissen Solutions.
 */
public class AVLTreeTest {

    @Test
    public void testHealthy() {
        AVLTree<Integer> avlTree = new AVLTree<>();
        // Left heavy situation
        avlTree.insert(1);
        avlTree.insert(2);
        avlTree.insert(3);
        avlTree.insert(4);
        avlTree.insert(5);
        avlTree.insert(6);
        avlTree.insert(7);
        avlTree.traverse(Tree.TraverseMode.PRE_ORDER);
        //Node{data=4} --> Node{data=2} --> Node{data=1} --> Node{data=3} --> Node{data=6} --> Node{data=5} --> Node{data=7}
    }

    @Test
    public void testDeleteHealthy() {
        AVLTree<Integer> avlTree = new AVLTree<>();
        // Left heavy situation
        avlTree.insert(1);
        avlTree.insert(2);
        avlTree.insert(3);
        avlTree.insert(4);
        avlTree.insert(5);
        avlTree.insert(6);
        avlTree.insert(7);

        avlTree.remove(1);
        avlTree.remove(3);
        avlTree.remove(2);
        avlTree.traverse(Tree.TraverseMode.PRE_ORDER);
        // Node{data=6} --> Node{data=4} --> Node{data=5} --> Node{data=7}
    }

}
