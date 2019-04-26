package arrays;

import org.junit.Test;

/**
 * @author : Wissen Solutions.
 */
public class MajorityElement {
    @Test
    public void testHealthy() {
        majorityElement(new int[]{3,2,3});
    }

    public int majorityElement(int[] nums) {
        int[] arr = new int[Integer.MAX_VALUE];
        for(int i=0; i<nums.length; i++){
            arr[nums[i]] = arr[nums[i]]+1;
            if(arr[nums[i]] >= nums.length/2){
                return nums[i];
            }
        }
        return 0;
    }

}
