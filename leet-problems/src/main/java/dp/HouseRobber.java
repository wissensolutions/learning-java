package dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author : Wissen Solutions.
 */
public class HouseRobber {
    @Test
    public void testHealthy() {
        //Assert.assertEquals(4,rob(new int[]{1,2,3,1}));
        Assert.assertEquals(4,rob(new int[]{2,1,1,2}));
    }

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int prev1 = 0;
        int prev2 = 0;
        for (int num : nums) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = tmp;
        }
        return prev1;
    }
}
