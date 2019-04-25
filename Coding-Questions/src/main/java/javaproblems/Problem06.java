package javaproblems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Problem06
 * * <br> Problem Statement :
 *
 * Write a function that adds two numbers. You should not
 * use + or any other arithmetic operators.
 *
 * </br>
 *
 * @author WissenSolutions.
 */
public class Problem06 {
    private static final Logger logger = LoggerFactory.getLogger(Problem06.class);

    public static void main(String[] args) {
        new Problem06().add(6600,8600);
        new Problem06().addWithRecursive(6600,8600);
    }

    /**
     * Using Iterative Approach
     * Sum :
     * Carry: is shifted by one so that adding it to x gives the required sum
     */
    private int add(int a, int b){
        int sum = 0;
        while ( b != 0) {
            sum = a ^ b;
            int carry = (a & b) << 1;
            logger.info("SUM={}, CARRY={}", sum, carry);
            a = sum;
            b = carry;
        }
        return sum;
    }

    /**
     * Using recursive Approach
     * Sum :
     * Carry: is shifted by one so that adding it to x gives the required sum
     */
    private int addWithRecursive(int a, int b) {
        if(b == 0){
            return a;
        }
        int sum = 0;
        sum = a ^ b;
        int carry = (a & b) << 1;
        logger.info("SUM={}, CARRY={}", sum, carry);
        addWithRecursive(sum,carry);
        return sum;
    }
}
