package bag;

import java.util.List;

public interface Bag<T> {

    boolean isEmpty();
    boolean add(T item);
    boolean addAll(List<T> items);
    boolean remove(T item);
    boolean clear();
    int size();
    int distinctSize();

}
