package queue;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * DeQueue
 * Learning
 *
 * @author WissenSolutions.
 */
public class DeQueue<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private Node<T> root;
    private Node<T> tail;
    private int size;
    private int capacity;

    public DeQueue(int capacity){
        this.capacity = capacity;
    }

    public DeQueue(){
        this(DEFAULT_CAPACITY);
    }

    public void addFirst(T newElement){
        Node<T> newNode = new Node<>(newElement);
        if(isEmpty()){
            root = newNode;
            tail = root;
        } else {
            root.prev = newNode;
            newNode.next = root;
            root = newNode;
        }

        size++;
    }

    public void addLast(T newElement){
        Node<T> newNode = new Node<>(newElement);
        if(isEmpty()){
            root = newNode;
            tail = root;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public T  removeFirst(){
        T returnItem = null;
        if(isEmpty()){
            throw new UnsupportedOperationException("Queue is empty");
        }
        returnItem = root.element;
        if( root == tail){
            root = tail = null;
        } else {
            root = root.next;
            root.prev = null;
        }
        size--;
        return returnItem;
    }

    public T removeLast(){
        T returnItem = null;
        if(isEmpty()){
            throw new UnsupportedOperationException("Queue is empty");
        }
        returnItem = tail.element;
        if( root == tail){
            root = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return returnItem;
    }

    public int size(){
        return size;
    }

    public Iterator<T> getIterator(){
        return new DequeueIterator<>(root);
    }

    private boolean isEmpty(){
        return root == null && tail == null;
    }
    class Node<T>{
        private T element;
        private Node<T> prev;
        private Node<T> next;

        public Node(T iElement) {
            element = iElement;
        }
    }

    class DequeueIterator<T> implements Iterator<T> {
        private Node<T> current;

        public DequeueIterator(Node<T> iCurrent) {
            current = iCurrent;
        }

        @Override
        public boolean hasNext() {
            return current!= null;
        }

        @Override
        public T next() {
            T item = current.element;
            current = current.next;
            return item;
        }

        @Override
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }
}
