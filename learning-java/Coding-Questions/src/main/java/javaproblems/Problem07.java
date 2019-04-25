package javaproblems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * Problem07
 ** <br> Problem Statement :
 *
 * Write a method to shuffle a deck of cards. It must be a
 * perfect shuffle - in other words, each of the 52! permutations
 * of the deck has to be equally likely. Assume that you are
 * given a random number generator which is perfect.
 *
 * </br>
 *
 * @author WissenSolutions.
 */
public class Problem07 {
    private static final Logger logger = LoggerFactory.getLogger(Problem07.class);

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        logger.info("Random array={}", new Problem07().shuffleNumbers(array));
    }

    private int[] shuffleNumbers(int[] inputArr){
        Random random = new Random();
        /* If we have empty deck, no need to shuffle */
        if (inputArr == null || inputArr.length == 0) {
            return new int[0];
        }
        for(int i = 1; i<inputArr.length; i++){
            /* Find a random number to replace */
            int k = random.nextInt(i);
            /* If that is not equal to the current position, swap */
            if(inputArr[k] != inputArr[i]){
                int temp = inputArr[k];
                inputArr[k] = inputArr[i];
                inputArr[i] = temp;
            }
        }
        return inputArr;
    }
}
