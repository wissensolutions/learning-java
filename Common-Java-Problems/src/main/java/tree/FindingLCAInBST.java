package tree;

import org.junit.Test;

/**
 * FindingLCAInBST
 * Learning
 *
 * @author WissenSolutions.
 */
public class FindingLCAInBST {
    @Test
    public void testFindingLCAInBST() {
        Node<Integer> root1 = new Node<>(4);
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(5);
        Node<Integer> node3 = new Node<>(8);
        root1.setLeftNode(node1);
        root1.setRightNode(node2);
        node2.setRightNode(node3);
        System.out.println(findLCA(root1, node1, node3).getValue());
    }

    private Node<Integer> findLCA(Node<Integer> root, Node<Integer> node1, Node<Integer> node2){
        if( root == null){
            return null;
        }
        // If both n1 and n2 are smaller than root, then LCA lies in left
        if(root.getValue() > node1.getValue() && root.getValue()> node2.getValue()){
            findLCA(root.getLeftNode(), node1, node2);
        }

        // If both n1 and n2 are greater than root, then LCA lies in right
        if(root.getValue() < node1.getValue() && root.getValue()< node2.getValue()){
            findLCA(root.getRightNode(), node1, node2);
        }
        return root;
    }
}
