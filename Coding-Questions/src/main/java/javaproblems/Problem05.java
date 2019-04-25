package javaproblems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

/**
 * Problem05
 * Learning
 *
 * @author WissenSolutions.
 */
public class Problem05 {
    private static final Logger logger = LoggerFactory.getLogger(Problem05.class);

    public static void main(String[] args) {
//        LRUCacheWithLinkedHashMap<String,String> lruCacheWithLinkedHashMap = new LRUCacheWithLinkedHashMap<>(5);
//        lruCacheWithLinkedHashMap.put("name1","Test1");
//        lruCacheWithLinkedHashMap.put("name2","Test2");
//        lruCacheWithLinkedHashMap.put("name3","Test3");
//        lruCacheWithLinkedHashMap.put("name4","Test4");
//        lruCacheWithLinkedHashMap.put("name5","Test5");
//
//        lruCacheWithLinkedHashMap.get("name3");
//
//        lruCacheWithLinkedHashMap.getCacheValues().entrySet().forEach((k)-> logger.info("Key={}, Value={}",k.getKey(),k.getValue()));
//
//        lruCacheWithLinkedHashMap.put("name6","Test6");
//
//        lruCacheWithLinkedHashMap.getCacheValues().entrySet().forEach((k)-> logger.info("Key={}, Value={}",k.getKey(),k.getValue()));

        LRUCache<String,String> lruCache = new LRUCache<>(5);
        lruCache.put("name1","Test1");
        lruCache.put("name2","Test2");
        lruCache.put("name3","Test3");
        lruCache.put("name4","Test4");
        lruCache.put("name5","Test5");
        //lruCache.getCacheValues().entrySet().forEach((k)-> logger.info("Key={}, Value={}",k.getKey(),k.getValue()));

        lruCache.get("name3");
       // lruCache.getCacheValues().entrySet().forEach((k)-> logger.info("Key={}, Value={}",k.getKey(),k.getValue()));




        lruCache.put("name6","Test6");

        lruCache.getCacheValues().entrySet().forEach((k)-> logger.info("Key={}, Value={}",k.getKey(),k.getValue()));

    }
}
