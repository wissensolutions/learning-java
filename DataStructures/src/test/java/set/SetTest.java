package set;

import org.junit.Assert;
import org.junit.Test;

/**
 * SetTest
 * Learning
 *
 * @author WissenSolutions.
 */
public class SetTest {

    @Test
    public void arraySetTest(){
        ArrayBasedSet<Integer> arrayBasedSet = new ArrayBasedSet<>();
        Assert.assertTrue(arrayBasedSet.add(10));
        Assert.assertFalse(arrayBasedSet.add(10));
        Assert.assertTrue(arrayBasedSet.add(20));
        Assert.assertTrue(arrayBasedSet.add(30));
    }
}
