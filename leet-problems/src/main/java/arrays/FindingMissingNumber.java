package arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * * <br> Problem Statement :
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * For example,
 * Given nums = [0, 1, 3] return 2.
 *
 * Note: Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 * @author : Wissen Solutions.
 */
public class FindingMissingNumber {
    @Test
    public void testHealthy() {
        Assert.assertEquals(4,findMissingNumber(new int[]{0,1,2,3,5,6,7}));
    }

    private int findMissingNumber(int[] array){
        if(array == null){
            return 0;
        }
        int total = (array.length * ( array.length+1))/2;
        int sum = 0;
        for(int n: array){
            sum += n;
        }
        return total - sum;
    }

}
