package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * * <br> Problem Statement :
 *
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 *
 * Note:
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 *
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 * </br>
 * @author : Wissen Solutions.
 */
public class AddStrings {
    @Test
    public void testHealthy() {
        Assert.assertEquals(357, addingTwoStrings("123", "234"));
    }
    // Simple Approach
    private int addingTwoStrings(String num1, String num2){
        int x = 0; int y = 0;
        int factor = 1;
        for(int i = num1.length()-1; i>=0; i--){
            x += (num1.charAt(i)- '0') * factor;
            factor = factor * 10;
        }
        factor = 1;
        for(int i = num2.length()-1; i>=0; i--){
            y += (num2.charAt(i)- '0') * factor;
            factor = factor * 10;
        }
        return x+y;
    }

}
