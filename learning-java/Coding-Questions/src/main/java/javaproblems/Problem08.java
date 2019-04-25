package javaproblems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

/**
 * Problem08
 * <br> Problem Statement :
 *
 * How would you design a stack which, in addition to push and pop,
 * has a function min() which returns a minimum element? Push, pop
 * and min, all should operate in O(1) time
 *
 * </br>
 * 1. Maintaining min element in the stack is not possible directly. So we follow an in-direct approach 
 * For Push :
 * if element is greater than min value
 * directly insert into stack
 *  else
 *  minvalue  = newElement
 *  stack.push ( 2 * minValue - newElement )
 *  So this position,
 * For pop:
 *  if element is
 *
 * @author WissenSolutions.
 */
public class Problem08 {
    private static final Logger logger = LoggerFactory.getLogger(Problem08.class);

    public static void main(String[] args) {
        MyStack sortedStack = new MyStack();
        sortedStack.push(3); // minValue = 3, push 3 to stack
        sortedStack.push(5); // minValue = 3, direct push 5 into stack
        sortedStack.push(2); // minValue = 2, push 2 * 2 - 3
        sortedStack.push(1); // minValue = 1, push 2*1-2
        sortedStack.push(7); // minValue = 1, push 7

        // at this point stack : 3, 5, 1, 0, 7

        sortedStack.getMin(); //minValue should be 1


        // sortedStack.push(10); // minValue =1 , push 10

        // at this point stack : 3, 5, 1, 0, 7, 10

        sortedStack.pop(); //should be 10
        sortedStack.getMin();// should be 1


        sortedStack.pop(); //should be 1
        sortedStack.getMin(); // should be 2

        sortedStack.pop(); //should be 2
        sortedStack.getMin(); // should be 3

    }

    static class MyStack
    {
        Stack<Integer> s;
        Integer minEle;

        // Constructor
        MyStack() { s = new Stack<Integer>(); }

        // Prints minimum element of MyStack
        void getMin()
        {
            // Get the minimum number in the entire stack
            if (s.isEmpty())
                System.out.println("Stack is empty");

                // variable minEle stores the minimum element
                // in the stack.
            else
                System.out.println("Minimum Element in the " +
                        " stack is: " + minEle);
        }

        // prints top element of MyStack
        void peek()
        {
            if (s.isEmpty())
            {
                System.out.println("Stack is empty ");
                return;
            }

            Integer t = s.peek(); // Top element.

            System.out.print("Top Most Element is: ");

            // If t < minEle means minEle stores
            // value of t.
            if (t < minEle)
                System.out.println(minEle);
            else
                System.out.println(t);
        }

        // Removes the top element from MyStack
        void pop()
        {
            if (s.isEmpty())
            {
                System.out.println("Stack is empty");
                return;
            }

            System.out.print("Top Most Element Removed: ");
            Integer t = s.pop();

            // Minimum will change as the minimum element
            // of the stack is being removed.
            if (t < minEle)
            {
                System.out.println(minEle);
                minEle = 2*minEle - t;
            }

            else
                System.out.println(t);
        }

        // Insert new number into MyStack
        void push(Integer x)
        {
            if (s.isEmpty())
            {
                minEle = x;
                s.push(x);
                System.out.println("Number Inserted: " + x);
                return;
            }

            // If new number is less than original minEle
            if (x < minEle)
            {
                s.push(2*x - minEle);
                minEle = x;
            }

            else
                s.push(x);

            System.out.println("Number Inserted: " + x);
        }
    };
}
