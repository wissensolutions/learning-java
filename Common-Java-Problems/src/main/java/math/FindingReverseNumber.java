package math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * math.FindingReverseNumber
 * Learning
 * <br> Problem Statement :
 *
 * Given a number n, positive or negative, find the reverse
 *
 * </br>
 * @author WissenSolutions.
 */
public class FindingReverseNumber {
    private static final Logger logger = LoggerFactory.getLogger(FindingReverseNumber.class);

    public static void main(String[] args) {
        logger.info("Number = {}, and corresponding REVERSE_NUMBER = {}", 3245, findReverseNumber(3245) );
    }

    private static int findReverseNumber(int number){
        //Converting to long as we need to multiply with 10 ...
        long input = (long) number;
        long reverseNumber = 0;

        while(input != 0) {
            reverseNumber = reverseNumber * 10 + input % 10;
            input = input / 10;
        }

        //Extra check
        if(reverseNumber > Integer.MAX_VALUE || reverseNumber < Integer.MIN_VALUE){
            throw new IllegalStateException("in valid reverse number");
        }
        return (int)reverseNumber;
    }
}
