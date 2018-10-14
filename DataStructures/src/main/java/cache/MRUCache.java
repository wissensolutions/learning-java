package cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * MRUCache
 * Learning
 *
 * @author WissenSolutions.
 */
public class MRUCache<K,V> implements Cache<K,V> {
    private static final Logger logger = LoggerFactory.getLogger(MRUCache.class);
    private static final int DEFAULT_CAPACITY= 10;
    private int capacity;

    private final Map<K,Node<K,V>> map = new LinkedHashMap<>();
    private Node<K,V> root;
    private Node<K,V> tail;

    public MRUCache(int iCapacity) {
        capacity = iCapacity;
    }

    public MRUCache() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void put(K key, V value) {
        //Check if its already existing key
        if(map.containsKey(key)){
            Node<K,V> existingNode = map.get(key);
            existingNode.value = value;
            moveNodeToLast(existingNode);
        } else {
            Node<K,V> newNode = new Node<>(key,value);
            if(isEmpty()){ // First Element
                root = newNode;
                tail = newNode;
                map.put(key,newNode);
            } else {
                if(map.size() == capacity){
                    evictNode();
                }
                // Add should be always at end
                tail.nextNode = newNode; //Linking to existing tail node
                newNode.prevNode = tail;
                tail = newNode;
                map.put(key,newNode);
            }
        }
    }

    @Override
    public V get(K key) {
        if(!map.containsKey(key)){
            return null;
        }
        Node<K,V> accessedNode = map.get(key);
        moveNodeToLast(accessedNode);
        return accessedNode.value;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    public void setCapacity(int iCapacity) {
        capacity = iCapacity;
        while(iCapacity<map.size()){
            evictNode();

        }
    }

    private void moveNodeToLast(Node<K,V> accessedNode){

        if(tail == accessedNode){
            //Nothing to move
        } else if(root == accessedNode){
            root = root.nextNode;
            root.prevNode = null;
            tail.nextNode = accessedNode; // Linking to existing tail
            accessedNode.prevNode = tail; // existing node
            tail = accessedNode;
            tail.nextNode = null;
        } else {
            accessedNode.prevNode.nextNode = accessedNode.nextNode;
            tail.nextNode = accessedNode; // Linking to existing tail
            accessedNode.prevNode = tail;
            tail = accessedNode;
            tail.nextNode = null;
        }
    }

    /**
     * in MRU, Always remove Most accessed one. i.e tail
     */
    private void evictNode(){
        map.remove(tail.key);
        tail = tail.prevNode;
        tail.nextNode = null;

    }
    class Node<K,V>{
        private final K key;
        private  V value;
        private Node<K,V> prevNode;
        private Node<K,V> nextNode;

        public Node(K iKey, V iValue) {
            key = iKey;
            value = iValue;
        }
    }
}
