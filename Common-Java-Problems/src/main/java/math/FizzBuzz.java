package math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * math.FizzBuzz
 * <br> Problem Statement
 *
 * Implement math.FizzBuzz till a given number n
 *
 * </br>
 *
 * @author WissenSolutions.
 */
public class FizzBuzz {
    private static final Logger logger = LoggerFactory.getLogger(FizzBuzz.class);

    public static void main(String[] args) {
        fizzBuzz();
    }

    /**
     * Write a program that prints the numbers from 1 to 100.
     * But for multiples of three print "Fizz" instead of the number
     * and for the multiples of five print "Buzz".
     * For numbers which are multiples of both three and five
     * print "math.FizzBuzz"
     */
    private static void fizzBuzz(){
        for(int i =0 ;i<100; i++) {
            if (i % 5 == 0 && i % 3 == 0) {
                logger.info("math.FizzBuzz");
            } else if (i % 5 == 0) {
                logger.info("Buzz");
            } else if (i % 3 == 0) {
                logger.info("Fizz");
            } else {
                logger.info("{}",i);
            }
        }
    }
}
