package iterator;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * LevelOrderIterator
 * Learning
 *
 * @author WissenSolutions.
 */
public class LevelOrderIterator<T extends Comparable<T>> implements Iterator<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private Node<T> root;
    private int size;
    private int capacity = 0;
    private List<T> list = new LinkedList<>();
    private boolean shouldTraverseTree = false;
    public LevelOrderIterator(int iSize) {
        capacity = iSize;

    }

    public LevelOrderIterator() {
        this(DEFAULT_CAPACITY);
    }


    public T next(){
        if(!shouldTraverseTree){
            printLevelOrderRecursive(root);
        }
        T returnItem = list.remove(0);
        return returnItem;
    }

    public boolean hasNext(){
        if(!shouldTraverseTree){
            printLevelOrderRecursive(root);
        }
        if(!list.isEmpty()){
            return true;
        } else {
            return false;
        }
    }


    private void printLevelOrderRecursive(Node<T> rootNode){
        if(rootNode == null){
            return;
        }

        list.add(rootNode.element);
        printLevelOrderRecursive(rootNode.left);
        printLevelOrderRecursive(rootNode.right);

        return;
    }

    public void add(T element){
        if(size == capacity){
            throw new UnsupportedOperationException("Tree is full");
        }
        if(root == null){
            root = new Node<>(element);
        } else {
            addRecursive(root,element);
        }
        size++;
    }

    private Node<T> addRecursive(Node<T> rootNode, T element){
        if(element.compareTo(rootNode.element)<0){
            if(rootNode.left != null){
                addRecursive(rootNode.left, element);
            } else {
                rootNode.left = new Node<>(element);
                return rootNode.left;
            }
        } else {
            if(rootNode.right != null){
                addRecursive(rootNode.right, element);
            } else {
                rootNode.right = new Node<>(element);
                return rootNode.right;
            }
        }
        return rootNode;
    }
    class Node<T>{
        private Node<T> left;
        private Node<T> right;
        private T element;

        public Node(T element){
            this.element = element;
        }
    }
}
