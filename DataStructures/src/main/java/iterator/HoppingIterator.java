package iterator;

import java.util.Iterator;

/**
 * <br> Problem Statement :
 *
 * Implement an iterator that hops specified number of times and then returns the next
 * element after the hop. Note: the iterator always returns the first element as
 * it is, and starts hopping only after the first element.
 *
 * Examples:
 *
 * If the original iterator returns: [1, 2, 3, 4, 5] in order, then the hopping
 * iterator will return [1, 3, 5] in order when the hop value is 1.
 *
 * If the original iterator returns: [1, 2, 3, 4, 5] in order, then the hopping
 * iterator will return [1, 4] in order when the hop value is 2.
 *
 * If the original iterator returns: [1, 2, 3, 4, 5] in order, then the hopping
 * iterator will return [1, 5] in order when the hop value is 3.
 *
 * </br>
 * @author WissenSolutions.
 */
public class HoppingIterator<T> implements Iterator<T> {

    private int hopingValue;
    private boolean isFirstElement = true;
    /* Iterator */
    private final Iterator<T> iterator;

    //Identifier whether hasNext() or hoping increment has run or not
    private T lastItem;

    public HoppingIterator(int iHopingValue, Iterator<T> iterator) {
        hopingValue = iHopingValue;
        this.iterator = iterator;
    }

    @Override
    public void remove(){
        iterator.remove();
    }

    /**
     * Two cases
     * 1. Customer has just run hasNext(). So last element will already be cached
     * 2. Customer just checking whether next element or exist
     */
    @Override
    public boolean hasNext(){
        if(lastItem != null){
            return true;
        }
        if(!isFirstElement){
            for(int i=0;i<hopingValue && iterator.hasNext(); i++){
                iterator.next();
            }
        }
        //Increment and check whether next element exist or not
        if(iterator.hasNext()){
            lastItem = iterator.next();
            isFirstElement = false;
        }
        return lastItem != null;
    }

    @Override
    public T next(){
        if(lastItem == null){
            hasNext();
        }
        T returnValue = lastItem;
        lastItem = null;

        return returnValue;
    }

}
