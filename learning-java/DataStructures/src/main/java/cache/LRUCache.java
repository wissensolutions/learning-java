package cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRUCache
 * Learning
 *
 * @author WissenSolutions.
 */
public class LRUCache<K,V> implements Cache<K,V>  {
    private static final Logger logger = LoggerFactory.getLogger(LRUCache.class);

    private final int capacity;
    private Node<K,V> root;
    private Node<K,V> tail;

    private final Map<K,Node<K,V>> dataMap;


    public LRUCache(int size) {
       dataMap = new LinkedHashMap<>(size);
       capacity = size;
    }

    @Override
    public void put(K key, V value) {
        Node<K,V> newNode = new Node<>(key,value);
        if(root == null){
            root = newNode;
            tail = newNode;
        } else {
            if(dataMap.size() == capacity){
                evict();
            }
            tail.nextNode = newNode;
            newNode.prevNode = tail;
            tail = newNode;
            tail.nextNode=null;
        }
        dataMap.put(key,newNode);
    }

    @Override
    public V get(K key) {
        V returnVal = null;
        Node<K,V> requestedNode = dataMap.get(key);
        moveNodeToLast(requestedNode);
        return requestedNode == null ? returnVal :requestedNode.value;
    }

    @Override
    public int size() {
        return dataMap.size();
    }

    @Override
    public boolean isEmpty() {
        return dataMap.isEmpty();
    }

    class Node<K,V> {
        private K key;
        private V value;
        private Node<K,V> nextNode;
        private Node<K,V> prevNode;
        Node(K iKey, V iValue) {
            key = iKey;
            value = iValue;
        }
    }

    private void evict(){
        if(root == null){
            throw new IllegalStateException("Nothing to delete");
        } else {
            dataMap.remove(root.key);
            root = root.nextNode;

        }
    }

    private void moveNodeToLast(Node<K,V> accessedNode){
        if(accessedNode!=null) {
            if (root == accessedNode && tail == accessedNode) {
                //Nothing to change.
            } else if(root == accessedNode){
                root = accessedNode.nextNode; // Changing root
                tail.nextNode = accessedNode; // Chaining accessedNode as current tail.nextNode
                tail = accessedNode; //Move accessedNode as tail;
            } else {
                accessedNode.prevNode = accessedNode.nextNode;
                tail.nextNode = accessedNode; // Chaining accessedNode as current tail.nextNode
                tail = accessedNode;
            }
            tail.nextNode = null;
            root.prevNode = null;
        }
    }
}
