package tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * CreateMirrorImageBinaryTree
 * Learning
 *
 * @author WissenSolutions.
 */
public class CreateMirrorImageBinaryTree {
    @Test
    public void testCreateMirrorImageTree() {
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

        //Node { value = 6 } --> Node { value = 4 } --> Node { value = 3 } --> Node { value = 5 } --> Node { value = 9 } --> Node { value = 8 } --> Node { value = 10 }
        new PrintTree<Integer>().traverse(PrintTree.TraverseMode.PRE_ORDER, root);

        System.out.println("\n\n After mirror image \n ");
        //Node { value = 6 } --> Node { value = 9 } --> Node { value = 10 } --> Node { value = 8 } --> Node { value = 4 } --> Node { value = 5 } --> Node { value = 3 }
        new PrintTree<Integer>().traverse(PrintTree.TraverseMode.PRE_ORDER, createMirrorImage(root));
    }

    private Node<Integer> createMirrorImage(Node<Integer> currentNode){
        if( currentNode == null){
            return null;
        }
        Node<Integer> leftNode = currentNode.getLeftNode();
        Node<Integer> rightNode = currentNode.getRightNode();
        currentNode.setRightNode(createMirrorImage(leftNode));
        currentNode.setLeftNode(createMirrorImage(rightNode));
        return currentNode;
    }

}
