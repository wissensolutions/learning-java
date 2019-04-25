package math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * math.FindingPowerOfN
 * Learning
 * <br> Problem Statement :
 *
 * Find if a given number is power of n
 *
 * </br>
 * @author WissenSolutions.
 */
public class FindingPowerOfN {
    private static final Logger logger = LoggerFactory.getLogger(FindingPowerOfN.class);

    public static void main(String[] args) {
        logger.info("Number ={} is power of 5 = {}",25, isPowerOfN(25,5));
        logger.info("Number ={} is power of 5 = {}",15, isPowerOfN(15,5));
    }

    private static boolean isPowerOfN(int number, int n){
        if( number == 0 ){
            return false;
        }
        if(number == 1){
            return true;
        }
        if( number % n == 0){
            number = number /n ;
            return isPowerOfN(number, n);
        }
        return false;
    }
}
