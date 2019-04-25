package math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * math.FindingPrimeNumber
 * Learning
 *
 * <br> Problem Statement :
 *
 * Check if a given number is prime or not
 * Prime Number : A number which is divisible by just 1 and itself
 *
 * </br>
 *
 *
 * @author WissenSolutions.
 */
public class FindingPrimeNumber {
    private static final Logger logger = LoggerFactory.getLogger(FindingPrimeNumber.class);

    public static void main(String[] args) {
        logger.info("Number 2 is prime = {}", isPrimeNumber(2));
        logger.info("Number 5 is prime = {}", isPrimeNumber(5));
        logger.info("Number 6 is prime = {}", isPrimeNumber(6));
    }

    /**
     * Method to check if a number is prime
     * Note : If a number is not divisible by any number
     * till n/2, it won't be divisible further.
     *
     * Time Complexity : O(n) => n/2 which is again n
     * Space Complexity : O(1)
     *
     * @param number
     * @return {@link boolean}
     */
    private static boolean isPrimeNumber(int number){
        /* If number is less then 2, return false */
        if (number < 2) {
            return false;
        }
        for (int i= 2; i< number/2; i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}
