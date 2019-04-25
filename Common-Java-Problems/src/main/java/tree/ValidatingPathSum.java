package tree;

import org.junit.Test;

/**
 * ValidatingPathSum
 * Learning
 *
 * @author WissenSolutions.
 */
public class ValidatingPathSum {
    @Test
    public void testValidatingPathSum() {
        Node<Integer> root = new Node<>(3);
        Node<Integer> node1 = new Node<>(6);
        Node<Integer> node2 = new Node<>(8);
        Node<Integer> node3 = new Node<>(2);
        Node<Integer> node4 = new Node<>(11);
        Node<Integer> node5 = new Node<>(13);
        Node<Integer> node6 = new Node<>(9);
        Node<Integer> node7 = new Node<>(5);
        Node<Integer> node8 = new Node<>(7);
        root.setLeftNode(node1);
        root.setRightNode(node2);
        node1.setLeftNode(node3);
        node1.setRightNode(node4);
        node4.setLeftNode(node6);
        node4.setRightNode(node7);
        node2.setRightNode(node5);
        node5.setLeftNode(node8);
        System.out.println(hasSumNode(root, 25));
        System.out.println(hasSumNode(root, 26));
    }

    private boolean hasSumNode(Node<Integer> root, int number){
        if(root == null){
            return false;
        }
        //Leaf node
        if(root.getValue() == number && root.getLeftNode() == null && root.getRightNode()== null){
            return true;
        }
        return hasSumNode(root.getLeftNode(), number-root.getValue()) || hasSumNode(root.getRightNode(), number-root.getValue());
    }
}
