package math;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author : Wissen Solutions.
 */
public class CountPrimeNumbers {
    @Test
    public void testHealthy() {

        Assert.assertEquals(41537,countPrimes(30));
    }

    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i] ) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }

        return count;
    }

    private boolean isInt(double d){
        return d == (int) d;
    }

}
