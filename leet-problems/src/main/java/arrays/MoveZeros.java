package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 *  * <br> Problem Statement :
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * Note: You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 * </br>
 *
 * @author : Wissen Solutions.
 */
public class MoveZeros {
    @Test
    public void testHealthy() {
        int[] array = {4,2,4,0,0,3,0,5,1,0};
        Assert.assertEquals("[4,2,4,3,5,1,0,0,0,0]", moveZerosToEnd(array));
    }

    private String moveZerosToEnd(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int j = 0; /* This will be first non zero element */
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        return Arrays.toString(nums);
    }
}
