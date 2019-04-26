package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 *  * <br> Problem Statement :
 *
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * </br>
 *
 * @author : Wissen Solutions.
 */
public class PlusOneArray {
    @Test
    public void testHealthy() {
        int[] expectedArray = new int[]{1,0,0,0};
        Assert.assertEquals(Arrays.toString(expectedArray), Arrays.toString(addIntegerToArray(new int[]{9,9,9})));
    }

    private int[] addIntegerToArray(int[] digits){

        for(int i= digits.length-1; i>0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newArray = new int[digits.length+1];
        newArray[0] = 1;
        // By default, int array will have zeros for non-assigned numbers
        return newArray;
    }



}
