package bag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * BagImplemetationWithArray
 * Learning
 *
 * @author WissenSolutions.
 */
public class BagImplemetationWithArray<T> implements Bag<T> {
    private static final Logger logger = LoggerFactory.getLogger(BagImplemetationWithArray.class);
    private static final int DEFAULT_SIZE=10;
    private Element<T>[] elements;
    private int size;

    public BagImplemetationWithArray(int iSize) {
        elements = new Element[iSize];
    }

    public BagImplemetationWithArray() {
        this(DEFAULT_SIZE);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(T item) {
        boolean returnValue = false;
        boolean found = false;
        ensureCapacity();
        for(int i=0;i<elements.length;i++){
            if(elements[i]!=null && elements[i].item.equals(item)){
                elements[i].incrementCount();
                returnValue = true;
                found = true;
                break;
            }
        }
        if(!found){
            Element<T> newElement = new Element<>(item);
            elements[size] = newElement;
            size++;
            returnValue = true;
        }
        return returnValue;
    }

    @Override
    public boolean addAll(List<T> items) {
        boolean returnValue = false;
        for (T item :items) {
            returnValue = add(item);
        }
        return returnValue;
    }

    @Override
    public boolean remove(T item) {
        boolean returnValue = false;
        for(int i=0;i<elements.length;i++){
            if(elements[i]!=null && elements[i].item.equals(item)){
                if(elements[i].quantity >1){
                    elements[i].decrementCount();
                } else {
                    System.arraycopy(elements,i+1,elements,i,elements.length-1-i);
                }
                returnValue = true;

                break;
            }
        }
        return returnValue;
    }

    @Override
    public boolean clear() {
        for(int i=0;i<elements.length;i++){
            elements[i] = null;
        }
        size = 0;
        return false;
    }

    @Override
    public int size() {
        int currentSize = 0;
        for(int i=0;i<elements.length;i++){
            if(elements[i]!=null )
                currentSize += elements[i].quantity;
        }
        return currentSize;
    }

    @Override
    public int distinctSize() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elements,size));
    }

    private void ensureCapacity(){
        if(elements.length == size) {
            elements = Arrays.copyOf(elements, elements.length + 10);
        }
    }

    class Element<T>{
        T item;
        int quantity;

        public Element(T iItem) {
            item = iItem;
            quantity = 1;
        }

        void incrementCount(){
            quantity++;
        }

         void decrementCount(){
             quantity--;
        }

        @Override
        public String toString() {
            return item.toString();
        }
    }
}
