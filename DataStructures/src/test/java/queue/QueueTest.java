package queue;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;


/**
 * queue.QueueTest
 * Learning
 *
 * @author WissenSolutions.
 */
public class QueueTest {
    private static final Logger logger = LoggerFactory.getLogger(QueueTest.class);
    @Test
    public void queueTestWithArray() throws Exception{
        ArrayBasedQueue<Integer> queue = new ArrayBasedQueue<>(10);
        queue.enqueue(10);
        queue.enqueue(3);
        queue.enqueue(27);
        queue.enqueue(34);
        queue.enqueue(12);
        queue.enqueue(11);
        Assert.assertEquals(6,queue.size());
        Assert.assertEquals(10, queue.dequeue().intValue());
        Assert.assertEquals(3, queue.dequeue().intValue());
        Assert.assertEquals(27, queue.dequeue().intValue());
        Assert.assertEquals(34, queue.dequeue().intValue());
        Assert.assertEquals(12, queue.dequeue().intValue());
    }

    @Test
    public void queueTestWithLinkedList() throws Exception{
        LinkedListBasedQueue<Integer> queue = new LinkedListBasedQueue<>(10);
        queue.enqueue(10);
        queue.enqueue(3);
        queue.enqueue(27);
        queue.enqueue(34);
        queue.enqueue(12);
        queue.enqueue(11);

        Assert.assertEquals(6,queue.size());

        Assert.assertEquals(10, queue.dequeue().intValue());
        Assert.assertEquals(3, queue.dequeue().intValue());
        Assert.assertEquals(27, queue.dequeue().intValue());
        Assert.assertEquals(34, queue.dequeue().intValue());
        Assert.assertEquals(12, queue.dequeue().intValue());
    }

    @Test
    public void queueTestWithStack() throws Exception{
        StackBaseQueue<Integer> queue = new StackBaseQueue<>(10);
        queue.enqueue(10);
        queue.enqueue(3);
        queue.enqueue(27);
        queue.enqueue(34);
        queue.enqueue(12);
        queue.enqueue(11);

        Assert.assertEquals(6,queue.size());

        Assert.assertEquals(10, queue.dequeue().intValue());
        Assert.assertEquals(3, queue.dequeue().intValue());
        Assert.assertEquals(27, queue.dequeue().intValue());
        Assert.assertEquals(34, queue.dequeue().intValue());
        Assert.assertEquals(12, queue.dequeue().intValue());
    }

    @Test
    public void queueTestWithDeQueue() throws Exception{
        DeQueue<Integer> queue = new DeQueue<>(10);
        queue.addFirst(10);
        queue.addFirst(12);
        queue.addFirst(3);
        queue.addLast(27);
        queue.addLast(34);
        queue.addLast(11);
        Iterator iterator = queue.getIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        Assert.assertEquals(6,queue.size());
        Assert.assertEquals(3,queue.removeFirst().longValue());
        Assert.assertEquals(11,queue.removeLast().longValue());
        Assert.assertEquals(4,queue.size());
    }
}
