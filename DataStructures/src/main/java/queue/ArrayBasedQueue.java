package queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * ArrayBasedQueue
 * Learning
 *
 * @author WissenSolutions.
 */
public class ArrayBasedQueue<T> {
    private static final Logger logger = LoggerFactory.getLogger(ArrayBasedQueue.class);
    private static final int DEFAULT_CAPACITY = 10;

    private T[] array;

    private int size;
    private int capacity = 0;

    //WE need to track of both indices
    private int head = 0;
    private int tail = 0;

    @SuppressWarnings(value="unchecked")
    public ArrayBasedQueue(int size) {
        array = (T[]) new Object[size];
        capacity = size;
    }
    public ArrayBasedQueue() {
        this(DEFAULT_CAPACITY);
        capacity = DEFAULT_CAPACITY;
    }

    public boolean enqueue(T newElement) throws Exception{
        if(size == capacity){
            throw new Exception("Overflow");
        }
        array[size] = newElement;
        tail = tail++;
        size++;
        return true;
    }

    public T dequeue(){
        if(array.length == 0){
            return null;
        }
        T returnElement =  array[head];
        size = size - 1;
        System.arraycopy(array,1,array,0,size);
        return returnElement;
    }

    public int size(){
        return size;
    }

    public T pop(){
        if(array.length == 0){
            return null;
        }
        return array[head];
    }
}
