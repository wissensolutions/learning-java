package stacks;

/**
 * LinkedListBasedStack
 * Learning
 *
 * @author WissenSolutions.
 */
public class LinkedListBasedStack<T> {

    private Node<T> tail;
    private int size;
    private int capacity;

    public LinkedListBasedStack(int iSize) {
        capacity = iSize;
    }

    public boolean push(T element){
        if(size == capacity){
            throw new StackOverflowError();
        }

        if(tail == null){
            tail = new Node<>(element, null);
        } else {
            tail = new Node<>(element,tail);
        }
        tail.value = element;
        size++;
        return true;
    }

    public T pop() throws Exception{
        if(size == 0){
            throw new NoSuchFieldException();
        }
        T returnValue = tail.value;
        tail = tail.prevNode;
        size--;
        return returnValue;
    }
    public int size(){
        return size;
    }
    class Node<T>{
        private T value;
        private Node<T> prevNode;

        public Node(T iValue, Node<T> iPrevNode) {
            value = iValue;
            prevNode = iPrevNode;
        }
    }
}
