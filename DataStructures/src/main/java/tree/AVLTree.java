package tree;

/**
 * AVLTree
 * Learning
 *
 * @author WissenSolutions.
 */
public class AVLTree<T extends Comparable<T>> implements Tree<T>  {

    private Node<T> root;


    @Override
    public void insert(T newElement) {
        root = addNodeRecursively(root, newElement);
    }

    @Override
    public void remove(T valueToBeRemoved) {
        root = removeNodeRecursively(root, valueToBeRemoved);
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
        node.setHeight(getHeightRecursively(node));
        if( !isBalancedNode(getBalanceFactor(node))) {
            node = doBalanceAfterAddition(node , newValue);
        }
        return node;
    }

    /**
     * Will tell you whether node is balanced or not
     */
    private boolean isBalancedNode(int balanceFactor){
        return Math.abs(balanceFactor) <= 1;
    }

    /**
     *   Returns the height difference between left and right
     */
    private int getBalanceFactor(Node<T> currentNode){
        if(currentNode == null){
            return 0;
        }
        return getHeightRecursively(currentNode.getLeft()) - getHeightRecursively(currentNode.getRight());
    }

    /**
     * Will the left side is heavy or not. i.e left children has more nodes than right nodes
     */
    private boolean isLeftHeavy(int balanceFactor){
        if(balanceFactor > 1){
            return true;
        }
        return false;
    }

    /**
     * Will the right side is heavy or not. i.e right children has more nodes than left nodes
     */
    private boolean isRightHeavy(int balanceFactor){
        if(balanceFactor < -1){
            return true;
        }
        return false;
    }

    /**
     * Rotate element in left side i.e anti clock wise
     */
    private Node<T> leftRotate(Node<T> currentNode){
        // Step 1. Assign right node as new root node
        Node<T> newRootNode = currentNode.getRight();
        Node<T> leftOfCurrentNodeRight = newRootNode.getLeft();

        // Step 2. Set current Node as left to new Root node
        newRootNode.setLeft(currentNode);

        //Step 3. Assign left children of new root node as right node to current node
        currentNode.setRight(leftOfCurrentNodeRight);

        // Step4. Re-calculate the heights for both nodes
        currentNode.setHeight(getHeightRecursively(currentNode));
        newRootNode.setHeight(getHeightRecursively(newRootNode));

        return newRootNode;
    }

    /**
     * Rotate element in right side i.e clock wise
     */
    private Node<T> rightRotate(Node<T> currentNode){
        // Step 1. Assign left node as new root node
        Node<T> newRootNode = currentNode.getLeft();
        Node<T> rightOfCurrentNodeLeft = newRootNode.getRight();

        // Step 2. Set current Node as right to new Root node
        newRootNode.setRight(currentNode);

        //Step 3. Assign right children of new root node as left node to current node
        currentNode.setLeft(rightOfCurrentNodeLeft);

        // Step4. Re-calculate the heights for both nodes
        currentNode.setHeight(getHeightRecursively(currentNode));
        newRootNode.setHeight(getHeightRecursively(newRootNode));

        return newRootNode;
    }

    /**
     * does the balance between left and right paths
     * Four cases
     * 1. left rotate
     * 2. Left - right rotate
     * 3. right rotate
     * 4. right- left rotate
     */
    private Node<T> doBalanceAfterAddition(Node<T> currentNode, T newValue){
        int balanceFactor = getBalanceFactor(currentNode);
        if(isLeftHeavy( balanceFactor)){
            // Check whether left rotate is required before right rotate
            // Check whether new Element is placed in right side. if yes, then do left rotate first and then right rotate
            if( currentNode.getData().compareTo(newValue) < 0){
                currentNode.setLeft(leftRotate( currentNode ));
            }
            // right rotate
            return rightRotate(currentNode);
        }
        if(isRightHeavy( balanceFactor)){
            // Check whether right rotate is required before left rotate
            // Check whether new Element is placed in left side. if yes, then do right rotate first and then left rotate
            if( currentNode.getData().compareTo(newValue) > 0){
                currentNode.setRight(rightRotate( currentNode ));
            }
            // left rotate
            return leftRotate(currentNode);
        }
        return currentNode;
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
        if( !isBalancedNode(getBalanceFactor(node))) {
            node = doBalanceAfterRemoval(node);
        }
        return node;


    }

    /**
     * Does the balance after node is removal. Here is also four cases
     * 1. Left rotate
     * 2. left - right rotate
     * 3. Right rotate
     * 4. Right - left rotate
     */
    private Node<T> doBalanceAfterRemoval(Node<T> currentNode) {
        int balanceFactor = getBalanceFactor(currentNode);
        if( isLeftHeavy( balanceFactor )){
            // First check whether left child side is also heavy
            if( getBalanceFactor( currentNode.getLeft()) > 0 ){
                currentNode.setLeft( leftRotate( currentNode.getLeft()));
            }
            // Right rotate
            return rightRotate( currentNode );
        }
        if( isRightHeavy( balanceFactor )){
            // First check whether right child side is also heavy
            if( getBalanceFactor( currentNode.getRight()) > 0 ){
                currentNode.setRight( rightRotate( currentNode.getRight()));
            }
            // Right rotate
            return leftRotate( currentNode );
        }
        return currentNode;
    }

    /**
     * Gets minimum value in the left side path
     */
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