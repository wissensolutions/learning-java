package stacks;

import queue.LinkedListBasedQueue;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * QueueBasedStack
 * Learning
 *
 * @author WissenSolutions.
 */
public class QueueBasedStack<T> {
    //TODO need to implement 

    private LinkedListBasedQueue<T> queue1;
    private LinkedListBasedQueue<T> queue2;
    private int size;
    private int capacity;
    public QueueBasedStack(int size){
        queue1 = new LinkedListBasedQueue<>();
        queue2 = new LinkedListBasedQueue<>();
        capacity = size;

    }
    public void push(T element){
        if(capacity == size){
            throw new StackOverflowError();
        }
        queue1.enqueue(element);
        size++;
    }
    public T pop(){
        if(queue1 == null){
            throw new NoSuchElementException();
        }
        moveElementsFromQueue1ToQueue2();
        T returnValue = queue2.dequeue();
        size--;
        return returnValue;
    }

    public int size(){
        return queue1.size()+queue2.size();
    }

    private void moveElementsFromQueue1ToQueue2(){
        while(queue1.size() != 0){
            queue2.enqueue(queue1.dequeue());
        }
    }
}
