package bag;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * BagImplementationWithLinkedListTest
 * Learning
 *
 * @author WissenSolutions.
 */
public class BagImplementationWithLinkedListTest {
    @Test
    public void test(){
        Bag<String> bag = new BagImplementationWithLinkedList<>();
        Assert.assertTrue(bag.isEmpty());
        bag.add("A");
        bag.add("B");
        Assert.assertTrue(bag.size() == 2);
        bag.add("A");
        bag.add("C");
        Assert.assertTrue(bag.size() == 4);
        bag.remove("A");
        Assert.assertTrue(bag.size() == 3);
        bag.remove("B");
        Assert.assertTrue(bag.size() == 2);
    }

    @Test
    public void testWithAll(){
        Bag<String> bag = new BagImplementationWithLinkedList<>();
        Assert.assertTrue(bag.isEmpty());
        bag.addAll(Arrays.asList("A","B","C","D"));
        Assert.assertTrue(bag.size() == 4);
        bag.add("A");
        bag.add("L");
        Assert.assertTrue(bag.size() == 6);
        bag.remove("A");
        Assert.assertTrue(bag.size() == 5);
        bag.remove("B");
        Assert.assertTrue(bag.size() == 4);
        bag.clear();
        Assert.assertTrue(bag.isEmpty());
    }

    @Test
    public void toStringTest(){
        Bag<String> bag = new BagImplementationWithLinkedList<>();
        Assert.assertTrue(bag.isEmpty());
        bag.addAll(Arrays.asList("A","B","C","D"));
        Assert.assertTrue(bag.size() == 4);
        bag.add("A");
        bag.add("L");
        Assert.assertTrue("{A}{B}{C}{D}{L}".equals(bag.toString()));
    }

    @Test
    public void sizeTest(){
        Bag<String> bag = new BagImplementationWithLinkedList<>();
        Assert.assertTrue(bag.isEmpty());
        bag.addAll(Arrays.asList("A","B","C","D"));
        Assert.assertTrue(bag.size() == 4);
        bag.add("A");
        bag.add("L");
        Assert.assertEquals(6,bag.size());
        Assert.assertEquals(5,bag.distinctSize());
    }
}
