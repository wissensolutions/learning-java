package math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * math.FindingHappyNumber
 * Learning
 *
 * <br> Problem Statement :
 *
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number
 * by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are
 * happy numbers.
 * Example: 19 is a happy number
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 * </br>
 * @author WissenSolutions.
 */
public class FindingHappyNumber {
    private static final Logger logger = LoggerFactory.getLogger(FindingHappyNumber.class);

    public static void main(String[] args) {
        logger.info("number 19 is happy number ={}",isHappyNumber(19));
        logger.info("number 19 is happy number ={}",isHappyNumber_withextraSpace(19));
        logger.info("number 20 is happy number ={}",isHappyNumber_withextraSpace(20));
    }

    private static boolean isHappyNumber_withextraSpace(int number){
         Set<Integer> set = new HashSet<>();
        set.add(number);

         while(number != 1){
             int result = 0;
             while(number != 0) {
                 result += (int) Math.pow(number % 10, 2);
                 number = number / 10;
             }
             if(set.contains(result)){
                 return false;
             } else {
                 set.add(result);
                 number = result;
             }
         }
        return true;
    }
    /**
     *
     * we will keep two number slow and fast both initialize from given number, slow is replaced one step at a time and
     * fast is replaced two steps at a time. If they meet at 1, then the given number is Happy Number otherwise not.
     */
    private static boolean isHappyNumber(int number) {
        int slow = number , fast = number;
        do {
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
            if( slow == 1){
                return true;
            }
        }while (slow != fast);

        return false;
    }

    private static int squareSum(int n){
        int sum = 0;
        while(n != 0){
            sum = n % 10 * n %10;
            n = n /10;
        }
        return sum;
    }
}
