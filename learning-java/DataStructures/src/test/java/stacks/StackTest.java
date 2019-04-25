package stacks;

import org.junit.Assert;
import org.junit.Test;
import queue.ArrayBasedQueue;
import queue.LinkedListBasedQueue;

/**
 * StackTest
 * Learning
 *
 * @author WissenSolutions.
 */
public class StackTest {
    @Test
    public void stackTestWithArray() throws Exception{
        ArrayBasedStack<Integer> queue = new ArrayBasedStack<>(10);
        queue.push(10);
        queue.push(3);
        queue.push(27);
        queue.push(34);
        queue.push(12);
        queue.push(11);
        Assert.assertEquals(6,queue.size());
        Assert.assertEquals(11, queue.pop().intValue());
        Assert.assertEquals(12, queue.pop().intValue());
        Assert.assertEquals(34, queue.pop().intValue());
        Assert.assertEquals(27, queue.pop().intValue());
        Assert.assertEquals(3, queue.pop().intValue());
    }

    @Test
    public void stackTestWithLinkedList() throws Exception{
        LinkedListBasedStack<Integer> queue = new LinkedListBasedStack<>(10);
        queue.push(10);
        queue.push(3);
        queue.push(27);
        queue.push(34);
        queue.push(12);
        queue.push(11);
        Assert.assertEquals(6,queue.size());
        Assert.assertEquals(11, queue.pop().intValue());
        Assert.assertEquals(12, queue.pop().intValue());
        Assert.assertEquals(34, queue.pop().intValue());
        Assert.assertEquals(27, queue.pop().intValue());
        Assert.assertEquals(3, queue.pop().intValue());
    }

    @Test
    public void stackTestWithList() throws Exception{
        StackWithJavaList<Integer> queue = new StackWithJavaList<>();
        queue.push(10);
        queue.push(3);
        queue.push(27);
        queue.push(34);
        queue.push(12);
        queue.push(11);
        Assert.assertEquals(6,queue.size());
        Assert.assertEquals(11, queue.pop().intValue());
        Assert.assertEquals(12, queue.pop().intValue());
        Assert.assertEquals(34, queue.pop().intValue());
        Assert.assertEquals(27, queue.pop().intValue());
        Assert.assertEquals(3, queue.pop().intValue());
    }
}
