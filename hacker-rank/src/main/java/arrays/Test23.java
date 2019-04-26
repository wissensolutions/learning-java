package arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author : Wissen Solutions.
 */
public class Test23 {
    @Test
    public void testHealthy() {
        Assert.assertFalse(checkPossibility(new int[]{3,4,2,3}));
    }

    public boolean checkPossibility(int[] nums) {
        int diffC = 0;
        for(int i=1; i< nums.length && diffC<2; i++){
            if(nums[i]-nums[i-1]<0){
                diffC++;
                if(i-2 >= 0 && nums[i]-nums[i-2]<0){
                    diffC++;
                }
            }
        }
        if(diffC > 1){
            return false;
        }
        return true;
    }

}
