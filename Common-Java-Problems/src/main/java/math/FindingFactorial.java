package math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;

/**
 * math.FindingFactorial
 * Learning
 * Factorial of Nth number = n * (n-1)!
 * Finding Factorial can be in three different formats
 * 1. Using Recursive
 * 2. Using iterative
 * 3. Using BigNumber
 * @author WissenSolutions.
 */
public class FindingFactorial {
    private static final Logger logger = LoggerFactory.getLogger(FindingFactorial.class);

    public static void main(String[] args) {
        logger.info("Factorial number={}",findFactorialUsingRecursiveApproach(4));
        logger.info("Factorial number={}",findFactorialUsingIterativeApproach(4));
        logger.info("Factorial number={}",findFactorialUsingBigNumberApproach(300));
    }


    /**
     * Method to find factorial of a given number
     * using iterative approach
     * Note : This approach is good for small numbers
     *
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     *
     * @param number
     * @return {@link int}
     */
    private static int findFactorialUsingRecursiveApproach(int number){
        if(number == 1){
            return 1;
        }
        return number * findFactorialUsingRecursiveApproach(number - 1);
    }

    /**
     * Method to find factorial of a given number
     * using iterative approach
     * Note : This approach is good for small numbers
     *
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     *
     * @param number
     * @return {@link int}
     */
    private static int findFactorialUsingIterativeApproach(int number){
        int result = 1;
        for(int i=1;i<=number;i++){
            result = result * i;
        }
        return result;
    }

    /**
     * Method to find factorial of a given number
     * when number is too big
     * Note : This will work for big numbers
     *
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     *
     * @param number
     * @return {@link BigInteger}
     */
    private static BigInteger findFactorialUsingBigNumberApproach(int number){
        BigInteger integer = new BigInteger("1");

        for(int i=1;i<=number;i++){
            integer = integer.multiply(new BigInteger(String.valueOf(i)));
        }
        return integer;
    }
}
