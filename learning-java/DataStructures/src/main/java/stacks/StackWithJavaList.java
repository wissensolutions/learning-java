package stacks;

import java.util.LinkedList;

/**
 * StackWithJavaList
 * Learning
 *
 * @author WissenSolutions.
 */
public class StackWithJavaList<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void push(T element){
        list.offerLast(element);
    }

    public T pop(){
        return list.pollLast();
    }
    public int size(){
        return list.size();
    }
}
