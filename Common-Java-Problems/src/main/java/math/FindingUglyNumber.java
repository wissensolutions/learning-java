package math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * math.FindingUglyNumber
 * Learning
 * <br> Problem Statement :
 *
 * Write a program to check whether a given number is an ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 * Note that 1 is typically treated as an ugly number.
 *
 * @author WissenSolutions.
 */
public class FindingUglyNumber {
    private static final Logger logger = LoggerFactory.getLogger(FindingUglyNumber.class);

    public static void main(String[] args) {
        System.out.println(isUglyNumber(6));
        System.out.println(isUglyNumber(8));
        System.out.println(isUglyNumber(14));
    }

    private static boolean isUglyNumber(int number){
        if(number == 0){
            return false;
        }
        if(number == 1){
            return true;
        }
        if(number % 2 == 0){
            number = number / 2;
            return isUglyNumber(number);
        }
        if(number % 3 == 0){
            number = number / 3;
            return isUglyNumber(number);
        }
        if(number % 5 == 0){
            number = number / 5;
            return isUglyNumber(number);
        }
        return false;
    }
}
