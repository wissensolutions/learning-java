package tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * BinarySearchTree
 * Learning
 *
 * @author WissenSolutions.
 */
@SuppressWarnings("all")
public class BinarySearchTree<T extends Comparable> extends BinaryTree<T>{
    private static final Logger logger = LoggerFactory.getLogger(BinarySearchTree.class);

    private Node<T> rootNode;
    private int count ;

    public Node addNode(T value) {

        Node<T> node = addNodeRecursively(rootNode,value);
        if(rootNode == null){
            rootNode = node;
        }
        return node;
    }

    public void deleteNode(T value){
        count--;
        deleteNodeRecursively(rootNode, value);
    }


    @Override
    public int size() {
        return count;
    }

    // left - > value - > Right
    public void printTreeInInOrder(){
        printTreeInOrderRecursively(rootNode);
    }
    //  value -> left - > Right
    public void printTreeInPreOrder(){
        printTreeInPreOrderRecursively(rootNode);
    }
    // left - > Right - > value
    public void printTreeInPostOrder(){
        printTreeInPostOrderRecursively(rootNode);
    }


    @Override
    public Node addLeftNode(T value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Node<T> addRightNodeRecursively(Node<T> root, T value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Node<T> addLeftNodeRecursively(Node<T> root, T value) {
        throw new UnsupportedOperationException();
    }

    private Node<T> deleteNodeRecursively(Node<T> node, T value){
        if( node == null){
            return null;
        }
        if(node.getValue().compareTo(value) < 0){
            node.setRightNode(deleteNodeRecursively(node.getRightNode(), value));
        } else if(node.getValue().compareTo(value) >0){
            node.setLeftNode(deleteNodeRecursively(node.getLeftNode(), value));
        } else {
            if (node.getRightNode() == null) {
                return node.getLeftNode();
            } else if (node.getLeftNode() == null) {
                return node.getRightNode();
            }
            //Get the inorder successor (smallest in the right subtree  )
            /**
             * 1) If right subtree of node is not NULL, then succ lies in right subtree.
             2) If right sbtree of node is NULL, then succ is one of the ancestors.
             */
            T minValue = minValue(node.getRightNode());
            node.setValue(minValue);
            node.setRightNode(deleteNodeRecursively(node.getRightNode(), minValue));
        }
        return node;
    }
    private T minValue(Node<T> node){
        T minValue = node.getValue();
        while(node.getLeftNode() != null){
            node = node.getLeftNode();
            minValue = node.getValue();
        }
        return minValue;
    }

    private Node<T> addNodeRecursively(Node<T> root, T value){
        if( root == null){
            root = new Node<T>(value);
            count++;
        } else {
            if(root.getValue().compareTo(value) > 0){
                if(root.getLeftNode() == null){
                    root.setLeftNode(new Node<T>(value));
                    count++;
                } else {
                    addNodeRecursively(root.getLeftNode(), value);
                }
            }
            if(root.getValue().compareTo(value) < 0){
                if(root.getRightNode() == null){
                    root.setRightNode(new Node<T>(value));
                    count++;
                } else {
                    addNodeRecursively(root.getRightNode(), value);
                }
            }
        }
        return root;
    }
}
