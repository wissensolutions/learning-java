package math;

import org.junit.Assert;
import org.junit.Test;

/**
 * * <br> Problem Statement :
 *
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *
 * For example:
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 *
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 *
 * @author : Wissen Solutions.
 *
 */
public class AddDigit {
    @Test
    public void testHealthy() {
        //Assert.assertEquals(2, addDigit(38));
        Assert.assertEquals(2, addDigits(38));
    }

    private int addDigit(int number){
        int sum = 0;
        if(number  < 10){
            return number;
        }
        while( number != 0){
            sum +=  number % 10;
            number = number/10;
        }

        return addDigit(sum);
    }

    private int addDigits(int num){
        if(num<=9)
            return num;
        else
        if(num%9==0)
            return 9;
        else
            return num%9;
    }
}
