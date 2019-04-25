package arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Associative Arrays in Java :
 *
 * Associative arrays are data structure, where keys are associated with some sort
 * of values. Though java does not support associative arrays, but same functionality
 * can be achieved through HashMap or HashTable.
 * Below is the replica of HashMap just names as associative arrays.
 *
 * @author WissenSolutions.
 */
public class AssociateArray<K,V> {
    private static final Logger logger = LoggerFactory.getLogger(AssociateArray.class);

    private static final int DEFAULT_SIZE = 100;

    private final Entry<K,V>[] entryTable;
    private  int size = 0;

    public AssociateArray(int size) {
        entryTable = new Entry[size];
    }

    public AssociateArray() {
        this(DEFAULT_SIZE);
    }

    /**
     * 1. entryTable is empty
     * 2. if the key is existing one
     * 3. if the key is new one
     * @param key the key
     * @param value the value
     */
    public void put(K key, V value){
        Entry requestedEntry = new Entry(key,value);
        int hash = key.hashCode();
        int bucket = getBucket(hash);
        Entry bucketEntry = entryTable[bucket];
        if(bucketEntry == null){
            entryTable[bucket] = requestedEntry;
            size++;
        } else {
            // loop through entry table and see if the key is an existing one

            boolean isNewKey = true;
            while(bucketEntry != null){
                if(bucketEntry.getKey().equals(key)){
                    requestedEntry.setNextEntry(bucketEntry.getNextEntry());
                    //overrides existing value
                    entryTable[bucket] = requestedEntry;
                    isNewKey = false;
                    break;
                } else if(bucketEntry.getNextEntry()!= null){
                    //Continue further until key found
                    bucketEntry = bucketEntry.getNextEntry();
                }
            }
            //Key is not existing one. So adding it as new entry
            if(isNewKey){
                bucketEntry.setNextEntry(requestedEntry);
                size++;
            }
        }
    }

    public V get(K key){
        V returnValue = null;
        int hash = key.hashCode();
        int bucket = getBucket(hash);

        Entry<K,V> bucketEntry = entryTable[bucket];
        while(bucketEntry != null){
            if(bucketEntry.getKey().equals(key)){
                returnValue = bucketEntry.getValue();
                break;
            } else {
                //Continue further until key found
                bucketEntry = bucketEntry.getNextEntry();
            }
        }
        return returnValue;
    }


    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    private int getBucket(int hashCode){
        return (hashCode % entryTable.length);
    }



    private class Entry<K,V>{
        private K key;
        private V value;
        private Entry<K,V> nextEntry;

        Entry() {
        }

        Entry(K iKey, V iValue) {
            key = iKey;
            value = iValue;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Entry getNextEntry() {
            return nextEntry;
        }

        public void setNextEntry(Entry iNextEntry) {
            nextEntry = iNextEntry;
        }
    }

}
