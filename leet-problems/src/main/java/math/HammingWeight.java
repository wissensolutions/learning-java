package math;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author : Wissen Solutions.
 */
public class HammingWeight {
    @Test
    public void testHealthy() {
        Assert.assertEquals(3, hammingWeight(521));
        Integer.bitCount(521);
    }

    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            int r = n & mask;
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }

}
