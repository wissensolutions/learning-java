package math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * math.ProductOfArrayExceptSelf
 * Learning

 * <br> Problem Statement :
 *
 * Given an array of n integers where n > 1, nums, return an array output
 * such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 *
 * For example, given [1,2,3,4], return [24,12,8,6].
 *
 * Follow up:
 * Could you solve it with constant space complexity?
 * (Note: The output array does not count as extra space
 * for the purpose of space complexity analysis.)
 *
 * </br>
 * @author WissenSolutions.
 */
public class ProductOfArrayExceptSelf {
    private static final Logger logger = LoggerFactory.getLogger(ProductOfArrayExceptSelf.class);

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productOfArrayExceptSelf(new int[]{1,2,3,4})));
    }

    /**
     * Method to calculate product of array except self
     *
     * Approach : Given numbers [1, 2, 3, 4], regarding the third number 3,
     * the product of array except 3 is 1*2*4 which consists of two parts:
     * left 1*2 and right 4. The product is left*right. We can get lefts and rights:
     * Numbers:     1    	2    3     4
     * Lefts:            	1    1*2   1*2*3
     * Rights:  	2*3*4   3*4  4
     *
     * Let’s fill the empty with 1:
     *
     * Numbers:     1    	2    3     4
     * Lefts:       1    	1    1*2   1*2*3
     * Rights:  	2*3*4   3*4  4     1
     *
     * We can calculate lefts and rights in 2 loops. The time complexity is O(n).
     * We store lefts in result array. If we allocate a new array for rights.
     * The space complexity is O(n). To make it O(1),
     * we just need to store it in a variable which is right in code.
     *
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     *
     * @param array the array of number
     * @return {@link int[]}
     */
    private static int[] productOfArrayExceptSelf(int[] array){
        int n = array.length;
        int[] resArray = new int[n];
        int left = 1;
        for(int i = 0;i<=n-1; i++){
            if(i > 0){
                left = left * array[i-1];
            }
            resArray[i] = left;
        }
        int right= 1;
        for(int i = n-1; i>=0; i--){
            if(i < n-1){
                right = right * array[i+1];
            }
            resArray[i] *= right;
        }
        return resArray;
    }

}
