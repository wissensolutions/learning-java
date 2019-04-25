package tree;

import org.junit.Test;

/**
 * FindingLCAInNonBST
 * Learning
 *
 * @author WissenSolutions.
 */
public class FindingLCAInNonBST {
    @Test
    public void testFindingLCAInNonBST() {
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
        System.out.println(findLCA(root, node3, node7).getValue());
    }

    private Node<Integer> findLCA(Node<Integer> root, Node<Integer> node1, Node<Integer> node2){
        if(root == null){
            return null;
        }
        if(node1 == null || node2 == null){
            return root;
        }
        Node<Integer> left = findLCA(root.getLeftNode(), node1, node2);
        Node<Integer> right = findLCA(root.getRightNode(), node1, node2);
        if(left != null && right != null){
            return root;
        }
        if(right == null && left == null){
            return null;
        }
        return left == null ? right : left;

    }
}
