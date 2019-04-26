package math;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author : Wissen Solutions.
 */
public class ReverseNumber {
    @Test
    public void testHealthy() {
        Assert.assertEquals(321, reverse(123));
        Assert.assertEquals(-321, reverse(-123));
        Assert.assertEquals(21, reverse(120));
        Assert.assertEquals(0, reverse(1534236469));
    }

    private int reverse(int x) {
        boolean isNegative = false;
        if( x < 0){
            isNegative = true;
            x = Math.abs(x);
        }
        long returnVal = 0;
        while(x > 0){

            returnVal = x % 10 + returnVal * 10  ;
            x = x/10;
        }
        if (returnVal  < Integer.MIN_VALUE || returnVal  > Integer.MAX_VALUE){
            return 0;
        }
        return (int) (isNegative ? -(returnVal): returnVal);
    }
}
