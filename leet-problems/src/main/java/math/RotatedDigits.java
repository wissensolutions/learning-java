package math;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/rotated-digits/
 * @author : Wissen Solutions.
 */
public class RotatedDigits {
    @Test
    public void testHealthy() {
        Assert.assertEquals(15, rotatedDigits(200));
    }
    public int rotatedDigits(int N) {
        int[] dp = new int[N + 1];
        int count = 0;
        for(int i = 0; i <= N; i++){
            if(i < 10){
                if(i == 0 || i == 1 || i == 8) dp[i] = 1;
                else if(i == 2 || i == 5 || i == 6 || i == 9){
                    dp[i] = 2;
                    count++;
                }
            } else {
                int a = dp[i / 10], b = dp[i % 10];
                if(a == 1 && b == 1) dp[i] = 1;
                else if(a >= 1 && b >= 1){
                    dp[i] = 2;
                    count++;
                }
            }
        }
        return count;
    }
}
