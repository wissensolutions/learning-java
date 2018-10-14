package cache;

/**
 * Cache
 * Learning
 *
 * @author WissenSolutions.
 */
public interface Cache<K,V> {
    void put(K key, V value);
    V get(K key);
    int size();
    boolean isEmpty();

}
