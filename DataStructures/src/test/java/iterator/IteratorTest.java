package iterator;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * IteratorTest
 * Learning
 *
 * @author WissenSolutions.
 */
public class IteratorTest {

    @Test
    public void hoppingIteratorTest(){
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(12);
        list.add(3);
        list.add(27);
        list.add(34);
        list.add(11);
        Iterator<Integer> hopingIterator = new HoppingIterator<>(2,list.iterator());

        Assert.assertEquals(10,hopingIterator.next().longValue());
        Assert.assertEquals(27,hopingIterator.next().longValue());
    }

    @Test
    public void hoppingIterator2Test(){
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(12);
        list.add(3);
        list.add(27);
        list.add(34);
        list.add(11);
        Iterator<Integer> hopingIterator = new HoppingIterator<>(3,list.iterator());

        Assert.assertEquals(10,hopingIterator.next().longValue());
        Assert.assertEquals(34,hopingIterator.next().longValue());
        Assert.assertFalse(hopingIterator.hasNext());
    }

    @Test
    public void inOrderIteratorTest(){
        InOrderTraversal<Integer> iterator = new InOrderTraversal<>();
        iterator.add(1);
        iterator.add(2);
        iterator.add(3);
        iterator.add(4);
        iterator.add(5);
        iterator.add(6);

        Assert.assertEquals(1,iterator.next().longValue());
        Assert.assertEquals(2,iterator.next().longValue());
        Assert.assertEquals(3,iterator.next().longValue());
    }

    @Test
    public void levelOrderIteratorTest(){
        LevelOrderIterator<Integer> iterator = new LevelOrderIterator<>();
        iterator.add(1);
        iterator.add(2);
        iterator.add(3);
        iterator.add(4);
        iterator.add(5);
        iterator.add(6);

        Assert.assertEquals(1,iterator.next().longValue());
        Assert.assertEquals(2,iterator.next().longValue());
        Assert.assertEquals(3,iterator.next().longValue());
    }

    @Test
    public void maxOrderIteratorTest(){
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(12);
        list.add(3);
        list.add(27);
        list.add(34);
        list.add(11);
        Iterator<Integer> iterator = new MaxOrderIterator<>(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 == o2){
                    return 0;
                } else if(o1<o2){
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        Assert.assertEquals(34,iterator.next().longValue());
        Assert.assertEquals(27,iterator.next().longValue());
        Assert.assertEquals(12,iterator.next().longValue());
    }
}
