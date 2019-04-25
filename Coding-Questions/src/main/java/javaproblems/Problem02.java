package javaproblems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <br> Problem Statement :
 *
 * Write a program to swap two numbers in place.
 * i.e You cannot use temporary variables
 *
 * </br>
 *
 *
 *
 * @author WissenSolutions.
 */
public class Problem02 {
    private static final Logger logger = LoggerFactory.getLogger(Problem02.class);

    public static void main(String[] args) {
        new Problem02().swapWithoutTemp(2,3);
    }

    private void swapWithoutTemp(int a, int b){
        logger.info("Before Swap a={},b={}", a,b);
        a = a+b;
        b = a - b;
        a = a - b;
        logger.info("After Swap a={},b={}", a,b);

    }
}
