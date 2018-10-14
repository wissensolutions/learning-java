package tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AVLTree
 * Learning
 *
 * @author WissenSolutions.
 */
public class AVLTree<T extends Comparable> {
    //TODO need to implement fully
    private static final Logger logger = LoggerFactory.getLogger(AVLTree.class);
    private Node<T> root;
    public void add(T newValue){
        if(root == null){
            root = new Node<>(newValue);
        } else {
            addRecursive(root, newValue);
        }
    }

    public void printTree(String printType){
        if("INORDER".equalsIgnoreCase(printType)){
            printInorder(root);
        } else if("PREORDER".equalsIgnoreCase(printType)){
            printPreOrder(root);
        } else if("POSTORDER".equalsIgnoreCase(printType)){
            printPostOrder(root);
        }

    }

    public void delete(T value){

    }

    /**
     * Three cases
     * 1. if the node is leaf node
     * 2. if the node has only one child node (left or right)
     * 3. if the node has both left and right
     */
    private Node<T> deleteRecursively(Node<T> rootNode, T valueToBeDeleted){
        if(rootNode == null){
            return null;
        }
        if(rootNode.rightNode == null && rootNode.leftNode == null){
            return rootNode;
        }
        if(valueToBeDeleted.compareTo(rootNode.value)<0){
            deleteRecursively(rootNode.leftNode,valueToBeDeleted);
        }

        if(valueToBeDeleted.compareTo(rootNode.value)>0){
            deleteRecursively(rootNode.rightNode,valueToBeDeleted);
        }

        if(rootNode.rightNode == null) {
            return rootNode.leftNode;
        } else if(rootNode.leftNode == null) {
            return rootNode.rightNode;
        } else  {

            //Find inorder successor and assign it as root node
            T minValue = root.value;
            while(root.leftNode != null){
                minValue = root.value;
                root = root.leftNode;
            }
            root.value = minValue;

            // Delete inorder successor
            root.rightNode = deleteRecursively(root.rightNode,root.value);
        }
        return rootNode;
    }
    /**
     * prints left -> root -> right
     */
    private void printInorder(Node<T> rootNode){
        if (rootNode == null) {
            return;
        }
        printInorder(rootNode.leftNode);
        System.out.println(rootNode.value+" ");
        printInorder(rootNode.rightNode);
    }

    /**
     * prints root -> left -> right
     */
    private void printPreOrder(Node<T> rootNode){
        if (rootNode == null) {
            return;
        }
        System.out.println(rootNode.value+" ");
        printPreOrder(rootNode.leftNode);
        printPreOrder(rootNode.rightNode);
    }

    /**
     * prints  left -> right -> root
     */
    private void printPostOrder(Node<T> rootNode){
        if (rootNode == null) {
            return;
        }
        printPostOrder(rootNode.leftNode);
        printPostOrder(rootNode.rightNode);
        System.out.println(rootNode.value+" ");


    }


    private Node<T> addRecursive(Node<T> rootNode, T newValue){

        if(newValue != null && newValue.compareTo(rootNode.value)<0){
            if(rootNode.leftNode!=null){
               return addRecursive(rootNode.leftNode,newValue);
            } else {
                root.leftNode = new Node<>(newValue);
            }
        } else {
            if(rootNode.rightNode!=null){
                return addRecursive(rootNode.rightNode,newValue);
            } else {
                rootNode.rightNode =  new Node<>(newValue);
            }
        }
        return rootNode;
    }
    class Node<T> {
        private T value;
        private Node<T> leftNode;
        private Node<T> rightNode;

        public Node(T iValue) {
            value = iValue;
        }
    }
}
