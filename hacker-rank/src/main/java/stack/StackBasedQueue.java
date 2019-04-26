package stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * @author : Wissen Solutions.
 */
public class StackBasedQueue {
    @Test
    public void testHealthy() {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(42);
        Assert.assertEquals(42,queue.dequeue().intValue());
        queue.enqueue(14);
        Assert.assertEquals(14,queue.peek().intValue());
        queue.enqueue(28);
        Assert.assertEquals(14,queue.peek().intValue());
        queue.enqueue(60);
        queue.enqueue(78);
        Assert.assertEquals(14,queue.dequeue().intValue());
        Assert.assertEquals(28,queue.dequeue().intValue());
    }

    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<>();
        Stack<T> stackOldestOnTop = new Stack<>();

        public void enqueue(T value) { // Push onto newest stack
            stackNewestOnTop.push(value);

        }

        public T peek() {
            if(stackOldestOnTop.isEmpty()) {
                moveElementsFromStack1ToStack2();
            }
            return stackOldestOnTop.peek();
        }

        public T dequeue() {
            if(stackOldestOnTop.isEmpty()) {
                moveElementsFromStack1ToStack2();
            }
            return stackOldestOnTop.pop();
        }
        private void moveElementsFromStack1ToStack2(){
            while(!stackNewestOnTop.isEmpty()) {
                stackOldestOnTop.push(stackNewestOnTop.pop());
            }
        }
    }
}
