package tree;

/**
 * BinarySearchTree
 * Learning
 *
 * @author WissenSolutions.
 */
@SuppressWarnings("all")
public class BinarySearchTree<T extends Comparable> implements Tree<T>{

    private Node<T> root;
    @Override
    public void insert(T newElement) {
        root = addNodeRecursively(root, newElement);
    }

    @Override
    public void remove(T valueToBeRemoved) {
        removeNodeRecursively(root, valueToBeRemoved);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void traverse(TraverseMode mode) {
        switch (mode){
            case IN_ORDER: printInOrder(root);
                            break;
            case PRE_ORDER: printInPreOrder(root);
                            break;
            case POST_ORDER: printInPostOrder(root);
                            break;
        }
    }

    @Override
    public int size() {
        return getSizeRecursively(root);
    }

    @Override
    public int getHeight() {
        return getHeightRecursively(root);
    }

    //Private Methods

    private int getHeightRecursively( Node<T> node){
        if(node == null ){
            return 0;
        }
        return 1+ Math.max(getHeightRecursively(node.getLeft()), getHeightRecursively(node.getRight()));
    }
    private int getSizeRecursively(Node<T> node){
        if(node == null){
            return 0;
        }
        return 1 + getSizeRecursively(node.getLeft()) + getSizeRecursively(node.getRight()); // +1 is for self
    }

    private Node<T> addNodeRecursively(Node<T> node, T newValue){
        if( node == null){
            node = new Node<>(newValue);
        } else {
            // Compare element value
            if(newValue.compareTo(node.getData()) > 0){
                // if the new value is greater than node's value, then try in right path
                node.setRight(addNodeRecursively(node.getRight(), newValue));
            } else if(newValue.compareTo(node.getData()) < 0){
                // if the new value is less than node's value, then try in right path
                node.setLeft(addNodeRecursively(node.getLeft(), newValue));
            } else {
                // if the new value is equal, then no need to insert
                return node;
            }
        }
        return node;
    }

    /**
     * Deletion will have three conditions
     * 1. Deleting node is leaf node
     * 2. Deleting node has only one child
     * 3. Deleting node has both childern. ( Need to identify in-order succesor)
     */
    private Node<T> removeNodeRecursively(Node<T> node, T valueToBeRemoved){
        if(node == null){
            return null;
        }
        // First compare the value
        if( node.getData().compareTo( valueToBeRemoved) == 0){
            // if its equal. then validate whether its leaf node or has childern

            if(node.getLeft() == null && node.getRight() == null){ // Leaf node
                return null; // Then simple remove the node.. No further processing is required
            }
            // if left child is null, then replace with right child
            if(node.getLeft() == null) {
                return node.getRight();
            }
            // if right child is null, then replace with left child
            if(node.getRight() == null) {
                return node.getLeft();
            }

            // All above conditions are not met. then this node has both childerns
            // Identify minimun value if right path
            T minValue = getMinValue(node.getRight());
            node.setData(minValue);
            // Next take care of this minValue node childern.
            // Left node handling is not required as min Value should be left most element
            // Only right node handling is required
            node.setRight(removeNodeRecursively(node.getRight(), minValue));
        } else if( node.getData().compareTo( valueToBeRemoved) > 0){
             node.setLeft(removeNodeRecursively(node.getLeft(), valueToBeRemoved));
        } else if( node.getData().compareTo( valueToBeRemoved) < 0){
             node.setRight(removeNodeRecursively(node.getRight(), valueToBeRemoved));
        }

        return node;


    }

    private T getMinValue(Node<T> node){
        T minValue = null;
        while( node!= null){
            minValue = node.getData();
            node = node.getLeft();// minValue will always be in left side
        }
        return minValue;
    }
    // left - > Node value - > Right
    private void printInOrder(Node<T> rootNode){
        if(rootNode == null){
            return;
        }
        printInOrder(rootNode.getLeft());
        System.out.print(rootNode + " --> ");
        printInOrder(rootNode.getRight());
    }

    //  Node value - > left - > Right
    private void printInPreOrder(Node<T> rootNode){
        if(rootNode == null){
            return;
        }
        System.out.print(rootNode + " --> ");
        printInPreOrder(rootNode.getLeft());
        printInPreOrder(rootNode.getRight());
    }
    // left - >  Right  - > Node value
    private void printInPostOrder(Node<T> rootNode){
        if(rootNode == null){
            return;
        }
        printInPostOrder(rootNode.getLeft());
        printInPostOrder(rootNode.getRight());
        System.out.print(rootNode + " --> ");
    }


}
