package arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * CustomArrayList
 * Learning
 *
 * @author WissenSolutions.
 */
public class CustomArrayList<T>  {
    private static final Logger logger = LoggerFactory.getLogger(CustomArrayList.class);
    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private T[] array;
    private int size;
    private int initialCapacity = 0;
    public CustomArrayList(int initialCapacity) {
        array = (T[]) new Object[initialCapacity];
    }

    public CustomArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public boolean add(T newValue){
        return add(newValue,size);
    }



    public T get(int index){
        return array[index];
    }



    public T remove(int requiredIndex){
        T returnValue = null;
        for(int i=0;i<array.length; i++){
            if(i == requiredIndex){
                returnValue = array[i];
                System.arraycopy(array, i+1, array, i , array.length-1 - i);
                size--;
                break;
            }
        }
        return returnValue;
    }


    public boolean add(T newValue, int requiredIndex){
        boolean isSuccess = false;
        ensureCapacity();

        if(requiredIndex > size-1){
            array[requiredIndex] = newValue;
            isSuccess = true;
        } else {
            System.arraycopy(array, requiredIndex-1, array, requiredIndex , array.length - requiredIndex);
            array[requiredIndex] = newValue;
            isSuccess = true;
        }

        size++;
        return isSuccess;
    }

    public T[] toArray() {
        return Arrays.copyOf(array,size);
    }


    @Override
    public String toString() {
        return "CustomArrayList{" +
                "array=" + Arrays.toString(toArray()) +
                '}';
    }

    private void ensureCapacity(){
        if(size >= array.length){
            array = Arrays.copyOf(array,(int)(array.length*1.5));
        }
    }
}
