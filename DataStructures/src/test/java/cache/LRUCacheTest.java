package cache;

import org.junit.Assert;
import org.junit.Test;
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
public class LRUCacheTest{
    @Test
    public void test(){
        LRUCache<String,String> cache = new LRUCache<>(5);
        Assert.assertTrue(cache.isEmpty());
        cache.put("name1","test");

        Assert.assertEquals("test",cache.get("name1"));

    }

    @Test
    public void evictionTest(){
        LRUCache<String,String> cache = new LRUCache<>(5);
        Assert.assertTrue(cache.isEmpty());
        cache.put("name1","test");
        cache.put("name2","test");
        cache.put("name3","test");
        Assert.assertEquals("test",cache.get("name1"));
        cache.put("name4","test");
        cache.put("name5","test");
        cache.put("name6","test");

        Assert.assertTrue(cache.get("name2")==null);

    }

}
