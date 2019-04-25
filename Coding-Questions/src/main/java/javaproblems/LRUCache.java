package javaproblems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRUCache
 * Learning
 *
 * @author WissenSolutions.
 */
public class LRUCache<K,V> {
    private static final Logger logger = LoggerFactory.getLogger(LRUCache.class);
    /**
     * Default capacity of cache
     */
    private static final int DEFAULT_CAPACITY = 100;

    private Map<K,Node<K,V>> map = new HashMap<>();
    private final int maxCapacity;
    private int size = 0;
    private Node<K,V> head;
    private Node<K,V> tail;

    public LRUCache() {
        maxCapacity = DEFAULT_CAPACITY;
    }

    public LRUCache(int iCapacity) {
        maxCapacity = iCapacity;
    }

    /**
     * 1. return the element
     * 2. Move accessed Node to last Node
     * @param iKey
     * @return
     */
    public V get(K iKey){
        Node<K,V> accessedNode = map.get(iKey);
        moveNodeToLast(accessedNode);
        return accessedNode.value;
    }

    /**
     * Three cases
     * 1. Existing key
     * 2. New Key
     * 3. Exceeded size
     *
     * @param iKey
     * @param value
     */
    public void put(K iKey, V value){
        if (map.containsKey(iKey)){
            Node<K,V> accessedNode = map.get(iKey);
            moveNodeToLast(accessedNode);
        } else {
            if (size == maxCapacity){
                evictNode();
            }
            addNode(iKey,value);
        }

    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return maxCapacity;
    }

    public Map<K, V> getCacheValues() {
        Map<K,V> kvMap = new LinkedHashMap<>();
        Node<K,V> tempNode = head;
        while(tempNode != null){
            kvMap.put(tempNode.getKey(),tempNode.getValue());
            tempNode = tempNode.nextNode;
        }
        return kvMap;
    }

    private void moveNodeToLast(Node<K,V> accessedNode){
        if (tail == accessedNode){
            return;
        }
        if (head == accessedNode){
            tail.nextNode = head;
            head.prevNode = tail;
            head = head.nextNode;
            accessedNode.nextNode = null;
        } else {
            tail.nextNode = accessedNode;
            accessedNode.prevNode.nextNode = accessedNode.nextNode;
            accessedNode.prevNode = tail;
            tail = accessedNode;
            accessedNode.nextNode = null;
        }

    }
    private void addNode(K key, V value ){
        Node<K,V> newNode = new Node<>(key,value);
        if(head == null){
            head = newNode;
            tail = head;
        } else {
            tail.nextNode = newNode;
            newNode.prevNode = tail;
            tail = newNode;
        }
        map.put(key,newNode);
        size++;
    }

    /**
     * eviction should happen from head Node
     */
    private Node<K,V> evictNode(){
        Node<K,V> returnNode = null;
        if(head == null){
            throw new AssertionError("There is nothing to evict");
        } else {
            returnNode = head;
            head = head.nextNode;
            head.prevNode = null;
            size--;
        }
        return returnNode;
    }


    private class Node<K,V>{
        private K key;
        private V value;
        private Node<K,V> prevNode;
        private Node<K,V> nextNode;

        public Node(K iKey, V iValue) {
            key = iKey;
            value = iValue;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K iKey) {
            key = iKey;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V iValue) {
            value = iValue;
        }
    }
}
