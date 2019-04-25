package javaproblems;//package javaproblems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * LRUCacheWithLinkedHashMap
 * Learning
 *
 * @author WissenSolutions.
 */
public class LRUCacheWithLinkedHashMap<K,V> {
    private final int maxCapacity;
    private final LinkedHashMap<K,V> map;

    public LRUCacheWithLinkedHashMap(int iMaxCapacity) {
        maxCapacity = iMaxCapacity;
        map = new CustomLinkedHashMap<K,V>();
    }

    public V get(K iKey){
        return map.get(iKey);
    }

    public void put(K iKey, V iValue){
        map.put(iKey, iValue);
    }

    public Map<K,V> getCacheValues(){
        return map;
    }


    private class CustomLinkedHashMap<K,V> extends LinkedHashMap<K,V> {
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size()> maxCapacity;
        }
    }
}
