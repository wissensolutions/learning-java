package queue;

import java.util.NoSuchElementException;

/**
 * LinkedListBasedQueue
 * Learning
 *
 * @author WissenSolutions.
 */
public class LinkedListBasedQueue<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Node<T> root;
    private Node<T> tail;
    private int capacity;

    public LinkedListBasedQueue(int iSize) {
        capacity = iSize;
    }

    public LinkedListBasedQueue() {
        this(DEFAULT_CAPACITY);
    }
    public boolean enqueue(T newElement){
        Node<T> newNode = new Node<>(newElement);
        if(root == null){
            root = newNode;
            tail = root;
        } else {
            tail.nextNode = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    public T dequeue(){
        if(root == null){
            throw new NoSuchElementException();
        }
        T returnElement = root.element;
        root = root.nextNode;
        size--;
        return returnElement;
    }
    public T peek(){
        if(root == null){
            throw new NoSuchElementException();
        }
        return root.element;
    }

    public int size(){
        return size;
    }
    class Node<T>{
        T element;
        Node<T> nextNode;

        public Node(T iElement) {
            element = iElement;
        }
    }
}
