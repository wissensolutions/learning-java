package set;


/**
 * ArrayBasedSet
 * Learning
 *
 * @author WissenSolutions.
 */
public class ArrayBasedSet<T> {
    private static final int DEFAULT_CAPTACITY = 10;
    private static final int MODULAR_FACTOR = 10;
    private T[] array;
    private int capacity;
    private int size;
    public ArrayBasedSet(int iCapacity){
        this.capacity = iCapacity;
        array = (T[]) new Object[capacity];
    }

    public ArrayBasedSet(){
        this(DEFAULT_CAPTACITY);
    }

    public boolean add(T newElement){
        if(size == capacity){
            increaseSize();
        }
        if(contains(newElement)){
            return false;
        } else {
            array[size] = newElement;
            size++;
            return true;
        }
    }

    private boolean contains(T newElement){
        for (int i=0;i<size;i++) {
            T element =  array[i];
            if(element.equals(newElement)){
                return true;
            }
        }
        return false;
    }

    private void increaseSize(){
        T[] newArray = (T[]) new Object[array.length + MODULAR_FACTOR] ;
        System.arraycopy(array,0,newArray,0,array.length);
        array = newArray;
    }
}
