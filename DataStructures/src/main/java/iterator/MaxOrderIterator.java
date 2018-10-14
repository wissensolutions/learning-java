package iterator;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * MaxOrderIterator
 * Learning
 *
 * @author WissenSolutions.
 */
public class MaxOrderIterator<T> implements Iterator<T> {

    private List<T> list;



    public MaxOrderIterator(List<T> iList, Comparator<T> iComparator) {
         Collections.sort(iList,iComparator);
         list = iList;
    }

    @Override
    public boolean hasNext() {
        if(list.isEmpty()){
            return false;
        }
        return true;
    }

    @Override
    public T next() {
        return list.remove(0);
    }
}
