package stacks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import queue.ArrayBasedQueue;

/**
 * ArrayBasedStack
 * Learning
 *
 * @author WissenSolutions.
 */
public class ArrayBasedStack<T> {
    private static final Logger logger = LoggerFactory.getLogger(ArrayBasedStack.class);

    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private T[] array;
    private int capacity = 0;

    @SuppressWarnings("unchecked")
    public ArrayBasedStack(int iSize){
        capacity = iSize;
        array = (T[]) new Object[capacity];
    }

    public ArrayBasedStack(){
        this(DEFAULT_CAPACITY);
    }

    public boolean push(T newValue){
        if(size == capacity){
            throw new StackOverflowError();
        }
       array[size] = newValue;
       size++;
       return true;
    }

    public T pop() throws Exception{
        if(array == null){
            throw  new NoSuchFieldException();
        }

        T newValue = array[size-1];
        array[size-1] = null;
        size--;
        return newValue;
    }

    public T peek() throws Exception{
        if(array == null){
            throw  new NoSuchFieldException();
        }
        return array[size-1];
    }

    public int size() {
        return size;
    }
}
