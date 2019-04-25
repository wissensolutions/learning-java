package cache;

import org.junit.Assert;
import org.junit.Test;

/**
 * LRUCache
 * Learning
 *
 * @author WissenSolutions.
 */
public class MRUCacheTest {
    @Test
    public void test(){
        MRUCache<String,String> cache = new MRUCache<>(5);
        Assert.assertTrue(cache.isEmpty());
        cache.put("name1","test");

        Assert.assertEquals("test",cache.get("name1"));

    }

    @Test
    public void evictionTestWhenAccessed(){
        MRUCache<String,String> cache = new MRUCache<>(5);
        Assert.assertTrue(cache.isEmpty());
        cache.put("name1","test");
        cache.put("name2","test");
        cache.put("name3","test");
        cache.put("name4","test");
        cache.put("name5","test");
        Assert.assertEquals("test",cache.get("name1"));
        cache.put("name6","test");

        Assert.assertTrue(cache.get("name1")==null);
        Assert.assertFalse(cache.get("name2")==null);

    }

    @Test
    public void evictionTestWhenAccessedAndInserted(){
        MRUCache<String,String> cache = new MRUCache<>(5);
        Assert.assertTrue(cache.isEmpty());
        cache.put("name1","test");
        cache.put("name2","test");
        cache.put("name3","test");
        Assert.assertEquals("test",cache.get("name1"));
        cache.put("name4","test");
        cache.put("name5","test");
        cache.put("name6","test");

        Assert.assertTrue(cache.get("name5")==null);
        Assert.assertFalse(cache.get("name1")==null);

    }

    @Test
    public void evictionTestWhenCapacityIncreased(){
        MRUCache<String,String> cache = new MRUCache<>(5);
        Assert.assertTrue(cache.isEmpty());
        cache.put("name1","test");
        cache.put("name2","test");
        cache.put("name3","test");
        cache.put("name4","test");
        cache.put("name5","test");
        cache.setCapacity(10);
        cache.put("name6","test");

        Assert.assertTrue(cache.size() == 6); //Nothing is removed
        Assert.assertFalse(cache.get("name1")==null);
        Assert.assertFalse(cache.get("name2")==null);

    }

    @Test
    public void evictionTestWhenCapacityDecreased(){
        MRUCache<String,String> cache = new MRUCache<>(5);
        Assert.assertTrue(cache.isEmpty());
        cache.put("name1","test");
        cache.put("name2","test");
        cache.put("name3","test");
        cache.put("name4","test");
        cache.put("name5","test");
        cache.setCapacity(3);
        cache.put("name6","test");

        Assert.assertTrue(cache.size() == 3); //Nothing is removed
        Assert.assertTrue(cache.get("name4")==null);
        Assert.assertTrue(cache.get("name4")==null);

    }
}
