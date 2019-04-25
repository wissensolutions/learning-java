package math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * math.FindGreatestCommonDivisor
 *
 * GCD (Greatest Common Divisor) or HCF (Highest Common Factor) of two numbers
 * is the largest number that divides both of them.
 * For ex: 36 = 2 * 2 * 3 * 3
 *      60 = 2 * 2 * 3 * 5
 *      GCD is 2 * 2 * 3 = 12
 *
 * @author WissenSolutions.
 */
public class FindGreatestCommonDivisor {
    private static final Logger logger = LoggerFactory.getLogger(FindGreatestCommonDivisor.class);

    public static void main(String[] args) {
        System.out.println(findGreatestCommonDivisor(15, 17));
        System.out.println(findGreatestCommonDivisor(15, 25));
        System.out.println(findGreatestCommonDivisor(25, 15));
        System.out.println(findGreatestCommonDivisor(25, 0));
    }

    private static int findGreatestCommonDivisor(int a, int b){
        int large = a > b ? a :b ;
        int small = a < b ? a : b;

        // if small is zero then return bigger number
        if(small == 0 ){
            return large;
        }
        int r = large % small;
        return findGreatestCommonDivisor(small,r);
    }
}
