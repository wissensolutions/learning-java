package queue;

import java.util.Stack;

/**
 * StackBaseQueue
 * Learning
 *
 * @author WissenSolutions.
 */

/**
 * (1) When calling the enqueue method, simply push the elements into the stack 1.
 (2) If the dequeue method is called, push all the elements from stack 1 into stack 2,
  which reverses the order of the elements. Now pop from stack 2.
 * @param <T>
 */
public class StackBaseQueue<T> {

    private Stack<T> stack1;
    private Stack<T> stack2;

    private int size;
    private int capacity;

    public StackBaseQueue(int size){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    public boolean enqueue(T newElement){
        stack1.push(newElement);
        return true;
    }
    public T dequeue(){
        if(!stack1.isEmpty()){
            moveElementsFromStack1ToStack2();
        }
        return stack2.pop();
    }

    public T peek(){
        if(!stack2.isEmpty()){
            moveElementsFromStack1ToStack2();
        }
        return stack2.peek();
    }

    public int size(){
        return stack1.size() + stack2.size();
    }
    private void moveElementsFromStack1ToStack2(){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }
}
