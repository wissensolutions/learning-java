package tree;

/**
 * @author : Wissen Solutions.
 */
public interface Tree<T> {

    void insert(T newElement);

    void remove(T valueToBeRemoved);

    boolean isEmpty();

    void traverse(TraverseMode mode);

    int size();

    int getHeight();

    enum TraverseMode {
        PRE_ORDER, IN_ORDER, POST_ORDER
    }
}
