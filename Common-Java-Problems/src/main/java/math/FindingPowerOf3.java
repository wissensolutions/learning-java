package math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * math.FindingPowerOf3
 * Learning
 *
 * @author WissenSolutions.
 */
public class FindingPowerOf3 {
    private static final Logger logger = LoggerFactory.getLogger(FindingPowerOf3.class);

    public static void main(String[] args) {
        logger.info("Number ={} is power of 3 = {}",9, isPowerOf3(9));
        logger.info("Number ={} is power of 3 = {}",6, isPowerOf3(6));
        logger.info("Number ={} is power of 3 = {}",9, isPowerOf3_recursive(9));
        logger.info("Number ={} is power of 3 = {}",6, isPowerOf3_recursive(6));
    }

    /**
     * if any number is power of 3, that should be divided by 3
     *
     */
    private static boolean isPowerOf3(int number){
        boolean returnValue = false;
        int remainder = 0;
        while (number != 0){
            /* Remainder should be 0 and then keep dividing by 3
			 * At the end, we should be left with 0. if yes, n is power of three */
            remainder = number % 3;
            if(remainder == 0){
                number = number /3;
                if(number == 1){
                    return true;
                }
            } else {
                return false;
            }
        }
        return returnValue;
    }
    private static boolean isPowerOf3_recursive(int number){
            if( number == 0){
                return false;
            }
            if(number == 1 ){
                return true;
            }

            if(number % 3 == 0){
                number = number /3;
                return isPowerOf3_recursive(number);
            }
            return false;
    }
}
