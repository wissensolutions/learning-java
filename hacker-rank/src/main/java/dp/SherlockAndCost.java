package dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author : Wissen Solutions.
 */
public class SherlockAndCost {
    @Test
    public void testHealthy() {
        Assert.assertEquals(36,cost(new int[]{10, 1, 10, 1 ,10}));
        Assert.assertEquals(2,cost(new int[]{1,2,3}));
        Assert.assertEquals(6,cost(new int[]{2,4,3}));
    }

//    static int cost(int[] b) {
//        int N = b.length;
//        //int[][] dp = new int[2][N];
//        int prevSum1 =0, prevSum2=0;
//        for (int j = 1; j < N; j++) {
//            prevSum1 = Math.max(prevSum2 + Math.abs(b[j] - b[j - 1]),
//                    prevSum1 + Math.abs(b[j] - 1));
//
//
//            prevSum2 = Math.max(prevSum2 + Math.abs(b[j - 1] - 1),
//                    prevSum1 + Math.abs(1 - 1));
//        }
//
//
//        return Math.max(prevSum1, prevSum2);
//
//    }

    static int cost(int[] b) {
        int N = b.length;
        int[][] dp = new int[2][N];
        for (int j = 1; j < N; j++) {
            dp[0][j] = Math.max(dp[0][j - 1] + Math.abs(b[j] - b[j - 1]),
                    dp[1][j - 1] + Math.abs(b[j] - 1));


            dp[1][j] = Math.max(dp[0][j - 1] + Math.abs(b[j - 1] - 1),
                    dp[1][j - 1] + Math.abs(1 - 1));
        }


        return Math.max(dp[0][N - 1], dp[1][N - 1]);

    }

}
