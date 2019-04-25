package arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * CustomArrayListTest
 * Learning
 *
 * @author WissenSolutions.
 */
public class CustomArrayListTest {

    @Test
    public void test(){
        CustomArrayList<String> customArrayList = new CustomArrayList<>();

        Assert.assertTrue(customArrayList.isEmpty());
        customArrayList.add("Test1");
        customArrayList.add("Test2");
        customArrayList.add("Test3");
        customArrayList.add("Test4");

        Assert.assertFalse(customArrayList.isEmpty());
        Assert.assertEquals(4,customArrayList.size());
        customArrayList.add("NewValue",2);
        Assert.assertEquals(5,customArrayList.size());

        Assert.assertEquals("NewValue",customArrayList.get(2));

        customArrayList.remove(2);
        Assert.assertEquals(4,customArrayList.size());

        customArrayList.remove(3);
        Assert.assertEquals(3,customArrayList.size());

        System.out.println(customArrayList.toString());
    }
}
