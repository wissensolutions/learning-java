package dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://www.hackerrank.com/challenges/coin-change/problem
 * @author : Wissen Solutions.
 */
public class CoinChange {
    @Test
    public void testHealthy() {
        Assert.assertEquals(4,count(new int[]{8,3,1,2}, 4, 4));
        //Assert.assertEquals(5,count(new int[]{8,3,1,2}, 4, 5));
       // Assert.assertEquals(7,count(new int[]{8,3,1,2}, 4, 6));
    }

    static int count( int S[], int m, int n )
    {
        // If n is 0 then there is 1 solution
        // (do not include any coin)
        if (n == 0)
            return 1;

        // If n is less than 0 then no
        // solution exists
        if (n < 0)
            return 0;

        // If there are no coins and n
        // is greater than 0, then no
        // solution exist
        if (m <=0 && n >= 1)
            return 0;

        // count is sum of solutions (i)
        // including S[m-1] (ii) excluding S[m-1]
        return count( S, m - 1, n ) +
                count( S, m, n-S[m-1] );
    }


}
