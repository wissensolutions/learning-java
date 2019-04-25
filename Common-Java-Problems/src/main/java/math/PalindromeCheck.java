package math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * math.PalindromeCheck
 * Learning
 * <br> Problem Statement :
 *
 * Find if a given number is a palindrome
 * A palindromic number or numeral palindrome is a number that remains the same when its digits are reversed.
 * For Ex: 16461
 * </br>
 *
 * @author WissenSolutions.
 */
public class PalindromeCheck {
    private static final Logger logger = LoggerFactory.getLogger(PalindromeCheck.class);

    public static void main(String[] args) {
        logger.info("Number = {} is a palindrome number={}", 16461, isPalindrome(16461)); // true
        logger.info("Number = {} is a palindrome number={}", 16463, isPalindrome(16463)); // false
    }

    private static boolean isPalindrome(int number){
        long input = (long) number;
        long reverseNumber = 0;
        while (input != 0 ){
            reverseNumber = reverseNumber * 10 + input %10;
            input = input / 10;
        }

        return reverseNumber == number;
    }
}
