package arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * AssociateArrayTest
 * Learning
 *
 * @author WissenSolutions.
 */
public class AssociateArrayTest {

    @Test
    public void test(){
        AssociateArray<String,String> associateArray = new AssociateArray<>();

        Assert.assertTrue(associateArray.isEmpty());

        associateArray.put("name1","test");
        associateArray.put("name2","test2");

        Assert.assertEquals("test",associateArray.get("name1"));
        Assert.assertEquals("test2",associateArray.get("name2"));

        Assert.assertFalse(associateArray.isEmpty());
        Assert.assertEquals(2,associateArray.size());

        associateArray.put("name2","test3");
        Assert.assertEquals("test3",associateArray.get("name2"));


    }
}
