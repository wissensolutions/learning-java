package stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Queue;
import java.util.Stack;

/**
 * @author : Wissen Solutions.
 */
public class MinStack {
    @Test
    public void testHealthy() {
//        MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        minStack.getMin();
//        minStack.pop();
//        minStack.top();
//        Assert.assertEquals(-2,minStack.getMin());

        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        minStack.top();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.push(2147483647);
        minStack.top();
        minStack.getMin();
        minStack.push(-2147483648);
        minStack.top();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();

    }

    private Stack<Integer> stack = new Stack<>();
    private  int minValue = Integer.MAX_VALUE;

    public void push(int x){
        if( x<= minValue){
            stack.push(minValue);
            minValue = x;
        }
        stack.push(x);
    }
    public void pop(){
        if(stack.pop() == getMin()){
            minValue = stack.pop();
        }

    }
    public void top(){
        stack.peek();
    }
    public int getMin(){
        return minValue;
    }

}
