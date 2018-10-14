package tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * BinaryTree
 * Learning
 *
 * @author WissenSolutions.
 */
@SuppressWarnings("all")
public class BinaryTree<T extends Comparable> {
    private static final Logger logger = LoggerFactory.getLogger(BinaryTree.class);
    private Node<T> rootNode;
    private int count;

    public Node<T> addRightNode(T value){
        Node<T> node = addRightNodeRecursively(rootNode, value);
        if( rootNode == null){
            rootNode = node;
        }
        return node;
    }

    public Node<T> addLeftNode(T value){
        Node<T> node = addLeftNodeRecursively(rootNode, value);
        if( rootNode == null){
            rootNode = node;
        }
        return node;
    }

    public int size(){
        return count;
    }

    /**
     * longest path to the leaf
     */
    public int getHeight(){
        return getHeightRecursively(rootNode);
    }

    /**
     * Length of the path to it's root node
     */
    public int getDepth(T value){
        Node<T> node = dfsTravesel(value);
        if(node != null) {
            return getDepthRecursively(node);
        }
        return 0;
    }

    public Node<T> bfsTravesel(T searchValue){
        if(rootNode == null){
            return null; //Nothing to search
        }
        if(rootNode.value.compareTo(searchValue) == 0){
            System.out.println(searchValue);
            return rootNode;
        }
        Queue<Node<T>> queue = new ConcurrentLinkedQueue<>();
        queue.add(rootNode);
        while(!queue.isEmpty()){
            Node<T> poledNode = queue.poll();
            if(poledNode == null){
                return null;
            }
            System.out.println(poledNode.value);
            if(poledNode.value.compareTo(searchValue) == 0){
                return poledNode;
            }
            if(poledNode.leftNode != null){
                queue.add(poledNode.leftNode);
            }
            if(poledNode.rightNode != null){
                queue.add(poledNode.rightNode);
            }




        }
        return null;
    }
    public Node<T> dfsTravesel(T searchValue){
        if(rootNode == null){
            return null; //Nothing to search
        }
        if(rootNode.value.compareTo(searchValue) == 0){
            System.out.println(searchValue);
            return rootNode;
        }

        Stack<Node<T>> stack = new Stack<>();
        stack.push(rootNode);
        while( !stack.isEmpty()){
            Node<T> popedNode = stack.pop();
            if(popedNode == null){
                return null;
            }
            System.out.println(popedNode.value);
            if(popedNode.value.compareTo(searchValue) == 0){
                return popedNode;
            }

            if(popedNode.rightNode != null){
                stack.push(popedNode.rightNode);
            }
            if(popedNode.leftNode != null){
                stack.push(popedNode.leftNode);
            }





        }
        return null;
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


    // left - > value - > Right
    protected void printTreeInOrderRecursively(Node<T> node){
        if( node == null){
            return ;
        }
        printTreeInOrderRecursively(node.leftNode);
        System.out.println(node.value);
        printTreeInOrderRecursively(node.rightNode);

    }

    // value - > left -> Right
    protected void printTreeInPreOrderRecursively(Node<T> node){
        if( node == null){
            return ;
        }
        System.out.println(node.value);
        printTreeInPreOrderRecursively(node.leftNode);
        printTreeInPreOrderRecursively(node.rightNode);

    }
    //  left -> Right - > value
    protected void printTreeInPostOrderRecursively(Node<T> node){
        if( node == null){
            return ;
        }
        printTreeInPostOrderRecursively(node.leftNode);
        printTreeInPostOrderRecursively(node.rightNode);
        System.out.println(node.value);

    }
    private int getHeightRecursively(Node<T> node){
        if(node == null){
            return 0;
        } else {
            int leftHeight = getHeightRecursively(node.leftNode);
            int rightHeight = getHeightRecursively(node.rightNode);
            return Math.max(leftHeight, rightHeight) + 1;
        }

    }

    private int getDepthRecursively(Node<T> node){
        if(node == null){
            return 0;
        } else {
            int leftNodeDepth = getDepthRecursively(node.leftNode);
            int rightNodeDepth = getDepthRecursively(node.rightNode);
            return Math.max(leftNodeDepth, rightNodeDepth) + 1;
        }

    }
    public Node<T> addRightNodeRecursively(Node<T> root, T value ){
        //root node
        if(root == null){
            root = new Node<>(value);
            count++;
        } else {
            if(root.rightNode == null){
                root.rightNode = new Node<>(value);
                count++;
            } else {
                addRightNodeRecursively(root.rightNode, value);
            }
        }
        return root;
    }

    public Node<T> addLeftNodeRecursively(Node<T> root, T value ){
        //root node
        if(root == null){
            root = new Node<>(value);
            count++;
        } else {
            if(root.leftNode == null){
                root.leftNode = new Node<>(value);
                count++;
            } else {
                addLeftNodeRecursively(root.leftNode, value);
            }
        }

        return root;
    }

    public class Node<T> {
        private T value;
        private Node<T> leftNode;
        private Node<T> rightNode;
        Node(T value){
            this.value = value;
        }

        public void setLeftNode(Node<T> iLeftNode) {
            leftNode = iLeftNode;
        }

        public void setRightNode(Node<T> iRightNode) {
            rightNode = iRightNode;
        }

        public Node<T> getLeftNode() {
            return leftNode;
        }

        public Node<T> getRightNode() {
            return rightNode;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T iValue) {
            value = iValue;
        }
    }
}
