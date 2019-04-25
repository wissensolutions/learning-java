package math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * math.AddDigits
 * Learning
 * <br> Problem Statement :
 *
 * Given a non-negative integer num, repeatedly add all its digits.
 *
 * Follow Up :
 * Keep adding until the result has only one digit.
 * For example:
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 *
 * @author WissenSolutions.
 */
public class AddDigits {
    private static final Logger logger = LoggerFactory.getLogger(AddDigits.class);

    public static void main(String[] args) {
        System.out.println(addDigits(38));
        System.out.println(addDigits(28));
    }
    private static int addDigits(int number){
        int sum = 0;
        if(number  < 10){
            return number;
        }
        while(number != 0) {
            sum += number % 10;
            number = number / 10;
        }
        return addDigits(sum);

    }
}
