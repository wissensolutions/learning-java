package math;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author : Wissen Solutions.
 */
public class ValidateHappyNumber {
    @Test
    public void testHealthy() {
        Assert.assertTrue(isHappyNumber(19));
        Assert.assertFalse(isHappyNumber(29));
    }

    private boolean isHappyNumber(int num){
        int sum = 0;
        if(num < 10){
            return num == 1;
        }
        while(num != 0){
            sum += Math.pow(num % 10, 2);
            num  = num/10;

        }
        return isHappyNumber(sum);

    }
}
