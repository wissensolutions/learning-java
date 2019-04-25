package math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * math.FindingPowerOf2
 * Learning
 * <br> Problem Statement :
 *
 * Find if a given number is power of 2
 *
 * </br>
 *
 * @author WissenSolutions.
 */
public class FindingPowerOf2 {
    private static final Logger logger = LoggerFactory.getLogger(FindingPowerOf2.class);

    public static void main(String[] args) {
        logger.info("Number = {} is power of 2={}", 4, isPowerOf2(4));
        logger.info("Number = {} is power of 2={}", 5, isPowerOf2(5));

    }

    /**
     * if number is zero, then it will return true, to avoid this case added not null check
     * & converts all the number into bits
     * so For ex: 4 = 100
     *             4-1 = 3 = 011
     *             100 & 011 = 0
     *
     */
    private static boolean isPowerOf2(int number){
        return number != 0 && (number & (number -1)) == 0 ;
    }
}
